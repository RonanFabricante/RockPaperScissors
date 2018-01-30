package com.transferwise.exam.model;



public class MockComputerPlayer extends ComputerPlayer {

    private String gesture;
    private String name;

    public String getGesture() {
        return gesture;
    }
    
    public String getName() {
        return name;
    }

    public MockComputerPlayer(String gesture) {
        this.gesture = gesture;
    }

    public MockComputerPlayer() {
        this.gesture = "scissors";
        this.name = "Computer Player";
    }
}
