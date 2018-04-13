package lab8;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import plotter.Plotter;
import plotter.Polyline;

public class TestPlotter
{
  public static void main(String[] args) throws FileNotFoundException
  {    
    ArrayList<Polyline> result = readFile("hello.txt");	
	Plotter plot1 = new Plotter();	
	for(int i=0; i < result.size(); i++){
		plot1.plot(result.get(i));
  }
}
  
  
 public static ArrayList<Polyline> readFile(String filename)
	      throws FileNotFoundException
	  {
	  File file = new File(filename);
	  ArrayList <Polyline> pl = new ArrayList<>();
	  Scanner scanner = new Scanner(file);
	  int j = 0;
	  int linecount = 0;
	  int width;
	  String color;
	  int a;
	  int b;	 
	  while(scanner.hasNextLine()){
		  String line = scanner.nextLine();
		  Scanner x = new Scanner(line);		  
		  if(linecount >= 2){
			  String[] arr = line.split(" ");
			  if(x.hasNext()){
				 if(arr[0].equals("red")){
					 width = 0;
					 color = arr[0];
					 pl.add(new Polyline(color,width));
					 int i =1;
					 while(i<arr.length-1){
						 a = Integer.parseInt(arr[i]);
						 b = Integer.parseInt(arr[i+1]);
						 pl.get(j).addPoint(new Point(a,b));
						 i=i+2;
					 }					
				 }
				 else{
					 int i = 2;
					 width = Integer.parseInt(arr[0]);
					 color = arr[1];
					 pl.add(new Polyline(color,width));
					 while(i < arr.length - 1){
						 a = Integer.parseInt(arr[i]);
						 b = Integer.parseInt(arr[i+1]);
						 pl.get(j).addPoint(new Point(a,b));
						 i=i+2;
					 }					
				 }
				 j++;
			  }
			  else{
				  int i = 0;				 
				  while(i<arr.length-1){					  	
				  		a = Integer.parseInt(arr[i]);
				  		b = Integer.parseInt(arr[i+1]);
				  		pl.get(j).addPoint(new Point(a,b));
				  		i=i+2;
				  }				  						  
			  }			
		  }
		  linecount ++;
	  }  
	  scanner.close();
	  return pl;		  
	  }
}
