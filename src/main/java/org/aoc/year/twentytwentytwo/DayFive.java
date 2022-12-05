package org.aoc.year.twentytwentytwo;

import java.util.*;

public class DayFive extends BaseDay {

    public DayFive() {
        super(5);
    }

    @Override
    protected void solve() {
        String[] input = retriever.getInputAsStringArray();
        String[] fauxInput = new String[] {
                "    [D]    ",
                "[N] [C]    ",
                "[Z] [M] [P]",
                " 1   2   3 ",
                "",
                "move 1 from 2 to 1",
                "move 3 from 1 to 3",
                "move 2 from 2 to 1",
                "move 1 from 1 to 2"};

        Instructions instructions = convertInstructions(input);
        String result = moveCreates(instructions);
        System.out.println("Part 1: " + result);
        Instructions instructionsPart2 = convertInstructions(input);
        String result2 = moveMultipleCreates(instructionsPart2);
        System.out.println("Part 2: " + result2);
    }

    private String moveMultipleCreates(Instructions instructions){
        for (Movement move: instructions.instructions) {
            instructions.columns = executeMultipleMovement(instructions.columns, move);
        }
        String res = "";
        for (String col: instructions.columns) {
            if (col != ""){
                res += col.substring(col.length()-1);
            }
        }
        return res;
    }

    private String[] executeMultipleMovement(String[] columns, Movement movement){
        String boxesToMove = columns[movement.from -1].substring(columns[movement.from -1].length() - movement.amount);
        columns[movement.from -1] = columns[movement.from -1].substring(0,columns[movement.from -1].length() - movement.amount);
        columns[movement.to -1 ] += boxesToMove;

        return columns;
    }

    private String moveCreates(Instructions instructions){
        for (Movement move: instructions.instructions) {
            instructions.columns = executeSingleMovement(instructions.columns, move);
        }
        String res = "";
        for (String col: instructions.columns) {
            if (col != ""){
                res += col.substring(col.length()-1);
            }
        }
        return res;
    }

    private String[] executeSingleMovement(String[] columns, Movement movement){
        for (int i = 0; i < movement.amount; i++) {
            String boxToMove = columns[movement.from-1].substring(columns[movement.from - 1].length()-1);
            columns[movement.from-1] = columns[movement.from-1].substring(0, columns[movement.from -1].length() -1);
            columns[movement.to-1] += boxToMove;
        }
        return columns;
    }

    private Movement getMovement(String instruction){
        String[] parts = instruction.split(" ");
        return new Movement(Integer.parseInt(parts[1]), Integer.parseInt(parts[3]), Integer.parseInt(parts[5]));
    }

    private Instructions convertInstructions(String[] input) {
        List<String> tempColumns = new LinkedList<>();
        String[] cols = new String[9];
        Arrays.fill(cols, "");
        List<Movement> instructions = new LinkedList<>();

        for (String in: input) {
            if (in.equals("")){
                continue;
            }
            if (in.startsWith("move")) {
                instructions.add(getMovement(in));
            }
            if (!in.startsWith("move") && !in.contains("1")) {
                tempColumns.add(in);
            }
        }
        for (int i = tempColumns.size() -1; i >= 0; i--) {
            String[] vals = tempColumns.get(i).split("(?<=\\G....)");
            for (int j = 0; j < vals.length ; j++) {
                cols[j] += vals[j].trim();
                cols[j] = cols[j].replace("[", "").replace("]", "");
            }
        }
        return new Instructions(cols, instructions);
    }

    class Movement {
        int amount;
        int from;
        int to;

        public Movement(int amount, int from, int to) {
            this.amount = amount;
            this.from = from;
            this.to = to;
        }
    }

    class Instructions {
        String[] columns;
        List<Movement> instructions;

        public Instructions(String[] columns, List<Movement> instructions) {
            this.columns = columns;
            this.instructions = instructions;
        }
    }
}
