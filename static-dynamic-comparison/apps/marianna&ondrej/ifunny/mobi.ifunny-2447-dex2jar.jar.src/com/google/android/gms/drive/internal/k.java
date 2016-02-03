package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class k
        implements Parcelable.Creator<OnListEntriesResponse> {
    static void a(OnListEntriesResponse paramOnListEntriesResponse, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnListEntriesResponse.a);
        c.a(paramParcel, 2, paramOnListEntriesResponse.b, paramInt, false);
        c.a(paramParcel, 3, paramOnListEntriesResponse.c);
        c.a(paramParcel, i);
    }

    public OnListEntriesResponse a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        DataHolder localDataHolder = null;
        int i = 0;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                i = a.g(paramParcel, k);
                continue;
                localDataHolder = (DataHolder) a.a(paramParcel, k, DataHolder.CREATOR);
                continue;
                bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnListEntriesResponse(i, localDataHolder, bool);
    }

    public OnListEntriesResponse[] a(int paramInt) {
        return new OnListEntriesResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */