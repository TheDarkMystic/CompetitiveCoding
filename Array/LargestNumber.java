/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
package interviewprep.Array.MissingRepeatedNumber;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class LargestNumber {
    /*	
    The idea here is basically implement a String comparator to decide which String should come first 
    during concatenation. Because when you have 2 numbers (let's convert them into String), you'll face 
    only 2 cases:
    For example:
    
    String s1 = "9";
    String s2 = "31";
    
    String case1 =  s1 + s2; // 931
    String case2 = s2 + s1; // 319
    
    Apparently, case1 is greater than case2 in terms of value.
    So, we should always put s1 in front of s2.
*/
    public String largestNumber(final List<Integer> A) {
        /*
        This problem can be solved by sorting strings, not sorting integer. Define a 
        comparator to compare strings by concat() right-to-left or left-to-right.

        */
        int lenA= A.size();
        String str[] = new String[lenA];
        
        // Convert Integer list to Array of String Objs
        for(int i=0; i<lenA; i++){
            str[i]=String.valueOf(A.get(i));
        }
        
        /*write comparator to sort the String obj array in descending order of the strings
          The java string compareTo() method compares the given string with current string 
          lexicographically. It returns positive number, negative number or 0.It compares 
          strings on the basis of Unicode value of each character in the strings.
          If first string is lexicographically greater than second string, it returns positive 
          number (difference of character value). If first string is less than second string 
          lexicographically, it returns negative number and if first string is lexicographically 
          equal to second string, it returns 0.
        */
        
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b){
                //sort in descending order
                return (b+a).compareTo(a+b);
                
                 //sort in ascending order
                //return (a+b).compareTo(b+a);
            }
        });
        
        
        // create string Builder from string array, we will perform some trimming operations
        // on the output before returning
        StringBuilder sb= new StringBuilder();
        for(String s: str){
            sb.append(s);
        }
        
        // Remove the leading 0's
        while(sb.charAt(0)=='0' && sb.length()>1){
            sb.deleteCharAt(0);
        }
        
        // convert stringBuilder to string and return
        return sb.toString();
        
    }
}

/*
ProblemURLs:
I-https://www.interviewbit.com/problems/largest-number/

NOTES:
http://www.programcreek.com/2014/02/leetcode-largest-number-java/
https://www.youtube.com/watch?v=iTC43mLZG38

Comparator->
https://www.youtube.com/watch?v=0xrhqxTOphI
compareTo->
https://www.youtube.com/watch?v=iTC43mLZG38

*/