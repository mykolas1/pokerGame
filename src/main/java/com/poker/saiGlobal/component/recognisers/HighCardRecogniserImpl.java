package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

/**
 * Recognises High Card and sets it to person object.
 */
@Component
public class HighCardRecogniserImpl implements HighCardRecogniser {

    /**
     * Recognises High Card and sets it to person object.
     * @param person
     */
    @Override
    public void recogniseHighCard(Person person) {
        person.setHighCard(getHighCard(person));
        person.setHandValue(PokerHandValuesConstants.HIGH_CARD);
    }

    /**
     * Gets highest hand's card.
     * @param person
     * @return
     */
    private int getHighCard (Person person) {
        RecogniserHelper.sortCards(person.getHand());
        return person.getHand().get(4).getRank();
    }
}
