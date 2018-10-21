package mini1;
//import java.util.Arrays;

public class DNASequenceTest
{

	public static void main(String[] args)
	{
//		DNASequence a = new DNASequence("fdATGC");
//		DNASequence b = new DNASequence("ATGCGCTAGC");
		DNASequence c = new DNASequence("TTCGCATCTATCT");
		DNASequence d = new DNASequence("GATCAT");
		DNASequence e = new DNASequence("GxAyAzCw");
//		DNASequence f = new DNASequence("TCAT");//others
//		DNASequence g = new DNASequence("AGAGCAT");//this
//		System.out.println("Test allValid():");
//		System.out.println(a.allValid() + " | false");
//		System.out.println(b.allValid() + " | true");
//		System.out.println("");
		
//		System.out.println("Test fix():");
//		a.fix();
//		b.fix();
//		System.out.println(a + " | ATGC");
//		System.out.println(b + " | ATGCGCTAGC");
//		System.out.println("");
		
//		System.out.println("Test allValid() after fix():");
//		System.out.println(a.allValid() + " | true");
//		System.out.println(b.allValid() + " | true");
//		System.out.println("");
		
		System.out.println("Test isSubsequence():");
		System.out.println(c.isSubsequence(d) + " | true");
		System.out.println(c.isSubsequence(e) + " | true");
		System.out.println(c.toString() + " | TTCGCATCTATCT");
		System.out.println(d.toString() + " | GATCAT");
		System.out.println(e.toString() + " | GAAC");
		System.out.println("");
		
//		System.out.println("Test countBondsWithShift():");
//		System.out.println(f.countBondsWithShift(g, -2) + " | 3");
//		System.out.println("");
//		
//		System.out.println("Test findBondsWithShift():");
//		System.out.println(g.findBondsWithShift(f, 0) + " | AG-----");
//		System.out.println(g.findBondsWithShift(f, 1) + " | -------");
//		System.out.println(g.findBondsWithShift(f, 2) + " | --AG-A-");
//		System.out.println(g.findBondsWithShift(f, 3) + " | -------");
//		System.out.println(g.findBondsWithShift(f, 4) + " | ------T");
//		System.out.println(g.findBondsWithShift(f, -1) + " | --A----");
//		System.out.println(g.findBondsWithShift(f, -2) + " | -------");
//		System.out.println(g.findBondsWithShift(f, -3) + " | A------");
//		System.out.println("");
//		System.out.println();
		
		
//		char[] arr = new char[5];
//		System.out.println(arr);

//		String str = "ATCGTCGTCGCT";
//		char[] cArray = str.toCharArray();
//		System.out.println(cArray);

//		String[] thisIsAStringArray = { "Apple", "Banana", "Orange" };
//		String theString = Arrays.toString( thisIsAStringArray );
//		System.out.println( theString );
		
	}
}
