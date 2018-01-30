package com.transferwise.exam.model;

import java.util.Random;

public class ComputerPlayer implements Player {
	
	private String gesture;
	private final String name;
	private int score;
    private static final Random random =  new Random();
    String[] gestures = {"rock", "paper", "scissors"};
	
	public ComputerPlayer() {
        name = "Computer Player";
    }
	
    public String getName() {
        return "Computer Player";
    }

    public void doGesture() {
    	final int i = random.nextInt(gestures.length);
		setGesture(gestures[i]);
	}

    public String getGesture() {
		return this.gesture;
	}

	public void setGesture(String gesture) {
		this.gesture = gesture;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
