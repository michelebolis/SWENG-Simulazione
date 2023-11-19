package it.unimi.di.sweng.briscola;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StrategyTest {
    @Test
    public void randomStrategyTest(){
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        List<Card> mockedHand = List.of(Card.get(Rank.ASSO, Suit.COPPE),
                                        Card.get(Rank.DUE, Suit.BASTONI),
                                        Card.get(Rank.QUATTRO, Suit.SPADE));
        when(p1.iterator()).thenReturn(mockedHand.iterator());
        assertThat(mockedHand.contains(new StrategyRandom().chooseCard(p1, p2, Suit.BASTONI))).isTrue();
    }
}
