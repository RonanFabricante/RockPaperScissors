package com.transferwise.exam.service;

import java.util.Optional;

public interface Rules {
    Optional<String> applyRules(String p1Gesture, String p2Gesture);

}
