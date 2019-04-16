/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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