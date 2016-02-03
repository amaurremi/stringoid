package com.everimaging.fotorsdk.algorithms.cpu;

public class b {
    private int[] a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private int g;
    private float h;

    public b(float paramFloat1, float paramFloat2, float paramFloat3, int[] paramArrayOfInt, int paramInt) {
        this.b = paramFloat1;
        this.c = paramFloat2;
        this.f = paramFloat3;
        this.a = paramArrayOfInt;
        this.g = paramInt;
    }

    public float a() {
        return this.f;
    }

    public float b() {
        return this.d;
    }

    public float c() {
        return this.h;
    }

    public void d() {
        float f2 = 1.0F;
        this.e = 0.0F;
        this.d = 0.0F;
        float f1 = 0.0F;
        float f3;
        if (f1 < 0.05F) {
            e();
            f3 = this.e - this.d;
            this.b = ((float) (this.b - 0.02D));
            this.c = ((float) (this.c + 0.02D));
            if ((this.b <= 0.0F) && (this.c >= 1.0F)) {
                this.d = 0.0F;
                f1 = f2;
            }
        }
        for (; ; ) {
            this.f *= f1;
            this.h = f1;
            return;
            if (this.b < 0.0F) {
                this.b = 0.0F;
            }
            f1 = f3;
            if (this.c <= 1.0F) {
                break;
            }
            this.c = 1.0F;
            f1 = f3;
            break;
        }
    }

    protected void e() {
        int m = 0;
        int k = (int) (this.g * this.b * 3.0F);
        int n = (int) (this.g * this.c * 3.0F);
        int i = 0;
        int j = 0;
        if (i < 256) {
            j += this.a[i];
            if (j <= k) {
            }
        }
        for (; ; ) {
            this.d = (i / 255.0F);
            i = 255;
            j = 0;
            for (; ; ) {
                k = m;
                if (i >= 0) {
                    j += this.a[i];
                    if (j > n) {
                        k = i;
                    }
                } else {
                    this.e = (k / 255.0F);
                    return;
                    i += 1;
                    break;
                }
                i -= 1;
            }
            i = 0;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/algorithms/cpu/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */