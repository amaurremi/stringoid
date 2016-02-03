package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.qt;

public final class a
        implements SafeParcelable {
    public static final Parcelable.Creator<a> CREATOR = new b();
    public static final a a = new a("com.google.android.gms", String.valueOf(6111000), null);
    private final int b;
    private final String c;
    private final String d;
    private final String e;

    a(int paramInt, String paramString1, String paramString2, String paramString3) {
        this.b = paramInt;
        this.c = ((String) ag.a(paramString1));
        this.d = "";
        this.e = paramString3;
    }

    public a(String paramString1, String paramString2, String paramString3) {
        this(1, paramString1, "", paramString3);
    }

    private boolean a(a parama) {
        return (this.c.equals(parama.c)) && (ad.a(this.d, parama.d)) && (ad.a(this.e, parama.e));
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    a d() {
        return new a(qt.a(this.c), qt.a(this.d), qt.a(this.e));
    }

    public int describeContents() {
        return 0;
    }

    int e() {
        return this.b;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof a)) && (a((a) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.d, this.e});
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", new Object[]{this.c, this.d, this.e});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/data/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */