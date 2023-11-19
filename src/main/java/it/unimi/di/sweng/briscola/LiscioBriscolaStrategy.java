package it.unimi.di.sweng.briscola;

import org.jetbrains.annotations.NotNull;

public class LiscioBriscolaStrategy implements Strategy{
    public LiscioBriscolaStrategy(Strategy next) {
    }

    @Override
    public @NotNull Card chooseCard(@NotNull Player me, @NotNull Player other, @NotNull Suit briscola) {
        return null;
    }
}
