public class Coin extends Currency {
	private String material;
	private String name;
	private double diameter;

	public Coin() {
		material = "gold";
		name = "weeee";
		diameter = 6.0;
	}

	public Coin(double coinValue, String coinColor, String coinMaterial, String coinName, double coinDiameter) {
		super(coinValue, coinColor);
		material = coinMaterial;
		name = coinName;
		diameter = coinDiameter;
	}

	public String getMaterial() {
		return material;
	}

	public String getName() {
		return name;
	}

	public double getDiameter() {
		return diameter;
	}

	public void meltCoin() {
		diameter += 5;
		System.out.println("Oh no. Your coin accidently fell in the oven and melted.");
	}

	@Override
	public String toString() {
		return "Name: " + name + " is made of " + material + " and is " + diameter + " wide.";
		// call super.toString() to modify existing toString method
	}
}