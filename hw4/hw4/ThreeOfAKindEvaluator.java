package hw4;

/**
 * Evaluator for a hand containing (at least) three cards of the same rank.
 * The number of main cards is three.
 * 
 * The name of this evaluator is "Three of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class ThreeOfAKindEvaluator extends OnePairEvaluator
{
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param totalCards
   *   number of cards in a hand
   */
  public ThreeOfAKindEvaluator(int ranking, int totalCards)
  {
	  super(ranking, totalCards, 3, "Three of a Kind");
  }
}
