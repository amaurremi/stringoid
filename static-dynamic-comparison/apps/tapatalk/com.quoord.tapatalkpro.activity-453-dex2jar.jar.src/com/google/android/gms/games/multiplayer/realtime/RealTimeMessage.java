package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.fq;

public final class RealTimeMessage
        implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator() {
        public RealTimeMessage aw(Parcel paramAnonymousParcel) {
            return new RealTimeMessage(paramAnonymousParcel, null);
        }

        public RealTimeMessage[] bp(int paramAnonymousInt) {
            return new RealTimeMessage[paramAnonymousInt];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String MH;
    private final byte[] MI;
    private final int MJ;

    private RealTimeMessage(Parcel paramParcel) {
        this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
    }

    public RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt) {
        this.MH = ((String) fq.f(paramString));
        this.MI = ((byte[]) ((byte[]) fq.f(paramArrayOfByte)).clone());
        this.MJ = paramInt;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.MI;
    }

    public String getSenderParticipantId() {
        return this.MH;
    }

    public boolean isReliable() {
        return this.MJ == 1;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.MH);
        paramParcel.writeByteArray(this.MI);
        paramParcel.writeInt(this.MJ);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RealTimeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */