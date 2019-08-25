/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
