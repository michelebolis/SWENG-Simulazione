package it.unimi.di.sweng.briscola;

import org.jetbrains.annotations.NotNull;

public class LiscioStrategy implements Strategy{
    private final Strategy next;

    public LiscioStrategy(Strategy next){
        this.next = next;
    }
    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        return next.chooseCard(me, other, briscola);
    }
}
