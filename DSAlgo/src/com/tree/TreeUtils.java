package com.tree;

import static com.tree.LCAforBSTandBinaryTree.Node;
import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

public class TreeUtils {

	public static void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		Node root = createBinaryTree();
		inorder(root);
	}

}
