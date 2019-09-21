/*
Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

Using recursion is not allowed.
 */
package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */
    
import java.util.*;

public class PreOrderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        /*
         Always Imagine a simple 3 node tree for any kind of tree problem.
         Process left, root and right in required order.
        */
        
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
        
        //TreeNode cur= A;
        stack.add(A);
        
        
        while(stack.isEmpty()!=false){
             /*
            section 1- Process root .
            */
            TreeNode cur = stack.pop();
            result.add(cur.val);
            
            /* section 2- Process Right Subtree. We are pushing right node before left node because 
               Stack is LIFO so while popping we will get left first and will be printed first. 
            */
            if(cur.right!=null){
                stack.add(cur.right);
            }
            /* section 2- Process Left Subtree.*/
            
            if(cur.left!=null){
                stack.add(cur.left);
            }
            
            
        }
        
        return result;
        
        
    }
}

/*
Link - 
    https://www.interviewbit.com/problems/preorder-traversal/

Notes- 
https://www.youtube.com/watch?v=elQcrJrfObg

https://leetcode.com/problems/binary-tree-postorder-traversal/#/solutions

https://discuss.leetcode.com/topic/6478/iterative-solution-in-java-simple-and-readable


*/