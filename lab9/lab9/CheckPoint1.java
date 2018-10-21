package lab9;

public class CheckPoint1 {
	public static void main(String []args)
	{
		int[] test = {3, 4, 5, 1, 2, 3, 2, 7, 9}; // max should be 9
	    int result = findMaximum(test);
	    System.out.println(result);	    
	    
	    System.out.println("---------------------");
	    int result2=getPyramid(9);
	    System.out.println(result2);
	}
	private static int findMaximum(int[] arr)
	{		
		return arrayMax(arr, 0, arr.length - 1);
	}
	private static int arrayMax(int[] arr, int start, int end)
	{
	    if (start == end)
	    {
	      return arr[start];
	    }
	    else
	    {
	      int mid = (start + end) / 2;
	      int leftMax = arrayMax(arr, start, mid);
	      int rightMax = arrayMax(arr, mid + 1, end);
	      	if(leftMax>rightMax)
	      	{
	      		return leftMax;
	      		}	    	      
	      	else
	      	{
	      		return rightMax;
	      	} 	    	 	      	   	
	    }
	}
	
	private static int getPyramid(int n)
	{
		return getPyramidCount(n);
	}
	private static int getPyramidCount(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else
		{			
			return n*n+getPyramidCount(n-1);
		}		
	}
}
