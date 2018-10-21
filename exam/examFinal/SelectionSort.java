package examFinal;

import java.util.Arrays;


public class SelectionSort
{
  public static void main(String[] args)
  {
    // try it out...
    int[] arr = {5, 3, 4, 7, 6, 2, 4, 3, 1};
    System.out.println(Arrays.toString(arr));
//    selectionSort(arr);
//    System.out.println(Arrays.toString(arr));
    
    // try the version for Strings
    String[] arr2 = {"chimpanzee", "aardvark", "apple", "gorilla"};
    System.out.println(Arrays.toString(arr2));
//    selectionSortForStrings(arr2);
    Arrays.sort(arr2);
    System.out.println(Arrays.toString(arr2));
  }
  
  
  /**
   * Selection sort for integer arrays, as first written in class using
   * a helper method.
   */
  public static void selectionSort(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; i += 1)
    {
      // find index of minimal element to the right of i
      int indexOfMin = findIndexOfMin(arr, i);
      
      // swap that element into position i
      swap(arr, i, indexOfMin);
    }
  } 
  
  private static int findIndexOfMin(int[] arr, int start)
  {
    int indexOfMin = start;
    for (int i = start + 1; i < arr.length; i += 1)
    {
      if (arr[i] < arr[indexOfMin])
      {
        indexOfMin = i;
      }
    }
    return indexOfMin;
  }

  
  
  /**
   * Selection sort for integer arrays, as normally written in textbooks
   * using nested loops.
   */
  public static void selectionSortAlt(int[] arr)
  {
    for (int i = 0; i < arr.length - 1; ++i)
    {
      // find index of minimal element to the right of i
      int indexOfMin = i;
      for (int j = i + 1; j < arr.length; ++j)
      {
        if (arr[j] < arr[indexOfMin])
        {
          indexOfMin = j;
        }
      }
      
      // swap into position i
      int temp = arr[i];
      arr[i] = arr[indexOfMin];
      arr[indexOfMin] = temp;
    }
  }
  
  
  
  public static void selectionSortForStrings(String[] arr)
  {
    for (int i = 0; i < arr.length - 1; ++i)
    {
      // find index of minimal element to the right of i
      int minIndex = i;
      for (int j = i + 1; j < arr.length; ++j)
      {
        //if (arr[j] < arr[minIndex])
        if (arr[j].compareTo(arr[minIndex]) < 0) 
        {
          minIndex = j;
        }
      }
      
      // swap into position i
      String temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
  }
  
  

  /**
   * Exchanges two elements of an array indicated by
   * the given indices.
   * @param arr
   * @param i
   * @param j
   */
  private static void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}