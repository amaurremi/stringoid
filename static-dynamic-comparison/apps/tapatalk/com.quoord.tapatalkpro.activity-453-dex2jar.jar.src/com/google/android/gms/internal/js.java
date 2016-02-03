package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class js
        implements SafeParcelable {
    public static final Parcelable.Creator<js> CREATOR = new jt();
    String adn;
    String pm;
    private final int xH;

    js() {
        this.xH = 1;
    }

    js(int paramInt, String paramString1, String paramString2) {
        this.xH = paramInt;
        this.adn = paramString1;
        this.pm = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        jt.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/js.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */