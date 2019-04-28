/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Graph;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class BlackShapes {
    public int black(ArrayList<String> A) {
        
        int rowNum=A.size();
        int colNum=A.get(0).length();
        
        //Convert given input to grid, because given input unnecessarily makes indexing complicated.
        int[][] grid= new int[rowNum][colNum];
        
        for(int i=0; i<rowNum; i++)
            for(int j=0; j<colNum; j++){
                if(A.get(i).charAt(j)=='X')
                    grid[i][j]=1;
                else 
                    grid[i][j]=0;
            }
        
        //for each 1 encountered in grid, mark horizontally and vertically adjacent 
        //1's with 0's recursively (using dfs function) and update islandCount
        int islandCount=0;
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(grid[i][j]==1){
                    islandCount++;
                    dfs(grid,i,j, rowNum, colNum);
                    
                }
            } 
         }
        
        return islandCount;
    }
    
    //this function recursively sets adjacent 1's to 0's for passed position (Horizontal and vertical not diagonal)
    public void dfs(int[][] grid, int i, int j, int rowNum, int colNum ){
        //base condition
        // make sure give position is inside the grid and passed element is 1
        if(i>=0 && i<rowNum && j>=0 && j<colNum && grid[i][j]==1){
            grid[i][j]=0;
            dfs(grid,i+1,j, rowNum, colNum);
            dfs(grid,i-1,j, rowNum, colNum);
            dfs(grid,i,j+1, rowNum, colNum);
            dfs(grid,i,j-1, rowNum, colNum);
        }
        else
            return;
    }
}
/*
Link-https://www.interviewbit.com/problems/black-shapes/
Notes-
https://www.youtube.com/watch?v=CLvNe-8-6s8

Simple problem
https://discuss.leetcode.com/topic/13248/very-concise-java-ac-solution
*/