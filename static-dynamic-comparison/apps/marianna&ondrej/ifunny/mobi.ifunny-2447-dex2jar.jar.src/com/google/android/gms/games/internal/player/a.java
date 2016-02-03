package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<MostRecentGameInfoEntity> {
    static void a(MostRecentGameInfoEntity paramMostRecentGameInfoEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramMostRecentGameInfoEntity.r_(), false);
        c.a(paramParcel, 1000, paramMostRecentGameInfoEntity.h());
        c.a(paramParcel, 2, paramMostRecentGameInfoEntity.c(), false);
        c.a(paramParcel, 3, paramMostRecentGameInfoEntity.d());
        c.a(paramParcel, 4, paramMostRecentGameInfoEntity.e(), paramInt, false);
        c.a(paramParcel, 5, paramMostRecentGameInfoEntity.f(), paramInt, false);
        c.a(paramParcel, 6, paramMostRecentGameInfoEntity.g(), paramInt, false);
        c.a(paramParcel, i);
    }

    public MostRecentGameInfoEntity a(Parcel paramParcel) {
        Uri localUri1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        long l = 0L;
        Uri localUri2 = null;
        Uri localUri3 = null;
        String str1 = null;
        String str2 = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 3:
                    l = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
                    break;
                case 4:
                    localUri3 = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
                    break;
                case 5:
                    localUri2 = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
                    break;
                case 6:
                    localUri1 = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new MostRecentGameInfoEntity(i, str2, str1, l, localUri3, localUri2, localUri1);
    }

    public MostRecentGameInfoEntity[] a(int paramInt) {
        return new MostRecentGameInfoEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/player/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */