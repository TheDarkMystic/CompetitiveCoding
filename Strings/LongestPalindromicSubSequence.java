/*
 * 
Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */


public class LongestPalindromicSubSequence {
    //This is a simple algo
    //We can scan to both sides for each character. Time O(n^2), Space O(n)
    //can also be coded using DP but will be Time O(n^2), Space O(n^2)

    
    boolean isPalin(StringBuilder str) {
        int len = str.length();
        
        for(int i = 0; i < len/2; i++) 
            if(str.charAt(i) != str.charAt(len-1-i)) return false;
        
        return true;
    }
    
    
    public String longestPalindrome(String a) {
        StringBuilder palin = new StringBuilder();
        
        for(int i = 0; i < a.length(); i++) {
            
            StringBuilder curWord = new StringBuilder();
            
            for(int j = i; j < a.length(); j++) {
                
                curWord.append(a.charAt(j));
                if(isPalin(curWord)) {
                    if(curWord.length() > palin.length()) {
                        palin = new StringBuilder(curWord.toString());
                    }
                }
            }
            
        }
        return palin.toString();
    }
}


/*
Link-
https://www.interviewbit.com/problems/longest-palindromic-substring/
Notes-
https://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/

Manacher's algorithm is much more complicated to figure out, even though it will bring benefit of time 
complexity of O(n). Since it is not typical, there is no need to waste time on that.



*/