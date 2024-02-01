public class CurrencyDriver {
	public static void main(String[] args) {
		Currency currency1 = new Currency(100, "putrid green");
		System.out.println(currency1); //implicitly calls toString() method

		Coin coin1 = new Coin(5.0, "PURPLE", "Silver", "myCoin", 4.0);
		System.out.println(coin1);
		coin1.meltCoin();
		//System.out.println(coin1.getValue());
		System.out.println(coin1);

		System.out.println("");

		Quarter quarter1 = new Quarter(9.0, "PURPLE", "Gold", "Quarter", 6, "My dog's face", 5);
		System.out.println(quarter1);
		quarter1.increaseShineRanking();

		Quarter quarter2 = new Quarter();
		System.out.println(quarter2);
	}
}