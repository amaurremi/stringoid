package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class b
        implements Parcelable.Creator<SnapshotEntity> {
    static void a(SnapshotEntity paramSnapshotEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSnapshotEntity.b(), paramInt, false);
        c.a(paramParcel, 1000, paramSnapshotEntity.d());
        c.a(paramParcel, 3, paramSnapshotEntity.c(), paramInt, false);
        c.a(paramParcel, i);
    }

    public SnapshotEntity a(Parcel paramParcel) {
        SnapshotContents localSnapshotContents = null;
        int j = a.b(paramParcel);
        int i = 0;
        SnapshotMetadataEntity localSnapshotMetadataEntity = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                localSnapshotMetadataEntity = (SnapshotMetadataEntity) a.a(paramParcel, k, SnapshotMetadataEntity.CREATOR);
                continue;
                i = a.g(paramParcel, k);
                continue;
                localSnapshotContents = (SnapshotContents) a.a(paramParcel, k, SnapshotContents.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new SnapshotEntity(i, localSnapshotMetadataEntity, localSnapshotContents);
    }

    public SnapshotEntity[] a(int paramInt) {
        return new SnapshotEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */