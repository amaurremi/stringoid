package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ix
        implements SafeParcelable {
    public static final Parcelable.Creator<ix> CREATOR = new iy();
    String[] act;
    byte[][] acu;
    private final int xH;

    ix() {
        this(1, new String[0], new byte[0][]);
    }

    ix(int paramInt, String[] paramArrayOfString, byte[][] paramArrayOfByte) {
        this.xH = paramInt;
        this.act = paramArrayOfString;
        this.acu = paramArrayOfByte;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        iy.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */