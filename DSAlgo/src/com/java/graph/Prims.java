package com.java.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Prims {
	static boolean visited[];
	static int path[];
	static int weight[][];

	public static void main(String[] args) {
		int graphSize = 5;
		Graph gr = buildGraph2(graphSize);
		visited = new boolean[graphSize];
		path = new int[graphSize];
		for (int i = 0; i < graphSize; i++) {
			path[i] = -1;
		}
		startPrims(gr, 2);
		for(int i : path)
			System.out.print(" " + i);
	}

	private static Graph buildGraph1(int graphSize) {
		Graph gr = new Graph(graphSize);
		weight = new int[graphSize][graphSize];
		gr.addEdge(0, 1);
		weight[0][1] = 1;
		gr.addEdge(1, 2);
		weight[1][2] = 4;
		gr.addEdge(1, 3);
		weight[1][3] = 3;
		gr.addEdge(2, 3);
		weight[2][3] = 1;
		gr.addEdge(2, 4);
		weight[2][4] = 2;
		gr.addEdge(3, 4);
		weight[3][4] = 2;

		// making it non directional
		gr.addEdge(1, 0);
		weight[1][0] = 1;
		gr.addEdge(2, 1);
		weight[2][1] = 4;
		gr.addEdge(3, 1);
		weight[3][1] = 3;
		gr.addEdge(3, 2);
		weight[3][2] = 1;
		gr.addEdge(4, 2);
		weight[4][2] = 2;
		gr.addEdge(4, 3);
		weight[4][3] = 2;
		return gr;
	}
	private static Graph buildGraph2(int graphSize) {
		Graph gr = new Graph(graphSize);
		weight = new int[graphSize][graphSize];
		gr.addEdge(0, 1);
		weight[0][1] = 4;
		gr.addEdge(0, 3);
		weight[0][3] = 2;
		gr.addEdge(0, 4);
		weight[0][4] = 4;
		gr.addEdge(1, 2);
		weight[1][2] = 3;
		gr.addEdge(1, 3);
		weight[1][3] = 5;
		gr.addEdge(2, 3);
		weight[2][3] = 1;
		gr.addEdge(2, 4);
		weight[2][4] = 2;
		gr.addEdge(3, 4);
		weight[3][4] = 6;

		// making it non directional
		gr.addEdge(1, 0);
		weight[0][1] = 4;
		gr.addEdge(3, 0);
		weight[3][0] = 2;
		gr.addEdge(4, 0);


		gr.addEdge(2, 1);
		weight[2][1] = 3;
		gr.addEdge(3, 1);
		weight[3][1] = 5;
		gr.addEdge(3, 2);
		weight[3][2] = 1;
		gr.addEdge(4, 2);
		weight[4][2] = 2;
		gr.addEdge(4, 3);
		weight[4][3] = 6;
		return gr;
	}
	private static void pq(Graph gr) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(3);
		pq.add(1);
		pq.add(18);
		pq.add(15);
		pq.stream().forEach(System.out::println);
	}

	private static void startPrims(Graph gr, int node) {
		LinkedList<Integer> adj = gr.adj[node];
		PriorityQueue<Integer> nodeQ = new PriorityQueue<>();
		nodeQ.add(node);
		while (!nodeQ.isEmpty()) {
			int thisNode = nodeQ.poll();
			adj = gr.adj[thisNode];
			Integer small = 999;
			for (int n : adj) {
				if (!visited[n]) {
					if(!nodeQ.contains(n))
						nodeQ.add(n);
					// System.out.println("weight[n][thisNode] "+weight[n][thisNode]+" small "+small +" visited "+ visited[n]+" n "+n );
					if(weight[n][thisNode] < small && path[n] == -1) {
						small = weight[n][thisNode];
						path[n] = thisNode;
					}
				}
			}
			System.out.println("PQ "+nodeQ+" this node "+ thisNode+" small "+small);
			visited[thisNode] = true;
			if(path[thisNode] == -1) {
				path[thisNode] = thisNode;
			}
		}
	}

	private static void traverse(Graph gr, int node) {
		LinkedList<Integer> adj = gr.adj[node];
		PriorityQueue<Integer> nodeQ = new PriorityQueue<>();
		nodeQ.add(node);
		while (!nodeQ.isEmpty()) {
			int thisNode = nodeQ.poll();
			adj = gr.adj[thisNode];
			adj.stream().forEach(n -> {
				if (!visited[n] && !nodeQ.contains(n)) {
					nodeQ.add(n);
				}
			});
			// System.out.println("PQ "+nodeQ);
			visited[thisNode] = true;
			System.out.println(thisNode);
		}
	}
}