/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.Bucketing;

/**
 *
 * @author jakadam
 */

import java.util.*;

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int len=A.size();
        
        for(int i=0;i<len-1;i++)
        {
            if(A.get(i)==A.get(i+1)) continue;
            if(A.get(i)==((len-1)-i))
                return 1;
        }
        if(A.get(len-1)==0) return 1;
        return -1;
    }
}

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/noble-integer/

NOTES:
http://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-elements-is-equal-to-value/
*/
