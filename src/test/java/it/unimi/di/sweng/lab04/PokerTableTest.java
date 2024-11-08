package it.unimi.di.sweng.lab04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.assertThat;

@Timeout(2)
class PokerTableTest {

    @Test
    void newPokerTableTest(){
        PokerTable table = new PokerTable(5);
        assertThat(table).hasSize(5);
    }

}