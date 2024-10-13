package ExamPreparation.Retake10April2024.spaceCrafts;

//package spaceCrafts;
public class Spacecraft {
    private String name;
    private String missionType;
    private String target;
    private String object;
    private int weight;

    public Spacecraft(String name, String missionType, String target, String object, int weight) {
        this.name = name;
        this.missionType = missionType;
        this.target = target;
        this.object = object;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "The mission of "+this.name+" was to reach "+this.target+" and to " + this.object;
    }
}
