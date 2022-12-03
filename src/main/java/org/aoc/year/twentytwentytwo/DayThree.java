package org.aoc.year.twentytwentytwo;

import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

public class DayThree extends BaseDay {

    public DayThree() {
        super(3);
    }

    @Override
    protected void solve() {
        String[] input = retriever.getInputAsStringArray();
        String[] fauxInput = new String[] {"vJrwpWtwJgWrhcsFMMfFFhFp", "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL", "PmmdzqPrVvPwwTWBwg", "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn", "ttgJtRGJQctTZtZT", "CrZsJsPPZsGzwwsLwLmpwMDw"};
        BackpackContents[] contents = convertToBackpacks(input);
        int part1 = determineSumOfPriorities(contents);
        System.out.println("Part 1: " + part1);
        int part2 = determinePartTwo(input);
        System.out.println("Part 2: " + part2);
    }

    private int determinePartTwo(String[] input) {
        int priority = 0;
        for (int i = 0; i < input.length; i++) {
            Character match = findMatchingCharForThree(input[i].toCharArray(), input[i+1].toCharArray(), input[i+2].toCharArray());
            priority += findPriority(match);
            i += 2;
        }
        return priority;
    }

    private Character findMatchingCharForThree(char[] backpackOne, char[] backPackTwo, char[] backPackThree) {
        for (Character s: backpackOne) {
            for (Character t: backPackTwo) {
                for (Character l: backPackThree) {
                    if (s.equals(t) && s.equals(l)){
                        return s;
                    }
                }
            }
        }
        throw new RuntimeException("Error");
    }

    private int determineSumOfPriorities(BackpackContents[] contents) {
        int priority = 0;
        for (BackpackContents in: contents) {
            Character match = findMatchingChar(in);
            priority += findPriority(match);
        }
        return priority;
    }

    private Character findMatchingChar(BackpackContents content) {
        for (Character s: content.firstPack) {
            for (Character t: content.secondPack) {
                if (s.equals(t)){
                    return s;
                }
            }
        }
        throw new RuntimeException("Error");
    }

    private BackpackContents[] convertToBackpacks(String[] input) {
        BackpackContents[] contents = new BackpackContents[input.length];
        for (int i = 0; i <input.length ; i++) {
            char[] arr1 = input[i].substring(0, input[i].length() /2).toCharArray();
            char[] arr2 = input[i].substring(input[i].length() /2).toCharArray();
            contents[i] = new BackpackContents(arr1, arr2);
        }
        return contents;
    }

    private int findPriority(Character character) {
        if (Character.isUpperCase(character)){
            return character - 'A' + 27;
        }
        return character - 'a' + 1;
    }

    class BackpackContents {
        char[] firstPack;
        char[] secondPack;

        public BackpackContents(char[] firstPack, char[] secondPack) {
            this.firstPack = firstPack;
            this.secondPack = secondPack;
        }
    }

}
