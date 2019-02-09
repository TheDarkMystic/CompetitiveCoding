/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class FindPermutation {
     public ArrayList<Integer> findPerm(final String str, int n) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        int max=n,
            min=1;
            
        for(int i=0; i<n-1; i++){
            if(str.charAt(i)=='I'){
                res.add(min);
                min++;
            }
            
            if(str.charAt(i)=='D'){
                res.add(max);
                max--;
            }
        }
        res.add(min);
        return res;
    }

}


/*
ProblemURLs:
I-https://www.interviewbit.com/problems/find-permutation/

NOTES:
http://www.binarycoder.org/array/find-permutation-interviewbit-solution/


I/P : "DIDD" 5
O/P :  5 1 4 3 2
*/