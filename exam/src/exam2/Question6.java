package exam2;

public class Question6 {

	public static void main(String[] args)
	{
		surprise(10);

	}
	
	public static void surprise (int n)
	{
		if (n<0)
		{
			System.out.println("hooray");
		}
		else
		{
			n = n-2;
			
			System.out.println(n);
			surprise(n-1);
		}
	}

}
