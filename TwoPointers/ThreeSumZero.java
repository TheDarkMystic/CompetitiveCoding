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
public class ThreeSumZero {
    
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        int len=a.size();
        ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
        //for non-decreasing ans
        Collections.sort(a);
        
        for(int i=0; i<len-2; i++){
            //following condition avoids dups for i
            // 1st ele will always be unique so we let it pass when i==0
            // || is a short circuit 'OR'
            //use .equals whenever using classes instead of !=
            if(i==0 || !(a.get(i).equals(a.get(i-1)))){
                //System.out.println("i "+i);
                int left=i+1;
                int right=len-1;
                
                
                while(left<right){
                    int curSum=a.get(i)+a.get(left)+a.get(right);
                    //System.out.println("CurSum "+curSum);
                    if(curSum==0){
                        ArrayList<Integer> triplet = new ArrayList<>();
                        triplet.add(a.get(i));
                        triplet.add(a.get(left));
                        triplet.add(a.get(right));
                        
                        //System.out.println("Here1");
                        ans.add(triplet);
                        
                        // avoids dups for left
                        while(left<right && a.get(left)==a.get(left+1))
                            left++;
                        
                        //avoids dups for right
                        while(left<right && a.get(right)==a.get(right-1))
                            right--;
                        
                        
                        left++;
                        right--;
                    }
                    
                    if(curSum<0)    left++;
                    if(curSum>0)    right--;
                }
            
            }
        }
        return ans;
        
    }
}

/*
Links-
https://www.interviewbit.com/problems/3-sum-zero/

Notes-
https://discuss.leetcode.com/topic/8125/concise-o-n-2-java-solution

idea- 3rd solution

http://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
*/