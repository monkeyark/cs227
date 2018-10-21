package mini1;

/**
 * Simple model of a strand of DNA.  An instance of this class encapsulates
 * a string of characters.  A character is called <em>valid</em> if it
 * is one of the the letters 'A', 'C', 'G', 'T' (uppercase) and a DNASequence
 * object is called <em>valid</em> if all its characters are valid.
 * The characters 'A' and 'T' are said to be <em>complements</em> of each 
 * other and likewise the characters 'C' and 'G' are complements.  
 * Complementary characters are said to <em>bond</em> with each other.
 * The main operations on this class are for the purpose of determining the 
 * number and locations of bonds that one sequence can form with another
 * depending how they are aligned (shifted) with each other.
 * <p>
 * However, it is entirely possible to construct a DNASequence object
 * containing invalid characters, and all operations should work
 * correctly for arbitrary characters.  Note that a character other than
 * 'A', 'C', 'G', or 'T' is never considered to bond with another character.
 */
public class DNASequence
{
	/**
	 * String of data for this sequence.
	 */
	private String data;
	
	/**
	 * Constructs a DNASequence object with the given string of data;
	 * this constructor does not check whether the given string
	 * is valid (see the method allValid).
	 * @param givenData
	 *   string of characters for this DNASequence
	 */
	public DNASequence(String givenData)
	{
		data = givenData;
	}
  
	  /**
	   * Returns a String representing the data for this
	   * DNASequence.
	   * @return
	   *   the characters in this DNASequence
	   */
	  public String toString()
	  {
		  return data;
	  }
	  
	  /**
	   * Determines whether all characters in this sequence
	   * are valid ('A', 'G', 'C', or 'T' in uppercase only).
	   * @return
	   *   true if all characters are valid, false otherwise
	   */
	  public boolean allValid()
	  {
		  if (data == null)
			  return false;
		  
		  boolean isA = false;
		  boolean isG = false;
		  boolean isC = false;
		  boolean isT = false;
		  for (int i=0; i<data.length(); i++)
		  {
			  if (data.charAt(i)=='A')
				  isA = true;
			  else if(data.charAt(i)=='T')
				  isG = true;
			  else if(data.charAt(i)=='C')
				  isC = true;
			  else if(data.charAt(i)=='G')
				  isT = true;
			  else
				  return false;
		  }
		  return isA && isG && isC && isT;
	  }
	  
	  /**
	   * Removes all invalid characters from this DNASequence.  For example, 
	   * if this object's data is the string <code>"TaGxy*!  Cz"</code>, 
	   * after calling this method, the data is <code>"TGC"</code>.
	   */
	  public void fix()
	  {
		  String fixData = "";
		  for (int i=0; i<data.length(); i++)
		  {
			  if (data.substring(i,i+1).equals("A"))
				  fixData = fixData + Character.toString(data.charAt(i));
			  else if(data.substring(i,i+1).equals("T"))
				  fixData = fixData + Character.toString(data.charAt(i));
			  else if(data.substring(i,i+1).equals("C"))
				  fixData = fixData + Character.toString(data.charAt(i));
			  else if(data.substring(i,i+1).equals("G"))
				  fixData = fixData + Character.toString(data.charAt(i));
		  }
		  data = fixData;
	  }
	  
	  /**
	   * Determines whether the given sequence is a subsequence
	   * of this one.  A string t is a subsequence of another
	   * string s if all characters of t can be found in s in the
	   * same order.  Equivalently, string t is a subsequence of s
	   * if t can be obtained by deleting some of the characters of s.
	   * Invalid characters in the given string are ignored.
	   * <p>
	   * For example "TxxAA" is a subsequence of "CTyyGCACA" but 
	   * not of "CAAT" nor of "TA".
	   * @param other
	   *   the given DNASequence
	   * @return
	   *   true if the given sequence is a subsequence of this one, 
	   *   false otherwise
	   */
	  public boolean isSubsequence(DNASequence other)
	  {
//TODO//First Method================================================
//		  this.fix();
//		  other.fix();
//		  String tempData = "";
//		  int j=0;
//		  for (int i=0; i<this.data.length(); i++)
//		  {
//			  boolean checked = true;
//			  while (other.data.charAt(i) == this.data.charAt(j) && checked)
//			  {
//				  tempData = tempData + Character.toString(this.data.charAt(i));
//				  checked = false;
//				  j++;
//			  }
//		  }
//		  return tempData.equals(other.data);
//Second Method==================================================
		  this.fix();
		  other.fix();
		  int i = 0;
		  int j = 0;
		  while (i<this.data.length() && j<other.data.length())
		  {
			  if (this.data.charAt(i) == other.data.charAt(j))
				  j++;
			  i++;
		  }
		  return j==other.data.length();
//===============================================================
	  }
	  
	  /**
	   * Returns true if the two characters are complementary
	   * ('A' with 'T' or 'C' with 'G').
	   * @param c1
	   *   potential character for a base pair
	   * @param c2
	   *   potential character for a base pair
	   * @return
	   *   true if the two characters are 'A' and 'T' or 'C' and 'G';
	   *   false otherwise
	   */
	  public boolean willBond(char c1, char c2)
	  {
		  if ((c1 == 'A' && c2 == 'T') || (c1 == 'T' && c2 == 'A'))
			  return true;
		  else if ((c1 == 'C' && c2 == 'G') || (c1 == 'G' && c2 == 'C'))
			  return true;
		  else
			  return false;
	  }
	    
	  /**
	   * Replaces this object's data with its complement;
	   * that is, 'A' is replaced with 'T' and so on.
	   * Invalid characters are not modified.
	   * For example, if the data for this sequence is "AGTT", after
	   * this method is called the data would be "TCAA".  
	   */
	  public void complement()
	  {
		  String replaceComplement = "";
		  for (int i=0; i<data.length(); i++)
		  {
			  if (data.substring(i,i+1).equals("A"))
				  replaceComplement = replaceComplement + "T";
			  else if(data.substring(i,i+1).equals("T"))
				  replaceComplement = replaceComplement + "A";
			  else if(data.substring(i,i+1).equals("C"))
				  replaceComplement = replaceComplement + "G";
			  else if(data.substring(i,i+1).equals("G"))
				  replaceComplement = replaceComplement + "C";
			  else
				  replaceComplement = replaceComplement + Character.toString(data.charAt(i));
		  }
		  data = replaceComplement;
	  }
	  
	  /**
	   * Returns the maximum possible number of bonds that can be formed
	   * with this sequence when the given sequence is shifted left or 
	   * right by any amount.
	   * @param other
	   *   the DNASequence to align with this one
	   * @return
	   *   maximum possible number of bonds 
	   */
	  public int findMaxPossibleBonds(DNASequence other)
	  {
		  int bonds = 0;
		  for (int i=-other.data.length(); i<other.data.length()+this.data.length(); i++)
		  {
			  bonds = Math.max(bonds, this.countBondsWithShift(other, i));
		  }
	    return bonds;
	  }
	  
	  /**
	   * Returns the number of bonds that are formed with this sequence
	   * when the given sequence is shifted right by the given number
	   * of spaces (where a negative number
	   * represents a left shift).
	   * @param other
	   *   the DNASequence to align with this one
	   * @param shift
	   *   number of spaces to the right that the other sequence is shifted
	   * @return
	   *   number of bonds formed when the given sequence is 
	   *   aligned with this one, with the given shift
	   */
	  public int countBondsWithShift(DNASequence other, int shift)
	  {
		  int counter=0;
		  if (shift >= 0) //shift other.data to right
			  for (int i=0; i<Math.min(other.data.length(),this.data.length()-shift); i++)
			  {
				  if(willBond(this.data.charAt(shift+i),other.data.charAt(i)))
					  counter++;
			  }
		  else
			  /*shift this.data to left
		  		start check from abs(shift)(shift is negative number)
			  	when other.length>this.length, i stop at other.length-abs(shift)(shift is negative number)
			  	when other.length<this.length, i stop at this.length*/
			  for (int i=0; i<Math.min(other.data.length()+shift,this.data.length()); i++)
			  {
				  if(willBond(this.data.charAt(i),other.data.charAt(i-shift)))
					  counter++;
			  }
		  return counter;
	  }
	  
	  /**
	   * Returns a string showing which characters in this sequence
	   * are bonded when the given sequence is shifted right by the given number
	   * of spaces (where a negative number represents a left shift).
	   * Non-matching characters are shown as dashes.  For example,
	   * if this sequence is "ATATGC" and the given sequence is "TCC",
	   * shifted right by 2, then this method returns "--A-G-"
	   * @param other
	   *   the sequence to which this one is being matched
	   * @param shift
	   *   the number of spaces the other sequence is shifted to the right
	   * @return
	   *   string indicating where matches occur
	   */  
	  public String findBondsWithShift(DNASequence other, int shift)
	  {
		  String match = "";
		  char[] arr = new char[this.data.length()];
		  if (shift >= 0) //shift other.data to right
		  {
			  for (int i=0; i<Math.min(other.data.length(),this.data.length()-shift); i++)
			  {
				  if(willBond(this.data.charAt(i+shift),other.data.charAt(i)))
					  arr[i+shift]= this.data.charAt(i+shift);
			  }
			  for(int j=0; j<arr.length; j++)
			  {
				  if (arr[j] != 0)
					  match = match + arr[j];
				  else
					  match = match + "-";
			  }
		  }
		  else
		  {
			  /*shift this.data to left
		  		start check from abs(shift)
			  	when other.length>this.length, i stop at other.length-abs(shift)
			  	when other.length<this.length, i stop at this.length*/
			  
			  for (int i=0; i<Math.min(other.data.length()+shift,this.data.length()); i++)
			  {
				  if(willBond(this.data.charAt(i),other.data.charAt(i-shift)))
					  arr[i]= this.data.charAt(i);
			  }
			  for(int j=0; j<arr.length; j++)
			  {
				  if (arr[j] != 0)
					  match = match + arr[j];
				  else
					  match = match + "-";
			  }
		  }
		  return match;
	  }
	}