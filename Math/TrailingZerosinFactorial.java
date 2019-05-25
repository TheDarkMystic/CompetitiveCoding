/*
 * 
    Given an integer n, return the number of trailing zeroes in n!.

    Note: Your solution should be in logarithmic time complexity.

    Example :

    n = 5
    n! = 120 
    Number of trailing zeros = 1
    So, return 1
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */

public class TrailingZerosinFactorial {
    public int trailingZeroes(int n) {
        /*
        This question is pretty straightforward.
        Because all trailing 0 is from factors 5 * 2.
        But sometimes one number may have several 5 factors, for example, 
        25 have two 5 factors, 125 have three 5 factors. In the n! operation, 
        factors 2 is always ample. So we just count how many 5 factors in all number from 
        1 to n.
        */
        
        int ans=0;
        while(n/5!=0){
            n=n/5;
            ans=ans+n;
        }
        
        return ans;
    }
}
/*
Links-
https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
Notes-
https://www.youtube.com/watch?v=FBW4hhhU838
*/