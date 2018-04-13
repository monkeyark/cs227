package hw4;

import api.Card;

/**
 * Evaluator for a hand containing (at least) two cards of the same rank.
 * The number of main cards is two.
 * 
 * The name of this evaluator is "One Pair".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class OnePairEvaluator extends AbstractEvaluator
{
	/**
	 * Constructs the evaluator.
	 * @param ranking
	 *   ranking of this hand
	 * @param totalCards
	 *   number of cards in a hand 
	 */
	public OnePairEvaluator(int ranking, int totalCards)
	{
		super(ranking, totalCards, 2, "One Pair");
	}
	
	protected OnePairEvaluator(int ranking, int totalCards, int mainCards, String className)
	{
		super(ranking, totalCards, mainCards, className);
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
		else
		{
			for (int i=0; i<mainCards.length-1; i++)
			{
				if (mainCards[i].compareToIgnoreSuit(mainCards[i+1]) != 0)
				{
					return false;
				}
			}
		}
		return true;
	}
}
