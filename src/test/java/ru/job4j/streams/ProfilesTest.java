package ru.job4j.streams;

import org.checkerframework.checker.units.qual.A;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectAdresses() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Tomsk", "Lenina street", 5, 3)),
                new Profile(new Address("Belgorod", "Lesnaya street", 10, 2)),
                new Profile(new Address("Pskov", "Staraya street", 3, 13)),
                new Profile(new Address("Moscow", "Old Square", 1, 1))
        );
        Profiles pf = new Profiles();
        List<Address> rsl = pf.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Moscow", "Red Square", 1, 1));
        expected.add(new Address("Tomsk", "Lenina street", 5, 3));
        expected.add(new Address("Belgorod", "Lesnaya street", 10, 2));
        expected.add(new Address("Pskov", "Staraya street", 3, 13));
        expected.add(new Address("Moscow", "Old Square", 1, 1));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectDuplicateAdresses() {
        List<Profile> profiles = List.of(
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Tomsk", "Lenina street", 5, 3)),
                new Profile(new Address("Belgorod", "Lesnaya street", 10, 2)),
                new Profile(new Address("Pskov", "Staraya street", 3, 13)),
                new Profile(new Address("Moscow", "Red Square", 1, 1)),
                new Profile(new Address("Belgorod", "Lesnaya street", 10, 2)),
                new Profile(new Address("Moscow", "Old Square", 1, 1))
        );
        Profiles pf = new Profiles();
        List<Address> rsl = pf.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Belgorod", "Lesnaya street", 10, 2));
        expected.add(new Address("Moscow", "Old Square", 1, 1));
        expected.add(new Address("Moscow", "Red Square", 1, 1));
        expected.add(new Address("Pskov", "Staraya street", 3, 13));
        expected.add(new Address("Tomsk", "Lenina street", 5, 3));
        assertThat(rsl, is(expected));
    }
}