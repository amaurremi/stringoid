package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleAuthApiResponse
        implements SafeParcelable {
    public static final b CREATOR = new b();
    final int a;
    final int b;
    final Bundle c;
    final byte[] d;

    public GoogleAuthApiResponse(int paramInt1, int paramInt2, Bundle paramBundle, byte[] paramArrayOfByte) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramBundle;
        this.d = paramArrayOfByte;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/api/GoogleAuthApiResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */