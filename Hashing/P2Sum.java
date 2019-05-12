/*
 * 
    Given an array of integers, find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers (both index1 and index2 ) are not zero-based. 
    Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.

    If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.

    Input: [2, 7, 11, 15], target=9
    Output: index1 = 1, index2 = 2
 */
package interviewprep.Hashing;

/**
 *
 * @author jakadam
 */
import java.util.*;

public class P2Sum {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> twoSum(final List<Integer> A, int target) {
        ArrayList<Integer> sol=new ArrayList<>();
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        
        int len=A.size();
        
        //handle corner case
        if(A==null || len<2){
            sol.add(0);
            sol.add(0);
            return sol;
        }
        
        //main logic
        for(int i=0; i<len; i++){
            if(map.containsKey(A.get(i))==true){
                sol.add(map.get(A.get(i)));
                sol.add(i+1);
                break;
                
            }
            else{ 
                if(!map.containsKey(target-A.get(i)))
                    map.put(target-A.get(i), i+1);
            }
        }
        
        return sol;
        
    }
}
/*
Links-
https://www.interviewbit.com/problems/2-sum/
Notes-
https://leetcode.com/problems/two-sum/#/solutions

http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/

hashmap duplicate key
http://javaworldwide.blogspot.in/2012/04/does-hashmap-allow-duplicate-key-or-how.html
*/