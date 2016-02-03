package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class PlayerEntityCreator
        implements Parcelable.Creator<PlayerEntity> {
    static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.a(paramParcel, 1, paramPlayerEntity.getPlayerId(), false);
        b.c(paramParcel, 1000, paramPlayerEntity.getVersionCode());
        b.a(paramParcel, 2, paramPlayerEntity.getDisplayName(), false);
        b.a(paramParcel, 3, paramPlayerEntity.getIconImageUri(), paramInt, false);
        b.a(paramParcel, 4, paramPlayerEntity.getHiResImageUri(), paramInt, false);
        b.a(paramParcel, 5, paramPlayerEntity.getRetrievedTimestamp());
        b.c(paramParcel, 6, paramPlayerEntity.gh());
        b.a(paramParcel, 7, paramPlayerEntity.getLastPlayedWithTimestamp());
        b.a(paramParcel, 8, paramPlayerEntity.getIconImageUrl(), false);
        b.a(paramParcel, 9, paramPlayerEntity.getHiResImageUrl(), false);
        b.F(paramParcel, i);
    }

    public PlayerEntity[] aT(int paramInt) {
        return new PlayerEntity[paramInt];
    }

    public PlayerEntity ao(Parcel paramParcel) {
        int k = a.o(paramParcel);
        int j = 0;
        String str4 = null;
        String str3 = null;
        Uri localUri2 = null;
        Uri localUri1 = null;
        long l2 = 0L;
        int i = 0;
        long l1 = 0L;
        String str2 = null;
        String str1 = null;
        while (paramParcel.dataPosition() < k) {
            int m = a.n(paramParcel);
            switch (a.R(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    str4 = a.n(paramParcel, m);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    str3 = a.n(paramParcel, m);
                    break;
                case 3:
                    localUri2 = (Uri) a.a(paramParcel, m, Uri.CREATOR);
                    break;
                case 4:
                    localUri1 = (Uri) a.a(paramParcel, m, Uri.CREATOR);
                    break;
                case 5:
                    l2 = a.i(paramParcel, m);
                    break;
                case 6:
                    i = a.g(paramParcel, m);
                    break;
                case 7:
                    l1 = a.i(paramParcel, m);
                    break;
                case 8:
                    str2 = a.n(paramParcel, m);
                    break;
                case 9:
                    str1 = a.n(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new a.a("Overread allowed size end=" + k, paramParcel);
        }
        return new PlayerEntity(j, str4, str3, localUri2, localUri1, l2, i, l1, str2, str1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/PlayerEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */