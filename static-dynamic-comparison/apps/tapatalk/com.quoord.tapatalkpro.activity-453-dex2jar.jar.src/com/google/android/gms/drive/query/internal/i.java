package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class i
        implements Parcelable.Creator<NotFilter> {
    static void a(NotFilter paramNotFilter, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.c(paramParcel, 1000, paramNotFilter.xH);
        b.a(paramParcel, 1, paramNotFilter.GT, paramInt, false);
        b.F(paramParcel, i);
    }

    public NotFilter[] aP(int paramInt) {
        return new NotFilter[paramInt];
    }

    public NotFilter al(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        FilterHolder localFilterHolder = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
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
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new NotFilter(i, localFilterHolder);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/query/internal/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */