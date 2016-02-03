package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.PlayerEntity;

public class a
        implements Parcelable.Creator<AchievementEntity> {
    static void a(AchievementEntity paramAchievementEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramAchievementEntity.j_(), false);
        c.a(paramParcel, 2, paramAchievementEntity.c());
        c.a(paramParcel, 3, paramAchievementEntity.d(), false);
        c.a(paramParcel, 4, paramAchievementEntity.e(), false);
        c.a(paramParcel, 5, paramAchievementEntity.f(), paramInt, false);
        c.a(paramParcel, 6, paramAchievementEntity.g(), false);
        c.a(paramParcel, 7, paramAchievementEntity.h(), paramInt, false);
        c.a(paramParcel, 8, paramAchievementEntity.i(), false);
        c.a(paramParcel, 9, paramAchievementEntity.j());
        c.a(paramParcel, 10, paramAchievementEntity.k(), false);
        c.a(paramParcel, 11, paramAchievementEntity.l(), paramInt, false);
        c.a(paramParcel, 12, paramAchievementEntity.m());
        c.a(paramParcel, 13, paramAchievementEntity.n());
        c.a(paramParcel, 14, paramAchievementEntity.o(), false);
        c.a(paramParcel, 15, paramAchievementEntity.p());
        c.a(paramParcel, 16, paramAchievementEntity.q());
        c.a(paramParcel, 1000, paramAchievementEntity.r());
        c.a(paramParcel, i);
    }

    public AchievementEntity a(Parcel paramParcel) {
        int i1 = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int n = 0;
        String str7 = null;
        int m = 0;
        String str6 = null;
        String str5 = null;
        Uri localUri2 = null;
        String str4 = null;
        Uri localUri1 = null;
        String str3 = null;
        int k = 0;
        String str2 = null;
        PlayerEntity localPlayerEntity = null;
        int j = 0;
        int i = 0;
        String str1 = null;
        long l2 = 0L;
        long l1 = 0L;
        while (paramParcel.dataPosition() < i1) {
            int i2 = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(i2)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i2);
                    break;
                case 1:
                    str7 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 2:
                    m = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i2);
                    break;
                case 3:
                    str6 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 4:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 5:
                    localUri2 = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i2, Uri.CREATOR);
                    break;
                case 6:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 7:
                    localUri1 = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i2, Uri.CREATOR);
                    break;
                case 8:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 9:
                    k = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i2);
                    break;
                case 10:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 11:
                    localPlayerEntity = (PlayerEntity) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, i2, PlayerEntity.CREATOR);
                    break;
                case 12:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i2);
                    break;
                case 13:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i2);
                    break;
                case 14:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, i2);
                    break;
                case 15:
                    l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, i2);
                    break;
                case 16:
                    l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, i2);
                    break;
                case 1000:
                    n = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, i2);
            }
        }
        if (paramParcel.dataPosition() != i1) {
            throw new b("Overread allowed size end=" + i1, paramParcel);
        }
        return new AchievementEntity(n, str7, m, str6, str5, localUri2, str4, localUri1, str3, k, str2, localPlayerEntity, j, i, str1, l2, l1);
    }

    public AchievementEntity[] a(int paramInt) {
        return new AchievementEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/achievement/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */