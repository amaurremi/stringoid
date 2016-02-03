package org.b.d.a;

import java.io.IOException;

import org.b.c;
import org.b.c.e;
import org.b.d.a;
import org.b.f.q;

public class l<T>
        extends a<T> {
    protected Class<T> a;
    protected m[] b;

    protected l(Class<T> paramClass, m[] paramArrayOfm) {
        this.a = paramClass;
        this.b = paramArrayOfm;
    }

    public T a(q paramq, T paramT, boolean paramBoolean) {
        int i = 0;
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        if (paramT == null) {
        }
        for (; ; ) {
            try {
                paramT = this.a.newInstance();
                paramq.s();
                if (i < this.b.length) {
                    m localm = this.b[i];
                    if (!localm.a.e()) {
                        paramq.u();
                    } else if ((!localm.a.f()) || (!paramq.h())) {
                        localm.a(paramq, paramT, false);
                    }
                }
            } catch (IOException paramq) {
                throw paramq;
                paramq.b();
                return paramT;
            } catch (Exception paramq) {
                throw new c(paramq);
            }
            continue;
            i += 1;
        }
    }

    public void a(e parame, T paramT, boolean paramBoolean) {
        if (paramT == null) {
            if (paramBoolean) {
                throw new c("attempted to write null");
            }
            parame.d();
            return;
        }
        for (; ; ) {
            int i;
            m localm;
            Object localObject;
            try {
                parame.c(this.b.length);
                m[] arrayOfm = this.b;
                int j = arrayOfm.length;
                i = 0;
                if (i >= j) {
                    break label183;
                }
                localm = arrayOfm[i];
                if (!localm.a.e()) {
                    parame.d();
                    break label191;
                }
                localObject = localm.a.a(paramT);
                if (localObject == null) {
                    if (localm.a.g()) {
                        throw new c(localm.a.b() + " cannot be null by @NotNullable");
                    }
                }
            } catch (IOException parame) {
                throw parame;
                parame.d();
            } catch (Exception parame) {
                throw new c(parame);
            }
            localm.a(parame, localObject, true);
            break label191;
            label183:
            parame.a();
            return;
            label191:
            i += 1;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */