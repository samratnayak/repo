package com.java.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	int V; //total vertices
	LinkedList<Integer> adj[] ;
	LinkedList<Integer> weight[];
	Graph(int v){
		V = v;
		adj = new LinkedList[v];
		weight = new LinkedList[v];
		for(int i=0; i< v; i++) {
			adj[i] = new LinkedList<>();
			weight[i] = new LinkedList<>();
		} 
	}
	private int largestElmt(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int a : arr) {
			if(a > max)
				max = a;
		}
		return max;
	}
	public void addEdge(int v, int v2) {
		adj[v].add(v2);
	}
	public void addEdge(int v, int v2, int w) {
		adj[v].add(v2);
		weight[v].add(w);
	}
	/*public void addweight(int v, int v2) {
		weight[v].add(v2);
	}*/
	public void DFS(boolean [] visited, int startV) {
		Iterator<Integer> it = adj[startV].listIterator();
		visited[startV] = true;
		while(it.hasNext()) {
			int val = it.next();
			if(!visited[val])
				DFS(visited, val);
		}
		System.out.println(startV);
	}
	public void DFSUtilt(int startV) {
		boolean [] visited = new boolean[4];
		DFS(visited, startV);
	}

	public static void main(String[] args) {
		int [] vertices = {0,1,2,3};
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.DFS(new boolean[4],2);
	}
}
