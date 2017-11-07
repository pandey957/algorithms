import java.util.Iterator;
import java.util.NoSuchElementException;
public class Deque<Item> implements Iterable<Item>
{
	//private int SIZE;
	private Node first;
	private Node last;
	
	public Iterator<Item> iterator() { return new dequeIterator();}
	
	public Deque() {
		first = null;
		last = null;
	}
	
	
	
	
	public boolean isEmpty()   {return first == null;}              // is the deque empty?
	public int size() { 
		if (isEmpty()) return 0;
		int size = 0;
		for (Item item : this) size++;
		return size;
		
	}
	public void addFirst(Item item)           // add the item to the front
	{
		assertNotNull(item);
		Node oldFirst = first;
		
		
		first = new Node();
		first.item = item;
		first.next  = oldFirst;
		first.previous = null;
		if (oldFirst == null) last = first;
		else oldFirst.previous = first;
		
	}
	public void addLast(Item item)           // add the item to the end
	{
		assertNotNull(item);
		Node oldLast = last;
		
		last = new Node();
		last.item = item;
		last.next = null;
		
		if (isEmpty()) 
		{
			last.previous = null;
			first = last;
		}
		else 
		{
			oldLast.next = last;
			last.previous = oldLast;
		}
	}
	public Item removeFirst()
	{
		assertNotEmpty();
		Item item= first.item;
		first = first.next;
		
		if (isEmpty())  last = null;
		else { 
			first.previous = null;			
		}
		return item;
		
	}
	public Item removeLast()
	{
		assertNotEmpty();
		Item item = last.item;		
		last = last.previous;
		//last.next = null;
		if (last == null) first = last;
		else last.next = null;
		return item;		
	}
   
	
	private class Node
	{
		Item item;
		Node next;
		Node previous;
	}
	
	
	public void assertNotNull(Item item){if (item == null) throw new IllegalArgumentException();}
	public void assertNotEmpty() { if (isEmpty()) throw new NoSuchElementException();}
	//public void assertNonRemove() { throw new UnsupportedOperationException();}
	
	
	
	
	
	
	private class dequeIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext() { return current != null;}
		public void remove() { throw new UnsupportedOperationException();}
		public Item next() {Item item = current.item; current = current.next; return item;}		
	}
	
	public static void main(String[] args)
	{
		System.out.println("Testing Both Ended Deque");
		Deque<String> deq = new Deque<String>();
		deq.addFirst("Satyendra");
		deq.addLast("Ritesh");
		deq.addLast("Mohit");
	}
	
}