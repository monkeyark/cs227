package lab3;
import java.util.Random;

public class Test
{
	public static void main(String[] args)
	  {
		
//	    String s = "Hello";
//	    char c = s.charAt(10);
//	    System.out.println(s);
		String sss = "abcdefg";
		String subsss1 = sss.substring(2, 2);
		System.out.println(subsss1);
		String subsss2 = sss.substring(2, 4);
		System.out.println(subsss2);
	    System.out.println("----------------------------");
		
	    // mod
	    System.out.println("checkpoint mod:");
	    System.out.println("mod is: " + 1000000%7);
	    System.out.println("----------------------------");
	    
	    // person
	    System.out.println("checkpoint person:");
	    Person a = new Person("Danry",24);
	    System.out.println("Name: " + a.getName());
	    System.out.println("Age: " + a.getAge());
//	    System.out.println("NameLength: " + a.getNameLength());
	    System.out.println("----------------------------");
	    
	    // string to int
	    System.out.println("checkpoint string to int:");
	    String s1 = "42";
	    int x1 = Integer.parseInt(s1);
	    System.out.println(x1+1);
//	    String s2 = "23Skidoo";
//	    int x2 = Integer.parseInt(s2);
//	    System.out.println(x2);
	    System.out.println("----------------------------");
	    
	    // extreme values
	    System.out.println("checkpoint overflow:");
	    System.out.println("MAX: " + Integer.MAX_VALUE);
	    System.out.println("MIN: " + Integer.MIN_VALUE);
	    System.out.println("MAX+1:");
	    System.out.println(Integer.MAX_VALUE+1);
	    System.out.println("MAX+2:");
	    System.out.println(Integer.MAX_VALUE+2);
	    System.out.println("MAX+MAX");
	    System.out.println(Integer.MAX_VALUE+Integer.MAX_VALUE);
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
	    System.out.println("random from 0-5, seed 137");
	    Random rand1 = new Random(137);
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println(rand1.nextInt(6));
	    System.out.println("----------------------------");
	    System.out.println("random from 0-5, seed 137");
	    Random rand2 = new Random(137);
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    System.out.println(rand2.nextInt(6));
	    
	  }
}
