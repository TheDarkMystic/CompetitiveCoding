/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Graph;

/**
 *
 * @author jakadam
 */


import java.util.*;
 //Definition for undirected graph.
 class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };


public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root == null) return null;
    
    // use a queue to help BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(root);
        
        // use a map to save cloned nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        // clone the root
        map.put(root, new UndirectedGraphNode(root.label));
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            
            // handle the neighbors
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // clone the neighbor
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    // add it to the next level
                    queue.add(neighbor);
                }
              
                // copy the neighbor
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(root);
    }
}