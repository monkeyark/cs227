package exam2;

import java.util.ArrayList;

public class Question3
{
	public static void main(String[] args)
	{
		ArrayList<String> b = new ArrayList<String>();
		b.add("foo");
		b.add("bar");
		b.add("banana");
		b.add("bar");
		b.add("apple");
		
		System.out.println(containsDuplicate(b));
	}
	
	public static boolean containsDuplicate (ArrayList<String> words)
	{
		for (int i=0; i<words.size(); i++)
		{
			for (int j=i+1; j<words.size(); j++)
			{
				if (words.get(i).equals(words.get(j)))
				{
					return true;
				}
			}
		}
		return false;
	}
}
