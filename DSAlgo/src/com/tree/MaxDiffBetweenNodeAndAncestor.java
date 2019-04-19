package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import com.tree.LCAforBSTandBinaryTree.Node;

public class MaxDiffBetweenNodeAndAncestor {

	static class Distance{
		int maxD;
	}
	public static void main(String[] args) {
		Node root = createBinaryTree();
		Distance d = new Distance();
		d.maxD = Integer.MIN_VALUE;
		findMaxDiff(root, d);
		System.out.println("max diff "+ d.maxD);
	}

	private static int findMaxDiff(Node node, Distance d) {
		if(node == null)
			return Integer.MAX_VALUE;
		
		int min_leftNode = findMaxDiff(node.left, d);
		int min_rightNode = findMaxDiff(node.right, d);
		int minNode = Math.min(min_leftNode, min_rightNode);
		int maxDs = Math.max(node.data - minNode , d.maxD);
		d.maxD = maxDs;
		return Math.min(node.data, minNode);
	}

}
