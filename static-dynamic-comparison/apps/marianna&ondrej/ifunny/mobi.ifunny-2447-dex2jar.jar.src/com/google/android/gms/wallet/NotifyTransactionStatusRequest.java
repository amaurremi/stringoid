package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class NotifyTransactionStatusRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<NotifyTransactionStatusRequest> CREATOR = new m();
    final int a;
    String b;
    int c;
    String d;

    NotifyTransactionStatusRequest() {
        this.a = 1;
    }

    NotifyTransactionStatusRequest(int paramInt1, String paramString1, int paramInt2, String paramString2) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramInt2;
        this.d = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        m.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wallet/NotifyTransactionStatusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */