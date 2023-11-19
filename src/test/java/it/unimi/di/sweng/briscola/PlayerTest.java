package it.unimi.di.sweng.briscola;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Test
    public void PlayerComparableSimpleTest(){
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        p1.addWonCardsToPersonalDeck(Card.get(Rank.ASSO, Suit.BASTONI), Card.get(Rank.DUE, Suit.BASTONI));
        assertThat(p1.compareTo(p2)).isEqualTo(1);
    }
}
