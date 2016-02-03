package com.everimaging.fotorsdk.editor.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.everimaging.fotorsdk.editor.R.color;
import com.everimaging.fotorsdk.editor.R.dimen;
import com.everimaging.fotorsdk.editor.R.drawable;
import com.everimaging.fotorsdk.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FotorStickerColorPicker
        extends FrameLayout {
    private int[] a;
    private List<b> b;
    private float c;
    private float d;
    private Drawable e;
    private Drawable f;
    private float g;
    private float h;
    private float i;
    private Paint j;
    private WindowManager k;
    private a l;
    private int m;
    private c n;
    private boolean o;
    private int p = 0;
    private Handler q = new Handler() {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
            }
            do {
                do {
                    return;
                } while (FotorStickerColorPicker.g(FotorStickerColorPicker.this) == null);
                FotorStickerColorPicker.g(FotorStickerColorPicker.this).invalidate();
                return;
            } while (FotorStickerColorPicker.g(FotorStickerColorPicker.this) == null);
            FotorStickerColorPicker.h(FotorStickerColorPicker.this).removeView(FotorStickerColorPicker.g(FotorStickerColorPicker.this));
            FotorStickerColorPicker.a(FotorStickerColorPicker.this, null);
        }
    };
    private Runnable r = new Runnable() {
        public void run() {
            while ((FotorStickerColorPicker.i(FotorStickerColorPicker.this)) && (FotorStickerColorPicker.f(FotorStickerColorPicker.this) > 0)) {
                FotorStickerColorPicker.a(FotorStickerColorPicker.this, 5);
                if (FotorStickerColorPicker.f(FotorStickerColorPicker.this) < 0) {
                    FotorStickerColorPicker.b(FotorStickerColorPicker.this, 0);
                }
                FotorStickerColorPicker.j(FotorStickerColorPicker.this).sendEmptyMessage(1);
                if (FotorStickerColorPicker.f(FotorStickerColorPicker.this) == 0) {
                    FotorStickerColorPicker.j(FotorStickerColorPicker.this).sendEmptyMessage(2);
                }
                Utils.sleep(5);
            }
        }
    };
    private Runnable s = new Runnable() {
        public void run() {
            while ((!FotorStickerColorPicker.i(FotorStickerColorPicker.this)) && (FotorStickerColorPicker.f(FotorStickerColorPicker.this) < 255)) {
                FotorStickerColorPicker.c(FotorStickerColorPicker.this, 5);
                if (FotorStickerColorPicker.f(FotorStickerColorPicker.this) > 255) {
                    FotorStickerColorPicker.b(FotorStickerColorPicker.this, 255);
                }
                FotorStickerColorPicker.j(FotorStickerColorPicker.this).sendEmptyMessage(1);
                Utils.sleep(5);
            }
        }
    };

    public FotorStickerColorPicker(Context paramContext) {
        this(paramContext, null);
    }

    public FotorStickerColorPicker(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public FotorStickerColorPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
    }

    private int a(float paramFloat) {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
            b localb = (b) localIterator.next();
            if (localb.a(paramFloat)) {
                return localb.b();
            }
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    private void a() {
        Resources localResources = getContext().getResources();
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        int[] arrayOfInt = new int[24];
        arrayOfInt[0] = R.color.fotor_feature_stickers_color1;
        arrayOfInt[1] = R.color.fotor_feature_stickers_color2;
        arrayOfInt[2] = R.color.fotor_feature_stickers_color3;
        arrayOfInt[3] = R.color.fotor_feature_stickers_color4;
        arrayOfInt[4] = R.color.fotor_feature_stickers_color5;
        arrayOfInt[5] = R.color.fotor_feature_stickers_color6;
        arrayOfInt[6] = R.color.fotor_feature_stickers_color7;
        arrayOfInt[7] = R.color.fotor_feature_stickers_color8;
        arrayOfInt[8] = R.color.fotor_feature_stickers_color9;
        arrayOfInt[9] = R.color.fotor_feature_stickers_color10;
        arrayOfInt[10] = R.color.fotor_feature_stickers_color11;
        arrayOfInt[11] = R.color.fotor_feature_stickers_color12;
        arrayOfInt[12] = R.color.fotor_feature_stickers_color13;
        arrayOfInt[13] = R.color.fotor_feature_stickers_color14;
        arrayOfInt[14] = R.color.fotor_feature_stickers_color15;
        arrayOfInt[15] = R.color.fotor_feature_stickers_color16;
        arrayOfInt[16] = R.color.fotor_feature_stickers_color17;
        arrayOfInt[17] = R.color.fotor_feature_stickers_color18;
        arrayOfInt[18] = R.color.fotor_feature_stickers_color19;
        arrayOfInt[19] = R.color.fotor_feature_stickers_color20;
        arrayOfInt[20] = R.color.fotor_feature_stickers_color21;
        arrayOfInt[21] = R.color.fotor_feature_stickers_color22;
        arrayOfInt[22] = R.color.fotor_feature_stickers_color23;
        arrayOfInt[23] = R.color.fotor_feature_stickers_color24;
        this.a = new int[arrayOfInt.length];
        int i1 = 0;
        while (i1 < arrayOfInt.length) {
            this.a[i1] = localResources.getColor(arrayOfInt[i1]);
            i1 += 1;
        }
        this.m = 0;
        this.c = localResources.getDimensionPixelSize(R.dimen.fotor_stickers_color_picker_height);
        this.d = (localResources.getDrawable(R.drawable.fotor_public_slider_thumb).getIntrinsicWidth() / 2.0F);
        this.e = localResources.getDrawable(R.drawable.fotor_stickers_slider_value_background);
        this.f = localResources.getDrawable(R.drawable.fotor_stickers_slider_value_color_area);
        this.j = new Paint();
        this.j.setAntiAlias(true);
        this.b = new ArrayList();
        this.k = ((WindowManager) getContext().getSystemService("window"));
    }

    private void a(float paramFloat, int paramInt) {
        this.o = true;
        int[] arrayOfInt = new int[2];
        getLocationOnScreen(arrayOfInt);
        float f1 = arrayOfInt[0];
        if (this.l != null) {
            this.l.a(f1 + paramFloat);
            this.l.a(paramInt);
            this.l.invalidate();
        }
        new Thread(this.r).start();
    }

    private void a(int paramInt1, int paramInt2) {
        this.b.clear();
        this.g = (this.c / 2.0F);
        this.h = (paramInt1 - this.d * 2.0F);
        if (this.a != null) {
            this.i = (this.h / this.a.length);
        }
        float f1 = (paramInt1 - this.h) / 2.0F;
        float f2 = (paramInt2 - this.c) / 2.0F;
        paramInt1 = 0;
        while (paramInt1 < this.a.length) {
            RectF localRectF = new RectF();
            localRectF.left = (this.i * paramInt1 + f1);
            localRectF.top = f2;
            localRectF.right = (localRectF.left + this.i);
            localRectF.bottom = (localRectF.top + this.c);
            b localb = new b(null);
            localb.a(localRectF);
            localb.a(this.a[paramInt1]);
            localb.b(paramInt1);
            this.b.add(localb);
            paramInt1 += 1;
        }
    }

    private float b(float paramFloat) {
        b localb1 = (b) this.b.get(0);
        b localb2 = (b) this.b.get(this.b.size() - 1);
        float f1 = paramFloat;
        if (paramFloat < localb1.a().left) {
            f1 = localb1.a().left;
        }
        paramFloat = f1;
        if (f1 > localb2.a().right) {
            paramFloat = localb2.a().right;
        }
        return paramFloat;
    }

    private void b(float paramFloat, int paramInt) {
        this.o = false;
        int[] arrayOfInt = new int[2];
        getLocationOnScreen(arrayOfInt);
        if (this.l == null) {
            this.l = new a(getContext());
            WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
            localLayoutParams.gravity = 51;
            localLayoutParams.height = this.e.getIntrinsicHeight();
            localLayoutParams.width = -1;
            localLayoutParams.flags = 920;
            localLayoutParams.format = -2;
            localLayoutParams.windowAnimations = 0;
            int i1 = (int) ((getHeight() - this.c) / 2.0F + arrayOfInt[1] - this.e.getIntrinsicHeight());
            localLayoutParams.x = 0;
            localLayoutParams.y = i1;
            this.k.addView(this.l, localLayoutParams);
        }
        float f1 = arrayOfInt[0];
        this.l.a(f1 + paramFloat);
        this.l.a(paramInt);
        this.l.invalidate();
        new Thread(this.s).start();
    }

    protected void onDraw(Canvas paramCanvas) {
        super.onDraw(paramCanvas);
        ((b) this.b.get(0)).a(paramCanvas);
        ((b) this.b.get(this.b.size() - 1)).a(paramCanvas);
        int i1 = 1;
        while (i1 < this.b.size() - 1) {
            ((b) this.b.get(i1)).a(paramCanvas);
            i1 += 1;
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
            a(paramInt1, paramInt2);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        float f1 = paramMotionEvent.getX();
        float f2 = b(f1);
        int i1 = a(f1);
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            if ((this.m != i1) && (this.n != null)) {
                this.m = i1;
                this.n.a(this.m);
            }
            return true;
            b(f2, i1);
            continue;
            a(f2, i1);
            continue;
            b(f2, i1);
        }
    }

    public void setColorPickerListener(c paramc) {
        this.n = paramc;
    }

    private class a
            extends TextView {
        private int b;
        private float c;

        public a(Context paramContext) {
            super();
            a();
        }

        @SuppressLint({"NewApi"})
        private void a() {
            setWillNotDraw(false);
            if (Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
        }

        public void a(float paramFloat) {
            this.c = paramFloat;
        }

        public void a(int paramInt) {
            this.b = paramInt;
        }

        @SuppressLint({"DrawAllocation"})
        protected void onDraw(Canvas paramCanvas) {
            super.onDraw(paramCanvas);
            int i = FotorStickerColorPicker.d(FotorStickerColorPicker.this).getIntrinsicWidth();
            int j = FotorStickerColorPicker.d(FotorStickerColorPicker.this).getIntrinsicHeight();
            Rect localRect = new Rect();
            localRect.left = ((int) (this.c - i / 2.0F));
            localRect.top = 0;
            localRect.right = (i + localRect.left);
            localRect.bottom = (localRect.top + j);
            FotorStickerColorPicker.e(FotorStickerColorPicker.this).setBounds(localRect);
            FotorStickerColorPicker.e(FotorStickerColorPicker.this).setAlpha(FotorStickerColorPicker.f(FotorStickerColorPicker.this));
            FotorStickerColorPicker.e(FotorStickerColorPicker.this).setColorFilter(this.b, PorterDuff.Mode.SRC_IN);
            FotorStickerColorPicker.e(FotorStickerColorPicker.this).draw(paramCanvas);
            FotorStickerColorPicker.d(FotorStickerColorPicker.this).setBounds(localRect);
            FotorStickerColorPicker.d(FotorStickerColorPicker.this).setAlpha(FotorStickerColorPicker.f(FotorStickerColorPicker.this));
            FotorStickerColorPicker.d(FotorStickerColorPicker.this).draw(paramCanvas);
        }
    }

    private class b {
        private RectF b;
        private int c;
        private int d;

        private b() {
        }

        public RectF a() {
            return this.b;
        }

        public void a(int paramInt) {
            this.c = paramInt;
        }

        public void a(Canvas paramCanvas) {
            FotorStickerColorPicker.a(FotorStickerColorPicker.this).setColor(this.c);
            RectF localRectF;
            if (this.d == 0) {
                localRectF = new RectF(this.b);
                localRectF.left += FotorStickerColorPicker.b(FotorStickerColorPicker.this);
                paramCanvas.drawCircle(localRectF.left, localRectF.top + FotorStickerColorPicker.b(FotorStickerColorPicker.this), FotorStickerColorPicker.b(FotorStickerColorPicker.this), FotorStickerColorPicker.a(FotorStickerColorPicker.this));
                paramCanvas.drawRect(localRectF, FotorStickerColorPicker.a(FotorStickerColorPicker.this));
                return;
            }
            if (this.d == FotorStickerColorPicker.c(FotorStickerColorPicker.this).size() - 1) {
                localRectF = new RectF(this.b);
                localRectF.right -= FotorStickerColorPicker.b(FotorStickerColorPicker.this);
                paramCanvas.drawCircle(localRectF.right, localRectF.top + FotorStickerColorPicker.b(FotorStickerColorPicker.this), FotorStickerColorPicker.b(FotorStickerColorPicker.this), FotorStickerColorPicker.a(FotorStickerColorPicker.this));
                paramCanvas.drawRect(localRectF, FotorStickerColorPicker.a(FotorStickerColorPicker.this));
                return;
            }
            paramCanvas.drawRect(this.b, FotorStickerColorPicker.a(FotorStickerColorPicker.this));
        }

        public void a(RectF paramRectF) {
            this.b = paramRectF;
        }

        public boolean a(float paramFloat) {
            if (this.d == 0) {
                if (paramFloat >= this.b.right) {
                }
            } else {
                do {
                    return true;
                    if (this.d != FotorStickerColorPicker.c(FotorStickerColorPicker.this).size() - 1) {
                        break;
                    }
                } while (paramFloat >= this.b.left);
            }
            while ((paramFloat >= this.b.right) || (paramFloat < this.b.left)) {
                return false;
            }
            return true;
        }

        public int b() {
            return this.c;
        }

        public void b(int paramInt) {
            this.d = paramInt;
        }
    }

    public static abstract interface c {
        public abstract void a(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/editor/widget/FotorStickerColorPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */