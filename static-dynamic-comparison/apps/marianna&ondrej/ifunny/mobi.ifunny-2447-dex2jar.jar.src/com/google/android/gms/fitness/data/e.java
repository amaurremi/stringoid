package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<DataPoint> {
    static void a(DataPoint paramDataPoint, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataPoint.b(), paramInt, false);
        c.a(paramParcel, 1000, paramDataPoint.h());
        c.a(paramParcel, 3, paramDataPoint.d());
        c.a(paramParcel, 4, paramDataPoint.g());
        c.a(paramParcel, 5, paramDataPoint.a(), paramInt, false);
        c.a(paramParcel, 6, paramDataPoint.c(), paramInt, false);
        c.a(paramParcel, 7, paramDataPoint.e());
        c.a(paramParcel, 8, paramDataPoint.f());
        c.a(paramParcel, i);
    }

    public DataPoint a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        DataSource localDataSource2 = null;
        long l4 = 0L;
        long l3 = 0L;
        Value[] arrayOfValue = null;
        DataSource localDataSource1 = null;
        long l2 = 0L;
        long l1 = 0L;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localDataSource2 = (DataSource) a.a(paramParcel, k, DataSource.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 3:
                    l4 = a.i(paramParcel, k);
                    break;
                case 4:
                    l3 = a.i(paramParcel, k);
                    break;
                case 5:
                    arrayOfValue = (Value[]) a.b(paramParcel, k, Value.CREATOR);
                    break;
                case 6:
                    localDataSource1 = (DataSource) a.a(paramParcel, k, DataSource.CREATOR);
                    break;
                case 7:
                    l2 = a.i(paramParcel, k);
                    break;
                case 8:
                    l1 = a.i(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataPoint(i, localDataSource2, l4, l3, arrayOfValue, localDataSource1, l2, l1);
    }

    public DataPoint[] a(int paramInt) {
        return new DataPoint[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */