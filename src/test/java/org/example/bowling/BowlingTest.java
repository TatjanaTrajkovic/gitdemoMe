package org.example.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingTest {

    @Test
    void gutterGameGivesZeroScore() {
        Bowling bowlingGame = new Bowling();

        for(int i = 0; i < 20; i++) {
            bowlingGame.roll(0);
        }

        assertThat(bowlingGame.score()).isEqualTo(0);

    }

}

//arrange: skapat förberet ett class
//act: du utför ngtning kastar tärning
//assert:verfierar bekräftaar att utfallet är som förväntat
