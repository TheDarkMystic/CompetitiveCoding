/*
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.
 */
package interviewprep.Array.Bucketing;

/**
 *
 * @author jakadam
 */

import java.util.*;

public class NobleInteger {
        public int solve(ArrayList<Integer> A) {
        int len=A.size();
        int ans=-1;
        Collections.sort(A);
        
        
        for(int i=0; i<len;i++){
            
            //if A[i]==A[i+1], skip to next ele. 
            //First condition avoids AIndexOutOfBounds for testing last ele
            if(i<len-1 && A.get(i)==A.get(i+1))
                continue;
            //count the number of eles > A[i]
            if(A.get(i)==len-1-i ){
                ans=1;
                //System.out.println(A.get(i));
                break;
            }
        }
        
        return ans;
        
    }
}

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/noble-integer/

NOTES:
http://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-elements-is-equal-to-value/
*/
