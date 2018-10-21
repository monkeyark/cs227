package exam2;

public class Question4
{
	public static void main(String[] args)
	{
		System.out.println(countTerms(1));
	}
	
	public static int countTerms (double target)
	{
		int count = 0;
		double base = 1;
		double sum = 0;
		
		while (sum <= target)
		{
			base++;
			sum += 1/base;
			count++;
		}
		return count;
	}
}
