package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.a.b.g;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ny$d
        extends jj
        implements g {
    public static final se CREATOR = new se();
    private static final HashMap<String, ji.a<?, ?>> i = new HashMap();
    final Set<Integer> a;
    final int b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;

    static {
        i.put("familyName", ji.a.d("familyName", 2));
        i.put("formatted", ji.a.d("formatted", 3));
        i.put("givenName", ji.a.d("givenName", 4));
        i.put("honorificPrefix", ji.a.d("honorificPrefix", 5));
        i.put("honorificSuffix", ji.a.d("honorificSuffix", 6));
        i.put("middleName", ji.a.d("middleName", 7));
    }

    public ny$d() {
        this.b = 1;
        this.a = new HashSet();
    }

    ny$d(Set<Integer> paramSet, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
        this.a = paramSet;
        this.b = paramInt;
        this.c = paramString1;
        this.d = paramString2;
        this.e = paramString3;
        this.f = paramString4;
        this.g = paramString5;
        this.h = paramString6;
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
        }
        return this.h;
    }

    public HashMap<String, ji.a<?, ?>> b() {
        return i;
    }

    public int describeContents() {
        se localse = CREATOR;
        return 0;
    }

    public d e() {
        return this;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof d)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (d) paramObject;
        Iterator localIterator = i.values().iterator();
        while (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (a(locala)) {
                if (((d) paramObject).a(locala)) {
                    if (!b(locala).equals(((d) paramObject).b(locala))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (((d) paramObject).a(locala)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = i.values().iterator();
        int j = 0;
        if (localIterator.hasNext()) {
            ji.a locala = (ji.a) localIterator.next();
            if (!a(locala)) {
                break label68;
            }
            int k = locala.g();
            j = b(locala).hashCode() + (j + k);
        }
        label68:
        for (; ; ) {
            break;
            return j;
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        se localse = CREATOR;
        se.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ny$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */