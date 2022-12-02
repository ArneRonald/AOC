package org.aoc.days;

import java.util.*;

public class DayOne extends BaseDay {

    @Override
    public void solve(){
        int[] input = retriever.getInputAsIntegerArray(1);
        List<Integer> combinedCalories = getElvesTotalCalories(input);
        Collections.sort(combinedCalories, Collections.reverseOrder());
        int topThree = getTopThreeCalories(combinedCalories);
        System.out.println("--Day One--");
        System.out.println("Part1: " + combinedCalories.get(0));
        System.out.println("Part2: " + topThree);
    }

    private Integer getTopThreeCalories(List<Integer> calories) {
        return calories.get(0) + calories.get(1) + calories.get(2);
    }

    private List<Integer> getElvesTotalCalories(int[] input) {
        List<Integer> elvesTotal = new LinkedList<>();
        int totalCalories = 0;
        for (int i: input) {
            if (i == 0) {
                elvesTotal.add(totalCalories);
                totalCalories = 0;
                continue;
            } else {
                totalCalories += i;
            }
        }

        return elvesTotal;
    }

}
