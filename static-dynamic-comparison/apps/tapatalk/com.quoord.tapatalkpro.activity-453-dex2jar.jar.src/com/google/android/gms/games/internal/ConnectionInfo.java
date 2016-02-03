package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
        implements SafeParcelable {
    public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
    private final String Is;
    private final int It;
    private final int xH;

    public ConnectionInfo(int paramInt1, String paramString, int paramInt2) {
        this.xH = paramInt1;
        this.Is = paramString;
        this.It = paramInt2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public String gi() {
        return this.Is;
    }

    public int gj() {
        return this.It;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ConnectionInfoCreator.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */