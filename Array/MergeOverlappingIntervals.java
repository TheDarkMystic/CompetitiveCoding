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

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> a) {
    
        Collections.sort(a, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start-i2.start;
            }
        });
        
 
		int start =a.get(0).start;
		int end = a.get(0).end;
		
		ArrayList<Interval> res = new ArrayList<Interval>();
		
		int size=a.size();
		for(int i=1; i<size; i++){
			
			Interval cur=a.get(i);
			if(cur.start<=end)
				end=Math.max(cur.end, end);
			else{
    				res.add(new Interval(start, end));
    				start=cur.start;
    				end=cur.end;
			}
		}
		res.add(new Interval(start, end));
        return res;
    }
}

 
class IntComparator implements Comparator{
 
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Interval i1 = (Interval)o1;
		Interval i2 = (Interval)o2;
		
		
		return i1.start - i2.start;
	}
	
}



/*
ProblemUrls:
I-https://www.interviewbit.com/problems/merge-overlapping-intervals/
NOTES:
https://discuss.leetcode.com/topic/12788/a-clean-java-solution/5

Comparator videos of durga and Trever page
https://www.youtube.com/watch?v=JSvVsOm4oX0&t=1572s


https://www.youtube.com/watch?v=JSvVsOm4oX0&t=1572s

Beautiful solution

*
*/
