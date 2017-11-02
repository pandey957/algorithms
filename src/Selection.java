public class Selection
{
	public static void sort(Comparable[] a )
	{
		for (int i = 0; i< a.length; i ++ )
		{
			int min = i;
			for ( int j = i+1; j< a.length; j ++ )
			{
				if(less(a[j], a[min])) min =j;
			}
			exch(a, i, min);
		}
	}
	
	public static void exch(Comparable[] a, int i, int j)
	{
		Comparable swp = a[i];
		a[i] = a[j];
		a[j] = swp;
	}
	
	public static boolean less(Comparable a, Comparable b)
	{
		return a.compareTo(b) < 0;
	}
	
	
	public static void main(String[] args)
	{
		String[] str_in = {"ba", "ac","aa"};
		Selection.sort(str_in);
		System.out.println(java.util.Arrays.toString(str_in));		
	}
	
}