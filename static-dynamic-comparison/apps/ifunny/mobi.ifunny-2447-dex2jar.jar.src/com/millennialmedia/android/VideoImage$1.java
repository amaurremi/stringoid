package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoImage$1
        implements Parcelable.Creator<VideoImage> {
    public VideoImage createFromParcel(Parcel paramParcel) {
        return new VideoImage(paramParcel);
    }

    public VideoImage[] newArray(int paramInt) {
        return new VideoImage[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoImage$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */