package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ge
        implements Parcelable.Creator<dv> {
    static void a(dv paramdv, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramdv.a);
        c.a(paramParcel, 2, paramdv.a(), false);
        c.a(paramParcel, 3, paramdv.b(), false);
        c.a(paramParcel, 4, paramdv.c(), false);
        c.a(paramParcel, 5, paramdv.d(), false);
        c.a(paramParcel, paramInt);
    }

    public dv a(Parcel paramParcel) {
        IBinder localIBinder1 = null;
        int j = a.b(paramParcel);
        int i = 0;
        IBinder localIBinder2 = null;
        IBinder localIBinder3 = null;
        IBinder localIBinder4 = null;
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
                    localIBinder4 = a.p(paramParcel, k);
                    break;
                case 3:
                    localIBinder3 = a.p(paramParcel, k);
                    break;
                case 4:
                    localIBinder2 = a.p(paramParcel, k);
                    break;
                case 5:
                    localIBinder1 = a.p(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new dv(i, localIBinder4, localIBinder3, localIBinder2, localIBinder1);
    }

    public dv[] a(int paramInt) {
        return new dv[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */