package hw4;

import java.util.ArrayList;

import api.Card;
import api.Hand;
import api.IEvaluator;
import api.SubsetFinder;
import api.Util;

/**
 * The class AbstractEvaluator includes common code for all evaluator types.
 * 
 * TODO: Expand this comment with an explanation of how your class hierarchy
 * is organized.
 */
public abstract class AbstractEvaluator implements IEvaluator
{
	
	private int EvaluatorRanking;
	private int numTotalCards;
	private String name;
	private int numMainCards;
	
	
	protected AbstractEvaluator(int ranking, int totalCards, int mainCards, String className)
	{
		EvaluatorRanking = ranking;
		numTotalCards = totalCards;
		numMainCards = mainCards;
		name = className;
	}
	
	/**
	 * Returns a name for this evaluator.
	 * @return
	 *   name of this evaluator
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the ranking for this evaluator, where a lower number
	 * is considered "better".
	 * @return
	 *		ranking for this evaluator
	 */
	public int getRanking()
	{
		return EvaluatorRanking;
	}
	
	/**
	   * Returns the number of main cards needed to satisfy this
	   * evaluator.
	   * @return
	   *   number of main cards
	   */
	public int numMainCards()
	{
		return numMainCards;
	}
	
	/**
	   * Returns the total number of cards in a hand created by this evaluator.
	   * (main cards plus side cards).  This value 
	   * is generally determined by the type of game being played, and
	   * may be larger than the value returned by <code>numMainCards</code>.
	   * @return
	   *   total number of cards in a hand
	   */
	public int totalCards()
	{
		return numTotalCards;
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
	public abstract boolean satisfiedBy(Card[] mainCards);
	
	/**
	   * Determines whether there exists a subset of the given cards
	   * that satisfies the criteria for this evaluator.  The length of
	   * the given array must be greater than or equal to the value
	   * returned by <code>numMainCards()</code>. The caller must ensure
	   * that the given array is sorted with highest-ranked card first
	   * according to <code>Card.compareTo()</code>.  The array
	   * is not modified by this operation.
	   * @param allCards
	   *   list of cards to evaluate
	   * @return
	   *   true if some subset of the given cards satisfy this evaluator
	   */
	public boolean canSubsetSatisfy(Card[] allCards)
	{
		boolean result = false;
		if (allCards.length < numMainCards())
		{
			return false;
		}
		else
		{
			ArrayList<Card[]> subset = SubsetFinder.findSubsets(allCards, this.numMainCards());
			Card[] subsetCards = new Card[this.numMainCards()];
			for (int i=0; i<subset.size(); i++)
			{
				for (int j=0; j<subset.get(0).length; j++)
				{
					subsetCards[j] = subset.get(i)[j];
				}
				result = result || satisfiedBy(subsetCards);
			}
			return result;
		}
	}
	
	/**
	   * Returns a hand whose main cards consist of the indicated subset
	   * of the given cards.  If the indicated subset does
	   * not satisfy the criteria for this evaluator, this
	   * method returns null. The subset is described as
	   * an ordered array of indices to be selected from the given
	   * Card array.  The number of main cards in the hand
	   * will be the value of <code>numMainCards()</code>
	   * and the total number of cards in the hand will
	   * be the value of <code>totalCards()</code>.  The side
	   * cards will consist of the <em>best</em> cards remaining after
	   * selecting the indicated main cards.  If the length
	   * of the given array of cards is less than <code>totalCards()</code>,
	   * or if the length of the given array of indices is not equal to
	   * <code>numMainCards()</code> this method returns null.  The caller must ensure
	   * that the given array is sorted with highest-ranked card first
	   * according to <code>Card.compareTo()</code>. The array
	   * is not modified by this operation.
	   * 
	   * @param allCards
	   *   list of cards from which to select the main cards for the hand
	   * @param subset
	   *   list of indices of cards to be selected, in ascending order
	   * @return
	   *   hand whose main cards consist of the indicated subset, or null
	   *   if the indicated subset does not satisfy this evaluator
	   */
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
			return new Hand(Util.getCardSubset(allCards, subset), sideCards, getName(), getRanking());
		}
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
	public Hand createBestHand(Card[] allCards)
	{
		if(!canSubsetSatisfy(allCards)
			|| allCards.length < totalCards())
		{
			return null;
		}
		ArrayList<int[]> subsetList = SubsetFinder.findSubsets(allCards.length, numMainCards());
		Hand bestHand = null;
		for (int i=0; i<subsetList.size(); i++)
		{
			Hand currentHand = createHand(allCards, subsetList.get(i));
			if (currentHand != null)
			{
				if (bestHand == null)
				{
					bestHand = currentHand;
				}
				else if (bestHand.compareTo(currentHand) > 0)
				{
					bestHand = currentHand;
				}
			}
		}
		return bestHand;
	}
}
