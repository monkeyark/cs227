package hw4;

import api.Card;
import api.Hand;
import api.Util;

/**
 * Evaluator for a generalized full house.  The number of main
 * cards is equal to the total cards.  If the total cards N is an even number,
 * then the cards must consist of two groups of N / 2 cards that have matching rank.  
 * If N is an odd number, then the cards must consist of two groups, one of 
 * (N / 2) + 1 cards of matching rank and other of (N / 2) cards of matching rank. 
 * (This evaluator is always satisfied when all cards are of the same rank.)
 * In the case that N is odd, when creating
 * a hand, <strong>the larger group must be listed first even if of lower rank
 * than the smaller group</strong> (e.g. as [3 3 3 5 5] rather than [5 5 3 3 3]).
 * 
 * The name of this evaluator is "Full House".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FullHouseEvaluator extends AbstractEvaluator
{
	public FullHouseEvaluator(int ranking, int totalCards)
	{
		super(ranking, totalCards, totalCards, "Full House");
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
		else if (mainCards.length == 1)
		{
			return false;
		}
		else if (mainCards.length == 2)
		{
			return true;
		}
		if (totalCards()%2 == 0)
		{
			return (mainCards[0].getRank() == mainCards[totalCards()/2 - 1].getRank() && mainCards[totalCards()/2].getRank() == mainCards[mainCards.length-1].getRank());
		}
		else if (totalCards()%2 == 1)
		{
			return ((mainCards[0].getRank() == mainCards[totalCards()/2].getRank() && mainCards[totalCards()/2 + 1].getRank() == mainCards[mainCards.length-1].getRank())
					|| (mainCards[0].getRank() == mainCards[totalCards()/2 - 1].getRank() && mainCards[totalCards()/2].getRank() == mainCards[mainCards.length-1].getRank()));
		}
		return false;
	}
	
	/**
	   * Returns the best possible hand satisfying this evaluator's 
	   * criteria that can be formed from the given list of cards.
	   * "Best" is defined to be first according to the compareTo() method of 
	   * Hand.  Returns null if there is no such hand.  The number of main cards 
	   * in the hand will be the value of <code>numMainCards()</code>.
	   * If the length of the given array of cards is less than 
	   * <code>totalCards()</code>, this method returns null.  The
	   * given array must be sorted with highest-ranked card first
	   * according to <code>Card.compareTo()</code>.  The array
	   * is not modified by this operation.
	   *  
	   * @param allCards
	   *   list of cards from which to create the hand
	   * @return
	   *   best possible hand satisfying this evaluator that can be formed
	   *   from the given cards, or null if there is no such hand
	   */
	@Override
	public Hand createHand(Card[] allCards, int[] subset)
	{
		if (!satisfiedBy(Util.getCardSubset(allCards, subset))
			|| allCards.length < totalCards()
			|| subset.length != numMainCards())
		{
			return null;
		}
		else
		{
			Card[] sideCards = new Card[totalCards()-numMainCards()];
			for (int i=0; i<sideCards.length; i++) //finding subset of allCards
			{
				sideCards[i] = Util.getCardNonSubset(allCards, subset)[i];
			}
			Card[] mainCards = Util.getCardSubset(allCards, subset);
			Card[] tempMainCards = new Card[mainCards.length];
			if (totalCards()%2== 1 && (mainCards[0].getRank() != mainCards[totalCards()/2].getRank()))
			{
				for (int i=0; i<mainCards.length; i++)
				{
					tempMainCards[i] = mainCards[mainCards.length-1-i];
				}
				return new Hand(tempMainCards, sideCards, getName(), getRanking());
			}
			else
			{
				return new Hand(Util.getCardSubset(allCards, subset), sideCards, getName(), getRanking());
			}
		}
	}
}
