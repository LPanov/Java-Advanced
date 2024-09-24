package DefiningClasses.Exercises.google;

public class Child {
    String name;
    String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String toString() {
        return name + " " + birthday;
    }
}
