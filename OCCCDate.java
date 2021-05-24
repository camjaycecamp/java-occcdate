import java.util.Calendar;
import java.util.GregorianCalendar;

public class OCCCDate 
{
	private int dayOfMonth;
	private int monthOfYear;
	private int year;
	private GregorianCalendar gc;
	private boolean dateFormat = true;
	private boolean dateStyle = true;
	private boolean dateDayName = true;
	public static final boolean FORMAT_US = true;
	public static final boolean FORMAT_EURO = false;
	public static final boolean STYLE_NUMBERS = true;
	public static final boolean STYLE_NAMES = false;
	public static final boolean SHOW_DAY_NAME = true;
	public static final boolean HIDE_DAY_NAME = false;
	
	public OCCCDate() 
	{
		GregorianCalendar gc = new GregorianCalendar();
		dayOfMonth = gc.get(Calendar.DATE);
		monthOfYear = (gc.get(Calendar.MONTH)+1);
		year = gc.get(Calendar.YEAR);
	}
	
	public OCCCDate(int day, int month, int year) 
	{
		gc = new GregorianCalendar(year, month-1, day);
		dayOfMonth = day;
		monthOfYear = month;
		this.year = year;
	}
	
	public OCCCDate(GregorianCalendar gc) 
	{
		this.dayOfMonth = gc.get(Calendar.DATE);
		this.monthOfYear = (gc.get(Calendar.MONTH)+1);
		this.year = gc.get(Calendar.YEAR);
	}
	
	public OCCCDate(OCCCDate d) 
	{
		this.dayOfMonth = d.getDayOfMonth();
		this.monthOfYear = (d.getMonthNumber()+1);
		this.year = d.getYear();
		gc = new GregorianCalendar(year, monthOfYear-1, dayOfMonth);
	}
	
	public int getDayOfMonth()
	{
		return dayOfMonth;
	}
	
	public String getDayName()
	{
		gc = new GregorianCalendar(year, monthOfYear-1, dayOfMonth);
		int i = gc.get(Calendar.DAY_OF_WEEK);
		
		if(i == 2)
		 {
		     return "Monday";           
		 }
		 else if (i==3)
		 {
		     return "Tuesday";
		 } 
		 else if (i==4)
		 {
		     return "Wednesday";
		 } 
		 else if (i==5)
		 {
		     return "Thursday";
		 }
		 else if (i==6)
		 {
		     return "Friday";
		 } 
		 else if (i==7)
		 {
		     return "Saturday";
		 } 
		 else if (i==1)
		 {
		     return "Sunday";
		 } 
		 else 
		 {
			 return null;
		 }
	}
	
	public int getMonthNumber()
	{
		return monthOfYear;
	}
	
	public String getMonthName() 
	{
		int i = monthOfYear-1;
		
		 if(i == 1)
		 {
		     return "January";           
		 } 
		 else if (i==2)
		 {
		     return "February";
		 } 
		 else if (i==3)
		 {
		     return "March";
		 } 
		 else if (i==4)
		 {
		     return "April";
		 }
		 else if (i==5)
		 {
		     return "May";
		 } 
		 else if (i==6)
		 {
		     return "June";
		 } 
		 else if (i==7)
		 {
		     return "July";
		 } 
		 else if (i==8)
		 {
		     return "August";
		 }
		 else if (i==9)
		 {
		     return "September";
		 } 
		 else if (i==10)
		 {
		     return "October";
		 } 
		 else if (i==11)
		 {
		     return "November";
		 } 
		 else if (i==12) 
		 {
			 return "December";
		 }
		 else 
		 {
			 return "error0";
		 }
	}
	
	public int getYear() 
	{
		gc = new GregorianCalendar(year, monthOfYear-1, dayOfMonth);
		return gc.get(Calendar.YEAR);
	}
	
	public void setDateFormat(boolean df) 
	{
		if (df == FORMAT_US) 
		{
			dateFormat = true;
		}
		else if (df == FORMAT_EURO)
		{
			dateFormat = false;
		}
	}
	
	public void setStyleFormat(boolean sf) 
	{
		if (sf == STYLE_NUMBERS) 
		{
			dateStyle = true;
		}
		else if (sf == STYLE_NAMES) 
		{
			dateStyle = false;
		}
	}
	
	public void setDayName(boolean nf) 
	{
		if (nf == SHOW_DAY_NAME) 
		{
			dateDayName = true;
		}
		else if (nf == HIDE_DAY_NAME) 
		{
			dateDayName = false;
		}
	}
	
	public int getDifferenceInYears() 
	{
		GregorianCalendar g = new GregorianCalendar();
		int difference = g.get(Calendar.YEAR) - year;
		return difference;
	}
	
	public int getDifferenceInYears(OCCCDate d) 
	{
		int difference = year - d.getYear();
		if (difference < 0) 
		{
			difference = difference * -1;
			return difference;
		}
		else {
		return difference;
		}
	}
	
	public boolean equals(OCCCDate dob) 
	{
		return this.getMonthNumber() == dob.getMonthNumber() &&
				this.getDayOfMonth() == dob.getDayOfMonth() &&
						this.getYear() == dob.getYear();
	}
	
	public String toString() 
	{
		gc = new GregorianCalendar(year, monthOfYear, dayOfMonth);
		if (this.dateStyle) 
		{
			if (this.dateFormat) 
			{
				if (!this.dateDayName) 
				{
					return (this.monthOfYear + " / " + this.dayOfMonth + " / " + this.year);
				}
				else if (this.dateDayName) 
				{
					return (this.getDayName() + ", " + this.monthOfYear + " / " + this.dayOfMonth + " / " + this.year);
				}
				else 
				{
					return "error1";
				}
			}
			else if (!this.dateFormat) 
			{
				if (!this.dateDayName) 
				{
					return (this.dayOfMonth + " / " + this.monthOfYear + " / " + this.year);
				}
				else if (this.dateDayName)
				{
					return (this.getDayName() + " " + this.dayOfMonth + " / " + this.monthOfYear + " / " + this.year);
				}
				else 
				{
					return "error2";
				}
			}
			else 
			{
				return "error3";
			}
		}
		else if (!this.dateStyle) 
		{
			if (this.dateFormat) 
			{
				if (!this.dateDayName) 
				{
					return (this.getMonthName() + " " + this.dayOfMonth + ", " + this.year);
				}
				else if (this.dateDayName) 
				{
					return (this.getDayName() + ", " + this.getMonthName() + " " + this.dayOfMonth + ", " + this.year);
				}
				else 
				{
					return "error4";
				}
			}
			else if (!this.dateFormat) 
			{
				if (!this.dateDayName) 
				{
					return (this.getDayName() + " of " + this.dayOfMonth + ", " + this.year);
				}
				else if (this.dateDayName) 
				{
					return (this.getDayName() + ", " + this.getMonthName() + " of " + this.dayOfMonth + ", " + this.year);
				}
				else 
				{
					return "error5";
				}
			}
			else 
			{
				return "error6";
			}
		}
		else 
		{
			return "error7";
		}
	}
}
