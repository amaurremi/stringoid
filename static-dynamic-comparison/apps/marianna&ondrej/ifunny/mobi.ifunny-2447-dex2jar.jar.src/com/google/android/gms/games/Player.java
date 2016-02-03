package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public abstract interface Player
        extends Parcelable, d<Player> {
    @Deprecated
    public abstract String e();

    public abstract Uri f();

    @Deprecated
    public abstract String g();

    public abstract String g_();

    public abstract long h();

    public abstract String h_();

    public abstract long i();

    public abstract Uri i_();

    public abstract int j();

    public abstract boolean k();

    public abstract String l();

    public abstract PlayerLevelInfo m();

    public abstract MostRecentGameInfo n();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/Player.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */