/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.StackQueues;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class RainWaterTrapped {
    public int trap(final List<Integer> A) {
        
        //idea is to calculate water level above each individual wall
        //among rightmax or leftmax wall whichever is smaller use that as boundary

        int len= A.size();
       
        //Following 2 arrays track tallest to left and right of cur, respectively
        int[] tallestToLeft = new int[len];
        int[] tallestToRight = new int[len];
        
        //Tracking leftmax
        int maxToLeft=0;
        for(int i=0; i<len; i++){
             tallestToLeft[i]=maxToLeft;
            if(A.get(i)>=maxToLeft)
                maxToLeft=A.get(i);
        }
        
        //Tracking rightMax
        int maxToRight=0;
        for(int i=len-1; i>=0; i--){
            tallestToRight[i]=maxToRight;
            if(A.get(i)>=maxToRight)
                maxToRight=A.get(i);
        }
        
        //Calculating Water Content
        int waterQnt=0;
        for(int i=0; i<len; i++){
            waterQnt=waterQnt+ Math.max(0, Math.min(tallestToRight[i],tallestToLeft[i])-A.get(i));
        }
        
        
        return waterQnt;
    }
}

/*
Links-
https://www.interviewbit.com/problems/rain-water-trapped/

Notes-
https://leetcode.com/problems/trapping-rain-water/solution/

latest solution easy to remember
https://www.youtube.com/watch?v=UzeL2GcLx3Y


complete sulution java section has a stack based solution
*/