package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class e
        implements Parcelable.Creator<StorageStats> {
    static void a(StorageStats paramStorageStats, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramStorageStats.a);
        c.a(paramParcel, 2, paramStorageStats.b);
        c.a(paramParcel, 3, paramStorageStats.c);
        c.a(paramParcel, 4, paramStorageStats.d);
        c.a(paramParcel, 5, paramStorageStats.e);
        c.a(paramParcel, 6, paramStorageStats.f);
        c.a(paramParcel, paramInt);
    }

    public StorageStats a(Parcel paramParcel) {
        int i = 0;
        long l1 = 0L;
        int k = a.b(paramParcel);
        long l2 = 0L;
        long l3 = 0L;
        long l4 = 0L;
        int j = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    j = a.g(paramParcel, m);
                    break;
                case 2:
                    l4 = a.i(paramParcel, m);
                    break;
                case 3:
                    l3 = a.i(paramParcel, m);
                    break;
                case 4:
                    l2 = a.i(paramParcel, m);
                    break;
                case 5:
                    l1 = a.i(paramParcel, m);
                    break;
                case 6:
                    i = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new StorageStats(j, l4, l3, l2, l1, i);
    }

    public StorageStats[] a(int paramInt) {
        return new StorageStats[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */