package lab7;

import java.util.Arrays;
import java.util.Random;

public class Checkpoint1
{
	public static void main(String[] args)
	{
		int[] test = {1, -2, 3, -4, 5, -6, 7, -8, 9};
	    System.out.println("Before: " + Arrays.toString(test));
	    System.out.println("After:  " + Arrays.toString(getPositiveNumbers(test)));
	    
	    System.out.println("randomExperiment:  " + Arrays.toString(randomExperiment(10,1000)));
	}
	
	public static int[] getPositiveNumbers(int[] numbers)
	{
		int count = 0;
		for (int i=0; i<numbers.length; i++)
		{
			if(numbers[i]>0)
				count++;
		}
		
		int[] positiveNums = new int[count];
		int element = 0;
		for (int i=0; i<numbers.length; i++)
		{
			if(numbers[i]>0)
				positiveNums[element++] = numbers[i];
		}
		return positiveNums;
	}
	
	public static int[] randomExperiment(int max, int iters)
	{
		int[] counts = new int[max];
		Random rand = new Random();
		for(int i=0; i<iters; i++)
		{
			int num = rand.nextInt(max);
			counts[num] += 1;
		}
		return counts;
	}
}
