package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class dj
        implements SafeParcelable {
    public static final fh CREATOR = new fh();
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;

    public dj(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramString4;
        this.f = paramString5;
        this.g = paramString6;
        this.h = paramString7;
    }

    public dj(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
        this(1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        fh.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */