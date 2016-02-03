package com.flurry.sdk;

import java.io.IOException;
import java.util.Iterator;

@kb
public class pm
        extends pb<Iterable<?>> {
    public pm(sh paramsh, boolean paramBoolean, jz paramjz, is paramis) {
        super(Iterable.class, paramsh, paramBoolean, paramjz, paramis, null);
    }

    public pf<?> a(jz paramjz) {
        return new pm(this.b, this.a, paramjz, this.e);
    }

    public void a(Iterable<?> paramIterable, hf paramhf, jw paramjw)
            throws IOException, he {
        Object localObject1 = null;
        Iterator localIterator = paramIterable.iterator();
        jz localjz;
        if (localIterator.hasNext()) {
            localjz = this.c;
            paramIterable = null;
        }
        for (; ; ) {
            Object localObject3 = localIterator.next();
            if (localObject3 == null) {
                paramjw.a(paramhf);
            }
            while (!localIterator.hasNext()) {
                return;
                Object localObject2 = localObject3.getClass();
                if (localObject2 == localObject1) {
                }
                for (localObject2 = paramIterable; ; localObject2 = paramIterable) {
                    if (localjz != null) {
                        break label114;
                    }
                    ((jk) localObject2).a(localObject3, paramhf, paramjw);
                    break;
                    paramIterable = paramjw.a((Class) localObject2, this.e);
                    localObject1 = localObject2;
                }
                label114:
                ((jk) localObject2).a(localObject3, paramhf, paramjw, localjz);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */