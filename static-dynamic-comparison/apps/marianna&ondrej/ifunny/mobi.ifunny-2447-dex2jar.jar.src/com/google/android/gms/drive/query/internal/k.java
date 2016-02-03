package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
        implements Parcelable.Creator<NotFilter> {
    static void a(NotFilter paramNotFilter, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1000, paramNotFilter.b);
        c.a(paramParcel, 1, paramNotFilter.a, paramInt, false);
        c.a(paramParcel, i);
    }

    public NotFilter a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        FilterHolder localFilterHolder = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 1:
                    localFilterHolder = (FilterHolder) a.a(paramParcel, k, FilterHolder.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new NotFilter(i, localFilterHolder);
    }

    public NotFilter[] a(int paramInt) {
        return new NotFilter[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/query/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */