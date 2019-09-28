/*
Given an array with n objects colored red, white or blue, 
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]

 */
package interviewprep.TwoPointers;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class SortByColor {
    public void sortColors(ArrayList<Integer> a) {
        //Alternative approaches
        //1. Sort array -> O(nLogn) time
        //2. create 3 seperate arrays and merge-> O(n) time and space
        int len= a.size();
        
        int lo=0,
            mid=0,
            hi=len-1;
        
        int temp=0;//for swapping
        while(mid<=hi){ //condition is important
            int key=a.get(mid);
            
            switch(key){
                case 0:
                        temp=a.get(lo);
                        a.set(lo,a.get(mid));
                        a.set(mid,temp);
                        lo++;
                        mid++;
                        break;
                case 1:
                        mid++;
                        break;
                case 2:
                        temp=a.get(hi);
                        a.set(hi,a.get(mid));
                        a.set(mid, temp);
                        hi--;
                        break;
            } 
        }
    }
}
/*
links-
https://www.interviewbit.com/problems/sort-by-color/
notes-
AKA Dutch flag problem

Best Explanation
http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
*/