package com.everimaging.fotorsdk.collage.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

public class CollageSwitchMaskView
        extends View {
    private Rect a;
    private SparseArray<Region> b;
    private float c;
    private float d;
    private a e;

    public CollageSwitchMaskView(Context paramContext) {
        this(paramContext, null);
    }

    public CollageSwitchMaskView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public CollageSwitchMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private int a(float paramFloat1, float paramFloat2) {
        float f1 = this.a.left;
        float f2 = this.a.top;
        int i = 0;
        while (i < this.b.size()) {
            if (((Region) this.b.valueAt(i)).contains((int) (paramFloat1 - f1), (int) (paramFloat2 - f2))) {
                return this.b.keyAt(i);
            }
            i += 1;
        }
        return -1;
    }

    public void a() {
        setVisibility(8);
    }

    public void a(Rect paramRect, SparseArray<Region> paramSparseArray) {
        this.a = paramRect;
        this.b = paramSparseArray;
        setVisibility(0);
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        float f1 = paramMotionEvent.getRawX();
        float f2 = paramMotionEvent.getRawY();
        switch (paramMotionEvent.getAction()) {
        }
        for (; ; ) {
            return true;
            this.c = f1;
            this.d = f2;
            continue;
            if ((Math.sqrt((f1 - this.c) * (f1 - this.c) + (f2 - this.d) * (f2 - this.d)) < 10.0D) && (this.e != null)) {
                int i = a(f1, f2);
                if (i < 0) {
                    this.e.a();
                } else {
                    this.e.a(i);
                }
            }
        }
    }

    public void setSwitchMaskClickListener(a parama) {
        this.e = parama;
    }

    public static abstract interface a {
        public abstract void a();

        public abstract void a(int paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/widget/CollageSwitchMaskView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */