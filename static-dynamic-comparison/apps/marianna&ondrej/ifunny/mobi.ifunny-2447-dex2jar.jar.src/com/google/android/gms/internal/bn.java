package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.b.a.a;
import com.google.android.gms.ads.b.b;
import com.google.android.gms.ads.b.g;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public final class bn {
    private final HashSet<String> a = new HashSet();
    private final Bundle b = new Bundle();
    private final HashMap<Class<? extends g>, g> c = new HashMap();
    private final HashSet<String> d = new HashSet();
    private Date e;
    private String f;
    private int g = -1;
    private Location h;
    private boolean i = false;
    private String j;
    private int k = -1;

    public void a(int paramInt) {
        this.g = paramInt;
    }

    public void a(Location paramLocation) {
        this.h = paramLocation;
    }

    @Deprecated
    public void a(g paramg) {
        if ((paramg instanceof a)) {
            a(AdMobAdapter.class, ((a) paramg).a());
            return;
        }
        this.c.put(paramg.getClass(), paramg);
    }

    public void a(Class<? extends b> paramClass, Bundle paramBundle) {
        this.b.putBundle(paramClass.getName(), paramBundle);
    }

    public void a(String paramString) {
        this.a.add(paramString);
    }

    public void a(Date paramDate) {
        this.e = paramDate;
    }

    public void a(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int m = 1; ; m = 0) {
            this.k = m;
            return;
        }
    }

    public void b(String paramString) {
        this.d.add(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */