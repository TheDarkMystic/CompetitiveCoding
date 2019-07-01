/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
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
public class SumRootToLeafNum {
    public int sumNumbers(TreeNode root) {
        return sumTree(root,0)%1003;
    }
    
    public int sumTree(TreeNode node, int sum){
        
        if(node==null) return 0;
        sum=(sum*10+node.val)%1003;
        if(node.right==null && node.left==null) return sum;
        
        return sumTree(node.left, sum) +
               sumTree(node.right, sum);
    }
    
}

/*
Link-
https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
Notes-

http://www.programcreek.com/2014/05/leetcode-sum-root-to-leaf-numbers-java/

https://leetcode.com/problems/sum-root-to-leaf-numbers/#/solutions

*/