package lab6;

import java.util.Scanner;

public class Checkpoint1
{
	public static void main(String[] args)
	{

		System.out.println(Checkpoint1.getInitial("Zhi Wang Jia Hang Li"));
		System.out.println(Checkpoint1.getFirstVowel("glvvnString"));
	}
	
	public static String getInitial (String fullname)
	{
		Scanner in = new Scanner(fullname);
		String initial = "";
		while (in.hasNext())
		{
			String name = in.next();
			initial = initial + name.charAt(0);
		}
		in.close();
		return initial;
	}
	
	public static int getFirstVowel(String givenString)
	{
		for (int i=0; i<givenString.length(); i++)
		{
			if ("aeiouAEIOU".indexOf(givenString.charAt(i)) >= 0)
				return i;
		}
		return -1;
	}
	
	
}
