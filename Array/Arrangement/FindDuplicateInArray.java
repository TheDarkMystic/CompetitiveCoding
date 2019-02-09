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
import java.util.List;
public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> a) {
	    boolean[] arr = new boolean[a.size()];
	    
	    
	    for(int i = 0 ; i < a.size() ; i ++){
	       int tmp = a.get(i)-1;
	       if(arr[tmp]==true){
	           return tmp+1;
	       }else{
	       arr[tmp] = true ; 
	       }
	    }
	    return -1;
	    
	}
}



/*
ProblemURLs:
I-https://www.interviewbit.com/problems/find-duplicate-in-array/
L-https://leetcode.com/problems/find-the-duplicate-number/
*/
