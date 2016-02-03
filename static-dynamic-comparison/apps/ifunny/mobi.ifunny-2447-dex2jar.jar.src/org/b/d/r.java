package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class r
        extends a<float[]> {
    static final r a = new r();

    public static r a() {
        return a;
    }

    public void a(e parame, float[] paramArrayOfFloat, boolean paramBoolean) {
        if (paramArrayOfFloat == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramArrayOfFloat.length);
        int j = paramArrayOfFloat.length;
        int i = 0;
        while (i < j) {
            parame.a(paramArrayOfFloat[i]);
            i += 1;
        }
        parame.a();
    }

    public float[] a(q paramq, float[] paramArrayOfFloat, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        float[] arrayOfFloat;
        if (paramArrayOfFloat != null) {
            arrayOfFloat = paramArrayOfFloat;
            if (paramArrayOfFloat.length == j) {
            }
        } else {
            arrayOfFloat = new float[j];
        }
        int i = 0;
        while (i < j) {
            arrayOfFloat[i] = paramq.o();
            i += 1;
        }
        paramq.b();
        return arrayOfFloat;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */