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
public class ArrayThreePointers {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
    
        int lenA=A.size();
        int lenB=B.size();
        int lenC=C.size();
        
        int resA=0,resB=0,resC=0;
        
        int i=0,j=0,k=0,diff=Integer.MAX_VALUE;
        
        while(i<lenA && j<lenB && k<lenC){
            // Find minimum and maximum of current three elements 
            int min=Math.min(A.get(i), Math.min(B.get(j),C.get(k)));
            int max=Math.max(A.get(i), Math.max(B.get(j),C.get(k)));
            
            // Update result if current diff is  
            // less than the min diff so far
            if(diff>max-min){
                diff=max-min;
                resA=i;
                resB=j;
                resC=k;
            }
            
            // We can't get less than 0  
            // as values are absolute 
            if(diff==0) break;
            
            // Increment index of array 
            // with smallest value 
            if(A.get(i)==min)        i++;
            else if(B.get(j)==min)   j++;
            else                    k++;
            
        }
        
        return diff;
        
    }
}


/*
Links-

https://www.interviewbit.com/problems/array-3-pointers/
Notes-

https://www.geeksforgeeks.org/find-three-closest-elements-from-given-three-sorted-arrays/

*/