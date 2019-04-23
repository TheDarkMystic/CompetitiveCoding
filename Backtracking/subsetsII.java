/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Backtracking;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class subsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
        int len= nums.size();
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp= new ArrayList<Integer>();
        Collections.sort(nums);
        helper(nums, 0, temp, res);
        
        return res;
    }
    
    public void helper(ArrayList<Integer> nums,int start,ArrayList<Integer> temp,
                        ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList<Integer>(temp));
        for(int i=start; i<nums.size();i++){
            if(i>start && nums.get(i)==nums.get(i-1))//  skip duplicates
                continue;
            
            temp.add(nums.get(i));
            helper(nums,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
            
    }
    
}
/*
Links-https://www.interviewbit.com/problems/subsets-ii/

Notes-


Recursion is not accurate but still helpful
https://www.youtube.com/watch?v=lCvL8htQ1iI&t=355s

*/