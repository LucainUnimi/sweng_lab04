package it.unimi.di.sweng.lab04;


import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PokerHand implements Iterable<Card>, Comparable<PokerHand> {
    private final Card[] cards;

    public PokerHand(List<Card> cards) {
        this.cards = cards.toArray(new Card[0]);
        assert this.cards.length == 5;
    }

    public HandRank getPoints() {
        return new StraightFlushEvaluator(
                new FourOfAKindEvaluator(
                        new FullHouseEvaluator(
                                new FlushEvaluator(
                                        new StraightEvaluator(
                                                new ThreeOfAKindEvaluator(
                                                        new TwoPairHandEvaluator(
                                                                new OnePairHandEvaluator(
                                                                        ChainedHandEvaluator.HIGH_CARD
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        ).handEvaluator(this);
    }

    @Override
    public @NotNull Iterator<Card> iterator() {
        return Arrays.stream(cards).iterator();
    }

    @Override
    public int compareTo(@NotNull PokerHand o) {
        return getPoints().compareTo(o.getPoints());
    }
}


