package it.unimi.di.sweng.briscola;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BriscolaTest {
    private Briscola partita;
    private Player p1;
    private Player p2;
    @BeforeEach
    public void setup(){
        p1 = mock(Player.class);
        p2 = mock(Player.class);
        Deck deck = mock(Deck.class);
        Card card = Card.get(Rank.CINQUE, Suit.BASTONI);
        Card briscola = Card.get(Rank.CINQUE, Suit.COPPE);
        when(deck.draw()).thenReturn(card, card, card, card, card, card, briscola);
        partita = new Briscola(p1, p2, deck);
    }
    @Test
    public void establishTurnWinnerSameSeedTest(){
        Card cardVincente = Card.get(Rank.ASSO, Suit.COPPE);
        Card cardPerdente = Card.get(Rank.TRE, Suit.COPPE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p1));
    }
    @Test
    public void establishTurnWinnerNoBriscolaTest(){
        Card cardVincente = Card.get(Rank.ASSO, Suit.BASTONI);
        Card cardPerdente = Card.get(Rank.TRE, Suit.SPADE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p1));
    }
    @Test
    public void establishTurnWinnerP2BriscolaTest(){
        Card cardVincente = Card.get(Rank.ASSO, Suit.SPADE);
        Card cardPerdente = Card.get(Rank.DUE, Suit.COPPE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p2));
    }
    @Test
    public void establishTurnWinnerP1BriscolaTest(){
        Card cardVincente = Card.get(Rank.ASSO, Suit.COPPE);
        Card cardPerdente = Card.get(Rank.DUE, Suit.SPADE);
        assertThat(Optional.of(partita.establishTurnWinner(cardVincente, cardPerdente))).isEqualTo(Optional.of(p1));
    }
    @Test
    public void establishGameWinnerP1Test(){
        when(p1.compareTo(p2)).thenReturn(1);
        assertThat(Optional.of(partita.establishGameWinner())).isEqualTo(Optional.of(p1));
    }
    @Test
    public void establishGameWinnerP2Test(){
        when(p1.compareTo(p2)).thenReturn(-1);
        assertThat(Optional.of(partita.establishGameWinner())).isEqualTo(Optional.of(p2));
    }
    @Test
    public void establishGameWinnerParitaTest(){
        when(p1.compareTo(p2)).thenReturn(0);
        assertThat(Optional.of(partita.establishGameWinner())).isEqualTo(Optional.of(Player.NESSUNO));
    }
}
