/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Adhoc.Heap;

/**
 *
 * @author jakadam
 */
/*
Given an array of n elements, where each element is at most k away from its target position, 
devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element at 
index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

Examples:

Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
            k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
         k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}

*/
import java.util.*;

public class SortKSortedArray {

    /**
     * @param args the command line arguments
     */
    public int[] sortNearlySortedArray(int[] arr, int k) {
        /*
        Idea is to maintain a min-heap and at a time keep k elements in the heap. Poll the min element 
        place it in the sorted array and then add next element from given array to heap... 
        keep repeating...
        */
        
        PriorityQueue<Integer> minHeap= new PriorityQueue<Integer>();
        int len = arr.length;
        
        //add first k elements to the heap from 0 to k-1
        // make sure there are more elements in array than k
        for(int i=0; i<k && i<len; i++){
            minHeap.add(arr[i]);
        }
        
        
        /*
        1. add element to heap
        2. poll min ele from heap and put it in the sorted array
        3. add next element from given array to heap 
        4. repleat from step 2 until given array is finished 
        5. now add remaining ele from heap to sorted array one by one
        */
        
        int readIndx=k;
        int writeIndx=0;
        
        while(readIndx<len){
            minHeap.add(arr[readIndx]);
            
            arr[writeIndx]=minHeap.poll();
            
            readIndx++;
            writeIndx++;
        }
        
        
        // array isfinished
        // poll minheap
        while(minHeap.isEmpty()==false){
            arr[writeIndx]=minHeap.poll();
            
        }
        
        return arr;
    }
    
    
}
/*
Links-https://www.geeksforgeeks.org/nearly-sorted-algorithm/
Notes-
https://github.com/bephrem1/backtobackswe/blob/master/Sorting%2C%20Searching%2C%20%26%20Heaps/sortAnAlmostSortedArray.java
https://www.youtube.com/watch?v=yQ84lk-EXTQ
*/