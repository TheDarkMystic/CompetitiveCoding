/*
 * 
Implement strStr().

strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. 
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */


public class strStr {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String text, final String pattern) {
        int lenText=text.length();
        int lenPat=pattern.length();
        
        char[] txt=text.toCharArray();
        char[] pat=pattern.toCharArray();
        
        for(int i=0; i<=lenText-lenPat; i++){
            
            int j=0;
            while(j<lenPat && txt[i+j]==pat[j])
                j++;
            
            // pattern found
            if(j==lenPat)
                return i;
        }
        
        return -1;
    }
}

/*
Link-
https://www.interviewbit.com/problems/implement-strstr/

Notes-

Optional:
https://discuss.leetcode.com/topic/18839/elegant-java-solution

KMP Solutions
https://www.youtube.com/watch?v=y2b94AxPlF8

https://www.youtube.com/watch?v=t4xUA-aHzy8

https://discuss.leetcode.com/topic/27261/clean-kmp-solution-with-super-detailed-explanation
*/