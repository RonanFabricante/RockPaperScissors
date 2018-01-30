package com.transferwise.exam.dto;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transferwise.exam.model.ComputerPlayer;
import com.transferwise.exam.model.GameStatus;
import com.transferwise.exam.model.GameStatus.Status;
import com.transferwise.exam.model.HumanPlayer;
import com.transferwise.exam.model.Round;

public class RoundDTO {
	
	private Round round;
	private GameStatus.Status status;
	
	@Value("${gameover.winning.score}")
    private int gameOverWinningScore;
	
    public RoundDTO(String gesture, HumanPlayer humanPlayer, ComputerPlayer computerPlayer) {
		
		this.round = new Round(gesture, humanPlayer, computerPlayer);
		updateStatus(round);
	}
    
	public void updateStatus(Round round) {
	
		if (round.getHumanPlayer().getScore() == gameOverWinningScore || round.getComputerPlayer().getScore() == gameOverWinningScore)
			setStatus(Status.GAME_OVER);
		else
			setStatus(Status.IN_PROGRESS);
	}
	
	public GameStatus.Status getStatus() {
		return status;
	}
	
	public void setStatus(GameStatus.Status status) {
		this.status = status;
	}
	
	public Round getRound() {
		return round;
	}
	
	public void setRound(Round round) {
		this.round = round;
	}
	
	@Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(o, this);
    }

    public Map toMap() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(this, Map.class);
    }

}
