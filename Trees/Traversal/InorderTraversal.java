/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */
import java.util.*;
//Definition for binary tree
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }
 

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        // Always Imagine a simple 3 node tree for any kind of tree problem.
        // Process left, root and right in required order.
        
        // List For storing Result
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        /*
        -   Recursive Solution uses System stack. For Iterative solution we need to 
            define stack explicitly.
        -   Recursive solution may cause overflow. Iterative will Not.
        -   Always ask what is the type of data store in Tree Node. int/ string etc.
        -   Notice we are storing entire TreeNode in the stack and only val in the result list.
            TreeNode has data, left and right pointers.
        */  
           
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur= A;
        
        
        /*
        -   cur!=null -> There are undiscovered Nodes in the Tree.
        -   !stack.empty() -> There exist nodes which have been discoved but not processed yet.
        */
        
        while(cur!=null || !stack.isEmpty()){
            /*
            section 1- Process left subtree. Keep pushing nodes to stack until you find 
            leftmost node.
            */
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }  
            /*section 2- Process Root Node. Print the value in this case.
            */
            cur=stack.pop();
            result.add(cur.val);
            
            /*Sction 3- Process Right Subtree*/
            cur=cur.right;
        }
        
        return result;
        
    }
}

/*
Link - https://www.interviewbit.com/problems/inorder-traversal/

Notes- 
https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable
http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/

leetcode Solution Article(3 approaches)- https://leetcode.com/articles/binary-tree-inorder-traversal/

refer tushar's video but code is wrong for code refer leetcode
https://www.youtube.com/watch?v=nzmtCFNae9k


*/