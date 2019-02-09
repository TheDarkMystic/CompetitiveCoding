/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array;

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
	public String largestNumber(final List<Integer> nums) {
	    
	    int len =nums.size();
        
        if(len==0 || nums==null) return "";
        String str[] = new String[len];
        
        for(int ele=0;ele<len;ele++)  str[ele]=Integer.toString(nums.get(ele));
        
        //sort in ascending oreder of lexecography
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b){//*********
                return (b+a).compareTo(a+b);//****************
            }
        });
        
        //check if largest number in array is 0, Sorted in ascending order hence len-1
        if(str[0].charAt(0)=='0') return "0";
        StringBuffer sb=new StringBuffer("");
        /*
        
        for(int i=len-1; i>=0;i--){
            sb.append(str[i]);
        }*/
        
        for(String s: str)
            sb.append(s);
        
        return sb.toString();
	    
	}
}

/*
ProblemURLs:
I-https://www.interviewbit.com/problems/largest-number/

NOTES:
http://www.programcreek.com/2014/02/leetcode-largest-number-java/
https://www.youtube.com/watch?v=iTC43mLZG38


*/