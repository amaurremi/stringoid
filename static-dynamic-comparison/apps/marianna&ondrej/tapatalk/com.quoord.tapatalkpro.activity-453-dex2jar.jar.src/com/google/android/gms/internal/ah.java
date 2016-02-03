package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public final class ah
        implements SafeParcelable {
    public static final ai CREATOR = new ai();
    public final Bundle extras;
    public final long lH;
    public final int lI;
    public final List<String> lJ;
    public final boolean lK;
    public final int lL;
    public final boolean lM;
    public final String lN;
    public final av lO;
    public final Location lP;
    public final String lQ;
    public final int versionCode;

    public ah(int paramInt1, long paramLong, Bundle paramBundle, int paramInt2, List<String> paramList, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, av paramav, Location paramLocation, String paramString2) {
        this.versionCode = paramInt1;
        this.lH = paramLong;
        this.extras = paramBundle;
        this.lI = paramInt2;
        this.lJ = paramList;
        this.lK = paramBoolean1;
        this.lL = paramInt3;
        this.lM = paramBoolean2;
        this.lN = paramString1;
        this.lO = paramav;
        this.lP = paramLocation;
        this.lQ = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ai.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */