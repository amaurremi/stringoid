package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ig
        implements SafeParcelable {
    public static final Parcelable.Creator<ig> CREATOR = new on();
    private final int a;
    private String b;

    public ig() {
        this(1, null);
    }

    ig(int paramInt, String paramString) {
        this.a = paramInt;
        this.b = paramString;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
            return true;
        }
        if (!(paramObject instanceof ig)) {
            return false;
        }
        paramObject = (ig) paramObject;
        return op.a(this.b, ((ig) paramObject).b);
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        on.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */