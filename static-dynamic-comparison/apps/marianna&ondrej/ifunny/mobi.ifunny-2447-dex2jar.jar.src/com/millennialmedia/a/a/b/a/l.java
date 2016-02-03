package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.aa;
import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.b.ag;
import com.millennialmedia.a.a.b.ai;
import com.millennialmedia.a.a.b.u;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.j;
import com.millennialmedia.a.a.t;
import com.millennialmedia.a.a.y;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class l<K, V>
        extends ae<Map<K, V>> {
    private final ae<K> b;
    private final ae<V> c;
    private final ag<? extends Map<K, V>> d;

    public l(j paramj, Type paramType1, ae<K> paramae, Type paramType2, ae<V> paramae1, ag<? extends Map<K, V>> paramag) {
        this.b = new x(paramType1, paramType2, paramae);
        this.c = new x(paramType1, paramag, paramae1);
        ag localag;
        this.d = localag;
    }

    private String a(t paramt) {
        if (paramt.i()) {
            paramt = paramt.m();
            if (paramt.p()) {
                return String.valueOf(paramt.a());
            }
            if (paramt.o()) {
                return Boolean.toString(paramt.f());
            }
            if (paramt.q()) {
                return paramt.b();
            }
            throw new AssertionError();
        }
        if (paramt.j()) {
            return "null";
        }
        throw new AssertionError();
    }

    public Map<K, V> a(a parama) {
        Object localObject = parama.f();
        if (localObject == c.i) {
            parama.j();
            return null;
        }
        Map localMap = (Map) this.d.a();
        if (localObject == c.a) {
            parama.a();
            while (parama.e()) {
                parama.a();
                localObject = this.b.b(parama);
                if (localMap.put(localObject, this.c.b(parama)) != null) {
                    throw new aa("duplicate key: " + localObject);
                }
                parama.b();
            }
            parama.b();
            return localMap;
        }
        parama.c();
        while (parama.e()) {
            u.a.a(parama);
            localObject = this.b.b(parama);
            if (localMap.put(localObject, this.c.b(parama)) != null) {
                throw new aa("duplicate key: " + localObject);
            }
        }
        parama.d();
        return localMap;
    }

    public void a(d paramd, Map<K, V> paramMap) {
        int m = 0;
        int k = 0;
        if (paramMap == null) {
            paramd.f();
            return;
        }
        if (!k.a(this.a)) {
            paramd.d();
            paramMap = paramMap.entrySet().iterator();
            while (paramMap.hasNext()) {
                localObject = (Map.Entry) paramMap.next();
                paramd.a(String.valueOf(((Map.Entry) localObject).getKey()));
                this.c.a(paramd, ((Map.Entry) localObject).getValue());
            }
            paramd.e();
            return;
        }
        Object localObject = new ArrayList(paramMap.size());
        ArrayList localArrayList = new ArrayList(paramMap.size());
        paramMap = paramMap.entrySet().iterator();
        int i = 0;
        if (paramMap.hasNext()) {
            Map.Entry localEntry = (Map.Entry) paramMap.next();
            t localt = this.b.a(localEntry.getKey());
            ((List) localObject).add(localt);
            localArrayList.add(localEntry.getValue());
            if ((localt.g()) || (localt.h())) {
            }
            for (int j = 1; ; j = 0) {
                i = j | i;
                break;
            }
        }
        if (i != 0) {
            paramd.b();
            i = k;
            while (i < ((List) localObject).size()) {
                paramd.b();
                ai.a((t) ((List) localObject).get(i), paramd);
                this.c.a(paramd, localArrayList.get(i));
                paramd.c();
                i += 1;
            }
            paramd.c();
            return;
        }
        paramd.d();
        i = m;
        while (i < ((List) localObject).size()) {
            paramd.a(a((t) ((List) localObject).get(i)));
            this.c.a(paramd, localArrayList.get(i));
            i += 1;
        }
        paramd.e();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */