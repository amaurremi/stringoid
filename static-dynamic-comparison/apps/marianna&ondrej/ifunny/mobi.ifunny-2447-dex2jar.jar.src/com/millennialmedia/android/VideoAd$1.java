package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoAd$1
        implements Parcelable.Creator<VideoAd> {
    public VideoAd createFromParcel(Parcel paramParcel) {
        return new VideoAd(paramParcel);
    }

    public VideoAd[] newArray(int paramInt) {
        return new VideoAd[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoAd$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */