public class Transaction 
{
	private String myDescription; 
	private int myNumItems;
	private double myItemCost; 
	public static final double TAX_RATE = 0.07;
	
	//constructor
	public Transaction (String description, int numItems, double itemCost)
	{
		myDescription = description; 
		myNumItems = numItems;
		myItemCost = itemCost;
	}
	
	//accessors
	public String getDescription()
	{ 
		return myDescription; 
	}

	public int getNumItems() 
	{
		return myNumItems;
	}

	public double getItemCost() 
	{
		return myItemCost; 
	}

	public double getTotal()
	{
		double cost = myNumItems * myItemCost;
		double tax = cost * TAX_RATE; 
		return cost + tax;
	}
	
	public String toString()
	{
		String result = "Description: " + myDescription + "\n";
		result += "Number of items: " + myNumItems + "\n";
		result += "Item cost: " + myItemCost + "\n";
		return result;
	}
}