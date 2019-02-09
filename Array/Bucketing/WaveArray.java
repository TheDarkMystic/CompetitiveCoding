/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.Bucketing;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> a) {
	    
	    Integer[] A= a.stream().toArray(Integer[] :: new);
	    //sorting is to get the lexicographically first part right, otherwise not needed
	    Arrays.sort(A);
	    int len= A.length; 
	    
	    /*
	        Logic is simple
	        1. if ele at even index is < than its prev ele, swap them
	        2. if ele at odd index is > than its prev ele, swap them
	    */
	    for(int i=1; i<len; i++){
	        int cur =A[i], prev=A[i-1];
	        
	        
	        if(i%2==0 && cur<prev)// even index
	            swap(A, i, i-1 );
	        else if(i%2==1 && cur>prev)//odd index 
	            swap(A, i, i-1);
	    }
	    a=new ArrayList<Integer>(Arrays.asList(A));
        return a;
	   
	}
	
	public static void swap(Integer A[], int a,int b){
        int temp = A[a];
        A[a]=A[b];
        A[b]=temp;
    }
	
    
}
/*
ProblemUrls:
I-
NOTES:
easy
https://discuss.leetcode.com/topic/23871/java-o-n-solution
--------------------------

https://www.youtube.com/watch?v=hNR6fsksEu8

http://www.geeksforgeeks.org/sort-array-wave-form-2/
*/
