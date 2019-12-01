/**
 * 
 */
package com.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author samrat
 * If root node is stored at index i, its left, and right children are stored at indices 2*i+1, 2*i+2 respectively.
 *
 */
public class ConstructTreeFromLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> ll = new LinkedList<>();
		ll.add(4);
		ll.add(9);
		ll.add(5);
		ll.add(6);
		ll.add(3);
		ll.add(12);
		ll.add(1);
		ll.add(16);
		ll.add(14);
		
		Node root = constructTree(ll);
		System.out.println(root);
	}
	
	static class Node {
		Node left;
		Node right;
		Integer data;
		Node(int data){
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [left=" + left + ", right=" + right + ", data=" + data + "]";
		}
		
	}

	private static Node constructTree(List<Integer> ll) {
		int i = 0;
		Queue<Node> q = new LinkedList<>();
		Node root = new Node(ll.get(i++));
		q.add(root);
		
		while(i < ll.size()) {
			Node temp = q.poll();
			if(i < ll.size()) {
				Node left = new Node(ll.get(i++));
				temp.left = left;
				q.add(left);
			}
			if(i < ll.size()) {
				Node right = new Node(ll.get(i++));
				temp.right = right;
				q.add(right);
			}
		}
		return root;
	}

}
