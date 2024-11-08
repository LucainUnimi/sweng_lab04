package it.unimi.di.sweng.lab04;

public class StraightEvaluator implements ChainedHandEvaluator{

    private final ChainedHandEvaluator next;

    StraightEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean straight(PokerHand hand) {
        return false;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if(straight(hand)) {
            return HandRank.STRAIGHT;
        }
        return null;
    }
}
