package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SnapshotMetadataChange
        implements SafeParcelable {
    public static final c CREATOR = new c();
    public static final SnapshotMetadataChange a = new SnapshotMetadataChange();
    private final int b;
    private final String c;
    private final Long d;
    private final Uri e;
    private a f;

    SnapshotMetadataChange() {
        this(4, null, null, null, null);
    }

    SnapshotMetadataChange(int paramInt, String paramString, Long paramLong, a parama, Uri paramUri) {
        this.b = paramInt;
        this.c = paramString;
        this.d = paramLong;
        this.f = parama;
        this.e = paramUri;
        if (this.f != null) {
            if (this.e == null) {
                ag.a(bool1, "Cannot set both a URI and an image");
            }
        }
        while (this.e == null) {
            for (; ; ) {
                return;
                bool1 = false;
            }
        }
        if (this.f == null) {
        }
        for (bool1 = bool2; ; bool1 = false) {
            ag.a(bool1, "Cannot set both a URI and an image");
            return;
        }
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Long c() {
        return this.d;
    }

    public a d() {
        return this.f;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.e;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotMetadataChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */