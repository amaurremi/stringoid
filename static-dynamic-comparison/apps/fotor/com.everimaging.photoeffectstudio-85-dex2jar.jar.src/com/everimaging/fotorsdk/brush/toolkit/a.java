package com.everimaging.fotorsdk.brush.toolkit;

import android.view.MotionEvent;

public class a {
    private a a;
    private int b;
    private int c;
    private float d;
    private float e;
    private float f;
    private boolean g;

    public a(a parama) {
        this.a = parama;
        this.b = 2;
        this.c = Integer.MAX_VALUE;
        this.g = false;
    }

    public void a() {
        this.b = 2;
        this.c = 2;
    }

    public boolean a(MotionEvent paramMotionEvent) {
        int i1 = 0;
        int k = paramMotionEvent.getPointerCount();
        int j = paramMotionEvent.getActionMasked();
        if (this.g) {
            if (j == 1) {
                this.g = false;
            }
            return true;
        }
        if (k < this.b) {
            return false;
        }
        int m = paramMotionEvent.getActionIndex();
        if ((j == 5) && (k <= this.c)) {
        }
        for (int i = 1; ; i = 0) {
            if (j == 6) {
                if (k == this.b) {
                    this.a.a();
                    return true;
                }
                if ((m < this.c) && (k > this.c)) {
                    this.g = true;
                    this.a.a();
                    return true;
                }
                if (k > this.c) {
                    break;
                }
                j = k - 1;
                i = 1;
            }
            for (; ; ) {
                int n = j;
                j = k;
                if (k > this.c) {
                    n = this.c;
                    j = n;
                }
                k = 0;
                float f1 = 0.0F;
                float f2 = 0.0F;
                if (k < j) {
                    if (k == m) {
                    }
                    for (; ; ) {
                        k += 1;
                        break;
                        f2 += paramMotionEvent.getX(k);
                        f1 += paramMotionEvent.getY(k);
                    }
                }
                float f3 = f2 / n;
                float f4 = f1 / n;
                f1 = 0.0F;
                f2 = 0.0F;
                k = i1;
                if (k < j) {
                    if (k == m) {
                    }
                    for (; ; ) {
                        k += 1;
                        break;
                        f2 += Math.abs(paramMotionEvent.getX(k) - f3);
                        f1 += Math.abs(paramMotionEvent.getY(k) - f4);
                    }
                }
                f2 /= n;
                f1 /= n;
                f2 *= 2.0F;
                f1 *= 2.0F;
                f1 = (float) Math.sqrt(f1 * f1 + f2 * f2);
                if (i != 0) {
                    this.d = f3;
                    this.e = f4;
                    this.f = f1;
                    this.a.a(this.d, this.e);
                    return true;
                }
                f1 /= this.f;
                f2 = this.d;
                float f5 = this.e;
                this.a.a(f1, f3 - f2, f4 - f5);
                return true;
                m = -1;
                j = k;
            }
        }
    }

    public void b() {
        this.b = 2;
        this.c = Integer.MAX_VALUE;
    }

    public static abstract interface a {
        public abstract void a();

        public abstract void a(float paramFloat1, float paramFloat2);

        public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/toolkit/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */