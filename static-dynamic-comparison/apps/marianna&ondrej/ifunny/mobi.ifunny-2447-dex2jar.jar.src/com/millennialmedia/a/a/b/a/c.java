package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.b.b;
import com.millennialmedia.a.a.b.f;
import com.millennialmedia.a.a.c.a;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Type;
import java.util.Collection;

public final class c
        implements af {
    private final f a;

    public c(f paramf) {
        this.a = paramf;
    }

    public <T> ae<T> a(j paramj, a<T> parama) {
        Type localType = parama.b();
        Class localClass = parama.a();
        if (!Collection.class.isAssignableFrom(localClass)) {
            return null;
        }
        localType = b.a(localType, localClass);
        return new d(paramj, localType, paramj.a(a.a(localType)), this.a.a(parama));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */