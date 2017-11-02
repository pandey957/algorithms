public class ArrayStackOfStrings
{
	private String[] s;
	private int N = 0;
	public ArrayStackOfStrings() {s = new String[2];}
	
	public void push(String item)
	{
		s[N++] = item;
		if (N == s.length) resize(2* s.length);
	}
	
	public String pop()
	{
		String item = s[--N];
		s[N] = null;
		if (N <= s.length/2) resize(s.length/2);
		return item;		
	}
	
	private void resize(int capacity)
	{
		String[] copydata = new String[capacity];
		for (int i = 0; i< s.length; i ++ ) copydata[i]= s[i];
		s = copydata;
	}

}