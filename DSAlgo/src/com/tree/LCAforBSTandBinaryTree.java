package com.tree;

public class LCAforBSTandBinaryTree {

	public static class Node {
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
		@Override
		public String toString() {
			return "Node [data=" + data + " left "+ left +" right "+ right+"]";
		}
	}
	
	public static void main(String[] args) {
		Node root = createBinaryTree();
		
		Node ans = findLCABinaryTree(root, 5, 9);
		System.out.println("resut "+ ans.data);
		
		Node root2 = createBST();
		Node ans2 = findLCABinarySearchTree(root2, 6, 9);
		System.out.println("resut BST "+ ans2.data);
	}

	public static Node createBST() {

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		
		root.right.left = new Node(6);
		root.right.right = new Node(8);
		
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		return root;
	
	}

	public static Node createBinaryTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(7);
		root.right.right = new Node(8);
		
		root.left.right.left = new Node(9);
		root.left.right.right = new Node(10);
		
		root.left.left.left = new Node(15);
		
		root.left.left.right = new Node(16);
		
		root.right.right.left = new Node(11);
		root.right.right.right = new Node(12);
		return root;
	}
	
	private static Node findLCABinaryTree(Node node, int n1, int n2) {
		if (node == null)
			return null;
		if (node.data == n1 || node.data == n2)
			return node;
		Node search_left = findLCABinaryTree(node.left, n1, n2);
		Node search_right = findLCABinaryTree(node.right, n1, n2);
		if (search_left != null && search_right != null)
			return node;
		return search_left != null ? search_left : search_right;
	}
	
	private static Node findLCABinarySearchTree(Node node, int n1, int n2) {
		if (node == null)
			return null;
		if (node.data > n1 && node.data > n2)
			return findLCABinarySearchTree(node.left, n1, n2);
		if (node.data < n1 && node.data < n2)
			return findLCABinarySearchTree(node.right, n1, n2);
		return node;
	}

}
