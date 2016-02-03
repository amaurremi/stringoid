package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class d
        implements Parcelable.Creator<SnapshotMetadataEntity> {
    static void a(SnapshotMetadataEntity paramSnapshotMetadataEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSnapshotMetadataEntity.C_(), paramInt, false);
        c.a(paramParcel, 1000, paramSnapshotMetadataEntity.m());
        c.a(paramParcel, 2, paramSnapshotMetadataEntity.c(), paramInt, false);
        c.a(paramParcel, 3, paramSnapshotMetadataEntity.d(), false);
        c.a(paramParcel, 5, paramSnapshotMetadataEntity.e(), paramInt, false);
        c.a(paramParcel, 6, paramSnapshotMetadataEntity.f(), false);
        c.a(paramParcel, 7, paramSnapshotMetadataEntity.i(), false);
        c.a(paramParcel, 8, paramSnapshotMetadataEntity.j(), false);
        c.a(paramParcel, 9, paramSnapshotMetadataEntity.k());
        c.a(paramParcel, 10, paramSnapshotMetadataEntity.l());
        c.a(paramParcel, 11, paramSnapshotMetadataEntity.g());
        c.a(paramParcel, 12, paramSnapshotMetadataEntity.h(), false);
        c.a(paramParcel, i);
    }

    public SnapshotMetadataEntity a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        GameEntity localGameEntity = null;
        PlayerEntity localPlayerEntity = null;
        String str5 = null;
        Uri localUri = null;
        String str4 = null;
        String str3 = null;
        String str2 = null;
        long l2 = 0L;
        long l1 = 0L;
        float f = 0.0F;
        String str1 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localGameEntity = (GameEntity) a.a(paramParcel, k, GameEntity.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localPlayerEntity = (PlayerEntity) a.a(paramParcel, k, PlayerEntity.CREATOR);
                    break;
                case 3:
                    str5 = a.o(paramParcel, k);
                    break;
                case 5:
                    localUri = (Uri) a.a(paramParcel, k, Uri.CREATOR);
                    break;
                case 6:
                    str4 = a.o(paramParcel, k);
                    break;
                case 7:
                    str3 = a.o(paramParcel, k);
                    break;
                case 8:
                    str2 = a.o(paramParcel, k);
                    break;
                case 9:
                    l2 = a.i(paramParcel, k);
                    break;
                case 10:
                    l1 = a.i(paramParcel, k);
                    break;
                case 11:
                    f = a.l(paramParcel, k);
                    break;
                case 12:
                    str1 = a.o(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new SnapshotMetadataEntity(i, localGameEntity, localPlayerEntity, str5, localUri, str4, str3, str2, l2, l1, f, str1);
    }

    public SnapshotMetadataEntity[] a(int paramInt) {
        return new SnapshotMetadataEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/snapshot/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */