package lab3;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits.
 * The population follows the Fibonacci sequence,
 * in which the current population is the sum of the previous two years' populations.
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
	private int population, lastYear, yearBefore;
	
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
	  population = 1;
	  lastYear = 0;
	  yearBefore = 0;
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
	  lastYear = population;
	  population = lastYear + yearBefore;
	  yearBefore = lastYear;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  population = 1;
	  lastYear = 0;
	  yearBefore = 0;
  }
}
