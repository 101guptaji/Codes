package javaBasics;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.temporal.Temporal;
import java.util.*;

public class DateClassExample {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println("Current Date and time: "+d);
		
		Date d1 = new Date(2000, 11, 21);
        Date d2 = new Date();  // Current date
        Date d3 = new Date(2010, 11, 21);

        boolean a = d3.after(d1);
        System.out.println("Date d3 comes after " +
                           "date d2: " + a);

        boolean b = d3.before(d2);
        System.out.println("Date d3 comes before "+
                           "date d2: " + b);
        
        int c = d1.compareTo(d2);
        System.out.println(c);

        System.out.println("Miliseconds from Jan 1 "+
                "1970 to date d1 is " + d1.getTime());

        System.out.println("Before setting "+d2);
        d2.setTime(204587433443L);
        System.out.println("After setting "+d2);
        
        //to convert Date into String
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.format(new Date());
        System.out.println( sdf.format(new Date()));
        
        
	}
}
