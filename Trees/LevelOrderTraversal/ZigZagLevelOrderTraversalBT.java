/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Trees.LevelOrderTraversal;

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


public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) { 
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        /*
        -   In java Queue, LinkedList are implemented as per DoublyLL.
        -   Doubly-linked list implementation of the List and Deque interfaces. Implements all optional list operations, and permits all elements (including null).
            All of the operations perform as could be expected for a doubly-linked list. Operations that index into the list will traverse the list from the beginning or the end, 
            whichever is closer to the specified index.(From JavaDoc)
        -   Hence addFirst() and addLast() are both O(1)
        -   res is the result arayList
        -   q is a Queue which will be used to store and process treeNodes as we
            traverse the tree
        */
        q.add(A);                   //added root to Queue to initialize the process.
        boolean zigZag=true;        //invert flag
        
        /*
        -   q.isEmpty()==false -> While there are nodes in the tree which are unprocessed
        */
        while(q.isEmpty()==false){ 
            
            // create a new LL for processing each level of tree
            LinkedList<Integer> level= new LinkedList<Integer>();
            int qSize=q.size();
            
            // Process the Level
            for(int i=0; i<qSize; i++){
                //pop the node from tree and add it to front or end acc. to zigZag
                TreeNode cur = q.poll();
                if(zigZag== true){
                    level.addLast(cur.val);
                }
                else{
                    level.addFirst(cur.val);
                }
                
                // push the children of the Node to the que for processing in next level
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
            //end of for
            
            //invert the zigZag
            zigZag=!zigZag;
            
            //add the level to result list
            res.add(new ArrayList<Integer>(level));
        }
        // end of while
        return res;
        
    }
}

/*
Link-https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/

Notes-
CTRL+F -> marcusgao 

https://discuss.leetcode.com/topic/3413/my-accepted-java-solution/13

https://www.tutorialspoint.com/java/util/linkedlist_addfirst.htm
*/