import java.util.ArrayList;
/**
You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

 *  maximize |A[i] - A[j]| + |i - j|
 *  max( A[i] +i - A[j] +j)
 *  max( (A[i]+i) - (A[j]-j) )
 **/
public class MaxAbsoluteDifference {
    public int maxArr(ArrayList<Integer> A) {
        int tempSum = -1, tempDiff = -1;
        int minOfSum = Integer.MAX_VALUE, minOfDiff = Integer.MAX_VALUE;
        int maxOfSum = Integer.MIN_VALUE, maxOfDiff = Integer.MIN_VALUE;

        for(int i = 0; i < A.size(); i++){
            // Calculating Min and Max values for A[i] + i
            tempSum = A.get(i) + i;

            if(tempSum > maxOfSum){
                maxOfSum = tempSum;
            }
            if(tempSum < minOfSum){
                minOfSum = tempSum;
            }
            // Calculating Min and Max values for A[i] - i
            tempDiff = A.get(i) - i;
            if(tempDiff > maxOfDiff){
                maxOfDiff = tempDiff;
            }
            if(tempDiff < minOfDiff){
                minOfDiff = tempDiff;
            }
        }
        return Math.max((maxOfSum - minOfSum), (maxOfDiff - minOfDiff));
    }
}


/**
 * Notes:
 * 
Sol1- Sort the array and find the ans. O(nlogn)
Sol2- O(n)

|A[i] - A[j]| + |i - j|

Case1 :A[i]<A[j]             i<j
           A[j]-A[i] + j-i      
           (A[j]+j) - (A[i]+i)

Case2: A[i]>A[j]             i<j
           A[i]-A[j] + j-i      
           (A[i]-i) - (A[j]-j)

Case3: A[i]<A[j]             i>j
           A[j]-A[i] + i-j     
           (A[j]-j) - (A[i]-i)

Case4: A[i]>A[j]             i>j
           A[i]-A[j] + i-j     
           (A[i]+i) - (A[j ]+j)

Case 1 and 4 equations are identical just the i and j are interchanged, same is the case with case 2 and 3.
So, we have only 2 equations in total-> 
(A[i] + i ) - (A[j] + j )
(A[i]  - i ) - (A[j] - j )

so we have to calculate only 2 terms ( A[i] + i ) and ( A[i] - i )
 */