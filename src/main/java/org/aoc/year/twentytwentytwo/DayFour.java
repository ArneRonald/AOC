package org.aoc.year.twentytwentytwo;

public class DayFour extends BaseDay {

    public DayFour() {
        super(4);
    }

    @Override
    protected void solve() {
        String[] input = retriever.getInputAsStringArray();
        String[] fauxInput = new String[] {"2-4,6-8", "2-3,4-5", "5-7,7-9", "2-8,3-7", "6-6,4-6" , "2-6,4-8"};
        int part1 = findAmountOfCompletelyOverlappingTasks(input);
        System.out.println("Part 1: " + part1);
        int part2 = findAmountOfPartialOverlappingTasks(input);
        System.out.println("Part 2: " + part2);
    }

    private int findAmountOfPartialOverlappingTasks(String[] input) {
        int overlap = 0;
        for (String s: input) {
            String[] tasks = s.split(",");
            if (determinePartialOverlap(tasks[0].split("-"), tasks[1].split("-"))) {
                overlap++;
            }
        }
        return overlap;
    }

    private boolean determinePartialOverlap(String[] tasks1, String[] tasks2) {
        int lower1 = Integer.parseInt(tasks1[0]);
        int upper1 = Integer.parseInt(tasks1[1]);
        int lower2 = Integer.parseInt(tasks2[0]);
        int upper2 = Integer.parseInt(tasks2[1]);

        if (lower1 <= upper2 && lower2 <= upper1) {
            return true;
        }

        return false;
    }

    private int findAmountOfCompletelyOverlappingTasks(String[] input) {
        int overlap = 0;
        for (String s: input) {
            String[] tasks = s.split(",");
            if (determineOverlap(tasks[0].split("-"), tasks[1].split("-"))) {
                overlap++;
            }
        }
        return overlap;
    }

    private boolean determineOverlap(String[] taskList1, String[] taskList2) {
        int lower1 = Integer.parseInt(taskList1[0]);
        int upper1 = Integer.parseInt(taskList1[1]);
        int lower2 = Integer.parseInt(taskList2[0]);
        int upper2 = Integer.parseInt(taskList2[1]);

        if (lower2 >= lower1 && upper2 <= upper1 || lower1 >= lower2 && upper1 <= upper2){
            return true;
        }
        return false;
    }
}
