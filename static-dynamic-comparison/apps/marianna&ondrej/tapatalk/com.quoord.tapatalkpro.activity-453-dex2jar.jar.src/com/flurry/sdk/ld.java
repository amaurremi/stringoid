package com.flurry.sdk;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public final class ld {
    protected final kx a;
    protected final HashMap<String, kt> b;
    protected Object[] c;
    protected final kt[] d;

    public ld(kx paramkx) {
        this.a = paramkx;
        this.b = new HashMap();
        kt[] arrayOfkt = paramkx.k();
        int j = arrayOfkt.length;
        int i = 0;
        paramkx = null;
        while (i < j) {
            kt localkt = arrayOfkt[i];
            this.b.put(localkt.c(), localkt);
            Object localObject2 = localObject1;
            if (localkt.a().t()) {
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = new Object[j];
                }
                localObject2[i] = qy.f(localkt.a().p());
            }
            localObject1 = paramkx;
            if (localkt.k() != null) {
                localObject1 = paramkx;
                if (paramkx == null) {
                    localObject1 = new kt[j];
                }
                localObject1[i] = localkt;
            }
            i += 1;
            paramkx = (kx) localObject1;
            localObject1 = localObject2;
        }
        this.c = ((Object[]) localObject1);
        this.d = paramkx;
    }

    public kt a(String paramString) {
        return (kt) this.b.get(paramString);
    }

    public lf a(hj paramhj, iz paramiz) {
        paramhj = new lf(paramhj, paramiz, this.b.size());
        if (this.d != null) {
            paramhj.a(this.d);
        }
        return paramhj;
    }

    public Object a(lf paramlf)
            throws IOException {
        Object localObject = this.a.a(paramlf.a(this.c));
        for (paramlf = paramlf.a(); paramlf != null; paramlf = paramlf.a) {
            paramlf.a(localObject);
        }
        return localObject;
    }

    public Collection<kt> a() {
        return this.b.values();
    }

    public void a(kt paramkt, jg<Object> paramjg) {
        paramkt = paramkt.a(paramjg);
        this.b.put(paramkt.c(), paramkt);
        paramjg = paramjg.b();
        if (paramjg != null) {
            if (this.c == null) {
                this.c = new Object[this.b.size()];
            }
            this.c[paramkt.j()] = paramjg;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */