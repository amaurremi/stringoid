package com.flurry.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class kp {
    protected final mw a;
    protected final HashMap<String, kt> b = new LinkedHashMap();
    protected List<lh> c;
    protected HashMap<String, kt> d;
    protected HashSet<String> e;
    protected kx f;
    protected ks g;
    protected boolean h;

    public kp(mw parammw) {
        this.a = parammw;
    }

    public jg<?> a(is paramis) {
        kz localkz = new kz(this.b.values());
        localkz.a();
        return new ko(this.a, paramis, this.f, localkz, this.d, this.e, this.h, this.g, this.c);
    }

    public void a(it paramit) {
    }

    public void a(ks paramks) {
        if ((this.g != null) && (paramks != null)) {
            throw new IllegalStateException("_anySetter already set to non-null");
        }
        this.g = paramks;
    }

    public void a(kt paramkt) {
        kt localkt = (kt) this.b.put(paramkt.c(), paramkt);
        if ((localkt != null) && (localkt != paramkt)) {
            throw new IllegalArgumentException("Duplicate property '" + paramkt.c() + "' for " + this.a.a());
        }
    }

    public void a(kt paramkt, boolean paramBoolean) {
        this.b.put(paramkt.c(), paramkt);
    }

    public void a(kx paramkx) {
        this.f = paramkx;
    }

    public void a(String paramString) {
        if (this.e == null) {
            this.e = new HashSet();
        }
        this.e.add(paramString);
    }

    public void a(String paramString, kt paramkt) {
        if (this.d == null) {
            this.d = new HashMap(4);
        }
        this.d.put(paramString, paramkt);
        if (this.b != null) {
            this.b.remove(paramkt.c());
        }
    }

    public void a(String paramString, sh paramsh, qv paramqv, mq parammq, Object paramObject) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(new lh(paramString, paramsh, paramqv, parammq, paramObject));
    }

    public void a(boolean paramBoolean) {
        this.h = paramBoolean;
    }

    public boolean b(String paramString) {
        return this.b.containsKey(paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/kp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */