package com.millennialmedia.a.a.b.a;

import com.millennialmedia.a.a.ae;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.c;
import com.millennialmedia.a.a.d.d;

final class z
        extends ae<Class> {
    public Class a(a parama) {
        if (parama.f() == c.i) {
            parama.j();
            return null;
        }
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    public void a(d paramd, Class paramClass) {
        if (paramClass == null) {
            paramd.f();
            return;
        }
        throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramClass.getName() + ". Forgot to register a type adapter?");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */