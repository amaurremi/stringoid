package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class a
        implements Parcelable.Creator<MilestoneEntity> {
    static void a(MilestoneEntity paramMilestoneEntity, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramMilestoneEntity.A_(), false);
        c.a(paramParcel, 1000, paramMilestoneEntity.h());
        c.a(paramParcel, 2, paramMilestoneEntity.c());
        c.a(paramParcel, 3, paramMilestoneEntity.f());
        c.a(paramParcel, 4, paramMilestoneEntity.g(), false);
        c.a(paramParcel, 5, paramMilestoneEntity.e());
        c.a(paramParcel, 6, paramMilestoneEntity.d(), false);
        c.a(paramParcel, paramInt);
    }

    public MilestoneEntity a(Parcel paramParcel) {
        long l1 = 0L;
        int i = 0;
        String str1 = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        byte[] arrayOfByte = null;
        long l2 = 0L;
        String str2 = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(m)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, m);
                    break;
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
                    break;
                case 1000:
                    j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 2:
                    l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
                    break;
                case 3:
                    l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, m);
                    break;
                case 4:
                    arrayOfByte = com.google.android.gms.common.internal.safeparcel.a.r(paramParcel, m);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 6:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new MilestoneEntity(j, str2, l2, l1, arrayOfByte, i, str1);
    }

    public MilestoneEntity[] a(int paramInt) {
        return new MilestoneEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */