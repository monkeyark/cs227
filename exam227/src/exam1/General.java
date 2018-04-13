package exam1;

import java.util.Random;

public class General
{
	public static void main(String[] args)
	{
		//string
		String sss = "abcdefg";
		String subsss1 = sss.substring(2, 2);
		System.out.println(subsss1);
		String subsss2 = sss.substring(2, 4);
		System.out.println(subsss2);
	    System.out.println("----------------------------");
	    
	    System.out.println("checkpoint string to int:");
	    String s1 = "42";
	    int x1 = Integer.parseInt(s1);
	    System.out.println(x1+1);
//	    String s2 = "23Skidoo";
//	    int x2 = Integer.parseInt(s2);
//	    System.out.println(x2);
	    System.out.println("----------------------------");
	    
	    // random
	    System.out.println("checkpoint random:");
	    System.out.println("random from 0-5, seed null");
	    Random rand = new Random();
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println("----------------------------");
	    System.out.println("random from 0-5, seed null");
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println(rand.nextInt(6));
	    System.out.println("----------------------------");
	    System.out.println("random from 0-5, seed 137");
	    Random rand1 = new Random(137);
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println("----------------------------");
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println("----------------------------");
	    Random rand2 = new Random(137);
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println("----------------------------");
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println("----------------------------");
	}
}
