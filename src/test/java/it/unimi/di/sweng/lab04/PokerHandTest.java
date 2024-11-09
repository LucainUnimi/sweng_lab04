package it.unimi.di.sweng.lab04;



import static org.assertj.core.api.Assertions.*;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import ca.mcgill.cs.stg.solitaire.cards.Rank;
import ca.mcgill.cs.stg.solitaire.cards.Suit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;


@Timeout(2)
public class PokerHandTest {

  private static Deck createEmptyDeck() {
    Deck deck = new Deck();
    for (int i = 0; i<52;i++)deck.draw();
    return deck;
  }
  final static private Card[] THREE_OF_A_KIND_CARDS = {
          Card.get (Rank.ACE, Suit. HEARTS), Card.get (Rank. THREE, Suit. HEARTS) , Card. get (Rank. FIVE, Suit. HEARTS), Card.get (Rank. ACE, Suit. CLUBS),
          Card.get (Rank. ACE, Suit. DIAMONDS)
  };

  final static private Card[] PokerHand = {
          Card.get (Rank.TWO, Suit. HEARTS), Card.get (Rank. THREE, Suit. HEARTS) , Card. get (Rank. FIVE, Suit. HEARTS), Card.get (Rank. FOUR, Suit. HEARTS),
          Card.get (Rank. SIX, Suit. HEARTS)
  };

  @Test
  void newPokerHandTest() {
    PokerHand hand = new PokerHand(List.of(THREE_OF_A_KIND_CARDS));
    assertThat((Iterable<Card>)hand).contains(THREE_OF_A_KIND_CARDS);
  }

  @Test
  void getPointsTest() {
    PokerHand hand = new PokerHand(List.of(THREE_OF_A_KIND_CARDS));
    assertThat(hand.getPoints()).isEqualTo(HandRank.THREE_OF_A_KIND);
  }

  @Test
  void getPointsTest2() {
    PokerHand hand = new PokerHand(List.of(PokerHand));
    assertThat(hand.getPoints()).isEqualTo(HandRank.STRAIGHT_FLUSH);
  }

  @Test
  void compareHandTest() {
    assertThat(new PokerHand(List.of(THREE_OF_A_KIND_CARDS)).compareTo(new PokerHand(List.of(PokerHand)))).isNegative();
  }

  @Test
  void compareHandTest2() {
    assertThat(new PokerHand(List.of(PokerHand)).compareTo(new PokerHand(List.of(PokerHand)))).isZero();
  }

  @Test
  void compareHandTest3() {
    assertThat(new PokerHand(List.of(PokerHand)).compareTo(new PokerHand(List.of(THREE_OF_A_KIND_CARDS)))).isPositive();
  }

}
