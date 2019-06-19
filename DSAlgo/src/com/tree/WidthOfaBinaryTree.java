package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.tree.LCAforBSTandBinaryTree.Node;

public class WidthOfaBinaryTree {
	

	public static void main(String[] args) {
		Node root = createBinaryTree();
		// System.out.println("L width "+findLWidthOfBinaryTree(root, 0));
		int w = findMaxWidthOfBinaryTree(root, 4);
		System.out.println("width "+ w);
	}

	private static int findMaxWidthOfBinaryTree(Node node, int h) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		int currLevel = 0;
		List<Integer> requiredCountInLevel = new ArrayList<>(h);
		requiredCountInLevel.add(0, 1);
		int count = 1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(requiredCountInLevel.get(currLevel) != null && requiredCountInLevel.get(currLevel) == count) {
				currLevel = currLevel + 1 ;
				count = 0;
			}
			count++;
			if(n.left != null) {
				q.add(n.left);
				int existingRequiredCountVal = requiredCountInLevel.size() > currLevel + 1 ? requiredCountInLevel.get(currLevel + 1) : 0;
				requiredCountInLevel.add(currLevel + 1, existingRequiredCountVal + 1);
			}
			if(n.right != null) {
				q.add(n.right);
				int existingRequiredCountVal = requiredCountInLevel.size() > currLevel + 1 ? requiredCountInLevel.get(currLevel + 1) : 0;
				requiredCountInLevel.add(currLevel + 1, existingRequiredCountVal + 1);
			}
			System.out.println(requiredCountInLevel);
		}
		
		return requiredCountInLevel.stream().max( (i1, i2) -> i1.compareTo(i2)).get();
	}
}
