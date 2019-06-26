/*
 *Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = “great”:


    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
 
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node “gr” and swap its two children, it produces a scrambled string 
“rgeat”.

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that “rgeat” is a scrambled string of “great”.

Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled 
string “rgtae”.

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that “rgtae” is a scrambled string of “great”.

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1. 
Return 0/1 for this problem.
 */
package interviewprep.DP;

/**
 *
 * @author jakadam
 */
import java.util.Arrays;
public class ScrambleStrings {
     // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String s1, final String s2) {
    
        //lenghts of the strings must be equal
        if(s1.length()!=s2.length())
            return 0;
    
        //strings are scramble if they are identical
        if(s1.equals(s2))
            return 1;
        
        //check if the set of characters in the string are same or not
        // this can also be done using a hashset
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(!new String(arr1).equals(new String(arr2))){
            return 0;
        }
     
        // main logic
        //use “rgtae” and “great” for eg.
        
        for(int i=1; i<s1.length(); i++){
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i, s1.length());
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i, s2.length());
            String s23 = s2.substring(0, s2.length()-i);
            String s24 = s2.substring(s2.length()-i, s2.length());
     
            if(isScramble(s11, s21)==1 && isScramble(s12, s22)==1)
                return 1;
            if(isScramble(s11, s24)==1 && isScramble(s12, s23)==1)
                return 1;    
        }    
     
        return 0;
            
            
    }
}

/*
Link-
https://www.interviewbit.com/problems/scramble-string/

Notes-

https://www.programcreek.com/2014/05/leetcode-scramble-string-java/

Explanation of the solution

If string s1 and s2 are scramble strings, there must be a point that breaks s1 to two parts s11, s12, 
and a point that breaks s2 to two parts, s21, s22, and isScramble(s11, s21) && isScramble(s12, s22) is 
true, or isScramble(s11, s22) && isScramble(s12, s21) is true.

So we can make it recursively. We just break s1 at different position to check if there exists one 
position satisfies the requirement.

Some checks are needed otherwise it will time out. For example, if the lengths of two strings are 
different, they can’t be scramble. And if the characters in two strings are different, they can’t be 
scramble either.
*/