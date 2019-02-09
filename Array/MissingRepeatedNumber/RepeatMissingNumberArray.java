/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.MissingRepeatedNumber;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class RepeatMissingNumberArray {
    
    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    int arraySize = a.size();
	    long sumOfNumbers = getSumOfNumbers(arraySize);
	    long sumOfSquares = getSumOfSquares(arraySize);
	    long differenceNumber =  getDifferenceofNumbers(a,sumOfNumbers);
	    long differenceSquare = getDifferenceofSquares(a,sumOfSquares);
	    long sumNumber =  differenceSquare/differenceNumber;
	    int repeatedNumber = (int)((sumNumber+differenceNumber)/2);
	    int missingNumber = (int)(sumNumber-repeatedNumber);
	    ArrayList<Integer> result = new ArrayList<>();
	    result.add(repeatedNumber);
	    result.add(missingNumber);
	    return result;
	}
	
	private long getDifferenceofNumbers(List<Integer> a,long sumOfNumbers){
	    long sum = sumOfNumbers*-1;
	    for(Integer number:a){
	        long num = (long)number;
	        sum+=num;;
	    }
	    return sum;
	}
	
	private long getDifferenceofSquares(List<Integer> a, long sumOfSquares){
	    long sumSquares = sumOfSquares*-1;
	    for(Integer number:a){
	         long num = (long)number;
	        sumSquares+=(num*num);
	    }
	    return sumSquares;
	}
	
	private long getSumOfNumbers(double n){
	    return (long)(n*(n-1)/2+n);
	}
	
	private long getSumOfSquares(double n){
	    return (long)(n*(n+1)*(2*n+1)/6);
	}
    
}
/*
ProblemURLs:
I-https://www.interviewbit.com/problems/repeat-and-missing-number-array/

NOTES:
problem in the judge
correct solution but complexity not accepted.

It is O(N). Many people complained in comment.


https://leisurehours.wordpress.com/2009/08/13/one-duplicate-one-missing-element-in-an-array/


http://www.geeksforgeeks.org/?p=11946/comment-page-1#comment-3796

Working solution in Python( if Java Solution Fails due to casting issues)

class Solution:
    # @param A : tuple of integers
    # @return a list of integers
    def repeatedNumber(self, A):
        sumOfA = 0
        sumOfA2 = 0
        n = 0
        for a in A:
            sumOfA2 += a*a
            sumOfA += a
            n += 1
        sumOfN = n*(n+1)/2
        retA = sumOfN - sumOfA
        
        retB = (sumOfN*(2*n+1)/3 - sumOfA2)/retA
        x = (retB-retA)/2
        return [x,x + retA]




*/