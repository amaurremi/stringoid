package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;

public final class jm
        implements SafeParcelable {
    public static final Parcelable.Creator<jm> CREATOR = new jn();
    String add;
    String ade;
    ArrayList<jk> adf;
    private final int xH;

    jm() {
        this.xH = 1;
        this.adf = gi.fs();
    }

    jm(int paramInt, String paramString1, String paramString2, ArrayList<jk> paramArrayList) {
        this.xH = paramInt;
        this.add = paramString1;
        this.ade = paramString2;
        this.adf = paramArrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        jn.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */