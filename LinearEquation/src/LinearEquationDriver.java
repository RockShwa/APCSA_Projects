public class LinearEquationDriver 
{
	public static void main(String[] args) 
	{
		LinearEquation line1 = new LinearEquation(5, 4, -17);
	    double slope1 = line1.getSlope(); 
	    System.out.println(slope1); // slope1 print -1.25
	    boolean onLine1 = line1.isOnLine(5, -2); // true because 5(5) + 4(-2) + (-17) = 0
	    System.out.println(onLine1); 

	    LinearEquation line2 = new LinearEquation(-25, 40, 30);
	    double slope2 = line2.getSlope(); 
	    System.out.println(slope2); // slope1 print 0.625
	    boolean onLine2 = line2.isOnLine(5, -2); // false because -25(5) + 40(-2) + 30 != 0
	    System.out.println(onLine2);

	}

}
