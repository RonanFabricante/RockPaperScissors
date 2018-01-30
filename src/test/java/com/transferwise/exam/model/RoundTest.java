package com.transferwise.exam.model;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.transferwise.exam.service.RockPaperScissorRules;


@RunWith(MockitoJUnitRunner.class)
public class RoundTest {
    private final String g1 = "rock";
    private final String g2 = "scissors";
    private Round round;
    @Mock
    private RockPaperScissorRules rules;

    @Test
    public void whenHumanWinsOverComputer() {
        final HumanPlayer p1 = new MockHumanPlayer(g1);
        final ComputerPlayer p2 = new MockComputerPlayer(g2);
        when(rules.applyRules(g1,g2)).thenReturn(Optional.of(g1));

        round = new Round(g1, p1, p2);

        assertEquals(p1.getName(), round.getRoundWinner().getName());
    }
    
    @Test
    public void whenComputerWinsOverComputer() {
        final HumanPlayer p1 = new MockHumanPlayer(g2);
        final ComputerPlayer p2 = new MockComputerPlayer(g1);
        when(rules.applyRules(g2,g1)).thenReturn(Optional.of(g1));

        round = new Round(g2, p1, p2);

        assertEquals(p1.getName(), round.getRoundWinner().getName());
    }

    @Test
    public void whenRulesEngineRetunsWinner_thenRoundDraws() {
        final HumanPlayer p1 = new MockHumanPlayer(g1);
        final ComputerPlayer p2 = new MockComputerPlayer(g1);
        when(rules.applyRules(g1, g1)).thenReturn(null);

        round = new Round(g1, p1, p2);

        assertNull(round.getRoundWinner());
    }
}
