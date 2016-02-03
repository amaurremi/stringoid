package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c
        implements SafeParcelable {
    public static final Parcelable.Creator<c> CREATOR = new e();
    final int a;
    private final String b;
    private final String c;
    private final int d;
    private final int e;
    private final boolean f;
    private boolean g;
    private String h;

    c(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, String paramString3) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramInt2;
        this.e = paramInt3;
        this.f = paramBoolean1;
        this.g = paramBoolean2;
        this.h = paramString3;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.g;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof c)) {
        }
        do {
            return false;
            paramObject = (c) paramObject;
        }
        while ((!ad.a(Integer.valueOf(this.a), Integer.valueOf(((c) paramObject).a))) || (!ad.a(this.b, ((c) paramObject).b)) || (!ad.a(this.c, ((c) paramObject).c)) || (!ad.a(Integer.valueOf(this.d), Integer.valueOf(((c) paramObject).d))) || (!ad.a(Integer.valueOf(this.e), Integer.valueOf(((c) paramObject).e))) || (!ad.a(Boolean.valueOf(this.f), Boolean.valueOf(((c) paramObject).f))));
        return true;
    }

    public String f() {
        return this.h;
    }

    public boolean g() {
        return this.f;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.a), this.b, this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), Boolean.valueOf(this.f)});
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        localStringBuilder.append("mName=" + this.b);
        localStringBuilder.append(", mAddress=" + this.c);
        localStringBuilder.append(", mType=" + this.d);
        localStringBuilder.append(", mRole=" + this.e);
        localStringBuilder.append(", mEnabled=" + this.f);
        localStringBuilder.append(", mIsConnected=" + this.g);
        localStringBuilder.append(", mEnabled=" + this.h);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */