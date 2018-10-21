package hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import api.Jewel;

/** 
 * Utility class that isolates the fundamental array algorithms needed
 * for implementation of the Bejeweled game.  Also includes some useful
 * methods for converting strings into arrays of Jewel objects.
 * 
 */

public class Util
{
  /**
   * Private constructor disables instantiation.
   */
  private Util()
  {
	  
  }
  
  /**
   * Finds all runs of three or more Jewels of matching type in the 
   * given array. The return value is a list of the indices of all
   * elements that are part of some run.  The given array is not modified.
   * Caller should ensure that there are no null elements in the given
   * array.
   * @param arr
   *   array of Jewels
   * @return
   *   indices of all Jewels that are part of a run
   */
  public static ArrayList<Integer> findRuns(Jewel[] arr)
  {
	  //record number of jewel occurrence in an int array named repeat
	  int[] repeat = new int[arr.length];
	  int count = 1;
	  repeat[0] = count;
	  for (int i=1; i<arr.length; i++)
	  {
		  if (arr[i].getType()==arr[i-1].getType())
		  {
			  count++;
			  repeat[i] = count;
		  }
		  else
		  {
			  count = 1;
			  repeat[i] = count;
		  }
	  }
	  
	  //use tempIndices stores repeated indices
	  ArrayList<Integer> tempIndices = new ArrayList<Integer>();
	  tempIndices.add(repeat[0]);
	  ArrayList<Integer> runIndices = new ArrayList<Integer>();
	  for (int i=1; i<repeat.length; i++)
	  {
		  if(repeat[i-1]<repeat[i])//because occurrence is always increasing
		  {
			  tempIndices.add(i);
			  if((i==repeat.length-1) && (tempIndices.size()>=3))
			  {
				  for (int j=0; j<tempIndices.size(); j++)
				  {
					  runIndices.add(tempIndices.get(j));//deep copy temp to indices
				  }
			  }
			  //i will be added to tempIndices, the missing i-1 will be added below
		  }
		  else//pass value in tempIndices to runIndices; then clear tempIndices
		  {
			  if(tempIndices.size()>=3)
			  {
				  for (int j=0; j<tempIndices.size(); j++)
				  {
					  runIndices.add(tempIndices.get(j));//deep copy temp to indices
				  }
				  tempIndices.clear();
				  tempIndices.add(i);//add i-1 of next iteration to tempIndices
			  }
			  else
			  {
				  tempIndices.clear();
				  tempIndices.add(i);//add i-1 of next iteration to tempIndices
			  }
		  }
	  }
	  return runIndices;
  }
  
  /**
   * Shifts all non-null elements in the array to the right without
   * changing the order.  This operation modifies the given array.
   * The return value is a list of the indices of elements that 
   * were actually shifted by this operation, ordered left to right
   * (this means the index of the element in the modified array, 
   * not the original). 
   * @param arr
   * 	array of Jewel objects, possibly containing null cells
   * @return
   *   list of the new indices of moved elements
   */
  public static ArrayList<Integer> shiftNonNullElements(Jewel[] arr)
  {
	  ArrayList<Integer> shiftIndices = new ArrayList<Integer>();
	  for (int i=arr.length-1; i>=0; i--)
	  {
		  if (arr[i] == null)
		  {
			  for (int j=i-1; j>=0; j--)
			  {
				  if (arr[j] != null)
				  {
					  Jewel temp = arr[i];
					  arr[i] = arr[j];
					  arr[j] = temp;
					  shiftIndices.add(i);
					  i--;//change the i to the next left element
				  }
			  }
		  }
	  }
	  Collections.reverse(shiftIndices);//shiftIndices was added from right to left
	  return shiftIndices;
  }
  
  /**
   * Creates an array of Jewel objects from a string of 
   * numbers separated by whitespace.
   * @param values
   *   string containing values for the Jewel types
   * @return
   *   array of Jewel objects with types determined by the given string
   */
  public static Jewel[] createFromString(String values)
  {
    ArrayList<Jewel> temp = new ArrayList<>();
    Scanner scanner = new Scanner(values);
    while (scanner.hasNextInt())
    {
      int value = scanner.nextInt();
      temp.add(new Jewel(value));
    }
    Jewel[] ret = temp.toArray(new Jewel[0]);
    scanner.close(); //added in addition to original code
    return ret;
  }
  
  /**
   * Returns a grid initialized from an array of strings.  Each string
   * consists of numbers, separated by whitespace, for the Jewel types for 
   * the corresponding row of the grid.  Throws IllegalArgumentException
   * if the strings in the array do not all contain the same number of
   * values.
   * @param descriptor
   *   array of strings containing numbers
   * @return
   *   a 2D array of Jewel objects whose types are determined by the
   *   given strings
   */
  public static Jewel[][] createFromStringArray(String[] descriptor)
  {
    int height = descriptor.length;
    
    // creates an uninitialized array of Jewel[]
    Jewel[][] grid = new Jewel[height][];
    
    // make rows from the strings of the given array
    for (int row = 0; row < height; row += 1)
    {
      grid[row] = createFromString(descriptor[row]);
    }
    
    // sanity check that all rows are the same length
    int width = grid[0].length;
    for (int row = 1; row < height; row += 1)
    {
      if (grid[row].length != width)
      {
        throw new IllegalArgumentException("Rows of descriptor are not the same length. ");
      }
    }
    return grid;
  }
  
  /**
   * Returns a String representation of the given 2D array, with rows
   * delimited by newlines.
   */
  public static String convertToString(Jewel[][] grid)
  {
    StringBuilder sb = new StringBuilder();
    for (int row = 0; row < grid.length; ++row)
    {
      for (int col = 0; col < grid[0].length; ++col)
      {
        Jewel jewel = grid[row][col];
        String s = String.format("%2s",
            (jewel == null ? "*" : "" + jewel.getType()));
        sb.append(s);
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
