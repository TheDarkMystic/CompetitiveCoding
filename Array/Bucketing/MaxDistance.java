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
public class MaxDistance {
    // DO NOT MODIFY THE LIST
	public int maximumGap(final List<Integer> a) {
	
	int n1 =a.size();
	int A[]= new int[n1];
	
	//convert arraylist to array
	for(int i=0;i<n1; i++)A[i]=a.get(i);
	
	int lmin[]= new int[n1], 
    rmax[]= new int[n1], 
    i, j,
    max = -1;
  
    //populate lmin[]
    lmin[0]=A[0];
    for(i=1; i<n1; i++)
        lmin[i]=Math.min(A[i], lmin[i-1]);
 
    //populate rmax[]
    rmax[n1-1]=A[n1-1];
    for(i=n1-2; i>=0; i--)
        rmax[i]=Math.max(A[i],rmax[i+1]);
    
    
    //traversing lmin[], rmax[]
    for(i=0, j=0; i<n1 && j<n1; ){
        if(lmin[i]<=rmax[j]){// this condition is different on GFG
            max=Math.max(j-i, max);
            j++;
        }else{
            i++;
        }
    }
    return max;
}
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/max-distance/
NOTES:
http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

*/
