package com.flurry.sdk;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@kb
public class ph
        extends pf<EnumMap<? extends Enum<?>, ?>>
        implements jt {
    protected final boolean a;
    protected final rb b;
    protected final sh c;
    protected final is d;
    protected jk<Object> e;
    protected final jz f;

    public ph(sh paramsh, boolean paramBoolean, rb paramrb, jz paramjz, is paramis, jk<Object> paramjk) {
        super(EnumMap.class, false);
        if (!paramBoolean) {
            paramBoolean = bool;
            if (paramsh != null) {
                paramBoolean = bool;
                if (!paramsh.u()) {
                }
            }
        } else {
            paramBoolean = true;
        }
        this.a = paramBoolean;
        this.c = paramsh;
        this.b = paramrb;
        this.f = paramjz;
        this.d = paramis;
        this.e = paramjk;
    }

    public pf<?> a(jz paramjz) {
        return new ph(this.c, this.a, this.b, paramjz, this.d, this.e);
    }

    public void a(jw paramjw)
            throws jh {
        if ((this.a) && (this.e == null)) {
            this.e = paramjw.a(this.c, this.d);
        }
    }

    public void a(EnumMap<? extends Enum<?>, ?> paramEnumMap, hf paramhf, jw paramjw)
            throws IOException, he {
        paramhf.d();
        if (!paramEnumMap.isEmpty()) {
            b(paramEnumMap, paramhf, paramjw);
        }
        paramhf.e();
    }

    protected void a(EnumMap<? extends Enum<?>, ?> paramEnumMap, hf paramhf, jw paramjw, jk<Object> paramjk)
            throws IOException, he {
        Object localObject2 = this.b;
        Iterator localIterator = paramEnumMap.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            Enum localEnum = (Enum) localEntry.getKey();
            Object localObject1 = localObject2;
            if (localObject2 == null) {
                localObject1 = ((pi) paramjw.a(localEnum.getDeclaringClass(), this.d)).d();
            }
            paramhf.a(((rb) localObject1).a(localEnum));
            localObject2 = localEntry.getValue();
            if (localObject2 == null) {
                paramjw.a(paramhf);
                localObject2 = localObject1;
            } else {
                try {
                    paramjk.a(localObject2, paramhf, paramjw);
                    localObject2 = localObject1;
                } catch (Exception localException) {
                    a(paramjw, localException, paramEnumMap, ((Enum) localEntry.getKey()).name());
                    Object localObject3 = localObject1;
                }
            }
        }
    }

    public void a(EnumMap<? extends Enum<?>, ?> paramEnumMap, hf paramhf, jw paramjw, jz paramjz)
            throws IOException, he {
        paramjz.b(paramEnumMap, paramhf);
        if (!paramEnumMap.isEmpty()) {
            b(paramEnumMap, paramhf, paramjw);
        }
        paramjz.e(paramEnumMap, paramhf);
    }

    protected void b(EnumMap<? extends Enum<?>, ?> paramEnumMap, hf paramhf, jw paramjw)
            throws IOException, he {
        Object localObject2 = null;
        if (this.e != null) {
            a(paramEnumMap, paramhf, paramjw, this.e);
            return;
        }
        rb localrb = this.b;
        Iterator localIterator = paramEnumMap.entrySet().iterator();
        Object localObject1 = null;
        label42:
        Map.Entry localEntry;
        Object localObject3;
        if (localIterator.hasNext()) {
            localEntry = (Map.Entry) localIterator.next();
            localObject3 = (Enum) localEntry.getKey();
            if (localrb != null) {
                break label273;
            }
            localrb = ((pi) paramjw.a(((Enum) localObject3).getDeclaringClass(), this.d)).d();
        }
        label273:
        for (; ; ) {
            paramhf.a(localrb.a((Enum) localObject3));
            Object localObject6 = localEntry.getValue();
            if (localObject6 == null) {
                paramjw.a(paramhf);
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
            }
            for (; ; ) {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
                break label42;
                break;
                Object localObject5 = localObject6.getClass();
                if (localObject5 == localObject2) {
                    localObject5 = localObject1;
                    localObject3 = localObject1;
                    localObject1 = localObject5;
                }
                for (; ; ) {
                    try {
                        ((jk) localObject3).a(localObject6, paramhf, paramjw);
                        localObject3 = localObject1;
                        localObject1 = localObject2;
                        localObject2 = localObject3;
                    } catch (Exception localException) {
                        a(paramjw, localException, paramEnumMap, ((Enum) localEntry.getKey()).name());
                        Object localObject4 = localObject1;
                        localObject1 = localObject2;
                        localObject2 = localObject4;
                    }
                    localObject3 = paramjw.a((Class) localObject5, this.d);
                    localObject1 = localObject3;
                    localObject2 = localObject5;
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */