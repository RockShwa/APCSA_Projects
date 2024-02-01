public class Hero extends Object { // every class inherits from Object class
	private String name; 
    private int power;
	//this is a declaration statement for an instance variable
	
	public Hero() //this is the default constructor
	{
		//this.name = "Percy";
                //this.power = 10;
		this("Percy");
	}
	
	public Hero(String x) //this is an overloaded constructor
	{
		this.name = x;
                this.power = 10;
                System.out.println(name + " reporting for duty!");
	}
	
	public String getName() //accessor method
	{
		return name;
	}
	
	public void changeName(String newName) //modifier method
	{
		name = newName;
	}
	
	public void run()
	{
		System.out.println(name + " runs frantically!");
	}
	
	public void equip(String item)
	{
		System.out.println(name + " picks up a " + item + ".");
	}
	
	public void equip(String item1, String item2) //overloaded method
	{
		System.out.println(name + " grabs a " + item1 + " and a " + item2 + "!");
	}
}