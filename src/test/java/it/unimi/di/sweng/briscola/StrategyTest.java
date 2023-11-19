package it.unimi.di.sweng.briscola;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StrategyTest {
    private Player p1;
    private Player p2;
    @BeforeEach
    public void setup(){
        p1 = mock(Player.class);
        p2 = mock(Player.class);
    }
    @Test
    public void randomStrategyTest(){
        List<Card> mockedHand = List.of(Card.get(Rank.ASSO, Suit.COPPE),
                                        Card.get(Rank.DUE, Suit.BASTONI),
                                        Card.get(Rank.QUATTRO, Suit.SPADE));
        when(p1.iterator()).thenReturn(mockedHand.iterator());
        assertThat(mockedHand.contains(new StrategyRandom().chooseCard(p1, p2, Suit.BASTONI))).isTrue();
    }
    @Test
    public void LiscioStrategy(){
        List<Card> mockedHand = List.of(Card.get(Rank.ASSO, Suit.COPPE),
                Card.get(Rank.DUE, Suit.BASTONI),
                Card.get(Rank.QUATTRO, Suit.SPADE));
        when(p1.iterator()).thenReturn(mockedHand.iterator());
        assertThat(new LiscioStrategy(null).chooseCard(p1, p2, Suit.BASTONI)).isEqualTo(Card.get(Rank.QUATTRO, Suit.SPADE));
    }
}
