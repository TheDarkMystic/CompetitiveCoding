/*
 *
    For Given Number N find if its COLORFUL number or not

    Return 0/1

    COLORFUL number:

    A number can be broken into different contiguous sub-subsequence parts. 
    Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
    And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
    Example:

    N = 23
    2 3 23
    2 -> 2
    3 -> 3
    23 -> 6
    this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

    Output : 1
 */
package interviewprep.Hashing;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class ColorFullNumber {
    public int colorful(int A) {
        
        ArrayList<Integer> nums= new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        
        // Seperate out the digits in the input number
        while(A!=0){
            nums.add(A%10);
            A=A/10;
        }
        
        
        //first two loops are used to generate all contiguous subsequences
        //third loop calculates the product of the digits in the subsequence
        int len=nums.size();
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                
                int prod=1;
                for(int k=i; k<=j; k++){
                    prod=prod*nums.get(k);
                }
                if(set.contains(prod))
                    return 0;
                else
                    set.add(prod);
            }
        }
        return 1;
    }
}

/*
Link-
https://www.interviewbit.com/problems/colorful-number/
Notes-
Own Logic
*/