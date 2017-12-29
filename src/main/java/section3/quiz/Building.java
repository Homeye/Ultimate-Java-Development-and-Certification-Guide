package section3.quiz;

public class Building {

    private int numberOfPeople;

    private int ageOfBuilding;

    private int costOfBuilding;

    public Building(int numberOfPeople, int ageOfBuilding) {
        this.numberOfPeople = numberOfPeople;
        this.ageOfBuilding = ageOfBuilding;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getAgeOfBuilding() {
        return ageOfBuilding;
    }

    public void setAgeOfBuilding(int ageOfBuilding) {
        this.ageOfBuilding = ageOfBuilding;
    }

    public int getCostOfBuilding() {
        return costOfBuilding;
    }

    public void setCostOfBuilding(int costOfBuilding) {
        this.costOfBuilding = costOfBuilding;
    }

    public void addOneYear() {
        setAgeOfBuilding(getAgeOfBuilding() + 1);
    }

    public static void main(String[] args) {

        Building building1 = new Building(10, 35);
        System.out.println(building1.getAgeOfBuilding());
        building1.addOneYear();
        System.out.println(building1.getAgeOfBuilding());
    }
}
