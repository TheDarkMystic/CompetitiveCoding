/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */



import java.util.*;
//Definition for an interval.
class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
 

public class MergeIntervals {
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInt) {
    /*
    There are 3 cases:
    1. if start of newInterval <  end of cur interval :
        insert the cur interval 
    
    2. if start of cur interval > end of newInterval : 
        we simply insert the cur interval as there is no effect on where the newInterval 
        should be inserted.
    
    3.Otherwise, we need to merge the interval, simply be getting the min of start 
    and max of end value.
    
    */
        
        ArrayList<Interval> ans= new ArrayList<Interval>();
        
        for(Interval cur : intervals){
            
            if(newInt==null || cur.end<newInt.start){
                //newInt==null indicates, newInt has already been added
                ans.add(cur);
            }
            else if(newInt.end<cur.start){
                    ans.add(newInt);
                    ans.add(cur);
                    newInt=null;
                }
                else{
                    newInt.start=Math.min(cur.start,newInt.start);
                    newInt.end=Math.max(cur.end, newInt.end);
                }
        }
        
        if(newInt!=null)
            ans.add(newInt);
        
        return ans;
    }
}


/*
Link-
https://www.interviewbit.com/problems/merge-intervals/
Notes-
https://discuss.leetcode.com/topic/12691/short-java-code

Variant
https://leetcode.com/problems/merge-intervals/#/solutions
*/