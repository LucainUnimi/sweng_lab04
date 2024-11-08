package it.unimi.di.sweng.lab04;

public class ThreeOfAKindEvaluator implements ChainedHandEvaluator{

    private final ChainedHandEvaluator next;

    ThreeOfAKindEvaluator(ChainedHandEvaluator next) {
        this.next = next;
    }

    private boolean isThreeOfAKind(PokerHand hand) {
        return false;
    }

    @Override
    public HandRank handEvaluator(PokerHand hand) {
        if (isThreeOfAKind(hand)) {
            return HandRank.THREE_OF_A_KIND;
        }
        return next.handEvaluator(hand);
    }
}
