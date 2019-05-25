/*
 * 
Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */

public class PowerOf2Integers {
    public int isPower(int A) {
        if(A==1)
            return 1;
        
        for(int i=2; i<A; i++){
            int num=A;
            
            //if number is completely divisible by i, keep doing it
            while(num%i==0)
                num=num/i;
                
            if(num==1)
                return 1;
        }
        
        return 0;
        
    }
}

/*
Link-
https://www.interviewbit.com/problems/power-of-two-integers/
Note-
Alternative-http://www.geeksforgeeks.org/check-if-a-number-can-be-expressed-as-xy-x-raised-to-power-y/

*/
