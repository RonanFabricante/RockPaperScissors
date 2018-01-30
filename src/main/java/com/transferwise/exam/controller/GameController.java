package com.transferwise.exam.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transferwise.exam.RPSGameApp;
import com.transferwise.exam.RPSGameAppBeanConfig;
import com.transferwise.exam.dto.RoundDTO;
import com.transferwise.exam.exception.InvalidRoundRequestException;
import com.transferwise.exam.model.ComputerPlayer;
import com.transferwise.exam.model.Game;
import com.transferwise.exam.model.HumanPlayer;
import com.transferwise.exam.service.GameService;


@RestController
public class GameController {
	
    @Value("${invalid.round.message}")
    private String invalidRoundRequestMessage;
	
    @Value("${invalid.input.message}")
    private String invalidInputExceptionMessage;
	
    @Value("${gameover.winning.score}")
    private int gameOverWinningScore;
	
    @Value("${gesture.rock}")
    private String rock;
	
    @Value("${gesture.paper}")
    private String paper;
	
    @Value("${gesture.scissors}")
    private String scissors;
	
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RPSGameAppBeanConfig.class);
    public HumanPlayer humanPlayer = context.getBean("humanPlayer", HumanPlayer.class);
    public ComputerPlayer computerPlayer = context.getBean("computerPlayer", ComputerPlayer.class);
    public GameService gameService = context.getBean("gameService", GameService.class);
	
	
    @GetMapping(value="/rps/rounds")
    public Game getGame(){
       return RPSGameApp.rpsGame;
    }
    
    @PostMapping(value="/round")
    public void addRound(@RequestParam(value="gesture") String humanGesture) {
           
       if(humanGesture == null || !Arrays.asList(new String[] {rock, paper, scissors}).contains(humanGesture))
            throw new HttpMessageNotReadableException(invalidInputExceptionMessage);
       
       if ((humanPlayer.getScore() == gameOverWinningScore || computerPlayer.getScore() == gameOverWinningScore))
    	     throw new InvalidRoundRequestException(invalidRoundRequestMessage);
       
       RoundDTO roundDTO = gameService.playRound(humanGesture, humanPlayer, computerPlayer); 
       RPSGameApp.rpsGame.addRoundDTO(roundDTO);
    }
    
}



