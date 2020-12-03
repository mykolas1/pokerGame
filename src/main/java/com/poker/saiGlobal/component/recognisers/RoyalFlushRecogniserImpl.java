package com.poker.saiGlobal.component.recognisers;

import com.poker.saiGlobal.dto.Card;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.helper.PokerConstants;
import com.poker.saiGlobal.helper.PokerHandValuesConstants;
import com.poker.saiGlobal.helper.RecogniserHelper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Recognises Royal Flush into given person's hand.
 */
@Primary
@Component
public class RoyalFlushRecogniserImpl extends FlushRecogniserImpl implements RoyalFlushRecogniser{

    /**
     * Recognises Royal Flush into given person's hand.
     * @param person information.
     */
    @Override
    public void recogniseRoyalFlush(Person person) {
        if (RecogniserHelper.areAllCardsSameSuite(person.getHand()) && areAllCardsFromRoyalFlushRank(person.getHand())) {
            person.getHand().sort(Comparator.comparing(Card::getRank));
            person.setHighCombinationCard(person.getHand().get(4).getRank());
            person.setHandValue(PokerHandValuesConstants.ROYAL_FLUSH);
        }
    }

    /**
     * Check are all cards from Royal Flush Rank.
     * @param hand
     * @return
     */
    private boolean areAllCardsFromRoyalFlushRank (List<Card> hand) {
        List<Card> tempHand = hand
                .stream()
                .filter(card -> card.getRank() >= PokerConstants.HAND_10)
                .collect(Collectors.toList());
        return tempHand.size() == PokerConstants.HAND_CARD_SIZE;
    }
}
