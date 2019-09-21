/*
 *  Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.

    Read more details about roman numerals at Roman Numeric System

    Example :

    Input : "XIV"
    Return : 14
    Input : "XX"
    Output : 20
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class RomanToInteger {
    public int romanToInt(String S) {
        /*
        1.  Roman Numeral have 7 fundamental numbers ('I',1), ('V',5),('X',10), ('L',50),
            ('C',100),('D',500),('M',1000). 
        2.  Traverse the given Roman no. String from Right to Left.
            if the value of literal Increase(or equal) from right to left,
                add the value of cur literal to running sum
            else 
                deduct the value of cur literal to running sum
                
        eg. "XIV" = 10 -1 + 5 =14
            "XX"  = 10+10=20
        */
        
        
        
        int len=S.length();
        if(S==null || len==0)
            return 0;
            
        Map<Character, Integer> romanToInt =new HashMap<>();
            romanToInt.put('I',1);
            romanToInt.put('V',5);
            romanToInt.put('X',10);
            romanToInt.put('L',50);
            romanToInt.put('C',100);
            romanToInt.put('D',500);
            romanToInt.put('M',1000);
        
        int result=romanToInt.get(S.charAt(len-1));
        
        for(int i=len-2;i>=0; i--){
            
            if(romanToInt.get(S.charAt(i))>=romanToInt.get(S.charAt(i+1)))
                result=result+romanToInt.get(S.charAt(i));
            else
                result=result-romanToInt.get(S.charAt(i));
        }
        
        return result;
    }
}

/*
Links-
https://www.interviewbit.com/problems/roman-to-integer/
Notes-
https://www.youtube.com/watch?v=Xy1dfcg7P-Y
http://www.wikihow.com/Learn-Roman-Numerals
*/