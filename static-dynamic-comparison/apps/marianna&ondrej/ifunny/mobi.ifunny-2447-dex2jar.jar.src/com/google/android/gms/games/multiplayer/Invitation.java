package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;

public abstract interface Invitation
        extends Parcelable, d<Invitation>, f {
    public abstract String e();

    public abstract Participant f();

    public abstract long g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract Game s_();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/Invitation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */