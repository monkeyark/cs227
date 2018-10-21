package exam2;

import java.util.Arrays;

public class Question2
{
	public static void main(String[] args)
	{
		int[] arr = {8, 2, 3, 4, 5, 6, 7, 0};
		swaqMaxToEnd(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void swaqMaxToEnd (int[] arr)
	{
		int max = arr[0];
		int maxIndex = 0;
		for (int i=1; i<arr.length; i++)
		{
			if (max < arr[i])
			{
				max = arr[i];
				maxIndex = i;
			}
		}
		
		int temp = arr[arr.length-1];
		arr[arr.length-1] = max;
		arr[maxIndex] = temp;
	}
}
