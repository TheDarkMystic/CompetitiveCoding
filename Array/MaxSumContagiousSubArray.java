/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.
*/





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.ArrayMath;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class MaxSumContagiousSubArray {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int lenA=A.size();
        
        /*
        Handle corner cases where is array has size 1 or 2
        */
        if(lenA==0)
            return A.get(0);
        else if(lenA==2)
            // return max of 2 numbers
            return Math.max(A.get(0), A.get(1));
        
        
        /*
        At every given position, you have 2 choices to make.
            1. Include the num in the running sum
            2. start a new runnningSum(Array) from that position
            
            if adding the current num to running sum gives you bigger runningSum choose 1.
            else start a new runningSum from that position
            
            keep tracking the maximum sum found till this point
        */
        int runningSum=A.get(0);
        int maxSum=A.get(0);
        
        for(int i=1; i<lenA; i++){
            if((A.get(i)+runningSum)>A.get(i))
                runningSum+=A.get(i);
            else 
                runningSum=A.get(i);
            maxSum=Math.max(maxSum, runningSum);
        }
        
        
        return maxSum;
        
    }
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
NOTES:
Asked in a lot of companies
https://www.youtube.com/watch?v=kekmCQXYwQ0
*/


