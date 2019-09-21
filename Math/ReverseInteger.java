/*
Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */

/*
Using Long for storing reverse Num, for checking of overflow
public class ReverseInteger {
    public int reverse(int A) {
        long rev=0;
        int sign=A<0?-1:1;
        int num=Math.abs(A);
        
        while(num>0){
            rev=rev*10+num%10;
            num=num/10;
        }
        
        rev=rev*sign;
        
        if(rev<Integer.MIN_VALUE || rev>Integer.MAX_VALUE)
            return 0;
        
        return (int)rev;
        
        
        
    }
}

*/

// solution- If using Long for checking overflow is not allowed.

public class ReverseInteger {
    public int reverse(int a) {
        
        // Handling negative numbers
        boolean negativeFlag = false;
        if(a < 0) {
            negativeFlag = true;
            a = -a;
        }

        int prev_rev_num = 0, rev_num = 0;
        while(a != 0) {
            int curr_digit = a % 10;

            rev_num = (rev_num * 10) + curr_digit;

            // checking if the reverse overflowed or not.
            // The values of (rev_num - curr_digit)/10 and
            // prev_rev_num must be same if there was no
            // problem.
            if((rev_num - curr_digit) / 10 != prev_rev_num) {
                return 0;
            }

            prev_rev_num = rev_num;
            a = a / 10;
        }

        return negativeFlag ? -rev_num : rev_num;
    }
}
/*
Links-
Notes-
https://www.interviewbit.com/problems/reverse-integer/
*/