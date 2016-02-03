package org.b.d;

import java.lang.reflect.Type;
import java.util.Map;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ak<T>
        extends a<T> {
    private al a;
    private Type b;
    private aj<T> c;

    public ak(al paramal, Type paramType) {
        this.a = paramal;
        this.b = paramType;
    }

    private void a() {
        if (this.c == null) {
            this.c = ((aj) this.a.a.get(this.b));
            if (this.c == null) {
                throw new c("Actual template have not been created");
            }
        }
    }

    public T a(q paramq, T paramT) {
        a();
        return (T) this.c.a(paramq, paramT, false);
    }

    public T a(q paramq, T paramT, boolean paramBoolean) {
        a();
        return (T) this.c.a(paramq, paramT, paramBoolean);
    }

    public void a(e parame, T paramT) {
        a();
        this.c.a(parame, paramT, false);
    }

    public void a(e parame, T paramT, boolean paramBoolean) {
        a();
        this.c.a(parame, paramT, paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */