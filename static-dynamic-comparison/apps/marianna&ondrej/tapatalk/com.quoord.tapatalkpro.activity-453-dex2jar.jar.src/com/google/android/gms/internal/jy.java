package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class jy
        implements SafeParcelable {
    public static final Parcelable.Creator<jy> CREATOR = new jz();
    String adn;
    ju adr;
    jw ads;
    jw adt;
    String pm;
    private final int xH;

    jy() {
        this.xH = 1;
    }

    jy(int paramInt, String paramString1, String paramString2, ju paramju, jw paramjw1, jw paramjw2) {
        this.xH = paramInt;
        this.adn = paramString1;
        this.pm = paramString2;
        this.adr = paramju;
        this.ads = paramjw1;
        this.adt = paramjw2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        jz.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */