public class QuickUnionUF
{
	private int id[] ;
	public QuickUnionUF(int N) 
	{
		id = new int[N];
		for ( int i = 0; i < N; i++) id[i]=i;
	}
	
	private int root(int p) 
	{ 
		while (id[p] != p) p = id[p];
		return p;
	}
	
	public boolean connected(int p, int q) {return root(p) == root(q);}
	
	public void union(int p, int q)
	{
		id[root(p)] = root(q);
	}
	
	public void checkArray() {System.out.println(java.util.Arrays.toString(id));}
	
	public static void main(String[] arg)
	{
		
		System.out.println("Validating Quick Union Problem.");
		QuickUnionUF qu = new QuickUnionUF(10);
		qu.union(4,3);
		qu.union(3, 8);
		qu.union(6, 5);
		qu.union(9, 4);
		qu.union(2, 1);
		qu.union(5, 0);
		qu.union(7, 2);
		qu.union(6, 1);
		qu.union(7, 3);
		System.out.println(qu.connected(5,4));
		qu.checkArray();
			

		
	}
	
}