package ru.job4j.streams;

public class Profile {
    private Address address;

    public Profile(Address addr){
        this.address = addr;
    }

    public Address getAddress() {
        return address;
    }
}
