package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.aa;
import android.support.v4.view.as;
import android.support.v4.view.bd;
import android.support.v4.view.v;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class DrawerLayout
        extends ViewGroup {
    private static final int[] a = {16842931};
    private final g b;
    private int c;
    private int d;
    private float e;
    private Paint f;
    private final ac g;
    private final ac h;
    private final k i;
    private final k j;
    private int k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private h r;
    private float s;
    private float t;
    private Drawable u;
    private Drawable v;

    static String b(int paramInt) {
        if ((paramInt & 0x3) == 3) {
            return "LEFT";
        }
        if ((paramInt & 0x5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(paramInt);
    }

    private boolean d() {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            if (((i) getChildAt(i1).getLayoutParams()).c) {
                return true;
            }
            i1 += 1;
        }
        return false;
    }

    private boolean e() {
        return f() != null;
    }

    private View f() {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            View localView = getChildAt(i1);
            if ((g(localView)) && (j(localView))) {
                return localView;
            }
            i1 += 1;
        }
        return null;
    }

    private static boolean l(View paramView) {
        boolean bool2 = false;
        paramView = paramView.getBackground();
        boolean bool1 = bool2;
        if (paramView != null) {
            bool1 = bool2;
            if (paramView.getOpacity() == -1) {
                bool1 = true;
            }
        }
        return bool1;
    }

    private static boolean m(View paramView) {
        return (bd.d(paramView) != 4) && (bd.d(paramView) != 2);
    }

    public int a(View paramView) {
        int i1 = e(paramView);
        if (i1 == 3) {
            return this.n;
        }
        if (i1 == 5) {
            return this.o;
        }
        return 0;
    }

    View a() {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            View localView = getChildAt(i1);
            if (((i) localView.getLayoutParams()).d) {
                return localView;
            }
            i1 += 1;
        }
        return null;
    }

    View a(int paramInt) {
        int i1 = v.a(paramInt, bd.f(this));
        int i2 = getChildCount();
        paramInt = 0;
        while (paramInt < i2) {
            View localView = getChildAt(paramInt);
            if ((e(localView) & 0x7) == (i1 & 0x7)) {
                return localView;
            }
            paramInt += 1;
        }
        return null;
    }

    public void a(int paramInt1, int paramInt2) {
        paramInt2 = v.a(paramInt2, bd.f(this));
        Object localObject;
        if (paramInt2 == 3) {
            this.n = paramInt1;
            if (paramInt1 != 0) {
                if (paramInt2 != 3) {
                    break label74;
                }
                localObject = this.g;
                label33:
                ((ac) localObject).e();
            }
            switch (paramInt1) {
            }
        }
        label74:
        do {
            do {
                return;
                if (paramInt2 != 5) {
                    break;
                }
                this.o = paramInt1;
                break;
                localObject = this.h;
                break label33;
                localObject = a(paramInt2);
            } while (localObject == null);
            h((View) localObject);
            return;
            localObject = a(paramInt2);
        } while (localObject == null);
        i((View) localObject);
    }

    void a(int paramInt1, int paramInt2, View paramView) {
        int i1 = 1;
        int i2 = this.g.a();
        int i3 = this.h.a();
        paramInt1 = i1;
        i locali;
        if (i2 != 1) {
            if (i3 == 1) {
                paramInt1 = i1;
            }
        } else if ((paramView != null) && (paramInt2 == 0)) {
            locali = (i) paramView.getLayoutParams();
            if (locali.b != 0.0F) {
                break label124;
            }
            b(paramView);
        }
        for (; ; ) {
            if (paramInt1 != this.k) {
                this.k = paramInt1;
                if (this.r != null) {
                    this.r.a(paramInt1);
                }
            }
            return;
            if ((i2 == 2) || (i3 == 2)) {
                paramInt1 = 2;
                break;
            }
            paramInt1 = 0;
            break;
            label124:
            if (locali.b == 1.0F) {
                c(paramView);
            }
        }
    }

    void a(View paramView, float paramFloat) {
        if (this.r != null) {
            this.r.a(paramView, paramFloat);
        }
    }

    void a(boolean paramBoolean) {
        int i5 = getChildCount();
        int i2 = 0;
        int i1 = 0;
        while (i2 < i5) {
            View localView = getChildAt(i2);
            i locali = (i) localView.getLayoutParams();
            int i3 = i1;
            if (g(localView)) {
                if ((paramBoolean) && (!locali.c)) {
                    i3 = i1;
                }
            } else {
                i2 += 1;
                i1 = i3;
                continue;
            }
            int i4 = localView.getWidth();
            if (a(localView, 3)) {
                i1 |= this.g.a(localView, -i4, localView.getTop());
            }
            for (; ; ) {
                locali.c = false;
                i4 = i1;
                break;
                i1 |= this.h.a(localView, getWidth(), localView.getTop());
            }
        }
        this.i.a();
        this.j.a();
        if (i1 != 0) {
            invalidate();
        }
    }

    boolean a(View paramView, int paramInt) {
        return (e(paramView) & paramInt) == paramInt;
    }

    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        if ((paramInt > 0) || ((paramInt < 0) && (getChildCount() > 0))) {
            bd.c(paramView, 4);
            bd.a(paramView, this.b);
        }
        for (; ; ) {
            super.addView(paramView, paramInt, paramLayoutParams);
            return;
            bd.c(paramView, 1);
        }
    }

    public void b() {
        a(false);
    }

    void b(View paramView) {
        Object localObject = (i) paramView.getLayoutParams();
        if (((i) localObject).d) {
            ((i) localObject).d = false;
            if (this.r != null) {
                this.r.b(paramView);
            }
            localObject = getChildAt(0);
            if (localObject != null) {
                bd.c((View) localObject, 1);
            }
            bd.c(paramView, 4);
            if (hasWindowFocus()) {
                paramView = getRootView();
                if (paramView != null) {
                    paramView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void b(View paramView, float paramFloat) {
        i locali = (i) paramView.getLayoutParams();
        if (paramFloat == locali.b) {
            return;
        }
        locali.b = paramFloat;
        a(paramView, paramFloat);
    }

    void c(View paramView) {
        Object localObject = (i) paramView.getLayoutParams();
        if (!((i) localObject).d) {
            ((i) localObject).d = true;
            if (this.r != null) {
                this.r.a(paramView);
            }
            localObject = getChildAt(0);
            if (localObject != null) {
                bd.c((View) localObject, 4);
            }
            bd.c(paramView, 1);
            sendAccessibilityEvent(32);
            paramView.requestFocus();
        }
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return ((paramLayoutParams instanceof i)) && (super.checkLayoutParams(paramLayoutParams));
    }

    public void computeScroll() {
        int i2 = getChildCount();
        float f1 = 0.0F;
        int i1 = 0;
        while (i1 < i2) {
            f1 = Math.max(f1, ((i) getChildAt(i1).getLayoutParams()).b);
            i1 += 1;
        }
        this.e = f1;
        if ((this.g.a(true) | this.h.a(true))) {
            bd.c(this);
        }
    }

    float d(View paramView) {
        return ((i) paramView.getLayoutParams()).b;
    }

    protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
        int i7 = getHeight();
        boolean bool1 = f(paramView);
        int i3 = 0;
        int i5 = 0;
        int i1 = getWidth();
        int i8 = paramCanvas.save();
        int i2 = i1;
        int i4;
        View localView;
        if (bool1) {
            int i9 = getChildCount();
            i4 = 0;
            i3 = i5;
            for (; ; ) {
                if (i4 < i9) {
                    localView = getChildAt(i4);
                    if ((localView != paramView) && (localView.getVisibility() == 0) && (l(localView)) && (g(localView))) {
                        if (localView.getHeight() < i7) {
                            i5 = i3;
                            i2 = i1;
                            i4 += 1;
                            i1 = i2;
                            i3 = i5;
                            continue;
                        }
                        if (a(localView, 3)) {
                            i2 = localView.getRight();
                            if (i2 <= i3) {
                                break label534;
                            }
                        }
                    }
                }
            }
        }
        for (; ; ) {
            i5 = i2;
            i2 = i1;
            break;
            int i6 = localView.getLeft();
            i2 = i6;
            i5 = i3;
            if (i6 < i1) {
                break;
            }
            i2 = i1;
            i5 = i3;
            break;
            paramCanvas.clipRect(i3, 0, i1, getHeight());
            i2 = i1;
            boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restoreToCount(i8);
            if ((this.e > 0.0F) && (bool1)) {
                i1 = (int) (((this.d & 0xFF000000) >>> 24) * this.e);
                i4 = this.d;
                this.f.setColor(i1 << 24 | i4 & 0xFFFFFF);
                paramCanvas.drawRect(i3, 0.0F, i2, getHeight(), this.f);
            }
            do {
                return bool2;
                if ((this.u != null) && (a(paramView, 3))) {
                    i1 = this.u.getIntrinsicWidth();
                    i2 = paramView.getRight();
                    i3 = this.g.b();
                    f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
                    this.u.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
                    this.u.setAlpha((int) (255.0F * f1));
                    this.u.draw(paramCanvas);
                    return bool2;
                }
            } while ((this.v == null) || (!a(paramView, 5)));
            i1 = this.v.getIntrinsicWidth();
            i2 = paramView.getLeft();
            i3 = getWidth();
            i4 = this.h.b();
            float f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
            this.v.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
            this.v.setAlpha((int) (255.0F * f1));
            this.v.draw(paramCanvas);
            return bool2;
            label534:
            i2 = i3;
        }
    }

    int e(View paramView) {
        return v.a(((i) paramView.getLayoutParams()).a, bd.f(this));
    }

    boolean f(View paramView) {
        return ((i) paramView.getLayoutParams()).a == 0;
    }

    boolean g(View paramView) {
        return (v.a(((i) paramView.getLayoutParams()).a, bd.f(paramView)) & 0x7) != 0;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new i(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new i(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        if ((paramLayoutParams instanceof i)) {
            return new i((i) paramLayoutParams);
        }
        if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return new i((ViewGroup.MarginLayoutParams) paramLayoutParams);
        }
        return new i(paramLayoutParams);
    }

    public void h(View paramView) {
        if (!g(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
        }
        if (this.m) {
            paramView = (i) paramView.getLayoutParams();
            paramView.b = 1.0F;
            paramView.d = true;
        }
        for (; ; ) {
            invalidate();
            return;
            if (a(paramView, 3)) {
                this.g.a(paramView, 0, paramView.getTop());
            } else {
                this.h.a(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
            }
        }
    }

    public void i(View paramView) {
        if (!g(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
        }
        if (this.m) {
            paramView = (i) paramView.getLayoutParams();
            paramView.b = 0.0F;
            paramView.d = false;
        }
        for (; ; ) {
            invalidate();
            return;
            if (a(paramView, 3)) {
                this.g.a(paramView, -paramView.getWidth(), paramView.getTop());
            } else {
                this.h.a(paramView, getWidth(), paramView.getTop());
            }
        }
    }

    public boolean j(View paramView) {
        if (!g(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a drawer");
        }
        return ((i) paramView.getLayoutParams()).b > 0.0F;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool1 = false;
        int i1 = as.a(paramMotionEvent);
        boolean bool2 = this.g.a(paramMotionEvent);
        boolean bool3 = this.h.a(paramMotionEvent);
        switch (i1) {
            default:
                i1 = 0;
                if (((bool2 | bool3)) || (i1 != 0) || (d()) || (this.q)) {
                    bool1 = true;
                }
                return bool1;
            case 0:
                label63:
                float f1 = paramMotionEvent.getX();
                float f2 = paramMotionEvent.getY();
                this.s = f1;
                this.t = f2;
                if ((this.e <= 0.0F) || (!f(this.g.d((int) f1, (int) f2)))) {
                    break;
                }
        }
        for (i1 = 1; ; i1 = 0) {
            this.p = false;
            this.q = false;
            break label63;
            if (!this.g.d(3)) {
                break;
            }
            this.i.a();
            this.j.a();
            i1 = 0;
            break label63;
            a(true);
            this.p = false;
            this.q = false;
            break;
        }
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && (e())) {
            aa.b(paramKeyEvent);
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            paramKeyEvent = f();
            if ((paramKeyEvent != null) && (a(paramKeyEvent) == 0)) {
                b();
            }
            return paramKeyEvent != null;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.l = true;
        int i4 = paramInt3 - paramInt1;
        int i5 = getChildCount();
        paramInt3 = 0;
        if (paramInt3 < i5) {
            View localView = getChildAt(paramInt3);
            if (localView.getVisibility() == 8) {
            }
            i locali;
            for (; ; ) {
                paramInt3 += 1;
                break;
                locali = (i) localView.getLayoutParams();
                if (!f(localView)) {
                    break label113;
                }
                localView.layout(locali.leftMargin, locali.topMargin, locali.leftMargin + localView.getMeasuredWidth(), locali.topMargin + localView.getMeasuredHeight());
            }
            label113:
            int i6 = localView.getMeasuredWidth();
            int i7 = localView.getMeasuredHeight();
            int i1;
            float f1;
            label167:
            int i2;
            if (a(localView, 3)) {
                paramInt1 = -i6;
                i1 = (int) (i6 * locali.b) + paramInt1;
                f1 = (i6 + i1) / i6;
                if (f1 == locali.b) {
                    break label314;
                }
                i2 = 1;
                label181:
                switch (locali.a & 0x70) {
                    default:
                        localView.layout(i1, locali.topMargin, i6 + i1, i7 + locali.topMargin);
                        label241:
                        if (i2 != 0) {
                            b(localView, f1);
                        }
                        if (locali.b <= 0.0F) {
                            break;
                        }
                }
            }
            for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4) {
                localView.setVisibility(paramInt1);
                break;
                i1 = i4 - (int) (i6 * locali.b);
                f1 = (i4 - i1) / i6;
                break label167;
                label314:
                i2 = 0;
                break label181;
                paramInt1 = paramInt4 - paramInt2;
                localView.layout(i1, paramInt1 - locali.bottomMargin - localView.getMeasuredHeight(), i6 + i1, paramInt1 - locali.bottomMargin);
                break label241;
                int i8 = paramInt4 - paramInt2;
                int i3 = (i8 - i7) / 2;
                if (i3 < locali.topMargin) {
                    paramInt1 = locali.topMargin;
                }
                for (; ; ) {
                    localView.layout(i1, paramInt1, i6 + i1, i7 + paramInt1);
                    break;
                    paramInt1 = i3;
                    if (i3 + i7 > i8 - locali.bottomMargin) {
                        paramInt1 = i8 - locali.bottomMargin - i7;
                    }
                }
            }
        }
        this.l = false;
        this.m = false;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i3 = 300;
        int i6 = View.MeasureSpec.getMode(paramInt1);
        int i5 = View.MeasureSpec.getMode(paramInt2);
        int i2 = View.MeasureSpec.getSize(paramInt1);
        int i4 = View.MeasureSpec.getSize(paramInt2);
        int i1;
        label81:
        label97:
        View localView;
        if (i6 == 1073741824) {
            i1 = i2;
            if (i5 == 1073741824) {
            }
        } else {
            if (!isInEditMode()) {
                break label164;
            }
            if (i6 == Integer.MIN_VALUE) {
                i1 = i2;
                if (i5 != Integer.MIN_VALUE) {
                    break label142;
                }
                i2 = i4;
                i3 = i1;
                setMeasuredDimension(i3, i2);
                i4 = getChildCount();
                i1 = 0;
                if (i1 >= i4) {
                    return;
                }
                localView = getChildAt(i1);
                if (localView.getVisibility() != 8) {
                    break label175;
                }
            }
        }
        for (; ; ) {
            i1 += 1;
            break label97;
            i1 = i2;
            if (i6 != 0) {
                break;
            }
            i1 = 300;
            break;
            label142:
            i2 = i3;
            i3 = i1;
            if (i5 == 0) {
                break label81;
            }
            i2 = i4;
            i3 = i1;
            break label81;
            label164:
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            label175:
            i locali = (i) localView.getLayoutParams();
            if (f(localView)) {
                localView.measure(View.MeasureSpec.makeMeasureSpec(i3 - locali.leftMargin - locali.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i2 - locali.topMargin - locali.bottomMargin, 1073741824));
            } else {
                if (!g(localView)) {
                    break label378;
                }
                i5 = e(localView) & 0x7;
                if ((0x0 & i5) != 0) {
                    throw new IllegalStateException("Child drawer has absolute gravity " + b(i5) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                }
                localView.measure(getChildMeasureSpec(paramInt1, this.c + locali.leftMargin + locali.rightMargin, locali.width), getChildMeasureSpec(paramInt2, locali.topMargin + locali.bottomMargin, locali.height));
            }
        }
        label378:
        throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (DrawerLayout.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        if (paramParcelable.a != 0) {
            View localView = a(paramParcelable.a);
            if (localView != null) {
                h(localView);
            }
        }
        a(paramParcelable.b, 3);
        a(paramParcelable.c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
        int i2 = getChildCount();
        int i1 = 0;
        if (i1 < i2) {
            Object localObject = getChildAt(i1);
            if (!g((View) localObject)) {
            }
            do {
                i1 += 1;
                break;
                localObject = (i) ((View) localObject).getLayoutParams();
            } while (!((i) localObject).d);
            localSavedState.a = ((i) localObject).a;
        }
        localSavedState.b = this.n;
        localSavedState.c = this.o;
        return localSavedState;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        this.g.b(paramMotionEvent);
        this.h.b(paramMotionEvent);
        float f1;
        float f2;
        boolean bool;
        switch (paramMotionEvent.getAction() & 0xFF) {
            case 2:
            default:
                return true;
            case 0:
                f1 = paramMotionEvent.getX();
                f2 = paramMotionEvent.getY();
                this.s = f1;
                this.t = f2;
                this.p = false;
                this.q = false;
                return true;
            case 1:
                f2 = paramMotionEvent.getX();
                f1 = paramMotionEvent.getY();
                paramMotionEvent = this.g.d((int) f2, (int) f1);
                if ((paramMotionEvent != null) && (f(paramMotionEvent))) {
                    f2 -= this.s;
                    f1 -= this.t;
                    int i1 = this.g.d();
                    if (f2 * f2 + f1 * f1 < i1 * i1) {
                        paramMotionEvent = a();
                        if (paramMotionEvent != null) {
                            if (a(paramMotionEvent) == 2) {
                                bool = true;
                            }
                        }
                    }
                }
                break;
        }
        for (; ; ) {
            a(bool);
            this.p = false;
            return true;
            bool = false;
            continue;
            a(true);
            this.p = false;
            this.q = false;
            return true;
            bool = true;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
        super.requestDisallowInterceptTouchEvent(paramBoolean);
        this.p = paramBoolean;
        if (paramBoolean) {
            a(true);
        }
    }

    public void requestLayout() {
        if (!this.l) {
            super.requestLayout();
        }
    }

    public void setDrawerListener(h paramh) {
        this.r = paramh;
    }

    public void setDrawerLockMode(int paramInt) {
        a(paramInt, 3);
        a(paramInt, 5);
    }

    public void setScrimColor(int paramInt) {
        this.d = paramInt;
        invalidate();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/widget/DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */