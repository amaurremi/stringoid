package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.af;
import com.millennialmedia.a.a.b.b;
import com.millennialmedia.a.a.b.f;
import com.millennialmedia.a.a.c.a;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Type;
import java.util.Map;

public final class k
        implements af {
    private final f a;
    private final boolean b;

    public k(f paramf, boolean paramBoolean) {
        this.a = paramf;
        this.b = paramBoolean;
    }

    private ae<?> a(j paramj, Type paramType) {
        if ((paramType == Boolean.TYPE) || (paramType == Boolean.class)) {
            return y.f;
        }
        return paramj.a(a.a(paramType));
    }

    public <T> ae<T> a(j paramj, a<T> parama) {
        Object localObject = parama.b();
        if (!Map.class.isAssignableFrom(parama.a())) {
            return null;
        }
        localObject = b.b((Type) localObject, b.e((Type) localObject));
        ae localae1 = a(paramj, localObject[0]);
        ae localae2 = paramj.a(a.a(localObject[1]));
        parama = this.a.a(parama);
        return new l(this, paramj, localObject[0], localae1, localObject[1], localae2, parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */