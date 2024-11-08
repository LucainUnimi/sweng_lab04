package it.unimi.di.sweng.lab04;


public class StraightFlushEvaluator implements ChainedHandEvaluator {
    private final ChainedHandEvaluator next;
    public StraightFlushEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        return null;
    }
}
