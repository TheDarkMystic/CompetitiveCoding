/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem

*/
package interviewprep.DP;

/**
 *
 * @author jakadam
 */



/*
Working Solution With (Recursion+memoization)
*/

/*
public class JumpGameArray {
    public int canJump(ArrayList<Integer> nums) {
        int len=nums.size();
        if(len==1)
            return 1;
        String[] memo= new String[len];
        Arrays.fill(memo,"UNKNOWN");
        memo[len-1]="GOOD";
        return canJump(nums, memo,0);
    }
    
    public int canJump(ArrayList<Integer> nums, String[] memo, int pos){
        if(memo[pos].equals("UNKNOWN")==false){
            return memo[pos].equals("GOOD")?1:0;
        }
        
        int farthestReach=Math.min(pos+nums.get(pos), nums.size()-1);
        
        for(int nextPos=pos+1;nextPos<=farthestReach; nextPos++){
            if(canJump(nums,memo,nextPos)==1){
                memo[pos]="GOOD";
                return 1;
            }
        }
        
        memo[pos]="BAD";
        return 0;
        
        
        
    }
}
*/


// Working Solution with Iterative DP
import java.util.*;
enum Index{
    GOOD, BAD, UNKNOWN;
}

public class JumpGameArray {
    public int canJump(ArrayList<Integer> nums) {
        int len=nums.size();
        Index memo[]= new Index[len];
        Arrays.fill(memo, Index.UNKNOWN);
        
        memo[len-1]=Index.GOOD;
        
        
        
        for(int pos=len-2; pos>=0; pos--){
            int farthestJump= Math.min(pos+nums.get(pos), len-1);
            for(int nextPos=pos+1; nextPos<=farthestJump; nextPos++){
                if(memo[nextPos]==Index.GOOD){
                    memo[pos]=Index.GOOD;
                    break;
                }
            }
        }
        
        
        
        return memo[0]==Index.GOOD?1:0;
        
    }
}
/*
//Consice Solution from Complete Solution section
public class Solution {
	public int canJump(ArrayList<Integer> a) {
	    int currJump= 0;
	    for (int i=0; i<a.size(); i++){
	        if (currJump<0) return 0;
	        currJump= Math.max(a.get(i),currJump);
	        currJump--;
	    }
	    return 1;
	}
}

*/

/*
Links-https://www.interviewbit.com/problems/jump-game-array/
Notes-
https://leetcode.com/problems/jump-game/solution/
Very nice and detailed conceptual explaination of arriving at DP solutions.



*/