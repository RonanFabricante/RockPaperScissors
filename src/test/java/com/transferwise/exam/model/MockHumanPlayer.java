package com.transferwise.exam.model;



public class MockHumanPlayer extends HumanPlayer {

    private String gesture;
    private String name;

    public String getGesture() {
        return gesture;
    }
   
    public String getName() {
        return name;
    }

    public MockHumanPlayer(String gesture) {
        this.gesture = gesture;
    }

    public MockHumanPlayer() {
        this.gesture = "rock";
        this.name = "Human Player";
    }
}
