public class AnimalDriver {
    public static void main(String[] args) {
        Animal animal = new Animal("Molly", 6, false, "broccoli");
        Tiger tiger = new Tiger("Hank", 1, true, "carne de res");
        Animal tester = new Tiger("Bruce", 3, true, "meat");

        animal.changeFavoriteFood("cheese");
        System.out.println(animal);

        tiger.changeFavoriteFood("vegtables");
        System.out.println(tiger);

        // This is not allowed! At compile time, this object is an Animal, not a Tiger
        // tester.getCarnivoreOnly();

        // This is okay to do
        tester.getAge();

    }
}
