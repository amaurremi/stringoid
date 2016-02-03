package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class cb
        implements SafeParcelable {
    public static final ca CREATOR = new ca();
    public final String mimeType;
    public final String nN;
    public final String nO;
    public final String nP;
    public final String nQ;
    public final String nR;
    public final String packageName;
    public final int versionCode;

    public cb(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this.versionCode = paramInt;
        this.nN = paramString1;
        this.nO = paramString2;
        this.mimeType = paramString3;
        this.packageName = paramString4;
        this.nP = paramString5;
        this.nQ = paramString6;
        this.nR = paramString7;
    }

    public cb(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ca.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */