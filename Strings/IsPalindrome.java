/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */
public class IsPalindrome {
    public int isPalindrome(String A) {
        // Converting string to Char Array for convenience.
        // Problem can be solved without doing this also by creating a StringBuilder and 
        // copying only alphaNumeric chars(after lowercasing) from string to it and then
        //process it.
        
        char[] str= A.toLowerCase().replaceAll("[^a-zA-Z0-9]","").toCharArray();
        int len=str.length;

        if(len==0||len==1)
            return 1;
        
            
        for(int i=0; i<=Math.floor(len/2); i++){
            if(str[i]!=str[len-i-1])
                return 0;
        }
        
        return 1;
    }
}

/*
Links-
https://www.interviewbit.com/problems/palindrome-string/

Notes-
replaceAll regex- https://stackoverflow.com/questions/14361556/remove-all-special-characters-in-java


http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/

2 successful submissions
 one using REGEX ans 
 other using Two pointers


*/