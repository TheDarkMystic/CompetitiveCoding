/*
Given two arrays A & B of size N each.
Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.

For example if A = [1,2], B = [3,4], then possible pair sums can be 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
and maximum 2 elements are 6, 5

Example:

N = 4
a[]={1,4,2,3}
b[]={2,5,1,6}

Maximum 4 elements of combinations sum are
10   (4+6), 
9    (3+6),
9    (4+5),
8    (2+6)
 */
package interviewprep.HeapsAndMaps;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class NmaxPairCombo {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        /*
            1.  Sort both the arrays in descending order
            2.  Initialize a Maxheap
            3.  add the sum of elements to heap one by one till size reaches n
            4.  return the result
        */
        
        Collections.sort(A,Collections.reverseOrder());
        Collections.sort(B,Collections.reverseOrder());
        int n=A.size();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num1 : A){
            for(int num2 : B){
                int s = num1 + num2 ;
                if (pq.size()<n){
                    pq.add(s);
                } else {
                    if (s>pq.peek()){
                        pq.poll();
                        pq.add(s);
                    }else{
                        break;
                    }
                }
            }
        }
        
        ArrayList<Integer> ret = new ArrayList<>(pq);
        Collections.sort(ret,Collections.reverseOrder());
        return ret;
    }
}

/*
Links-
https://www.interviewbit.com/problems/n-max-pair-combinations/
Notes-
Logic mentioned in comments.
*/