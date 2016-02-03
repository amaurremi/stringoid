package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;

public final class RealTimeMessage
        implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new a();
    private final String a;
    private final byte[] b;
    private final int c;

    private RealTimeMessage(Parcel paramParcel) {
        this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
    }

    public RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt) {
        this.a = ((String) ag.a(paramString));
        this.b = ((byte[]) ((byte[]) ag.a(paramArrayOfByte)).clone());
        this.c = paramInt;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeByteArray(this.b);
        paramParcel.writeInt(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RealTimeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */