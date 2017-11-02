
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats
{
	private Percolation per ;
	private double[] results;
	private final int SIZE;
	
	public PercolationStats(int n, int T)
	{
		SIZE = n;
		results = new double[T];
		runExperiments(T);
		
	}
	
	public double mean()  {return StdStats.mean(results);}                        // sample mean of percolation threshold
	public double stddev()  {return StdStats.stddev(results);}// sample standard deviation of percolation threshold
	public double confidenceLo() { return mean() - confidence();}// low  endpoint of 95% confidence interval
	public double confidenceHi() {return mean() + confidence();}
	
	
	private double confidence() {return 1.96 * stddev() / Math.sqrt(results.length);}
	
	private void runExperiments(int trials)
	{
		for (int i = 0; i< trials; i++)
		{
			results[i] = runExpriment();
		}
	}
	
	
	private double runExpriment()
	{
		per = new Percolation(SIZE);
		while (!per.percolates())
		{
			per.open(randomNum(), randomNum());
		}
		
		return (double) per.numberOfOpenSites() /(double) (SIZE* SIZE);
		
	}
	
	
	private int randomNum()
	{
		return StdRandom.uniform(1, SIZE+1);
	}
	
	
	public static void main(String[] args)
	{
		PercolationStats test = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("mean\t\t\t= " + test.mean());
		System.out.println("stddev\t\t\t= " + test.stddev());
		System.out.println("95% confidence interval\t= [" + test.confidenceLo() + "," + test.confidenceHi() + "]");
		//System.out.println([test.confidenceLo(),test.confidenceHi()]);
	}
}