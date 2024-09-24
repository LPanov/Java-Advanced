package DefiningClasses.Exercises.google;

public class Pokemon {
    private String name;
    private String element;

    public Pokemon(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public String toString() {
        return name + " " + element;
    }

}
