/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*/
package interviewprep.Array.ArrayMath;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
    /* Solution using Array
	    
	   ArrayList<Integer> num = new ArrayList<>();
	    //Scanner in = new Scanner(System.in);
		
		/*
		 * input contains single line eg. 3 1 2 3
		 * 1st digit shows the size of the number and remaining digits constitute the number itself
		 * number may have leading  zeros
		 * 
		 */
		
	/*	String numArr[]= in.nextLine().split(" ");
		
		for(int i=1; i<=Integer.parseInt(numArr[0]);i++){
			
			int digit=Integer.parseInt(numArr[i]);
			
			if(digit!=0)
				num.add(digit);
			
		}
		*/
		
		
			
	
		
	/*	for(int i=1; i<=a.get(0);i++){
			
			int digit=a.get(0);
			
			if(digit!=0)
				num.add(digit);
			
		}
		
		*/
		
    /*		if(a.size()==1)
		    {
		        if(a.get(0)!=9)
		            a.set(0,a.get(0)+1);
		        else 
		           { a.add(0,1);
		            a.set(1,0);}
		        return a;
		    }
		    
		for(int i=0; i<a.size();)
		{
		    if(a.get(0)==0)
		        a.remove(0);
		    else break;
		}
		int size=a.size();
		int carry=1;
		for(int j=size-1; j>=0;j--){
			
			int incDgt=a.get(j)+carry;
			
			if(incDgt<=9)
				{
					a.set(j,incDgt);
					carry=0;
				}
			else 
				{
					a.set(j, incDgt%10);
					carry=1;
				}
		}
		
		
		
		if(carry==1)
			a.add(0,1);
			
	return a;
	
		
	/*	for(int i:num)
			{
				System.out.print(i+" ");
			}
	    */
	    
        
     
        
        
        
        /*
        Working Solution using ArrayList
        */
       
        ArrayList<Integer> res= new ArrayList<Integer>();
        
        //remove all leading 0's from the input array
        while(a.size()>0 && a.get(0)==0){
            a.remove(0);
        }
        
        
        /*
        1.init carry as 1, as we have to add 1 to the num
        2.keep adding the sum at the 0th location of the arrayList
        */
        int sum=0, carry=1;
        int lenA= a.size();
        for(int i=lenA-1; i>=0; i--){
            sum=a.get(i)+carry;
            res.add(0, sum%10);
            carry=sum/10;
        }
        
        //if carry is 1, add 1 to the 0th position to the answer list
        if(carry==1)
            res.add(0,carry);
        
        return res;
  


	}
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/add-one-to-number/
NOTES:
*/
