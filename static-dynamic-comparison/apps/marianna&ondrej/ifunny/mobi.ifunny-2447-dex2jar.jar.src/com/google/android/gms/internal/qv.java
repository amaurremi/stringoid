package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataType;

import java.util.ArrayList;

public class qv
        implements Parcelable.Creator<lf> {
    static void a(lf paramlf, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.c(paramParcel, 1, paramlf.a(), false);
        c.a(paramParcel, 1000, paramlf.b());
        c.a(paramParcel, paramInt);
    }

    public lf a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList = a.c(paramParcel, k, DataType.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new lf(i, localArrayList);
    }

    public lf[] a(int paramInt) {
        return new lf[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/qv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */