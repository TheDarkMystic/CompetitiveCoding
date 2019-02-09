package interviewprep.Array;

/**
 *
 * @author jakadam
 */
import java.util.ArrayList;
public class FirstMissingInteger {
    public int firstMissingPositive(ArrayList<Integer> a) {
        
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
}

/*
NOTES:
R1-https://discuss.leetcode.com/topic/8293/my-short-c-solution-o-1-space-and-o-n-time
R2-http://javadevnotes.com/java-list-to-array-examples
S1-https://leetcode.com/problems/first-missing-positive/submissions/
*/
