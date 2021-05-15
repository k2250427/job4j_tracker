package ru.job4j.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles){
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Tomsk", "Lenina street", 5, 3)),
                new Profile(new Address("Belgorod", "Lesnaya street", 10, 2)),
                new Profile(new Address("Pskov", "Staraya street", 3, 13)),
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Belgorod", "Lesnaya street", 10, 2)),
                new Profile(new Address("Moscow", "Old Square", 1, 1))
        );
        for (Profile pr: profiles) {
            System.out.println(pr.getAddress());

        }


        profiles.stream()
                //.map(profile -> profile.getAddress())
                .forEach(System.out::println);
    }
}
