/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
notes-
AKA Dutch flag problem

Best Explanation
http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
*/