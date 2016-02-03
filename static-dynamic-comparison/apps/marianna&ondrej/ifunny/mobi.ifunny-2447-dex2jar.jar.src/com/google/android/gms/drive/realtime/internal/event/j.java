package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class j
        implements Parcelable.Creator<ValuesSetDetails> {
    static void a(ValuesSetDetails paramValuesSetDetails, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramValuesSetDetails.a);
        c.a(paramParcel, 2, paramValuesSetDetails.b);
        c.a(paramParcel, 3, paramValuesSetDetails.c);
        c.a(paramParcel, 4, paramValuesSetDetails.d);
        c.a(paramParcel, paramInt);
    }

    public ValuesSetDetails a(Parcel paramParcel) {
        int m = 0;
        int n = a.b(paramParcel);
        int k = 0;
        int j = 0;
        int i = 0;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.a(paramParcel);
            switch (a.a(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    i = a.g(paramParcel, i1);
                    break;
                case 2:
                    j = a.g(paramParcel, i1);
                    break;
                case 3:
                    k = a.g(paramParcel, i1);
                    break;
                case 4:
                    m = a.g(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new b("Overread allowed size end=" + n, paramParcel);
        }
        return new ValuesSetDetails(i, j, k, m);
    }

    public ValuesSetDetails[] a(int paramInt) {
        return new ValuesSetDetails[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */