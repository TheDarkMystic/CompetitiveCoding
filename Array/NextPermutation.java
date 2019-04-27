/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array;

/**
 *
 * @author jakadam
 */


import java.util.*;
public class NextPermutation {
    public void nextPermutation(ArrayList<Integer> A) {
        /*
        Approach 1: Find all permutations of given numbers and compare with given sequence to find the next permutation.
                    O(n!) time is required, as we can generate n! permutations with given n numbers.
        Approach 2: Spot the pattern in the approach of generating permutations and tweak it.
                    We generate permutations of the given set of no.s by fixing positions of some of the numbers and trying to fill 
                    remaining positions with remaining numbers.
                    
                    eg. if we have to generate permutations of 1 2 3 4, we will start by fixing 1st position and then for 1st fixed, we will 
                    fix 2nd position and so on.
                    When all possible permutations are exhausted for 1 fixed at 1st position, we recurse and fix 2 at 1st position and explore
                    remaining positions with remaining numbers.
                    Pattern: When all possible permutations are exhausted,Just before recursing, the section of numbers after the fixed numbers 
                            is in decreasing order.
                            eg. 2 1 4 3
                                in above sequence, we have 2 and 1 fixed at 1st, 2nd pos respectively and we have exhausted all lexicographical 
                                permutations for 3rd and 4th position. To generate next permutation, we have to recurse and remove 1 from 2nd pos,
                                fix 3(as it is next greater than 1) at 2nd pos and explore remaining positions with 1 and 4.
                                Immediate next permutation with 3 fixed in 2nd pos will have remaining section in ascending order lexicographically.
                                This is the key.
                                
                    Algo:
                            1.  Traverse array from right->left, find the first decreasing number.
                                This number is the fixed number(say p) in the current sequence and section after that number is last permutation as all the 
                                numbers are in decreasing order.
                            2.  Traverse array from right->left again to find number just greater than p (call it q). This will be our fixed number in next permutation.
                            3.  Swap p and q. We don't care where p goes. We just want to fix the q at right position for next permutation, which is held by p in given 
                                sequence.
                            4.  only remaining task is, sort the section after q in increasing order so we have next permutation.
                                But, it will take O(nLogn). Notice that the section is already in decreasing order, so we can reverse it and 
                                we will be done in O(n).
        */
        
        
        int len= A.size();

        // Step 1: find P
        int pIndex=-1;
        
        for(int i=len-1; i>0; i--){
            if(A.get(i-1)<A.get(i)){
                pIndex=i-1;
                break;
            }
        }
        
        //List is already in highest permutation, return smallest permutation
        if(pIndex==-1)
            Collections.sort(A);
        else{
            //Step 2: Find q
            int qIndex=-1;
            for(int i=len-1; i>=0; i--){
                if(A.get(i)>A.get(pIndex)){
                    qIndex=i;
                    break;
                }
            }
            
            //Step 3: Swap p and q
            int temp=A.get(pIndex);
            A.set(pIndex,A.get(qIndex));
            A.set(qIndex,temp);
            
            //Step 4: Sort section after pIndex
            Collections.sort(A.subList(pIndex+1, len));
        
        }
    }
}

/*
Link-
https://www.interviewbit.com/problems/next-permutation/
Notes-
https://www.youtube.com/watch?v=quAS1iydq7U
https://www.programcreek.com/2014/06/leetcode-next-permutation-java/
*/

