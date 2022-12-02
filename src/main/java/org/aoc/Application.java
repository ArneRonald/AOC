package org.aoc;

import org.aoc.year.twentytwentytwo.DayOne;
import org.aoc.year.twentytwentytwo.DayTwo;

public class Application {
    public static void main(String[] args) {
        System.out.println("----2021----");
        new org.aoc.year.twentytwentyone.DayOne(1).solve();

        System.out.println("----2022----");
        new DayOne(1).solve();
        new DayTwo(2).solve();
    }
}