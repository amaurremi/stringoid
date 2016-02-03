package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.b.a;

import java.util.Date;
import java.util.Set;

@ii
public final class ed
        implements a {
    private final Date a;
    private final int b;
    private final Set<String> c;
    private final boolean d;
    private final Location e;
    private final int f;

    public ed(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean, int paramInt2) {
        this.a = paramDate;
        this.b = paramInt1;
        this.c = paramSet;
        this.e = paramLocation;
        this.d = paramBoolean;
        this.f = paramInt2;
    }

    public Date a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public Set<String> c() {
        return this.c;
    }

    public Location d() {
        return this.e;
    }

    public boolean e() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */