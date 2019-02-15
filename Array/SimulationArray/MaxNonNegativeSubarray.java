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
    public ArrayList<Integer> maxset(ArrayList<Integer> arr) {
        int len=arr.size();
        
        //sum may overflow int range hence use long
        long cur_sum=0;
        long max_sum=0;
        
        ArrayList<Integer> sol= new ArrayList<Integer>();
        ArrayList<Integer> newSol= new ArrayList<Integer>();
       
        
        for(Integer num: arr){
            if(num>=0){
                cur_sum+=num;
                newSol.add(num);
            }
            else{
                cur_sum=0;
                newSol=new ArrayList<Integer>();
            }
            
            if(cur_sum>max_sum || (cur_sum==max_sum && newSol.size()>sol.size())){
                sol=newSol;
                max_sum=cur_sum;
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
