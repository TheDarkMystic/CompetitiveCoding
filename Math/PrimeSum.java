/*
 * 
Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 

 */
package interviewprep.Math;

/**
 *
 * @author jakadam
 */


import java.util.*;
public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        /*
            -idea is to populate all prime numbers till A(using a sieve)
            -find 2 prime numbers leading to sum using sieve tracker
        */
        
        //create Eratosthenes sieve 
        boolean isPrime[]= new boolean[A+1];
        Arrays.fill(isPrime, true);
        isPrime[0]=false;
        isPrime[1]=false;
        
        for(int i=2;i<=Math.sqrt(A);i++){
            if(isPrime[i]==true){
                //strike out ]multiples of i
                for(int j=2; i*j<=A; j++)
                    isPrime[i*j]=false;
            }
        }
        
        //main logic- finding 2 prime numbers sum
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=2; i<=A; i++){
            if(isPrime[i]==true && isPrime[A-i]==true){
                ans.add(i);
                ans.add(A-i);
                return ans;
            }
        }
        
        return ans;
    }
}

/*
Link-
https://www.interviewbit.com/problems/prime-sum/
Notes-
Eratosthenese's sieve
https://www.youtube.com/watch?v=eKp56OLhoQs&t=5s
*/