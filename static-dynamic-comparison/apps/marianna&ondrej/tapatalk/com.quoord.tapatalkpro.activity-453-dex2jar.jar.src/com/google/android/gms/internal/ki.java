package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.e;

public class ki
        implements SafeParcelable, e {
    public static final Parcelable.Creator<ki> CREATOR = new kj();
    private final int Eu;
    private final byte[] Nf;
    private final String adF;
    private final String adG;
    final int xH;

    ki(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2) {
        this.xH = paramInt1;
        this.Eu = paramInt2;
        this.adF = paramString1;
        this.Nf = paramArrayOfByte;
        this.adG = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public int fA() {
        return this.Eu;
    }

    public byte[] getData() {
        return this.Nf;
    }

    public String getPath() {
        return this.adF;
    }

    public String getSource() {
        return this.adG;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.Eu).append(",").append(this.adF);
        if (this.Nf == null) {
        }
        for (Object localObject = "null"; ; localObject = Integer.valueOf(this.Nf.length)) {
            return localObject + "]";
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        kj.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */