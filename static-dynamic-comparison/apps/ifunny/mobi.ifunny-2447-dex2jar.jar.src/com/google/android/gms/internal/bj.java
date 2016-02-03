package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.ads.d.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ii
public final class bj
        implements SafeParcelable {
    public static final bq CREATOR = new bq();
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final int k;
    public final String l;
    public final int m;
    public final int n;
    public final String o;

    bj(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, int paramInt10, String paramString2, int paramInt11, int paramInt12, String paramString3) {
        this.a = paramInt1;
        this.b = paramInt2;
        this.c = paramInt3;
        this.d = paramInt4;
        this.e = paramInt5;
        this.f = paramInt6;
        this.g = paramInt7;
        this.h = paramInt8;
        this.i = paramInt9;
        this.j = paramString1;
        this.k = paramInt10;
        this.l = paramString2;
        this.m = paramInt11;
        this.n = paramInt12;
        this.o = paramString3;
    }

    public bj(a parama) {
        this.a = 1;
        this.b = parama.a();
        this.c = parama.b();
        this.d = parama.c();
        this.e = parama.d();
        this.f = parama.e();
        this.g = parama.f();
        this.h = parama.g();
        this.i = parama.h();
        this.j = parama.i();
        this.k = parama.j();
        this.l = parama.k();
        this.m = parama.l();
        this.n = parama.m();
        this.o = parama.n();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        bq.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */