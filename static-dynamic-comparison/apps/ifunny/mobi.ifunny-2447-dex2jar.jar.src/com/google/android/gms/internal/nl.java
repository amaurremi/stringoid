package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class nl
        implements SafeParcelable {
    public static final rm CREATOR = new rm();
    public final int a;
    public final String b;
    public final int c;
    public final int d;
    public final String e;
    public final String f;
    public final boolean g;

    public nl(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramInt2;
        this.d = paramInt3;
        this.e = paramString2;
        this.f = paramString3;
        this.g = paramBoolean;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof nl)) {
                break;
            }
            paramObject = (nl) paramObject;
        }
        while ((this.b.equals(((nl) paramObject).b)) && (this.c == ((nl) paramObject).c) && (this.d == ((nl) paramObject).d) && (ad.a(this.e, ((nl) paramObject).e)) && (ad.a(this.f, ((nl) paramObject).f)) && (this.g == ((nl) paramObject).g));
        return false;
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, Integer.valueOf(this.c), Integer.valueOf(this.d), this.e, this.f, Boolean.valueOf(this.g)});
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PlayLoggerContext[");
        localStringBuilder.append("package=").append(this.b).append(',');
        localStringBuilder.append("versionCode=").append(this.a).append(',');
        localStringBuilder.append("logSource=").append(this.d).append(',');
        localStringBuilder.append("uploadAccount=").append(this.e).append(',');
        localStringBuilder.append("loggingId=").append(this.f).append(',');
        localStringBuilder.append("logAndroidId=").append(this.g);
        localStringBuilder.append("]");
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rm.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */