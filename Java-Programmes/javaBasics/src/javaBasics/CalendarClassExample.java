package javaBasics;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarClassExample {

	public static void main(String[] args) {
		
		TimeZone tz = TimeZone.getTimeZone("GMT+5:30");
		//Calendar c = Calendar.getInstance(tz);
		
		Calendar c = Calendar.getInstance(tz, new Locale("en", "IN"));
		
		//Calendar c = Calendar.getInstance();
				
		System.out.println("Current Date and time: "+c.getTime());
        
     // declaring an array to store month abbreviations
        String month[] = { "Jan", "Feb", "Mar", "Apr",
                           "May", "Jun", "Jul", "Aug",
                           "Sep", "Oct", "Nov", "Dec" };

        // declaring an array to store AM or PM
        String amPm[] = { "AM", "PM" };
        
        // displaying the date, time, time zone and locale using get method
        System.out.print("Date: "
                         + month[c.get(Calendar.MONTH)] + " "
                         + c.get(Calendar.DATE) + ", "
                         + c.get(Calendar.YEAR) + "\n"
                         + "Time: "
                         + c.get(Calendar.HOUR) + ":"
                         + c.get(Calendar.MINUTE) + ":"
                         + c.get(Calendar.SECOND) + " "
                         + amPm[c.get(Calendar.AM_PM)] + "\n"
                         + "Time Zone: " + c.getTimeZone().getDisplayName()
                         + "\n"
                         + "Locale: "
                         + Locale.getDefault().getDisplayName()+"\n");
        
        int max = c.getMaximum(Calendar.DAY_OF_WEEK);
        System.out.println("Maximum number of days in a week: " + max);
        
        max = c.getMaximum(Calendar.WEEK_OF_YEAR);
        System.out.println("Maximum number of weeks in a year: " + max);
        
        
        int min = c.getMinimum(Calendar.DAY_OF_WEEK);
        System.out.println("Minimum number of days in week: " + min);
        
        min = c.getMinimum(Calendar.WEEK_OF_YEAR);
        System.out.println("Minimum number of weeks in year: " + min);
        
        c.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + c.getTime());
        c.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + c.getTime());
        c.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + c.getTime());
        
        String[] days = {"Sunday", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday"};
        GregorianCalendar gc = new GregorianCalendar(2024,8,15);
        gc.add(Calendar.DATE, 0);
        System.out.println(gc.getTime());
        System.out.println(days[gc.get(Calendar.DAY_OF_WEEK)]);
        
        Calendar cal_obj1 = Calendar.getInstance(); 
        Calendar cal_obj2 = Calendar.getInstance(); 
        cal_obj2.set(Calendar.YEAR, 2010); 
        System.out.println("Result : " +  
                    cal_obj1.equals(cal_obj2)); 
	}

}
