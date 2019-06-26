/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.BitManipulation;

/*
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. 
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The 
first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) 
uch that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) + 
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8
 */

/**
 *
 * @author jakadam
 */


/**
 * A Simple Solution is to run two loops to consider all pairs one by one. For every pair, 
 * count bit differences. Finally return sum of counts. Time complexity of this solution is O(n2).

*An Efficient Solution can solve this problem in O(n) time using the fact that all numbers are 
* represented using 32 bits (or some fixed number of bits). The idea is to count differences at 
* individual bit positions. We traverse from 0 to 31 and count numbers with i’th bit set. Let this 
* count be ‘count’. There would be “n-count” numbers with i’th bit not set. So count of differences 
* at i’th bit would be “count * (n-count) * 2”, the reason for this formula is as every pair having one
* element which has set bit at i’th position and second element having unset bit at i’th position 
* contributes exactly 1 to sum, therefore total permutation count will be count*(n-count) and multiply 
* by 2 is due to one more repetition of all this type of pair as per given condition for making pair 
* 1<=i,j<=N.

Below is implementation of above idea.

 */
import java.util.*;
public class DiffBitsSumPairwise {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    //This is a duplicate problem of "SumOfPairWiseHammingDist"
    public int hammingDistance(final List<Integer> A) {
        int len=A.size();
        int hamDist=0;
        
        for(int i=0; i<31; i++){
            int oneCnt=0;
            for(int j=0; j<len; j++){
                int num=A.get(j);
                oneCnt += (num & 1 << i) != 0? 1 : 0;
            }
            int zeroCnt = len - oneCnt;
            hamDist +=  (2L * oneCnt * zeroCnt) % 1000000007;
            hamDist = hamDist%1000000007;
        }
        return hamDist;
    }
}



/*
Link-
https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
Notes-
https://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/
*/