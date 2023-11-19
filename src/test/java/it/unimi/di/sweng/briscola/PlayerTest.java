package it.unimi.di.sweng.briscola;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
    @Test
    public void PlayerComparableTest(){
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        p1.addWonCardsToPersonalDeck(Card.get(Rank.ASSO, Suit.BASTONI), Card.get(Rank.DUE, Suit.BASTONI));
        assertThat(p2.compareTo(p1)).isEqualTo(-1);
        p2.addWonCardsToPersonalDeck(Card.get(Rank.ASSO, Suit.BASTONI), Card.get(Rank.DUE, Suit.BASTONI));
        assertThat(p2.compareTo(p1)).isEqualTo(0);
    }
    @Test
    public void PlayerIterable(){
        Player p1 = new Player("P1");
        List<Card> cards = List.of(Card.get(Rank.ASSO, Suit.BASTONI), Card.get(Rank.ASSO, Suit.DENARI), Card.get(Rank.ASSO, Suit.SPADE));
        for (Card card: cards) {
            p1.giveCard(card);
        }
        ArrayList<Card> listaCard = new ArrayList<>();
        for (Card card:p1) {
            listaCard.add(card);
        }
        assertThat(listaCard).containsExactlyInAnyOrderElementsOf(cards);
    }
}
