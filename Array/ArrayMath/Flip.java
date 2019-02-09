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
public class Flip {
    public ArrayList<Integer> flip(String A) {
        int oneCount = 0;
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int maxLeft = -1;
        int maxRight = -1;
        int maxDiff = 0;
        
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') zeroCount++;
            if (A.charAt(i) == '1') oneCount++;
            
            if (zeroCount - oneCount < 0) {
                left = i + 1;
                right = i + 1;
                zeroCount = 0;
                oneCount = 0;
            } else {
                if (zeroCount - oneCount > maxDiff) {
                    maxLeft = left;
                    maxRight = right;
                    maxDiff = zeroCount - oneCount;
                }
                right++;
            }
        }
        
        if (maxLeft >= 0) {
            ArrayList<Integer> maxChangeCoordinates = new ArrayList<Integer>(2);
            maxChangeCoordinates.add(maxLeft + 1);
            maxChangeCoordinates.add(maxRight + 1);
            return maxChangeCoordinates;
        }
        return new ArrayList<Integer>();
    }
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/flip/
NOTES:
*/
