package lab3;

public class Mod
{
	private int n;
	private String s;
	
	public Mod(String givenString)
	{
		s = givenString;
	}
	
	public void getFind_N()
	{
		n = 1000000 % s.length();
	}
	
	public int getN_thNumber()
	{
		return s.charAt(n);
	}	
}
