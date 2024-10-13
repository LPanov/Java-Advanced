package ExamPreparation.Regular17Feb2024.ChasingSharks;

public class Shark {
    private String kind;
    private int length;
    private String food;
    private String habitation;

    public Shark(String kind, int length, String food, String habitation) {
        this.kind = kind;
        this.length = length;
        this.food = food;
        this.habitation = habitation;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getHabitation() {
        return habitation;
    }

    public void setHabitation(String habitation) {
        this.habitation = habitation;
    }

    @Override
    public String toString() {
        return "The "+this.kind+" is "+this.length+" centimeters long, eats "+this.food+" and inhabits "+this.habitation+"." ;
    }
}
