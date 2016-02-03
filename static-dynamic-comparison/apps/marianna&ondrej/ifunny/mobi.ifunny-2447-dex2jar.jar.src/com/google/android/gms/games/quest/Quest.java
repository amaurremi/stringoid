package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.Game;

import java.util.List;

public abstract interface Quest
        extends Parcelable, d<Quest> {
    public static final int[] b_ = {1, 2, 3, 4, 6, 5};
    public static final String[] c_ = {Integer.toString(1), Integer.toString(2), Integer.toString(3)};

    public abstract String B_();

    public abstract String c();

    public abstract String d();

    public abstract Uri e();

    @Deprecated
    public abstract String f();

    public abstract Uri g();

    @Deprecated
    public abstract String h();

    public abstract List<Milestone> i();

    public abstract Game j();

    public abstract int k();

    public abstract int l();

    public abstract long m();

    public abstract long n();

    public abstract long o();

    public abstract long p();

    public abstract long q();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/Quest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */