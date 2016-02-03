package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.b.ag;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

final class d<E>
        extends ae<Collection<E>> {
    private final ae<E> a;
    private final ag<? extends Collection<E>> b;

    public d(j paramj, Type paramType, ae<E> paramae, ag<? extends Collection<E>> paramag) {
        this.a = new x(paramj, paramae, paramType);
        this.b = paramag;
    }

    public Collection<E> a(a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        Collection localCollection = (Collection) this.b.a();
        parama.a();
        while (parama.e()) {
            localCollection.add(this.a.b(parama));
        }
        parama.b();
        return localCollection;
    }

    public void a(com.millennialmedia.a.a.d.d paramd, Collection<E> paramCollection) {
        if (paramCollection == null) {
            paramd.f();
            return;
        }
        paramd.b();
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
            Object localObject = paramCollection.next();
            this.a.a(paramd, localObject);
        }
        paramd.c();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */