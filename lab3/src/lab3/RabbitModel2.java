package lab3;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 * The population starts at 500 and decreases by half each year.
 */
public class RabbitModel2
{
  // TODO - add instance variables as needed
	private int population;
	
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel2()
  {
	  population = 500;
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
	  population = population / 2;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  population = 500;
  }
}
