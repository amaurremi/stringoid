package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class q
        implements Parcelable.Creator<OnSyncMoreResponse> {
    static void a(OnSyncMoreResponse paramOnSyncMoreResponse, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnSyncMoreResponse.a);
        c.a(paramParcel, 2, paramOnSyncMoreResponse.b);
        c.a(paramParcel, paramInt);
    }

    public OnSyncMoreResponse a(Parcel paramParcel) {
        boolean bool = false;
        int j = a.b(paramParcel);
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnSyncMoreResponse(i, bool);
    }

    public OnSyncMoreResponse[] a(int paramInt) {
        return new OnSyncMoreResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */