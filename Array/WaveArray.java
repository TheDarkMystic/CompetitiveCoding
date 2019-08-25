/*
Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 
So, in example case, you will return [2, 1, 4, 3] 
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



//Solution with ArrayList
/*
public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        int len=A.size();
        
        for(int i=1; i<len; i++){
            if(i%2==0 && A.get(i-1)>A.get(i))
                swap(A,i-1,i);
            if(i%2==1 && A.get(i-1)<A.get(i))
                swap(A,i-1,i);
        }
        
        return A;
    }
    
    public static void swap(ArrayList<Integer> Arr, int i, int j){
        int temp=Arr.get(i);
        Arr.set(i,Arr.get(j));
        Arr.set(j,temp);
    }
}

*/




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
