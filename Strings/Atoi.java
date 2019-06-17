/*
 *
Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 
Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
If you do, we will disqualify your submission retroactively and give you penalty points.
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */


public class Atoi {
    public int atoi(final String a) {
        char[] str= a.toCharArray();
        int len =str.length;
        
        //skip the leading spaces
        int i=0;
        while(str[i]==' ')
            i++;
        
        //check sign
        int sign=1;
        if(str[i]=='-' || str[i]=='+'){
            sign=str[i]=='-'? -1 :1 ;
            i++;
        }
        
        //convert the remaining string to a number
        long num=0;

        while(i<len && str[i]>='0' && str[i]<='9'){
            num=num*10+(str[i]-'0');
            i++;
            
            if(sign*num>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(sign*num<=Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        

        return (int)(num*sign);
        
    }
}

/*
Link-
https://www.interviewbit.com/problems/atoi/
Notes-
Problem is simple but too many coerner cases.
*/