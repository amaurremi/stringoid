package mobi.ifunny.view.a;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class a {
    private static float f = 8.0F;
    private static float g = 1.0F / b(1.0F);
    private int a;
    private final b b;
    private final b c;
    private final Interpolator d;
    private final boolean e;

    public a(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean) {
        this.d = paramInterpolator;
        this.e = paramBoolean;
        this.b = new b();
        this.c = new b();
        b.a(paramContext);
    }

    static float b(float paramFloat) {
        paramFloat = f * paramFloat;
        if (paramFloat < 1.0F) {
        }
        for (paramFloat -= 1.0F - (float) Math.exp(-paramFloat); ; paramFloat = (1.0F - (float) Math.exp(1.0F - paramFloat)) * (1.0F - 0.36787945F) + 0.36787945F) {
            return paramFloat * g;
        }
    }

    public final void a(float paramFloat) {
        this.b.a(paramFloat);
        this.c.a(paramFloat);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
        a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 0, 0);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10) {
        if ((this.e) && (!a())) {
            float f1 = b.c(this.b);
            float f2 = b.c(this.c);
            if ((Math.signum(paramInt3) == Math.signum(f1)) && (Math.signum(paramInt4) == Math.signum(f2))) {
                paramInt3 = (int) (f1 + paramInt3);
                paramInt4 = (int) (paramInt4 + f2);
            }
        }
        for (; ; ) {
            this.a = 1;
            this.b.a(paramInt1, paramInt3, paramInt5, paramInt6, paramInt9);
            this.c.a(paramInt2, paramInt4, paramInt7, paramInt8, paramInt10);
            return;
        }
    }

    public final void a(boolean paramBoolean) {
        b.a(this.b, b.a(this.c, paramBoolean));
    }

    public final boolean a() {
        return (b.a(this.b)) && (b.a(this.c));
    }

    public final int b() {
        return b.b(this.b);
    }

    public boolean c() {
        if (a()) {
            return false;
        }
        switch (this.a) {
        }
        for (; ; ) {
            return true;
            long l = AnimationUtils.currentAnimationTimeMillis() - b.d(this.b);
            int i = b.e(this.b);
            if (l < i) {
                float f1 = (float) l / i;
                if (this.d == null) {
                }
                for (f1 = b(f1); ; f1 = this.d.getInterpolation(f1)) {
                    this.b.b(f1);
                    this.c.b(f1);
                    break;
                }
            }
            d();
            continue;
            if ((!b.a(this.b)) && (!this.b.c()) && (!this.b.b())) {
                this.b.a();
            }
            if ((!b.a(this.c)) && (!this.c.c()) && (!this.c.b())) {
                this.c.a();
            }
        }
    }

    public void d() {
        this.b.a();
        this.c.a();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */