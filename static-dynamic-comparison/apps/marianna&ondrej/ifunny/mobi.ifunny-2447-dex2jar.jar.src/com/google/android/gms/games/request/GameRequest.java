package com.google.android.gms.games.request;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

import java.util.List;

public abstract interface GameRequest
        extends Parcelable, d<GameRequest> {
    public abstract int a_(String paramString);

    public abstract String d();

    public abstract Game e();

    public abstract Player f();

    public abstract byte[] h();

    public abstract int i();

    public abstract long j();

    public abstract long k();

    public abstract int l();

    public abstract List<Player> n();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/request/GameRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */