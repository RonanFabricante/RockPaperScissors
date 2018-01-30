package com.transferwise.exam.model;

public class HumanPlayer implements Player {
    private String gesture;
    private final String name;
    private int score;

    public HumanPlayer() {
        name = "Human Player";
    }

    public void setGesture(String gesture) {
        this.gesture = gesture;
    }
    
    public String getGesture() {
        return gesture;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
	return score;
    }

    public void setScore(int score) {
	this.score = score;
    }

}
