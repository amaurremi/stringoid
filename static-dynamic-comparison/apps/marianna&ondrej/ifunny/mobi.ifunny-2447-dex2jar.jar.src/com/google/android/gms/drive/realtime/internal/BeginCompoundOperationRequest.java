package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new a();
    final int a;
    final boolean b;
    final String c;
    final boolean d;

    BeginCompoundOperationRequest(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2) {
        this.a = paramInt;
        this.b = paramBoolean1;
        this.c = paramString;
        this.d = paramBoolean2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/BeginCompoundOperationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */