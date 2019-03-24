/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.DP.Classic;

/**
 *
 * @author jakadam
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LCS {

    // Complete the longestCommonSubsequence function below.
    static int[] longestCommonSubsequence(int[] a, int[] b) {
        int lenA=a.length;
        int lenB=b.length;

        int[][] dp= new int[lenA+1][lenB+1];

        for(int i=0; i<lenA+1; i++){
            for(int j=0; j<lenB+1; j++){
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(a[i-1]==b[j-1])
                        dp[i][j]= 1+dp[i-1][j-1];
                    else   
                        dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int ansLen=dp[lenA][lenB];
        int[] ans=new int[ansLen];
        
        //Reverse tracking explained. Please Pay attention.
        // WATCH GFG vid linked below.
        int i=lenA;
        int j=lenB;
        int indx=ansLen;
        // Start from the right-most-bottom-most corner and 
        // one by one store characters in dp[] 
        while(i>0 && j>0){
            // If current character in a[] and b[] are same, then 
            // current character is part of LCS 
            if(a[i-1]==b[j-1]){
                // Put current character in result
                ans[indx-1]=a[i-1];
                // reduce values of i, j and index
                i--;
                j--;
                indx--;
            }
            else{
                    // If not same, then find the larger of two and 
                    // go in the direction of larger value 
                    if(dp[i-1][j]>dp[i][j-1])
                        i--;
                    else 
                        j--;
            }
        }
        
        
    return ans;

      


    }
    /*
    Link-
        https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
    Notes-
        https://www.youtube.com/watch?v=ASoaQq66foQ
        https://www.geeksforgeeks.org/printing-longest-common-subsequence/
        
        All possible ways to solve LCS (w/ O(n) sol)
        https://leetcode.com/problems/delete-operation-for-two-strings/solution/

    
    */
    
    // driver code [Skip it!]

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b[i] = bItem;
        }

        int[] result = longestCommonSubsequence(a, b);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
