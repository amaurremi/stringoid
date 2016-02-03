package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.d;
import com.millennialmedia.a.a.j;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class x<T>
        extends ae<T> {
    private final j a;
    private final ae<T> b;
    private final Type c;

    x(j paramj, ae<T> paramae, Type paramType) {
        this.a = paramj;
        this.b = paramae;
        this.c = paramType;
    }

    private Type a(Type paramType, Object paramObject) {
        Object localObject = paramType;
        if (paramObject != null) {
            if ((paramType != Object.class) && (!(paramType instanceof TypeVariable))) {
                localObject = paramType;
                if (!(paramType instanceof Class)) {
                }
            } else {
                localObject = paramObject.getClass();
            }
        }
        return (Type) localObject;
    }

    public void a(d paramd, T paramT) {
        ae localae = this.b;
        Type localType = a(this.c, paramT);
        if (localType != this.c) {
            localae = this.a.a(com.millennialmedia.a.a.c.a.a(localType));
            if ((localae instanceof r)) {
                break label52;
            }
        }
        for (; ; ) {
            localae.a(paramd, paramT);
            return;
            label52:
            if (!(this.b instanceof r)) {
                localae = this.b;
            }
        }
    }

    public T b(com.millennialmedia.a.a.d.a parama) {
        return (T) this.b.b(parama);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */