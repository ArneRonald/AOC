package org.aoc.year.twentytwentyone;

import org.aoc.year.twentytwentyone.BaseDay;
import org.apache.http.pool.PoolStats;

public class DayTwo extends BaseDay {

    public DayTwo() {
        super(2);
    }

    @Override
    public void solve() {
        String[] inputs = retriever.getInputAsStringArray();
        String[] fauxInput = new String[] {"forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2"};
        Instruction[] instructions = convertToInstructions(inputs);
        Position result = followInstructions(instructions);
        System.out.println("Part 1: " + result.getX() * result.getY());
    }

    private Position followInstructions(Instruction[] instructions) {
        Position pos = new Position(0,0);
        for (Instruction instruction: instructions) {
            Position move = handleInstruction(instruction);
            pos.setX(pos.getX() + move.getX());
            pos.setY(pos.getY() + move.getY());
        }
        return  pos;
    }

    private Position handleInstruction(Instruction instruction) {
        switch (instruction.getDirection()) {
            case "forward":
                return new Position(instruction.getDistance(), 0);
            case "down":
                return new Position(0, instruction.getDistance());
            case "up":
                return new Position(0, -instruction.getDistance());
        }
        throw new RuntimeException("Error");
    }

    private Instruction[] convertToInstructions(String[] inputs) {
        Instruction[] instructions = new Instruction[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            String[] split = inputs[i].split(" ");
            instructions[i] = new Instruction(split[0], Integer.parseInt(split[1]));
        }
        return instructions;
    }
}

class Instruction {
    public Instruction(String direction, int distance) {
        this.direction = direction;
        this.distance = distance;
    }
    private String direction;
    private int distance;

    public String getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }
}

class Position {
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}