package org.b.d.a;

import org.b.c.e;
import org.b.d.aj;
import org.b.f.q;

final class k
        extends m {
    private aj b;

    public k(f paramf, aj paramaj) {
        super(paramf);
        this.b = paramaj;
    }

    public Object a(q paramq, Object paramObject, boolean paramBoolean) {
        Object localObject = this.a.a(paramObject);
        paramq = this.b.a(paramq, localObject, paramBoolean);
        if (paramq != localObject) {
            this.a.a(paramObject, paramq);
        }
        return paramq;
    }

    public void a(e parame, Object paramObject, boolean paramBoolean) {
        this.b.a(parame, paramObject, paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */