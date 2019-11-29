/*
 Give a N*N square matrix, return an array of its anti-diagonals. Look at the 
 example for more details.

Example:
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]

Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]

 */
package interviewprep.Array.SimulationArray;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class AntiDiagonals {

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> res
                = new ArrayList<ArrayList<Integer>>();

        //property of antidiagonal ele is for each ele in the same anti-diag
        //sum of row+col is same
        int row = a.size();
        int col = a.get(0).size();
        
        //initilize the ans list of lists with empty placeholders
        for (int i = 0; i < row + col - 1; i++) {
            res.add(new ArrayList<Integer>());
        }
        
        //populate the result list
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res.get(i + j).add(a.get(i).get(j));
            }
        }

        return res;
    }
}

/*
ProblemUrls:
I-https://www.interviewbit.com/problems/anti-diagonals/
NOTES:
easy

http://qa.geeksforgeeks.org/4151/return-an-array-of-all-the-anti-diagonals 

second solution
 */
