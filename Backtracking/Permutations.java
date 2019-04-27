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
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int size=A.size();
        ArrayList<Integer> temp= new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res= new ArrayList<ArrayList<Integer>>();
        
        helper(A,temp,res);
        
        return res;
    }
    
    public void helper(ArrayList<Integer> A,ArrayList<Integer> temp,
                        ArrayList<ArrayList<Integer>> res){
        if(temp.size()==A.size())
            res.add(new ArrayList<Integer>(temp));
        else{
            for(int i=0; i<A.size(); i++){
                if(temp.contains(A.get(i))) continue; // element is already present, skip
                temp.add(A.get(i));
                helper(A,temp,res);
                temp.remove(temp.size()-1);
            }
        }    
    }
}
/*
Links-
https://www.interviewbit.com/problems/permutations/
Notes-
https://www.youtube.com/watch?v=GCm7m5671Ps&t=517s
https://leetcode.com/problems/combination-sum/discuss/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
*/