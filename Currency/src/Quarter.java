public class Quarter extends Coin {
	private String picture;
	private static int shineRanking; // Int value from 1-10
	private final static double value = 0.25; //won't ever change, variables that belong to the class (same for all objects of that class)
	private static int quarterCount;

	public Quarter() {
		picture = "A face";
		shineRanking = 2;
		quarterCount ++; // changes quarterCount for every quarter made
	}

	public Quarter(double coinValue, String coinColor, String coinMaterial, String coinName, double coinDiameter, String coinPicture, int coinShineRanking) {
		super(coinValue, coinColor, coinMaterial, coinName, coinDiameter);
		picture = coinPicture;
		shineRanking = coinShineRanking;
	}

	public String getPicture() {
		return picture;
	}
	
	public int getShineRanking() {
		return shineRanking;
	}

	public void increaseShineRanking() {
		shineRanking ++;
		System.out.println("Congrats! The bottle trick worked; your quarter is now shinier!");
	}

	@Override
	public String toString() {
		return "This quarter's value is " + this.getValue() + ". Its picture is: " + picture + ". Its shine ranking is: " + shineRanking;
	}

}