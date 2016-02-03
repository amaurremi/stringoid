package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.snapshot.SnapshotMetadata;

import java.util.ArrayList;

public abstract interface ExtendedGame
        extends Parcelable, d<ExtendedGame> {
    public abstract boolean e();

    public abstract int f();

    public abstract long g();

    public abstract long h();

    public abstract String i();

    public abstract long j();

    public abstract String k();

    public abstract SnapshotMetadata l();

    public abstract ArrayList<GameBadge> l_();

    public abstract int m_();

    public abstract Game n_();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/game/ExtendedGame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */