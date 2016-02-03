package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.e;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$b$b
        extends jj
        implements e {
    public static final sc CREATOR = new sc();
    private static final HashMap<String, ji.a<?, ?>> f = new HashMap();
    final Set<Integer> a;
    final int b;
    int c;
    String d;
    int e;

    static {
        f.put("height", ji.a.a("height", 2));
        f.put("url", ji.a.d("url", 3));
        f.put("width", ji.a.a("width", 4));
    }

    public ny$b$b() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$b$b(Set<Integer> paramSet, int paramInt1, int paramInt2, String paramString, int paramInt3) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = paramInt2;
        this.d = paramString;
        this.e = paramInt3;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
            case 2:
                return Integer.valueOf(this.c);
            case 3:
                return this.d;
        }
        return Integer.valueOf(this.e);
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return f;
    }

    public int describeContents() {
        sc localsc = CREATOR;
        return 0;
    }

    public b e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof b)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (b) paramObject;
        Iterator localIterator = f.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((b) paramObject).a(locala)) {
                    if (!b(locala).equals(((b) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((b) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = f.values().iterator();
        int i = 0;
        if (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (!a(locala)) {
                break label68;
            }
            int j = locala.g();
            i = b(locala).hashCode() + (i + j);
        }
        label68:
        for (; ; ) {
            break;
            return i;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        sc localsc = CREATOR;
        sc.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$b$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */