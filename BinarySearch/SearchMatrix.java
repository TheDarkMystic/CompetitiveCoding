/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

 */
package interviewprep.BinarySearch;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class SearchMatrix {
    public int searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        
        if(mat==null || mat.size()==0)
            return 0;
        
        int numRows=mat.size();
        int numCols=mat.get(0).size();
        
        int left=0;
        int right=numRows*numCols-1;
        
        while(left<=right){
            int mid=(left+right)/2;
            
            int num=mat.get(mid/numCols).get(mid%numCols);
            
            if(num==target)
                return 1;
            else if(num>target)
                right=mid-1;
            else    
                left=mid+1;
        }
        
        return 0;
        
    }
}
/*
Links-
https://discuss.leetcode.com/topic/3227/don-t-treat-it-as-a-2d-matrix-just-treat-it-as-a-sorted-list/7

Notes-
https://discuss.leetcode.com/topic/3227/don-t-treat-it-as-a-2d-matrix-just-treat-it-as-a-sorted-list/7

*/