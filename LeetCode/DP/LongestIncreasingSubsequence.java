/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.LeetCode.DP;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class LongestIncreasingSubsequence {
        public int lis(final List<Integer> A) {
        //converted the list to array for easier understanding of operations
        int len=A.size();
        int maxLISLength=1;
        Integer[] arr= A.toArray(new Integer[len]);
        
        // for empty array, longest subsequence has length 0.
        if(len==0)
            return 0;
        
        /*
            Construct DP array
            the maxLength[i] stores the length of longest increasing subsequence till arr[i]
            Fill the array with initially. That's the base case because every element in itself is longest inc. subsequence
        */
        int[] maxLength= new int[len]; 
        Arrays.fill(maxLength,1);
        
        
        // now we 2 indices i and j. For each index i, we iterate through the all the previous elements of using j (j=0 to j<i)
        // and we check if we can extend the LIS till j using element at a[i] and accordingly update LIS length in DP array.
        
        
        for(int i=0; i<len; i++){
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j])
                    maxLength[i]= Math.max(maxLength[i], maxLength[j]+1);
            }
            
            //after completing iteration for each i, if we have found new longest Subsequence
            maxLISLength=Math.max(maxLISLength,maxLength[i] );
 
        }
        
        
        return maxLISLength;
        /*
        For Longest nonDecreasing SS -> if(a[i]>=a[j])
        for Longest decreasing SS    -> if(a[i]<a[j])
        */
        
    }
}

/*
Link-
https://www.interviewbit.com/problems/longest-increasing-subsequence/

Notes-
https://www.youtube.com/watch?v=fV-TF4OvZpk&list=PLiQ766zSC5jM2OKVr8sooOuGgZkvnOCTI&index=17
https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming,%20Recursion,%20&%20Backtracking/longestIncreasingSubsequence.java
*/