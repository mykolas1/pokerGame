package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import org.springframework.stereotype.Component;

import java.util.Comparator;

/**
 * Recognises Full House combination into given person's hand.
 */
@Component
public class FullHouseRecogniserImpl implements FullHouseRecogniser {

    /**
     * Recognises Full House combination into given person's hand.
     * @param person person with 5 cards and other information.
     */
    @Override
    public void recogniserFullHouse(Person person) {
        person.getHand().sort(Comparator.comparing(Card::getRank));
        if (
                (person.getHand().get(0).getRank() == person.getHand().get(1).getRank() &&
                        person.getHand().get(1).getRank() == person.getHand().get(2).getRank() &&
                        person.getHand().get(3).getRank() == person.getHand().get(4).getRank()
                ) ||
                (person.getHand().get(0).getRank() == person.getHand().get(1).getRank() &&
                        person.getHand().get(2).getRank() == person.getHand().get(3).getRank() &&
                        person.getHand().get(3).getRank() == person.getHand().get(4).getRank()
                )
        ) {
            person.setHighCombinationCard(person.getHand().get(4).getRank());
            person.setHandValue(PokerHandValuesConstants.FULL_HOUSE);
        }
    }
}
