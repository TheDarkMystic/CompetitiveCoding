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
public class PostOrderTraversal {
     public ArrayList<Integer> postorderTraversal(TreeNode A) {
        
        //with 2 stacks
        ArrayList<Integer> res= new ArrayList<>();
        
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        TreeNode root= A;
        
        s1.push(root);
        
        while(!s1.isEmpty()){
            //pop a node from s1
            root=s1.pop();
               
            // push node.left to s1  
            if(root.left!=null)
                s1.push(root.left);
            //push node.right to s2
            if(root.right!=null)
                s1.push(root.right);
            
            // now, push visited node to s2,    
            s2.push(root); 
                
        }
        
        TreeNode node=null;
        while(!s2.isEmpty()){
            node=s2.pop();
            res.add(node.val);
        }
        
        return res;
         
    }
     
     
     //with recursion
     /*
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        
        ArrayList<Integer> res= new ArrayList<Integer>();
        postOrder(A, res);
        return res;
         
    }
    
    
    public void postOrder(TreeNode root, ArrayList<Integer>res){
        if(root==null)
            return;
        
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
        
    }
      */
    
    // with 1 stack
     /*
    public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
    }
     */
    
}


/*
Link-
https://www.interviewbit.com/problems/postorder-traversal/

Notes-
https://www.youtube.com/watch?v=xLQKdq0Ffjg&t=3s
https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45551/Preorder-Inorder-and-Postorder-Iteratively-Summarization
https://www.youtube.com/watch?v=qT65HltK2uE
*/
