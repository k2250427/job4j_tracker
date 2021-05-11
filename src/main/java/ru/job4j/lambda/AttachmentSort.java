package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 3", 100),
                new Attachment("image 1", 34),
                new Attachment("image 2", 13)
        );
        Comparator<Attachment> comparator =  new Comparator<>() {
            @Override
            public int compare(Attachment left, Attachment right) {
                return left.getName().compareTo(right.getName());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
    }
}