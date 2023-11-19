package it.unimi.di.sweng.briscola;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BriscolaTest {
    @Test
    public void establishTurnWinnerSameSeedTest(){
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Deck deck = mock(Deck.class);
        Card card = Card.get(Rank.CINQUE, Suit.BASTONI);
        Card briscola = Card.get(Rank.CINQUE, Suit.COPPE);
        when(deck.draw()).thenReturn(card, card, card, card, card, card, briscola);
        Briscola partita = new Briscola(p1, p2, deck);
        Card cardVincente = Card.get(Rank.ASSO, Suit.COPPE);
        Card cardPerdente = Card.get(Rank.TRE, Suit.COPPE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p1));
    }
    @Test
    public void establishTurnWinnerNoBriscolaTest(){
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Deck deck = mock(Deck.class);
        Card card = Card.get(Rank.CINQUE, Suit.BASTONI);
        Card briscola = Card.get(Rank.CINQUE, Suit.COPPE);
        when(deck.draw()).thenReturn(card, card, card, card, card, card, briscola);
        Briscola partita = new Briscola(p1, p2, deck);
        Card cardVincente = Card.get(Rank.ASSO, Suit.BASTONI);
        Card cardPerdente = Card.get(Rank.TRE, Suit.SPADE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p1));
    }
    @Test
    public void establishTurnWinnerP2BriscolaTest(){
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Deck deck = mock(Deck.class);
        Card card = Card.get(Rank.CINQUE, Suit.BASTONI);
        Card briscola = Card.get(Rank.CINQUE, Suit.COPPE);
        when(deck.draw()).thenReturn(card, card, card, card, card, card, briscola);
        Briscola partita = new Briscola(p1, p2, deck);
        Card cardVincente = Card.get(Rank.ASSO, Suit.SPADE);
        Card cardPerdente = Card.get(Rank.DUE, Suit.COPPE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p2));
    }
    @Test
    public void establishTurnWinnerP1BriscolaTest(){
        Player p1 = mock(Player.class);
        Player p2 = mock(Player.class);
        Deck deck = mock(Deck.class);
        Card card = Card.get(Rank.CINQUE, Suit.BASTONI);
        Card briscola = Card.get(Rank.CINQUE, Suit.COPPE);
        when(deck.draw()).thenReturn(card, card, card, card, card, card, briscola);
        Briscola partita = new Briscola(p1, p2, deck);
        Card cardVincente = Card.get(Rank.ASSO, Suit.COPPE);
        Card cardPerdente = Card.get(Rank.DUE, Suit.SPADE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p1));
    }
}
