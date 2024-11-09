package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Timeout(2)
class PokerTableTest {

    @Test
    void newPokerTableTest() {
        PokerTable table = new PokerTable(5);
        assertThat(table).hasSize(5);
    }

    @ParameterizedTest
    @CsvSource({
            "2",
            "3"
    })
    void getHandTest(int n) {
        PokerTable table = new PokerTable(5);
        Iterator<PokerHand> iterator = table.iterator();
        PokerHand hand = table.getHand(0);
        for (int i = 0; i <= n; i++) {
            hand = iterator.next();
        }

        assertThat((Iterable<Card>) hand).isEqualTo(table.getHand(n));
    }

    @Test
    void changeCardsTest(){
        PokerTable pokerTable = new PokerTable(5);
        PokerHand hand = pokerTable.getHand(0);
        List<Card> newHand = new ArrayList<>();
        for(Card card : hand){
            newHand.add(card);
        }
        newHand.removeFirst();
        pokerTable.change(0, newHand);
        assertThat((Iterable<Card>) pokerTable.getHand(0)).isNotEqualTo(hand);
    }

    @Test
    void iteratorSortedTest() {
        PokerTable table = new PokerTable(5);
        Iterator<Integer> it = table.iteratorSortedPoints();
        HandRank prec = HandRank.STRAIGHT_FLUSH;
        boolean sorted = true;
        while (it.hasNext()) {
            Integer i = it.next();
            if (prec.compareTo(table.getHand(i).getPoints()) < 0) {
                sorted = false;
            }
            prec = table.getHand(i).getPoints();
        }
        assertThat(sorted).isTrue();
    }

}
