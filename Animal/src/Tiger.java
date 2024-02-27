public class Tiger extends Animal {
    private boolean carnivoreOnly;

    public Tiger(String name, int age, boolean isMale, String favoriteFood) {
        super(name, age, isMale, favoriteFood);
        carnivoreOnly = true;
    }

    public boolean getCarnivoreOnly() {
        return carnivoreOnly;
    }

    @Override
    public void changeFavoriteFood(String newFav) {
        if (newFav.contains("vegtables")) {
            System.out.println("Hmm this looks interesting. Okay, lets try it.");
            carnivoreOnly = false;

        } else {
            super.changeFavoriteFood(newFav);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Carnivore Only: " + carnivoreOnly;
    }
}
