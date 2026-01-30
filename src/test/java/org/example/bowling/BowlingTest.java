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

    @Test
    void onePinEachRollGiveScore20(){
        Bowling bowlingGame = new Bowling();
        for(int i = 0; i < 20; i++) {
            bowlingGame.roll(1);
        }

        assertThat(bowlingGame.score()).isEqualTo(20);

    }

    @Test
    void oneSpareGivesScoreTwentyNine(){
        Bowling bowlingGame = new Bowling();
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        for(int i = 0; i < 18; i++) {
            bowlingGame.roll(1);
        }

        assertThat(bowlingGame.score()).isEqualTo(29);
    }

    @Test
    void oneStrikeGivesScoreTwentyFour(){
        Bowling bowlingGame = new Bowling();
        bowlingGame.roll(10);
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        for(int i = 0; i < 16; i++) {
            bowlingGame.roll(1);
        }


        assertThat(bowlingGame.score()).isEqualTo(40);

    }

//    @Test
//    void mock(){
//
//        Bowling bowlingGame = Mockito.mock(Bowling.class);
//        Mockito.when(bowlingGame.score()).thenReturn(20);
//        assertThat(bowlingGame.score()).isEqualTo(20);
//    }
}

//arrange: skapat förberet ett class
//act: du utför ngtning kastar tärning
//assert:verfierar bekräftaar att utfallet är som förväntat
