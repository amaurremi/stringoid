package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class x
        implements SafeParcelable {
    public static final Parcelable.Creator<x> CREATOR = new aj();
    private final int a;
    private final String b;
    private final String c;

    x(int paramInt, String paramString1, String paramString2) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
    }

    private boolean a(x paramx) {
        return (ad.a(this.b, paramx.b)) && (ad.a(this.c, paramx.c));
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (paramObject == this) || (((paramObject instanceof x)) && (a((x) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("name", this.b).a("identifier", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        aj.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */