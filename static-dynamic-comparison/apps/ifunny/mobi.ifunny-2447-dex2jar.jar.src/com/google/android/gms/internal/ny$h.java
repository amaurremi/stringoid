package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.j;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$h
        extends jj
        implements j {
    public static final sh CREATOR = new sh();
    private static final HashMap<String, ji.a<?, ?>> f = new HashMap();
    final Set<Integer> a;
    final int b;
    String c;
    int d;
    String e;
    private final int g = 4;

    static {
        f.put("label", ji.a.d("label", 5));
        f.put("type", ji.a.a("type", 6, new jf().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4).a("otherProfile", 5).a("contributor", 6).a("website", 7), false));
        f.put("value", ji.a.d("value", 4));
    }

    public ny$h() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$h(Set<Integer> paramSet, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = paramString1;
        this.d = paramInt2;
        this.e = paramString2;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
            case 5:
                return this.c;
            case 6:
                return Integer.valueOf(this.d);
        }
        return this.e;
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return f;
    }

    public int describeContents() {
        sh localsh = CREATOR;
        return 0;
    }

    @Deprecated
    public int e() {
        return 4;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof h)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (h) paramObject;
        Iterator localIterator = f.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((h) paramObject).a(locala)) {
                    if (!b(locala).equals(((h) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((h) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public h f() {
        return this;
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
        sh localsh = CREATOR;
        sh.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */