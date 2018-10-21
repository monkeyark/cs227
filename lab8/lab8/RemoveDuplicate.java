package lab8;

import java.util.ArrayList;


public class RemoveDuplicate {
	public static void removeDuplicates(ArrayList words){
		  int count = words.size();
		    for (int i = 0; i < count; i++) 
		    {
		        for (int j = i + 1; j < count; j++) 
		        {
		            if (words.get(i).equals(words.get(j)))
		            {
		                words.remove(j--);
		                count--;
		            }
		        }
		    }
	}
	public static void main (String []args){
		ArrayList<Object> a1 = new ArrayList<Object>();
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(2);
		a1.add(55);
		a1.add(66);
		a1.add(2);
		a1.add(78);
		a1.add(55);
		removeDuplicates(a1);
		System.out.println(a1);		
	}
}
