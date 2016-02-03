package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public class m {
    private Interpolator a;
    private int b;
    private int[] c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private boolean h;
    private float i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private Drawable n;
    private n o;

    public m(Context paramContext) {
        a(paramContext);
    }

    private void a(Context paramContext) {
        paramContext = paramContext.getResources();
        this.a = new AccelerateInterpolator();
        this.b = paramContext.getInteger(g.spb_default_sections_count);
        this.c = new int[]{paramContext.getColor(e.spb_default_color)};
        this.d = Float.parseFloat(paramContext.getString(h.spb_default_speed));
        this.e = this.d;
        this.f = this.d;
        this.g = paramContext.getBoolean(d.spb_default_reversed);
        this.j = paramContext.getDimensionPixelSize(f.spb_default_stroke_separator_length);
        this.i = paramContext.getDimensionPixelOffset(f.spb_default_stroke_width);
        this.k = paramContext.getBoolean(d.spb_default_progressiveStart_activated);
        this.m = false;
    }

    public k a() {
        if (this.l) {
            this.n = j.a(this.c, this.i);
        }
        return new k(this.a, this.b, this.j, this.c, this.i, this.d, this.e, this.f, this.g, this.h, this.o, this.k, this.n, this.m, null);
    }

    public m a(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("The width must be >= 0");
        }
        this.i = paramFloat;
        return this;
    }

    public m a(int paramInt) {
        if (paramInt <= 0) {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        this.b = paramInt;
        return this;
    }

    public m a(Drawable paramDrawable) {
        this.n = paramDrawable;
        return this;
    }

    public m a(Interpolator paramInterpolator) {
        if (paramInterpolator == null) {
            throw new IllegalArgumentException("Interpolator can't be null");
        }
        this.a = paramInterpolator;
        return this;
    }

    public m a(boolean paramBoolean) {
        this.g = paramBoolean;
        return this;
    }

    public m a(int[] paramArrayOfInt) {
        if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
            throw new IllegalArgumentException("Your color array must not be empty");
        }
        this.c = paramArrayOfInt;
        return this;
    }

    public m b() {
        this.l = true;
        return this;
    }

    public m b(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.d = paramFloat;
        return this;
    }

    public m b(int paramInt) {
        if (paramInt < 0) {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        this.j = paramInt;
        return this;
    }

    public m b(boolean paramBoolean) {
        this.h = paramBoolean;
        return this;
    }

    public m c(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("progressiveStartSpeed must be >= 0");
        }
        this.e = paramFloat;
        return this;
    }

    public m c(int paramInt) {
        this.c = new int[]{paramInt};
        return this;
    }

    public m c(boolean paramBoolean) {
        this.k = paramBoolean;
        return this;
    }

    public m d(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("progressiveStopSpeed must be >= 0");
        }
        this.f = paramFloat;
        return this;
    }

    public m d(boolean paramBoolean) {
        this.m = paramBoolean;
        return this;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/fr/castorflex/android/smoothprogressbar/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */