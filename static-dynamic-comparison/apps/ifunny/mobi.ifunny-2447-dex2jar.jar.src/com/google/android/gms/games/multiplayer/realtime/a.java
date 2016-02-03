package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
        implements Parcelable.Creator<RealTimeMessage> {
    public RealTimeMessage a(Parcel paramParcel) {
        return new RealTimeMessage(paramParcel, null);
    }

    public RealTimeMessage[] a(int paramInt) {
        return new RealTimeMessage[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */