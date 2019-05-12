/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Hashing;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class DiffkII {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int diffPossible(final List<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        
        for(Integer num:A){
            if(set.contains(num+B) || set.contains(num-B))
                return 1;
            else 
                set.add(num);
        }
        return 0;
    }
}
/*
Link-
https://www.interviewbit.com/problems/diffk-ii/
*/