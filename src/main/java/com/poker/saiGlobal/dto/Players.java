package com.poker.saiGlobal.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Players object.
 */
@Getter
public class Players {

    private List<Person> people;

    /**
     * Initializes players.
     * @param playersSize size of the players.
     */
    public Players(int playersSize) {
        people = new ArrayList<>();
        for (var i = 0; i < playersSize; i++) {
            people.add(new Person(i + 1));
        }
    }
}
