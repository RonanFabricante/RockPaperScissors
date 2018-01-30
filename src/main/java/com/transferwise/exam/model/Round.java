package com.transferwise.exam.model;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.transferwise.exam.service.RockPaperScissorRules;


public class Round {

	@Autowired
	private HumanPlayer humanPlayer;
	@Autowired
	private ComputerPlayer computerPlayer;
	
	private Player roundWinner;
	private RockPaperScissorRules rules;
 
    public Round(String gesture, HumanPlayer humanPlayer, ComputerPlayer computerPlayer) {
        
    	this.humanPlayer = humanPlayer;
    	this.computerPlayer = computerPlayer;
    	humanPlayer.setGesture(gesture);
    	computerPlayer.doGesture();
    	
    	roundWinner= evaluate(humanPlayer, computerPlayer);
    	setRoundWinner(roundWinner);
    }
	
	public HumanPlayer getHumanPlayer() {
		return humanPlayer;
	}

	public void setHumanPlayer(HumanPlayer human) {
		this.humanPlayer = human;
	}
	
	public ComputerPlayer getComputerPlayer() {
		return computerPlayer;
	}

	public void setComputerPlayer(ComputerPlayer computerPlayer) {
		this.computerPlayer = computerPlayer;
	}
	
	public Player getRoundWinner() {
		return roundWinner;
	}
	
	public void setRoundWinner(Player roundWinner) {
		this.roundWinner = roundWinner;
	}
	
	private Player evaluate(HumanPlayer human, ComputerPlayer computer) {
		
		rules = new RockPaperScissorRules();
        Optional<String> winningGesture = rules.applyRules(human.getGesture(), computer.getGesture());
        
        Player roundWinner = null;

        if(winningGesture.isPresent() && winningGesture.get().equalsIgnoreCase(human.getGesture())) {
        	roundWinner = human;
        	int score = humanPlayer.getScore() + 1;
        	humanPlayer.setScore(score);
        }
        else if (winningGesture.isPresent() && winningGesture.get().equalsIgnoreCase(computer.getGesture())) {
        	roundWinner = computer;
        	int score = computerPlayer.getScore() + 1;
        	computerPlayer.setScore(score);
        }
      
        return roundWinner;
    }
	
}
