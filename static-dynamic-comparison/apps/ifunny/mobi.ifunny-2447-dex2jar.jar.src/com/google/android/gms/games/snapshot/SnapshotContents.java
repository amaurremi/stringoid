package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public final class SnapshotContents
        implements SafeParcelable {
    public static final a CREATOR = new a();
    private static final Object a = new Object();
    private final int b;
    private Contents c;

    SnapshotContents(int paramInt, Contents paramContents) {
        this.b = paramInt;
        this.c = paramContents;
    }

    public int a() {
        return this.b;
    }

    public Contents b() {
        return this.c;
    }

    public boolean c() {
        return this.c == null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */