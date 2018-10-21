package lab3;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 * The population starts at zero and increases each year by 1 rabbit,
 * but after every 5 years,
 * oversaturation brings the population back down to 0.
 */
public class RabbitModel1
{
  // TODO - add instance variables as needed
	private int population;
	
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel1()
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
    return population % 5;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  population = population + 1;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  population = 0;
  }
}
