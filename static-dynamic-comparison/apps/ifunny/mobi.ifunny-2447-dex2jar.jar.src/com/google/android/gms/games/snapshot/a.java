package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.drive.Contents;

public class a
        implements Parcelable.Creator<SnapshotContents> {
    static void a(SnapshotContents paramSnapshotContents, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSnapshotContents.b(), paramInt, false);
        c.a(paramParcel, 1000, paramSnapshotContents.a());
        c.a(paramParcel, i);
    }

    public SnapshotContents a(Parcel paramParcel) {
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        Contents localContents = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    localContents = (Contents) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Contents.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SnapshotContents(i, localContents);
    }

    public SnapshotContents[] a(int paramInt) {
        return new SnapshotContents[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */