package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class gr {
    public gq a(fn paramfn, Map<a, gq> paramMap) {
        Object localObject1;
        Object localObject3;
        Object localObject2;
        int i;
        switch (1. a[paramfn.a().ordinal()])
        {
            default:
                throw new RuntimeException("Unexpected schema type");
            case 1:
                localObject1 = gq.c;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                do {
                    return (gq) localObject1;
                    return gq.d;
                    return gq.e;
                    return gq.f;
                    return gq.g;
                    return gq.h;
                    return gq.i;
                    return gq.j;
                    return gq.b(new gq[]{new gq.h(paramfn.l()), gq.k});
                    return gq.b(new gq[]{new gq.h(paramfn.c().size()), gq.l});
                    return gq.b(new gq[]{gq.a(gq.o, new gq[]{a(paramfn.i(), paramMap)}), gq.n});
                    return gq.b(new gq[]{gq.a(gq.q, new gq[]{a(paramfn.j(), paramMap), gq.i}), gq.p});
                    localObject3 = new a(paramfn);
                    localObject2 = (gq) paramMap.get(localObject3);
                    localObject1 = localObject2;
                } while (localObject2 != null);
                localObject1 = new gq[paramfn.b().size()];
                localObject2 = gq.b((gq[]) localObject1);
                paramMap.put(localObject3, localObject2);
                i = localObject1.length;
                paramfn = paramfn.b().iterator();
        }
        while (paramfn.hasNext()) {
            localObject3 = (fn.f) paramfn.next();
            i -= 1;
            localObject1[i] = a(((fn.f) localObject3).c(), paramMap);
            continue;
            localObject2 = paramfn.k();
            localObject1 = new gq[((List) localObject2).size()];
            localObject2 = new String[((List) localObject2).size()];
            paramfn = paramfn.k().iterator();
            i = 0;
            while (paramfn.hasNext()) {
                localObject3 = (fn) paramfn.next();
                localObject1[i] = a((fn) localObject3, paramMap);
                localObject2[i] = ((fn) localObject3).g();
                i += 1;
            }
            return gq.b(new gq[]{gq.a((gq[]) localObject1, (String[]) localObject2), gq.m});
        }
        return (gq) localObject2;
    }

    static class a {
        public final fn b;

        public a(fn paramfn) {
            this.b = paramfn;
        }

        public boolean equals(Object paramObject) {
            if (!(paramObject instanceof a)) {
            }
            while (this.b != ((a) paramObject).b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.b.hashCode();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */