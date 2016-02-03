package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class a<E>
        extends ae<Object> {
    public static final af a = new b();
    private final Class<E> b;
    private final ae<E> c;

    public a(j paramj, ae<E> paramae, Class<E> paramClass) {
        this.c = new x(paramj, paramae, paramClass);
        this.b = paramClass;
    }

    public void a(d paramd, Object paramObject) {
        if (paramObject == null) {
            paramd.f();
            return;
        }
        paramd.b();
        int i = 0;
        int j = Array.getLength(paramObject);
        while (i < j) {
            Object localObject = Array.get(paramObject, i);
            this.c.a(paramd, localObject);
            i += 1;
        }
        paramd.c();
    }

    public Object b(com.millennialmedia.a.a.d.a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        ArrayList localArrayList = new ArrayList();
        parama.a();
        while (parama.e()) {
            localArrayList.add(this.c.b(parama));
        }
        parama.b();
        parama = Array.newInstance(this.b, localArrayList.size());
        int i = 0;
        while (i < localArrayList.size()) {
            Array.set(parama, i, localArrayList.get(i));
            i += 1;
        }
        return parama;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */