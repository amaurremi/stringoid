package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Player;

public abstract interface Participant
        extends Parcelable, d<Participant> {
    public abstract boolean e();

    public abstract String f();

    public abstract Uri g();

    @Deprecated
    public abstract String h();

    public abstract Uri i();

    @Deprecated
    public abstract String j();

    public abstract String k();

    public abstract Player l();

    public abstract ParticipantResult m();

    public abstract int t_();

    public abstract String u_();

    public abstract int v_();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/Participant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */