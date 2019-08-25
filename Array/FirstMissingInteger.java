package interviewprep.Array.MissingRepeatedNumber;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> A) {
    //Approach 1:Put each number in its right place.
    /*  
        Put each number in its right place.

        For example:

        When we find 5, then swap it with A[4].

        At last, the first place where its number is not right, return the place + 1.
        int len= a.size();
        Integer[] A= a.stream().toArray(Integer[] :: new);
        
        for(int i=0; i<len; i++){
            //check boundaries and duplicates handling
            while(A[i]>0 && A[i]<=len &&   A[  A[i]-1    ]!=A[i]   ){
                //swap A[i] with A[ A[i]-1   ]
                int temp        =   A[  A[i]-1  ];
                A[  A[i]-1  ]   =   A[i];
                A[i]            =   temp;
            }
        }
        
        //traverse the array to find missing element
        for(int i=0; i<len; i++){
            if(A[i] != i+1)
                return i+1;
        }
        
        return len+1;
	}
    */

    // Approach 2: Using Input array as tracker
   
    /*
        1.The -ve's & 0's in the array are of no use to us. We can replace them with some large 
            +ve num( Here abs(Max(A)) )
        2.Then when you find a +ve num in array, mark the indx as -ve.
            eg. if you find 3, mark the element presne at the 3rd index in array -ve
            This will work as a flag stating that we have encountered the num in array.
        3. Traverse the array and find first positive element in array. return the indx+1 as ans.
       */ 
        
        // Implementing step 1
        int lenA=A.size();
        int inf=Math.abs(Collections.max(A))+1;
        
        for(int i=0; i<lenA; i++){
            if(A.get(i)<=0)
                A.set(i,inf);
        }
        
        // Implementing step 2

        for(int i=0; i<lenA; i++){
            int flag=Math.abs(A.get(i))-1;
            if(flag<lenA && flag>=0 && A.get(flag)>0)
                A.set(flag,-1*A.get(flag));
        }
        
        
       // Implementing step 3

        for(int i=0; i<lenA; i++){
            if(A.get(i)>0)
                return i+1;
        }
        
        
        // if no element is missing the next element is arrayLen+1. Hence return.
        return lenA+1;
    }
}

/*
ProblemURLS:
I-https://www.interviewbit.com/problems/first-missing-integer/
L-https://leetcode.com/problems/first-missing-positive/
NOTES:
R1-https://discuss.leetcode.com/topic/8293/my-short-c-solution-o-1-space-and-o-n-time
R2-http://javadevnotes.com/java-list-to-array-examples
S1-https://leetcode.com/problems/first-missing-positive/submissions/
*/
