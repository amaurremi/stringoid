package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<ClientSettings.ParcelableClientSettings> {
    static void a(ClientSettings.ParcelableClientSettings paramParcelableClientSettings, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramParcelableClientSettings.a(), false);
        c.a(paramParcel, 1000, paramParcelableClientSettings.f());
        c.b(paramParcel, 2, paramParcelableClientSettings.e(), false);
        c.a(paramParcel, 3, paramParcelableClientSettings.c());
        c.a(paramParcel, 4, paramParcelableClientSettings.d(), false);
        c.a(paramParcel, paramInt);
    }

    public ClientSettings.ParcelableClientSettings a(Parcel paramParcel) {
        int i = 0;
        String str1 = null;
        int k = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        ArrayList localArrayList = null;
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
                    localArrayList = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel, m);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, m);
                    break;
                case 4:
                    str1 = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new ClientSettings.ParcelableClientSettings(j, str2, localArrayList, i, str1);
    }

    public ClientSettings.ParcelableClientSettings[] a(int paramInt) {
        return new ClientSettings.ParcelableClientSettings[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */