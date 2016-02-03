package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class w
        extends a<int[]> {
    static final w a = new w();

    public static w a() {
        return a;
    }

    public void a(e parame, int[] paramArrayOfInt, boolean paramBoolean) {
        if (paramArrayOfInt == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramArrayOfInt.length);
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j) {
            parame.a(paramArrayOfInt[i]);
            i += 1;
        }
        parame.a();
    }

    public int[] a(q paramq, int[] paramArrayOfInt, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        if ((paramArrayOfInt != null) && (paramArrayOfInt.length == j)) {
        }
        for (; ; ) {
            int i = 0;
            while (i < j) {
                paramArrayOfInt[i] = paramq.l();
                i += 1;
            }
            paramArrayOfInt = new int[j];
        }
        paramq.b();
        return paramArrayOfInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */