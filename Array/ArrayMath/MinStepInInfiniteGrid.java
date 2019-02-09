/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int ans=0;
        int len=X.size();
        for(int i=1;i<len;i++)
            ans=ans+Math.max(
                                Math.abs(X.get(i)-X.get(i-1)),
                                Math.abs(Y.get(i)-Y.get(i-1))
                            );
        return ans;
    }   
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/min-steps-in-infinite-grid/

NOTES:
https://interviewbitsolutions.blogspot.in/2016/05/min-steps-in-infinite-grid-problem-you.html
*/
