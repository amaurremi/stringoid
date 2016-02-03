package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class rb
        implements Parcelable.Creator<me> {
    static void a(me paramme, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramme.a());
        c.a(paramParcel, 1000, paramme.a);
        c.c(paramParcel, 2, paramme.b(), false);
        c.a(paramParcel, paramInt);
    }

    public me a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        ArrayList localArrayList = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    bool = a.c(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = a.c(paramParcel, k, mo.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new me(i, bool, localArrayList);
    }

    public me[] a(int paramInt) {
        return new me[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/rb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */