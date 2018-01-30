package com.transferwise.exam.service;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.transferwise.exam.service.RockPaperScissorRules;

public class RockPaperScissorsRulesTest {
    private RockPaperScissorRules rules;

    @Before
    public void setUp() throws Exception {
        rules = new RockPaperScissorRules();
    }

    @Test
    public void whenRockVsScissors_RockWins() {
        Optional<String> expectedWinner = Optional.of("rock");

        Optional<String> actualWinner = rules.applyRules("rock", "scissors");
        assertEquals(expectedWinner, actualWinner);

        actualWinner = rules.applyRules("scissors", "rock");
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void whenRockVsPaper_PaperWins() {
        Optional<String> expectedWinner = Optional.of("paper");

        Optional<String> actualWinner = rules.applyRules("rock", "paper");
        assertEquals(expectedWinner, actualWinner);

        actualWinner = rules.applyRules("paper", "rock");
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void whenRockVsRock_Draw() {
        Optional<String> expectedWinner = Optional.empty();

        Optional<String> actualWinner = rules.applyRules("rock", "rock");
        assertEquals(expectedWinner, actualWinner);
    }

	@Test
    public void whenPaperVsPaper_Draw() {
        Optional<String> expectedWinner = Optional.empty();

        Optional<String> actualWinner = rules.applyRules("rock", "rock");
        assertEquals(expectedWinner, actualWinner);
    }

    @Test
    public void whenScissorsVsScissors_Draw() {
        Optional<String> expectedWinner = Optional.empty();

        Optional<String> actualWinner = rules.applyRules("scissors", "scissors");
        assertEquals(expectedWinner, actualWinner);
    }
}

