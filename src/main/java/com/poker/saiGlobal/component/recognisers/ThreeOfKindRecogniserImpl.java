package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.dto.SimilarCardsCombination;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

/**
 * Recognises Three of Kind combination into the person's hand.
 */
@Component
public class ThreeOfKindRecogniserImpl implements ThreeOfKindRecogniser {
    /**
     * Recognises Three of Kind combination into the person's hand.
     * @param person with cards and relevant information
     */
    @Override
    public void recogniseThreeOfKind(Person person) {
        SimilarCardsCombination similarCardsCombination =
                RecogniserHelper.hasCountOfCardsByGivenCounter(person.getHand(), 3);

        if (similarCardsCombination.isCombinationFound()) {
            person.setHighCombinationCard(similarCardsCombination.getHighCombinationCard());
            person.setHandValue(PokerHandValuesConstants.THREE_OF_KIND);
        }
    }
}
