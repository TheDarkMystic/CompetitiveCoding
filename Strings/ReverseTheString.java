/*
Given a string A.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.

Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.

If there are multiple spaces between words, reduce them to a single space in the reversed string.



Input Format

The only argument given is string A.
Output Format

Return the string A after reversing the string word by word.
For Example

Input 1:
    A = "the sky is blue"
Output 1:
    "blue is sky the"

Input 2:
    A = "this is ib"
Output 2:
    "ib is this"
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */
public class ReverseTheString {
    public String reverseWords(String s) {
        /*
            1. Split the string on " "
            2. append the returned array in reverse order
        */
       String[] arr= s.split(" ");
       
       StringBuilder res= new StringBuilder();
       
       for(int i=arr.length-1; i>=0; i--){
           res.append(arr[i]+" ");
       }
       
       res.deleteCharAt(res.length()-1);
       
       return res.toString();
    }
}
/*
Link-
https://www.interviewbit.com/problems/reverse-the-string/
Notes-

https://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/

https://www.youtube.com/watch?v=DlygTBMhonA

http://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/



for 2nd solution
https://www.tutorialspoint.com/java/stringbuffer_reverse.htm

https://stackoverflow.com/questions/2242471/java-clearing-the-string-buffer-after-loop
*/