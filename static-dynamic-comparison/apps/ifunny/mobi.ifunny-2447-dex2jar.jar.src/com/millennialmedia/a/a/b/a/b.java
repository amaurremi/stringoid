package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.j;

import java.lang.reflect.GenericArrayType;

final class b
        implements af {
    public <T> ae<T> a(j paramj, com.millennialmedia.a.a.c.a<T> parama) {
        parama = parama.b();
        if ((!(parama instanceof GenericArrayType)) && ((!(parama instanceof Class)) || (!((Class) parama).isArray()))) {
            return null;
        }
        parama = com.millennialmedia.a.a.b.b.g(parama);
        return new a(paramj, paramj.a(com.millennialmedia.a.a.c.a.a(parama)), com.millennialmedia.a.a.b.b.e(parama));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */