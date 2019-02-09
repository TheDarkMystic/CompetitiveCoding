/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.Bucketing;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class TripletsWithSumBetweenGivenRange {
    public int solve(ArrayList<String> A) {
        int n = A.size();
        double[] arr = new double[n];
        for(int i=0; i<n; i++) {
            arr[i] = Double.valueOf(A.get(i));
        }
        double a=arr[0], b=arr[1], c=arr[2];
        for(int i=3 ; i<n ; i++){
            // check if sum fall in (1, 2)
            if(a+b+c > 1 && a+b+c < 2){
                return 1;
            }
            // if not, then check is sum greater than 2
            // if so, then replece MAX(a,b,c) to new number
            else if(a+b+c > 2){
                if(a>b && a>c){
                    a = arr[i];
                }
                else if(b>a && b>c){
                    b = arr[i];
                }
                else if(c>a && c>b){
                    c = arr[i];
                }
            }
            // else then sum must be less than 1
            // then replace MIN(a,b,c) to new number
            else{
                if(a<b && a<c){
                    a = arr[i];
                }
                else if(b<a && b<c){
                    b = arr[i];
                }
                else if(c<a && c<b){
                    c = arr[i];
                }
            }
        }
        // check for last a, b, c  triplet
        if(a+b+c > 1 && a+b+c < 2){
            return 1;
        }
        else{
            return 0;
        }
    }
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
NOTES:
*/
