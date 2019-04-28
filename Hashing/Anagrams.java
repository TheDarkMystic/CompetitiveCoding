/*
 * 
    Given an array of strings, return all groups of strings that are anagrams. Represent a group by a 
    list of integers representing the index in the original list. Look at the sample case for 
    clarification.


    Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', 
    formed from 'rasp' 
    Note: All inputs will be in lower-case. 
    Example :

    Input : cat dog god tca
    Output : [[1, 4], [2, 3]]
    cat and tca are anagrams which correspond to index 1 and 4. 
    dog and god are another set of anagrams which correspond to index 2 and 3.
    The indices are 1 based ( the first element has index 1 instead of index 0).

    Ordering of the result : You should not change the relative ordering of the words / phrases within 
    the group. Within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 */
package interviewprep.Hashing;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class Anagrams {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        /*
        Maintain HashMap<String,ArrayList<Integer>)
            
        For each string in the given list
            1. Convert string to char array
            2. sort the char array
            3. convert char array again to string
            4. This String is now our key for hashmap
            5. If map contains the key, add the index of the string to the arrayList in map values
            6. else add key to map,initialize a new ArrayList<Integer> for values, add the index of the string to the arrayList
        */
        int len=A.size();
        HashMap<String, ArrayList<Integer>> map= new HashMap<>();
        
        //indices are 1 based, hence this workaround
        int i=1;
        for(String str:A){
            //steps 1-3
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String key=String.valueOf(arr);
            
            //steps 4-6
            if(map.containsKey(key)){
                map.get(key).add(i);
            }
            else{
                map.put(key, new ArrayList<Integer>());
                map.get(key).add(i);
            }
            //increment i
            i++;
        }
        
        return new ArrayList<ArrayList<Integer>>(map.values());
        
        
    }
}

/*
Link-https://www.interviewbit.com/problems/anagrams/
Notes-

Problem is not complex, but converting collections and handling them is a challenge here

1. How string is sorted
2. converting values set of a map to arraylist


If Simple anagrams question is asked, 
    Sol 1.use HashSet to keep chars from 1st string and cross-check with chars from second string
    Sol 2.sort both arrays, compare
    
*/
