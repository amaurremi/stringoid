package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UnclaimBleDeviceRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new f();
    private final int a;
    private final String b;

    UnclaimBleDeviceRequest(int paramInt, String paramString) {
        this.a = paramInt;
        this.b = paramString;
    }

    public String a() {
        return this.b;
    }

    int b() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/UnclaimBleDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */