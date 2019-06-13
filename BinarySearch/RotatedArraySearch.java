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
public class RotatedArraySearch {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> A, int target) {
        
        int n = A.size();
        int A0=A.get(0);
        int low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(A.get(mid) == target) 
                return mid;
            else 
                if(A0<=A.get(mid)){//i.e. left part is sorted
                if(A0<=target && target < A.get(mid)) 
                    high = mid-1;//B lies on left part
                else 
                    low = mid+1;
            }
            else{//right part is sorted
                if(A.get(mid) < target && target<=A.get(n-1)) 
                    low = mid+1;//B lies on right part
                else    
                    high = mid-1;
            }
        }
        return -1;
    }
}

/*
Link-
https://www.interviewbit.com/problems/rotated-sorted-array-search/
Notes-
https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

*/