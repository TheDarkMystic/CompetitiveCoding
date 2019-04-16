/*
Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
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
public class combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
         
        helper(n,k, 1, temp, res);
        return res;
        
    }
    
    public void helper(int n, int k, int start, ArrayList<Integer> temp,
                        ArrayList<ArrayList<Integer>> res
                         ){
        if(k==temp.size()){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        
        for(int i=start;i<=n;i++){
            temp.add(i);
            helper(n,k, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
            
                                
    }
}
/*
Links-
https://www.interviewbit.com/problems/combinations/
Notes-
backTrack(nums, res, tempList, k-1,i+1);

only changed statement as compared to combination sum I and II solutions

instead of passing remain , passing k

refer combination i and ii

also can refer 
https://leetcode.com/problems/combinations/#/solutions
*/