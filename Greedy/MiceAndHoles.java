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
public class MiceAndHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        /*
            Idea is to minimize the difference between the hole no. and mouse no.
        */
        
        Collections.sort(A);
        Collections.sort(B);
        
        int len=A.size();
        int ans=0;
        
        for(int i=0; i<len; i++){
            ans=Math.max(ans, 
                            Math.abs(A.get(i)-B.get(i))
                        );
        }
        
        return ans;
    }
}

/*
Link-
https://www.interviewbit.com/problems/assign-mice-to-holes/
Note-
Own Logic

*/