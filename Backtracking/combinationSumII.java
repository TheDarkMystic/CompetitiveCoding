/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. 
 */
package interviewprep.Backtracking;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class combinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidates, int targetSum) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp= new ArrayList<Integer>();
        //ArrayList<Integer> candidates= new ArrayList<Integer>(new HashSet(candidateList));
        Collections.sort(candidates);
        helper(candidates, targetSum, 0, temp, res);
        return res;
    }
    
    public void helper(ArrayList<Integer> candidates,int targetSum, int start, ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> res){
        if(targetSum<0)
            return;
        if(targetSum==0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        int prev=-1;
        for(int i=start; i<candidates.size(); i++){
            if(prev!=candidates.get(i)){ // each time start from different element

                temp.add(candidates.get(i));
                helper(candidates, targetSum-candidates.get(i), i+1, temp, res);
                temp.remove(temp.size()-1);
            
                prev=candidates.get(i);
            }
        } 
    }
}

/*
Link-
https://www.interviewbit.com/problems/combination-sum-ii/
Notes-
https://leetcode.com/problems/combination-sum/#/solutions


https://leetcode.com/problems/combination-sum-ii/#/description    
*/