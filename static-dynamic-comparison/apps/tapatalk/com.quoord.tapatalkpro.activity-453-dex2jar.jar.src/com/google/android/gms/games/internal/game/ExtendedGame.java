package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

import java.util.ArrayList;

public abstract interface ExtendedGame
        extends Parcelable, Freezable<ExtendedGame> {
    public abstract ArrayList<GameBadge> gW();

    public abstract int gX();

    public abstract boolean gY();

    public abstract int gZ();

    public abstract Game getGame();

    public abstract long ha();

    public abstract long hb();

    public abstract String hc();

    public abstract long hd();

    public abstract String he();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */