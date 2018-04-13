package hw4;

import java.util.Arrays;

import api.Card;
import api.Hand;
import api.IEvaluator;

public class Test1 {

	public static void main(String[] args) {
		
//		IEvaluator eval = new OnePairEvaluator(3, 5);
//		IEvaluator eval4 = new FourOfAKindEvaluator(3, 5);
//		IEvaluator eval3 = new ThreeOfAKindEvaluator(3, 5);
//		System.out.println(eval3.getName()); // "Three of a Kind"		
//		Card[] cards = Card.createArray("2c, 2d, 2s");
//		System.out.println(Arrays.toString(cards));
//		System.out.println(eval3.satisfiedBy(cards)); 		
//		 cards = Card.createArray("Kc, Qd, Jd, 8d");
//		 System.out.println(Arrays.toString(cards));
//		 System.out.println(eval3.satisfiedBy(cards)); 		
//		 cards = Card.createArray("2c, 2d, 3h, 2h");
//		 System.out.println(Arrays.toString(cards));
//		 System.out.println(eval3.satisfiedBy(cards)); 		
//		 System.out.println(eval3.canSubsetSatisfy(cards));
//		 cards = Card.createArray("6s, Jd, Ah, 10h, 6h, Js, 6c, Kh, Qh, Jh, 6s, Js");
//		 Arrays.sort(cards); 
//		 System.out.println(Arrays.toString(cards));
//		 System.out.println(eval3.canSubsetSatisfy(cards));		
//		int[] subset = {8, 9, 10};
//		Hand hand = eval3.createHand(cards, subset);
//		System.out.println(hand);
//		int[] subset2 = {0, 3, 7};
//		hand = eval3.createHand(cards, subset2);
//		System.out.println(hand); 
//		hand = eval3.createBestHand(cards);
//		System.out.println(hand);
//		System.out.println("");
//		
//		ArrayList<IEvaluator> evaluators = new ArrayList<IEvaluator>();
//		evaluators.add(new OnePairEvaluator(3, 5));
//		evaluators.add(new FullHouseEvaluator(1, 5));
//		evaluators.add(new StraightEvaluator(2, 5, 13));		
//		Hand best = null;
//		for (IEvaluator e : evaluators)
//		{
//		Hand h = e.createBestHand(cards);
//			if (best == null || h != null && h.compareTo(best) < 0)
//			{
//				best = h;
//			}
//		}
//		 System.out.println("Best hand: " + best);
//		 System.out.println("");
//		 
			IEvaluator fullHouse = new FullHouseEvaluator(42, 4);
			Card[] test1 = Card.createArray("10c, 2d, 2s, 8s, 7c, 2s, 9d, 9s, 10s, 10d, 10s"); 
			Arrays.sort(test1);
			System.out.println(Arrays.toString(test1));
			int[] subset0 = {0, 1, 9, 10};
			Hand hand0 = fullHouse.createHand(test1, subset0);
			Hand hand1 = fullHouse.createBestHand(test1);
			System.out.println(hand0);
			System.out.println(hand1);
			System.out.println("");
			
			IEvaluator fullHouse2 = new FullHouseEvaluator(42, 5);
			Card[] testFullHouse2 = Card.createArray("Jc, 2d, 2s, Js, 7c, 2s, 9d, 9s, 10s, 10d, 10s");
			Arrays.sort(testFullHouse2);
			Hand handFullHouse1 = fullHouse2.createBestHand(testFullHouse2);
			System.out.println(handFullHouse1);
		 
		 
		 
		
		
//		IEvaluator prime = new AllPrimesEvaluator(2, 3);
//		System.out.println(prime.getName());
//		Card[] cards = Card.createArray("2c, 3d, 4s, 5s, 6d");
//		Arrays.sort(cards);
//		System.out.println(Arrays.toString(cards));
//		System.out.println(prime.satisfiedBy(cards)); 		
//		System.out.println(prime.canSubsetSatisfy(cards));
//		int[] subset = {1, 3, 4};
//		Hand hand = prime.createHand(cards, subset);
//		System.out.println(hand); 		
//		int[] subset2 = {0, 2, 4};
//		hand = prime.createHand(cards, subset2);
//		System.out.println(hand);
//		hand = prime.createBestHand(cards);
//		System.out.println(hand);
		
//		IEvaluator suits = new AllSuitsEvaluator(2, 6);
//		System.out.println(suits.getName());
//		Card[] cardsSuit = Card.createArray("1d, 2c, 3d, 4s, 5s, 6d, 7h, 9d");
//		Arrays.sort(cardsSuit);
//		System.out.println(Arrays.toString(cardsSuit));
//		System.out.println(suits.satisfiedBy(cardsSuit)); 		
//		System.out.println(suits.canSubsetSatisfy(cardsSuit));
//		int[] subsetSuit = {0, 1, 3, 6};
//		Hand handSuit = suits.createHand(cardsSuit, subsetSuit);
//		System.out.println(handSuit); 		
//		int[] subsetSuit2 = {0, 2, 4, 6};
//		handSuit = suits.createHand(cardsSuit, subsetSuit2);
//		System.out.println(handSuit);
//		handSuit = suits.createBestHand(cardsSuit);
//		System.out.println(handSuit);
//	
//		IEvaluator catchAll = new CatchAllEvaluator(42, 4);    // requires 4 cards
//		Card[] test0 = Card.createArray("10c, 8s, 7c, 2s");  // whatever
//		System.out.println(catchAll.satisfiedBy(test0)); // true
//		Card[] test2 = Card.createArray("10c, 9c, 7c, 6c");  // happens to be a straight, too
//		System.out.println(catchAll.satisfiedBy(test2)); // true
//		Card[] test3 = Card.createArray("10c, 8s, 7c"); 
//		System.out.println(catchAll.satisfiedBy(test3)); // false - not enough cards
		
		
//		IEvaluator Straight = new StraightEvaluator(42, 5, 13);
//		Card[] testStraight = Card.createArray("Kd, 4s, Ad, 7s, 8d, 5d, 6s, 9s, 10h, Js, Qh, 2s");
//		Arrays.sort(testStraight);
//		System.out.println(Arrays.toString(testStraight));
//		System.out.println(Straight.satisfiedBy(testStraight));
//		System.out.println(Straight.canSubsetSatisfy(testStraight));
//		int[] subsetStraight = {0, 1, 2, 3, 4};
//		Hand handStraight = Straight.createHand(testStraight, subsetStraight);
//		System.out.println(handStraight);
//		Hand handBest = Straight.createBestHand(testStraight);
//		System.out.println(handBest);
//		
//		int[] subsetStraight2 = {0, 1};
//		Card[] testStraight2 = Card.createArray("Ac, 9c");
//		Hand handStraight2 = Straight.createHand(testStraight2, subsetStraight2);
//		System.out.println(handStraight2);
//		Hand handBest2 = Straight.createBestHand(testStraight2);
//		System.out.println(handBest2);
//		System.out.println("");
//		
//	    IEvaluator Straight2 = new StraightEvaluator(42, 4, 9);
//	    Card[] Straight2cards1 = Card.createArray("Ac, 9c, 8c, 7c");
//	    System.out.println(Straight2.satisfiedBy(Straight2cards1)); // true, ace used as highest
//	    Card[] Straight2cards2 = Card.createArray("Ac, 4c, 3c, 2c");
//	    System.out.println(Straight2.satisfiedBy(Straight2cards2)); // true, ace used as lowest
//	    Card[] Straight2cards3 = Card.createArray("Ac, Jc, 9s, 8h");
//	    System.out.println(Straight2.satisfiedBy(Straight2cards3)); //  false
//	    Card[] Straight2cards4 = Card.createArray("Ac, Kc, Qs, Jh");
//	    System.out.println(Straight2.satisfiedBy(Straight2cards4)); // false
//	    
//		IEvaluator StraightFlush = new StraightFlushEvaluator(42, 5, 5);
//		Card[] testStraightFlush = Card.createArray("1d, 2d, 3d, 4s, 5d, 4d, 1s, 2s, 3s, 5s");
//		Arrays.sort(testStraightFlush);
//		System.out.println(Arrays.toString(testStraightFlush));
//		System.out.println(StraightFlush.satisfiedBy(testStraightFlush));
//		System.out.println(StraightFlush.canSubsetSatisfy(testStraightFlush));
//		int[] subsetStraightFlush = {0, 2, 4, 6, 8};
//		Hand handStraightFlush = StraightFlush.createHand(testStraightFlush, subsetStraightFlush);
//		System.out.println(handStraightFlush);
//		Hand handBestFlush = StraightFlush.createBestHand(testStraightFlush);
//		System.out.println(handBestFlush);
		
	}

}
