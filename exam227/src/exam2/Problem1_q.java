package exam2;

import java.util.ArrayList;
import java.util.Random;

public class Problem1_q
{
	public static void main(String[] args)
	{
		Random r = new Random();
		System.out.println(randInt(r));
	}
	
	public static ArrayList<Integer> randInt(Random rand)
	{
		ArrayList<Integer> randList = new ArrayList<Integer>();
		boolean repeat = false;

		while (!repeat)
		{
			int element = rand.nextInt(100);
			
			if (randList.contains(element))
			{
				repeat = true;
				break;
			}
			else
			{
				randList.add(element);
			}
		}
		
		return randList;
	}
}