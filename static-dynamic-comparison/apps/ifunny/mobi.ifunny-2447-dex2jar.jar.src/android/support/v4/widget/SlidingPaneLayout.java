package android.support.v4.widget;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.as;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

import java.util.ArrayList;

public class SlidingPaneLayout
        extends ViewGroup {
    static final y a = new z();
    private int b;
    private int c;
    private Drawable d;
    private Drawable e;
    private final int f;
    private boolean g;
    private View h;
    private float i;
    private float j;
    private int k;
    private boolean l;
    private int m;
    private float n;
    private float o;
    private w p;
    private final ac q;
    private boolean r;
    private boolean s;
    private final Rect t;
    private final ArrayList<u> u;

    static {
        int i1 = Build.VERSION.SDK_INT;
        if (i1 >= 17) {
            a = new ab();
            return;
        }
        if (i1 >= 16) {
            a = new aa();
            return;
        }
    }

    private void a(float paramFloat) {
        boolean bool = f();
        Object localObject = (v) this.h.getLayoutParams();
        int i1;
        label43:
        int i2;
        if (((v) localObject).c) {
            if (bool) {
                i1 = ((v) localObject).rightMargin;
                if (i1 > 0) {
                    break label94;
                }
                i1 = 1;
                int i5 = getChildCount();
                i2 = 0;
                label52:
                if (i2 >= i5) {
                    return;
                }
                localObject = getChildAt(i2);
                if (localObject != this.h) {
                    break label99;
                }
            }
        }
        label94:
        label99:
        do {
            i2 += 1;
            break label52;
            i1 = ((v) localObject).leftMargin;
            break;
            i1 = 0;
            break label43;
            int i3 = (int) ((1.0F - this.j) * this.m);
            this.j = paramFloat;
            int i4 = i3 - (int) ((1.0F - paramFloat) * this.m);
            i3 = i4;
            if (bool) {
                i3 = -i4;
            }
            ((View) localObject).offsetLeftAndRight(i3);
        } while (i1 == 0);
        if (bool) {
        }
        for (float f1 = this.j - 1.0F; ; f1 = 1.0F - this.j) {
            a((View) localObject, f1, this.c);
            break;
        }
    }

    private void a(View paramView, float paramFloat, int paramInt) {
        v localv = (v) paramView.getLayoutParams();
        if ((paramFloat > 0.0F) && (paramInt != 0)) {
            i1 = (int) (((0xFF000000 & paramInt) >>> 24) * paramFloat);
            if (localv.d == null) {
                localv.d = new Paint();
            }
            localv.d.setColorFilter(new PorterDuffColorFilter(i1 << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
            if (bd.e(paramView) != 2) {
                bd.a(paramView, 2, localv.d);
            }
            d(paramView);
        }
        while (bd.e(paramView) == 0) {
            int i1;
            return;
        }
        if (localv.d != null) {
            localv.d.setColorFilter(null);
        }
        paramView = new u(this, paramView);
        this.u.add(paramView);
        bd.a(this, paramView);
    }

    private boolean a(View paramView, int paramInt) {
        boolean bool = false;
        if ((this.s) || (a(0.0F, paramInt))) {
            this.r = false;
            bool = true;
        }
        return bool;
    }

    private boolean b(View paramView, int paramInt) {
        if ((this.s) || (a(1.0F, paramInt))) {
            this.r = true;
            return true;
        }
        return false;
    }

    private static boolean c(View paramView) {
        if (bd.g(paramView)) {
        }
        do {
            return true;
            if (Build.VERSION.SDK_INT >= 18) {
                return false;
            }
            paramView = paramView.getBackground();
            if (paramView == null) {
                break;
            }
        } while (paramView.getOpacity() == -1);
        return false;
        return false;
    }

    private void d(View paramView) {
        a.a(this, paramView);
    }

    private boolean f() {
        return bd.f(this) == 1;
    }

    void a() {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            View localView = getChildAt(i1);
            if (localView.getVisibility() == 4) {
                localView.setVisibility(0);
            }
            i1 += 1;
        }
    }

    void a(View paramView) {
        boolean bool = f();
        int i1;
        int i2;
        label31:
        int i9;
        int i10;
        int i11;
        int i6;
        int i5;
        int i4;
        int i3;
        if (bool) {
            i1 = getWidth() - getPaddingRight();
            if (!bool) {
                break label123;
            }
            i2 = getPaddingLeft();
            i9 = getPaddingTop();
            i10 = getHeight();
            i11 = getPaddingBottom();
            if ((paramView == null) || (!c(paramView))) {
                break label136;
            }
            i6 = paramView.getLeft();
            i5 = paramView.getRight();
            i4 = paramView.getTop();
            i3 = paramView.getBottom();
        }
        int i7;
        View localView;
        for (; ; ) {
            int i12 = getChildCount();
            i7 = 0;
            if (i7 < i12) {
                localView = getChildAt(i7);
                if (localView != paramView) {
                    break label151;
                }
            }
            return;
            i1 = getPaddingLeft();
            break;
            label123:
            i2 = getWidth() - getPaddingRight();
            break label31;
            label136:
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        label151:
        if (bool) {
            i8 = i2;
            label159:
            int i13 = Math.max(i8, localView.getLeft());
            int i14 = Math.max(i9, localView.getTop());
            if (!bool) {
                break label271;
            }
            i8 = i1;
            label191:
            i8 = Math.min(i8, localView.getRight());
            int i15 = Math.min(i10 - i11, localView.getBottom());
            if ((i13 < i6) || (i14 < i4) || (i8 > i5) || (i15 > i3)) {
                break label277;
            }
        }
        label271:
        label277:
        for (int i8 = 4; ; i8 = 0) {
            localView.setVisibility(i8);
            i7 += 1;
            break;
            i8 = i1;
            break label159;
            i8 = i2;
            break label191;
        }
    }

    boolean a(float paramFloat, int paramInt) {
        if (!this.g) {
            return false;
        }
        boolean bool = f();
        v localv = (v) this.h.getLayoutParams();
        int i1;
        int i2;
        if (bool) {
            paramInt = getPaddingRight();
            i1 = localv.rightMargin;
            i2 = this.h.getWidth();
        }
        for (paramInt = (int) (getWidth() - (i1 + paramInt + this.k * paramFloat + i2)); this.q.a(this.h, paramInt, this.h.getTop()); paramInt = (int) (localv.leftMargin + paramInt + this.k * paramFloat)) {
            a();
            bd.c(this);
            return true;
            paramInt = getPaddingLeft();
        }
        return false;
    }

    public boolean b() {
        return b(this.h, 0);
    }

    boolean b(View paramView) {
        if (paramView == null) {
            return false;
        }
        paramView = (v) paramView.getLayoutParams();
        if ((this.g) && (paramView.c) && (this.i > 0.0F)) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public boolean c() {
        return a(this.h, 0);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return ((paramLayoutParams instanceof v)) && (super.checkLayoutParams(paramLayoutParams));
    }

    public void computeScroll() {
        if (this.q.a(true)) {
            if (!this.g) {
                this.q.f();
            }
        } else {
            return;
        }
        bd.c(this);
    }

    public boolean d() {
        return (!this.g) || (this.i == 1.0F);
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        Drawable localDrawable;
        if (f()) {
            localDrawable = this.e;
            if (getChildCount() <= 1) {
                break label53;
            }
        }
        label53:
        for (View localView = getChildAt(1); ; localView = null) {
            if ((localView != null) && (localDrawable != null)) {
                break label59;
            }
            return;
            localDrawable = this.d;
            break;
        }
        label59:
        int i3 = localView.getTop();
        int i4 = localView.getBottom();
        int i5 = localDrawable.getIntrinsicWidth();
        int i2;
        int i1;
        if (f()) {
            i2 = localView.getRight();
            i1 = i2 + i5;
        }
        for (; ; ) {
            localDrawable.setBounds(i2, i3, i1, i4);
            localDrawable.draw(paramCanvas);
            return;
            i1 = localView.getLeft();
            i2 = i1 - i5;
        }
    }

    protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
        v localv = (v) paramView.getLayoutParams();
        int i1 = paramCanvas.save(2);
        boolean bool;
        if ((this.g) && (!localv.b) && (this.h != null)) {
            paramCanvas.getClipBounds(this.t);
            if (f()) {
                this.t.left = Math.max(this.t.left, this.h.getRight());
                paramCanvas.clipRect(this.t);
            }
        } else {
            if (Build.VERSION.SDK_INT < 11) {
                break label140;
            }
            bool = super.drawChild(paramCanvas, paramView, paramLong);
        }
        for (; ; ) {
            paramCanvas.restoreToCount(i1);
            return bool;
            this.t.right = Math.min(this.t.right, this.h.getLeft());
            break;
            label140:
            if ((localv.c) && (this.i > 0.0F)) {
                if (!paramView.isDrawingCacheEnabled()) {
                    paramView.setDrawingCacheEnabled(true);
                }
                Bitmap localBitmap = paramView.getDrawingCache();
                if (localBitmap != null) {
                    paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localv.d);
                    bool = false;
                } else {
                    Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
                    bool = super.drawChild(paramCanvas, paramView, paramLong);
                }
            } else {
                if (paramView.isDrawingCacheEnabled()) {
                    paramView.setDrawingCacheEnabled(false);
                }
                bool = super.drawChild(paramCanvas, paramView, paramLong);
            }
        }
    }

    public boolean e() {
        return this.g;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new v();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new v(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return new v((ViewGroup.MarginLayoutParams) paramLayoutParams);
        }
        return new v(paramLayoutParams);
    }

    public int getCoveredFadeColor() {
        return this.c;
    }

    public int getParallaxDistance() {
        return this.m;
    }

    public int getSliderFadeColor() {
        return this.b;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.s = true;
        int i2 = this.u.size();
        int i1 = 0;
        while (i1 < i2) {
            ((u) this.u.get(i1)).run();
            i1 += 1;
        }
        this.u.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = false;
        int i1 = as.a(paramMotionEvent);
        if ((!this.g) && (i1 == 0) && (getChildCount() > 1)) {
            View localView = getChildAt(1);
            if (localView != null) {
                if (this.q.b(localView, (int) paramMotionEvent.getX(), (int) paramMotionEvent.getY())) {
                    break label108;
                }
            }
        }
        label108:
        for (boolean bool1 = true; ; bool1 = false) {
            this.r = bool1;
            if ((this.g) && ((!this.l) || (i1 == 0))) {
                break;
            }
            this.q.e();
            bool1 = super.onInterceptTouchEvent(paramMotionEvent);
            return bool1;
        }
        if ((i1 == 3) || (i1 == 1)) {
            this.q.e();
            return false;
        }
        switch (i1) {
        }
        label164:
        float f1;
        float f2;
        do {
            for (i1 = 0; ; i1 = 1) {
                if (!this.q.a(paramMotionEvent)) {
                    bool1 = bool2;
                    if (i1 == 0) {
                        break;
                    }
                }
                return true;
                this.l = false;
                f1 = paramMotionEvent.getX();
                f2 = paramMotionEvent.getY();
                this.n = f1;
                this.o = f2;
                if ((!this.q.b(this.h, (int) f1, (int) f2)) || (!b(this.h))) {
                    break label164;
                }
            }
            f2 = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            f2 = Math.abs(f2 - this.n);
            f1 = Math.abs(f1 - this.o);
        } while ((f2 <= this.q.d()) || (f1 <= f2));
        this.q.e();
        this.l = true;
        return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        boolean bool = f();
        int i3;
        label35:
        label46:
        int i5;
        int i4;
        if (bool) {
            this.q.a(2);
            i3 = paramInt3 - paramInt1;
            if (!bool) {
                break label154;
            }
            paramInt1 = getPaddingRight();
            if (!bool) {
                break label162;
            }
            paramInt4 = getPaddingLeft();
            i5 = getPaddingTop();
            i4 = getChildCount();
            if (this.s) {
                if ((!this.g) || (!this.r)) {
                    break label171;
                }
            }
        }
        View localView;
        label154:
        label162:
        label171:
        for (float f1 = 1.0F; ; f1 = 0.0F) {
            this.i = f1;
            int i1 = 0;
            for (paramInt2 = paramInt1; ; paramInt2 = paramInt3) {
                if (i1 >= i4) {
                    break label451;
                }
                localView = getChildAt(i1);
                if (localView.getVisibility() != 8) {
                    break;
                }
                paramInt3 = paramInt1;
                paramInt1 = paramInt2;
                paramInt2 = paramInt3;
                i1 += 1;
                paramInt3 = paramInt1;
                paramInt1 = paramInt2;
            }
            this.q.a(1);
            break;
            paramInt1 = getPaddingLeft();
            break label35;
            paramInt4 = getPaddingRight();
            break label46;
        }
        v localv = (v) localView.getLayoutParams();
        int i6 = localView.getMeasuredWidth();
        int i2;
        if (localv.b) {
            paramInt3 = localv.leftMargin;
            i2 = localv.rightMargin;
            i2 = Math.min(paramInt1, i3 - paramInt4 - this.f) - paramInt2 - (paramInt3 + i2);
            this.k = i2;
            if (bool) {
                paramInt3 = localv.rightMargin;
                label258:
                if (paramInt2 + paramInt3 + i2 + i6 / 2 <= i3 - paramInt4) {
                    break label388;
                }
                paramBoolean = true;
                label280:
                localv.c = paramBoolean;
                i2 = (int) (i2 * this.i);
                paramInt2 += paramInt3 + i2;
                this.i = (i2 / this.k);
                paramInt3 = 0;
                label321:
                if (!bool) {
                    break label435;
                }
                i2 = i3 - paramInt2 + paramInt3;
                paramInt3 = i2 - i6;
            }
        }
        for (; ; ) {
            localView.layout(paramInt3, i5, i2, localView.getMeasuredHeight() + i5);
            paramInt3 = localView.getWidth() + paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = paramInt3;
            break;
            paramInt3 = localv.leftMargin;
            break label258;
            label388:
            paramBoolean = false;
            break label280;
            if ((this.g) && (this.m != 0)) {
                paramInt3 = (int) ((1.0F - this.i) * this.m);
                paramInt2 = paramInt1;
                break label321;
            }
            paramInt3 = 0;
            paramInt2 = paramInt1;
            break label321;
            label435:
            paramInt3 = paramInt2 - paramInt3;
            i2 = paramInt3 + i6;
        }
        label451:
        if (this.s) {
            if (!this.g) {
                break label526;
            }
            if (this.m != 0) {
                a(this.i);
            }
            if (((v) this.h.getLayoutParams()).c) {
                a(this.h, this.i, this.b);
            }
        }
        for (; ; ) {
            a(this.h);
            this.s = false;
            return;
            label526:
            paramInt1 = 0;
            while (paramInt1 < i4) {
                a(getChildAt(paramInt1), 0.0F, this.b);
                paramInt1 += 1;
            }
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i3 = View.MeasureSpec.getMode(paramInt1);
        int i1 = View.MeasureSpec.getSize(paramInt1);
        int i2 = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        if (i3 != 1073741824) {
            if (isInEditMode()) {
                if (i3 == Integer.MIN_VALUE) {
                    paramInt2 = i1;
                    i1 = i2;
                }
            }
        }
        for (; ; ) {
            label85:
            boolean bool1;
            int i7;
            int i8;
            int i6;
            float f1;
            label137:
            View localView;
            v localv;
            switch (i1) {
                default:
                    paramInt1 = 0;
                    i3 = -1;
                    bool1 = false;
                    i7 = paramInt2 - getPaddingLeft() - getPaddingRight();
                    i8 = getChildCount();
                    if (i8 > 2) {
                        Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
                    }
                    this.h = null;
                    i6 = 0;
                    i2 = i7;
                    f1 = 0.0F;
                    if (i6 >= i8) {
                        break label618;
                    }
                    localView = getChildAt(i6);
                    localv = (v) localView.getLayoutParams();
                    if (localView.getVisibility() == 8) {
                        localv.c = false;
                        i4 = i2;
                        i2 = paramInt1;
                        paramInt1 = i4;
                    }
                    break;
            }
            float f2;
            for (; ; ) {
                i6 += 1;
                i4 = i2;
                i2 = paramInt1;
                paramInt1 = i4;
                break label137;
                if (i3 != 0) {
                    break label1106;
                }
                i1 = i2;
                paramInt2 = 300;
                break;
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                if (i2 != 0) {
                    break label1106;
                }
                if (isInEditMode()) {
                    if (i2 != 0) {
                        break label1106;
                    }
                    i2 = Integer.MIN_VALUE;
                    paramInt2 = i1;
                    paramInt1 = 300;
                    i1 = i2;
                    break;
                }
                throw new IllegalStateException("Height must not be UNSPECIFIED");
                paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
                i3 = paramInt1;
                break label85;
                i3 = getPaddingTop();
                i4 = getPaddingBottom();
                i2 = 0;
                i3 = paramInt1 - i3 - i4;
                paramInt1 = i2;
                break label85;
                f2 = f1;
                if (localv.a <= 0.0F) {
                    break label374;
                }
                f1 += localv.a;
                f2 = f1;
                if (localv.width != 0) {
                    break label374;
                }
                i4 = paramInt1;
                paramInt1 = i2;
                i2 = i4;
            }
            label374:
            int i4 = localv.leftMargin + localv.rightMargin;
            label410:
            int i5;
            label430:
            int i9;
            if (localv.width == -2) {
                i4 = View.MeasureSpec.makeMeasureSpec(i7 - i4, Integer.MIN_VALUE);
                if (localv.height != -2) {
                    break label574;
                }
                i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                localView.measure(i4, i5);
                i5 = localView.getMeasuredWidth();
                i9 = localView.getMeasuredHeight();
                i4 = paramInt1;
                if (i1 == Integer.MIN_VALUE) {
                    i4 = paramInt1;
                    if (i9 > paramInt1) {
                        i4 = Math.min(i9, i3);
                    }
                }
                paramInt1 = i2 - i5;
                if (paramInt1 >= 0) {
                    break label612;
                }
            }
            label574:
            label612:
            for (boolean bool2 = true; ; bool2 = false) {
                localv.b = bool2;
                if (localv.b) {
                    this.h = localView;
                }
                i2 = i4;
                bool1 = bool2 | bool1;
                f1 = f2;
                break;
                if (localv.width == -1) {
                    i4 = View.MeasureSpec.makeMeasureSpec(i7 - i4, 1073741824);
                    break label410;
                }
                i4 = View.MeasureSpec.makeMeasureSpec(localv.width, 1073741824);
                break label410;
                if (localv.height == -1) {
                    i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    break label430;
                }
                i5 = View.MeasureSpec.makeMeasureSpec(localv.height, 1073741824);
                break label430;
            }
            label618:
            if ((bool1) || (f1 > 0.0F)) {
                i6 = i7 - this.f;
                i4 = 0;
                if (i4 < i8) {
                    localView = getChildAt(i4);
                    if (localView.getVisibility() == 8) {
                    }
                    for (; ; ) {
                        i4 += 1;
                        break;
                        localv = (v) localView.getLayoutParams();
                        if (localView.getVisibility() != 8) {
                            if ((localv.width == 0) && (localv.a > 0.0F)) {
                                i1 = 1;
                                label716:
                                if (i1 == 0) {
                                    break label812;
                                }
                                i5 = 0;
                                label724:
                                if ((!bool1) || (localView == this.h)) {
                                    break label876;
                                }
                                if ((localv.width >= 0) || ((i5 <= i6) && (localv.a <= 0.0F))) {
                                    continue;
                                }
                                if (i1 == 0) {
                                    break label860;
                                }
                                if (localv.height != -2) {
                                    break label822;
                                }
                                i1 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                            }
                            for (; ; ) {
                                localView.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i1);
                                break;
                                i1 = 0;
                                break label716;
                                label812:
                                i5 = localView.getMeasuredWidth();
                                break label724;
                                label822:
                                if (localv.height == -1) {
                                    i1 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                } else {
                                    i1 = View.MeasureSpec.makeMeasureSpec(localv.height, 1073741824);
                                    continue;
                                    label860:
                                    i1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                                }
                            }
                            label876:
                            if (localv.a > 0.0F) {
                                if (localv.width == 0) {
                                    if (localv.height == -2) {
                                        i1 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                                    }
                                }
                                for (; ; ) {
                                    if (!bool1) {
                                        break label1022;
                                    }
                                    i9 = localv.leftMargin;
                                    i9 = i7 - (localv.rightMargin + i9);
                                    int i10 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                                    if (i5 == i9) {
                                        break;
                                    }
                                    localView.measure(i10, i1);
                                    break;
                                    if (localv.height == -1) {
                                        i1 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                    } else {
                                        i1 = View.MeasureSpec.makeMeasureSpec(localv.height, 1073741824);
                                        continue;
                                        i1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                                    }
                                }
                                label1022:
                                i9 = Math.max(0, i2);
                                localView.measure(View.MeasureSpec.makeMeasureSpec((int) (localv.a * i9 / f1) + i5, 1073741824), i1);
                            }
                        }
                    }
                }
            }
            setMeasuredDimension(paramInt2, getPaddingTop() + paramInt1 + getPaddingBottom());
            this.g = bool1;
            if ((this.q.a() != 0) && (!bool1)) {
                this.q.f();
            }
            return;
            label1106:
            paramInt2 = i1;
            i1 = i2;
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (SlidingPaneLayout.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        if (paramParcelable.a) {
            b();
        }
        for (; ; ) {
            this.r = paramParcelable.a;
            return;
            c();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SlidingPaneLayout.SavedState localSavedState = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
        if (e()) {
        }
        for (boolean bool = d(); ; bool = this.r) {
            localSavedState.a = bool;
            return localSavedState;
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramInt1 != paramInt3) {
            this.s = true;
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool1;
        if (!this.g) {
            bool1 = super.onTouchEvent(paramMotionEvent);
        }
        float f1;
        float f2;
        do {
            int i1;
            boolean bool2;
            float f3;
            float f4;
            do {
                do {
                    return bool1;
                    this.q.b(paramMotionEvent);
                    i1 = paramMotionEvent.getAction();
                    bool2 = true;
                    switch (i1 & 0xFF) {
                        default:
                            return true;
                        case 0:
                            f1 = paramMotionEvent.getX();
                            f2 = paramMotionEvent.getY();
                            this.n = f1;
                            this.o = f2;
                            return true;
                    }
                    bool1 = bool2;
                } while (!b(this.h));
                f1 = paramMotionEvent.getX();
                f2 = paramMotionEvent.getY();
                f3 = f1 - this.n;
                f4 = f2 - this.o;
                i1 = this.q.d();
                bool1 = bool2;
            } while (f3 * f3 + f4 * f4 >= i1 * i1);
            bool1 = bool2;
        } while (!this.q.b(this.h, (int) f1, (int) f2));
        a(this.h, 0);
        return true;
    }

    public void requestChildFocus(View paramView1, View paramView2) {
        super.requestChildFocus(paramView1, paramView2);
        if ((!isInTouchMode()) && (!this.g)) {
            if (paramView1 != this.h) {
                break label36;
            }
        }
        label36:
        for (boolean bool = true; ; bool = false) {
            this.r = bool;
            return;
        }
    }

    public void setCoveredFadeColor(int paramInt) {
        this.c = paramInt;
    }

    public void setPanelSlideListener(w paramw) {
        this.p = paramw;
    }

    public void setParallaxDistance(int paramInt) {
        this.m = paramInt;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable paramDrawable) {
        setShadowDrawableLeft(paramDrawable);
    }

    public void setShadowDrawableLeft(Drawable paramDrawable) {
        this.d = paramDrawable;
    }

    public void setShadowDrawableRight(Drawable paramDrawable) {
        this.e = paramDrawable;
    }

    @Deprecated
    public void setShadowResource(int paramInt) {
        setShadowDrawable(getResources().getDrawable(paramInt));
    }

    public void setShadowResourceLeft(int paramInt) {
        setShadowDrawableLeft(getResources().getDrawable(paramInt));
    }

    public void setShadowResourceRight(int paramInt) {
        setShadowDrawableRight(getResources().getDrawable(paramInt));
    }

    public void setSliderFadeColor(int paramInt) {
        this.b = paramInt;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */