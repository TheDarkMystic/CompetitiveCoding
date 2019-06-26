/*
Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Example

Let f(x, y) be the hamming distance defined above.

A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) + 
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) = 

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8
 */
package interviewprep.Math;

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
public class SumOfPairWiseHammingDist {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
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