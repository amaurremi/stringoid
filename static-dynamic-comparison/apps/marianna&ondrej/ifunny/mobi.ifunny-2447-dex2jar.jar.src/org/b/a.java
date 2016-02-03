package org.b;

import org.b.c.b;
import org.b.c.c;
import org.b.d.aj;
import org.b.d.al;
import org.b.f.e;
import org.b.f.l;

public class a {
    private static final a b = new a();
    private al a = new al(null);

    public <T> T a(byte[] paramArrayOfByte, Class<T> paramClass) {
        return (T) a(paramArrayOfByte, null, this.a.a(paramClass));
    }

    public <T> T a(byte[] paramArrayOfByte, T paramT, aj<T> paramaj) {
        return (T) paramaj.a(a(paramArrayOfByte), paramT);
    }

    public b a() {
        return new c(this);
    }

    public <T> aj<T> a(Class<T> paramClass) {
        return this.a.a(paramClass);
    }

    public e a(byte[] paramArrayOfByte) {
        return b().a(paramArrayOfByte);
    }

    public <T> void a(Class<T> paramClass, aj<T> paramaj) {
        this.a.a(paramClass, paramaj);
    }

    public <T> byte[] a(T paramT) {
        b localb = a();
        if (paramT == null) {
            localb.d();
        }
        for (; ; ) {
            return localb.c();
            this.a.a(paramT.getClass()).a(localb, paramT);
        }
    }

    public e b() {
        return new l(this);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */