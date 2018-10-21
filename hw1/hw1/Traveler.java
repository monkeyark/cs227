package hw1;

/**
 * 
 * A Traveler object models a student bumming around Europe, with very given amount of money.
 */
public class Traveler
{
	/**
	 * Proportionality constant when calling home for more money: the amount of money received
	 * is this constant times the number of postcards the traveler has sent home
	 * (since the last time she called home for money).
	 */
	public static final int SYMPATHY_FACTOR = 30;
	
	/**
	 * current fund the traveler possess
	 */
	private int currentFunds;
	
	/**
	 * number of nights the traveler need to stay in gloomy and cold train station
	 */
	private int stationNights;
	
	/**
	 * total number of postcards the traveler sent to home
	 */
	private int totalSentPostcards;
	
	/**
	 * traveler's history of city touring
	 */
	private String journal;
	
	/**
	 * current city the traveler locates
	 */
	private City currentCity;
	
	/**
	 * Constructs a traveler starting out with the given amount of money
	 * in the given city. The journal is initially a string consisting of
	 * "cityname(start)", where cityname is the name of the starting city
	 * @param initialFunds
	 * 		initial Money the traveler has
	 * @param initialCity
	 * 		initial location of the traveler
	 */
	
	public Traveler(int initialFunds, City initialCity)
	{
		currentFunds = initialFunds;
		currentCity = initialCity;
		stationNights = 0;
		totalSentPostcards = 0;
		//initialize journal
		journal = currentCity.getName() + "(start)";
	}
	
	/**
	 * Returns the name of the traveler's current city
	 * @return
	 * 		current city the traveler locates
	 */
	public String getCurrentCity()
	{
		return currentCity.getName();
	}
	
	/**
	 * Returns the amount of money the traveler currently has
	 * @return
	 * 		current money
	 */
	public int getCurrentFunds()
	{
		return currentFunds;
	}
	
	/**
	 * Returns the traveler's journal. The journal is a string
	 * of comma-separated values of the form cityname(number_of_nights)
	 * containing the cities visited by the traveler, in the order
	 * visited, along with the number of nights spent in each. The first
	 * value always has the form cityname(start) for the starting city
	 * @return
	 * 		traveling journal
	 */
	public String getJournal()
	{
		return journal;
	}
	
	/**
	 * Returns true if the traveler does not have enough money
	 * to send a postcard from the current city
	 * @return
	 * 		true if the travel has to cry out in the phone and beg his/her parents for money, false otherwise
	 */
	public boolean isSOL()
	{
		return currentFunds < currentCity.costToSendPostcard();
	}
	
	/**
	 * Returns the number of nights the traveler has spent in a
	 * train station when visiting a city without enough money for lodging
	 * @return
	 * 		number of nights stayed in gloomy and cold train station
	 */
	public int getTotalNightsInTrainStation()
	{
		return stationNights;
	}
	
	/**
	 * Simulates a visit by this traveler to the given city for the given number of nights.
	 * The traveler's funds are reduced based on the number of nights of lodging purchased.
	 * When the funds are not sufficient for numNights nights of lodging in the city,
	 * the number of nights spent in the train station is updated accordingly.
	 * The journal is updated by appending a comma, the city name, and the number of nights
	 * in parentheses.
	 * @param c
	 * 		name of the current visiting city
	 * @param numNights
	 * 		number of nights will stay in current visiting city
	 */
	public void visit(City c, int numNights)
	{
		currentCity = c;
		int lodgingNights = Math.min(currentCity.maxLengthOfStay(currentFunds),numNights);//actual lodgingNights is depends on the Funds
		currentFunds = currentFunds - lodgingNights * currentCity.lodgingCost();//subtract total lodging cost in one city from funds
		stationNights = stationNights + (numNights - lodgingNights);//update nights stays in train station 
		journal = journal + "," + currentCity.getName() + "(" + numNights + ")";//update journal
	}
	
	/**
	 * Sends the given number of postcards, if possible,
	 * reducing the traveler's funds appropriately and increasing
	 * the count of postcards sent. If there is not enough money,
	 * sends as many postcards as possible without allowing the funds
	 * to go below zero
	 * @param howMany
	 * 		number of postcards that will send to home
	 */
	public void sendPostcardsHome(int howMany)
	{
		int sentPostcards = Math.min(currentCity.maxNumberOfPostcards(currentFunds), howMany);
		currentFunds = currentFunds - sentPostcards * currentCity.costToSendPostcard(); //subtract cost for postcards sent from Funds
		totalSentPostcards = totalSentPostcards + sentPostcards;
	}
	
	/**
	 * Increases the traveler's funds by an amount equal to SYMPATHY_FACTOR
	 * times the number of postcards sent since the last call to this method,
	 * and resets the count of the number of postcards sent back to zero
	 */
	public void callHomeForMoney()
	{
		currentFunds = currentFunds + SYMPATHY_FACTOR * totalSentPostcards;
		totalSentPostcards = 0;
	}
}
