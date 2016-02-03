package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.d;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$b$a
        extends jj
        implements d {
    public static final sb CREATOR = new sb();
    private static final HashMap<String, ji.a<?, ?>> e = new HashMap();
    final Set<Integer> a;
    final int b;
    int c;
    int d;

    static {
        e.put("leftImageOffset", ji.a.a("leftImageOffset", 2));
        e.put("topImageOffset", ji.a.a("topImageOffset", 3));
    }

    public ny$b$a() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$b$a(Set<Integer> paramSet, int paramInt1, int paramInt2, int paramInt3) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = paramInt2;
        this.d = paramInt3;
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
        }
        return Integer.valueOf(this.d);
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return e;
    }

    public int describeContents() {
        sb localsb = CREATOR;
        return 0;
    }

    public a e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof a)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (a) paramObject;
        Iterator localIterator = e.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((a) paramObject).a(locala)) {
                    if (!b(locala).equals(((a) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((a) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = e.values().iterator();
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
        sb localsb = CREATOR;
        sb.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */