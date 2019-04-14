package com.geeksforgeeks;

public class MaxDiffBetweenAncestor {

	static class Node{
		Node(int data){
			this.data = data;
		}
		int data;
		Node left;
		Node right;
	}
	/*int maxDiff(Node root)
    {
        //your code here
		
		int l = root.left != null ? findMaxDiff(root.left, root.data, root.data - root.left.data, root.left.data)
				: Integer.MIN_VALUE;
		int r = root.right != null ? findMaxDiff(root.right, root.data, root.data - root.right.data, root.right.data)
				: Integer.MIN_VALUE;
        return Math.max(l, r);
    }
    int findMaxDiff(Node node, int parentNodedata,  int maxAncDiff, int maxNodedata){
        if(node == null)
            return maxAncDiff;
        int curDiff = parentNodedata - node.data;
        int maxDiff = findMaxAmongThreeSpl(curDiff, parentNodedata, maxAncDiff, maxNodedata);
        int valToPassNext = node.data;
        if(maxAncDiff == maxDiff)
        	valToPassNext = maxNodedata;
        int l = findMaxDiff(node.left, node.data, maxDiff, valToPassNext);
        int r = findMaxDiff(node.right, node.data, maxDiff, valToPassNext);
        // return Math.abs(l) > Math.abs(r)  ? l : r;
        return l > r ? l:r;
    }*/
    int findMaxAmongThreeSpl(int curDiff, int parentNodedata, int maxAncDiff, int maxNodedata){
        int tempMax = curDiff > maxAncDiff ? curDiff : maxAncDiff;
        int third = curDiff + maxAncDiff + (maxNodedata - parentNodedata);
        return tempMax > third ? tempMax : third;
     }
    /*int findMaxAmongThreeSpl(int curDiff, int ancsDiff){
       int tempMax = Math.abs(curDiff) > Math.abs(ancsDiff) ? curDiff : ancsDiff;
       return Math.abs(tempMax) > Math.abs(curDiff + ancsDiff) ? tempMax : curDiff + ancsDiff;
    }*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Node root = new Node(5);
		
		root.left = new Node(2);
		
		root.left.left = new Node(15);
		
		root.left.left.left = new Node(9);
		root.left.left.right = new Node(16);
		root.left.left.right.left = new Node(9);
		root.left.left.right.right = new Node(17);
		
		root.left.right = new Node(3);
		
		root.right = new Node(1);
		
		root.right.left = new Node(4);
		root.right.right = new Node(9);*/
		Node root = new Node(58);
		
		root.left = new Node(6);
		
		root.left.right = new Node(45);
		
		root.left.right.left = new Node(9);
		root.left.right.left.right = new Node(1);
		
		MaxDiffBetweenAncestor ob = new MaxDiffBetweenAncestor();
		
		//System.out.println(ob.maxDiff(root));
	}

}
