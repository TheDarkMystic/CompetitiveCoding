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

public class ThreeSum {
       public int threeSumClosest(ArrayList<Integer> a, int targetSum) {
       
       Collections.sort(a);
       int len= a.size();
       int diff=Integer.MAX_VALUE;
       int ans=0;
       
       for(int i=0 ;i<len-2;i++){
           
           int left=i+1;
           int right=len-1;
           
           while(left<right){
                int curSum= a.get(i)+a.get(left)+a.get(right);
               
                if(curSum==targetSum)
                    return curSum;
                
                if(Math.abs(curSum-targetSum)<diff){
                    diff=Math.abs(curSum-targetSum);
                    ans=curSum;
                }
                
                if(curSum<targetSum)
                    left++;
                if(curSum>targetSum)
                    right--;
           }
       }
       return ans;
    }
}


/*
Links-
https://www.interviewbit.com/problems/3-sum/
Notes-
http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/

*/