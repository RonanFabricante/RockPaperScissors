package com.transferwise.exam.model;


public class GameStatus {
	
	private Status status;
    
	public enum Status {
        IN_PROGRESS, GAME_OVER;
    }

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

}
