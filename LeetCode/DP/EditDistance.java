/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.LeetCode.DP;

/**
 *
 * @author jakadam
 */
public class EditDistance {
    public int minDistance(String A, String B) {
        int lenA= A.length();
        int lenB= B.length();
        
        int [][] minEdit= new int[lenB+1][lenA+1];
        //first column initialization;
        for(int i=0;i <lenB+1; i++){
            minEdit[i][0]=i;
        }
        //first row initialization;
         for(int i=0;i <lenA+1; i++){
            minEdit[0][i]=i;
        }
        
        
        for(int i=1; i<lenB+1; i++){
            for(int j=1; j<lenA+1; j++){
                if(B.charAt(i-1)==A.charAt(j-1))
                    minEdit[i][j]=minEdit[i-1][j-1];
                else
                    minEdit[i][j]=Math.min(Math.min(minEdit[i][j-1],minEdit[i-1][j]),minEdit[i-1][j-1])+1;
            }
        }
        
        
        return minEdit[lenB][lenA];
    }
}

/*
Link-https://www.interviewbit.com/problems/edit-distance/

Notes-
https://discuss.leetcode.com/topic/20922/java-dp-solution-o-nm

https://www.youtube.com/watch?v=2veeHbRQUuw

https://www.youtube.com/watch?v=MiqoA-yF-0M

*/