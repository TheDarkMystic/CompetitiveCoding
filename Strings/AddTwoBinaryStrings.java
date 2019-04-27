/*
    Given two binary strings, return their sum (also a binary string).

    Example:

    a = "100"

    b = "11"
    Return a + b = “111”.
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */


public class AddTwoBinaryStrings {
    public String addBinary(String A, String B) {
        StringBuilder sb= new StringBuilder();
        
        int lenA=A.length();
        int lenB=B.length();
        int i=lenA-1;
        int j=lenB-1;
        int carry=0;
        while(i>=0 || j>=0){
            int sum=0;
            if(i>=0 && A.charAt(i)=='1')
                sum++;
            if(j>=0 && B.charAt(j)=='1')
                sum++;
                
            sum=sum+carry;    
            if(sum>=2)
                carry=1;
            else
                carry=0;
            
            sb.insert(0,(char)((sum%2)+'0'));
            
            j--;
            i--;
        }
        
        if(carry==1)
            sb.insert(0,'1');
        
        return sb.toString();
    }
}

/*
Link
https://www.interviewbit.com/problems/add-binary-strings/

Notes-
https://www.programcreek.com/2014/05/leetcode-add-binary-java/
*/