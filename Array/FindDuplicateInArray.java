/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.Arrangement;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
        
        
        //Approach 1: Since input is read only, use a Set. It will take O(n) space
        
        Set<Integer> set= new HashSet<Integer>();
        
        for(int num: a){
            if(set.contains(num)==true)
                return num;
            else set.add(num);
        }
        
        return 0;
      /*  
        //Approach 2: Maintaining a Boolean array for tracking
        boolean[] arr = new boolean[a.size()];
        for(int i = 0 ; i < a.size() ; i ++){
           int tmp = a.get(i)-1;
           if(arr[tmp]==true){
               return tmp+1;
           }else{
           arr[tmp] = true ; 
           }
        }
        return 0;
	*/
	}
}



/*
ProblemURLs:
I-https://www.interviewbit.com/problems/find-duplicate-in-array/
L-https://leetcode.com/problems/find-the-duplicate-number/
*/
