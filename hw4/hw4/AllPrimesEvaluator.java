package hw4;

import api.Card;

/**
 * Evaluator for a hand in which the rank of each card is a prime number.
 * The number of main cards is equal to the total cards. 
 * 
 * The name of this evaluator is "All Primes".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class AllPrimesEvaluator extends AbstractEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param totalCards
   *   number of cards in a hand
   */
  public AllPrimesEvaluator(int ranking, int totalCards)
  {
		super(ranking, totalCards, totalCards, "All Primes");
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
		for (int i=0; i<mainCards.length; i++)
		{
			for (int j = 2; j<mainCards[i].getRank(); j++)
			{
				if (mainCards[i].getRank() % j == 0)
				{
					return false;
				}
			}
		}
		return true;
	}
}
