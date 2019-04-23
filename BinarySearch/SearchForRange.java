/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4]. 
*/
package interviewprep.BinarySearch;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class SearchForRange {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> searchRange(final List<Integer> list, int target) {
        
        int first=searchHelper(list, target, true);
        int last=searchHelper(list, target, false);
        
        ArrayList<Integer> res= new ArrayList<Integer>();
        
        res.add(first);
        res.add(last);
        
        return res;
        
    }
    
    public int searchHelper(List<Integer> list, int target, Boolean searchFirst){
        int len=list.size();
        int start=0, end=len-1;
        int result=-1;
        while(start<=end){
            int mid=(start+end)/2;
            int num=list.get(mid);
            if(num==target){
                
                result=mid;
                
                if(searchFirst==true)// go on searching towards left
                    end=mid-1;
                else
                    start=mid+1;// go on searching towards right
                
            }
            else if(num<target)
                start=mid+1;
            else
                end=mid-1;
        }
        
        return result;
    }
}

/*
Link-https://www.interviewbit.com/problems/search-for-a-range/
Notes-https://www.youtube.com/watch?v=pLT_9jwaPLs
*/
