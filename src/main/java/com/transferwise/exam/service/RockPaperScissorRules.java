package com.transferwise.exam.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.transferwise.exam.model.Tuple;


@Component
public class RockPaperScissorRules implements Rules{
	
	private static Map<Tuple<String>, String> rules;
	{
		RockPaperScissorRules.initializeRules();
	}
    
    private static void initializeRules() {
        rules = new HashMap<Tuple<String>, String>();
        rules.put(new Tuple<String>("rock", "paper"), "paper");
        rules.put(new Tuple<String>("paper", "paper"), null);
        rules.put(new Tuple<String>("rock", "scissors"), "rock");
        rules.put(new Tuple<String>("rock", "rock"), null);
        rules.put(new Tuple<String>("paper", "scissors"), "scissors");
        rules.put(new Tuple<String>("scissors", "scissors"), null);
    }

    public Optional<String> applyRules(String p1Gesture, String p2Gesture) {
        String gesture = rules.get(new Tuple<String>(p1Gesture, p2Gesture));
        return Optional.ofNullable(gesture);
    }
}
