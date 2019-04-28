/*
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"
 Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to 
 think of all the needed clarifications and see the expected response using “See Expected Output” For 
the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations.

 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */



public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        StringBuilder sb= new StringBuilder();
        
        //for each element in values, keep subtracting it from given number till 
        //the num>=element
        
        /*
        Eg. for 14, we will do 
            num=14-10   =>  sb=X
            num=4-4     =>  sb=X IV
            num==0
        */
        for(int i=0; i<values.length;i++){
            
            while(num>=values[i]){
                num=num-values[i];
                sb.append(strs[i]);
            }
        }
        
        return sb.toString();

    }
}

/*
Link-
https://www.interviewbit.com/problems/integer-to-roman/
Notes-
http://www.wikihow.com/Learn-Roman-Numerals
*/