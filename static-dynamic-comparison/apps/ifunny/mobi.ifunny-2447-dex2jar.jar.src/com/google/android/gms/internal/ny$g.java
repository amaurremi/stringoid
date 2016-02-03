package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.i;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$g
        extends jj
        implements i {
    public static final sg CREATOR = new sg();
    private static final HashMap<String, ji.a<?, ?>> e = new HashMap();
    final Set<Integer> a;
    final int b;
    boolean c;
    String d;

    static {
        e.put("primary", ji.a.c("primary", 2));
        e.put("value", ji.a.d("value", 3));
    }

    public ny$g() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$g(Set<Integer> paramSet, int paramInt, boolean paramBoolean, String paramString) {
        this.a = paramSet;
        this.b = paramInt;
        this.c = paramBoolean;
        this.d = paramString;
    }

    protected boolean a(ji.a parama) {
        return this.a.contains(Integer.valueOf(parama.g()));
    }

    protected Object b(ji.a parama) {
        switch (parama.g()) {
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + parama.g());
            case 2:
                return Boolean.valueOf(this.c);
        }
        return this.d;
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return e;
    }

    public int describeContents() {
        sg localsg = CREATOR;
        return 0;
    }

    public g e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof g)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (g) paramObject;
        Iterator localIterator = e.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((g) paramObject).a(locala)) {
                    if (!b(locala).equals(((g) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((g) paramObject).a(locala)) {
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
        sg localsg = CREATOR;
        sg.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */