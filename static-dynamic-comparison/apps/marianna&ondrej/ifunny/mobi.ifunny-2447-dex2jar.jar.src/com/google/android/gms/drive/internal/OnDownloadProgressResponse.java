package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse
        implements SafeParcelable {
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new g();
    final int a;
    final long b;
    final long c;

    OnDownloadProgressResponse(int paramInt, long paramLong1, long paramLong2) {
        this.a = paramInt;
        this.b = paramLong1;
        this.c = paramLong2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/OnDownloadProgressResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */