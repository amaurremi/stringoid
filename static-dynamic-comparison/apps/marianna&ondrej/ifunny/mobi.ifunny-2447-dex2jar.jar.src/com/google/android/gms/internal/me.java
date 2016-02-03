package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

public class me
        implements SafeParcelable {
    public static final rb CREATOR = new rb();
    final int a;
    private final boolean b;
    private final List<mo> c;

    me(int paramInt, boolean paramBoolean, List<mo> paramList) {
        this.a = paramInt;
        this.b = paramBoolean;
        this.c = paramList;
    }

    public boolean a() {
        return this.b;
    }

    public List<mo> b() {
        return this.c;
    }

    public int describeContents() {
        rb localrb = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rb localrb = CREATOR;
        rb.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/me.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */