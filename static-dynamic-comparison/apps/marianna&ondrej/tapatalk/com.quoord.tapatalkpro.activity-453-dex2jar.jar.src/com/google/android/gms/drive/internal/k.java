package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class k
        implements Parcelable.Creator<DisconnectRequest> {
    static void a(DisconnectRequest paramDisconnectRequest, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramDisconnectRequest.xH);
        b.F(paramParcel, paramInt);
    }

    public DisconnectRequest K(Parcel paramParcel) {
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
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new DisconnectRequest(i);
    }

    public DisconnectRequest[] ao(int paramInt) {
        return new DisconnectRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */