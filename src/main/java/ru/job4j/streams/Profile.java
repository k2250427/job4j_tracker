package ru.job4j.streams;

import java.util.Objects;

public class Profile {
    private static Address address;

    public Profile(Address addr){
        this.address = addr;
    }

    public static Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}
