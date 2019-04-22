package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.LCAforBSTandBinaryTree.Node;

public class LevelOrderTraversal {

	static Queue<Node> qu = new LinkedList<>();

	public static void main(String[] args) {
		Node root = createBinaryTree();
		qu.add(root);
		levelOrderTraversal(root);
	}

	private static void levelOrderTraversal(Node node) {
		if (qu.isEmpty())
			return;
		while (!qu.isEmpty()) {
			Node thisNode = qu.poll();
			if (thisNode != null) {
				if (thisNode.left != null)
					qu.add(thisNode.left);
				if (thisNode.right != null)
					qu.add(thisNode.right);
			}
			System.out.print(thisNode.data + " ");
		}
	}

}
