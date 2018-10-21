package exam2;

import java.util.Arrays;

public class Question1_b
{
	public static void main(String[] args)
	{
		int[] arr = {0, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(Arrays.toString(getEvenNumbers(arr)));
	}
	
	public static int[] getEvenNumbers (int[] arr)
	{
		int even = 0;
		for (int i=0; i<arr.length; i++)
		{
			if (arr[i]%2==0)
			{
				even++;
			}
		}
		
		int evenArr[] = new int[even];
		int index = 0;
		for (int i=0; i<arr.length; i++)
		{
			if (arr[i]%2==0)
			{
				evenArr[index] = arr[i];
				index++;
			}
		}
		return evenArr;
	}
}
