package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

@ii
public class jk
        implements Runnable {
    protected final mz a;
    protected boolean b;
    protected boolean c;
    private final Handler d;
    private final long e;
    private long f;
    private nd g;
    private final int h;
    private final int i;

    public jk(nd paramnd, mz parammz, int paramInt1, int paramInt2) {
        this(paramnd, parammz, paramInt1, paramInt2, 200L, 50L);
    }

    public jk(nd paramnd, mz parammz, int paramInt1, int paramInt2, long paramLong1, long paramLong2) {
        this.e = paramLong1;
        this.f = paramLong2;
        this.d = new Handler(Looper.getMainLooper());
        this.a = parammz;
        this.g = paramnd;
        this.b = false;
        this.c = false;
        this.h = paramInt2;
        this.i = paramInt1;
    }

    public void a() {
        this.d.postDelayed(this, this.e);
    }

    public void a(fk paramfk) {
        a(paramfk, new nr(this, this.a, paramfk.q));
    }

    public void a(fk paramfk, nr paramnr) {
        this.a.setWebViewClient(paramnr);
        mz localmz = this.a;
        if (TextUtils.isEmpty(paramfk.b)) {
        }
        for (paramnr = null; ; paramnr = lw.a(paramfk.b)) {
            localmz.loadDataWithBaseURL(paramnr, paramfk.c, "text/html", "UTF-8", null);
            return;
        }
    }

    public void b() {
        try {
            this.b = true;
            return;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean c() {
        try {
            boolean bool = this.b;
            return bool;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public boolean d() {
        return this.c;
    }

    public void run() {
        if ((this.a == null) || (c())) {
            this.g.a(this.a);
            return;
        }
        new jl(this, this.a).execute(new Void[0]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */