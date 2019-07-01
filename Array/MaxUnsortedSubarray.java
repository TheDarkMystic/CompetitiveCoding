/*
 * 
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */


import java.util.*;
public class MaxUnsortedSubarray {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        
        ArrayList<Integer> ans= new ArrayList<Integer>();
        int len=A.size();
        //find the already sorted part starting from left of the array
        int i=0;
        while(i<len-1 && A.get(i)<=A.get(i+1))
            i++;
        
        // if array is already is already sorted
        if(i==len-1){
            ans.add(-1);
            return ans;
        }
        
        //find the already sorted part starting from end of the array
        int j=len-1;
        while(j>0 && A.get(j)>=A.get(j-1))
            j--;
            
        //find the min and max in the unsorted part of array
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        
        for(int k=i; k<=j; k++){
            min=Math.min(min, A.get(k));
            max=Math.max(max, A.get(k));
        }

        // find the correct locations of min and max in sorted parts of the array
        int left=0;
        while(A.get(left)<=min && left<=i)
            left++;
            
        int right=len-1;
        while(A.get(right)>=max && right>=j)
            right--;
        
        //copy the subarray in the answer
        ans.add(left);
        ans.add(right);
                
        return ans;
    }
}

/*
Link-
https://www.interviewbit.com/problems/maximum-unsorted-subarray/
Notes-
comments explain the algo.
reference video(optional)-
https://www.youtube.com/watch?v=Hg03KTli9co

https://leetcode.com/articles/shortest-unsorted-continous-subarray/

*/