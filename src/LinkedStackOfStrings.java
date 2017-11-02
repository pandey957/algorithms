public class LinkedStackOfStrings
{
	private Node first = null;
	
	private class Node
	{
		String item; 
		Node next;
	}
	
	public boolean isEmpty() {return first == null;}
	
	public void push(String item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;			
	}
	
	public String pop()
	{
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String[] arg)
	{
		System.out.println("Validating LinkedStackofStrings.");
		LinkedStackOfStrings ls = new LinkedStackOfStrings();
		String[] input= new String[] {"to","be","or", "not", "to", "-", "be", "-","-", "that", "-", "-", "-", "is"};
		for(int i = 0; i< input.length; i ++ ) 
		{
			if (input[i] == "-") System.out.println(ls.pop());
			else ls.push(input[i]);
		}
		
		
		
	}
}