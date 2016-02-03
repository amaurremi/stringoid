package com.everimaging.fotorsdk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.everimaging.fotorsdk.R.attr;
import com.everimaging.fotorsdk.R.dimen;
import com.everimaging.fotorsdk.R.styleable;
import com.everimaging.fotorsdk.utils.DeviceUtils;
import com.everimaging.fotorsdk.utils.TypefaceUtils;
import com.everimaging.fotorsdk.utils.Utils;

public class FotorSliderPanelLayout
        extends FrameLayout
        implements SeekBar.OnSeekBarChangeListener {
    private FotorCustomSlider a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private Drawable g;
    private Drawable h;
    private Drawable i;
    private String j = null;
    private TextPaint k;
    private Typeface l;
    private boolean m;
    private int n = 0;
    private a o;
    private b p = null;
    private WindowManager q;
    private Handler r = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
            }
            do {
                do {
                    return;
                } while (FotorSliderPanelLayout.j(FotorSliderPanelLayout.this) == null);
                FotorSliderPanelLayout.j(FotorSliderPanelLayout.this).invalidate();
                return;
            } while (FotorSliderPanelLayout.j(FotorSliderPanelLayout.this) == null);
            FotorSliderPanelLayout.k(FotorSliderPanelLayout.this).removeView(FotorSliderPanelLayout.j(FotorSliderPanelLayout.this));
            FotorSliderPanelLayout.a(FotorSliderPanelLayout.this, null);
        }
    };
    private Runnable s = new Runnable() {
        public void run() {
            while ((FotorSliderPanelLayout.l(FotorSliderPanelLayout.this)) && (FotorSliderPanelLayout.e(FotorSliderPanelLayout.this) > 0)) {
                FotorSliderPanelLayout.a(FotorSliderPanelLayout.this, 5);
                if (FotorSliderPanelLayout.e(FotorSliderPanelLayout.this) < 0) {
                    FotorSliderPanelLayout.b(FotorSliderPanelLayout.this, 0);
                }
                FotorSliderPanelLayout.m(FotorSliderPanelLayout.this).sendEmptyMessage(1);
                if (FotorSliderPanelLayout.e(FotorSliderPanelLayout.this) == 0) {
                    FotorSliderPanelLayout.m(FotorSliderPanelLayout.this).sendEmptyMessage(2);
                }
                Utils.sleep(5);
            }
        }
    };
    private Runnable t = new Runnable() {
        public void run() {
            while ((!FotorSliderPanelLayout.l(FotorSliderPanelLayout.this)) && (FotorSliderPanelLayout.e(FotorSliderPanelLayout.this) < 255)) {
                FotorSliderPanelLayout.c(FotorSliderPanelLayout.this, 5);
                if (FotorSliderPanelLayout.e(FotorSliderPanelLayout.this) > 255) {
                    FotorSliderPanelLayout.b(FotorSliderPanelLayout.this, 255);
                }
                FotorSliderPanelLayout.m(FotorSliderPanelLayout.this).sendEmptyMessage(1);
                Utils.sleep(5);
            }
        }
    };

    public FotorSliderPanelLayout(Context paramContext) {
        this(paramContext, null);
    }

    public FotorSliderPanelLayout(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, R.attr.fotorDefaultSliderStyle);
    }

    public FotorSliderPanelLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FotorCustomSlider, paramInt, 0);
        paramInt = paramAttributeSet.getInt(0, 400);
        boolean bool = paramAttributeSet.getBoolean(1, true);
        Drawable localDrawable1 = paramAttributeSet.getDrawable(2);
        String str = paramAttributeSet.getString(4);
        Drawable localDrawable2 = paramAttributeSet.getDrawable(5);
        Drawable localDrawable3 = paramAttributeSet.getDrawable(3);
        int i1 = paramAttributeSet.getInt(6, 100);
        int i2 = paramAttributeSet.getInt(7, 0);
        this.h = localDrawable1;
        setIsShowValue(bool);
        setAdjustYDistance(paramInt);
        setTypeface(str);
        setThumb(localDrawable3);
        setProgressDrawable(localDrawable2);
        setMax(i1);
        setProgress(i2);
        paramAttributeSet.recycle();
        a(paramContext);
    }

    private void a(Context paramContext) {
        this.a = new FotorCustomSlider(paramContext);
        this.a.setAdjustYDistance(this.b);
        this.a.setThumb(this.g);
        this.a.setProgressDrawable(this.i);
        this.a.setMax(this.d);
        this.a.setProgress(this.c);
        this.a.setOnSeekBarChangeListener(this);
        this.a.setEnabled(false);
        this.a.setEnabled(true);
        if (this.g != null) {
            int i1 = (int) (this.g.getIntrinsicWidth() / 2.0F + 0.5D);
            this.a.setPadding(i1, 0, i1, 0);
        }
        addView(this.a, new FrameLayout.LayoutParams(-1, -2, 80));
        setWillNotDraw(false);
        this.f = false;
        this.k = new TextPaint();
        this.k.setAntiAlias(true);
        this.k.setColor(-16777216);
        float f1 = TypedValue.applyDimension(2, 12.0F, getResources().getDisplayMetrics());
        this.k.setTextSize(f1);
        this.q = ((WindowManager) paramContext.getSystemService("window"));
    }

    public void a() {
        this.m = true;
        if (this.p != null) {
            this.p.a(this.g.copyBounds());
        }
        new Thread(this.s).start();
    }

    public void b() {
        this.m = false;
        if (this.p == null) {
            this.p = new b(getContext());
            WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
            localLayoutParams.gravity = 51;
            localLayoutParams.height = this.h.getIntrinsicHeight();
            localLayoutParams.width = -1;
            localLayoutParams.flags = 920;
            localLayoutParams.format = -2;
            localLayoutParams.windowAnimations = 0;
            int i1 = this.a.getTop();
            int i2 = this.h.getIntrinsicHeight();
            float f1 = getResources().getDimension(R.dimen.fotor_slider_value_margin);
            int[] arrayOfInt = new int[2];
            getLocationOnScreen(arrayOfInt);
            i1 = (int) (i1 + arrayOfInt[1] - f1 - i2 + 0.5F);
            localLayoutParams.x = 0;
            localLayoutParams.y = i1;
            this.q.addView(this.p, localLayoutParams);
        }
        if (this.p != null) {
            this.p.a(this.g.copyBounds());
        }
        new Thread(this.t).start();
    }

    public SeekBar getSeekBar() {
        return this.a;
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {
        if (this.p != null) {
            this.p.a(this.g.copyBounds());
        }
        if (this.o != null) {
            this.o.a(this, paramInt, paramBoolean);
        }
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar) {
        if (this.o != null) {
            this.o.a(this);
        }
        this.f = true;
        b();
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar) {
        if (this.o != null) {
            this.o.b(this);
        }
        this.f = false;
        a();
    }

    public void setAdjustYDistance(int paramInt) {
        int i1 = paramInt;
        if (paramInt == 0) {
            i1 = DeviceUtils.getScreenHeight();
        }
        this.b = i1;
    }

    public void setDisplayValue(String paramString) {
        this.j = paramString;
    }

    public void setEnabled(boolean paramBoolean) {
        this.a.setEnabled(paramBoolean);
        super.setEnabled(paramBoolean);
    }

    public void setIsShowValue(boolean paramBoolean) {
        this.e = paramBoolean;
    }

    public void setMax(int paramInt) {
        this.d = paramInt;
        if (this.a != null) {
            this.a.setMax(paramInt);
        }
    }

    public void setOnChangedListener(a parama) {
        this.o = parama;
    }

    public void setOnTouchListener(View.OnTouchListener paramOnTouchListener) {
        this.a.setOnTouchListener(paramOnTouchListener);
    }

    public void setProgress(int paramInt) {
        this.c = paramInt;
        if (this.a != null) {
            this.a.setProgress(paramInt);
        }
    }

    public void setProgressDrawable(Drawable paramDrawable) {
        this.i = paramDrawable;
        if (this.a != null) {
            this.a.setProgressDrawable(paramDrawable);
        }
    }

    public void setThumb(Drawable paramDrawable) {
        this.g = paramDrawable;
        if (this.a != null) {
            this.a.setThumb(paramDrawable);
        }
    }

    public void setTypeface(String paramString) {
        if (paramString != null) {
        }
        try {
            this.l = TypefaceUtils.createFromAssetPath(getContext(), paramString);
            return;
        } catch (Throwable paramString) {
        }
    }

    public static abstract interface a {
        public abstract void a(FotorSliderPanelLayout paramFotorSliderPanelLayout);

        public abstract void a(FotorSliderPanelLayout paramFotorSliderPanelLayout, int paramInt, boolean paramBoolean);

        public abstract void b(FotorSliderPanelLayout paramFotorSliderPanelLayout);
    }

    private class b
            extends ImageView {
        private Rect b = new Rect();

        public b(Context paramContext) {
            super();
        }

        public void a(Rect paramRect) {
            this.b = paramRect;
            invalidate();
        }

        @SuppressLint({"DrawAllocation"})
        protected void onDraw(Canvas paramCanvas) {
            super.onDraw(paramCanvas);
            if (((FotorSliderPanelLayout.a(FotorSliderPanelLayout.this)) && (FotorSliderPanelLayout.b(FotorSliderPanelLayout.this)) && (FotorSliderPanelLayout.c(FotorSliderPanelLayout.this) != null) && (FotorSliderPanelLayout.d(FotorSliderPanelLayout.this) != null)) || ((FotorSliderPanelLayout.e(FotorSliderPanelLayout.this) > 0) && (FotorSliderPanelLayout.f(FotorSliderPanelLayout.this) != null))) {
                Object localObject = new int[2];
                FotorSliderPanelLayout.g(FotorSliderPanelLayout.this).getLocationOnScreen((int[]) localObject);
                float f1 = localObject[0] + FotorSliderPanelLayout.g(FotorSliderPanelLayout.this).getPaddingLeft() + this.b.left;
                float f2 = this.b.width() / 2.0F;
                int k = FotorSliderPanelLayout.g(FotorSliderPanelLayout.this).getThumbOffset();
                int i = FotorSliderPanelLayout.d(FotorSliderPanelLayout.this).getIntrinsicWidth();
                int j = FotorSliderPanelLayout.d(FotorSliderPanelLayout.this).getIntrinsicHeight();
                k = (int) (f1 + f2 - i / 2.0F - k + 0.5F);
                FotorSliderPanelLayout.d(FotorSliderPanelLayout.this).setAlpha(FotorSliderPanelLayout.e(FotorSliderPanelLayout.this));
                localObject = new Rect();
                ((Rect) localObject).left = k;
                ((Rect) localObject).top = 0;
                ((Rect) localObject).right = (k + i);
                ((Rect) localObject).bottom = j;
                FotorSliderPanelLayout.d(FotorSliderPanelLayout.this).setBounds((Rect) localObject);
                FotorSliderPanelLayout.d(FotorSliderPanelLayout.this).draw(paramCanvas);
                FotorSliderPanelLayout.i(FotorSliderPanelLayout.this).setTypeface(FotorSliderPanelLayout.h(FotorSliderPanelLayout.this));
                FotorSliderPanelLayout.i(FotorSliderPanelLayout.this).setAlpha(FotorSliderPanelLayout.e(FotorSliderPanelLayout.this));
                localObject = new StaticLayout(FotorSliderPanelLayout.f(FotorSliderPanelLayout.this), FotorSliderPanelLayout.i(FotorSliderPanelLayout.this), i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
                f2 = ((StaticLayout) localObject).getWidth();
                f1 = f2;
                if (f2 > i) {
                    f1 = i;
                }
                f2 = j * 0.08F;
                float f3 = (j * 0.73399997F - f2 - ((StaticLayout) localObject).getHeight()) / 2.0F;
                float f4 = k;
                f1 = (i - f1) / 2.0F;
                paramCanvas.save();
                paramCanvas.translate(f1 + f4, f2 + f3);
                ((StaticLayout) localObject).draw(paramCanvas);
                paramCanvas.restore();
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/FotorSliderPanelLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */