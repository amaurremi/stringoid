package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;

public abstract interface SnapshotMetadata
        extends Parcelable, d<SnapshotMetadata> {
    public abstract Game C_();

    public abstract Player c();

    public abstract String d();

    public abstract Uri e();

    @Deprecated
    public abstract String f();

    public abstract float g();

    public abstract String h();

    public abstract String i();

    public abstract String j();

    public abstract long k();

    public abstract long l();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */