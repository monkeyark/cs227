package hw2;

public class ClockRadioTest
{
	public static void main (String[] args)
	{
		System.out.println("After calling setTime, the clock time should be the value that was set.");
		ClockRadio c = new ClockRadio();
		System.out.println(c.getClockTimeRaw() + " //expected 0"); // expected 0
		c.setTime(60);
		System.out.println(c.getClockTimeRaw() + " //expected 60"); // expected 60
		
		//
		System.out.println("After calling advanceTime(15), the clock time should be 15 minutes later.");
		c.advanceTime(15);
		System.out.println(c.getClockTimeRaw() + " //expected 75"); // expected 75	
		
		//
		System.out.println("After calling advanceTime with a number of minutes greater than one day, the clock time should correctly wrap around.");
		c.advanceTime(4000);
		System.out.println(c.getClockTimeRaw() + " //expected 1195"); // expected 1195
		System.out.println("1==========================");
		System.out.println("");
		
		//
		System.out.println("");
//		If the alarm is enabled, advancing the time past the alarm time should cause the alarm to sound.
		c = new ClockRadio();
		c.setTime(300); // 5:00
		c.setAlarmTime(315); // 5:15
		System.out.println(c.getAlarmTimeRaw() + " //expected 315"); // expected 315
//		System.out.println(c.timeString(c.getAlarmTimeRaw()));
		c.alarmEnabled();
		System.out.println(c.isSounding() + " //expected false"); // expected false
		c.advanceTime(30);
		System.out.println(c.getClockTimeRaw() + " //expected 330"); // expected 330
		System.out.println(c.isSounding() + " //expected true"); // expected true
		System.out.println("2==========================");
		System.out.println("");
		
		//
		System.out.println("If the alarm is sounding, disabling the alarm should cause it to stop sounding.");
		c.alarmDisabled();
		System.out.println(c.isSounding() + " //expected false"); // expected false
		System.out.println("3==========================");
		System.out.println("");
		
		//
		System.out.println("Does your logic still work when the alarm time is a smaller number than the current clock\r\n" + 
				"time (i.e., you advance the time past midnight)? What about the other way around? Here's an\r\n" + 
				"example to try.");
		c.setTime(1430); // 23:50, or 11:50 PM
		c.setAlarmTime(5); // 00:05, or 12:05 AM
		System.out.println(c.getClockTimeRaw() + " //expected 1430"); // expected 1430
		System.out.println(c.getAlarmTimeRaw() + " //expected 5"); // expected 5
		c.alarmEnabled();
		System.out.println(c.isSounding() + " //expected false"); // expected false
		c.advanceTime(5);
		System.out.println(c.getClockTimeRaw() + " //expected 1435"); // expected 1435
		System.out.println(c.getAlarmTimeRaw() + " //expected 5"); // expected 5
		System.out.println(c.isSounding() + " //expected false"); // now 23:55, expected false
		c.advanceTime(5);
		System.out.println(c.getClockTimeRaw() + " //expected 0"); // expected 0
		System.out.println(c.getAlarmTimeRaw() + " //expected 5"); // expected 5
		System.out.println(c.isSounding() + " //expected false"); // now 00:00, expected false
		System.out.println(c.getClockTimeRaw() + " //expected 5"); // expected 5
		System.out.println(c.getAlarmTimeRaw() + " //expected 5"); // expected 5
		c.advanceTime(5);
		System.out.println(c.isSounding() + " //expected true"); // now 00:05, expected true

		
//		c.setTime(1430); // 23:50, or 11:50 PM
//		c.setAlarmTime(5); // 00:05, or 12:05 AM
//		c.alarmEnabled();
//		System.out.println(c.isSounding()); // expected false
//		c.advanceTime(5);
//		System.out.println(c.isSounding()); // now 23:55, expected false
//		c.advanceTime(5);
//		System.out.println(c.isSounding()); // now 00:00, expected false
//		c.advanceTime(5);
//		System.out.println(c.isSounding()); // now 00:05, expected true
		System.out.println("4==========================");
		System.out.println("");
		
		//
		System.out.println("Setting the alarm time should set the effective alarm time to the same value.");
		c = new ClockRadio();
		c.setTime(300); // 5:00
		c.setAlarmTime(315); // 5:15
		System.out.println(c.getAlarmTimeRaw() + " //expected 315"); // expected 315
		System.out.println(c.getEffectiveAlarmTimeRaw() + " //expected 315"); // expected 315
		System.out.println("5==========================");
		System.out.println("");
		
		//
		System.out.println("If snooze() is called when the alarm is sounding, the alarm stops sounding.");
		c = new ClockRadio();
		c.setTime(300); // 5:00
		c.setAlarmTime(315); // 5:15
		c.alarmEnabled();
		System.out.println(c.isSounding() + " //expected false"); // expected false
		c.advanceTime(30);
		System.out.println(c.isSounding() + " //expected true"); // expected true
		c.advanceTime(5);
		c.snooze();
		System.out.println(c.isSounding() + " //expected false"); // expected false
		System.out.println("6==========================");
		System.out.println("");
		
		//
		System.out.println("Calling snooze() alters the effective alarm time, but not the alarm time.");
		System.out.println(c.getClockTimeRaw() + " //expected 335"); // expected 335
		System.out.println(c.getAlarmTimeRaw() + " //expected 315"); // expected 315
		System.out.println(c.getEffectiveAlarmTimeRaw() + " //expected 344"); // expected 344
		System.out.println("7==========================");
		System.out.println("");
		
		//
		System.out.println("After snooze(), advancing the time past the effective alarm time causes the alarm to sound.");
		c.advanceTime(5);
		System.out.println(c.getClockTimeRaw() + " //expected 340"); // expected
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeRaw() + " //expected 315"); // expected 
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeRaw() + " //expected 344"); // expected
		System.out.println(c.getEffectiveAlarmTimeAsString());
		System.out.println(c.isSounding() + " //expected false"); // expected false
		
		c.advanceTime(4);
		System.out.println(c.getClockTimeRaw() + " //expected 344"); // expected
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeRaw() + " //expected 315"); // expected 
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeRaw() + " //expected 344"); // expected
		System.out.println(c.getEffectiveAlarmTimeAsString());
		System.out.println(c.isSounding() + " //expected true"); // expected true
//		System.out.println(c.debugflag());
		
		
		System.out.println("8==========================");
		System.out.println("");
		
		//
		System.out.println("After disabling the alarm, the effective alarm time should be the same as the alarm time.");
		c.alarmDisabled();
		System.out.println(c.getClockTimeRaw() + " //expected 344"); // expected 344
		System.out.println(c.getAlarmTimeRaw() + " //expected 315"); // expected 315
		System.out.println(c.getEffectiveAlarmTimeRaw() + " //expected 315"); // expected 315
		
		
		System.out.println("9==========================");
		System.out.println("");
		
		//
		System.out.println("Test time display");
		c.set24HourDisplay(true);
		c.setTime(300);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		c.setTime(30);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		c.setTime(1300);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		c.setTime(750);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		
		
		c.set24HourDisplay(false);
		c.setTime(300);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		c.setTime(30);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		c.setTime(1300);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
		c.setTime(750);
		System.out.println(c.getClockTimeAsString());
		System.out.println(c.getAlarmTimeAsString());
		System.out.println(c.getEffectiveAlarmTimeAsString());
			
		System.out.println("10==========================");
		System.out.println("");
		
		
	}
}
