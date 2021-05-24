import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestOCCCDate {
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		GregorianCalendar g = new GregorianCalendar(2003, 7, 13);
		
		OCCCDate o1 = new OCCCDate();
		OCCCDate o2 = new OCCCDate(16, 12, 2008);
		OCCCDate o3 = new OCCCDate(g);
		OCCCDate o4 = new OCCCDate(o2);
		
		System.out.println("o1's day of month: " + o1.getDayOfMonth());
		System.out.println("o1's day name: " + o1.getDayName());
		System.out.println("o2's month number: " + o2.getMonthNumber());
		System.out.println("o2's month name: " + o2.getMonthName());
		System.out.println("o3's year: " + o3.getYear());
		
		o4.setDateFormat(o4.FORMAT_EURO);
		o4.setStyleFormat(o4.STYLE_NAMES);
		o4.setDayName(o4.SHOW_DAY_NAME);
		
		System.out.println(o4.toString());
		System.out.println(o4.getDifferenceInYears());
		System.out.println(o4.getDifferenceInYears(o2));
		System.out.println(o4.equals(o2));
		System.out.println(o4.equals(o3));
		System.out.println(o3.toString());
		
		System.out.println("\nInitial test phase complete. Now for you, the user, to test the program!");
		System.out.println("Let's start by choosing how you'd like your date formatted. Press 0 for European format and 1 for US, respectively: ");
		String userFormat = s.nextLine();
		System.out.println("Next, whether the date is in names or numbers. Again, 0 or 1, respectively: ");
		String userStyle = s.nextLine();
		System.out.println("Finally, whether you'd like the day of the week's name included. 0 or 1 for no or yes, respectively.");
		String userDayName = s.nextLine();
		System.out.println("Now that we have all of that, please enter the month, day, and year of your date, line by line, respectively: ");
		int userMonth = s.nextInt();
		int userDay = s.nextInt();
		int userYear = s.nextInt();
		System.out.println("Excellent! Creating your OCCCDate object...");
		
		OCCCDate userDate = new OCCCDate(userDay, userMonth, userYear);
		
		if(userFormat.equalsIgnoreCase("1")) 
		{
			userDate.setDateFormat(userDate.FORMAT_US);
		} 
		else if (userFormat.equalsIgnoreCase("0"))
		{
			userDate.setDateFormat(userDate.FORMAT_EURO);
		}
		else 
		{
			System.out.println("Illegal value detected in userFormat input. Exiting...");
			System.exit(0);
		}
		
		if(userStyle.equalsIgnoreCase("1")) 
		{
			userDate.setStyleFormat(userDate.STYLE_NUMBERS);
		} 
		else if (userStyle.equalsIgnoreCase("0"))
		{
			userDate.setStyleFormat(userDate.STYLE_NAMES);
		}
		else 
		{
			System.out.println("Illegal value detected in userStyle input. Exiting...");
			System.exit(0);
		}
		
		if(userDayName.equalsIgnoreCase("1")) 
		{
			userDate.setDayName(userDate.SHOW_DAY_NAME);
		} 
		else if (userDayName.equalsIgnoreCase("0"))
		{
			userDate.setDayName(userDate.HIDE_DAY_NAME);
		}
		else 
		{
			System.out.println("Illegal value detected in userDayName input. Exiting...");
			System.exit(0);
		}
		
		System.out.println("Creation complete! toString() of your OCCC object: " + userDate.toString());
		
		
		
	}
}
