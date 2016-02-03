package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class hb
        implements Parcelable {
    @Deprecated
    public static final Parcelable.Creator<hb> CREATOR = new ns();
    private String a;
    private String b;
    private String c;

    @Deprecated
    public hb() {
    }

    @Deprecated
    hb(Parcel paramParcel) {
        a(paramParcel);
    }

    public hb(String paramString1, String paramString2, String paramString3) {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramString3;
    }

    @Deprecated
    private void a(Parcel paramParcel) {
        this.a = paramParcel.readString();
        this.b = paramParcel.readString();
        this.c = paramParcel.readString();
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeString(this.a);
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */