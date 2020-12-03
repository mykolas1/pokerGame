package com.poker.saiGlobal.kernel;

import com.poker.saiGlobal.component.HandEvaluator;
import com.poker.saiGlobal.dto.Deck;
import com.poker.saiGlobal.dto.Person;
import com.poker.saiGlobal.dto.Players;
import com.poker.saiGlobal.helper.RecogniserHelper;
import com.poker.saiGlobal.service.DeckService;
import com.poker.saiGlobal.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Kernel layer which initiates players with deck and communicates with services.
 */
@Component
@RequiredArgsConstructor
public class PlayPokerKernelImpl implements PlayPokerKernel {

    private final DeckService deckService;
    private final HandEvaluator handEvaluator;
    private final WinnerService winnerService;

    /**
     * Initiates players with deck and communicates with services.
     * @param playersSize
     */
    @Override
    public String  playPoker(int playersSize) {

        Deck deck = new Deck();
        Players players = new Players(playersSize);

        deckService.shuffleCards(deck);
        deckService.splitCards(players, deck);
        players.getPeople().forEach(handEvaluator::evaluateHand);

        return buildResponseString(players);
    }

    /**
     * Build a response string to the user.
     * @param players
     * @return String with winner and losers.
     */
    private String buildResponseString (Players players) {
        Person winner = winnerService.recogniseWinner(players.getPeople());
        String output = "Player " + winner.getId() + " wins with " + RecogniserHelper.mapHandValueToPokerCombination(winner.getHandValue()) +
                ". Hand: " + winner.getHand().toString() + " \nBecause other players have:\n";
        players.getPeople().remove(winner);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < players.getPeople().size(); i++) {
            stringBuilder
                    .append("Player ")
                    .append(players.getPeople().get(i).getId())
                    .append(" - ")
                    .append(RecogniserHelper.mapHandValueToPokerCombination(players.getPeople().get(i).getHandValue()))
                    .append(". Hand: ")
                    .append(players.getPeople().get(i).getHand().toString())
                    .append("\n");
        }
        return output + stringBuilder.toString();
    }
}
