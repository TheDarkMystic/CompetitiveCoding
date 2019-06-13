/*
Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 
 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */


public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        char[] arr=A.toCharArray();
        int len=arr.length;
        
        int ans=0;
        for(int i=len-1; i>=0; i--){
            ans=(int)(ans+Math.pow(26, (len-1)-i)*(arr[i]-'A'+1));
        }
        
        return ans;
        
    }
}

/*
Link-
https://www.interviewbit.com/problems/excel-column-number/
Notes-
It is similar to binary to decimal conversion problem.

*/