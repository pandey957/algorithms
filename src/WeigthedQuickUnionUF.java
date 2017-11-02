public class WeigthedQuickUnionUF
{
	private int id[] ;
	private int size[];
	public WeigthedQuickUnionUF(int N) 
	{
		id = new int[N];
		size = new int[N];
		for ( int i = 0; i < N; i++) {id[i]=i; size[i] = 1;}		
	}
	
	private int root(int p) 
	{ 
		while (id[p] != p) 
		{ 
			//id[p] = id[id[p]]; // For path Compression method   
			p = id[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q) {return root(p) == root(q);}
	
	public void union(int p, int q)
	{
		int p_root = root(p);
		int q_root = root(q);
		if (p_root == q_root) return ;	
		if (size[p_root] < size[q_root]) { id[p_root] = q_root; size[q_root] += size[p_root]; }
		else { id[q_root] = p_root; size[p_root] += size[q_root]; }
	}
	
	public void checkArray() {System.out.println(java.util.Arrays.toString(id));}
	
	public static void main(String[] arg)
	{
		
		System.out.println("Validating Quick Union Problem.");
		WeigthedQuickUnionUF qu = new WeigthedQuickUnionUF(10);
		qu.union(4,3);
		qu.union(3, 8);
		qu.checkArray();

		qu.union(6, 5);
		qu.checkArray();

		qu.union(9, 4);
		qu.union(2, 1);
		qu.union(5, 0);
		qu.union(7, 2);
		qu.union(6, 1);
		qu.union(7, 3);
		System.out.println(qu.connected(5,4));
		qu.checkArray();
		//[6, 2, 6, 4, 6, 6, 6, 2, 4, 4]

		
	}
	
}