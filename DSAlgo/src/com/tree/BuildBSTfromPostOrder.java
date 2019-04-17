package com.tree;

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node  
{ 
 int data; 
 Node left, right; 

 Node(int data)  
 { 
     this.data = data; 
     left = right = null; 
 } 
} 

//Class containing variable that keeps a track of overall 
//calculated postindex 
class Index  
{ 
 int postindex = 0; 
} 

class BuildBSTfromPostOrder  
{ 
 // A recursive function to construct BST from post[].  
 // postIndex is used to keep track of index in post[]. 
 Node constructTreeUtil(int post[], Index postIndex, 
         int key, int min, int max, int size)  
 { 
     // Base case 
     if (postIndex.postindex < 0) 
         return null; 

     Node root = null; 

     // If current element of post[] is in range, then 
     // only it is part of current subtree 
     if (key > min && key < max)  
     { 
         // Allocate memory for root of this subtree and decrement 
         // *postIndex 
         root = new Node(key); 
         postIndex.postindex = postIndex.postindex - 1; 

         if (postIndex.postindex > 0)  
         { 
             // All nodes which are in range {key..max} will go in  
             // right subtree, and first such node will be root of right 
             // subtree 
             root.right = constructTreeUtil(post, postIndex,  
                     post[postIndex.postindex],key, max, size); 

             // Contruct the subtree under root 
             // All nodes which are in range {min .. key} will go in left 
             // subtree, and first such node will be root of left subtree. 
             root.left = constructTreeUtil(post, postIndex,  
                     post[postIndex.postindex],min, key, size); 
         } 
     } 
     return root; 
 } 

 // The main function to construct BST from given postorder 
 // traversal. This function mainly uses constructTreeUtil() 
 Node constructTree(int post[], int size)  
 { 
     Index index = new Index(); 
     index.postindex = size - 1; 
     return constructTreeUtil(post, index, post[index.postindex], 
             Integer.MIN_VALUE, Integer.MAX_VALUE, size); 
 } 

 // A utility function to print inorder traversal of a Binary Tree 
 void printInorder(Node node)  
 { 
     if (node == null) 
         return; 
     printInorder(node.left); 
     System.out.print(node.data + " "); 
     printInorder(node.right); 
 } 

 // Driver program to test above functions 
 public static void main(String[] args)  
 { 
     BuildBSTfromPostOrder tree = new BuildBSTfromPostOrder(); 
     int post[] = new int[] {2, 6, 5, 4, 8, 11, 13, 12, 10, 7};/*{1, 7, 5, 50, 40, 10};*/ 
     int size = post.length; 

     Node root = tree.constructTree(post, size); 

     System.out.println("Inorder traversal of the constructed tree:"); 
     tree.printInorder(root); 
 } 
}