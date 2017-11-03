
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats
{
	private Percolation per ;
	private double[] results;
	private final int SIZE;
	private double mean, stddev;
	public PercolationStats(int n, int T)
	{
		assertSize(n);
		assertSize(T);
		SIZE = n;
		results = new double[T];
		runExperiments(T);
		setMean();
		setStddev();
	}
	
	
	
	public double mean()  { return mean;}                        // sample mean of percolation threshold
	public double stddev()  {return stddev;}// sample standard deviation of percolation threshold
	public double confidenceLo() { return  mean - confidence();}// low  endpoint of 95% confidence interval
	public double confidenceHi() {return mean + confidence();}
	
	
	
	
	private void setMean(){ mean = StdStats.mean(results);}
	private void setStddev(){ stddev = StdStats.stddev(results);}
	
	private double confidence() {return 1.96 * stddev / Math.sqrt(results.length);}
	
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
		
		double result = (double) per.numberOfOpenSites() /(double) (SIZE* SIZE);
		per = null;
		return result ;
		
	}
	
	
	private int randomNum()
	{
		return StdRandom.uniform(1, SIZE+1);
	}
	
	private void assertSize(int size){ if (size < 1) throw new IllegalArgumentException();}
	
	
	
	public static void main(String[] args)
	{
		PercolationStats test = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		System.out.println("mean\t\t\t= " + test.mean());
		System.out.println("stddev\t\t\t= " + test.stddev());
		System.out.println("95% confidence interval\t= [" + test.confidenceLo() + "," + test.confidenceHi() + "]");
		//System.out.println([test.confidenceLo(),test.confidenceHi()]);
	}
}