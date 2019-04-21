package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import com.tree.LCAforBSTandBinaryTree.Node;

public class NearestLeafFromAGivenNode {

	static Node leafNode = null;
	static int minD = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Node root = createBinaryTree();
		Node searchNode = new Node(5);
		int dis = findNearestLeafNodeDistance(root, searchNode, 0);
		System.out.println("Nearest leaf Distance " + dis);
		findNearestLeafNode(root, searchNode, 0);
		System.out.println("Nearest leaf Distance " + minD + " node " + leafNode);
	}

	private static int findNearestLeafNodeDistance(Node node, Node searchNode, int d) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		if (searchNode == null || node.data == searchNode.data) {
			if (node.left == null && node.right == null) {
				return d;
			}
		}
		searchNode = searchNode == null ? null : node.data == searchNode.data ? null : searchNode;
		int distance = searchNode == null ? d + 1 : 0;
		int dLeft = findNearestLeafNodeDistance(node.left, searchNode, distance);
		int dRight = findNearestLeafNodeDistance(node.right, searchNode, distance);
		return Math.min(dLeft, dRight);
	}

	private static void findNearestLeafNode(Node node, Node searchNode, int d) {
		if (node == null) {
			return;
		}
		if (searchNode == null || node.data == searchNode.data) {
			if (node.left == null && node.right == null && d < minD) {
				leafNode = node;
				minD = d;
				return;
			}
		}
		searchNode = searchNode == null ? null : node.data == searchNode.data ? null : searchNode;
		int distance = searchNode == null ? d + 1 : 0;
		findNearestLeafNode(node.left, searchNode, distance);
		findNearestLeafNode(node.right, searchNode, distance);
	}

}
