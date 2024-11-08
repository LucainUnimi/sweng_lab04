package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StraightEvaluator implements ChainedHandEvaluator{

    private final ChainedHandEvaluator next;

    StraightEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean straight(PokerHand hand) {
            List<Rank> ranks = new ArrayList<>();

            for (Card card : hand) {
                ranks.add(card.getRank());
            }

            ranks = ranks.stream().distinct().sorted().collect(Collectors.toList());

            for (int i = 0; i < ranks.size() - 1; i++) {
                if (ranks.get(i).ordinal() + 1 != ranks.get(i + 1).ordinal()) {
                    return false;
                }
            }
            return true;

    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if(straight(hand)) {
            return HandRank.STRAIGHT;
        }
        return next.handEvaluator(hand);
    }
}
