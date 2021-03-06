package hw4;

/**
 * Evaluator for a hand containing (at least) four cards of the same rank.
 * The number of main cards is four.
 * 
 * The name of this evaluator is "Four of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FourOfAKindEvaluator extends OnePairEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param totalCards
   *   number of cards in a hand
   */
  public FourOfAKindEvaluator(int ranking, int totalCards)
  {
	  super(ranking, totalCards, 4, "Four of a Kind");
  }
}
