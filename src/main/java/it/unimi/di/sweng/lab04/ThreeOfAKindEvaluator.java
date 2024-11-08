package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.EnumMap;
import java.util.Map;

public class ThreeOfAKindEvaluator implements ChainedHandEvaluator{

    private final ChainedHandEvaluator next;

    ThreeOfAKindEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean isThreeOfAKind(PokerHand hand) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount.values().stream().anyMatch(count -> count == 3);
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if (isThreeOfAKind(hand)) {
            return HandRank.THREE_OF_A_KIND;
        }
        return next.handEvaluator(hand);
    }
}
