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
public class MaximumConsecutiveGap {
    public int maximumGap(final List<Integer> nums) {
	    
	    int n = nums.size();
        if (n < 2) return 0;
        Collections.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < n; i += 1) {
          maxGap = Math.max(maxGap, nums.get(i) - nums.get(i - 1));
        }
        return maxGap;
    }
}

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/maximum-consecutive-gap/
NOTES:
Using collections.sort beats 99% java solutions on leetcode

https://leetcode.com/submissions/detail/106020916/
*/
