package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class x
        implements SafeParcelable {
    public static final to CREATOR = new to();
    public final int a;
    public final boolean b;
    public final boolean c;

    x(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
        this.a = paramInt;
        this.b = paramBoolean1;
        this.c = paramBoolean2;
    }

    public x(boolean paramBoolean1, boolean paramBoolean2) {
        this.a = 1;
        this.b = paramBoolean1;
        this.c = paramBoolean2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        to.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */