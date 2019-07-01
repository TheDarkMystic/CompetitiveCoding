/*
 Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
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
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
public class RootToLeafPathSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        
        backTrack(root, sum, res, tempList);
        
        return res;
    }
    
    public static void backTrack(TreeNode root, int sum,
    ArrayList<ArrayList<Integer>> res,ArrayList<Integer> tempList){
        
        if(root==null) return;
        
        tempList.add(root.val);
        if(root.left==null && root.right==null && root.val==sum){
            res.add(new ArrayList<Integer>(tempList));
            //return;
        }
        else{
            backTrack(root.left, sum-root.val, res, tempList);
            backTrack(root.right, sum-root.val, res, tempList);
        }
        
        tempList.remove(tempList.size()-1);
    }
}


/*
Link-
https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/
Notes-
This has been designed using 
backtracking structure

https://discuss.leetcode.com/topic/5414/dfs-with-one-linkedlist-accepted-java-solution/8

CTRL+F: xi11


Another approach using stack
https://discuss.leetcode.com/topic/13657/simple-dfs-java-solution
*/