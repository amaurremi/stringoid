package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
        implements SafeParcelable {
    public static final a CREATOR = new a();
    private final int a;
    private final String b;
    private final int c;

    public ConnectionInfo(int paramInt1, String paramString, int paramInt2) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */