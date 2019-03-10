/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
*/


package interviewprep.Trees.Traversal;

/**
 *
 * @author jakadam
 */
public class LowestCommonAncestor {
     public int lca(TreeNode root, int n1, int n2) {
        // There is a possiblity that both nodes are not present in the tree
        // Make sure both node exist by doing a DFS for each node
        // instead of calling DFS 2 times, you can populate nodelist and one call and check 
        // the list for both nodes
        
        boolean n1Exists=DFS(root, n1);
        boolean n2Exists=DFS(root, n2);
        
        if(n1Exists && n2Exists){
             
            TreeNode node=LCA(root, n1, n2);
            if(node==null)
                return -1;
            else
                return node.val;
        }
        else// nodes not present in the tree
            return -1;
        
       
        
    }
    
    
    // DFS function to find if node exixts int the tree (GFG)
    public boolean DFS(TreeNode node, int key){
        if(node==null)
            return false;
        if(node.val==key)
            return true;
        
        boolean left=DFS(node.left,key);
        boolean right=DFS(node.right,key);
        
        return (left||right);
        
        
    }
    
    
    // main LCA ago( Tushar)
    public TreeNode LCA(TreeNode root, int n1, int n2) {
        
        if(root == null)
            return null;
        
        // if the root itself is one of the nodes, return root    
        if(root.val==n1 || root.val==n2)
            return root;
        
        // else search for nodes in left and right subtrees
        TreeNode node1= LCA(root.left, n1, n2);
        TreeNode node2= LCA(root.right, n1, n2);
        
        
        // if booth subtrees return null, nodes doesnt exist in this part of tree, return null
        if(node1==null && node2==null)
            return null;
        
        // if both  the subtrees return non-null, the root is parent for bothe nodes and hence LCA
        if(node1!=null && node2!=null)
            return root;
        
        
        // if one subtree returns null and other returns non-null, return the non-null node as it can the LCA or
        
        return node1!=null? node1:node2;
            
    }
}

/*
Links-https://www.interviewbit.com/problems/least-common-ancestor/
Notes-

"No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1."

This is a tricky case.


Best Explainations
LCA-https://www.youtube.com/watch?v=13m9ZCB8gjw

DFS-https://www.geeksforgeeks.org/search-a-node-in-binary-tree/


*/