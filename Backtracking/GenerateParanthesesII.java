/*
 * 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
 */
package interviewprep.Backtracking;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class GenerateParanthesesII {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res= new ArrayList<String>();
        
        helper(res,"",0,0,n);
        return res;
        
    }
    
    public void helper(ArrayList<String> res, String str ,int open, int close, int n){
        if(str.length()==2*n){
            res.add(str);
            return;
        }
        
        if(open<n)
            helper(res, str+"(", open+1, close, n);
        if(close<open)
            helper(res, str+")", open, close+1, n);
    }
}


/*
Link-

https://www.interviewbit.com/problems/generate-all-parentheses-ii/

Notes-
https://www.tutorialspoint.com/java/lang/stringbuffer_setlength.htm



https://discuss.leetcode.com/topic/8724/easy-to-understand-java-backtracking-solution/13

https://www.youtube.com/watch?v=sz1qaKt0KGQ

Other ways:

https://leetcode.com/problems/generate-parentheses/solution/
*/