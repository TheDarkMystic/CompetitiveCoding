/*
 Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    } 
}
Example 2:

Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. 
The strings should not have “\n” character in them.
 */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */

import java.util.*;
public class PrettyJSON {
    public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<String>();
        int tabCounter = 0;
        StringBuffer current = new StringBuffer();
        for(int i=0; i<a.length(); i++) {
            char c = a.charAt(i);
            switch(c) {
                case '{':
                case '[':
                    if(current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    tabCounter++;
                    break;
                
                case ']':    
                case '}':
                    if(current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    tabCounter--;
                    for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
                    current.append(c);
                    break;
                    
                case ',':
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    break;
                    
                default:
                    if(current.length() == 0) {
                        for(int j=0; j<tabCounter; j++) {
                            current.append('\t');
                        }
                    }
                    current.append(c);
            }
        }
        
        if(current.length() > 0) {
            result.add(current.toString());
        }
        
        return result;
    }
}

/*
Link-
https://www.interviewbit.com/problems/pretty-json/
Notes-
Self-explainatory logic
*/