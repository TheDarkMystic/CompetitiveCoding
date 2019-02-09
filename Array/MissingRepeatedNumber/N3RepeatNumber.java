/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.MissingRepeatedNumber;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class N3RepeatNumber {
    public int repeatedNumber(final List<Integer> nums) {
	    
	    int len= nums.size(),
        cand1=0,
        cand2=0,
        count1=0,
        count2=0;
        
        
        //phase1 [1,2,2,3,2,1,1,3]=>[2,1]//order of if else is ver 
        //important
        for(int n: nums){
            if(n==cand1) count1++;
                    else 
                        if(n==cand2) count2++;
                        else
                            if(count1==0){
                                cand1=n; 
                                count1=1;
                            }
                            else  
                                if(count2==0){
                                    cand2=n;
                                    count2=1;
                                } 
                                else{
                                        count1--;
                                        count2--;
                                    }
        }
        
        //phase2
        count1=0; 
        count2=0;
        for(int n:nums){
            if(n==cand1)
                count1++;
            else if(n==cand2)
                count2++;
        }
        
        //Set<Integer> set= new HashSet<>();
        // avoid duplicates in result[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]=
        //>[0,0]... which is not correct
        
        if(count1>len/3) return cand1;
        else
            if(count2>len/3) return cand2;
	    
	    return -1;
	}
}


/*
*
ProblemURLs:-
I-https://www.interviewbit.com/problems/n3-repeat-number/

NOTES:
Boyer-moore algo for majority counting

https://www.youtube.com/watch?v=zOyOwDEF1Rc

n/3 variation
https://discuss.leetcode.com/topic/17396/boyer-moore-majority-vote-algorithm-generalization/5

CTRL+F :doudou900914 

n/2 algorithm variation
https://leetcode.com/problems/majority-element/#/description

soltion using Sorting is in complete solution section of IB
*/
