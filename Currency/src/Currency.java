public class Currency {
	private double value;
	private String color;
	
	/* If you don't use super, the constructor calls the default constructor of the class, 
	* so you must have a default constructor if you want to use the default values of the parent class' instance variables */

	public Currency() {
		value = 0.0;
		color = "Unknown";
	}

	public Currency(double currencyValue, String currencyColor) {
		value = currencyValue;
		color = currencyColor;
	}

	public double getValue() {
		return value;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Value: " + value + "\n" + "Color: " + color + "\n";
	}
}