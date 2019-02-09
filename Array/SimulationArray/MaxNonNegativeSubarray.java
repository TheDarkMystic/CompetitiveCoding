/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.SimulationArray;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class MaxNonNegativeSubarray {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    
	    long curr_sum = 0;
	    long max_sum = 0;
	    
	    ArrayList<Integer> newSol = new ArrayList<>();
	    ArrayList<Integer> sol = new ArrayList<>();
	    
	    
	    for(Integer i: a)
	    {
	        if(i>=0){
	            curr_sum+=i;
	            newSol.add(i);
	        }
	   
	        else{
	            curr_sum=0;
	            newSol=new ArrayList<Integer>();
	        }
	        
	        if(curr_sum>max_sum || (curr_sum==max_sum) && (newSol.size()>sol.size())){
	            sol=newSol;
	            max_sum=curr_sum;
	        }
	    }
	    
	    return sol;
}
}

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/max-non-negative-subarray/

NOTES:
*/
