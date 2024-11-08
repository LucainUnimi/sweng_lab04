package it.unimi.di.sweng.lab04;


import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Suit;

import java.util.EnumMap;
import java.util.Map;

public class StraightFlushEvaluator implements ChainedHandEvaluator {
    private final ChainedHandEvaluator next;
    public StraightFlushEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean StraightFlush(PokerHand hand) {
        Map<Suit, Integer> suitCount = new EnumMap<>(Suit.class);
        for (Card card: hand) {
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }
        HandRank handRank = new StraightEvaluator(HIGH_CARD).handEvaluator(hand);
        return suitCount.size() == 1 && handRank == HandRank.STRAIGHT;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if (StraightFlush(hand)) return HandRank.STRAIGHT_FLUSH;
        System.out.println(StraightFlush(hand));
        return next.handEvaluator(hand);
    }
}
