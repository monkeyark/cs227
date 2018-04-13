package exam2;

public class Problem1_c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "zhi!@ wang, ma mingjun )*&^jihangli";
		System.out.println(replace(s));	
	}
	
	public static String replace (String a)
	{
		String s = "";
		for (int i=0; i<a.length(); i++)
		{
			if (Character.isAlphabetic(a.charAt(i)))
			{
				s+=a.charAt(i);
			}
			else
			{
				s+="#";
			}
		}
		return s;
	}

}
