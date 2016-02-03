package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.f;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$c
        extends jj
        implements f {
    public static final sd CREATOR = new sd();
    private static final HashMap<String, ji.a<?, ?>> d = new HashMap();
    final Set<Integer> a;
    final int b;
    String c;

    static {
        d.put("url", ji.a.d("url", 2));
    }

    public ny$c() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$c(Set<Integer> paramSet, int paramInt, String paramString) {
        this.a = paramSet;
        this.b = paramInt;
        this.c = paramString;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
        }
        return this.c;
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return d;
    }

    public int describeContents() {
        sd localsd = CREATOR;
        return 0;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof c)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (c) paramObject;
        Iterator localIterator = d.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((c) paramObject).a(locala)) {
                    if (!b(locala).equals(((c) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((c) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public c f() {
        return this;
    }

    public int hashCode() {
        Iterator localIterator = d.values().iterator();
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
        sd localsd = CREATOR;
        sd.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */