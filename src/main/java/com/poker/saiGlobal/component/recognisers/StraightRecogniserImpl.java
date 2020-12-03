package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.poker.saiGlobal.helper.PokerConstants.*;

/**
 * Component to recognise Straight combination into the given person's hand.
 */
@Component
public class StraightRecogniserImpl implements StraightRecogniser {
    /**
     * Recognises Straight in a hand.
     * @param person person object which information will be updated.
     */
    @Override
    public void recogniseStraight(Person person) {
        RecogniserHelper.sortCards(person.getHand());
        recogniseStr(person);
    }

    /**
     * Recognises Straight combination in hand and fills person with relevant information.
     * @param person Person.
     * @return person object with filled information.
     */
    private Person  recogniseStr (Person person) {
        if (person.getHand().get(4).getRank() == HAND_A) {
            if (isHandLowerStraight(person.getHand())) {
                person.setHighCombinationCard(HAND_A);
                person.setHandValue(PokerHandValuesConstants.STRAIGHT);
            }
        } else {
            int higherCard = person.getHand().get(0).getRank() + 1;
            for (var i = 1; i < 5; i++) {
                if (person.getHand().get(i).getRank() != higherCard) {
                    return person;
                }
                higherCard ++;
            }
        }
        person.setHighCombinationCard(person.getHand().get(4).getRank());
        person.setHandValue(PokerHandValuesConstants.STRAIGHT);
        return person;
    }

    /**
     * Recognises is hand a Straight combination.
     * @param hand Players Hand.
     * @return boolean value has hand Straight combination or not.
     */
    protected boolean isStraight (List<Card> hand) {
        if (hand.get(4).getRank() == HAND_A) {
            if (isHandLowerStraight(hand)) {
                return true;
            }
        } else {
            int higherCard = hand.get(0).getRank() + 1;
            for (var i = 1; i < 5; i++) {
                if (hand.get(i).getRank() != higherCard) {
                    return false;
                }
                higherCard ++;
            }
        }
        return true;
    }

    /**
     * Recognises is given hand a lower Straight combination.
     * @param hand hand with 5 cards.
     * @return boolean value is lower Straight combination or not.
     */
    private boolean isHandLowerStraight (List<Card> hand) {
        return (hand.get(0).getRank() == HAND_2 && hand.get(1).getRank() == HAND_3 &&
                        hand.get(2).getRank() == HAND_4 && hand.get(3).getRank() == HAND_5) ||
                (hand.get(0).getRank() == HAND_10 && hand.get(1).getRank() == HAND_J &&
                        hand.get(2).getRank() == HAND_Q && hand.get(3).getRank() == HAND_K);
    }
}
