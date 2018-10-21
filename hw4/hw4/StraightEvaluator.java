package hw4;

import api.Card;

/**
 * Evaluator for a hand consisting of a "straight" in which the
 * card ranks are consecutive numbers.  The number of main 
 * cards is equal to the total cards.  An ace (card of rank 1) 
 * may be treated as the highest possible card or as the lowest
 * (but not both).  To evaluate a straight containing an ace it is
 * necessary to know what the highest card rank will be in a
 * given game; therefore, this value is specified when the
 * evaluator is constructed.  In a hand created by this
 * evaluator the cards are listed in descending order with high 
 * card first, e.g. [10 9 8 7 6] or [A K Q J 10], with
 * one exception: In case of an ace-low straight, the ace
 * must appear last, as in [5 4 3 2 A].
 * 
 * The name of this evaluator is "Straight".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class StraightEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator. Note that the maximum rank of
   * the cards to be used must be specified in order to 
   * correctly evaluate a straight with ace high.
   * @param ranking
   *   ranking of this hand
   * @param totalCards
   *   number of cards in a hand
   * @param maxCardRank
   *   largest rank of any card to be used
   */
  public StraightEvaluator(int ranking, int totalCards, int maxCardRank)
  {
	  super(ranking, totalCards, totalCards, "Straight");
	  maxRank = maxCardRank;
  }
	
  /**
   * maxCardRank from constructor
   */
	private int maxRank;
	
	/**
	 * Accessor method of maxRank
	 * @return
	 * 		maxCardRank
	 */
	private int getMaxRank()
	{
		return maxRank;
	}
	
	/**
	 * Determines whether the given group of cards satisfies the
	 * criteria for this evaluator. The length
	 * of the given array must exactly match the value
	 * returned by <code>numMainCards()</code>. The caller must ensure
	 * that the given array is sorted with highest-ranked card first
	 * according to <code>Card.compareTo()</code>. The array
	 * is not modified by this operation.
	 * @param mainCards
	 *		array of cards
	 * @return
	 *		true if the given cards satisfy this evaluator
	 */
	@Override
	public boolean satisfiedBy(Card[] mainCards)
	{
		if (mainCards.length != numMainCards())
		{
			return false;
		}
		if (mainCards.length == 1)
		{
			return true;
		}
		if (mainCards[0].getRank() == 1 && (mainCards[1].getRank() == getMaxRank() || mainCards[mainCards.length-1].getRank() == 2))
		{
			for (int i=1; i<mainCards.length-1; i++)
			{
				if (mainCards[i].getRank()-mainCards[i+1].getRank() != 1)
				{
					return false;
				}
			}
		}
		else
		{
			for (int i=0; i<mainCards.length-1; i++)
			{
				if (mainCards[i].getRank()-mainCards[i+1].getRank() != 1)
				{
					return false;
				}
			}
		}
		return true;
	}
}
