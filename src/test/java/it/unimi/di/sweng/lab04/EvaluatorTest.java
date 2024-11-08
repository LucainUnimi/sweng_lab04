package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Timeout(2)
public class EvaluatorTest {
    @Test
    public void testOnePairHandEvaluatorTrue() {
        ChainedHandEvaluator evaluator = new OnePairHandEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.ACE, Suit.DIAMONDS),
                                Card.get(Rank.ACE, Suit.HEARTS),
                                Card.get(Rank.KING, Suit.CLUBS),
                                Card.get(Rank.QUEEN, Suit.SPADES),
                                Card.get(Rank.JACK, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.ONE_PAIR);
    }

    @Test
    public void testTwoPairHandEvaluatorTrue() {
        ChainedHandEvaluator evaluator = new TwoPairHandEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.ACE, Suit.DIAMONDS),
                                Card.get(Rank.ACE, Suit.HEARTS),
                                Card.get(Rank.KING, Suit.CLUBS),
                                Card.get(Rank.KING, Suit.SPADES),
                                Card.get(Rank.JACK, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.TWO_PAIR);
    }
}
