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
public class diffK {
    
    
    public int diffPossible(ArrayList<Integer> a, int target) {
        int len=a.size();
        /*
        A : [ 1, 2, 2, 3, 4 ]
        B : 0
        */
        int left=0;
        int right=1;
        
        while(left<len && right<len){
            int diff=a.get(right) - a.get(left);
            if(diff==target && left!=right){
                return 1;
            }
            
            if(diff>target)  left++ ;
            if(diff<=target)  right++;
                 
        }
        
        return 0;
        
    }

}


/*
Links-https://www.interviewbit.com/problems/diffk/

Notes-
https://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/

nested loops -O(n^2)
2 pointers approach -O(n)
Using BinarySearch -O(nLogn)

*/
