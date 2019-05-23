/*
 * 
Given a string, 

find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */
package interviewprep.Hashing;

/**
 *
 * @author jakadam
 */


import java.util.*;
public class LongestSubstringWORepeat {
    public int lengthOfLongestSubstring(String A) {
        int len=A.length();
        //this map stores the last seen position for characters in the string
        HashMap<Character, Integer> map= new HashMap<Character, Integer>();
        
        //ans. maximum length string
        int maxLen=0;
        //running length of the substring under consideration
        int count=0;
        
        for(int i=0; i<len; i++){
            char c=A.charAt(i);
            
            if(!map.containsKey(c)){
                //found a new char, increase the running length
                count++;
                // add char position to the map
                map.put(c,i);
                //update maxLength
                maxLen=Math.max(count, maxLen);
            }
            else{// repeating char found
                // get the last seen position of the repeated char
                // next iteration will start from the next char of the repeated char
                //because of i++ in for loop( make a dry run for more clarity)
                i=map.get(c);
                
                //reset the map for new substring
                map.clear();
                
                //reset the runningLength to 0 for next new string
                count=0;
            }
        }
        return maxLen;
    }
}

/*
Link-
https://www.interviewbit.com/problems/longest-substring-without-repeat/
Notes-

This solution is self-explainatory.

Alternative solution
http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/

*/