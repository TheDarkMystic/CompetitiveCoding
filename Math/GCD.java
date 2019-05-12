/*
 * 
    Given 2 non negative integers m and n, find gcd(m, n)

    GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
    Both m and n fit in a 32 bit signed integer.

    Example

    m : 6
    n : 9

 GCD(m, n) : 3 
 NOTE : DO NOT USE LIBRARY FUNCTIONS 
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */

public class GCD {
    public int gcd(int a, int b) {
        if(a==0)
            return b;
         return gcd(b%a,a);
    }
}

/*
Link-
https://www.interviewbit.com/problems/greatest-common-divisor/

Notes-
https://www.youtube.com/watch?v=VWOUh4w_zVI
*/