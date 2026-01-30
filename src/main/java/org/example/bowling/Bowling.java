package org.example.bowling;

public class Bowling {

    private int[] rolls = new int[20];
    private int rollCount = 0;

    public void roll(int pins) {
        rolls[rollCount++] = pins;
        if(pins == 10)
            rollCount++;
    }

    public Object score() {
        int score = 0;
        for(int i = 0; i < rolls.length; i+=2) {
            if(isSpare(i)){
                score += rolls[i + 2] + rolls[i + 3];
            }else if(isStrike(i)){
                score += rolls[i + 2];
            }
            score += rolls[i];
            score += rolls[i+1];
        }
        return score;
    }

    private boolean isStrike(int i) {
        return rolls[i] == 10;
    }

    private boolean isSpare(int i) {
        return rolls[i] + rolls[i + 1] == 10;
    }
}
