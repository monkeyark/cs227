package lab7;

public class Test {

	public static void main(String[] args)
	{
		final double x = 6;
		double n = x;
		
		for (int i=1; i<Integer.MAX_VALUE; i++)
		{
			n = x + 1/n;
		}
		
		System.out.println(n);
		System.out.println((int) n);
		System.out.println();
		
		for (int i=1; i<50; i++)
		{
			System.out.println(i);
			System.out.println(Math.sqrt(i));
		}
	}
}
