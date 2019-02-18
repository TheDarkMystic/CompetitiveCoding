/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.BinarySearch;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> a, int b) {
	    //classic Binary Search
	    
	    int len= a.size();
        
        int start=0;
        int end=len-1;
        
        int mid=0;
        
        while(start<=end){
            
            mid=(start+end)/2;
            if(a.get(mid)==b)   return mid;
            
            if(a.get(mid)>b) 
                end=mid-1;
            else
                start=mid+1;
        }
        return start;
        
	}
}
