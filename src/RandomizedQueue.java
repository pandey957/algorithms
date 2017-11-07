import java.util.NoSuchElementException;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;



public class RandomizedQueue<Item> implements Iterable<Item>
{
	private int numElems = 0;
	private Item[] elems; 
	
	public RandomizedQueue()
	{
		elems = (Item[]) new Object[2];
	}
	
	public boolean isEmpty() {return numElems == 0;}
	
	public int size() {return numElems;}
	
	public void enqueue(Item item)
	{
		assertNotNull(item);
		elems[numElems++] = item;
		if (numElems == elems.length ) reSize(elems.length * 2);
	}
	
	public Item dequeue()
	{
		assertNotEmpty();
		int randomIndex = getRandomIndex();
		Item item = elems[randomIndex];
		elems[randomIndex] = elems[--numElems];
		elems[numElems] = null;
		
		if (numElems > 0 && numElems < elems.length/4) reSize(elems.length/2);
		
		return item;
	}
	
	public Item sample()
	{
		assertNotEmpty();
		int randomIndex = getRandomIndex();
		Item item = elems[randomIndex];		
		return item;
	}
	
	//public void printSchema() {System.out.println(java.util.Arrays.toString(elems));}
	
	private int getRandomIndex() { return StdRandom.uniform(0, numElems);}
	
	private void reSize(int size) {
		Item[] tempElems= (Item[]) new Object[size];
		for (int i = 0; i < numElems ; i++)
		{
			tempElems[i] = elems[i]; 
			elems[i] = null;
		}
		elems = tempElems ;
	}
	
	public Iterator<Item> iterator() {return new RandomizedQueueIter();}
	
	private class RandomizedQueueIter implements Iterator<Item>
	{
		private int current = elems.length;
		private Item[] iterQueue ;
		
		public RandomizedQueueIter()
		{
			iterQueue =(Item[]) new Object[elems.length];
			for (int i=0; i < elems.length ; i++)
			{
				iterQueue [i] = elems[i];
			}
			
			StdRandom.shuffle(iterQueue);
		}
		
		
		public boolean hasNext() {return current != 0;}
		public void remove () { throw new UnsupportedOperationException(); }
		public Item next()
		{
			Item item = iterQueue[current--];
			iterQueue[current] = null;
			return item;
		}
	}
	
	private void assertNotEmpty() {if (numElems == 0) throw new NoSuchElementException();}
	private void assertNotNull(Item item) {if (item == null) throw new IllegalArgumentException();}

	public static void main(String[] args)
	{
		System.out.println("Testing out RandomizedQueue");
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		for (int i =0 ; i< 20; i++) {
			rq.enqueue(i);
			//rq.printSchema();
		}
		for (int i=0; i< 20; i++) {
			//rq.printSchema();
			System.out.print(rq.sample() + "\t");}
		//System.out.print(rq.dequeue() + "\n");
		//System.out.print(rq.dequeue());
	}
	
}