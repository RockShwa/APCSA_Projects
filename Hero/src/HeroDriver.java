public class HeroDriver {
	public static void main(String[] args) {
		Warrior hero1 = new Warrior("Rodrigo", 50);
		hero1.run(); // child class has access to parent class methods
		hero1.attack();

		Hero hero2 = new Warrior(); // declares a Hero object that is a Warrior; becomes a Warrior at run time, not compile time
		// CANT DO: Warrior hero3 = new Hero();
		((Warrior) hero2).attack(); // cast Hero to be a Warrior at compile time

		// you can only extend from one class (each class can only have one parent)
		/* static: you don't have to make an object to use the static method, static variables are class specific, so if you change a 
		* static variable, it changes it for all instances of that class */

		System.out.println(Warrior.getHP());
		Warrior hero3 = new Warrior();
		Warrior.changeHP(300);
		System.out.println(Warrior.getHP());
	}
}