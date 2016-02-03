package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.f;

public abstract interface TurnBasedMatch
        extends Parcelable, d<TurnBasedMatch>, f {
    public static final int[] a_ = {0, 1, 2, 3};

    public abstract String c();

    public abstract String d();

    public abstract long e();

    public abstract int f();

    public abstract int g();

    public abstract String h();

    public abstract int i();

    public abstract String j();

    public abstract long k();

    public abstract String m();

    public abstract byte[] n();

    public abstract int o();

    public abstract String p();

    public abstract byte[] q();

    public abstract int r();

    public abstract Bundle s();

    public abstract int t();

    public abstract boolean u();

    public abstract String v();

    public abstract Game z_();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/turnbased/TurnBasedMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */