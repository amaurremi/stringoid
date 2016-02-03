package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class InterstitialAd$1
        implements Parcelable.Creator<InterstitialAd> {
    public InterstitialAd createFromParcel(Parcel paramParcel) {
        return new InterstitialAd(paramParcel);
    }

    public InterstitialAd[] newArray(int paramInt) {
        return new InterstitialAd[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/InterstitialAd$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */