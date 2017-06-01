/**
 * @author Muddu
 * @date 26.5.17
 */
import java.util.*;
public class Gregorian
{
    public static String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
    public static void gregcal_default()
    {
        GregorianCalendar greg=new GregorianCalendar();
        System.out.print("Date: ");
        System.out.print(months[greg.get(Calendar.MONTH)-1]+" ");
        System.out.print(greg.get(Calendar.DATE)+" ");
        System.out.println(greg.get(Calendar.YEAR)+" ");
        
        System.out.print("Time: ");
        System.out.println(greg.get(Calendar.HOUR)+":");
        System.out.print(greg.get(Calendar.MINUTE)+":");
        System.out.println(greg.get(Calendar.SECOND)+":");
        System.out.println("Week in a Year: "+greg.get(Calendar.WEEK_OF_YEAR));
        if(greg.isLeapYear(greg.get(Calendar.YEAR)))
            System.out.println("The year ia a leap year");
        else
            System.out.println("The year is not a leap year");
    }
    public static void gregcal_default_1(int year,int month,int dayofmonth)
    {
       GregorianCalendar greg=new GregorianCalendar(year,month,dayofmonth);
       System.out.print("Date: ");
        System.out.print(months[greg.get(Calendar.MONTH)-1]+" ");
        System.out.print(greg.get(Calendar.DATE)+" ");
        System.out.println(greg.get(Calendar.YEAR)+" ");
        
        System.out.print("Time: ");
        System.out.println(greg.get(Calendar.HOUR)+":");
        System.out.print(greg.get(Calendar.MINUTE)+":");
        System.out.println(greg.get(Calendar.SECOND)+":");
        System.out.println("Week in a Year: "+greg.get(Calendar.WEEK_OF_YEAR));
        if(greg.isLeapYear(greg.get(Calendar.YEAR)))
            System.out.println("The year ia a leap year");
        else
            System.out.println("The year is not a leap year");
    }
    public static void gregcal_default_2(int year,int month,int dayofmonth, int hours,int minutes)
    {
        GregorianCalendar greg=new GregorianCalendar(year,month,dayofmonth,hours,minutes);
        System.out.print("Date: ");
        System.out.print(months[greg.get(Calendar.MONTH)-1]+" ");
        System.out.print(greg.get(Calendar.DATE)+" ");
        System.out.println(greg.get(Calendar.YEAR)+" ");
        
        System.out.print("Time: ");
        System.out.println(greg.get(Calendar.HOUR)+":");
        System.out.print(greg.get(Calendar.MINUTE)+":");
        System.out.println(greg.get(Calendar.SECOND)+":");
        System.out.println("Week in a Year: "+greg.get(Calendar.WEEK_OF_YEAR));
        if(greg.isLeapYear(greg.get(Calendar.YEAR)))
            System.out.println("The year ia a leap year");
        else
            System.out.println("The year is not a leap year");
    }
    public static void gregcal_default_3(int year,int month,int dayofmonth, int hours,int minutes,int seconds)
    {
        GregorianCalendar greg=new GregorianCalendar(year,month,dayofmonth,hours,minutes,seconds);
        System.out.print("Date: ");
        System.out.print(months[greg.get(Calendar.MONTH)-1]+" ");
        System.out.print(greg.get(Calendar.DATE)+" ");
        System.out.println(greg.get(Calendar.YEAR)+" ");
        
        System.out.print("Time: ");
        System.out.print(greg.get(Calendar.HOUR)+":");
        System.out.print(greg.get(Calendar.MINUTE)+":");
        System.out.println(greg.get(Calendar.SECOND)+":");
        System.out.println("Week in a Year: "+greg.get(Calendar.WEEK_OF_YEAR));
        if(greg.isLeapYear(greg.get(Calendar.YEAR)))
            System.out.println("The year ia a leap year");
        else
            System.out.println("The year is not a leap year");
    }
    public static void main(String args[])
    {
        gregcal_default();
        gregcal_default_1(1995,07,13);
        gregcal_default_2(1995,07,13,07,06);
        gregcal_default_3(1995,07,13,07,06,13);
    }
    
}
