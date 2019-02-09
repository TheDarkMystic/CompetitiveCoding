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
    public int maxSubArray(final List<Integer> a) {
	    Integer[] A= a.stream().toArray(Integer[]::new);
	    int max_cur = 0;
	    int max_global = Integer.MIN_VALUE;
	    int size= A.length;
	    
	    for(int i=0; i<size; i++){
	        
	        max_cur= max_cur+A[i];
	        if(max_cur>max_global)
	            max_global=max_cur;
	        if(max_cur<0)
	            max_cur=0;
	    }
	    
	    return max_global;
	}
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
NOTES:
Asked in a lot of companies
https://www.youtube.com/watch?v=kekmCQXYwQ0
*/


