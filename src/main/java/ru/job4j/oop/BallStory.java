package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball bally = new Ball();
        Hare squint = new Hare();
        Wolf grey = new Wolf();
        Fox red = new Fox();
        bally.meet("заяц");
        squint.tryEat(bally);
        bally.song();
        bally.meet("волк");
        grey.tryEat(bally);
        bally.song();
        bally.meet("лиса");
        red.tryEat(bally);
        bally.song();
        System.out.println("Happy end");
    }
}
