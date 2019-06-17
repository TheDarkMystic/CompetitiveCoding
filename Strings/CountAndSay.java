/*
The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.


 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */


public class CountAndSay {
    public String countAndSay(int n) {

        StringBuilder prev=new StringBuilder("1");
        StringBuilder cur=new StringBuilder();

        for(int i=1; i<n; i++){// generate Nth Seq, we already have 1st seq "1"
            char curChar=prev.charAt(0);
            int count=1;
            for(int j=1; j<prev.length(); j++){// iterate through the prev seq and do the count and say
                if(prev.charAt(j)!=curChar){
                    cur.append(count).append(curChar);
                    curChar=prev.charAt(j);
                    //reset the counter for next count and say
                    count=1;
                }
                else{
                    count++;
                }
            }
            cur.append(count).append(curChar);
            prev=cur;
            cur=new StringBuilder();
        }
        return prev.toString();
    }
}


/*
Link-
https://www.interviewbit.com/problems/count-and-say/
Notes-
https://www.youtube.com/watch?v=kAt-4y0qG8Q
    Optional:
    http://www.programcreek.com/2014/03/leetcode-count-and-say-java/

    http://www.geeksforgeeks.org/look-and-say-sequence/
*/