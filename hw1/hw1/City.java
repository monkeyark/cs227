package hw1;

import java.lang.Math;

/**
 * 
 * City object represents a city name along with a cost per night for lodging.
 */
public class City
{
	/**
	 * The cost to mail a postcard from a city is this fraction
	 * times the city's lodging cost (rounded to the nearest integer)
	 */
	public static final double RELATIVE_COST_OF_POSTCARD = 0.05;
	
	/**
	 * name of given city
	 */
	private String name;
	
	/**
	 * cost for lodging one night in given city
	 */
	private int lodgingCost;
	
	/**
	 * Constructs a new City with the given name and lodging cost per night
	 * @param givenName
	 * 		name a city
	 * @param givenLodgingCost
	 * 		cost for lodging one night in given city
	 */
	public City(String givenName, int givenLodgingCost)
	{
		name = givenName;
		lodgingCost = givenLodgingCost;
	}
	
	/**
	 * Returns this city's name
	 * @return
	 * 		name of city
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns this city's lodging cost per night
	 * @return
	 * 		lodging cost per night
	 */
	public int lodgingCost()
	{
		return lodgingCost;
	}
	
	/**
	 * The value is a percentage of the lodging cost
	 * specified by the constant RELATIVE_COST_OF_POSTCARD,
	 * rounded to the nearest integer
	 * @return
	 * 		cost to send a postcard
	 */
	public int costToSendPostcard()
	{
		//round to nearest postcardCost to integer that least number is 1
		int postcardCost = Math.max(1,((int) Math.round(lodgingCost*RELATIVE_COST_OF_POSTCARD)));
		return postcardCost;
	}
	
	/**
	 * Returns the number of nights of lodging in this city that
	 * a traveler could afford with the given amount of money
	 * @param funds
	 * 		total current funds the traveler has
	 * @return
	 * 		number of nights can lodge with current funds
	 */
	public int maxLengthOfStay(int funds)
	{
		int lengthStay = funds / lodgingCost;
		return lengthStay;
	}
	
	/**
	 * Returns the number of postcards that a traveler could afford
	 * to send from this city with the given amount of money
	 * @param funds
	 * 		total current funds the traveler has
	 * @return
	 * 		max number of postcard can send
	 */
	public int maxNumberOfPostcards(int funds)
	{
		//round to nearest numberPostcard to integer that least number is 1
		int numberPostcard = funds / Math.max(1,((int) Math.round(costToSendPostcard())));
		return numberPostcard;
	}
	
}
