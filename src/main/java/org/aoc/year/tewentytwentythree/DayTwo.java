package org.aoc.year.tewentytwentythree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwo extends BaseDay {

    public DayTwo() {
        super(2);
    }

    private final int red = 12;
    private final int green = 13;
    private final int blue = 14;

    @Override
    public void solve(){
        String[] input = retriever.getInputAsStringArray();
        List<Game> games = convertInput(input);
        int validGames = 0;
        int minVal = 0;
        for (Game g: games) {
            if (isValidGame(g)) {
                validGames += Integer.parseInt(g.getGameName().split(" ")[1]);
            }
            minVal += g.getBlue() * g.getGreen() * g.getRed();
        }

        System.out.println("Part1: " + validGames);
        System.out.println("Part2: " + minVal);
    }

    private boolean isValidGame(Game game) {
        return game.getRed() <= red && game.getGreen() <= green && game.getBlue() <= blue;
    }

    private static List<Game> convertInput(String[] input){
        List<Game> gamesList = new ArrayList<>();
        for (String game: input) {
            Game currentGame = new Game();
            String[] gameSplit = game.strip().split(":");
            currentGame.setGameName(gameSplit[0]);
            String[] rounds = gameSplit[1].strip().split(";");
            for (String currentRound: rounds) {
                String[] pulls = currentRound.strip().split(",");
                for (String pull: pulls) {
                    String[] p = pull.strip().split(" ");
                    int val = Integer.parseInt(p[0]);
                    switch (p[1]) {
                        case "red":
                            if (currentGame.getRed() < val)
                                currentGame.setRed(val);
                            break;
                        case "green":
                            if (currentGame.getGreen() < val)
                                currentGame.setGreen(val);
                            break;
                        case "blue":
                            if (currentGame.getBlue() < val)
                                currentGame.setBlue(val);
                            break;
                    }
                }
            }
            gamesList.add(currentGame);
        }
        return gamesList;
    }
}

class Game {
    private String gameName;
    private int red;
    private int green;
    private int blue;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}

