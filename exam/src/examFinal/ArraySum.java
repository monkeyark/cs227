package examFinal;


/**
 * An example of recursion on an array.
 */
public class ArraySum
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    int[] arr = {2, 10, 6, 4, 8};
    System.out.println(arraySum(arr));
  }

  /**
   * Computes the sum of elements in the given array. Note use
   * of helper method that keeps track of the start and end indices.
   * @param arr
   * @return
   */
  public static int arraySum(int[] arr)
  {
    return arraySumRec(arr, 0, arr.length - 1);
  }
  
  /**
   * Helper method recursively computes the sum of elements in the given
   * array between start and end, inclusive.  This version is a 
   * "divide-and-conquer" algorithm that splits the array in half.
   * @param arr
   * @param start
   * @param end
   * @return
   */
  private static int arraySumRec(int[] arr, int start, int end)
  {
    if (start == end)
    {
      return arr[start];
    }
    else
    {
      int mid = (start + end) / 2;
      int left = arraySumRec(arr, start, mid);
      int right = arraySumRec(arr, mid + 1, end);
      return left + right;
    }
  }


}
