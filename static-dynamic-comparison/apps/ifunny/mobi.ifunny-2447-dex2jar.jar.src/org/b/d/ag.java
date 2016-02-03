package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class ag
        extends a<short[]> {
    static final ag a = new ag();

    public static ag a() {
        return a;
    }

    public void a(e parame, short[] paramArrayOfShort, boolean paramBoolean) {
        if (paramArrayOfShort == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramArrayOfShort.length);
        int j = paramArrayOfShort.length;
        int i = 0;
        while (i < j) {
            parame.a(paramArrayOfShort[i]);
            i += 1;
        }
        parame.a();
    }

    public short[] a(q paramq, short[] paramArrayOfShort, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        short[] arrayOfShort;
        if (paramArrayOfShort != null) {
            arrayOfShort = paramArrayOfShort;
            if (paramArrayOfShort.length == j) {
            }
        } else {
            arrayOfShort = new short[j];
        }
        int i = 0;
        while (i < j) {
            arrayOfShort[i] = paramq.k();
            i += 1;
        }
        paramq.b();
        return arrayOfShort;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */