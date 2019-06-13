/*
 * 
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */

public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder str= new StringBuilder();
        while(A!=0){
            int remainder=A%26;
            A=A/26;
            
            if(remainder==0){
                remainder=26;
                A--;
            }
            
            str.append((char)(64+remainder));
        }
        
        return str.reverse().toString();
    }
}

/*
Link-
https://www.interviewbit.com/problems/excel-column-title/
Notes-

This problem is similar to decimal to binary conversion
https://www.youtube.com/watch?v=4vNlt_EDw1Q&t=7s

https://discuss.leetcode.com/topic/6248/accepted-java-solution
*/