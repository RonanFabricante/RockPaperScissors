package com.transferwise.exam.model;

import java.util.ArrayList;

import com.transferwise.exam.dto.RoundDTO;

public class Game {
	
		private ArrayList<RoundDTO> listRounds;
		
		public Game() {
			this.listRounds = new ArrayList<RoundDTO>();
		}
		 
	    public void addRoundDTO(RoundDTO roundDto)
	    {
	    	listRounds.add(roundDto);
	    }
	    
	    public ArrayList<RoundDTO> getRoundDTOs()
	    {
	    	return listRounds;
	    }

	}
