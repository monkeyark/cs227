package lab3;

import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 * The increase in population each year is a random value in the range 0 through 10.
 */
public class RabbitModel3
{
  // TODO - add instance variables as needed
	private int population;
	private Random rand = new Random(1);
	
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel3()
  {
	  population = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  population = population + rand.nextInt(11);
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
    // TODO
	  population = 0;
  }
}
