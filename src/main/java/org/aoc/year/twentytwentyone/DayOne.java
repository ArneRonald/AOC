package org.aoc.year.twentytwentyone;

public class DayOne extends BaseDay {

    public DayOne(int day) {
        super(day);
    }

    @Override
    public void solve() {
        String[] input = retriever.getInputAsStringArray();
        for (String in: input) {
            System.out.println(in);
        }
    }
}
