package it.unimi.di.sweng.lab04;

public class FullEvaluator implements ChainedHandEvaluator {

    private final ChainedHandEvaluator next;

    FullEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean fullHouse(PokerHand hand) {
        return new ThreeOfAKindEvaluator(new OnePairHandEvaluator(null)).handEvaluator(hand) == HandRank.FULL_HOUSE;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if(fullHouse(hand)) {
            return HandRank.FULL_HOUSE;
        }
        return next.handEvaluator(hand);
    }
}
