/*
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.

Note that since Java does not have unsigned int, use long for Java
 */
package interviewprep.BitManipulation;

/**
 *
 * @author jakadam
 */


public class numSetBits {
    public int numSetBits(long a) {
        int count=0;
        
        while(a>0){
            a=a & (a-1);
            count++;
        }
        
        return count;
    }
}
/*
Link-
https://www.interviewbit.com/problems/number-of-1-bits/
Note-
https://www.geeksforgeeks.org/count-set-bits-in-an-integer/
Subtraction of 1 from a number toggles all the bits (from right to left) till the 
rightmost set bit(including the rightmost set bit). So if we subtract a number by 1 
and do bitwise & with itself (n & (n-1)), we unset the rightmost set bit. 
If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
The beauty of this solution is the number of times it loops is equal to the number of set bits 
in a given integer.
*/