package com.emilsjolander.components.StickyScrollViewItems;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StickyScrollView
        extends ScrollViewEx
        implements g {
    private static final String d = StickyScrollView.class.getSimpleName();
    private int[] A = new int[2];
    private Rect B = new Rect();
    private k C = k.a;
    private StickyScrollView.SavedState D;
    uk.co.chrisjenx.paralloid.c c;
    private b e;
    private ViewPropertyAnimator f;
    private final int g;
    private View h;
    private boolean i;
    private boolean j;
    private f k;
    private j l;
    private Queue<MotionEvent> m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private MotionEvent s;
    private MotionEvent t;
    private VelocityTracker u;
    private int v;
    private float w;
    private float x;
    private float y;
    private float z;

    public StickyScrollView(Context paramContext) {
        this(paramContext, null);
    }

    public StickyScrollView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 16842880);
    }

    public StickyScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, d.StickyScrollView, paramInt, 0);
        this.p = paramAttributeSet.getDimensionPixelSize(d.StickyScrollView_stickOffsetY, 0);
        this.q = paramAttributeSet.getResourceId(d.StickyScrollView_stickyView, 0);
        paramAttributeSet.recycle();
        this.g = paramContext.getResources().getInteger(17694721);
    }

    private int a(View paramView) {
        int i1 = paramView.getTop();
        while (paramView.getParent() != getChildAt(0)) {
            paramView = (View) paramView.getParent();
            i1 += paramView.getTop();
        }
        return i1;
    }

    private MotionEvent a(f paramf, MotionEvent paramMotionEvent) {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((paramMotionEvent.getX() == paramMotionEvent.getRawX()) && (paramMotionEvent.getY() == paramMotionEvent.getRawY())) {
            paramf.getLocationOnScreen(this.A);
            localMotionEvent.offsetLocation(-this.A[0], -this.A[1]);
        }
        return localMotionEvent;
    }

    private void a(float paramFloat) {
        a(k.g, null);
        f((int) -paramFloat);
    }

    private void a(MotionEvent paramMotionEvent) {
        if (this.s != null) {
            this.s.recycle();
        }
        this.s = MotionEvent.obtain(paramMotionEvent);
    }

    private void a(View paramView, List<f> paramList, boolean paramBoolean) {
        if ((paramBoolean) && ((paramView instanceof f))) {
            paramList.add((f) paramView);
        }
        for (; ; ) {
            return;
            if ((paramView instanceof ViewGroup)) {
                paramView = (ViewGroup) paramView;
                int i2 = paramView.getChildCount();
                int i1 = 0;
                while (i1 < i2) {
                    a(paramView.getChildAt(i1), paramList, true);
                    i1 += 1;
                }
            }
        }
    }

    private void a(f paramf) {
        a(k.e, paramf);
    }

    private void a(f paramf, float paramFloat) {
        a(k.f, paramf);
        paramf.a((int) -paramFloat);
    }

    private void a(k paramk, f paramf) {
        if (this.k != null) {
            this.k.setStickyMainContentScrollListener(null);
        }
        switch (h.a[this.C.ordinal()]) {
        }
        for (; ; ) {
            if (this.t != null) {
                this.t.recycle();
                this.t = null;
            }
            this.k = paramf;
            if (this.k != null) {
                this.k.setStickyMainContentScrollListener(this);
            }
            this.C = paramk;
            return;
            p();
            continue;
            q();
            continue;
            r();
        }
    }

    private void a(Queue<MotionEvent> paramQueue) {
        Iterator localIterator = paramQueue.iterator();
        while (localIterator.hasNext()) {
            ((MotionEvent) localIterator.next()).recycle();
        }
        paramQueue.clear();
    }

    private boolean a(ViewGroup paramViewGroup) {
        if (((paramViewGroup instanceof f)) && (paramViewGroup.canScrollVertically(0))) {
            return true;
        }
        int i2 = paramViewGroup.getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            View localView = paramViewGroup.getChildAt(i1);
            if (((localView instanceof f)) && (localView.canScrollVertically(0))) {
                return true;
            }
            if (((localView instanceof ViewGroup)) && (a((ViewGroup) localView))) {
                return true;
            }
            i1 += 1;
        }
        return false;
    }

    private void b(f paramf) {
        a(k.c, paramf);
        this.u = c();
        this.v = getActivePointerId();
        this.t = MotionEvent.obtain(this.s);
        f();
    }

    private boolean b(MotionEvent paramMotionEvent) {
        switch (h.a[this.C.ordinal()]) {
            default:
                return false;
            case 1:
                if (this.m.size() > 0) {
                    Iterator localIterator = this.m.iterator();
                    while (localIterator.hasNext()) {
                        MotionEvent localMotionEvent = (MotionEvent) localIterator.next();
                        this.k.a(localMotionEvent);
                    }
                    a(this.m);
                }
                return this.k.a(a(this.k, paramMotionEvent));
            case 2:
                if (this.t != null) {
                    this.k.a(this.u, this.t, paramMotionEvent, getActivePointerId());
                    this.t.recycle();
                    this.t = null;
                    this.u = null;
                    this.v = -1;
                    return true;
                }
                return this.k.a(paramMotionEvent);
        }
        if (this.t != null) {
            b(this.u, this.t, paramMotionEvent, this.v);
            this.t.recycle();
            this.t = null;
            this.u = null;
            this.v = -1;
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    private void c(int paramInt1, int paramInt2) {
        if ((paramInt1 > paramInt2) && (this.C != k.f) && (!canScrollVertically(1))) {
            f localf = a(this, false, 1, getWidth() / 2, getHeight() / 2);
            if (localf != null) {
                d();
                a(localf, getCurrentFlingVelocity());
            }
        }
    }

    private void c(f paramf) {
        a(k.d, paramf);
        this.u = paramf.c();
        this.v = paramf.getActivePointerId();
        this.t = MotionEvent.obtain(this.s);
        paramf.b();
    }

    private int getStickTranslation() {
        if (this.n) {
        }
        for (int i1 = 0; ; i1 = getPaddingTop()) {
            return i1 - a(this.h) + getScrollY() + this.p;
        }
    }

    private void h() {
        this.h.getLocationOnScreen(this.A);
        this.B.set(this.A[0], this.A[1], this.A[0] + this.h.getWidth(), this.A[1] + this.h.getHeight());
    }

    private void i() {
        int i2 = a(this.h);
        int i3 = getScrollY();
        int i1;
        if (this.n) {
            i1 = 0;
            if (i1 + (i2 - i3) > this.p) {
                break label81;
            }
            if (!this.i) {
                k();
            }
        }
        for (; ; ) {
            if ((this.i) && (!this.j)) {
                this.h.setTranslationY(getStickTranslation());
            }
            return;
            i1 = getPaddingTop();
            break;
            label81:
            if (this.i) {
                l();
            }
        }
    }

    private void j() {
        this.j = false;
        if (this.f != null) {
            this.f.cancel();
            this.f = null;
        }
        if (this.l != null) {
            this.l.b_(this.j);
        }
        this.h.setTranslationY(0.0F);
    }

    private void k() {
        this.i = true;
        j();
        this.h.bringToFront();
        requestLayout();
        invalidate();
    }

    private void l() {
        j();
        this.i = false;
    }

    private void m() {
        this.h = findViewById(this.q);
    }

    private void n() {
        a(k.a, this.k);
    }

    private void o() {
        a(k.b, null);
    }

    private void p() {
        this.k.d();
    }

    private void q() {
        d();
    }

    private void r() {
        a(this.m);
    }

    protected f a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
        int i2 = 1;
        if ((paramView instanceof ViewGroup)) {
            ViewGroup localViewGroup = (ViewGroup) paramView;
            int i3 = paramView.getScrollX();
            int i4 = paramView.getScrollY();
            int i1 = localViewGroup.getChildCount() - 1;
            while (i1 >= 0) {
                Object localObject = localViewGroup.getChildAt(i1);
                if ((paramInt2 + i3 >= ((View) localObject).getLeft()) && (paramInt2 + i3 < ((View) localObject).getRight()) && (paramInt3 + i4 >= ((View) localObject).getTop()) && (paramInt3 + i4 < ((View) localObject).getBottom())) {
                    localObject = a((View) localObject, true, paramInt1, paramInt2 + i3 - ((View) localObject).getLeft(), paramInt3 + i4 - ((View) localObject).getTop());
                    if (localObject != null) {
                        return (f) localObject;
                    }
                }
                i1 -= 1;
            }
        }
        if (((paramView instanceof f)) && (paramBoolean)) {
            paramInt2 = i2;
            if (paramInt1 != 0) {
                if (!paramView.canScrollVertically(paramInt1)) {
                    break label193;
                }
            }
        }
        label193:
        for (paramInt2 = i2; paramInt2 != 0; paramInt2 = 0) {
            return (f) paramView;
        }
        return null;
    }

    public void a() {
        this.m = new LinkedList();
        this.r = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.c = uk.co.chrisjenx.paralloid.c.a(this);
    }

    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if ((paramInt1 <= paramInt2) && (paramInt1 == 0) && (((paramInt3 == -1) && (paramInt4 == -1)) || ((paramInt3 > paramInt4) && (paramInt3 == 0) && (!canScrollVertically(1)) && (!paramView.canScrollVertically(-1))))) {
            c((f) paramView);
        }
        if (this.l != null) {
            this.l.a(paramView, paramInt1, paramInt2);
        }
    }

    public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat) {
        if ((paramInt1 <= paramInt2) && (paramInt1 == 0) && (((paramInt3 == -1) && (paramInt4 == -1)) || ((paramInt3 > paramInt4) && (paramInt3 == 0) && (this.C != k.g) && (!canScrollVertically(1)) && (!paramView.canScrollVertically(-1))))) {
            this.C = k.f;
            a(paramFloat);
        }
        if (this.l != null) {
            this.l.a(paramView, paramInt1, paramInt2);
        }
    }

    public void a(View paramView, uk.co.chrisjenx.paralloid.c.c paramc, float paramFloat) {
        this.c.a(paramView, paramc, paramFloat);
    }

    public void addView(View paramView) {
        super.addView(paramView);
        m();
    }

    public void addView(View paramView, int paramInt) {
        super.addView(paramView, paramInt);
        m();
    }

    public void addView(View paramView, int paramInt1, int paramInt2) {
        super.addView(paramView, paramInt1, paramInt2);
        m();
    }

    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        super.addView(paramView, paramInt, paramLayoutParams);
        m();
    }

    public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        super.addView(paramView, paramLayoutParams);
        m();
    }

    public void b() {
        if (a(this)) {
            scrollTo(getScrollX(), getScrollRange());
        }
    }

    public void g() {
        a(k.a, null);
        if (canScrollVertically(1)) {
            Object localObject = new ArrayList();
            a(this, (List) localObject, false);
            localObject = ((List) localObject).iterator();
            while (((Iterator) localObject).hasNext()) {
                ((f) ((Iterator) localObject).next()).a();
            }
        }
    }

    public int getAnimationDuration() {
        return this.g;
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        if ((this.C == k.f) || (this.C == k.g)) {
            n();
        }
        int i1;
        if ((this.i) && (!this.j)) {
            i1 = paramMotionEvent.getActionMasked();
            if (i1 == 0) {
                h();
                if (this.B.contains((int) paramMotionEvent.getRawX(), (int) paramMotionEvent.getRawY())) {
                    o();
                }
            } else {
                do {
                    return false;
                    if (((i1 == 3) || (i1 == 1)) && (this.C == k.b)) {
                        n();
                        return false;
                    }
                } while (this.C == k.b);
            }
        }
        a(paramMotionEvent);
        if (!canScrollVertically(1)) {
            switch (paramMotionEvent.getActionMasked()) {
            }
        }
        f localf;
        do {
            float f1;
            do {
                do {
                    for (; ; ) {
                        i1 = paramMotionEvent.getActionMasked();
                        if ((i1 == 3) || (i1 == 1)) {
                            n();
                        }
                        return super.onInterceptTouchEvent(paramMotionEvent);
                        a(this.m);
                        this.w = paramMotionEvent.getRawY();
                        this.x = paramMotionEvent.getRawX();
                        this.y = paramMotionEvent.getY();
                        this.z = paramMotionEvent.getX();
                        this.m.offer(MotionEvent.obtain(paramMotionEvent));
                    }
                    f1 = paramMotionEvent.getRawY();
                    f1 = this.w - f1;
                    if ((f1 <= 0.0F) || (f1 <= this.r)) {
                        break;
                    }
                    localf = a(this, false, 0, (int) this.z, (int) this.y);
                } while (localf == null);
                a(localf);
                return true;
            } while ((f1 >= 0.0F) || (f1 >= -this.r));
            localf = a(this, false, -1, (int) this.z, (int) this.y);
        } while (localf == null);
        a(localf);
        return true;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (!this.o) {
            this.n = true;
        }
        if (this.D != null) {
            if (this.D.b) {
                scrollTo(getScrollX(), getScrollRange());
            }
            this.D = null;
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (StickyScrollView.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.a());
        this.D = paramParcelable;
    }

    protected Parcelable onSaveInstanceState() {
        StickyScrollView.SavedState localSavedState = new StickyScrollView.SavedState(super.onSaveInstanceState());
        localSavedState.b = a(this);
        return localSavedState;
    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        i();
        if (!e()) {
            c(paramInt2, paramInt4);
        }
        for (; ; ) {
            if (this.l != null) {
                this.l.a(paramInt2, paramInt4, getScrollRange());
            }
            this.c.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
            return;
            if ((paramInt2 > paramInt4) && (!canScrollVertically(1))) {
                f localf = a(this, false, 1, getWidth() / 2, getHeight() / 2);
                if (localf != null) {
                    b(localf);
                }
            }
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.e != null) {
            this.e.a(this, paramInt1, paramInt2);
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        a(paramMotionEvent);
        boolean bool = b(paramMotionEvent);
        int i1 = paramMotionEvent.getActionMasked();
        if ((i1 == 3) || (i1 == 1)) {
            n();
        }
        if (bool) {
            return true;
        }
        return super.onTouchEvent(paramMotionEvent);
    }

    public void setClipToPadding(boolean paramBoolean) {
        super.setClipToPadding(paramBoolean);
        this.n = paramBoolean;
        this.o = true;
    }

    public void setOnSizeChangedListener(b paramb) {
        this.e = paramb;
    }

    public void setStickyOffsetY(int paramInt) {
        this.p = paramInt;
    }

    public void setStickyScrollListener(j paramj) {
        this.l = paramj;
    }

    public void setStickyViewId(int paramInt) {
        this.q = paramInt;
        m();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/StickyScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */