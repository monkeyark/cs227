//package exam2;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Observation
//{
////	private String date="";
////	private int low=0;
////	private int high=0;
//	
//	public Observation(String date,int low,int high)
//	{
////		this.date=date;
////		this.low=low;
////		this.high=high;
//	}
//	
//	
//	public static void main(String[] args) throws FileNotFoundException
//	{		
//		ArrayList<Observation> weather = new ArrayList<Observation>(readWeatherFile("test.txt"));
//		Observation[] weatherArr = weather.toArray(new Observation[weather.size()]);				
//		System.out.println(weatherArr);		
//	}
//	
//	public static ArrayList<Observation> readWeatherFile(String filename) throws FileNotFoundException
//	{
//		File file=new File(filename);
//		Scanner in=new Scanner(file);
//		ArrayList<Observation> weather=new ArrayList<Observation>();
//		while(in.hasNextLine())
//		{
//			in.nextLine();
//			Observation a=new Observation(in.next(),in.nextInt(),in.nextInt());
//			weather.add(a);			
//		}
//		in.close();
//		return weather;
//	}
//	
//}