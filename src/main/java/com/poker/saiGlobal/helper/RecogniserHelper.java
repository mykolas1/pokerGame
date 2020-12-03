package com.poker.saiGlobal.helper;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.dto.SimilarCardsCombination;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper class which supports recognise components.
 */
public class RecogniserHelper {

    /**
     * Calculates cards by given count.
     * @param hand
     * @param cardCount number how many cards we will count.
     * @return SimilarCardsCombination object which contains information about found similar cards.
     */
    public static SimilarCardsCombination hasCountOfCardsByGivenCounter(List<Card> hand, int cardCount) {
        SimilarCardsCombination similarCardsCombination = new SimilarCardsCombination();
        similarCardsCombination.setCombinationFound(false);
        for(int i = 0; i <= hand.size(); i++) {
            int counter = 1;
            for (int j = (i + 1); j <= hand.size() - 1; j++) {
                if (hand.get(i).getRank() == hand.get(j).getRank()) {
                    counter ++;
                }
                if (counter == cardCount) {
                    similarCardsCombination.setCombinationFound(true);
                    similarCardsCombination.setHighCombinationCard(hand.get(j).getRank());
                    return similarCardsCombination;
                }
            }
        }
        return similarCardsCombination;
    }

    /**
     * Sorts cards by rank.
     * @param hand
     * @return sorted card list.
     */
    public static List<Card> sortCards (List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getRank));
        return hand;
    }

    /**
     * Checks if cards are same suite.
     * @param hand
     * @return boolean value are all cards in same suite.
     */
    public static boolean areAllCardsSameSuite (List<Card> hand) {
        List<Card> tempHand = hand
                .stream()
                .filter(card -> card.getSuit().equals(hand.get(0).getSuit()))
                .collect(Collectors.toList());
        return tempHand.size() == PokerConstants.HAND_CARD_SIZE;
    }

    /**
     * Fills person object with combination information
     * @param person
     * @param pokerCombination
     * @param highHandValueCard
     */
    public static void fillPersonWithCombinationInformation(Person person, int pokerCombination, int highHandValueCard) {
        person.setHandValue(pokerCombination);
        person.setHighCombinationCard(highHandValueCard);
    }

    /**
     * Maps combination values to poker combination names.
     */
    public static String mapHandValueToPokerCombination (int handValue) {
        switch (handValue) {
            case 0:
                return "High Card";
            case 1:
                return "Pair";
            case 2:
                return "Two Pair";
            case 3:
                return "Three of a Kind";
            case 4:
                return "Straight";
            case 5:
                return "Flush";
            case 6:
                return "Full House";
            case 7:
                return "Four of a Kind";
            case 8:
                return "Straight Flush";
            case 9:
                return "Royal Flush";
            default:
                return "";
        }
    }
}
