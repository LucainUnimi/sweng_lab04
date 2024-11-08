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

  @Test
  void newPokerHandTest() {
    PokerHand hand = new PokerHand(List.of(THREE_OF_A_KIND_CARDS));
    assertThat(hand).contains(THREE_OF_A_KIND_CARDS);
  }

}
