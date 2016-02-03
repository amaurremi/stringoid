package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class VideoLogEvent$1
        implements Parcelable.Creator<VideoLogEvent> {
    public VideoLogEvent createFromParcel(Parcel paramParcel) {
        return new VideoLogEvent(paramParcel);
    }

    public VideoLogEvent[] newArray(int paramInt) {
        return new VideoLogEvent[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/VideoLogEvent$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */