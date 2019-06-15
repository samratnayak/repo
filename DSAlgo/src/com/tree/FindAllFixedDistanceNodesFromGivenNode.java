package com.tree;

import static com.tree.LCAforBSTandBinaryTree.createBinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.tree.LCAforBSTandBinaryTree.Node;

public class FindAllFixedDistanceNodesFromGivenNode {

	public static void main(String[] args) {
		System.out.println("main");
		Node root = createBinaryTree();
		Queue<Node> q = new LinkedList<Node>();
		int targetLevel = 2;
		findAllNodes(root, root.left, targetLevel, q);
	}

	private static void findAllNodes(Node root, Node targetNode, int targetLevel, Queue<Node> queue) {
		int currLevel = 0;
		Set<Integer> visitedSet = new HashSet<>();
		queue.add(targetNode);
		visitedSet.add(targetNode.data);
		// key child node val, value is parent NOde refrence
		Map<Integer, Node> parentMap = new HashMap<>();
		createChildToParentsMap(root.left, root, parentMap);
		createChildToParentsMap(root.right, root, parentMap);
		
		int iterationsRequiredAtLevel[] = new int[targetLevel + 1];
		int i = 0;
		iterationsRequiredAtLevel[currLevel] = 1;
		while (!queue.isEmpty() && currLevel < targetLevel) {
			i++;
			Node curr = queue.poll();
			int itemsAdded = 0;
			itemsAdded += addElementInQueue(queue, visitedSet, curr.left);
			itemsAdded += addElementInQueue(queue, visitedSet, curr.right);
			itemsAdded += addElementInQueue(queue, visitedSet, parentMap.get(curr.data));
			
			if (currLevel < targetLevel) {
				iterationsRequiredAtLevel[currLevel + 1] = iterationsRequiredAtLevel[currLevel + 1] + itemsAdded;
			}
			if (i == iterationsRequiredAtLevel[currLevel]) {
				i = 0;
				currLevel++;
			}
		}
		while(!queue.isEmpty())
		System.out.print(queue.poll().data+" ");
	}

	private static int addElementInQueue(Queue<Node> queue, Set<Integer> visitedSet, Node newNode) {
		if (newNode != null && !visitedSet.contains(newNode.data)) {
			queue.add(newNode);
			visitedSet.add(newNode.data);
			return 1;
		}
		return 0;
	}
	private static void createChildToParentsMap(Node node, Node parentNode, Map<Integer, Node> parentMap) {
		if(node == null)
			return;
		parentMap.put(node.data, parentNode);
		createChildToParentsMap(node.left, node, parentMap);
		createChildToParentsMap(node.right, node, parentMap);
	}
	
	/*private static void createChildToParentsMap(Node node, Node parentNode, Map<Integer, Integer> parentMap) {
		if(node == null)
			return;
		parentMap.put(node.data, parentNode.data);
		createChildToParentsMap(node.left, node, parentMap);
		createChildToParentsMap(node.right, node, parentMap);
	}*/
/*	private static void createChildToParentsMapIt(Node node, Node root, Map<Integer, Integer> parentMap) {
		Node parent = root;
		while(node != null && parent != null) {
			parentMap.put(node.data, parent.data);
			if(parent.left != null) {
				parent = parent.left;
			} else {
				parent = parent.right;
			} 
			if(node.left != null) {
				node = node.left;
			} else {
				node = node.right;
			}
			parent = parent.left;
			node = node.left;
		}
	}
*/
}
