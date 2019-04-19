package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import com.tree.LCAforBSTandBinaryTree.Node;
public class NearestLeafFromAGivenNode {
	
	Node resNode;

	public static void main(String[] args) {
		Node root = createBinaryTree();
		Node searchNode = new Node(5);
		int dis = findNearestLeafNode(root, searchNode, 0);
		System.out.println(dis);
	}

	private static int findNearestLeafNode(Node node, Node searchNode, int d) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (searchNode == null || node.data == searchNode.data) {
			if (node.left == null && node.right == null) {
				return d;
			}
		}
		searchNode = searchNode == null ? null : node.data == searchNode.data ? null : searchNode;
		int distance =  searchNode == null ? d + 1 : 0; 
		int dLeft = findNearestLeafNode(node.left, searchNode, distance);
		int dRight = findNearestLeafNode(node.right, searchNode, distance);
		return Math.min(dLeft, dRight);
	}

}
