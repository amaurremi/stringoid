package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class m
        implements Parcelable.Creator<NotifyTransactionStatusRequest> {
    static void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.c(paramParcel, 1, paramNotifyTransactionStatusRequest.xH);
        b.a(paramParcel, 2, paramNotifyTransactionStatusRequest.abh, false);
        b.c(paramParcel, 3, paramNotifyTransactionStatusRequest.status);
        b.a(paramParcel, 4, paramNotifyTransactionStatusRequest.ach, false);
        b.F(paramParcel, paramInt);
    }

    public NotifyTransactionStatusRequest bi(Parcel paramParcel) {
        String str2 = null;
        int j = 0;
        int k = a.o(paramParcel);
        String str1 = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.n(paramParcel);
            switch (a.R(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str1 = a.n(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
                    break;
                case 4:
                    str2 = a.n(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new a.a("Overread allowed size end=" + k, paramParcel);
        }
        return new NotifyTransactionStatusRequest(i, str1, j, str2);
    }

    public NotifyTransactionStatusRequest[] cu(int paramInt) {
        return new NotifyTransactionStatusRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/wallet/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */