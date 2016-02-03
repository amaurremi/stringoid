package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.a.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class nv
        extends jj
        implements b {
    public static final rv CREATOR = new rv();
    private static final HashMap<String, ji.a<?, ?>> h = new HashMap();
    final Set<Integer> a;
    final int b;
    String c;
    nt d;
    String e;
    nt f;
    String g;

    static {
        h.put("id", ji.a.d("id", 2));
        h.put("result", ji.a.a("result", 4, nt.class));
        h.put("startDate", ji.a.d("startDate", 5));
        h.put("target", ji.a.a("target", 6, nt.class));
        h.put("type", ji.a.d("type", 7));
    }

    public nv() {
        this.b = 1;
        this.a = new HashSet();
    }

    nv(Set<Integer> paramSet, int paramInt, String paramString1, nt paramnt1, String paramString2, nt paramnt2, String paramString3) {
        this.a = paramSet;
        this.b = paramInt;
        this.c = paramString1;
        this.d = paramnt1;
        this.e = paramString2;
        this.f = paramnt2;
        this.g = paramString3;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
            case 2:
                return this.c;
            case 4:
                return this.d;
            case 5:
                return this.e;
            case 6:
                return this.f;
        }
        return this.g;
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return h;
    }

    public int describeContents() {
        rv localrv = CREATOR;
        return 0;
    }

    public nv e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof nv)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (nv) paramObject;
        Iterator localIterator = h.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((nv) paramObject).a(locala)) {
                    if (!b(locala).equals(((nv) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((nv) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = h.values().iterator();
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
        rv localrv = CREATOR;
        rv.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */