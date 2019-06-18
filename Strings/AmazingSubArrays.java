/*
 You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */


public class AmazingSubArrays {
    public int solve(String A) {
        int count=0;
        String s = "aeiouAEIOU";
        for(int i=0; i<A.length(); i++){
            //Alternatively if(s.indexOf(A.charAt(i)) != -1) can be used
            if(s.contains( String.valueOf(  A.charAt(i) )  )){
                count= count + A.length()-i;
                count= count%10003;
            }
        }
        return count;
    }
}
/*
Link-
https://www.interviewbit.com/problems/amazing-subarrays/
Notes-

Regarding indexOf and contains method:
https://www.geeksforgeeks.org/java-string-contains-method-example/

*/