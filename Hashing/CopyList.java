
/**
 * A linked list is given such that each node contains an additional random pointer which could point 
 * to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as 
* the original list, but a copy of them. The pointers in the returned list should not link to any node 
* in the original input list.
*/
package interviewprep.Hashing;

/**
 *
 * @author jakadam
 */




class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class CopyList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p= head;
        //Step 1: Create a copy node for each original node
        while(p!=null){
            RandomListNode copy= new RandomListNode(p.label);
            copy.next=p.next;
            p.next=copy;
            p=copy.next;
        }
        
        //Step 2: Copy random pointers for every copy node
        p=head;
        while(p!=null){
            if(p.random!=null)
                p.next.random=p.random.next;
            p=p.next.next;
        }
        //Step 3: Sperate out the original list and copy list
        RandomListNode oldHead=head;
        RandomListNode newHead=head.next;
        RandomListNode result=newHead;
        
        while(oldHead!=null){
            oldHead.next=oldHead.next.next;
            oldHead=oldHead.next;
            
            if(oldHead!=null){
                newHead.next=newHead.next.next;
                newHead=newHead.next;
            }
        }
        
        return result;
    }
}



/*
HashMap Based Working Solution

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode list1 = head;
        Map<RandomListNode, RandomListNode> copyMap = new HashMap<>();
        while (list1 != null) {
            RandomListNode node = new RandomListNode(list1.label);
            copyMap.put(list1, node);
            list1 = list1.next;
        }
        // heart of the code.
        for (RandomListNode node : copyMap.keySet()) {
            RandomListNode copy = copyMap.get(node);
            copy.next = copyMap.get(node.next);
            copy.random = copyMap.get(node.random);
            // copyMap.put(node, copy);
        }
        return copyMap.get(head);
    }
}






*/



/*
Link-
https://www.interviewbit.com/problems/copy-list/
Notes-
2 solutions exist

1-  pointer manipulation
2-  hashmap

https://leetcode.com/problems/copy-list-with-random-pointer/#/solutions

http://www.programcreek.com/2012/12/leetcode-copy-list-with-random-pointer/

https://www.youtube.com/watch?v=-ExVoZXedo4
*/