package com.transferwise.exam.service;

import com.transferwise.exam.dto.RoundDTO;
import com.transferwise.exam.model.ComputerPlayer;
import com.transferwise.exam.model.HumanPlayer;

public class GameService {
	
	public RoundDTO playRound(String gesture, HumanPlayer humanPlayer, ComputerPlayer computerPlayer) {
		
		RoundDTO roundDTO = new RoundDTO(gesture, humanPlayer, computerPlayer);
        return roundDTO;
    }
}
