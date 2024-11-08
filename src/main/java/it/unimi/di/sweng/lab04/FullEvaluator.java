package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.EnumMap;
import java.util.Map;

public class FullEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    FullEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean fullHouse(PokerHand hand) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount.containsValue(3) && rankCount.containsValue(2);
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if(fullHouse(hand)) {
            return HandRank.FULL_HOUSE;
        }
        return next.handEvaluator(hand);
    }
}
