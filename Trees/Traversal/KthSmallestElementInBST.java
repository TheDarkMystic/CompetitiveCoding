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

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

import java.util.*;
public class KthSmallestElementInBST {
    public int kthsmallest(TreeNode A, int k) {
        /*
        Inorder Traversal of a BST returns elements in sorted order.
        This solution  is based on Iterative Inorder.
        */
        TreeNode p=A;
        int result=0;
        Stack<TreeNode> stack= new Stack<TreeNode>();
        while(stack.isEmpty()==false || p!=null){
            if(p!=null){
                stack.push(p);
                p=p.left;
            }
            else{
                TreeNode t= stack.pop();
                k--;
                if(k==0)
                    result= t.val;
                p=t.right;
            }
        }
        
        return result;
    }
    
}
/*
Link-
https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
Notes-

https://www.programcreek.com/2014/07/leetcode-kth-smallest-element-in-a-bst-java/

Alternative Solution Approach-
https://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
*/