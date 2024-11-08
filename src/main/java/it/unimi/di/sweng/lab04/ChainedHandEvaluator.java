package it.unimi.di.sweng.lab04;

public interface ChainedHandEvaluator {
    ChainedHandEvaluator HIGH_CARD = (hand) -> HandRank.HIGH_CARD;

    HandRank handEvaluator(PokerHand hand);
}
