package section3.quiz;

public class GovermentBuilding extends Building {

    private String agency;

    private boolean isTopSecret;

    public GovermentBuilding(int numberOfPeople, int ageOfBuilding, String agency) {
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

        GovermentBuilding govermentBuilding1 = new GovermentBuilding(66, 33, "DEA");
    }
}
