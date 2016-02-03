package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.h;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$f
        extends jj
        implements h {
    public static final sf CREATOR = new sf();
    private static final HashMap<String, ji.a<?, ?>> l = new HashMap();
    final Set<Integer> a;
    final int b;
    String c;
    String d;
    String e;
    String f;
    String g;
    boolean h;
    String i;
    String j;
    int k;

    static {
        l.put("department", ji.a.d("department", 2));
        l.put("description", ji.a.d("description", 3));
        l.put("endDate", ji.a.d("endDate", 4));
        l.put("location", ji.a.d("location", 5));
        l.put("name", ji.a.d("name", 6));
        l.put("primary", ji.a.c("primary", 7));
        l.put("startDate", ji.a.d("startDate", 8));
        l.put("title", ji.a.d("title", 9));
        l.put("type", ji.a.a("type", 10, new jf().a("work", 0).a("school", 1), false));
    }

    public ny$f() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$f(Set<Integer> paramSet, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, String paramString6, String paramString7, int paramInt2) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = paramString1;
        this.d = paramString2;
        this.e = paramString3;
        this.f = paramString4;
        this.g = paramString5;
        this.h = paramBoolean;
        this.i = paramString6;
        this.j = paramString7;
        this.k = paramInt2;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return Boolean.valueOf(this.h);
            case 8:
                return this.i;
            case 9:
                return this.j;
        }
        return Integer.valueOf(this.k);
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return l;
    }

    public int describeContents() {
        sf localsf = CREATOR;
        return 0;
    }

    public f e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof f)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (f) paramObject;
        Iterator localIterator = l.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((f) paramObject).a(locala)) {
                    if (!b(locala).equals(((f) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((f) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = l.values().iterator();
        int m = 0;
        if (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (!a(locala)) {
                break label68;
            }
            int n = locala.g();
            m = b(locala).hashCode() + (m + n);
        }
        label68:
        for (; ; ) {
            break;
            return m;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        sf localsf = CREATOR;
        sf.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */