package section8;

public class Person {

    private String name;

    private int age;

    private Address address;

    public static class Address {

        private String street;

        private String city;

        private String state;

        public Address(String street, String city, String state) {
            this.street = street;
            this.city = city;
            this.state = state;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        static class Builder {
            private String street;

            private String city;

            private String state;

            public Builder street(String street) {
                this.street = street;
                return this;
            }

            public Builder city(String city) {
                this.city = city;
                return this;
            }

            public Builder state(String state) {
                this.state = state;
                return this;
            }

            public Address create() {
                return new Address(street, city, state);
            }
        }
    }

    static class Builder {

        private String name;

        private int age;

        private Address address;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Person create() {
            return new Person(name, age, address);
        }
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
