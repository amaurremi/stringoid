package com.everimaging.fotorsdk.brush.toolkit;

import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class b {
    private Interpolator a = null;
    private long b = 0L;
    private long c = 200L;
    private float[] d = new float[1];
    private float[] e = new float[1];
    private boolean f = true;

    public float a() {
        return this.e[0];
    }

    protected float a(float paramFloat, int paramInt) {
        return this.d[paramInt] + (this.e[paramInt] - this.d[paramInt]) * paramFloat;
    }

    public void a(float paramFloat) {
        this.d = new float[1];
        this.d[0] = paramFloat;
    }

    public void a(long paramLong) {
        this.c = paramLong;
    }

    public void a(Interpolator paramInterpolator) {
        this.a = paramInterpolator;
    }

    public void a(float[] paramArrayOfFloat) {
        this.d = ((float[]) paramArrayOfFloat.clone());
    }

    public float b(long paramLong) {
        return a(d(paramLong), 0);
    }

    public void b(float[] paramArrayOfFloat) {
        this.e = ((float[]) paramArrayOfFloat.clone());
    }

    public boolean b() {
        return this.f;
    }

    protected float[] b(float paramFloat) {
        int j = this.d.length;
        float[] arrayOfFloat = new float[j];
        int i = 0;
        while (i < j) {
            arrayOfFloat[i] = a(paramFloat, i);
            i += 1;
        }
        return arrayOfFloat;
    }

    public void c() {
        this.b = AnimationUtils.currentAnimationTimeMillis();
        this.f = false;
    }

    public float[] c(long paramLong) {
        return b(d(paramLong));
    }

    protected float d(long paramLong) {
        paramLong -= this.b;
        if (paramLong > this.c) {
            this.f = true;
            return 1.0F;
        }
        return this.a.getInterpolation((float) paramLong / (float) this.c);
    }

    public void d() {
        this.f = true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/brush/toolkit/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */