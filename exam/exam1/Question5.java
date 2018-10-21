package exam1;

import java.util.Random;
import java.util.Scanner;

public class Question5
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		String firstName = in.next();
		String lastName = in.next();
		in.close();
		Random r = new Random();
		String f = firstName.toLowerCase();
		System.out.println( (f.charAt(0) + lastName.toLowerCase() + (r.nextInt(50)+1)));
	}
}
