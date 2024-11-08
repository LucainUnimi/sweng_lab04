package it.unimi.di.sweng.lab04;

public class FourOfAKindEvaluator implements ChainedHandEvaluator {

    private ChainedHandEvaluator next;

    public FourOfAKindEvaluator(ChainedHandEvaluator next) {
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        return null;
    }
}
