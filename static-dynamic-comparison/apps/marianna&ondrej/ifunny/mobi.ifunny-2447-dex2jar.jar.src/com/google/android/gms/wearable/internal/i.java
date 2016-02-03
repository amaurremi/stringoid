package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class i
        implements Parcelable.Creator<am> {
    static void a(am paramam, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramam.a);
        c.a(paramParcel, 2, paramam.b, false);
        c.a(paramParcel, 3, paramam.c, false);
        c.a(paramParcel, 4, paramam.d);
        c.a(paramParcel, paramInt);
    }

    public am a(Parcel paramParcel) {
        String str1 = null;
        int j = a.b(paramParcel);
        int i = 0;
        long l = 0L;
        String str2 = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    str2 = a.o(paramParcel, k);
                    break;
                case 3:
                    str1 = a.o(paramParcel, k);
                    break;
                case 4:
                    l = a.i(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new am(i, str2, str1, l);
    }

    public am[] a(int paramInt) {
        return new am[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */