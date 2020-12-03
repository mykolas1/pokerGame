package com.poker.saiGlobal.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Stores boolean isCombinationFound and high card of the combination.
 */
@Getter
@Setter
public class SimilarCardsCombination {
    private boolean isCombinationFound;
    private int highCombinationCard;
}
