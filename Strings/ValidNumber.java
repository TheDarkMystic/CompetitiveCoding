/*
 * 
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input. */
package interviewprep.Strings;

/**
 *
 * @author jakadam
 */

/*

We start with trimming white spaces.
If we see [0-9], we set the numberSeen, numberAfterE flags.
'.' cannot occur immediately after 'e' or '.'
'e' can occur after a number. 'e' cannot occur immediately after another 'e' or a '.'. 
We reset numberAfterE flag. Also 'e' must be followed  by a number or a '+' or a '-'. 
We can only see + and - in the beginning and after an 'e'.
any other character break the validation.

So basically the number should match this regular expression:
 
[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?
*/
 
public class ValidNumber {
    public int isNumber(final String str) {
        String s= str.trim();
        int len=s.length();
        char[] num= s.toCharArray();
        if(s==null || len==0) return 0;
        
        boolean numberSeen=false;
        boolean eSeen=false;
        boolean pointSeen=false;
        boolean numberAfterE=true;
        
        for(int i=0;i<len;i++){
            if(num[i]>='0' && num[i]<='9'){
                numberSeen=true;
                numberAfterE=true;
            }
            else if(num[i]=='.'){
                    if(pointSeen || eSeen ||i==len-1) //'3.'=>false
                        return 0;
                    pointSeen=true;
                }
                else if(num[i]=='e'){
                            if(!numberSeen || eSeen ||num[i-1]=='.')//1.e1=>false
                                return 0;
                            numberAfterE=false;
                            eSeen=true;
                    }
                    else if(num[i]=='-' || num[i]=='+'){
                                if(i>0 && num[i-1]!='e')
                                    return 0;
                        }
                        else return 0;
        }
        
        int ans=(numberAfterE && numberSeen)==true?1:0;
        return ans;
    }
}

/*
Link-
https://www.interviewbit.com/problems/valid-number/
Notes-
https://leetcode.com/problems/valid-number/#/description
*/