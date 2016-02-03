package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.HashMap;

public class ji$a<I, O>
        implements SafeParcelable {
    public static final pi CREATOR = new pi();
    protected final int a;
    protected final boolean b;
    protected final int c;
    protected final boolean d;
    protected final String e;
    protected final int f;
    protected final Class<? extends ji> g;
    protected final String h;
    private final int i;
    private jm j;
    private ph<I, O> k;

    ji$a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, jd paramjd) {
        this.i = paramInt1;
        this.a = paramInt2;
        this.b = paramBoolean1;
        this.c = paramInt3;
        this.d = paramBoolean2;
        this.e = paramString1;
        this.f = paramInt4;
        if (paramString2 == null) {
            this.g = null;
        }
        for (this.h = null; paramjd == null; this.h = paramString2) {
            this.k = null;
            return;
            this.g = jp.class;
        }
        this.k = paramjd.c();
    }

    protected ji$a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends ji> paramClass, ph<I, O> paramph) {
        this.i = 1;
        this.a = paramInt1;
        this.b = paramBoolean1;
        this.c = paramInt2;
        this.d = paramBoolean2;
        this.e = paramString;
        this.f = paramInt3;
        this.g = paramClass;
        if (paramClass == null) {
        }
        for (this.h = null; ; this.h = paramClass.getCanonicalName()) {
            this.k = paramph;
            return;
        }
    }

    public static a<Integer, Integer> a(String paramString, int paramInt) {
        return new a(0, false, 0, false, paramString, paramInt, null, null);
    }

    public static a a(String paramString, int paramInt, ph<?, ?> paramph, boolean paramBoolean) {
        return new a(paramph.c(), paramBoolean, paramph.d(), false, paramString, paramInt, null, paramph);
    }

    public static <T extends ji> a<T, T> a(String paramString, int paramInt, Class<T> paramClass) {
        return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
    }

    public static a<Double, Double> b(String paramString, int paramInt) {
        return new a(4, false, 4, false, paramString, paramInt, null, null);
    }

    public static <T extends ji> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass) {
        return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
    }

    public static a<Boolean, Boolean> c(String paramString, int paramInt) {
        return new a(6, false, 6, false, paramString, paramInt, null, null);
    }

    public static a<String, String> d(String paramString, int paramInt) {
        return new a(7, false, 7, false, paramString, paramInt, null, null);
    }

    public static a<ArrayList<String>, ArrayList<String>> e(String paramString, int paramInt) {
        return new a(7, true, 7, true, paramString, paramInt, null, null);
    }

    public int a() {
        return this.i;
    }

    public I a(O paramO) {
        return (I) this.k.a(paramO);
    }

    public void a(jm paramjm) {
        this.j = paramjm;
    }

    public int b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public int describeContents() {
        pi localpi = CREATOR;
        return 0;
    }

    public boolean e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public Class<? extends ji> h() {
        return this.g;
    }

    String i() {
        if (this.h == null) {
            return null;
        }
        return this.h;
    }

    public boolean j() {
        return this.k != null;
    }

    jd k() {
        if (this.k == null) {
            return null;
        }
        return jd.a(this.k);
    }

    public HashMap<String, a<?, ?>> l() {
        ag.a(this.h);
        ag.a(this.j);
        return this.j.a(this.h);
    }

    public String toString() {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Field\n");
        localStringBuilder1.append("            versionCode=").append(this.i).append('\n');
        localStringBuilder1.append("                 typeIn=").append(this.a).append('\n');
        localStringBuilder1.append("            typeInArray=").append(this.b).append('\n');
        localStringBuilder1.append("                typeOut=").append(this.c).append('\n');
        localStringBuilder1.append("           typeOutArray=").append(this.d).append('\n');
        localStringBuilder1.append("        outputFieldName=").append(this.e).append('\n');
        localStringBuilder1.append("      safeParcelFieldId=").append(this.f).append('\n');
        localStringBuilder1.append("       concreteTypeName=").append(i()).append('\n');
        if (h() != null) {
            localStringBuilder1.append("     concreteType.class=").append(h().getCanonicalName()).append('\n');
        }
        StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
        if (this.k == null) {
        }
        for (String str = "null"; ; str = this.k.getClass().getCanonicalName()) {
            localStringBuilder2.append(str).append('\n');
            return localStringBuilder1.toString();
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        pi localpi = CREATOR;
        pi.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ji$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */