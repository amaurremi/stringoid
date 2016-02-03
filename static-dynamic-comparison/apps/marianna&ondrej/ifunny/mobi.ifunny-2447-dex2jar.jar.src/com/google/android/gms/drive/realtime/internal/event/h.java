package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class h
        implements Parcelable.Creator<ValuesAddedDetails> {
    static void a(ValuesAddedDetails paramValuesAddedDetails, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramValuesAddedDetails.a);
        c.a(paramParcel, 2, paramValuesAddedDetails.b);
        c.a(paramParcel, 3, paramValuesAddedDetails.c);
        c.a(paramParcel, 4, paramValuesAddedDetails.d);
        c.a(paramParcel, 5, paramValuesAddedDetails.e, false);
        c.a(paramParcel, 6, paramValuesAddedDetails.f);
        c.a(paramParcel, paramInt);
    }

    public ValuesAddedDetails a(Parcel paramParcel) {
        int i = 0;
        int i1 = a.b(paramParcel);
        String str = null;
        int j = 0;
        int k = 0;
        int m = 0;
        int n = 0;
        while (paramParcel.dataPosition() < i1) {
            int i2 = a.a(paramParcel);
            switch (a.a(i2)) {
                default:
                    a.b(paramParcel, i2);
                    break;
                case 1:
                    n = a.g(paramParcel, i2);
                    break;
                case 2:
                    m = a.g(paramParcel, i2);
                    break;
                case 3:
                    k = a.g(paramParcel, i2);
                    break;
                case 4:
                    j = a.g(paramParcel, i2);
                    break;
                case 5:
                    str = a.o(paramParcel, i2);
                    break;
                case 6:
                    i = a.g(paramParcel, i2);
            }
        }
        if (paramParcel.dataPosition() != i1) {
            throw new b("Overread allowed size end=" + i1, paramParcel);
        }
        return new ValuesAddedDetails(n, m, k, j, str, i);
    }

    public ValuesAddedDetails[] a(int paramInt) {
        return new ValuesAddedDetails[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */