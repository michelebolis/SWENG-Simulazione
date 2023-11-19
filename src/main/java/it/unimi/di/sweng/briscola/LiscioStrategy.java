package it.unimi.di.sweng.briscola;

import org.jetbrains.annotations.NotNull;

public class LiscioStrategy implements Strategy{
    private final Strategy next;

    public LiscioStrategy(Strategy next){
        this.next = next;
    }
    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        for (Card card: me) {
            if(card.getSuit()!=briscola && card.getRank().points()==0) return card;
        }
        return next.chooseCard(me, other, briscola);
    }
}
