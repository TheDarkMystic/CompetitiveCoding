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
public class removeDuplicatesFromSortedArray {
     public int removeDuplicates(ArrayList<Integer> arr) {
        int len=arr.size();
        
        int wall=0;
        for(int num: arr){ // for each number in array
            if(wall<1 || arr.get(wall-1)!=num){ 
                // wall<1 cause first ele will always be unique, so make if cond. true
                // after 1st ele, if  depends completly on "arr.get(wall-1)!=num"
                //'wall-1' because we are doing wall++, so for correct comparison check previous
                // of wall
                arr.set(wall,num);
                wall++;
            }
        }
        return wall;
    }
}
        
/*
Links-https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
Notes-
Make a dry run of code.

*/
