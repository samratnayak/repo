package com.tree.heap;

class Node {
	int value;
	Node left;
	Node right;
	Node parent;

	Node(int value) {
		this.value = value;
	}
}

public class MaxHeap {
	private static Node root;

	public static void main(String[] args) {
		Node node4 = new Node(4);
		Node node3 = new Node(3);
		Node node5 = new Node(5);
		
		Node node10 = new Node(10);
		
		insertInHeap(node3);
		insertInHeap(node5);
		insertInHeap(node10);
		/*insertInHeap(node4);
		
		insertInHeap(node10);
		
		
		
		
		printHeap(root);*/
	}

	private static void printHeap(Node root) {
		int h = findHeight(root), i = 0;
		System.out.println("height "+h);
		
		while(++i <= h) {
			printForHeight(root, i);
			System.out.println("");
		}
	}

	private static void printForHeight(Node root, int h) {
		if(root == null)
			return;
		if(h == 1) {
			System.out.print(root.value+" ");
		}
		else {
			printForHeight(root.left, h - 1);
			printForHeight(root.right, h - 1);
		}
	}

	private static int findHeight(Node root) {
		if(root == null) {
			return 0;
		}
		int lheight = findHeight(root.left) + 1;
		int rheight = findHeight(root.right) + 1;
		return lheight > rheight ? lheight : rheight;
	}

	private static void insertInHeap(Node node) {
		if (root == null) {
			root = node;
			root.parent = null;
			return;
		}
		Node endNode = findEndNode(root);
		System.out.println("endNode "+endNode.value);
		boolean isRight = false;
		if(endNode.left == null) {
			endNode.left = node;
			node.parent = endNode;
		}
		else if(endNode.right == null) {
			endNode.right = node;
			node.parent = endNode;
			isRight = true;
		}
		System.out.println(" isRight "+isRight);
		checkParent(node.parent, node, isRight);
		printHeap(root);
	}

	private static void checkParent(Node parent, Node node, boolean isRight) {
		
		if(parent == null) {
			return;
		}
		
		else if(parent.value < node.value && parent == root) {
			// 
			System.out.println("1. Parent Node val "+ parent.value+" Node val "+node.value);
			Node temp = new Node(root.value);
			if(isRight)
				node.right = temp;
			else 
				node.left = temp;
			root = node;
		}
		else if(parent.value < node.value) {
			// System.out.println("2. Parent Node val "+ parent.value+" Node val "+node.value+" ");
			Node temp = new Node(parent.value);
			if(isRight)
				node.right = temp;
			else 
				node.left = temp;
			parent = node;
		}
		checkParent(parent.parent, node.parent,  isRight);
	}

	private static Node findEndNode(Node root) {
		if (root != null && root.left == null && root.right == null || (root != null && root.left != null && root.right == null)
				|| (root != null && root.left==null && root.right != null)) {
			return root;
		}
		else {
			return findEndNode(root.right);
		}
	}

}
