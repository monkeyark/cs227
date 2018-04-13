//package exam2;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Question5_2
//{
//	public static ArrayList<Obseration> readWeatherFile (String fileName)
//	{
//		File file = new File(fileName);
//		ArrayList<Observation> list = new ArrayList<Observation>();
//		Scanner in = new Scanner(file);
//		
//		while(in.hasNextLine())
//		{
//			String line = in.nextLine();
//			Scanner word = new Scanner(line);
//			String date = word.next();
//			int low = word.nextInt();
//			int high = word.nextInt();
//			Observation b = new Observation(date,low,high);
//			list.add(b);
//			}
//		
//		return list;
//	}
//}
