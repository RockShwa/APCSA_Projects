public class Animal {
    // This is a practice prompt/experimentation for the Unit 5 & 6 APCSA Test
    private String name;
    private int age;
    private boolean isMale;
    private String favoriteFood;

    public Animal(String name, int age, boolean isMale, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void changeFavoriteFood(String newFav) {
        favoriteFood = newFav;
        System.out.println("My New Favorite Food Is: " + newFav);
    }

    public String maleOrFemaleString() {
        if (isMale) {
            return "Male";
        }
        return "Female";
    }

    @Override
    public String toString() {
        String result = "Name: " + name + "\n";
        result += "Age: " + age + "\n";
        result += "Gender: " + maleOrFemaleString() + "\n";
        result += "Favorite Food: " + favoriteFood + "\n";
        return result;
    }
}