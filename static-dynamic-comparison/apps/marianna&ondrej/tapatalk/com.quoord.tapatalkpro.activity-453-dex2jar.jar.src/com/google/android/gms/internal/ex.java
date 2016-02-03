package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class ex
        extends Drawable
        implements Drawable.Callback {
    private int CA;
    private int CB = 0;
    private boolean CC;
    private b CD;
    private Drawable CE;
    private Drawable CF;
    private boolean CG;
    private boolean CH;
    private boolean CI;
    private int CJ;
    private boolean Cp = true;
    private int Cv = 0;
    private long Cw;
    private int Cx;
    private int Cy;
    private int Cz = 255;

    public ex(Drawable paramDrawable1, Drawable paramDrawable2) {
        this(null);
        Object localObject = paramDrawable1;
        if (paramDrawable1 == null) {
            localObject = a.eA();
        }
        this.CE = ((Drawable) localObject);
        ((Drawable) localObject).setCallback(this);
        paramDrawable1 = this.CD;
        paramDrawable1.CN |= ((Drawable) localObject).getChangingConfigurations();
        paramDrawable1 = paramDrawable2;
        if (paramDrawable2 == null) {
            paramDrawable1 = a.eA();
        }
        this.CF = paramDrawable1;
        paramDrawable1.setCallback(this);
        paramDrawable2 = this.CD;
        paramDrawable2.CN |= paramDrawable1.getChangingConfigurations();
    }

    ex(b paramb) {
        this.CD = new b(paramb);
    }

    public boolean canConstantState() {
        if (!this.CG) {
            if ((this.CE.getConstantState() == null) || (this.CF.getConstantState() == null)) {
                break label44;
            }
        }
        label44:
        for (boolean bool = true; ; bool = false) {
            this.CH = bool;
            this.CG = true;
            return this.CH;
        }
    }

    public void draw(Canvas paramCanvas) {
        int j = 1;
        int i = 1;
        int k = 0;
        switch (this.Cv) {
        }
        boolean bool;
        Drawable localDrawable1;
        Drawable localDrawable2;
        do {
            for (; ; ) {
                j = this.CB;
                bool = this.Cp;
                localDrawable1 = this.CE;
                localDrawable2 = this.CF;
                if (i == 0) {
                    break;
                }
                if ((!bool) || (j == 0)) {
                    localDrawable1.draw(paramCanvas);
                }
                if (j == this.Cz) {
                    localDrawable2.setAlpha(this.Cz);
                    localDrawable2.draw(paramCanvas);
                }
                return;
                this.Cw = SystemClock.uptimeMillis();
                this.Cv = 2;
                i = k;
            }
        } while (this.Cw < 0L);
        float f1 = (float) (SystemClock.uptimeMillis() - this.Cw) / this.CA;
        if (f1 >= 1.0F) {
        }
        for (i = j; ; i = 0) {
            if (i != 0) {
                this.Cv = 0;
            }
            f1 = Math.min(f1, 1.0F);
            float f2 = this.Cx;
            this.CB = ((int) (f1 * (this.Cy - this.Cx) + f2));
            break;
        }
        if (bool) {
            localDrawable1.setAlpha(this.Cz - j);
        }
        localDrawable1.draw(paramCanvas);
        if (bool) {
            localDrawable1.setAlpha(this.Cz);
        }
        if (j > 0) {
            localDrawable2.setAlpha(j);
            localDrawable2.draw(paramCanvas);
            localDrawable2.setAlpha(this.Cz);
        }
        invalidateSelf();
    }

    public Drawable ez() {
        return this.CF;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.CD.CM | this.CD.CN;
    }

    public Drawable.ConstantState getConstantState() {
        if (canConstantState()) {
            this.CD.CM = getChangingConfigurations();
            return this.CD;
        }
        return null;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.CE.getIntrinsicHeight(), this.CF.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.CE.getIntrinsicWidth(), this.CF.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.CI) {
            this.CJ = Drawable.resolveOpacity(this.CE.getOpacity(), this.CF.getOpacity());
            this.CI = true;
        }
        return this.CJ;
    }

    public void invalidateDrawable(Drawable paramDrawable) {
        if (gr.fu()) {
            paramDrawable = getCallback();
            if (paramDrawable != null) {
                paramDrawable.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if ((!this.CC) && (super.mutate() == this)) {
            if (!canConstantState()) {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
            this.CE.mutate();
            this.CF.mutate();
            this.CC = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect paramRect) {
        this.CE.setBounds(paramRect);
        this.CF.setBounds(paramRect);
    }

    public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {
        if (gr.fu()) {
            paramDrawable = getCallback();
            if (paramDrawable != null) {
                paramDrawable.scheduleDrawable(this, paramRunnable, paramLong);
            }
        }
    }

    public void setAlpha(int paramInt) {
        if (this.CB == this.Cz) {
            this.CB = paramInt;
        }
        this.Cz = paramInt;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter paramColorFilter) {
        this.CE.setColorFilter(paramColorFilter);
        this.CF.setColorFilter(paramColorFilter);
    }

    public void startTransition(int paramInt) {
        this.Cx = 0;
        this.Cy = this.Cz;
        this.CB = 0;
        this.CA = paramInt;
        this.Cv = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {
        if (gr.fu()) {
            paramDrawable = getCallback();
            if (paramDrawable != null) {
                paramDrawable.unscheduleDrawable(this, paramRunnable);
            }
        }
    }

    private static final class a
            extends Drawable {
        private static final a CK = new a();
        private static final a CL = new a(null);

        public void draw(Canvas paramCanvas) {
        }

        public Drawable.ConstantState getConstantState() {
            return CL;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int paramInt) {
        }

        public void setColorFilter(ColorFilter paramColorFilter) {
        }

        private static final class a
                extends Drawable.ConstantState {
            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return ex.a.eA();
            }
        }
    }

    static final class b
            extends Drawable.ConstantState {
        int CM;
        int CN;

        b(b paramb) {
            if (paramb != null) {
                this.CM = paramb.CM;
                this.CN = paramb.CN;
            }
        }

        public int getChangingConfigurations() {
            return this.CM;
        }

        public Drawable newDrawable() {
            return new ex(this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */