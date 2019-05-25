/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Greedy;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class HighestProduct {
    public int maxp3(ArrayList<Integer> A) {
        /*
        Taget is to find the largest 3 elements in the array.
        Array may contain negative elements
        sol:
        -Sort the array, calculate product of first 3 eles and last 3 eles
        -return the maximum.
        */
        
        Collections.sort(A);
        
        int firstThreeEleProd=A.get(0)*A.get(1)*A.get(A.size() - 1);
        int lastThreeEleProd=A.get(A.size() - 3)*A.get(A.size() - 2)*A.get(A.size() - 1);
       
        return Math.max(firstThreeEleProd,lastThreeEleProd);
    }
}
/*
Link-
https://www.interviewbit.com/problems/highest-product/
Note-
Solution Section Editorial

*/