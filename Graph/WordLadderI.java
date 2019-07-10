/*
 * 
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

You must change exactly one character in every transformation
Each intermediate word must exist in the dictionary
Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note that we account for the length of the transformation path instead of the number of transformation itself.

 Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
package interviewprep.Graph;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class WordLadderI {
    public int ladderLength(String start, String end, ArrayList<String> dict) {
        
        if(start.equals(end))
            return 1;
            
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);
        /**
         *  refer the diagram on the page
            https://www.programcreek.com/2012/12/leetcode-word-ladder/
        
            -we take the starting word and for each char in the word, we try/replace 26 letters (a-z)
            -if the new word is found in the dict, its a valid transformation and hence we add it to the 
                queue for the next rounds of transformation
            -This way all possible words formed by replacing one char at a time form one level of tree 
            -"null" marks the end of one level of tree
            -This is a classic BFS search problem
            -BFS always returns shortest path, hence the ans found is the shortest path.
         */
         
        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(start);
          
        int level = 1;
          
        while (!queue.isEmpty()) {
            String str = queue.poll();
            
            if (str != null) {// one level of tree is completed
                // Modify str's each character (so word distance is 1)
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                          
                        String word = new String(chars);
                          
                        // Found the end word
                        if (word.equals(end)) 
                            return (level + 1);
                          
                        // Put it into the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } 
            else 
            {
                level++;
              
                if (!queue.isEmpty()) { 
                    queue.add(null);
                }
            }
        }
          
        return 0;
    }
}
/*
Link-
https://www.interviewbit.com/problems/word-ladder-i/
Notes-
https://www.programcreek.com/2012/12/leetcode-word-ladder/

https://discuss.leetcode.com/topic/17890/another-accepted-java-solution-bfs
*/