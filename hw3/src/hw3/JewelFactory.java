package hw3;
import java.util.Random;

import api.Jewel;

/**
 * 
 * Generates random instances of Jewel.
 *
 */
public class JewelFactory
{

	private int maxType;
	private Random rand;
	
	/**
	 * Constructs a JewelFactory that will create Jewel objects with types 0 through givenMaxType - 1.
	 * @param givenMaxType
	 * 		number of types of Jewels
	 */
	public JewelFactory(int givenMaxType)
	{
		maxType = givenMaxType;
		rand = new Random();
	}
	
	/**
	 * Constructs a JewelFactory that will create jewels with types 0 through givenMaxType - 1. using the given Random instance.
	 * @param givenMaxType
	 * 		number of types of jewels
	 * @param rand
	 * 		random number generator to use
	 */
	public JewelFactory(int givenMaxType, java.util.Random rand)
	{
		maxType = givenMaxType;
		this.rand = rand;
	}
	
	/**
	 * Returns a random instance of Jewel with a type that is less than this factory's maximum value.
	 * @return
	 * 		a Jewel object with randomly selected type
	 */
	public Jewel generate()
	{
		return new Jewel(rand.nextInt(maxType));
	}
	
	/**
	 * Creates a grid of the given width and height that is initialized with random Jewels
	 * with type less than this factory's maximum type. The Jewels are produced using this
	 * factory's random number generator, where the random selection is restricted so that
	 * the resulting grid has no runs.
	 * @param width
	 * 		number of columns for the created grid
	 * @param height
	 * 		number of rows for the created grid
	 * @return
	 * 		a 2D array of randomly selected Jewel objects that contains no runs
	 */
	public Jewel[][] createGrid(int width, int height)
	{
		Jewel[][] jewels = new Jewel[width][height];
		for (int row=0; row<width; row++)
		{
			for (int col=0; col<height; col++)
			{
				jewels[row][col] = generate(); //jewels is generated horizontally
				if (row >= 2 //check run two neighbors above
					&& jewels[row][col].getType() == jewels[row-1][col].getType()
					&& jewels[row][col].getType() == jewels[row-2][col].getType()
					|| (col>=2 //check run two neighbors left
					&& jewels[row][col].getType() == jewels[row][col-1].getType()
					&& jewels[row][col].getType() == jewels[row][col-1].getType()))
				{
					col--;//back to previous solt and generate and chekc again
				}
			}
		}
		return jewels;
	}
}