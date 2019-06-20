package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.tree.LCAforBSTandBinaryTree.Node;

public class WidthOfaBinaryTree {
	

	public static void main(String[] args) {
		Node root = createBinaryTree();
		// System.out.println("L width "+findLWidthOfBinaryTree(root, 0));
		int w = findMaxWidthOfBinaryTree(root, 4);
		System.out.println("max width "+ w);
	}

	private static int findMaxWidthOfBinaryTree(Node node, int h) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		int count = 1;
		int currLevel = 0;
		int[] requiredCountInLevel = new int[h];
		requiredCountInLevel[0] = 1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.left != null) {
				q.add(n.left);
				requiredCountInLevel[currLevel + 1] = requiredCountInLevel[currLevel + 1] + 1 ;
			}
			if(n.right != null) {
				q.add(n.right);
				requiredCountInLevel[currLevel + 1] = requiredCountInLevel[currLevel + 1] + 1 ;
			}
			if(requiredCountInLevel[currLevel] == count) {
				currLevel = currLevel + 1;
				count = 0;
			}
			count++;
			//System.out.println(Arrays.toString(requiredCountInLevel));
		}
		return Arrays.stream(requiredCountInLevel).max().getAsInt();
	}
}
