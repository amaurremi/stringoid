package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;

import java.util.HashSet;
import java.util.List;

@ii
class tj {
    public final ti a;
    public final String b;
    public final Context c;
    public final pv d;
    public final gt e;
    public az f;
    public lo g;
    public lo h;
    public ay i;
    public lc j;
    public ld k;
    public lg l;
    public bi m;
    public hh n;
    public gw o;
    public hx p;
    public ia q;
    public cc r;
    public cd s;
    public List<String> t;
    public gq u;
    public lm v = null;
    public View w = null;
    public int x = 0;
    public boolean y = false;
    private HashSet<lg> z = null;

    public tj(Context paramContext, ay paramay, String paramString, gt paramgt) {
        if (paramay.e) {
            this.a = null;
        }
        for (; ; ) {
            this.i = paramay;
            this.b = paramString;
            this.c = paramContext;
            this.e = paramgt;
            this.d = new pv(new tn(this));
            return;
            this.a = new ti(paramContext);
            this.a.setMinimumWidth(paramay.g);
            this.a.setMinimumHeight(paramay.d);
            this.a.setVisibility(4);
        }
    }

    public HashSet<lg> a() {
        return this.z;
    }

    public void a(HashSet<lg> paramHashSet) {
        this.z = paramHashSet;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/tj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */