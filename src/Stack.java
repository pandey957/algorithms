//import LinkedStackOfStrings.Node;

public class Stack<Item>
{
	private Node first = null;
	
	private class Node
	{
		Item item; 
		Node next;
	}
	
	public boolean isEmpty() {return first == null;}
	
	public void push(Item item)
	{
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;			
	}
	
	public Item pop()
	{
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String[] arg)
	{
		System.out.println("Validating LinkedStackofStrings.");
		Stack<String> sk = new Stack<String>();
		String[] input= new String[] {"to","be","or", "not", "to", "-", "be", "-","-", "that", "-", "-", "-", "is"};
		for(int i = 0; i< input.length; i ++ ) 
		{
			if (input[i] == "-") System.out.println(sk.pop());
			else sk.push(input[i]);
		}
		
		Stack<Integer> sk1 = new Stack<Integer>();
		sk1.push(10);
		sk1.push(111);
		System.out.println(sk1.pop());	
		
	}
}