package com.millennialmedia.a.a;

import com.millennialmedia.a.a.b.a.i;
import com.millennialmedia.a.a.d.a;
import com.millennialmedia.a.a.d.d;

import java.io.IOException;

public abstract class ae<T> {
    public final t a(T paramT) {
        try {
            i locali = new i();
            a(locali, paramT);
            paramT = locali.a();
            return paramT;
        } catch (IOException paramT) {
            throw new u(paramT);
        }
    }

    public abstract void a(d paramd, T paramT);

    public abstract T b(a parama);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */