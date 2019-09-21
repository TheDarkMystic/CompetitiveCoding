/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.
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
