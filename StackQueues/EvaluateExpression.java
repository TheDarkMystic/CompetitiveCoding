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
public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack= new Stack<Integer>();
        int len =A.size();
        
        /*
        Idea is to keep pushing the elements to stack until we encounter an operator.
        Once operator is encountered, pop 2 times. 
        Those are our 2 operands and perform the 
        operation using the operator. 
        Push the result back to stack.
        */
        
        
        String operators="+-/*";
        
        for(String ele: A){
            if(operators.contains(ele)==true){
                //notice the order of popping op1 and op2.
                
                int op2=stack.pop();
                int op1=stack.pop();
                
                switch(ele){
                    case "+": stack.push(op1+op2); break;
                    case "-": stack.push(op1-op2); break;
                    case "*": stack.push(op1*op2); break;
                    case "/": stack.push(op1/op2); break;
                }
            }
            else{
                stack.push(Integer.parseInt(ele));
            }
        }
        
        return stack.peek();
        
    }
}
/*
Links-
Notes-
Watch Bens Video on youtube(reverse polish Notation).

https://github.com/nagajyothi/InterviewBit/blob/master/StacksAndQueues/EvaluateExpression.java

https://leetcode.com/problems/evaluate-reverse-polish-notation/#/solutions


Java Switch Reference
https://www.tutorialspoint.com/java/switch_statement_in_java.htm



String contains() method
https://www.javatpoint.com/java-string-contains
*/