/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewprep.Array.ArrayMath;

/**
 *
 * @author jakadam
 */
import java.util.*;
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    
	    
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
		
		if(a.size()==1)
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
	//	System.out.println(size+" "+a.size());
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
	    
	}
}
/*
ProblemUrls:
I-https://www.interviewbit.com/problems/add-one-to-number/
NOTES:
*/
