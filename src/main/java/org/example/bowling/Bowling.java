package org.example.bowling;

public class Bowling {

    private int[] rolls = new int[20];
    private int rollCount = 0;

    public void roll(int pins) {
        rolls[rollCount++] = pins;
    }

    public Object score() {
        int score = 0;
        for(int i = 0; i < rolls.length; i+=2) {
            score += rolls[i];
            score += rolls[i+1];
            if(rolls[i] + rolls[i+1] == 10){
                score += rolls[i + 2];
            }
        }
        return score;
    }
}
