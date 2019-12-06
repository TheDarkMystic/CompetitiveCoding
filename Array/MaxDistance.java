package interviewprep.Array.ArrayMath;

import java.util.List;
public class MaxDistance {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        /*
        
        we construct two auxiliary arrays LMin[] and RMax[] such that LMin[i] holds the 
        smallest element on left side of arr[i] including arr[i], and RMax[j] holds the 
        greatest element on right side of arr[j] including arr[j]. 
        
        After constructing these two auxiliary arrays, we traverse both of these arrays 
        from left to right. While traversing LMin[] and RMa[] if we see that LMin[i] is 
        greater than RMax[j],then we must move ahead in LMin[] (or do i++) because all 
        elements on left of LMin[i] are greater than or equal to LMin[i]. 
        Otherwise we must move ahead in RMax[j] to look for a greater j-i value.
        
        */
        
        //Step 1 : Create Auxiliary array
        int len=A.size();
        
        int lmin[] =new int[len];
        int rmax[] =new int[len];
        
        //Step 2 :Populate Auxiliary Arrays
        lmin[0]=A.get(0);
        for(int i=1; i<len; i++)
            lmin[i]=Math.min(lmin[i-1],A.get(i));
                
        
        rmax[len-1]=A.get(len-1);
        for(int i=len-2; i>=0; i--)
            rmax[i]=Math.max(rmax[i+1],A.get(i));
            
        
        //Step 3 : Traverse the Aux Arrays
        int i=0,j=0;
        //if ans is not found, return -1. Hence init maxDist with -1
        int maxDist=-1;
        while(i<len && j<len){
            if(lmin[i]<=rmax[j]){
                maxDist=Math.max(j-i, maxDist);
                j++;
            }
            else
                i++;
                
        }
        
        return maxDist;
        
    }
}

/*
Links-https://www.interviewbit.com/problems/max-distance/
Notes-
http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
Eg.

Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
lmin=  [34, 8, 8,  3, 2, 2,   2,  2,  1]
rmax= [80, 80, 80, 80, 80,80,33, 33, 1]
Output: 6  (j = 7, i = 1)

Input:  3, 2, 1
lmin=[3, 2, 1]
rmax=[3, 2, 1]
output:0

*/

