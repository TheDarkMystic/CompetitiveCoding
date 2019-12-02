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
        /*
        1. Sort the Array arr[] in ascending order. This step takes (O(nlogn)).
        2. Iterate through the array. Compare the value of index i to the number of elements 
        after index i. If arr[i] equals the number of elements after arr[i], it is a noble 
        Integer. Condition to check: (A[i] == length-i-1). This step takes O(n).
        Note: Array may have duplicate elements. So, we should skip the elements 
        (adjacent elements in the sorted array) that are same.
         */
        int len = A.size();
        int ans = -1;
        Collections.sort(A);

        // Return a Noble element if present 
        // before last. 
        for (int i = 0; i < len - 1; i++) {
            if (A.get(i) == A.get(i + 1)) {
                continue;
            }
            // In case of duplicates, we 
            // reach last occurrence here. 
            if (A.get(i) == len - i - 1) {
                return 1;
            }
        }

        if (A.get(len - 1) == 0) {
            return 1;
        }
        return -1;
    }
}

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/noble-integer/

NOTES:
http://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-elements-is-equal-to-value/
 */
