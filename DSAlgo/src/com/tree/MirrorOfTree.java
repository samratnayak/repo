package com.tree;

import static com.tree.LCAforBSTandBinaryTree.Node;
import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

public class MirrorOfTree {

	public static void main(String[] args) {
		Node root = createBinaryTree();
		System.out.println("Before..");
		TreeUtils.inorder(root);
		Node rootMirror = convertMirror(root);
		System.out.println("\nafter..");
		TreeUtils.inorder(rootMirror);
		System.out.println("");
		boolean isMirror = checkMirror(rootMirror, createBinaryTree());
		System.out.println("isMirror tree "+isMirror);
	}

	private static Node convertMirror(Node node) {
		if(node == null)
			return null;
		Node nodeLeft = convertMirror(node.left);
		Node nodeRight = convertMirror(node.right);
		if(nodeLeft != null || nodeRight != null) {
			Node temp = node.left;
			node.left = nodeRight;
			node.right = temp;
		}
		return node;
	}
	
	private static boolean checkMirror(Node node1, Node node2) {
		if((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
			return false;
		}
		else if(node1 == null && node2 == null) {
			return true;
		}
		else if(node1.data != node2.data) {
			return false;
		}
			
		boolean checkMirror1 = checkMirror(node1.left, node2.right);
		boolean checkMirror2 = checkMirror(node1.right, node2.left);
		
		return checkMirror1 && checkMirror2;
	}

}
