/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.TwoPointers;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class removeElement {
    //[4, 1, 1, 2, 1, 3] , 1
    //Use 2 pointers, lets call 'b' an invalid ele
    //hare  -  runs ahead to find next valid element(replacement), (it always increments)
    //tor   -  keeps the leftmost valid ele( stops whenever encounters a invalid ele)
    public int removeElement(ArrayList<Integer> a, int b)
    {
        int hare=0, tor=0;
        int len = a.size();
        
        for(hare=0; hare<len; hare++ ){
            //for each valid element found by hare, set it to tor (tor is kinda 'wall' from quicksort)
            if(a.get(hare)!=b) 
            {
                a.set(tor, a.get(hare));
                tor++;
            }
        }
        return tor;
    }
}
/*
Links-
https://www.interviewbit.com/problems/remove-element-from-array/
Notes-
http://www.programcreek.com/2014/04/leetcode-remove-element-java/

https://www.tutorialspoint.com/java/util/arraylist_set.htm

removeElement
removeDuplicateFromSortedArray
removeDuplicateFromSortedArray II 
are all the same techniques just if condition changes.


*/