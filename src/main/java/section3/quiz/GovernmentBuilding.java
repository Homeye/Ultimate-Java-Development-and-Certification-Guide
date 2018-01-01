package section3.quiz;

public class GovernmentBuilding extends Building {

    private String agency;

    private boolean isTopSecret;

    public GovernmentBuilding(int numberOfPeople, int ageOfBuilding, String agency) {
        super(numberOfPeople, ageOfBuilding);
        this.agency = agency;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public boolean isTopSecret() {
        return isTopSecret;
    }

    public void setTopSecret(boolean topSecret) {
        isTopSecret = topSecret;
    }

    public static void main(String[] args) {

        GovernmentBuilding governmentBuilding1 = new GovernmentBuilding(66, 33, "DEA");
    }

    @Override
    public String toString() {
        return agency + ", numberOfPeople " + getNumberOfPeople() + ", ageOfBuilding " + getAgeOfBuilding();
    }
}
