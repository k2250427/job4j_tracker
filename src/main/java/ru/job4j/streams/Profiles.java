package ru.job4j.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles){
        return profiles.stream()
                .map(profile -> profile.getAddress())
                .sorted(new SortByAddress())
                .distinct()
                .collect(Collectors.toList());
    }
}
