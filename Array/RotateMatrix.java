/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]
 */
package interviewprep.Array.Arrangement;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> A) {
	    
	    //revised code from leetcode
	    //Clockwise 90 degree
	    //step 1: reverse up to down 
	    Collections.reverse(A);
	    
	    //step 2: swap symmetrical elements
	    int nRows= A.size();
	    for(int i=0; i<nRows; i++)
	        for(int j=0; j<i; j++){
	            //swapping code
	            int temp= A.get(i).get(j);
	            A.get(i).set(j, A.get(j).get(i));
	            A.get(j).set(i, temp);
	            
	        }
	    
	    
	    
/*	    
	//THIS taken from Github anyway copied from CTCI
	//NOT TLE check the offset wala statement, that's the game changer
				   
	int n = A.size();
        if(n == 0)
            return;
        int layers = n;
        
        int row1, col1, row2, col2;*/
/*      int num;
        int temp;
        int first, last;
        for(int layer = 0; layer < layers/2; layer++){
            first = layer;
            last = n - layer - 1;
            
            for(int i = first; i < last; i++){
                int offset = i-layer;
                int top = A.get(first).get(i);
                               
                A.get(first).set(i, A.get(last-offset).get(first)); // topleft = bottomleft
                A.get(last-offset).set(first, A.get(last).get(last-offset));//bottomleft = bottomright
                A.get(last).set(last-offset, A.get(i).get(last));//bottomright = topright;
                A.get(i).set(last, top);
                
            }
        }
		 
		  */
	}
}


/*
ProblemURLs:
I-https://www.interviewbit.com/problems/rotate-matrix/

NOTES:

ignore following comments

//TIME LIMIT EXCEEDED IN THE CURRENT SOLUTION 196/300


Final code
 
	   //THIS taken from Github anyway copied from CTCI
	   //NOT TLE check the offset wala statement, that's the game changer
=================================

Start here

revised

very short solution from leetcode

https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image

and some simplifications added to it

*/