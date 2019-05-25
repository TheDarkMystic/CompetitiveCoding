/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.HeapsAndMaps;

/**
 *
 * @author jakadam
 */


import java.util.*;
public class MagicianAndChocolates {
    public int nchoc(int time, ArrayList<Integer> arr) {
        /*
            Idea is to sort the bags in descending order of number of chocos, so 
            that everytime we pick the bag with largest num of chocs.
        */
        
        //define a maxHeap
        PriorityQueue<Integer> maxHeap= new PriorityQueue<Integer>(Collections.reverseOrder());
        
        //add the numberof chocolates in bags to heap. it will sort them in descending order.
        for(int chocoBag : arr){
            maxHeap.add(chocoBag);
        }
        
        //start eating chocos now :)
        long ans=0;
        int temp=0;
        for(int i=0; i<time; i++){
            //extract largest bag with chocolates
            temp=maxHeap.poll();
            //update ans
            ans=(ans+temp)%(long)(Math.pow(10,9)+7);
            //refill the bag with half the chocolates and to maxHeap
            maxHeap.add(temp/2);
        }
        
        return (int)ans%(int)(Math.pow(10,9)+7);
    }
}


/*
Link-
https://www.interviewbit.com/problems/magician-and-chocolates/
Note-

Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7

*/
