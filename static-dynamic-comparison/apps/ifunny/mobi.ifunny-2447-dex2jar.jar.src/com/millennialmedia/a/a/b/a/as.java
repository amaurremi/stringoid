package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.c.a;
import com.millennialmedia.a.a.j;

final class as
        implements af {
    public <T> ae<T> a(j paramj, a<T> parama) {
        parama = parama.a();
        if ((!Enum.class.isAssignableFrom(parama)) || (parama == Enum.class)) {
            return null;
        }
        paramj = parama;
        if (!parama.isEnum()) {
            paramj = parama.getSuperclass();
        }
        return new bf(paramj);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */