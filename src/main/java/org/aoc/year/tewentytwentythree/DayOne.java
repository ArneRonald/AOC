package org.aoc.year.tewentytwentythree;

import java.util.HashMap;
import java.util.Map;

public class DayOne extends BaseDay {

    public DayOne() {
        super(1);
    }

    @Override
    public void solve(){
        String[] input = retriever.getInputAsStringArray();
        int sum = calculateSum(input);

        System.out.println("Part1: ");
        System.out.println("Part2: " + sum);
    }

    private int calculateSum(String[] lines) {
        int sum = 0;

        for (String line : lines) {
            String[] lineSplit = line.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            int firstDigit = -1;
            int lastDigit = -1;

            for (int i = 0; i < lineSplit.length; i++) {
                if (firstDigit != -1)
                    break;
                firstDigit = getDigitValue(lineSplit[i], i);
            }

            for (int i = lineSplit.length; i > 0; i--) {
                if (lastDigit != -1)
                    break;
                lastDigit = getLastDigitValue(lineSplit[i-1], i);
            }

            String val = String.format("%d%d", firstDigit, lastDigit);

            sum += Integer.parseInt(val);
        }

        return sum;
    }

    private int getLastDigitValue(String parts, int pos) {
        Map<String, Integer> wordToDigit = new HashMap<>();
        wordToDigit.put("zero", 0);
        wordToDigit.put("one", 1);
        wordToDigit.put("two", 2);
        wordToDigit.put("three", 3);
        wordToDigit.put("four", 4);
        wordToDigit.put("five", 5);
        wordToDigit.put("six", 6);
        wordToDigit.put("seven", 7);
        wordToDigit.put("eight", 8);
        wordToDigit.put("nine", 9);

        if (parts.matches("-?\\d+")) {
            return parts.length() == 1 ? Integer.parseInt(parts) : Integer.parseInt(parts.split("")[parts.split("").length-1]);
        }

        for (int i = parts.length(); i > 0; i--) {
            String valTocheck = parts.substring(i-1, parts.length());
            for (Map.Entry<String, Integer> entry : wordToDigit.entrySet()) {
                if (valTocheck.startsWith(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return -1; // Not a digit or spelled-out word
    }

    private int getDigitValue(String check, int pos) {
        Map<String, Integer> wordToDigit = new HashMap<>();
        wordToDigit.put("zero", 0);
        wordToDigit.put("one", 1);
        wordToDigit.put("two", 2);
        wordToDigit.put("three", 3);
        wordToDigit.put("four", 4);
        wordToDigit.put("five", 5);
        wordToDigit.put("six", 6);
        wordToDigit.put("seven", 7);
        wordToDigit.put("eight", 8);
        wordToDigit.put("nine", 9);

        if (check.matches("-?\\d+")) {
            return Integer.parseInt(check.split("")[0]);
        }

        for (int i = 0; i < check.length(); i++) {
            String valTocheck = check.substring(i);
            for (Map.Entry<String, Integer> entry : wordToDigit.entrySet()) {
                if (valTocheck.startsWith(entry.getKey())) {
                    return entry.getValue();
                }
            }
        }
        return -1; // Not a digit or spelled-out word
    }

}
