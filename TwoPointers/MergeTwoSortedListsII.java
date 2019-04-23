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
public class MergeTwoSortedListsII {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int aIndex = 0;
        int bIndex = 0;
        //When we inserted all the items from 'b' into 'a' there is no need
        //to continue iteration
        while (bIndex < b.size()) {
            //Find an element in 'a' which is greater than the current
            //element in 'b'
            while (aIndex < a.size() && a.get(aIndex) <= b.get(bIndex)) {
                aIndex++;
            }
            //Insert the element in 'b' before the element we found
            a.add(aIndex, b.get(bIndex));
            //Move to the next element in b
            bIndex++;
        }
    }
}

/*
Link-https://www.interviewbit.com/problems/merge-two-sorted-lists-ii/
Notes-
https://leetcode.com/submissions/detail/106446693/
*/
