import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{
	private WeightedQuickUnionUF backwash;	
	private boolean[] grid;
	private final int SIZE, BOTTOM_INDEX, TOP_INDEX;
	private int NO_SITES_OPEN;

	public Percolation(int size)
	{
		backwash = new WeightedQuickUnionUF(size * size + 2);
		grid = new boolean[size * size];
		SIZE = size;
		BOTTOM_INDEX = size * size + 1; 
		TOP_INDEX = size * size;	
	}
	
	public boolean isOpen(int row, int col)
	{
		return grid[getIndex(row, col)];
	}
	
	private int getIndex(int row, int col) { return (row -1) * SIZE + (col - 1);}
	
	public int numberOfOpenSites() {return NO_SITES_OPEN;} 
	
	public void open(int row, int col)
	{
		assertGridSize(row, col);
		
		if (isOpen(row, col)) return ;
		
		grid[getIndex(row,col)] = true; // Open a site at row, col 
		connectTopRowSite(row, col);
		connectBottomRowSite(row, col);
		
		connectAboveSite(row, col);
		connectBelowSite(row, col);
		connectLeftSite(row, col);
		connectRightSite(row, col);
		
		NO_SITES_OPEN++;
		
	}
	
	public boolean percolates() {return backwash.connected(TOP_INDEX, BOTTOM_INDEX);}
	
    public boolean isFull(int row, int col) {
        assertGridSize(row, col);
        return backwash.connected(getIndex(row, col), TOP_INDEX);
    }
	
	private void union(int x, int y) {backwash.union(x,y);}
	
	private void connectTopRowSite(int row, int col)
	{
		if (row == 1)union(TOP_INDEX, getIndex(row, col));
	}
	
	private void connectBottomRowSite(int row, int col)
	{
		if (row == SIZE) union(BOTTOM_INDEX, getIndex(row,col));
	}
	
	private void connectAboveSite(int row, int col)
	{
		if (row > 1 && isOpen(row-1, col)) 
		{
			union(getIndex(row-1, col), getIndex(row, col));
		}		
	}
	
	private void connectBelowSite(int row, int col)
	{
		if (row < SIZE && isOpen(row+1, col))
		{
			union(getIndex(row+1, col),getIndex(row, col));
		}	
	}
	
	private void connectLeftSite(int row, int col)
	{
		if (col > 1 && isOpen(row, col-1))
		{
			union(getIndex(row, col-1), getIndex(row,col));
		}
	}
	
	private void connectRightSite(int row, int col)
	{
		if (col < SIZE && isOpen(row, col+1))
		{
			union(getIndex(row,col+1), getIndex(row,col));
		}		
	}
	
	
	private void assertGridSize(int row, int col)
	{
		if (row < 1 || row > SIZE || col < 1 || col  > SIZE) 
			throw new IllegalArgumentException();
	}
	
	public static void main(String[] args)
	{
		System.out.println("Randomly Testing a 4X4 Grid wheter it percolates.");
		Percolation per = new Percolation(4);
		per.open(1,2);
		per.open(2,2);
		per.open(2,3);
		per.open(3,3);
		per.open(4, 4);
		per.open(4, 3);
		System.out.println(per.percolates());
	}
}