/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.MissingRepeatedNumber;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class LargestNumber {
    /*	
	The idea here is basically implement a String comparator to decide which String should come first during concatenation. Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
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
        
        //write comparator to sort the String obj array in descending order of the strings
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
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