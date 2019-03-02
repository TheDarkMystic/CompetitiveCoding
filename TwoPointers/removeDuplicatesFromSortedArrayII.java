/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.TwoPointers;

/**
 * @author jakadam
 */

import java.util.*;

public class removeDuplicatesFromSortedArrayII {
     public int removeDuplicates(ArrayList<Integer> arr) {
        //int len= arr.size();
        
        int wall=0;
        
        for(int num: arr){
            if(wall<2 || num!=arr.get(wall-2)){// || is 'short circuit or' 
                arr.set(wall, num);
                wall++;
            }
        }
        
        return wall;
    }
}
/*
Links-https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array-ii/
Notes-
Check removeDuplicatesFromSortedArray for explaination of logic
*/