package org.b.d;

import org.b.c;
import org.b.f.q;

public class e
        extends a<boolean[]> {
    static final e a = new e();

    public static e a() {
        return a;
    }

    public void a(org.b.c.e parame, boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        if (paramArrayOfBoolean == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramArrayOfBoolean.length);
        int j = paramArrayOfBoolean.length;
        int i = 0;
        while (i < j) {
            parame.a(paramArrayOfBoolean[i]);
            i += 1;
        }
        parame.a();
    }

    public boolean[] a(q paramq, boolean[] paramArrayOfBoolean, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        boolean[] arrayOfBoolean;
        if (paramArrayOfBoolean != null) {
            arrayOfBoolean = paramArrayOfBoolean;
            if (paramArrayOfBoolean.length == j) {
            }
        } else {
            arrayOfBoolean = new boolean[j];
        }
        int i = 0;
        while (i < j) {
            arrayOfBoolean[i] = paramq.i();
            i += 1;
        }
        paramq.b();
        return arrayOfBoolean;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */