/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> a) {
	    int len=a.size();
	    int A[] = new int[len];
	    for(int i=0;i<len;i++)
	        A[i]=a.get(i);
	    
	    int p=0;
	    for(int i=len-2;i>=0;i--){
	        if(A[i]<A[i+1]){
	            p=i;
	            break;
	        }
	    }
	    
	    int q=0;
	    for(int i=len-1;i>=0;i--){
	        if(A[i]>A[p]){
	            q=i;
	            break;
	        }
	    }
	    
	    if(p==0 && q==0)
	        reverse(A,0,len-1);
	   
	   //swap p and q
	    int temp=A[p];
	    A[p]=A[q];
	    A[q]=temp;
	    
	    reverse(A,p+1, len-1);
	    
	    for(int i=0;i<len;i++)
	    a.set(i,A[i]);
	}
	
	
	public static void reverse(int A[],int start, int end){
	    while(start<end){
	        int temp=A[start];
	        A[start]=A[end];
	        A[end]=temp;
	        
	        start++;
	        end--;
	    }
	}
}

/*
ProblemUrls:
I- https://www.interviewbit.com/problems/next-permutation/
NOTES:
http://www.programcreek.com/2014/06/leetcode-next-permutation-java/

http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
---------------------------------------------------------------------------------------------------
Its a 4 step algorithm

step 1: scan from right to left find the first element that is less than its previous one.

step 2:scan from right to left, find the first element that is greater than p.

step 3: swap p and q

step 4: reverse elements [p+1, nums.length]

example on leetcode link
remember 4 5 6 3 2 1 for example
*/