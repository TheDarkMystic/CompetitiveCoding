/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.SpaceRecycle;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class SetMatrixZeros {
//    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
//	    boolean firstColZeros=false;
//	    int nrows=a.size(), ncols=a.get(0).size();
//	    
//	    //PHASE 1- detecting zeros and setting first col and row eles to zeros
//	    for(int i=0;i<nrows;i++){
//	        if(a.get(i).get(0)==0)//first column has zero
//	            firstColZeros=true;
//	        for(int j=1;j<ncols;j++){
//	            if(a.get(i).get(j)==0){
//	                a.get(0).set(j,0);//first row set to zero
//	                a.get(i).set(0,0);//first col set to zero
//	            }
//	                
//	        }
//	    }
//	    
//	    
//	    //PHASE2 setting matrix to zero
//	    // starting from end of the matrix to preserve indicators in 1st row and col
//	    for(int i=nrows-1; i>=0; i--){
//	        for(int j=ncols-1; j>=1; j--)// skip the first col, handle at end
//	        {
//	            if(a.get(0).get(j)==0|| a.get(i).get(0)==0)// one of the indicators is zero
//	                a.get(i).set(j,0);//set to zero
//	        }
//	        if(firstColZeros==true)
//	            a.get(i).set(0,0);//first col set to zero
//	    }
//	}
    
     public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int rowNum= a.size();
        int colNum= a.get(0).size();
        boolean firstRowZero=false;
        boolean firstColZero=false;
        
        //check first col for zeros
        for(int i=0; i<rowNum; i++){
            if(a.get(i).get(0)==0)
                firstColZero=true;
        }
        
        
        //check first row for zeros
        for(int i=0; i<colNum; i++){
            if(a.get(0).get(i)==0)
                firstRowZero=true;
        }
        //mark first row and first col as 0 if ele is 0
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
                if(a.get(i).get(j)==0){
                    a.get(i).set(0,0);
                    a.get(0).set(j,0);
                }
            }
        }
        //mark all rows and cols 0 if ele is 0
        for(int i=1; i<rowNum; i++){
            for(int j=1; j<colNum; j++){
               if(a.get(i).get(0)==0 || a.get(0).get(j)==0){
                   a.get(i).set(j,0);
               } 
            }
        }

        //mark first  row and col as 0
        if(firstRowZero){
            for(int i=0; i<colNum; i++){
                a.get(0).set(i,0);
                
            }
        }
        
        if(firstColZero){
            for(int i=0; i<rowNum; i++){
                a.get(i).set(0,0);
                
            }
        }
     }
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/set-matrix-zeros/

NOTES:
Easy to Understand Solution:
https://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/


https://www.youtube.com/watch?v=qWeNXOCff3o

https://discuss.leetcode.com/topic/5056/any-shorter-o-1-space-solution/2


Compact 1ms Solution
https://leetcode.com/submissions/detail/106054365/
*/