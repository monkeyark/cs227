package exam2;

import java.util.Scanner;

public class Problem1_b
{
	public static void main (String[] args)
	{
		String s = "zhi wang ma mingjun jihangli";
		System.out.println(longestWord(s));	
	}
	
	public static String longestWord (String sentence)
	{
		Scanner in = new Scanner(sentence);
		int length = 0;
		String longest = "";
		while (in.hasNext())
		{
			String word = in.next();
			if (word.length()>length)
			{
				longest = word;
				length = word.length();
			}
		}
		in.close();
		return longest;
	}
}
