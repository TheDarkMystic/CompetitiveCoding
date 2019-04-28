/*
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, 
level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the 
tree when depth of the tree is much greater than number of nodes on a level.

*/
package interviewprep.Graph;

/**
 *
 * @author jakadam
 */


import java.util.*;

// Definition for binary tree
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
 
public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        TreeNode root=A;
        //define result container and BFS queu
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue= new LinkedList<>();
        
        //add root to the queue
        queue.add(root);
        
        while(!queue.isEmpty()){
            // for each level use new list to store nodes in that level
            ArrayList<Integer>level = new ArrayList<>();
            
            //compute the size of the level
            int qsize= queue.size();
            
            for(int i=0; i<qsize; i++){
                // poll node from queue and add it to level list 
                TreeNode node=queue.poll();
                level.add(node.val);
                
                // add children of the node to queue for processing
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            //add level list to result container
            res.add(new ArrayList<Integer>(level));
        }
        
        return res;
        
        
    }
}
/*
Links-https://www.interviewbit.com/problems/level-order/
Notes-
Solution is based on zigzag order traversal of a tree fron tree package. Refer the same for detailed 
comments.
*/