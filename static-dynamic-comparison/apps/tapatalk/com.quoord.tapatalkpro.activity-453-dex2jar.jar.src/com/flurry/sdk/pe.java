package com.flurry.sdk;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class pe
        extends pb<Collection<?>> {
    public pe(sh paramsh, boolean paramBoolean, jz paramjz, is paramis, jk<Object> paramjk) {
        super(Collection.class, paramsh, paramBoolean, paramjz, paramis, paramjk);
    }

    public pf<?> a(jz paramjz) {
        return new pe(this.b, this.a, paramjz, this.e, this.d);
    }

    public void a(Collection<?> paramCollection, hf paramhf, jw paramjw)
            throws IOException, he {
        if (this.d != null) {
            a(paramCollection, paramhf, paramjw, this.d);
        }
        Iterator localIterator;
        do {
            return;
            localIterator = paramCollection.iterator();
        } while (!localIterator.hasNext());
        Object localObject1 = this.f;
        jz localjz = this.c;
        int i = 0;
        int j = i;
        for (; ; ) {
            Object localObject4;
            Class localClass;
            Object localObject2;
            Object localObject3;
            try {
                localObject4 = localIterator.next();
                if (localObject4 == null) {
                    j = i;
                    paramjw.a(paramhf);
                    j = i + 1;
                    i = j;
                    if (localIterator.hasNext()) {
                        break;
                    }
                    return;
                }
                j = i;
                localClass = localObject4.getClass();
                j = i;
                jk localjk = ((ov) localObject1).a(localClass);
                localObject2 = localObject1;
                localObject3 = localjk;
                if (localjk == null) {
                    j = i;
                    if (this.b.e()) {
                        j = i;
                        localObject1 = a((ov) localObject1, paramjw.a(this.b, localClass), paramjw);
                        j = i;
                        localObject2 = this.f;
                        localObject3 = localObject1;
                    }
                } else {
                    if (localjz != null) {
                        break label242;
                    }
                    j = i;
                    ((jk) localObject3).a(localObject4, paramhf, paramjw);
                    localObject1 = localObject2;
                    continue;
                }
                j = i;
            } catch (Exception paramhf) {
                a(paramjw, paramhf, paramCollection, j);
                return;
            }
            localObject1 = a((ov) localObject1, localClass, paramjw);
            continue;
            label242:
            j = i;
            ((jk) localObject3).a(localObject4, paramhf, paramjw, localjz);
            localObject1 = localObject2;
        }
    }

    public void a(Collection<?> paramCollection, hf paramhf, jw paramjw, jk<Object> paramjk)
            throws IOException, he {
        Iterator localIterator = paramCollection.iterator();
        jz localjz;
        int i;
        if (localIterator.hasNext()) {
            localjz = this.c;
            i = 0;
        }
        for (; ; ) {
            Object localObject = localIterator.next();
            if (localObject == null) {
            }
            try {
                paramjw.a(paramhf);
                for (; ; ) {
                    i += 1;
                    if (localIterator.hasNext()) {
                        break;
                    }
                    return;
                    if (localjz != null) {
                        break label95;
                    }
                    paramjk.a(localObject, paramhf, paramjw);
                }
            } catch (Exception localException) {
                for (; ; ) {
                    a(paramjw, localException, paramCollection, i);
                    continue;
                    label95:
                    paramjk.a(localException, paramhf, paramjw, localjz);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/pe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */