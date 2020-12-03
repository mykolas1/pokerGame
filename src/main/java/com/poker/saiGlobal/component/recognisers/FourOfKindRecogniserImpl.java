package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.dto.SimilarCardsCombination;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

/**
 * Recognises Fur of Kind combination in hand.
 */
@Component
public class FourOfKindRecogniserImpl implements FourOfKindRecogniser {
    /**
     * Recognises Fur of Kind combination in hand.
     * @param person person with 5 cards and other information.
     */
    @Override
    public void recogniserFourOfKind(Person person) {
        SimilarCardsCombination similarCardsCombination =
                RecogniserHelper.hasCountOfCardsByGivenCounter(person.getHand(), 4);

        if(similarCardsCombination.isCombinationFound()) {
            person.setHandValue(PokerHandValuesConstants.FOUR_OF_KIND);
            person.setHighCombinationCard(similarCardsCombination.getHighCombinationCard());
        }
    }
}
