package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.internal.ag;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class f<T>
        implements a<T> {
    private final String a;
    private final Set<String> b;
    private final Set<String> c;
    private final int d;

    protected f(String paramString, int paramInt) {
        this.a = ((String) ag.a(paramString, "fieldName"));
        this.b = Collections.singleton(paramString);
        this.c = Collections.emptySet();
        this.d = paramInt;
    }

    protected f(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt) {
        this.a = ((String) ag.a(paramString, "fieldName"));
        this.b = Collections.unmodifiableSet(new HashSet(paramCollection1));
        this.c = Collections.unmodifiableSet(new HashSet(paramCollection2));
        this.d = paramInt;
    }

    public final T a(Bundle paramBundle) {
        ag.a(paramBundle, "bundle");
        if (paramBundle.get(a()) != null) {
            return (T) b(paramBundle);
        }
        return null;
    }

    public final String a() {
        return this.a;
    }

    protected abstract T b(Bundle paramBundle);

    public String toString() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */