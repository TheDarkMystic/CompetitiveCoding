/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.SimulationArray;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int a) {
	    int numRows=a;
	    
	    ArrayList<ArrayList<Integer>> triangle= new ArrayList<ArrayList<Integer>>();
	    
	    
	    for(int i=0; i<numRows; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();	 //position of this statement is critical
            // for every row create a new arrayList
            //no of eles in a row == row no.
            //eg. 3rd row contains 3 eles
            for(int j=0; j<i+1; j++){
	            if(j==0 || j==i)    
	                row.add(1);
	            else
	                row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
	        }
	        triangle.add(new ArrayList<Integer>(row));
	    }
	    
	    return triangle;
	}
}


/*
ProblemUrls:
I-https://www.interviewbit.com/problems/pascal-triangle/
NOTES:
https://discuss.leetcode.com/topic/5128/solution-in-java

http://www.geeksforgeeks.org/pascal-triangle/

logic is same as traditional generation of pascal triangle
*/
