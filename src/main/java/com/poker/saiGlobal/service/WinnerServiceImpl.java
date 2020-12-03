package com.poker.saiGlobal.service;

import com.poker.saiGlobal.dto.Person;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WinnerServiceImpl which recognises winner of the game.
 */
@Service
public class WinnerServiceImpl implements WinnerService {

    /**
     * WinnerServiceImpl which recognises winner of the game.
     */
    @Override
    public Person recogniseWinner(List<Person> players) {
        players.sort(Comparator.comparing(Person::getHandValue));
        if (players.get(players.size()-1).getHandValue() == 0) {
            return calculateHighCardWinner(players);
        }
        return calculateWinnerWithCombination(players);
    }

    /**
     * Calculates winner when each player's combination is high card.
     * @param players players.
     * @return returns winner.
     */
    private Person calculateHighCardWinner(List<Person> players) {
        players.sort(Comparator.comparing(Person::getHighCard));
        return players.get(players.size()-1);
    }

    /**
     * Calculates winner when at least one player does not have high card combination.
     * @param players players.
     * @return returns winner.
     */
    private Person calculateWinnerWithCombination(List<Person> players) {
        players.sort(Comparator.comparing(Person::getHandValue));
        List<Person> winnersWithSameCombination = players
                .stream()
                .filter(player -> player.getHandValue() == players.get(players.size() - 1).getHandValue())
                .sorted(Comparator.comparing(Person::getHighCombinationCard))
                .collect(Collectors.toList());
        return winnersWithSameCombination.get(winnersWithSameCombination.size() - 1);
    }
}
