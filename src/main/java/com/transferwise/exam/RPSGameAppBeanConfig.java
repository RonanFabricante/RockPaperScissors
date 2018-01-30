package com.transferwise.exam;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.transferwise.exam.model.ComputerPlayer;
import com.transferwise.exam.model.HumanPlayer;
import com.transferwise.exam.service.GameService;

@Configuration
public class RPSGameAppBeanConfig {
	
	@Bean("gameService")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public GameService getGameService() {
	      return new GameService();
    }
	
   @Bean("humanPlayer")
   @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
   public HumanPlayer getHumanPlayer() {
      return new HumanPlayer();
   }
   
   @Bean("computerPlayer")
   @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
   public ComputerPlayer getComputerPlayer() {
      return new ComputerPlayer();
   }
   
}
