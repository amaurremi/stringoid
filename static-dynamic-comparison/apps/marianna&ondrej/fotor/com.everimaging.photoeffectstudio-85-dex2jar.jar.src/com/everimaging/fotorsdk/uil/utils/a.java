package com.everimaging.fotorsdk.uil.utils;

import android.opengl.GLES10;
import com.everimaging.fotorsdk.uil.core.assist.ViewScaleType;
import com.everimaging.fotorsdk.uil.core.assist.e;

public final class a {
    private static e a;

    static {
        int[] arrayOfInt = new int[1];
        GLES10.glGetIntegerv(3379, arrayOfInt, 0);
        int i = Math.max(arrayOfInt[0], 2048);
        a = new e(i, i);
    }

    public static int a(e parame) {
        int i = parame.a();
        int j = parame.b();
        int k = a.a();
        int m = a.b();
        return Math.max((int) Math.ceil(i / k), (int) Math.ceil(j / m));
    }

    public static int a(e parame1, e parame2, ViewScaleType paramViewScaleType, boolean paramBoolean) {
        int j = parame1.a();
        int i = parame1.b();
        int i1 = parame2.a();
        int i2 = parame2.b();
        int k = j / i1;
        int m = i / i2;
        switch (1. a[paramViewScaleType.ordinal()])
        {
            default:
                i = 1;
        }
        while (i < 1) {
            return 1;
            int n;
            if (paramBoolean) {
                n = 1;
                m = j;
                k = i;
                j = n;
                for (; ; ) {
                    if (m / 2 < i1) {
                        i = j;
                        if (k / 2 < i2) {
                            break;
                        }
                    }
                    m /= 2;
                    k /= 2;
                    j *= 2;
                }
            }
            i = Math.max(k, m);
            continue;
            if (paramBoolean) {
                n = 1;
                m = j;
                k = i;
                j = n;
                for (; ; ) {
                    i = j;
                    if (m / 2 < i1) {
                        break;
                    }
                    i = j;
                    if (k / 2 < i2) {
                        break;
                    }
                    m /= 2;
                    k /= 2;
                    j *= 2;
                }
            }
            i = Math.min(k, m);
        }
        return i;
    }

    public static e a(com.everimaging.fotorsdk.uil.core.imageaware.a parama, e parame) {
        int j = parama.a();
        int i = j;
        if (j <= 0) {
            i = parame.a();
        }
        int k = parama.b();
        j = k;
        if (k <= 0) {
            j = parame.b();
        }
        return new e(i, j);
    }

    public static float b(e parame1, e parame2, ViewScaleType paramViewScaleType, boolean paramBoolean) {
        int k = parame1.a();
        int m = parame1.b();
        int i = parame2.a();
        int j = parame2.b();
        float f1 = k / i;
        float f2 = m / j;
        if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f2)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f2))) {
            j = (int) (m / f1);
        }
        for (; ; ) {
            f2 = 1.0F;
            if ((paramBoolean) || (i >= k) || (j >= m)) {
                f1 = f2;
                if (paramBoolean) {
                    f1 = f2;
                    if (i != k) {
                        f1 = f2;
                        if (j == m) {
                        }
                    }
                }
            } else {
                f1 = i / k;
            }
            return f1;
            i = (int) (k / f2);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/uil/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */