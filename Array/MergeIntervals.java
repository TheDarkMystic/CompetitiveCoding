/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.ValueRanges;

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
    /*
    There are 3 cases:
    1. the start value of the newInterval < the old interval end: insert the 
    old interval and increment the index as we will know where this newInterval 
    should be inserted.
    
    2.the start value of the old interval > newInterval end: we simply insert the 
    old interval as there is no effect on where the newInterval should be inserted.
    
    3.Otherwise, we need to merge the interval, simply be getting the min of start 
    and max of end value.
    
    */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, 
    Interval newIntr) {
        
        ArrayList<Interval> res= new ArrayList<Interval>();
        for(Interval current: intervals){
            if(newIntr==null || current.end<newIntr.start ){//case 1
                res.add(current);
            }
            else if(current.start>newIntr.end){//case 2
                res.add(newIntr);
                res.add(current);
                newIntr=null;
            }
            else{//case 3: overlap found
                newIntr.start= Math.min(current.start, newIntr.start);
                newIntr.end=Math.max(current.end, newIntr.end);
            } 
        }
        
        if(newIntr!=null)
            res.add(newIntr);
    return res;
    }
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/merge-intervals/

NOTES:
https://discuss.leetcode.com/topic/12691/short-java-code


Variant
https://leetcode.com/problems/merge-intervals/#/solutions
*/
