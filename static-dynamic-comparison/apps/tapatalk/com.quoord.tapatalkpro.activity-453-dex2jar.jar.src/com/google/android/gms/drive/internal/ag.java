package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ag
        implements Parcelable.Creator<OnSyncMoreResponse> {
    static void a(OnSyncMoreResponse paramOnSyncMoreResponse, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramOnSyncMoreResponse.xH);
        b.a(paramParcel, 2, paramOnSyncMoreResponse.Fg);
        b.F(paramParcel, paramInt);
    }

    public OnSyncMoreResponse U(Parcel paramParcel) {
        boolean bool = false;
        int j = a.o(paramParcel);
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
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
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new OnSyncMoreResponse(i, bool);
    }

    public OnSyncMoreResponse[] ay(int paramInt) {
        return new OnSyncMoreResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */