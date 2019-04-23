/*
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 */
package interviewprep.BinarySearch;

/**
 *
 * @author jakadam
 */

public class Sqrt {
    public int sqrt(int a) {
    
        if(a==0)
            return 0;
            
        long left=1, right=a;//in case of overflow
        
        while(left<right){
            long mid= left+(right-left)/2+1;
            if(mid*mid>a)
                right=mid-1;
            else
                left=mid;
                
        }
        
        return (int)left;
    }
}

/*
Link-https://www.interviewbit.com/problems/square-root-of-integer/
Notes-
https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution
CTRL+F : My easy version:

https://www.youtube.com/watch?v=DY9mpb5YLZ4


if(mid==A/mid) and if(mid>A/mid) are FASTER THAN if(mid*mid==A) 
and if(mid*mid>A) 

https://www.interviewbit.com/problems/square-root-of-integer/

Second combination gives TLE. Everyone has used the first combination.



*/