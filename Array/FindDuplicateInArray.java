/*
Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using 
less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1
 */
package interviewprep.Array.Arrangement;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class FindDuplicateInArray {

    public int repeatedNumber(final List<Integer> a) {
        /*
        -   Questions to ask in similar problems.
        -   1. Does the array have -ve nums or 0.
        -   2. How many numbers can repeat and how many times they can repeat.
        -   3. Does the Sequence of output matters
        -   4. Is it ok to modify the input, if extra space usage is not allowed.
         */

        //Approach 1: Since input is read only, use a Set. It will take O(n) space
        Set<Integer> set = new HashSet<Integer>();

        for (int num : a) {
            if (set.contains(num) == true) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
        /*  
        //Approach 2: Maintaining a Boolean array for tracking
        boolean[] arr = new boolean[a.size()];
        for(int i = 0 ; i < a.size() ; i ++){
           int tmp = a.get(i)-1;
           if(arr[tmp]==true){
               return tmp+1;
           }else{
           arr[tmp] = true ; 
           }
        }
        return -1;
         */
    }
}

/*
ProblemURLs:
I-https://www.interviewbit.com/problems/find-duplicate-in-array/
L-https://leetcode.com/problems/find-the-duplicate-number/
 */
