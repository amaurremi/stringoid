package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

public class o
        implements Parcelable.Creator<b> {
    static void a(b paramb, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramb.a);
        c.a(paramParcel, 2, paramb.a(), false);
        c.a(paramParcel, 3, paramb.c, paramInt, false);
        c.a(paramParcel, i);
    }

    public b a(Parcel paramParcel) {
        IntentFilter[] arrayOfIntentFilter = null;
        int j = a.b(paramParcel);
        int i = 0;
        IBinder localIBinder = null;
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
                    localIBinder = a.p(paramParcel, k);
                    break;
                case 3:
                    arrayOfIntentFilter = (IntentFilter[]) a.b(paramParcel, k, IntentFilter.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + j, paramParcel);
        }
        return new b(i, localIBinder, arrayOfIntentFilter);
    }

    public b[] a(int paramInt) {
        return new b[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */