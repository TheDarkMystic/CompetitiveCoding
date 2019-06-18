/*
 * There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Sample Input :

Ratings : [1 2]
Sample Output :

3
The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its 
neighbor. So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
 */
package interviewprep.Greedy;

/**
 *
 * @author jakadam
 */


import java.util.*;
public class Candies {
    public int candy(ArrayList<Integer> A) {
        int n=A.size();
        int[] candies=new int[n];
        //start by assigning 1 candy to all
        Arrays.fill(candies,1);
        
        // scan left to right and assign candies in ascending order
        for(int i=0;i<n-1;i++){
            if(A.get(i+1)>A.get(i))
                candies[i+1]=candies[i]+1;
        }
        
        //scan right to left and assign candies in ascending order
        for(int i=n-1;i>0;i--){
            if(A.get(i-1)>A.get(i) && candies[i-1]<=candies[i])
                candies[i-1]=candies[i]+1;
        }
        
        //count total number of candies
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=candies[i];
        }
        return sum;
    }
    
}

/*
Link-
https://www.interviewbit.com/problems/distribute-candy/
Notes-
https://leetcode.com/problems/candy/#/solutions

http://www.programcreek.com/2014/03/leetcode-candy-java/
*/
