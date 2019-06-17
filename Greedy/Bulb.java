/*
N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.

Note : 0 represents the bulb is off and 1 represents the bulb is on.

Example:

Input : [0 1 0 1]
Return : 4

Explanation :
	press switch 0 : [1 0 1 0]
	press switch 1 : [1 1 0 1]
	press switch 2 : [1 1 1 0]
	press switch 3 : [1 1 1 1]
 */
package interviewprep.Greedy;

/**
 *
 * @author jakadam
 */



import java.util.*;
public class Bulb {
    public int bulbs(ArrayList<Integer> A) {
        boolean inverted=false;
        int ans=0;
        /*
            we increment ans only when we alter the state of any bulb.
            The state of bulb needs to be only if it is in OFF state.
            
            There are only 2 conditions in which the bulb can be in OFF condition.
            Considering the statement "switch also changes the state of all the bulbs 
            to the right of current bulb" ...
                1. Current bulb is 1 and previous bulb was OFF and hence switched ON
                2. Current bulb is OFF and previous bulb was NOT switched from original state.
        
        
        */
        for(int i=0; i<A.size(); i++){
            
            if(inverted==true){
               if(A.get(i)==1){
                   ans++;
                   inverted=false;
               } 
            }
            else{//inverted==false
                if(A.get(i)==0){
                    ans++;
                    inverted=true;
                }
            }
        }
        
        return ans;
    }
}
/*
Link-
https://www.interviewbit.com/problems/bulbs/
Notes-
Optional:
http://qa.geeksforgeeks.org/4118/find-the-minimum-number-switches-you-have-press-turn-the-bulbs

*/

