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
public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        int len= arr.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Integer> stack= new Stack<Integer>();
        
        // Initialize result list with -1. As -1 is the default return value.
        for(int i=0; i<len; i++){
            res.add(-1);
        }
        
        
        //we are asked to find smaller element to left hence start from end of list.
        for(int i=len-1; i>=0; i--){ 
            
            // keep popping eles from stack till next array ele is smaller than
            //stack top. For all popped eles, the nearest smaller ele is the next array ele.
            while(stack.isEmpty()==false && arr.get(stack.peek())>arr.get(i)){
                res.set(stack.pop(), arr.get(i));
            }
            
            // after all popping, push the array ele to stack
            stack.push(i);
            // as we had initialized arrayList with -1, we need not worry abt the remaining 
            //eles in stack. They will automatically have -1 s ans.
        }
        return res;
    }
}
/*
Link-https://www.interviewbit.com/problems/nearest-smaller-element/
Notes-
https://codevillage.wordpress.com/2016/08/24/nearest-smaller-element/

https://www.youtube.com/watch?v=8P-Z7Oc8x9I

problem has another variation 
called next largest element

just start the for from 0 to n

everything else will be same

*/