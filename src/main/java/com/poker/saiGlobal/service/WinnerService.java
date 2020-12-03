package com.poker.saiGlobal.service;

import com.poker.saiGlobal.dto.Person;

import java.util.List;

/**
 * WinnerServiceImpl interface.
 */
public interface WinnerService {
    Person recogniseWinner (List<Person> players);
}
