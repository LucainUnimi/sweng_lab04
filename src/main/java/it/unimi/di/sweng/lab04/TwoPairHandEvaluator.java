package it.unimi.di.sweng.lab04;

public class TwoPairHandEvaluator implements ChainedHandEvaluator{

    private final ChainedHandEvaluator next;

    TwoPairHandEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean TwoPair(PokerHand hand) {
        return false;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if (TwoPair(hand)) return HandRank.TWO_PAIR;
        return next.handEvaluator(hand);
    }
}
