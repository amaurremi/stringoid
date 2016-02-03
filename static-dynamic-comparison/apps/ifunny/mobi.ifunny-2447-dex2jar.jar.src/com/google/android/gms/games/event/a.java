package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.PlayerEntity;

public class a
        implements Parcelable.Creator<EventEntity> {
    static void a(EventEntity paramEventEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramEventEntity.k_(), false);
        c.a(paramParcel, 1000, paramEventEntity.k());
        c.a(paramParcel, 2, paramEventEntity.c(), false);
        c.a(paramParcel, 3, paramEventEntity.d(), false);
        c.a(paramParcel, 4, paramEventEntity.e(), paramInt, false);
        c.a(paramParcel, 5, paramEventEntity.f(), false);
        c.a(paramParcel, 6, paramEventEntity.g(), paramInt, false);
        c.a(paramParcel, 7, paramEventEntity.h());
        c.a(paramParcel, 8, paramEventEntity.i(), false);
        c.a(paramParcel, 9, paramEventEntity.j());
        c.a(paramParcel, i);
    }

    public EventEntity a(Parcel paramParcel) {
        boolean bool = false;
        String str1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        long l = 0L;
        PlayerEntity localPlayerEntity = null;
        String str2 = null;
        Uri localUri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    str5 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    str4 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 3:
                    str3 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 4:
                    localUri = (Uri) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, Uri.CREATOR);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 6:
                    localPlayerEntity = (PlayerEntity) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, PlayerEntity.CREATOR);
                    break;
                case 7:
                    l = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
                    break;
                case 8:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
                    break;
                case 9:
                    bool = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new EventEntity(i, str5, str4, str3, localUri, str2, localPlayerEntity, l, str1, bool);
    }

    public EventEntity[] a(int paramInt) {
        return new EventEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/event/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */