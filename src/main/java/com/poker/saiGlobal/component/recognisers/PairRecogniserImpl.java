package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.dto.SimilarCardsCombination;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.stereotype.Component;

/**
 * Recognises Pair combination into the given players hand.
 */
@Component
public class PairRecogniserImpl implements PairRecogniser {
    /**
     * Recognises Pair combination into the given players hand.
     * @param person with 5 cards hand and relevant information.
     */
    @Override
    public void recognisePair(Person person) {
        SimilarCardsCombination similarCardsCombination =
                RecogniserHelper.hasCountOfCardsByGivenCounter(person.getHand(), 2);

        if (similarCardsCombination.isCombinationFound()) {
            person.setHighCombinationCard(similarCardsCombination.getHighCombinationCard());
            person.setHandValue(PokerHandValuesConstants.PAIR);
        }
    }
}
