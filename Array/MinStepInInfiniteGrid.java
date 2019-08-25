/*
 You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Input :

Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
Output :

Return an Integer, i.e minimum number of steps.
Example :

Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 */
package interviewprep.Array.ArrayMath;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class MinStepInInfiniteGrid {
    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    /*
    One way to reach form a point (x1,y1) to (x2, y2) is to move abs(x2-x1) steps in horizontal direction 
    and abs(y2-y1) steps in vertical direction, but this is not the shortest path to reach (x2,y2). 
    The best way would be to cover the maximum possible distance in diagonal direction and remaining in 
    horizontal or vertical direction. If we look closely this just reduces to maximum of abs(x2-x1) and 
    abs(y2-y1).
    */
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int result=0;
        int lenA=A.size();
        int lenB=B.size();
        
        if(lenA<=1)
            return 0;
        
        assert lenA==lenB : "Given Points NOT Correct!";
        
        for(int i=0;i<lenA-1;i++){
            result+=Math.max(
                Math.abs(A.get(i)-A.get(i+1)),
                Math.abs(B.get(i)-B.get(i+1))
                );
        }
        
        return result;
    }
}

      

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/min-steps-in-infinite-grid/

NOTES:
https://interviewbitsolutions.blogspot.in/2016/05/min-steps-in-infinite-grid-problem-you.html
*/
