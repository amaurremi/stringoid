package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;

public abstract interface Event
        extends Parcelable, d<Event> {
    public abstract String c();

    public abstract String d();

    public abstract Uri e();

    @Deprecated
    public abstract String f();

    public abstract Player g();

    public abstract long h();

    public abstract String i();

    public abstract boolean j();

    public abstract String k_();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/event/Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */