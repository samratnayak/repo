package com.java.graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologySortUtil {
	static int [] indegree;
	public static void main(String[] args) {
		boolean[] visited = new boolean[5];
		Stack<Integer> st = new Stack<Integer>();
		Graph gr = new Graph(5);
		indegree = new int[5];
		gr.addEdge(3, 4);
		indegree[4] += 1; 
		gr.addEdge(3, 0);
		indegree[0] += 1;
		gr.addEdge(0, 4);
		indegree[4] += 1;
		gr.addEdge(4, 1);
		indegree[1] += 1;
		gr.addEdge(2, 1);
		indegree[1] += 1;
		// add all edge as unvisted
		for (int i = 0; i < 5; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < 5; i++) {
			if(!visited[i])
			topologySort(gr, i, visited, st);
		}
		for (int i = 0; i < 5; i++) {
			visited[i] = false;
		}
		System.out.println("");
		//topologySort(gr,4, visited, st);
		for(int i=0; i< 5; i++) {
			//System.out.print(" "+st.pop());
		}
	}

	private static void topologySort(Graph gr, int v, boolean[] visited, Stack<Integer> st) {
		Iterator<Integer> it = gr.adj[v].iterator();
		visited[v] = true;
		if(indegree[v]-- == 0) {
			System.out.print(" "+v);
		}
		
		while(it.hasNext()) {
			int vertex = it.next();
			if(!visited[vertex] || indegree[vertex] >=0)
			topologySort(gr, vertex , visited, st);
		}
	}
}
