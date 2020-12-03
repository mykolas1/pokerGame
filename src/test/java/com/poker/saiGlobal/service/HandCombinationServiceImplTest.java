package com.poker.saiGlobal.service;

import com.poker.saiGlobal.component.HandEvaluator;
import com.poker.saiGlobal.component.HandEvaluatorImpl;
import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Deck;
import com.poker.saiGlobal.dto.Players;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HandCombinationServiceImplTest {

    @InjectMocks
    private HandCombinationServiceImpl handCombinationService;

    @Mock
    private HandEvaluator handEvaluator;

    @Test
    public void playPoker_Test () {
        Mockito.doNothing().when(handEvaluator).evaluateHand(any());
        handCombinationService.playPoker(new Players(2));
        verify(handEvaluator, times(2)).evaluateHand(any());
    }

}
