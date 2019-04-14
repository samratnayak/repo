package com.java.graph;

import java.util.Arrays;

public class Dijkshtra {
	static String[] s;
	static boolean[] visited;
	static Graph gr = new Graph(5);
	static int[] path = new int[5];
	static int[] weightMatrix = new int[5];
	public static void main(String [] rgs) {
		
		s = new String[5];
		// = new String[5];
		gr.addEdge(2, 4, 2);
		gr.addEdge(2, 3, 1);
		gr.addEdge(1, 2, 4);
		gr.addEdge(0, 1, 1);
		gr.addEdge(1, 3, 3);
		gr.addEdge(3, 4, 2);
		// gr.addEdge(1, 2, 1);
		visited = new boolean[5];
		for(int p=0; p < weightMatrix.length ; p++) {
			weightMatrix[p] = 999;
		}
		for(int p=0; p < path.length ; p++) {
			path[p] = -1;
		}
		//for(int i=0; i< 5; i++)
		weightMatrix[0] = 0;
		for(int i=0; i< 5; i++)
			shortestPathUtil(i);
		System.out.println("Path");
		Arrays.stream(path)
		.forEach(System.out :: println);
		System.out.println("Weight");
		Arrays.stream(weightMatrix).forEach(System.out :: println);
	}
	
	private static void shortestPathUtil(int thisNode) {
		for(int index = 0; index < gr.adj[thisNode].size(); index++) {
			int adjNode = gr.adj[thisNode].get(index);
			System.out.println("adjNode "+adjNode);
			// int wayNode = path[adjNode];
			int prevWeight = weightMatrix[adjNode];
			int currWeight = weightMatrix[thisNode] + gr.weight[thisNode].get(index);
			System.out.println("prevWeight "+prevWeight+" currWeight "+currWeight);
			if(prevWeight > currWeight ) {
				path[adjNode] = thisNode;
				weightMatrix[adjNode] = currWeight;
			}
		}
	}
}
