/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]
 */
package interviewprep.Backtracking;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class subsetsI {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp =new ArrayList<Integer>();
        Collections.sort(nums);
        helper(nums, 0, temp, res);
        return res;
    }
    
    public void helper(ArrayList<Integer> nums, int start, ArrayList<Integer> temp,
                        ArrayList<ArrayList<Integer>> res){
        res.add(new ArrayList(temp));
        for(int i=start; i<nums.size(); i++){
            temp.add(nums.get(i));
            helper(nums,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
/*
Links-https://www.interviewbit.com/problems/subset/
Notes-
https://leetcode.com/problems/combination-sum/discuss/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning


Another great solution using BIT MANIPULATION
https://discuss.leetcode.com/topic/2764/my-solution-using-bit-manipulation


*/