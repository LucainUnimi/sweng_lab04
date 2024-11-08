package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.EnumMap;
import java.util.Map;

public class TwoPairHandEvaluator implements ChainedHandEvaluator{

    private final ChainedHandEvaluator next;

    TwoPairHandEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean TwoPair(PokerHand hand) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for (Card card: hand) {
            Rank rank = card.getRank();
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount.values().stream().filter(count -> count == 2).count() == 2;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if (TwoPair(hand)) return HandRank.TWO_PAIR;
        return next.handEvaluator(hand);
    }
}
