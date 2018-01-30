package com.transferwise.exam.model;

/*
 * This represents the participant in the game
 * who or which has the capability to perform a gesture	
 */
public interface Player {
    void setGesture(String gesture);
    String getGesture();
    String getName();
    void setScore(int score);
    int getScore();
}
