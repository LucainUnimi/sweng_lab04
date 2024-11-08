package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.EnumMap;
import java.util.Map;

public class FourOfAKindEvaluator implements ChainedHandEvaluator {

    private ChainedHandEvaluator next;

    public FourOfAKindEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean fourOfAKind(PokerHand hand) {
        Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
        for(Card card : hand) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }
        return rankCount.values().stream().anyMatch(count -> count == 4);
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if (fourOfAKind(hand)) return HandRank.FOUR_OF_A_KIND;
        return next.handEvaluator(hand);
    }
}
