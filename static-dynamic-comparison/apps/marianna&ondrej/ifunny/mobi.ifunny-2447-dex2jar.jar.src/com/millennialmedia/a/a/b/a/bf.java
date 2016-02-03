package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.a.b;
import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class bf<T extends Enum<T>>
        extends ae<T> {
    private final Map<String, T> a = new HashMap();
    private final Map<T, String> b = new HashMap();

    public bf(Class<T> paramClass) {
        for (; ; ) {
            try {
                Enum[] arrayOfEnum = (Enum[]) paramClass.getEnumConstants();
                int j = arrayOfEnum.length;
                int i = 0;
                if (i < j) {
                    Enum localEnum = arrayOfEnum[i];
                    String str = localEnum.name();
                    b localb = (b) paramClass.getField(str).getAnnotation(b.class);
                    if (localb != null) {
                        str = localb.a();
                        this.a.put(str, localEnum);
                        this.b.put(localEnum, str);
                        i += 1;
                    }
                } else {
                    return;
                }
            } catch (NoSuchFieldException paramClass) {
                throw new AssertionError();
            }
        }
    }

    public T a(a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        return (Enum) this.a.get(parama.h());
    }

    public void a(d paramd, T paramT) {
        if (paramT == null) {
        }
        for (paramT = null; ; paramT = (String) this.b.get(paramT)) {
            paramd.b(paramT);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */