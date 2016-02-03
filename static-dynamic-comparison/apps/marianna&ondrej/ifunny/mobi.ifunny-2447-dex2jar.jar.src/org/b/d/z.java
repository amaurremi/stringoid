package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class z
        extends a<long[]> {
    static final z a = new z();

    public static z a() {
        return a;
    }

    public void a(e parame, long[] paramArrayOfLong, boolean paramBoolean) {
        if (paramArrayOfLong == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramArrayOfLong.length);
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j) {
            parame.a(paramArrayOfLong[i]);
            i += 1;
        }
        parame.a();
    }

    public long[] a(q paramq, long[] paramArrayOfLong, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        long[] arrayOfLong;
        if (paramArrayOfLong != null) {
            arrayOfLong = paramArrayOfLong;
            if (paramArrayOfLong.length == j) {
            }
        } else {
            arrayOfLong = new long[j];
        }
        int i = 0;
        while (i < j) {
            arrayOfLong[i] = paramq.m();
            i += 1;
        }
        paramq.b();
        return arrayOfLong;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */