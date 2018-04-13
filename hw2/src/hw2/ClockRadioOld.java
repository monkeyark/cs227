package hw2;
/**
 * 
 * This class simulate behavior of a clock radio
 */
public class ClockRadioOld
{

	/**
	 * Number of minutes in a 24-hour day.
	 */
	public static final int MINUTES_PER_DAY = 1440;
	
	/**
	 * Number of minutes to silence the alarm when snoozing.
	 */
	public static final int SNOOZE_MINUTES = 9;
	
	/**
	 * current raw clock time of radio clock
	 */
	private int clockTime;
	
	/**
	 * current raw alarm time of radio clock
	 */
	private int alarmTime;
	
	/**
	 * current raw effective alarm time of radio clock
	 * different to alarm time only when snooze is on
	 */
	private int effectiveAlarmTime;
	
	/**
	 * alarm enabling status of radio clock,
	 * true if alarm is enabled, false otherwise
	 */
	private boolean alarmIsEnabled;
	
	/**
	 * sounding status of radio clock,
	 * true if radio clock is sounding (can be on radio or buzzing)
	 */
	private boolean alarmSounding;
	
	/**
	 * status of time displaying mode,
	 * true if radio clock is on 24-hour mode, false otherwise
	 */
	private boolean is24HourMode;
	
	/**
	 * radio mode status of radio clock,
	 * true if radio clock is on radio, false on buzzing)
	 */
	private boolean radioModeOn;
	
	/**
	 * whether snooze is activated
	 * true if radio clock is on snooze, false otherwise
	 */
	private boolean snoozeOn;
	
	/**
	 * helper method constant
	 * Number of minutes in a hour is 60
	 */
	private static final int MINUTES_PER_HOUR = 60;
	
	/**
	 * for helper method amToMinutesRaw(int givenHours, int givenMinutes, boolean isPm)
	 * represent a raw time when converting from 12-hour mode to 24-hour mode
	 */
	private int timeToRawMinutes;
	
	/**
	 * for helper method timeToString(int givenMinutes, boolean Hour24Mode)
	 * a time string displayed in 12-hour mode or 24-hour mode,
	 * based on (boolean Hour24Mode)
	 */
	private String timeDisplayString;
	
	/**
	 * Constructs a clock radio with initial clock time at 00:00 and alarm time at 01:00.
	 * Initially the alarm is disabled, the alarm is not sounding, the display is in 24-hour mode,
	 * and radio mode is off.
	 */
	public ClockRadioOld()
	{
		clockTime = 0;
		alarmTime = MINUTES_PER_HOUR;
		effectiveAlarmTime = MINUTES_PER_HOUR;
		alarmIsEnabled = false; //alarm disable
		alarmSounding = false; //alarm not sounding
		is24HourMode = true; //display in 24-hour mode
		radioModeOn = false; //radio mode is off
	}
	
	/**
	 * Constructs a clock radio with the given initial clock time and with alarm time at 01:00.
	 * Initially the alarm is disabled, the alarm is not sounding, the display is in 24-hour mode,
	 * and radio mode is off.
	 * The argument is assumed to be non-negative but may be arbitrarily large.
	 * @param givenMinutesPastMidnight
	 * 		number of minutes past midnight for this clock's initial time
	 */
	public ClockRadioOld(int givenMinutesPastMidnight)
	{
		clockTime = givenMinutesPastMidnight % MINUTES_PER_DAY;
		alarmTime = MINUTES_PER_HOUR;
		effectiveAlarmTime = MINUTES_PER_HOUR;
		alarmIsEnabled = false; //alarm disable
		alarmSounding = false; //alarm not sounding
		is24HourMode = true; //display in 24-hour mode
		radioModeOn = false; //radio mode is off
	}
	
	/**
	 * Advances the clock time by the specified number of minutes.
	 * If the updated clock time passes or equals the effective alarm time, and the alarm is set,
	 * then the clock should go into ringing mode.
	 * If snooze is not in effect, "effective alarm time" is just the alarm time as currently set.
	 * If snooze is in effect, the "effective alarm time" is 9 minutes after the clock time
	 * at which the snooze() method was called.
	 * If the clock goes into ringing mode as a result of advancing the time, snooze is canceled.
	 * The arguments must be non-negative numbers but may be arbitrarily large.
	 * @param givenMinutes
	 * 		number of minutes to advance time
	 */
//	private int flag;
//	public int debugflag()
//	{
//		return flag;
//	}
	public void advanceTime(int givenMinutes)
	{
//====================================================
		//alarmIsEnabled   &&  clockTime advanced to the next day    &&    second day clockTime > effectiveAlarmTimes
		if (alarmIsEnabled && (clockTime + givenMinutes >= MINUTES_PER_DAY) && ((clockTime + givenMinutes) % MINUTES_PER_DAY >= effectiveAlarmTime))
		{
			alarmSounding = true;
		}
		//clockTimeRaw is the same day && clockTimeRaw is initially smaller than alarmTimeRaw but is bigger after time advance
		else if (alarmIsEnabled && (effectiveAlarmTime > clockTime && (clockTime + givenMinutes) >= effectiveAlarmTime)) 
		{
			alarmSounding = true;
		}
		//when alarm is currently sounding and snooze is off, alarm should continue sounding regardless of advance time
		//https://piazza.com/class/j6k801284cv66u?cid=158
		else if (alarmIsEnabled && alarmSounding && !snoozeOn)
		{
			alarmSounding = true;
		}
		else //alarmSounding = true, only happens when alarmIsEnabled and clockTimeRaw is initially smaller than alarmTimeRaw but is bigger after time advance
		{
			alarmSounding = false;
		}
		clockTime = (clockTime + givenMinutes) % MINUTES_PER_DAY;
//====================================================
//		if (alarmIsEnabled)
//		{
//			//alarmTime is on today && clockTime after advancing will pass alarmTime
//			if (((effectiveAlarmTime - clockTime) > 0) && ((effectiveAlarmTime - clockTime) <= givenMinutes))
//			{
//				alarmSounding = true;
//			}
//			//alarmTime is on second day && advanced time in second day pass alarmTime
//			else if ((clockTime+givenMinutes > MINUTES_PER_DAY) && (clockTime + givenMinutes) % MINUTES_PER_DAY >= effectiveAlarmTime)
//			{
//				alarmSounding = true;
//			}
//			//when alarm is currently sounding and snooze is off, alarm should continue sounding regardless of advance time
//			//https://piazza.com/class/j6k801284cv66u?cid=158
//			else if (alarmSounding && !snoozeOn)
//			{
//				alarmSounding = true;
//			}
//		}
//		else //(!alarmIsEnable)
//		{
//			alarmSounding = false;
//		}
//		clockTime = (clockTime + givenMinutes) % MINUTES_PER_DAY;
//====================================================
//		// second method: use time difference between clockTime and alarmTime
//		int timeToNextAlarm;
//		if (alarmIsEnabled)
//		{
//			timeToNextAlarm = effectiveAlarmTime - clockTime;
//			if (timeToNextAlarm <= 0)
//			{
//				timeToNextAlarm = timeToNextAlarm + MINUTES_PER_DAY; //givenMinutes; 
//			}
//			if (timeToNextAlarm - givenMinutes <= 0)
//			{
//				alarmSounding = true;
//			}
//			else
//			{
//				alarmSounding = false;
//			}
//		}
//		clockTime = (clockTime + givenMinutes) % MINUTES_PER_DAY;
//====================================================
	}
	
	/**
	 * Advances the clock time by the given hours and minutes.
	 * If the updated clock time passes or equals the effective alarm time, and the alarm is on,
	 * then the clock should go into sounding mode.
	 * If snooze is not in effect, "effective alarm time" is just the alarm time as currently set.
	 * If snooze is in effect, the "effective alarm time" is 9 minutes after the clock time
	 * at which the snooze() method was last called.
	 * If the clock goes into sounding mode as a result of advancing the time, snooze is canceled.
	 * The argument must be a non-negative number but may be arbitrarily large.
	 * @param givenHours
	 * 		number of hours to advance the time
	 * @param givenMinutes
	 * 		number of minutes to advance the time
	 */
	public void advanceTime(int givenHours, int givenMinutes)
	{
		advanceTime(MINUTES_PER_HOUR*givenHours + givenMinutes);
	}
	
	/**
	 * Turns off the alarm.
	 * Stops it from sounding (if it is sounding) and cancels snooze if it is in effect.
	 */
	public void alarmDisabled()
	{
		alarmIsEnabled = false;
		alarmSounding = false; //stop sounding
		snoozeOn = false; //cancel snooze
		effectiveAlarmTime = alarmTime;  //cancel change in effectiveAlarmTime
	}
	
	/**
	 * Turns the alarm on.
	 * This method does not cause the alarm to start sounding regardless of current clock time and alarm time.
	 * (If clock time and alarm time are equal, it will start sounding after time is advanced by 24 hours.)
	 */
	public void alarmEnabled()
	{
		alarmIsEnabled = true;
	}
	
	/**
	 * Returns the current alarm time as a string in one of the following forms, depending on
	 * whether the clock is currently in 24-hour mode: "hh:mm", "hh:mm AM", or "hh:mm PM".
	 * If the clock is in 24-hour mode, the hours value hh is between 0 and 23, inclusive, and if not,
	 * the hours value hh is between 1 and 12, inclusive, and the appropriate string "AM" or "PM" is appended.
	 * The minutes value mm is always between 0 and 59, inclusive.
	 *
	 * @return
	 * 		alarm time in string form
	 */
	public String getAlarmTimeAsString()
	{
		String timeString = timeToString(getAlarmTimeRaw(), is24HourMode);
		return timeString;
	}
	
	/**
	 * Returns the current alarm time as the number of minutes past midnight.
	 * This value is always between 0 and 1439, inclusive.
	 * @return
	 * 		number of minutes past midnight for the alarm time
	 */
	public int getAlarmTimeRaw()
	{
		return alarmTime;
	}
	
	/**
	 * Returns the current clock time as a string in one of the following forms, depending on
	 * whether the clock is currently in 24-hour mode: "hh:mm", "hh:mm AM", or "hh:mm PM".
	 * If the clock is in 24-hour mode, the hours value hh is between 0 and 23, inclusive,
	 * and if not, the hours value hh is between 1 and 12, inclusive,
	 * and the appropriate string "AM" or "PM" is appended.
	 * The minutes value mm is always between 0 and 59, inclusive.
	 * @return
	 * 		clock time in string form
	 */
	public String getClockTimeAsString()
	{
		String timeString = timeToString(getClockTimeRaw(), is24HourMode);
		return timeString;
	}
	
	/**
	 * Returns the current clock time as the number of minutes past midnight.
	 * This value is always between 0 and 1439, inclusive.
	 * @return
	 * 		number of minutes past midnight for the clock time
	 */
	public int getClockTimeRaw()
	{
		return clockTime;
	}
	
	/**
	 * Returns the current effective alarm time as a string in one of the following forms,
	 * depending on whether the clock is currently in 24-hour mode: "hh:mm", "hh:mm AM", or "hh:mm PM".
	 * If the clock is in 24-hour mode, the hours value hh is between 0 and 23, inclusive,
	 * and if not, the hours value hh is between 1 and 12, inclusive, 
	 * and the appropriate string "AM" or "PM" is appended.
	 * The minutes value mm is always between 0 and 59, inclusive.
	 * @return
	 * 		effective alarm time in string form
	 */
	public String getEffectiveAlarmTimeAsString()
	{
		String timeString = timeToString(getEffectiveAlarmTimeRaw(), is24HourMode);
		return timeString;
	}
	
	/**
	 * Returns the effective alarm time as the number of minutes past midnight.
	 * If snooze is not in effect, this value is the same as the current alarm time.
	 * This value is always between 0 and 1439, inclusive.
	 * @return
	 * 		number of minutes past midnight for the effective alarm time
	 */
	public int getEffectiveAlarmTimeRaw()
	{
		return effectiveAlarmTime;
	}
	
	/**
	 * Determines whether the alarm is currently buzzing.
	 * @return
	 * 		true if the clock is currently buzzing.
	 */
	public boolean isBuzzing()
	{
		return !radioModeOn && alarmSounding;
	}
	
	/**
	 * Determines whether the alarm is currently playing the radio.
	 * @return
	 * 		true if the clock is currently playing the radio.
	 */
	public boolean isPlayingRadio()
	{
		return radioModeOn && alarmSounding;
	}
	
	/**
	 * Determines whether the alarm is currently sounding (buzzer or radio).
	 * @return
	 * 		true if the clock is currently sounding.
	 */
	public boolean isSounding()
	{
		return alarmIsEnabled && alarmSounding;
	}
	
	/**
	 * Sets whether the clock should display time strings using 24-hour mode.
	 * (i.e. 00:00 to 23:59) or AM/PM mode (i.e. 12:00 AM to 11:59 PM).
	 * @param use24HourDisplay
	 * 		true if the clock should display time strings using 24-hour mode, false otherwise
	 */
	public void set24HourDisplay(boolean use24HourDisplay)
	{
		is24HourMode = use24HourDisplay;
	}
	
	/**
	 * Sets the alarm time to the given number of minutes past midnight.
	 * The hours and minutes are assumed to be non-negative but may be arbitrarily large.
	 * This method will not cause the clock to start sounding, and will not cause it to stop sounding
	 * if it is already in the sounding state. If snooze is in effect, it is canceled by this method.
	 * @param givenMinutesPastMidnight
	 * 		number of minutes past midnight
	 */
	public void setAlarmTime(int givenMinutesPastMidnight)
	{
		alarmTime = givenMinutesPastMidnight % MINUTES_PER_DAY;
		snoozeOn = false; //cancel snooze
		effectiveAlarmTime = alarmTime;  //cancel change in effectiveAlarmTime
	}
	
	/**
	 * Sets the alarm time to the given hours and minutes. 
	 * The hours are assumed to be in the range [1, 12] and minutes are assumed to be in the range [0, 59].
	 * The given time is interpreted as AM or PM based on the third argument, regardless of whether
	 * the clock is currently in 24-hour mode.
	 * This method will not cause the clock to start sounding, and will not cause it to stop sounding
	 * if it is already in the sounding state.
	 * If snooze is in effect, it is canceled by this method.
	 * @param givenHours
	 * 		hour for alarm time
	 * @param givenMinutes
	 * 		minutes for alarm time
	 * @param isPm
	 * 		true if the given hours and minutes should be interpreted as a PM time, false if AM
	 */
	public void setAlarmTime(int givenHours, int givenMinutes, boolean isPm)
	{
		//use helper method
		int timeRaw = amToMinutesRaw(givenHours, givenMinutes, isPm);
		setAlarmTime(timeRaw);
	}
	
	/**
	 * Sets whether the clock should play the radio or the buzzer when sounding the alarm.
	 * @param useRadio
	 * 		true if clock should play the radio when sounding, false otherwise
	 */
	public void setRadioMode(boolean useRadio)
	{
		radioModeOn = useRadio;
	}
	
	/**
	 * Sets the current clock time to the given number of minutes past midnight.
	 * The argument is assumed to be non-negative but may be arbitrarily large.
	 * This method will not cause the clock to start sounding, even if the alarm is currently set,
	 * and will not cause it to stop ringing if it is already in the ringing state.
	 * If snooze is in effect, it is canceled by this method.
	 * @param givenMinutesPastMidnight
	 * 		number of minutes past midnight
	 */
	public void setTime(int givenMinutesPastMidnight)
	{
		clockTime = givenMinutesPastMidnight % MINUTES_PER_DAY;
		snoozeOn = false; //cancel snooze
		effectiveAlarmTime = alarmTime;  //cancel change in effectiveAlarmTime
	}
	
	/**
	 * Sets the current clock time to the given hours and minutes.
	 * The hours are assumed to be in the range [1, 12] and minutes are assumed to be in the range [0, 59].
	 * The given time is interpreted as AM or PM based on the third argument, regardless of whether the clock
	 * is currently in 24-hour mode.
	 * This method will not cause the clock to start sounding, even if the alarm is currently set,
	 * and will not cause it to stop ringing if it is already in the ringing state. If snooze is in effect,
	 * it is canceled by this method.
	 * @param givenHours
	 * 		hour for alarm time
	 * @param givenMinutes
	 * 		minutes for alarm time
	 * @param isPm
	 * 		true if the given hours and minutes should be interpreted as a PM time, false if AM
	 */
	public void setTime(int givenHours, int givenMinutes, boolean isPm)
	{
		//use helper method
		int timeRaw = amToMinutesRaw(givenHours, givenMinutes, isPm);
		setTime(timeRaw);
	}
	
	/**
	 * Stops the clock from sounding and sets the effective alarm time for SNOOZE_MINUTES minutes
	 * after the current clock time. Does not disable the alarm or change the alarm time.
	 * Does nothing if the alarm is not currently sounding.
	 */
	public void snooze()
	{
		if (alarmSounding)
		{
			alarmSounding = false;
			effectiveAlarmTime = (clockTime + SNOOZE_MINUTES) % MINUTES_PER_DAY;
			snoozeOn = true;
		}
	}
	
	/**
	 * Helper Method: Sets the given time to the given hours and minutes.
	 * The hours are assumed to be in the range [1, 12] and minutes are assumed
	 * to be in the range [0, 59].
	 * The given time is interpreted as AM or PM based on the third argument,
	 * regardless of whether the clock is currently in 24-hour mode.
	 * @param givenHours
	 * 		hour for given time
	 * @param givenMinutes
	 * 		minutes for given time
	 * @param isPm
	 * 		true if the given hours and minutes should be interpreted as a PM time, false if AM
	 */
	private int amToMinutesRaw(int givenHours, int givenMinutes, boolean isPm)
	{
		if (isPm)
		{
			timeToRawMinutes = (MINUTES_PER_HOUR * (givenHours%12 + 12) + givenMinutes);
		}
		else
		{
			timeToRawMinutes = (MINUTES_PER_HOUR * (givenHours%12) + givenMinutes);
		}
		return timeToRawMinutes;
	}
	
	/**
	 * Helper Method: Returns the time as a string in one of the following forms,
	 * depending on whether the clock is currently in 24-hour mode:
	 * "hh:mm", "hh:mm AM", or "hh:mm PM".
	 * If the clock is in 24-hour mode, the hours value hh is between 0 and 23,
	 * inclusive, and if not, the hours value hh is between 1 and 12, inclusive, 
	 * and the appropriate string "AM" or "PM" is appended.
	 * The minutes value mm is always between 0 and 59, inclusive.
	 * @param givenMinutes
	 * 		time need to display in number of raw minutes
	 * @param Hour24Mode
	 * 		true if on 24-hour display, false otherwise
	 * @return
	 * 		time string in 24-hour or 12-hour display
	 */
	private String timeToString(int givenMinutes, boolean Hour24Mode)
	{
		if (Hour24Mode)
		{
			timeDisplayString = String.format("%02d:%02d", givenMinutes / MINUTES_PER_HOUR, givenMinutes % MINUTES_PER_HOUR);
		}
		else
		{
			if (givenMinutes / MINUTES_PER_HOUR == 0)
			{
				timeDisplayString = String.format("12:%02d AM", givenMinutes % MINUTES_PER_HOUR);
			}
			else if (givenMinutes / MINUTES_PER_HOUR < 12)
			{
				timeDisplayString = String.format("%02d:%02d AM", givenMinutes / MINUTES_PER_HOUR, givenMinutes % MINUTES_PER_HOUR);
			}
			else if (givenMinutes/MINUTES_PER_HOUR == 12)
			{
				timeDisplayString = String.format("12:%02d PM", givenMinutes % MINUTES_PER_HOUR);
			}
			else if (givenMinutes/MINUTES_PER_HOUR > 12)
			{
				timeDisplayString = String.format("%02d:%02d PM", (givenMinutes / MINUTES_PER_HOUR)-12, givenMinutes % MINUTES_PER_HOUR);
			}
		}
		return timeDisplayString;
	}
	
}
