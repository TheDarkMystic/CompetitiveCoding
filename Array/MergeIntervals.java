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

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class MergeIntervals {

    /*
    There are 3 cases:
    1. the start value of the newInterval > the old interval end: insert the 
    old interval and increment the index as we will know where this newInterval 
    should be inserted.
    
    2.the start value of the old interval > newInterval end: we simply insert the 
    old interval as there is no effect on where the newInterval should be inserted.
    
    3.Otherwise, we need to merge the interval, simply be getting the min of start 
    and max of end value.
    
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals,
            Interval newIntr) {

        ArrayList<Interval> res = new ArrayList<Interval>();
        for (Interval current : intervals) {
            if (newIntr == null || current.end < newIntr.start) {//case 1
                res.add(current);
            } else if (current.start > newIntr.end) {//case 2
                res.add(newIntr);
                res.add(current);
                newIntr = null;
            } else {//case 3: overlap found
                newIntr.start = Math.min(current.start, newIntr.start);
                newIntr.end = Math.max(current.end, newIntr.end);
            }
        }

        if (newIntr != null) {
            res.add(newIntr);
        }
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
