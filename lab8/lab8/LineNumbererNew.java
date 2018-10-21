package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumbererNew
{
  public static void main(String[] args) throws FileNotFoundException
  {
//    File file = new File("U:/workspace/project7/src/lab7/Deck.java");
//    Scanner scanner = new Scanner(file);
//    int lineCount = 1;
//
//    while (scanner.hasNextLine())
//    {
//      String line = scanner.nextLine();
//      System.out.print(lineCount + " ");
//      System.out.println(line);
//      lineCount += 1;
//    }
//    scanner.close();
    File file = new File("story.txt");
    Scanner scanner = new Scanner(file);
    int lineCount = 1;
    int wordCount = 0;

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      Scanner in2 = new Scanner(line);
      while(in2.hasNext()){
    	  String b = in2.next();
    	  wordCount ++;
      }
      System.out.println(wordCount + " ");
      System.out.println(line);
      lineCount += 1;
    }
    
    scanner.close();
    }
}
 

//    Scanner in2=new Scanner(file);
//    while(in2.hasNext())
//            {
//
//        String b=in2.next();
//        System.out.println(b);
//        wordCount++;
//        System.out.print(wordCount + " ");
//        System.out.println(b);
//            }
//   in2.close();
 
	  
//    File file = new File("Deck.java");
//    System.out.println(file.exists());          // true if the file exists
//    System.out.println(file.getName());         // name of the file 
//    System.out.println(file.getAbsolutePath()); // absolute path to the file
//    System.out.println(file.length());          // size of the file

