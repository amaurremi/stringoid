package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class nt
        extends ng {
    protected LinkedHashSet<nf> a;

    public Collection<nf> a(mn parammn, jn<?> paramjn, iq paramiq) {
        HashMap localHashMap = new HashMap();
        if (this.a != null) {
            Class localClass = parammn.d();
            Iterator localIterator = this.a.iterator();
            while (localIterator.hasNext()) {
                nf localnf = (nf) localIterator.next();
                if (localClass.isAssignableFrom(localnf.a())) {
                    a(mn.b(localnf.a(), paramiq, paramjn), localnf, paramjn, paramiq, localHashMap);
                }
            }
        }
        a(parammn, new nf(parammn.d(), null), paramjn, paramiq, localHashMap);
        return new ArrayList(localHashMap.values());
    }

    public Collection<nf> a(mq parammq, jn<?> paramjn, iq paramiq) {
        HashMap localHashMap = new HashMap();
        Object localObject2;
        if (this.a != null) {
            localObject1 = parammq.d();
            localObject2 = this.a.iterator();
            while (((Iterator) localObject2).hasNext()) {
                nf localnf = (nf) ((Iterator) localObject2).next();
                if (((Class) localObject1).isAssignableFrom(localnf.a())) {
                    a(mn.b(localnf.a(), paramiq, paramjn), localnf, paramjn, paramiq, localHashMap);
                }
            }
        }
        Object localObject1 = paramiq.a(parammq);
        if (localObject1 != null) {
            localObject1 = ((Collection) localObject1).iterator();
            while (((Iterator) localObject1).hasNext()) {
                localObject2 = (nf) ((Iterator) localObject1).next();
                a(mn.b(((nf) localObject2).a(), paramiq, paramjn), (nf) localObject2, paramjn, paramiq, localHashMap);
            }
        }
        localObject1 = new nf(parammq.d(), null);
        a(mn.b(parammq.d(), paramiq, paramjn), (nf) localObject1, paramjn, paramiq, localHashMap);
        return new ArrayList(localHashMap.values());
    }

    protected void a(mn parammn, nf paramnf, jn<?> paramjn, iq paramiq, HashMap<nf, nf> paramHashMap) {
        Object localObject = paramnf;
        if (!paramnf.c()) {
            String str = paramiq.g(parammn);
            localObject = paramnf;
            if (str != null) {
                localObject = new nf(paramnf.a(), str);
            }
        }
        if (paramHashMap.containsKey(localObject)) {
            if ((((nf) localObject).c()) && (!((nf) paramHashMap.get(localObject)).c())) {
                paramHashMap.put(localObject, localObject);
            }
        }
        do {
            return;
            paramHashMap.put(localObject, localObject);
            parammn = paramiq.a(parammn);
        } while ((parammn == null) || (parammn.isEmpty()));
        paramnf = parammn.iterator();
        label123:
        if (paramnf.hasNext()) {
            parammn = (nf) paramnf.next();
            localObject = mn.b(parammn.a(), paramiq, paramjn);
            if (parammn.c()) {
                break label195;
            }
            parammn = new nf(parammn.a(), paramiq.g((mn) localObject));
        }
        label195:
        for (; ; ) {
            a((mn) localObject, parammn, paramjn, paramiq, paramHashMap);
            break label123;
            break;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/nt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */