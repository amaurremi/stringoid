package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.IBinder;

import java.util.HashSet;

final class q {
    private final String b;
    private final r c;
    private final HashSet<e<?>.j> d;
    private int e;
    private boolean f;
    private IBinder g;
    private ComponentName h;

    public q(p paramp, String paramString) {
        this.b = paramString;
        this.c = new r(this);
        this.d = new HashSet();
        this.e = 0;
    }

    public r a() {
        return this.c;
    }

    public void a(e<?>.j parame) {
        this.d.add(parame);
    }

    public void a(boolean paramBoolean) {
        this.f = paramBoolean;
    }

    public String b() {
        return this.b;
    }

    public void b(e<?>.j parame) {
        this.d.remove(parame);
    }

    public boolean c() {
        return this.f;
    }

    public boolean c(e<?>.j parame) {
        return this.d.contains(parame);
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.d.isEmpty();
    }

    public IBinder f() {
        return this.g;
    }

    public ComponentName g() {
        return this.h;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */