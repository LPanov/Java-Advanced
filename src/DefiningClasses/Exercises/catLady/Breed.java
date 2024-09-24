package DefiningClasses.Exercises.catLady;

public class Breed {
    String name;

    public Breed(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
class Siamese extends Breed {
    String name;
    double earSize;


    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    @Override
    public String toString() {
        return "Siamese " + super.getName() + " " + String.format("%.2f", earSize);
    }
}
class Cymric extends Breed {
    String name;
    double furLength;


    public Cymric(String name, double earSize) {
        super(name);
        this.furLength = earSize;
    }

    public double getFurLength() {
        return furLength;
    }

    @Override
    public String toString() {
        return "Cymric " + super.getName() + " " + String.format("%.2f", furLength);
    }
}

class StreetExtraordinaire extends Breed {
    String name;
    double meowSize;


    public StreetExtraordinaire(String name, double meowSize) {
        super(name);
        this.meowSize = meowSize;
    }

    public double getMeowSize() {
        return meowSize;
    }

    @Override
    public String toString() {
        return "StreetExtraordinaire " + super.getName() + " " + String.format("%.2f", meowSize);
    }
}
