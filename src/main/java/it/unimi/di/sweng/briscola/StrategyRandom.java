package it.unimi.di.sweng.briscola;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class StrategyRandom implements Strategy{
    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        ArrayList<Card> cards = new ArrayList<>();
        for (Card card:me) { cards.add(card); }
        Collections.shuffle(cards);
        return cards.get(0);
    }
}
