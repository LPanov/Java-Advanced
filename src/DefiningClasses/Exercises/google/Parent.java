package DefiningClasses.Exercises.google;

public class Parent {
    String name;
    String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return name + " " + birthday;
    }
}
