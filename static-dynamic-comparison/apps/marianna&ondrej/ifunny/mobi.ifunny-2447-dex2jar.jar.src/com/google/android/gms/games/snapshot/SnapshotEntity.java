package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SnapshotEntity
        implements SafeParcelable, Snapshot {
    public static final b CREATOR = new b();
    private final int a;
    private final SnapshotMetadataEntity b;
    private final SnapshotContents c;

    SnapshotEntity(int paramInt, SnapshotMetadata paramSnapshotMetadata, SnapshotContents paramSnapshotContents) {
        this.a = paramInt;
        this.b = new SnapshotMetadataEntity(paramSnapshotMetadata);
        this.c = paramSnapshotContents;
    }

    static int a(Snapshot paramSnapshot) {
        return ad.a(new Object[]{paramSnapshot.b(), paramSnapshot.c()});
    }

    static boolean a(Snapshot paramSnapshot, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Snapshot)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramSnapshot == paramObject);
            paramObject = (Snapshot) paramObject;
            if (!ad.a(((Snapshot) paramObject).b(), paramSnapshot.b())) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((Snapshot) paramObject).c(), paramSnapshot.c()));
        return false;
    }

    static String b(Snapshot paramSnapshot) {
        af localaf = ad.a(paramSnapshot).a("Metadata", paramSnapshot.b());
        if (paramSnapshot.c() != null) {
        }
        for (boolean bool = true; ; bool = false) {
            return localaf.a("HasContents", Boolean.valueOf(bool)).toString();
        }
    }

    private boolean f() {
        return this.c.c();
    }

    public SnapshotMetadata b() {
        return this.b;
    }

    public SnapshotContents c() {
        if (f()) {
            return null;
        }
        return this.c;
    }

    public int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public Snapshot e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public int hashCode() {
        return a(this);
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/SnapshotEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */