package com.poker.saiGlobal.service;

import com.poker.saiGlobal.dto.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class WinnerServiceImplTest {

    @InjectMocks
    private WinnerServiceImpl winnerService;

    @Test
    public void recogniseWinner_Test_Player1Wins () {
        Person person1 = new Person(1);
        person1.setHandValue(6);
        Person person2 = new Person(2);
        person2.setHandValue(2);

        List<Person> players = new ArrayList<>(Arrays.asList(person1, person2));

        Person winner = winnerService.recogniseWinner(players);
        assertEquals(6, winner.getHandValue());
    }

    @Test
    public void recogniseWinner_Test_HigherCardOnTie () {
        Person person1 = new Person(1);
        person1.setHandValue(2);
        person1.setHighCombinationCard(14);
        Person person2 = new Person(2);
        person2.setHandValue(2);
        person2.setHighCombinationCard(13);

        List<Person> players = new ArrayList<>(Arrays.asList(person1, person2));

        Person winner = winnerService.recogniseWinner(players);
        assertEquals(14, winner.getHighCombinationCard());
    }

    @Test
    public void recogniseWinner_Test_HigherCard () {
        Person person1 = new Person(1);
        person1.setHandValue(0);
        person1.setHighCard(14);
        Person person2 = new Person(2);
        person2.setHandValue(0);
        person2.setHighCard(13);

        List<Person> players = new ArrayList<>(Arrays.asList(person1, person2));

        Person winner = winnerService.recogniseWinner(players);
        assertEquals(14, winner.getHighCard());
    }
}
