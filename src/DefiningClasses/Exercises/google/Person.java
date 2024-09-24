package DefiningClasses.Exercises.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    Car car;
    List<Pokemon> pokemons;
    List<Parent> parents;
    List<Child> children;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Company getCompanyName() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder pokemons = new StringBuilder();

        if (this.company == null && this.car == null) {
            return name + "\n" +
                    "Company:\n" +
                    "Car:";
        }
        else if (this.company == null) {
            return name + "\n" +
                    "Company:\n" +
                    "Car:\n" + car;
        }
        else if (this.car == null) {
            return name + "\n" +
                    "Company:\n" + company + "\n" +
                    "Car:";
        }
        else {
            return name + "\n" +
                    "Company:\n" + company + "\n" +
                    "Car:\n" + car;
        }

    }
}
