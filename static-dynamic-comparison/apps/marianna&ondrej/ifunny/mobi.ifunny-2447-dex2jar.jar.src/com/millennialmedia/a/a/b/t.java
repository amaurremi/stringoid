package com.millennialmedia.a.a.b;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.j;

class t
        extends ae<T> {
    private ae<T> f;

    t(s params, boolean paramBoolean1, boolean paramBoolean2, j paramj, com.millennialmedia.a.a.c.a parama) {
    }

    private ae<T> a() {
        ae localae = this.f;
        if (localae != null) {
            return localae;
        }
        localae = this.c.a(this.e, this.d);
        this.f = localae;
        return localae;
    }

    public void a(d paramd, T paramT) {
        if (this.b) {
            paramd.f();
            return;
        }
        a().a(paramd, paramT);
    }

    public T b(com.millennialmedia.a.a.d.a parama) {
        if (this.a) {
            parama.n();
            return null;
        }
        return (T) a().b(parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */