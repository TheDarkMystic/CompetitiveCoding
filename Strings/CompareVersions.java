/*
Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */



import java.math.BigInteger;

public class CompareVersions {
    public int compareVersion(String A, String B) {
        //split both strings based on '.'
        String[] ver1=A.split("\\.");
        String[] ver2=B.split("\\.");
        
        int l1=ver1.length;
        int l2=ver2.length;
        
        //find the longer version in size
        int longer = l1>l2 ? l1 : l2;
        
        for(int i=0; i<longer; i++){
            
            //check for arraySize and then extract one item from each array for comparison
            BigInteger v1 = i < l1 ? new BigInteger(ver1[i]) : BigInteger.ZERO;
            BigInteger v2 = i < l2 ? new BigInteger(ver2[i]) : BigInteger.ZERO;
            
            // use comparator for comparing strings 
            int res = v1.compareTo(v2);
            if(res != 0)
                return res;
        }
        
        return 0;
    }
}


/*
Link-
https://www.interviewbit.com/problems/compare-version-numbers/
Notes-

https://discuss.leetcode.com/topic/8316/simple-java-solution/9

https://www.tutorialspoint.com/java/math/biginteger_compareto.htm

failed test cases for which I used BigInteger

444444444444444444444444
4444444444444444444444444


Regarding the Split method in java for using '.' as split character

The problem with this code is that "." is a metacharacter if you want to use it literally you need to 
escape it by using backslash e.g. \\. , though you should remember that to escape dot you just need one 
backslash i.e \., but in Java since \ backslash also need escaping you need two backslashes or \\, as 
shown below:


Read more: https://javarevisited.blogspot.com/2016/02/2-ways-to-split-string-with-dot-in-java-using-regular-expression.html#ixzz5rDYv4bhE

*/
