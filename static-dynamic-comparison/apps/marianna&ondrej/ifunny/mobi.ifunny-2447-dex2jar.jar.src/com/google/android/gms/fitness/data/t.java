package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class t
        implements Parcelable.Creator<Subscription> {
    static void a(Subscription paramSubscription, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramSubscription.a(), paramInt, false);
        c.a(paramParcel, 1000, paramSubscription.e());
        c.a(paramParcel, 2, paramSubscription.b(), paramInt, false);
        c.a(paramParcel, 3, paramSubscription.d());
        c.a(paramParcel, 4, paramSubscription.c());
        c.a(paramParcel, i);
    }

    public Subscription a(Parcel paramParcel) {
        DataType localDataType = null;
        int i = 0;
        int k = a.b(paramParcel);
        long l = 0L;
        DataSource localDataSource = null;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    localDataSource = (DataSource) a.a(paramParcel, m, DataSource.CREATOR);
                    break;
                case 1000:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    localDataType = (DataType) a.a(paramParcel, m, DataType.CREATOR);
                    break;
                case 3:
                    l = a.i(paramParcel, m);
                    break;
                case 4:
                    i = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new Subscription(j, localDataSource, localDataType, l, i);
    }

    public Subscription[] a(int paramInt) {
        return new Subscription[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */