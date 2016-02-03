package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.aa;
import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.b.ag;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class r<T>
        extends ae<T> {
    private final ag<T> a;
    private final Map<String, s> b;

    private r(ag<T> paramag, Map<String, s> paramMap) {
        this.a = paramag;
        this.b = paramMap;
    }

    public void a(d paramd, T paramT) {
        if (paramT == null) {
            paramd.f();
            return;
        }
        paramd.d();
        try {
            Iterator localIterator = this.b.values().iterator();
            while (localIterator.hasNext()) {
                s locals = (s) localIterator.next();
                if (locals.h) {
                    paramd.a(locals.g);
                    locals.a(paramd, paramT);
                }
            }
            paramd.e();
        } catch (IllegalAccessException paramd) {
            throw new AssertionError();
        }
    }

    public T b(a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        Object localObject1 = this.a.a();
        try {
            parama.c();
            for (; ; ) {
                if (!parama.e()) {
                    break label103;
                }
                localObject2 = parama.g();
                localObject2 = (s) this.b.get(localObject2);
                if ((localObject2 != null) && (((s) localObject2).i)) {
                    break;
                }
                parama.n();
            }
        } catch (IllegalStateException parama) {
            for (; ; ) {
                Object localObject2;
                throw new aa(parama);
                ((s) localObject2).a(parama, localObject1);
            }
        } catch (IllegalAccessException parama) {
            throw new AssertionError(parama);
        }
        label103:
        parama.d();
        return (T) localObject1;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */