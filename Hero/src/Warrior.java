public class Warrior extends Hero { // can access the same methods and attributes of Hero
	private int charisma;
	private static int hitpoints = 100;
	
	public Warrior() {
		super(); //calls default constructor in parent class
		this.charisma = 0;
		System.out.println(this.getName() + "is a Warrior");
	}

	public Warrior(String name, int charisma) {
		super(name); //cannot assign parent class attributes without super; this must be first in a constructor
		this.charisma = charisma;
		System.out.println(name + "is a Warrior");
	}

	public void attack() { // method only Warrior knows
		System.out.println(this.getName() + " attacks the enemy.");
	}

	@Override // optional
	public void run() { // overrides run method in Hero; polyomrphic method because there is two forms
		super.run(); // calls run method of parent class
		System.out.println(this.getName() + " runs vigorously like a warrior.");
	}

	public static void changeHP(int newHP)
	{
		hitpoints = newHP;
	}

	public static int getHP()
	{
		return hitpoints;
	}
}