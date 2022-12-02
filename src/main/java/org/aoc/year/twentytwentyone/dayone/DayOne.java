package org.aoc.year.twentytwentyone.dayone;

import org.aoc.year.twentytwentyone.BaseDay;

public class DayOne extends BaseDay {

    public DayOne() {
        super(1);
    }

    @Override
    public void solve() {
        int[] input = retriever.getInputAsIntegerArray();
        int[] fauxInput = new int[] {199, 200, 208, 210, 200, 207, 240, 269, 260, 263};
        int result = determineAmountOfIncreases(input);
        int part2 = determineAmountOfSlidingIncreases(input);
        System.out.println("--Day one--");
        System.out.println("Part 1: " + result);
        System.out.println("Part 2: " + part2);
    }

    private int determineAmountOfSlidingIncreases(int[] inputs) {
        int increases = 1;
        for (int i = 1; i < inputs.length; i++) {
            if (i == inputs.length - 3){
                break;
            }
            int measurementOne = inputs[i] + inputs[i+1] + inputs[i+2];
            int measurementTwo = inputs[i+1] + inputs[i+2] + inputs[i+3];
            increases += isIncreased(measurementTwo, measurementOne);
        }
        return increases;
    }

    private int determineAmountOfIncreases(int[] inputs) {
        int increases = 0;
        for (int i = 1; i < inputs.length; i++) {
            increases += isIncreased(inputs[i], inputs[i-1]);
        }
        return increases;
    }

    private int isIncreased(int currentMeasurement, int previousMeasurement) {
        if (currentMeasurement > previousMeasurement){
            return 1;
        }
        return 0;
    }
}
