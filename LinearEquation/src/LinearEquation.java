public class LinearEquation 
{
	private int a;
	private int b;
	private int c;
	
	public LinearEquation(int valueA, int valueB, int valueC)
	{
		a = valueA;
		b = valueB;
		c = valueC;
	}
	
	public double getSlope()
	{
		return (-1 * (double) a) / b;
	}
	
	public boolean isOnLine(int x, int y)
	{
		if (((a * x) + (b * y) + c) == 0)
		{
			return true;
		}
		return false;
	}
}