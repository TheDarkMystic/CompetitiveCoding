/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.DP;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class LengthOfLongestSubsequence {
    
        public int longestSubsequenceLength(final List<Integer> A) {
        /*
            -This is an Application of LIS. This problem is also called as BITONIC Sequence.
            -Approach- 
                    -Maintain 2 DP arrays. One maintains LIS starting from left end.
                    -2nd maintains LIS starting from right end.
                    -for each index i calculate (LISLeft+LISright-1) and find max value of the 
                        same.
                    - (-1) in the formula indicates that we have counted the ele at i
                        twice in calculation, hence ned to be subtracted once.
                    
        */
        
        // for explaination related to following few steps, read LIS problem in git.
        
        int len= A.size();
        
        //for empty array
        if(len==0)
            return 0;
        
        int[] LISRight= new int[len];
        int[] LISLeft = new int[len];
        
        Arrays.fill(LISRight, 1);
        Arrays.fill(LISLeft,1);
        
        
        //popultate LIS left
        
        for(int i=0; i<len; i++){
            for(int j=0;j<i; j++){
                if(A.get(i)>A.get(j))
                    LISLeft[i]= Math.max(LISLeft[i], LISLeft[j]+1);
            }
        }
        
        
         //popultate LIS Right
        
        for(int i=len-1; i>=0; i--){
            for(int j=len-1;j>i; j--){
                if(A.get(i)>A.get(j))
                    LISRight[i]= Math.max(LISRight[i], LISRight[j]+1);
            }
        }
        
        
        
        //calculate max of (LISLeft+LISRight-1)
        int max=1; //default or base LIS value is 1. LISL+LISR-1=1+1-1= 1 
        for(int i=0; i<len; i++){
            max= Math.max(max, LISLeft[i]+LISRight[i]-1);
        }
        
        
        return max;
    }
}

/*
Link-
https://www.interviewbit.com/problems/length-of-longest-subsequence/
Notes-
https://www.youtube.com/watch?v=TWHytKnOPaQ

http://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/

https://www.interviewbit.com/problems/longest-increasing-subsequence/


*/
