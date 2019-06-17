/*
 * 
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
Completing the circuit means starting at i and ending up at i again.

Example :

Input :
      Gas :   [1, 2]
      Cost :  [2, 1]

Output : 1 

If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1. 
If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to station 1, which you do and complete the circuit. 

 */
package interviewprep.Greedy;

/**
 *
 * @author jakadam
 */


/*
The bruteforce solution should be obvious. Start from every i, and check to 
see if every point is reachable with the gas available. Return the first i for 
which you can complete the trip without the gas reaching a negative number. 
This approach would however be quadratic.

Lets look at how we can improve. 
1) If sum of gas is more than sum of cost, does it imply that there always is 
a solution ? 
2) Lets say you start at i, and hit first negative of sum(gas) - sum(cost) at 
j. We know TotalSum(gas) - TotalSum(cost) > 0. What happens if you start at j + 1 instead ? Does it cover the validity clause for i to j already ?



Some observation here:
Set budget[i]=gas[i]-cost[i]
1.If budget[i]<0 => we can't go to (i+1)th gas station.
2. If Sum(budget[i]:budget[j])<0 we can't go to j from i.
3. If Sum(budget[0]:budget[n])<0, we can't make a cycle.

*/

import java.util.*;
public class GasStation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        int lenGas=gas.size();
        
        int sumGas=0;
        int sumCost=0;
        int balance=0;
        
        int start=0;
        
        for(int i=0; i<lenGas; i++){
            sumGas+=gas.get(i);
            sumCost+=cost.get(i);
            balance=balance+(gas.get(i)-cost.get(i));
            
            if(balance<0){
                balance=0;
                start=i+1;
            }
            
        }
        
        
        if(sumGas-sumCost>=0)
            return start;
        else return -1;
        
        
        
    }
}

/*
Link-
https://www.interviewbit.com/problems/gas-station/
Notes-
http://blog.shengwei.li/leetcode-gas-station/
https://codesniper.blogspot.com/2015/03/134-gas-station-leetcode-java.html
*/