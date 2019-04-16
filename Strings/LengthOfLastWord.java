/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.

"Hello world     "
still the ans should be 5

*/
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(final String A) {
        
        int lenA=A.length();
        if(lenA==0)
            return 0;
        
        boolean flag=false;
        int count=0;
        for(int i=lenA-1; i>=0; i--){
            
            if(A.charAt(i)!=' ' && flag==false){        // found the start of last word
                flag=true;
                count++;
            }
            else if(A.charAt(i)!=' ' && flag==true){    // inside the last word
                count++;
                
            }
            else if(A.charAt(i)==' ' && flag==true){    // found the end of last word
                flag=false;
                break;
            }
            else if(A.charAt(i)==' ' && flag==false)    // skipping the trailing spaces
                continue;
        }
        
        return count;
    }
    
    //Alternate Solution: Concise
    /*
    public int lengthOfLastWord(final String s) {
        int len = 0;
        
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        for (i=i; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                return len;
            }
            len++;
        }
        
        return len;
    }
    */
}
