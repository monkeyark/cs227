package examFinal;

import java.util.Arrays;


public class MergeSort
{
  public static void main(String[] args)
  {
    int[] arr = {2, 5, 8, 7, 3};
    System.out.println(Arrays.toString(arr));
    MergeSort.mergeSort(arr);
    System.out.println(Arrays.toString(arr));
  }
  
  /**
   * Performs a recursive merge sort on the given array.  This version
   * does a lot of copying and requires 200% additional memory.
   * Various strategies can be used to minimize this; see MergeSortAlt
   * and MergeSortAlt2.
   * @param arr
   */
  public static void mergeSort(int[] arr)
  {
    // Base case
    if (arr.length <= 1)
    {
      return;
    }
    
    // Split into two new arrays
    int firstLength = arr.length / 2;
    int[] first = Arrays.copyOf(arr, firstLength);
    int[] second = Arrays.copyOfRange(arr, firstLength, arr.length);   
    
    // Recursively sort each half and merge back together
    mergeSort(first);
    mergeSort(second);
    int[] result = merge(first, second);
    
    //arr = result; <--won't work!!!
    
    // result now has to be copied back into the given array
    for (int i = 0; i < result.length; ++i)
    {
      arr[i] = result[i];
    }
  }
  
  /**
   * Merges two sorted arrays into a third one.
   * The given arrays 'first' and 'second' must already be sorted.
   * @param a
   * @param b
   * @param result
   */
  private static int[] merge(int[] a, int[] b)
  {
    int[] result = new int[a.length + b.length];
    
    int i = 0;                  // starting index in a
    int j = 0;                  // starting index in b
    final int iMax = a.length;  // max index in a
    final int jMax = b.length;  // max index in b
    int k = 0;                  // index in result
    
    while (i < iMax && j < jMax)
    {
      if (a[i] <= b[j])
      {
        result[k] = a[i];
        i = i + 1;
        k = k + 1;
       }
      else
      {
        result[k] = b[j];
        j = j + 1;
        k = k + 1;
      }
    }
    
    // pick up any stragglers
    while (i < iMax)
    {
      result[k] = a[i];
      i = i + 1;
      k = k + 1;
    }
    while (j < jMax)
    {
      result[k] = b[j];
      j = j + 1;
      k = k + 1;
    }
    
    return result;
  }
  
}