package lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample1
{
  public static void main(String[] args)
  {
    String s = "3 5 7 9 12 12 9 7";
    ArrayList<Integer> result = readNumbers(s);
    removeDuplicates(result);
    System.out.println(result);
  }
  
  public static ArrayList<Integer> readNumbers(String text)
  {
    Scanner scanner = new Scanner(text);

    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    scanner = new Scanner(text);
    while (scanner.hasNextInt())
    { 
      nums.add(scanner.nextInt());
    }
    return nums;  
  }
  
  public static void removeDuplicates(ArrayList words){
	  ArrayList<Integer> nums = new ArrayList<Integer>();
	  nums.add((Integer)words.get(0));
	  //String s = words.toString();
	  //Scanner scanner = new Scanner(s);
	  for(int j=0; j < words.size(); j ++){
		  if(!nums.contains(words.get(j))){
			  nums.add((Integer)words.get(j));
		  }	 	  
	  }
		  words.clear();
		  words.addAll(nums);
  }

}