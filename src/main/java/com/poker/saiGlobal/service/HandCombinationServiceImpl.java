package com.poker.saiGlobal.service;

import com.poker.saiGlobal.component.HandEvaluator;
import com.poker.saiGlobal.dto.Players;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Hand evaluation service.
 */
@RequiredArgsConstructor
@Service
public class HandCombinationServiceImpl implements HandCombinationService {

    private final HandEvaluator handEvaluator;

    /**
     * Evaluates each player's poker hand.
     * @param players players object with all poker players
     */
    @Override
    public void playPoker(Players players) {
        players.getPeople().forEach(handEvaluator::evaluateHand);
    }
}
