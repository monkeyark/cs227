package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import api.IEvaluator;

public class Test {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Create a one pair evaluator that has ranking 3
		// and hand size of four cards
		IEvaluator eval = new OnePairEvaluator(3, 4);
		System.out.println(eval.getName()); // "One Pair"

		// Create an array of Cards to test. This is equivalent to
		// Card[] cards = {new Card(2, Suit.CLUBS), new Card(2, Suit.DIAMONDS)};
		// (see the Card class documentation)
		// This array should satisfy the One Pair evaluator.
		Card[] cards = Card.createArray("2c, 2d");
		System.out.println(Arrays.toString(cards));
		System.out.println(eval.satisfiedBy(cards)); // true
		// This one should not satisfy the one pair evaluator
		cards = Card.createArray("Kc, Qd");
		System.out.println(Arrays.toString(cards));
		System.out.println(eval.satisfiedBy(cards)); // false
		// This one won't either, since it has more than the
		// required number of cards
		cards = Card.createArray("2c, 2d, 3h");
		System.out.println(Arrays.toString(cards));
		System.out.println(eval.satisfiedBy(cards)); // false
		// However, it contains a subset that does
		System.out.println(eval.canSubsetSatisfy(cards)); // true
		// Try a bigger array. We'll use Arrays.sort to get them
		// in order, as required by the IEvaluator API. This
		// illustrates the ordering of the Card compareTo() method
		cards = Card.createArray("6s, Jd, Ah, 10h, 6h, Js, 6c, Kh, Qh");
		Arrays.sort(cards); // now [Ah, Kh, Qh, Js, Jd, 10h, 6s, 6h, 6c]
		System.out.println(Arrays.toString(cards));
		System.out.println(eval.canSubsetSatisfy(cards)); // true
		System.out.println("==================================");

		// Define a subset consisting of indices 6 and 8
		// and have the evaluator create a Hand from those cards
		int[] subset = {6, 8};
		Hand hand = eval.createHand(cards, subset);
		System.out.println(hand); // One Pair (3) [6s 6c : Ah Kh]

		// Subset at indices 0 and 3 doesn't satisfy evaluator, so
		// createHand returns null
		int[] subset2 = {0, 3};
		hand = eval.createHand(cards, subset2);
		System.out.println(hand); // null

		// Finds the best hand from these cards (for this evaluator)
		// which will be the pair of jacks plus ace and king
		hand = eval.createBestHand(cards);
		System.out.println(hand); // One Pair (3) [Js Jd : Ah Kh]
		System.out.println("==================================");
		
		// CatchAll evaluator Test
		IEvaluator eval2 = new CatchAllEvaluator(42, 4);    // requires 4 cards
		Card[] test1 = Card.createArray("10c, 8s, 7c, 2s");  // whatever
		System.out.println(eval2.satisfiedBy(test1)); // true
		Card[] test2 = Card.createArray("10c, 9c, 7c, 6c");  // happens to be a straight, too
		System.out.println(eval2.satisfiedBy(test2)); // true
		Card[] test3 = Card.createArray("10c, 8s, 7c"); 
		System.out.println(eval2.satisfiedBy(test3)); // false - not enough cards
		System.out.println("==================================");
		
		
		// Create a list of some evaluators for 5-card hands
		ArrayList<IEvaluator> evaluators = new ArrayList<IEvaluator>();
		evaluators.add(new OnePairEvaluator(3, 5));
//		evaluators.add(new FullHouseEvaluator(1, 5));
		evaluators.add(new StraightEvaluator(2, 5, 13));

		// Now find the best hand we can get from these cards
		Hand best = null;
		for (IEvaluator e : evaluators)
		{
		Hand h = e.createBestHand(cards);
		if (best == null || h != null && h.compareTo(best) < 0)
		{
		best = h;
		}
		}
		// Full House (1) [6s 6h 6c Js Jd]
		 System.out.println("Best hand: " + best);
	}

}
