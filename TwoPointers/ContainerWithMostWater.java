/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.TwoPointers;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class ContainerWithMostWater {
    public int maxArea(ArrayList<Integer> A) {
        int len=A.size();
        if(len==0 || len==1)
            return 0;
        
        
        int left=0;
        int right=len-1;
        int maxArea=Integer.MIN_VALUE;
        while(left<right){
            int curArea=Math.min(A.get(left), A.get(right))*(right-left);
            maxArea=Math.max(maxArea,curArea);
            
            if(A.get(left)<A.get(right))
                left++;
            else right--;
        }
        
        return maxArea;
    }
}
/*
Links-
https://www.interviewbit.com/problems/container-with-most-water/
Notes-
https://www.youtube.com/watch?v=TI3e-17YAlc


https://leetcode.com/problems/container-with-most-water/discuss/6089/Anyone-who-has-a-O(N)-algorithm/7268
Here is the proof.
Proved by contradiction:

Suppose the returned result is not the optimal solution. Then there must exist an optimal solution, say a container with a_ol and a_or (left and right respectively), such that it has a greater volume than the one we got. Since our algorithm stops only if the two pointers meet. So, we must have visited one of them but not the other. WLOG, let's say we visited a_ol but not a_or. When a pointer stops at a_ol, it won't move until

The other pointer also points to a_ol.
In this case, iteration ends. But the other pointer must have visited a_or on its way from right end to a_ol. Contradiction to our assumption that we didn't visit a_or.

The other pointer arrives at a value, say a_rr, that is greater than a_ol before it reaches a_or.
In this case, we does move a_ol. But notice that the volume of a_ol and a_rr is already greater than a_ol and a_or (as it is wider and heigher), which means that a_ol and a_or is not the optimal solution -- Contradiction!

Both cases arrive at a contradiction.




http://www.programcreek.com/2014/03/leetcode-container-with-most-water-java/

https://leetcode.com/articles/container-most-water/

https://www.youtube.com/watch?v=fZJrY9zpVVQ
*/