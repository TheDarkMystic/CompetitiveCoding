/*
 * 
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.

Example:

Given “25525511135”,

return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 */


package interviewprep.Strings;

/**
 *
 * @author jakadam
 */



import java.util.*;
public class ValidIPAddress {
    public boolean chk(String s){
        int len = s.length();
        int intVal = Integer.parseInt(s);
        //reconvert the int to string and check the length of the new and original string 
        //to check appended zeros
        String s1 = String.valueOf(intVal);
        if(len != s1.length())
            return false;
            
        return (intVal>=0 && intVal<=255);
    }
    
    
    
    
    public ArrayList<String> restoreIpAddresses(String A) {
        int i, j, k, len=A.length();
        ArrayList<String> res= new ArrayList<String>();
        
        /*
        
        devide the string into 4 partitions using 3 pointers i,j,k and keep moving t
        partition size using the nested for loops below.
        for every set of 4 partitions chcek if they are all valid strings for IP 
        address and add them to result list.
        */
        
        for(i=1; i<len; i++){
            for(j=i+1; j<len; j++){
                for(k=j+1; k<len; k++){
                    String a = A.substring(0,i);
                    String b = A.substring(i,j);
                    String c = A.substring(j,k);
                    String d = A.substring(k);
                    
                    if(chk(a) && chk(b) && chk(c) && chk(d)){
                        res.add( String.join(".", a, b, c, d));
                    }
                }
            }
        }
        
        return res;
    }
}


/*
Link-
https://www.interviewbit.com/problems/valid-ip-addresses/

Notes-
Own Logic
*/
