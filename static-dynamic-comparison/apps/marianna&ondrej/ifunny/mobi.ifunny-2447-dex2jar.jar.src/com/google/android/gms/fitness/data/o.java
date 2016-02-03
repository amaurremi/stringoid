package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class o
        implements Parcelable.Creator<RawDataPoint> {
    static void a(RawDataPoint paramRawDataPoint, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramRawDataPoint.b);
        c.a(paramParcel, 1000, paramRawDataPoint.a);
        c.a(paramParcel, 2, paramRawDataPoint.c);
        c.a(paramParcel, 3, paramRawDataPoint.d, paramInt, false);
        c.a(paramParcel, 4, paramRawDataPoint.e);
        c.a(paramParcel, 5, paramRawDataPoint.f);
        c.a(paramParcel, 6, paramRawDataPoint.g);
        c.a(paramParcel, 7, paramRawDataPoint.h);
        c.a(paramParcel, i);
    }

    public RawDataPoint a(Parcel paramParcel) {
        int m = a.b(paramParcel);
        int k = 0;
        long l4 = 0L;
        long l3 = 0L;
        Value[] arrayOfValue = null;
        int j = 0;
        int i = 0;
        long l2 = 0L;
        long l1 = 0L;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    l4 = a.i(paramParcel, n);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    l3 = a.i(paramParcel, n);
                    break;
                case 3:
                    arrayOfValue = (Value[]) a.b(paramParcel, n, Value.CREATOR);
                    break;
                case 4:
                    j = a.g(paramParcel, n);
                    break;
                case 5:
                    i = a.g(paramParcel, n);
                    break;
                case 6:
                    l2 = a.i(paramParcel, n);
                    break;
                case 7:
                    l1 = a.i(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new RawDataPoint(k, l4, l3, arrayOfValue, j, i, l2, l1);
    }

    public RawDataPoint[] a(int paramInt) {
        return new RawDataPoint[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */