/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The combinations themselves must be sorted in ascending order.
CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR … (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
The solution set must not contain duplicate combinations.
Example, 
Given candidate set 2,3,6,7 and target 7,
A solution set is:

[2, 2, 3]
[7]
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
    public class combinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> candidateList, int targetSum) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        /*  Duplicates in candidateList cause duplicate combinations in result, 
            hence converting 
        */
        ArrayList<Integer> candidates = new ArrayList<Integer>(new HashSet(candidateList));

        Collections.sort(candidates);
        helper(candidates,targetSum,0,temp,res);        
        return res;
    }
    
    public void helper(ArrayList<Integer> candidates,int targetSum, int start, 
                                               ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
                                                   
        if(targetSum<0)
            return;
        
        if(targetSum==0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i=start; i<candidates.size(); i++){
            temp.add(candidates.get(i));
            helper(candidates,targetSum-candidates.get(i),i,temp,res);
            temp.remove(temp.size()-1);
        }
        
    }
    
}

/*
Link-
    https://www.interviewbit.com/problems/combination-sum/
Notes-
  
  https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/20
  
*/