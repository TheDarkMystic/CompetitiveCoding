/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.StackQueues;

/**
 *
 * @author jakadam
 */

import java.util.*;

public class RedunduntBraces {
    public int braces(String A) {
        //convert string to char array
        char[] str= A.toCharArray();
        int len= str.length;
        
        
        //Define a stack
        Stack<Character> stack= new Stack<Character>();
        
        /*
        -   operators allowed are only + , * , - , /. hence , a pair of () must have atleast 2 
        -   why 2? Eg. (a+(a+b))  in this case the inner operation will be popped out of stack 
            and we'll be left with (a+ ), and since input expr is always valid, we need to tackle this case as valid case.
        -   Idea- keep pushing eles until you come across ')'. Once we hit closing brace, start popping
            and counting until we hit ')' i.e, start of the expr.
            from start of this expr to end of this expr if we have less than 2 eles, we say these 
            brackets are redundunt.
            
            
        - there is a problem on geeks -> duplicate/empty braces-> same idea-> but return 1 if count<1
        
        
        */
        for(int i=0; i<len; i++){
            //when we hit closing
            if(str[i]==')'){
                int count=0;
                //keep popping until we hit opeining and count simultaneously
                while(stack.peek()!='('){
                    count++;
                    stack.pop();
                }
                stack.pop();
                
                if(count<2)
                    return 1;
            }
            else//keep puching until we hit closing
                stack.push(str[i]);
        }
        
        return 0;
    }
}


/*
Link-https://www.interviewbit.com/problems/redundant-braces/
Notes-
https://www.geeksforgeeks.org/find-expression-duplicate-parenthesis-not/
*/