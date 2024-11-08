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

    @Test
    public void testTwoPairHandEvaluatorFalse() {
        ChainedHandEvaluator evaluator = new TwoPairHandEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.ACE, Suit.DIAMONDS),
                                Card.get(Rank.ACE, Suit.HEARTS),
                                Card.get(Rank.KING, Suit.CLUBS),
                                Card.get(Rank.NINE, Suit.SPADES),
                                Card.get(Rank.JACK, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.HIGH_CARD);
    }
    @Test
    public void testThreeOfAKindEvaluatorTrue() {
        ChainedHandEvaluator evaluator = new ThreeOfAKindEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.ACE, Suit.DIAMONDS),
                                Card.get(Rank.ACE, Suit.HEARTS),
                                Card.get(Rank.ACE, Suit.CLUBS),
                                Card.get(Rank.NINE, Suit.SPADES),
                                Card.get(Rank.JACK, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.THREE_OF_A_KIND);
    }
    @Test
    public void testThreeOfAKindEvaluatorFalse() {
        ChainedHandEvaluator evaluator = new ThreeOfAKindEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.ACE, Suit.DIAMONDS),
                                Card.get(Rank.ACE, Suit.HEARTS),
                                Card.get(Rank.TWO, Suit.CLUBS),
                                Card.get(Rank.NINE, Suit.SPADES),
                                Card.get(Rank.JACK, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.HIGH_CARD);
    }
    @Test
    public void testStraightTestTrue() {
        ChainedHandEvaluator evaluator = new StraightEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.TWO, Suit.DIAMONDS),
                                Card.get(Rank.THREE, Suit.HEARTS),
                                Card.get(Rank.FOUR, Suit.CLUBS),
                                Card.get(Rank.FIVE, Suit.SPADES),
                                Card.get(Rank.SIX, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.STRAIGHT);
    }
    @Test
    public void testStraightTestFalse() {
        ChainedHandEvaluator evaluator = new StraightEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.NINE, Suit.DIAMONDS),
                                Card.get(Rank.THREE, Suit.HEARTS),
                                Card.get(Rank.FOUR, Suit.CLUBS),
                                Card.get(Rank.FIVE, Suit.SPADES),
                                Card.get(Rank.SIX, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.HIGH_CARD);
    }
    @Test
    public void testFlushEvaluatorTrue() {
        ChainedHandEvaluator evaluator = new FlushEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.NINE, Suit.DIAMONDS),
                                Card.get(Rank.THREE, Suit.DIAMONDS),
                                Card.get(Rank.FOUR, Suit.DIAMONDS),
                                Card.get(Rank.FIVE, Suit.DIAMONDS),
                                Card.get(Rank.SIX, Suit.DIAMONDS)
                        )
                )
        )).isEqualTo(HandRank.FLUSH);
    }
    @Test
    public void testFlushEvaluatorFalse() {
        ChainedHandEvaluator evaluator = new FlushEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.NINE, Suit.DIAMONDS),
                                Card.get(Rank.THREE, Suit.HEARTS),
                                Card.get(Rank.FOUR, Suit.CLUBS),
                                Card.get(Rank.FIVE, Suit.SPADES),
                                Card.get(Rank.SIX, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.HIGH_CARD);
    }
    @Test
    public void testFullEvaluatortrue() {
        ChainedHandEvaluator evaluator = new FullEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.NINE, Suit.DIAMONDS),
                                Card.get(Rank.NINE, Suit.SPADES),
                                Card.get(Rank.NINE, Suit.CLUBS),
                                Card.get(Rank.SIX, Suit.CLUBS),
                                Card.get(Rank.SIX, Suit.DIAMONDS)
                        )
                )
        )).isEqualTo(HandRank.FULL_HOUSE);
    }
    @Test
    public void testFullEvaluatorfalse() {
        ChainedHandEvaluator evaluator = new StraightEvaluator(ChainedHandEvaluator.HIGH_CARD);
        assertThat(evaluator.handEvaluator(
                new PokerHand(
                        List.of(
                                Card.get(Rank.NINE, Suit.DIAMONDS),
                                Card.get(Rank.THREE, Suit.HEARTS),
                                Card.get(Rank.FOUR, Suit.CLUBS),
                                Card.get(Rank.FIVE, Suit.SPADES),
                                Card.get(Rank.SIX, Suit.HEARTS)
                        )
                )
        )).isEqualTo(HandRank.HIGH_CARD);
    }
}
