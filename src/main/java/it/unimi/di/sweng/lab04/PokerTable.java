package it.unimi.di.sweng.lab04;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PokerTable implements Iterable<PokerHand> {
    private final Deck deck = new Deck();
    private final List<PokerHand> players;

    PokerTable(int numPlayers) {
        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            List<Card> temp = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                temp.add(deck.draw());
            }
            players.add(new PokerHand(temp));
        }
    }

    public @NotNull PokerHand getHand(int player) {
        return null;
    }

    @Override
    public @NotNull Iterator<PokerHand> iterator() {
        return players.iterator();
    }
}
