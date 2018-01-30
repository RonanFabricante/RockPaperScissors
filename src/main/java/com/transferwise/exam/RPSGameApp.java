package com.transferwise.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.transferwise.exam.model.Game;

@SpringBootApplication
public class RPSGameApp
{
    
	public static Game rpsGame;
	
	static public void main(String[] args) throws Exception
    {
    	rpsGame = new Game();
    	SpringApplication.run(RPSGameApp.class, args);
    }
}
