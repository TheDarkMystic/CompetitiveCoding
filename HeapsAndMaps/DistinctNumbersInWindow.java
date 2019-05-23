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
public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        /*
        Idea is
        1. Initialize a map of size= window size
        2. Keep sliding the window (add new ele to map, remove last ele from map) and count the distinct keys in map.
        */
        
        ArrayList<Integer> ans= new ArrayList<>();
        int len=A.size();
        
        // corner case
        if(B>len)
            return ans;
        
        //Map< ele, count >. This map is our window
        HashMap<Integer,Integer> map= new HashMap<>();
        
        //initialize the window with firt B elements
        for(int i=0; i<B; i++){
            addToMap(map,A.get(i));
        }
        ans.add(map.keySet().size());
        
        
        //sliding the window
        
        //last allowed index for sliding
        int lastAllowedIndex=len-B;
        for(int i=1; i<=lastAllowedIndex; i++){
            int outgoingEle=A.get(i-1);
            int incomingEle=A.get(i+B-1);
            removeFromMap(map,outgoingEle);
            addToMap(map,incomingEle);
            
            ans.add(map.keySet().size());
            
        }
        
        return ans;
    }
    
    
    public void addToMap(HashMap<Integer, Integer> map, int ele){
        if(!map.containsKey(ele)){
            map.put(ele,1);
        }
        else{
            int newCount=map.get(ele)+1;
            map.put(ele,newCount);
        }
    }
    
    public void removeFromMap(HashMap<Integer, Integer> map, int ele){
        if(map.get(ele)>1){
            int newCount=map.get(ele)-1;
            map.put(ele,newCount);
        }
        else{
            map.remove(ele);
        }
    }
    
}

/*
Link-
https://www.interviewbit.com/problems/distinct-numbers-in-window/
Notes-
Alternative -
http://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/

*/
