package ru.job4j.streams;

import java.util.Comparator;

public class SortByAddress implements Comparator<Address> {
    @Override
    public int compare(Address first, Address second) {
        int rsl = first.getCity().compareTo(second.getCity());
        if(rsl == 0){
            rsl = first.getStreet().compareTo(second.getStreet());
            if(rsl == 0){
                rsl = Integer.compare(first.getHome(), second.getHome());
                if(rsl == 0){
                    return Integer.compare(first.getApartment(), second.getApartment());
                }
            }
        }
        return rsl;
    }
}
