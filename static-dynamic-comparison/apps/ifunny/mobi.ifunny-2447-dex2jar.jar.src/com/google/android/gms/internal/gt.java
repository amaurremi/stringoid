package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class gt
        implements SafeParcelable {
    public static final my CREATOR = new my();
    public final int a;
    public String b;
    public int c;
    public int d;
    public boolean e;

    public gt(int paramInt1, int paramInt2, boolean paramBoolean) {
    }

    gt(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramString;
        this.c = paramInt2;
        this.d = paramInt3;
        this.e = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        my.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */