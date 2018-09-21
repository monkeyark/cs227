package examFinal;


public class PalindromeChecker
{

  public static void main(String[] args)
  {
    // TODO Auto-generated method stub
    System.out.println(isPalindromeAlt("aabcbaa"));
    System.out.println(isPalindromeAlt("aaba"));
  }

  /**
   * Checks whether given string is a palindrome (same
   * forwards and backwards).
   * @param s
   * @return
   */
  public static boolean isPalindrome(String s)
  {
    int len = s.length();
    if (len <= 1)
    {
      // base case, every string of 1 or 0 characters is a palindrome
      return true;
    }
    // recursive case: a string is a palindrome if the first and last characters match
    // AND the substring in between is also a palindrome
    return s.charAt(0) == s.charAt(len - 1) && isPalindrome(s.substring(1, len - 1));
  }
  
  
  
  // Alternate version uses indices for beginning and end instead of creating
  // a new substring for each recursive call.  Note use of helper method to
  // actually do the recursion
  public static boolean isPalindromeAlt(String s)
  {
    return isPalindromeAlt(s, 0, s.length() - 1);
  }

  private static boolean isPalindromeAlt(String s, int start, int end)
  {
    if (end <= start)
    {
      return true;
    }
    return s.charAt(start) == s.charAt(end) && isPalindromeAlt(s, start + 1, end - 1);
  }
  
}