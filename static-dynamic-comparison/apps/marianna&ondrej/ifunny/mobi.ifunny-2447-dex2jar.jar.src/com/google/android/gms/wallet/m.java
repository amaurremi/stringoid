package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class m
        implements Parcelable.Creator<NotifyTransactionStatusRequest> {
    static void a(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramNotifyTransactionStatusRequest.a);
        c.a(paramParcel, 2, paramNotifyTransactionStatusRequest.b, false);
        c.a(paramParcel, 3, paramNotifyTransactionStatusRequest.c);
        c.a(paramParcel, 4, paramNotifyTransactionStatusRequest.d, false);
        c.a(paramParcel, paramInt);
    }

    public NotifyTransactionStatusRequest a(Parcel paramParcel) {
        String str2 = null;
        int j = 0;
        int k = a.b(paramParcel);
        String str1 = null;
        int i = 0;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    str1 = a.o(paramParcel, m);
                    break;
                case 3:
                    j = a.g(paramParcel, m);
                    break;
                case 4:
                    str2 = a.o(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new NotifyTransactionStatusRequest(i, str1, j, str2);
    }

    public NotifyTransactionStatusRequest[] a(int paramInt) {
        return new NotifyTransactionStatusRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */