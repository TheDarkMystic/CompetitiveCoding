/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Given a binary tree, invert the binary tree and return it. 
Look at the example for more details.

Example : 
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4
*/

package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class InvertBinaryTree {
 
 /*
    //Working Recursive DFS Solution
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
            return null;
        
        // create copies of address of left and right subtrees
        TreeNode tempLeft=root.left;
        TreeNode tempRight=root.right;
        
        // swap the subtree pointers
        root.left=invertTree(tempRight);
        root.right=invertTree(tempLeft);
        
        //return node with swapped pointers
        return root;
        
    }
    */
    
    //Above solution is recursive & hence bound to call stack, we will come across a problem size which will blow up
    // the stack. Hence Alterantive Iterative BFS solution
    
    public TreeNode invertTree(TreeNode root){
        if(root==null)
            return null;
        
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        
        queue.add(root);
        
        while(queue.isEmpty()==false){
            // pop the node
            TreeNode node= queue.poll();
            // swap left and right pointers
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            
            
            // add left child to queue
            if(node.left!=null)
                queue.add(node.left);
                
            // add right child to queue
            if(node.right!=null)
                queue.add(node.right);
            
        }
        
        return root;
    }
    
    
}

/*
Links-https://www.interviewbit.com/problems/invert-the-binary-tree/
Notes-
https://discuss.leetcode.com/topic/16039/straightforward-dfs-recursive-iterative-bfs-solutions/2


*/