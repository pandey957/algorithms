public class Date implements Comparable<Date>
{	
	private int year, month, day;
	public Date(int y,int m, int d) 
	{year = y; month = m; day = d;}
	
	public int compareTo(Date that)
	{
		if (that.year > this.year) return -1;
		if (that.year < this.year) return 1; 
		if (that.month > this.month) return -1 ;
		if ( that.month < this.month) return 1;
		if ( that.day > this.day ) return -1; 
		if ( that.day < this.day) return 1;
		return 0;
	}
	
	
	public static void main(String[] args)
	{
		Date date1 = new Date(2017,10,11);
		Date date2 = new Date(2017, 13 ,11);
		System.out.println(date1.compareTo(date2));
		
	}
}