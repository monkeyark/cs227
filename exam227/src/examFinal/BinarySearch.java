package examFinal;

import java.util.Arrays;

/**
 * Recursive and nonrecursive implementations of the binary search algorithm.
 */
public class BinarySearch
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    int[] test = {0, 1, 3, 4, 7, 8, 10, 15, 20, 21, 23, 42};
    System.out.println(Arrays.toString(test));
    
    System.out.println();
    System.out.println("Searching for 21:");
    int result = binarySearch(test, 21);
    System.out.println(result);
    result = binarySearchNonRec(test, 21);
    System.out.println(result);
    
    System.out.println();
    System.out.println("Searching for 5");
    result = binarySearch(test, 5);
    System.out.println(result);
    result = binarySearchNonRec(test, 5);
    System.out.println(result);

  }
  
  /**
   * Returns the index of the target value in the given sorted array, 
   * or -1 if not found.
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearch(int[] arr, int target)
  {
    return binarySearch(arr, target, 0, arr.length - 1);
  }
  
  /**
   * Helper method performs a recursive binary search of the given
   * array between start and end, inclusive.
   * @param arr
   * @param target
   * @param start
   * @param end
   * @return
   */
  private static int binarySearch(int[] arr, int target, int start, int end)
  {
    if (start > end) 
    {
      // target was not found
      return -1;
    }
    
    int mid = (start + end) / 2;
    if (target == arr[mid])
    {
      return mid;
    }
    else if (target < arr[mid])
    {
      // search the left half
      return binarySearch(arr, target, start, mid - 1);
    }
    else
    {
      // search the right half
      return binarySearch(arr, target, mid + 1, end);
    }
  }
  
  /**
   * Nonrecursive version of binary search.
   * @param arr
   * @param target
   * @return
   */
  public static int binarySearchNonRec(int[] arr, int target)
  {
    int start = 0; 
    int end = arr.length - 1;
    while (start <= end)
    {
      int mid = (start + end) / 2;
      if (target == arr[mid])
      {
        return mid;
      }
      else if (target < arr[mid])
      {
        // search the left half
        end = mid - 1;
      }
      else
      {
        // search the right half
        start = mid + 1;
      }
    }
    return -1;
  }
  

}