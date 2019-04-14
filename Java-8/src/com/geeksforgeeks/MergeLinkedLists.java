package com.geeksforgeeks;

public class MergeLinkedLists {
	static class Node {
		int value;
		Node next;
		Node(int val) {
			value = val;
		}
	} 

	public static void main(String[] args) {
		Node list1 = new Node(6);
		list1.next = new Node(10);
		list1.next.next = new Node(15);
		list1.next.next.next = new Node(17);
		/*list1.next.next.next.next= new Node(20);
		list1.next.next.next.next.next= new Node(22);*/
		
		Node list2 = new Node(4);
		list2.next= new Node(7);
		list2.next.next= new Node(12);
		list2.next.next.next= new Node(20);
		list2.next.next.next.next= new Node(22);
		
		/*//Node resAsc = mergeTwoListsInAsc(list1 , list2);
		// printLL(resAsc);
		Node resNode = 	null;
		mergeTwoListsInDesc1(list1 , list2, null, null);
		System.out.println("returned");
		printLL(resNode);
		//printLL(list1);
		//printLL(list2);
*/		
		Node resNode = mergeLists(list1, list2);
		printLL(resNode);
		
	}
	private static Node mergeLists(Node list1, Node list2) {
		Node res = null;
		
		while(list1 != null && list2 != null) {
		if(list1.value < list2.value) {
			Node temp = list1.next;
			list1.next = res;
			res = list1;
			list1 = temp;
		}
		else {
			Node temp = list2.next;
			list2.next = res;
			res = list2;
			list2 = temp;
		}
		}
		while(list1 != null) {
			Node temp = list1.next;
			list1.next = res;
			res = list1;
			list1 = temp;
		}
		while(list2 != null) {
			Node temp = list2.next;
			list2.next = res;
			res = list2;
			list2 = temp;
		}
		return res;
	}
	static Node res = null;
	private static Node mergeTwoListsInDesc1(Node node1, Node node2, Node resultRoot, Node res) {
		Node resIt = null;
		if(node1.next != null) {
			resIt =  mergeTwoListsInDesc1(node1.next, null, resultRoot, resIt);
		}
		if(node1.next == null) {
			res = node1;
			return res;
		}
		resIt.next = node1;
		return res;
	}

	private static void mergeTwoListsInDesc(Node node1, Node node2, Node resultRoot, Node resIt) {/*
		if(node1.next != null && node2.next != null) {
			mergeTwoListsInDesc(node1.next, node2.next, resultRoot, resIt);
		}
		else if (node1.next == null && node2.next == null) {
			if(node2.value > node1.value) {
				assignGreaterNode(resultRoot, resIt, node2);
				//node2 = node2.next;
			} else {
				assignGreaterNode(resultRoot, resIt, node1);
				// node1 = node1.next;
			}
			//mergeTwoListsInDesc(node1.next, node2.next, resultRoot, resIt);
			return;
		}
		else if (node1.next != null) {
			mergeTwoListsInDesc(node1.next, node2, resultRoot, resIt);
		}
		else
			mergeTwoListsInDesc(node1, node2.next, resultRoot, resIt);
			 
		while(node1 != null && node2 != null ){
			if(node1.value > node2.value) {
				if(resultRoot == null) {
					resultRoot = node1;// new Node(node1.value);//node1;//
					resIt = resultRoot;
				} else {
					resIt.next = node1;
					resIt = resIt.next;
					}
				node1 = node1.next;
			} else {
				if(resultRoot == null) {
					resultRoot = node2;// node2;//new Node(node2.value);
					resIt = resultRoot;
				} else {
					resIt.next = node2;
					resIt = resIt.next;
				}
				node2 = node2.next;
			}
		}
		while(node1 != null) {
			resIt.next = node1;
			resIt = resIt.next;
			node1 = node1.next;
		}
		while(node2 != null) {
			resIt.next = node2;
			resIt = resIt.next;
			node2 = node2.next;
		}
		
		return resultRoot;
	
	*/}

	private static void assignGreaterNode(Node resultRoot, Node resIt, Node nodeFound) {
		if(resultRoot == null) {
			resultRoot = nodeFound;
			resIt = resultRoot;
		}
	}

	private static void printLL(Node resAsc) {
		while(resAsc != null) {
			System.out.print(resAsc.value +" ");
			resAsc = resAsc.next;
		}
		System.out.println("");
	}

	private static Node mergeTwoListsInAsc(Node node1, Node node2) {
		Node resultRoot = null, resIt = null;
		while (node1 != null && node2 != null) {
			if (node1.value < node2.value) {
				if (resultRoot == null) {
					resultRoot = node1;// new Node(node1.value);//node1;//
					resIt = resultRoot;
				} else {
					resIt.next = node1;
					resIt = resIt.next;
				}
				node1 = node1.next;
			} else {
				if (resultRoot == null) {
					resultRoot = node2;// node2;//new Node(node2.value);
					resIt = resultRoot;
				} else {
					resIt.next = node2;
					resIt = resIt.next;
				}
				node2 = node2.next;
			}
		}
		while (node1 != null) {
			resIt.next = node1;
			resIt = resIt.next;
			node1 = node1.next;
		}
		while (node2 != null) {
			resIt.next = node2;
			resIt = resIt.next;
			node2 = node2.next;
		}

		return resultRoot;
	}

}
