package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;
import com.tree.LCAforBSTandBinaryTree.Node;

public class FindAllFixedDistanceNodesFromGivenNode {

	
	public static void main(String[] args) {
		System.out.println("main");
		Node root = createBinaryTree();
		int d = 3;
		findAllNodes(root, new Node(4), 3);
	}

	private static void findAllNodes(Node nodeIt, Node targetNode, int i) {
		if(nodeIt.data == targetNode.data) {
			
		}
	}

}
