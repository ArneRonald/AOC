package org.aoc.days;

public class DayTwo extends BaseDay {

    @Override
    public void solve() {
        String[] intput = retriever.getInputAsStringArray(2);
        String[] fauxInput = new String[] {"A Y","B X","C Z"};
        int partOne = playAllRounds(intput);
        int partTwo = playAllRoundsTwo(intput);
        System.out.println("--Day Two--");
        System.out.println("Part1: " + partOne);
        System.out.println("Part2: " + partTwo);
    }

    private int playAllRounds(String[] input) {
        int scoreRoundOne = 0;

        for (String in: input) {
            String[] line = in.split(" ");
            int result = determineWinner(line[0], line[1]);
            scoreRoundOne += calculateScore(result, line[1]);
        }
        return scoreRoundOne;
    }

    private int playAllRoundsTwo(String[] input) {
        int score = 0;

        for (String in: input) {
            String[] line = in.split(" ");
            score += runRoundTwo(line[0], line[1]);
        }
        return score;
    }

    private int runRoundTwo(String opponentMove, String result) {
        int res = 0;
        switch (result){
            case "X":
                res += 0;
                if (opponentMove.equals("A")) {
                    res += 3;
                }
                if (opponentMove.equals("B")){
                    res += 1;
                }
                if (opponentMove.equals("C")) {
                    res += 2;
                }
                break;
            case "Y":
                res += 3;
                if (opponentMove.equals("A")) {
                    res += 1;
                }
                if (opponentMove.equals("B")){
                    res += 2;
                }
                if (opponentMove.equals("C")) {
                    res += 3;
                }
                break;
            case "Z":
                res += 6;
                if (opponentMove.equals("A")) {
                    res += 2;
                }
                if (opponentMove.equals("B")){
                    res += 3;
                }
                if (opponentMove.equals("C")) {
                    res += 1;
                }
                break;
        }
        return res;
    }

    private int determineWinner(String opponentMove, String myMove) {
        switch (opponentMove) {
            case "A":
                if (myMove.equals("X")) {
                    return 3;
                }
                if (myMove.equals("Y")) {
                    return 6;
                }
                if (myMove.equals("Z")) {
                    return 0;
                }
                break;
            case "B":
                if (myMove.equals("X")) {
                    return 0;
                }
                if (myMove.equals("Y")) {
                    return 3;
                }
                if (myMove.equals("Z")) {
                    return 6;
                }
                break;
            case "C":
                if (myMove.equals("X")) {
                    return 6;
                }
                if (myMove.equals("Y")) {
                    return 0;
                }
                if (myMove.equals("Z")) {
                    return 3;
                }
                break;
        }
        throw new RuntimeException("Error, no points");
    }

    private int calculateScore(int result, String move) {
        switch (move){
            case "X":
                result += 1;
                break;
            case "Y":
                result += 2;
                break;
            case "Z":
                result += 3;
                break;
        }
        return result;
    }
}
