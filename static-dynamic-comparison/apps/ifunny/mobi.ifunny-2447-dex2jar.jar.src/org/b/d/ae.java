package org.b.d;

import java.util.HashMap;

import org.b.a.j;
import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ae<T>
        extends a<T> {
    protected T[] a;
    protected HashMap<T, Integer> b;
    protected boolean c;

    public ae(Class<T> paramClass) {
        this.a = paramClass.getEnumConstants();
        this.b = new HashMap();
        int i = 0;
        while (i < this.a.length) {
            this.b.put(this.a[i], Integer.valueOf(i));
            i += 1;
        }
        if ((!paramClass.isAnnotationPresent(j.class)) || (((j) paramClass.getAnnotation(j.class)).a())) {
            bool = true;
        }
        this.c = bool;
    }

    public T a(q paramq, T paramT, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
        }
        int i;
        do {
            return null;
            i = paramq.l();
            if (i < this.a.length) {
                return (T) this.a[i];
            }
        } while (!this.c);
        throw new c(new IllegalArgumentException("ordinal: " + i));
    }

    public void a(e parame, T paramT, boolean paramBoolean) {
        if (paramT == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        paramT = (Integer) this.b.get(paramT);
        if (paramT == null) {
            throw new c(new IllegalArgumentException("ordinal: " + paramT));
        }
        parame.a(paramT.intValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */