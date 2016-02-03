package org.b.d;

import org.b.c;
import org.b.c.e;
import org.b.f.q;

public class m
        extends a<double[]> {
    static final m a = new m();

    public static m a() {
        return a;
    }

    public void a(e parame, double[] paramArrayOfDouble, boolean paramBoolean) {
        if (paramArrayOfDouble == null) {
            if (paramBoolean) {
                throw new c("Attempted to write null");
            }
            parame.d();
            return;
        }
        parame.c(paramArrayOfDouble.length);
        int j = paramArrayOfDouble.length;
        int i = 0;
        while (i < j) {
            parame.a(paramArrayOfDouble[i]);
            i += 1;
        }
        parame.a();
    }

    public double[] a(q paramq, double[] paramArrayOfDouble, boolean paramBoolean) {
        if ((!paramBoolean) && (paramq.h())) {
            return null;
        }
        int j = paramq.s();
        double[] arrayOfDouble;
        if (paramArrayOfDouble != null) {
            arrayOfDouble = paramArrayOfDouble;
            if (paramArrayOfDouble.length == j) {
            }
        } else {
            arrayOfDouble = new double[j];
        }
        int i = 0;
        while (i < j) {
            arrayOfDouble[i] = paramq.p();
            i += 1;
        }
        paramq.b();
        return arrayOfDouble;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/org/b/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */