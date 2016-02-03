package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
        implements Parcelable.Creator<SnapshotMetadataChange> {
    static void a(SnapshotMetadataChange paramSnapshotMetadataChange, Parcel paramParcel, int paramInt) {
        int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1, paramSnapshotMetadataChange.b(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramSnapshotMetadataChange.a());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramSnapshotMetadataChange.c(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 4, paramSnapshotMetadataChange.e(), paramInt, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 5, paramSnapshotMetadataChange.d(), paramInt, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
    }

    public SnapshotMetadataChange a(Parcel paramParcel) {
        Uri localUri = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        com.google.android.gms.common.data.a locala = null;
        Long localLong = null;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    localLong = com.google.android.gms.common.internal.safeparcel.a.j(paramParcel, k);
                    break;
                case 4:
                    localUri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
                    break;
                case 5:
                    locala = (com.google.android.gms.common.data.a) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, com.google.android.gms.common.data.a.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SnapshotMetadataChange(i, str, localLong, locala, localUri);
    }

    public SnapshotMetadataChange[] a(int paramInt) {
        return new SnapshotMetadataChange[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */