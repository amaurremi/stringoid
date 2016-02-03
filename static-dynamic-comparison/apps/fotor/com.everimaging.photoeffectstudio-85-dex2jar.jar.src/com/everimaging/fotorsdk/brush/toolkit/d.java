package com.everimaging.fotorsdk.brush.toolkit;

import java.util.ArrayList;
import java.util.List;

public abstract class d<Cache>
        extends c {
    protected int a = Integer.MAX_VALUE;
    protected ArrayList<d<Cache>.a> b = new ArrayList();
    protected int c = -1;

    public final List<c.b> a(c.b paramb) {
        ArrayList localArrayList = new ArrayList();
        int i = this.b.size() - 1;
        while (this.c < i) {
            localArrayList.add(this.b.remove(i));
            i -= 1;
        }
        this.b.add((a) paramb);
        for (this.c += 1; this.b.size() > this.a; this.c -= 1) {
            localArrayList.add(this.b.remove(1));
        }
        if (this.b.size() > 1) {
            a();
        }
        d();
        return localArrayList;
    }

    protected void a(d<Cache>.a paramd) {
        this.b.clear();
        this.b.add(paramd);
        this.c = 0;
    }

    public abstract void a(Cache paramCache);

    public final boolean e() {
        if (this.c == 0) {
            return false;
        }
        ArrayList localArrayList = this.b;
        int i = this.c - 1;
        this.c = i;
        a(((a) localArrayList.get(i)).b);
        if (this.c == 0) {
            c();
        }
        b();
        return true;
    }

    public final boolean f() {
        if (this.c >= this.b.size() - 1) {
            return false;
        }
        ArrayList localArrayList = this.b;
        int i = this.c + 1;
        this.c = i;
        a(((a) localArrayList.get(i)).b);
        a();
        if (this.c == this.b.size() - 1) {
            d();
        }
        return true;
    }

    public abstract class a
            extends c.b {
        public Cache b;

        public a() {
            super();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/toolkit/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */