package section5.quiz;

public class Cellphone {

    private String name;

    private String model;

    private Battery battery;

    public Cellphone(String name, String model, Battery battery) {
        this.name = name;
        this.model = model;
        this.battery = battery;
    }

    public static class Battery {

        private int duration;

        public Battery(int duration) {
            this.duration = duration;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public static void main(String[] args) {

        Cellphone cellphone = new Cellphone("LG", "Nexus 5X", new Cellphone.Battery(21));
        System.out.println(cellphone.getName());
        System.out.println(cellphone.getModel());
        System.out.println(cellphone.getBattery().getDuration());
    }
}
