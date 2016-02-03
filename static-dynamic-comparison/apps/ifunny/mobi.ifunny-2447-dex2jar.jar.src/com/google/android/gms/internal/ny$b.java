package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.c;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$b
        extends jj
        implements c {
    public static final sa CREATOR = new sa();
    private static final HashMap<String, ji.a<?, ?>> f = new HashMap();
    final Set<Integer> a;
    final int b;
    ny.b.a c;
    ny.b.b d;
    int e;

    static {
        f.put("coverInfo", ji.a.a("coverInfo", 2, ny.b.a.class));
        f.put("coverPhoto", ji.a.a("coverPhoto", 3, ny.b.b.class));
        f.put("layout", ji.a.a("layout", 4, new jf().a("banner", 0), false));
    }

    public ny$b() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$b(Set<Integer> paramSet, int paramInt1, ny.b.a parama, ny.b.b paramb, int paramInt2) {
        this.a = paramSet;
        this.b = paramInt1;
        this.c = parama;
        this.d = paramb;
        this.e = paramInt2;
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
        }
        return Integer.valueOf(this.e);
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return f;
    }

    public int describeContents() {
        sa localsa = CREATOR;
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
        sa localsa = CREATOR;
        sa.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */