package ru.job4j.streams;

public class Profile {
    private Address address;

    public Profile(String city, String street, int home, int apartment){
        this.address = new Address(city, street, home, apartment);
    }

    public Address getAddress() {
        return address;
    }
}
