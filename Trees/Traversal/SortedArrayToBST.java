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
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        
        int len = a.size();
        if(len==0 || a==null)
            return null;
        return sortedArrayToBST(a, 0, len-1);
         
    }
    
    public TreeNode sortedArrayToBST(final List<Integer> a, int start, int end){
        if(start>end)
            return null;
        
        int mid=(start+end)/2;

        TreeNode root=new TreeNode(a.get(mid));
        root.left=sortedArrayToBST(a, start, mid-1);
        root.right=sortedArrayToBST(a,mid+1,end);
        return root;
            
        
    }
    
    
}


/*
Link-
https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/

Notes-

https://www.programcreek.com/2013/01/leetcode-convert-sorted-array-to-binary-search-tree-java/
https://www.youtube.com/watch?v=VCTP81Ij-EM
A BST is balanced if abs.diff(ht_of_left_subtree - ht_of_right_subtree)=1
and above property holds for each node of the tree
*/