package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class HttpMMHeaders$1
        implements Parcelable.Creator<HttpMMHeaders> {
    public HttpMMHeaders createFromParcel(Parcel paramParcel) {
        return new HttpMMHeaders(paramParcel);
    }

    public HttpMMHeaders[] newArray(int paramInt) {
        return new HttpMMHeaders[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HttpMMHeaders$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */