/*
Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]

I/P : "DIDD" 5
O/P :  5 1 4 3 2
*/
package interviewprep.Array.Arrangement;

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
        res.add(min); // ans.add(max); also works as min and max both point to same no. now. 
        
        return res;
    }

}


/*
ProblemURLs:
I-https://www.interviewbit.com/problems/find-permutation/

NOTES:
http://www.binarycoder.org/array/find-permutation-interviewbit-solution/

*/