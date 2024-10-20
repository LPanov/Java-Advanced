package ExamPreparation.Retake12August2024.surfers;
//package surfers;

public class Surfer {
    private String name;
    private int age;
    private int experience;
    private Boolean ownSurfBoard;
    private int money;

    public Surfer(String name, int age, int experience, Boolean ownSurfBoard, int money) {
        this.name = name;
        this.age = age;
        this.experience = experience;
        this.ownSurfBoard = ownSurfBoard;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public Boolean ownSurfBoard() {
        return ownSurfBoard;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Surfer "+getName()+" is "+getAge()+" years old and has "+getExperience()+" years surfing experience.";
    }
}
