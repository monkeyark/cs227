
package lab7;

/**
 * Class representing a playing card with possible rank 1 through 13 and four
 * possible suits.
 */

public class Card
{
//	
//	public static void main(String[] args)
//	{
//		Card[] arr = new Card[4];
//		
//	  Card a = new Card(3, Suit.CLUBS);
//	  Card b = new Card(3, Suit.DIAMONDS);
//	  Card c = new Card(4, Suit.HEARTS);
//	  Card d = new Card(5, Suit.SPADES);
//	  
//	  arr[0]=a;
//	  arr[1]=b;
//	  arr[2]=c;
//	  arr[3]=d;
//	  
//	  System.out.println(a);
//	  System.out.println(a.toString());
//	  //toString(arr);
//	  System.out.println(toString(arr));
//	}
	
  /**
   * Constants for the four suits.
   */
  public enum Suit
  {
    CLUBS, DIAMONDS, HEARTS, SPADES
  };

  /**
   * Suit for this card.
   */
  private final Suit suit;

  /**
   * Rank for this card.
   */
  private final int rank;

  /**
   * Names used for displaying strings.
   */
  private final String[] NAMES = {"Dummy", // element 0 not used
    "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Jack", "Queen", "King"};

  /**
   * Constructs a card with the given rank and suit. Ranks are assumed to be in
   * the range 1 through 13.
   * 
   * @param givenRank
   *          rank for this card
   * @param givenSuit
   *          suit for this card
   */
  public Card(int givenRank, Suit givenSuit)
  {
    rank = givenRank;
    suit = givenSuit;
  }

  /**
   * Returns the rank for this card.
   * 
   * @return rank for this card
   */
  public int getRank()
  {
    return rank;
  }

  /**
   * Returns the suit for this card.
   * 
   * @return suit for this card
   */
  public Suit getSuit()
  {
    return suit;
  }

  /**
   * Returns a String representation of this card.
   */
  public String toString()
  {
    return NAMES[rank] + " of " + suit;
  }

  /**
   * Returns a String representation of a given array of cards.
   * 
   * @param arr
   *          array of Card objects
   * @return a String representation of the given array
   */
  public static String toString(Card[] arr)
  {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < arr.length; ++i)
    {
      if (i > 0)
      {
        // every element after first one has comma before it
        sb.append(", ");
      }
      sb.append(arr[i]);
    }
    sb.append("]");
    return sb.toString();
  }

}
