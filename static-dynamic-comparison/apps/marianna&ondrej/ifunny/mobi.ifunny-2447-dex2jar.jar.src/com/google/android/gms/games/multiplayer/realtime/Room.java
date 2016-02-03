package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.multiplayer.f;

public abstract interface Room
        extends Parcelable, d<Room>, f {
    public abstract int e();

    public abstract String f();

    public abstract int g();

    public abstract Bundle h();

    public abstract int i();

    public abstract String w_();

    public abstract String x_();

    public abstract long y_();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/Room.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */