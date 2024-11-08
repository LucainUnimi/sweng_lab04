package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Suit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FlushEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    FlushEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean flush(PokerHand hand) {
        List<Suit> suits = new ArrayList<>();
        for (Card card : hand) {
            suits.add(card.getSuit());
        }
        return suits.stream().distinct().count() == 1;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if(flush(hand)) {
            return HandRank.FLUSH;
        }
        return next.handEvaluator(hand);
    }
}
