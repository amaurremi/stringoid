package com.etsy.android.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.view.as;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView.RecyclerListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.OverScroller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ExtendableListView
        extends AbsListView {
    private boolean A = false;
    private boolean B;
    private int C;
    private int D;
    private k E;
    private c F;
    private int G;
    private g H;
    private j I;
    private d J;
    private ArrayList<f> K;
    private ArrayList<f> L;
    private boolean M;
    private Runnable N;
    private Runnable O;
    private Rect P = new Rect();
    private AbsListView.OnScrollListener Q;
    private ExtendableListView.ListSavedState R;
    ListAdapter a;
    protected int b;
    final boolean[] c = new boolean[1];
    protected boolean d;
    protected ContextMenu.ContextMenuInfo e = null;
    protected int f;
    protected int g;
    long h = Long.MIN_VALUE;
    long i;
    boolean j = false;
    private int k;
    private int l;
    private int m = 0;
    private VelocityTracker n = null;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x = -1;
    private boolean y;
    private Rect z;

    public ExtendableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setWillNotDraw(false);
        setClipToPadding(false);
        setFocusableInTouchMode(false);
        paramContext = ViewConfiguration.get(paramContext);
        this.o = paramContext.getScaledTouchSlop();
        this.p = paramContext.getScaledMaximumFlingVelocity();
        this.q = paramContext.getScaledMinimumFlingVelocity();
        this.E = new k(this);
        this.F = new c(this);
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.k = 0;
    }

    private View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        a(paramInt1, paramBoolean1);
        if (!this.B) {
            localView = this.E.c(paramInt1);
            if (localView != null) {
                a(localView, paramInt1, paramInt2, paramBoolean1, paramBoolean2, true);
                return localView;
            }
        }
        View localView = a(paramInt1, this.c);
        a(localView, paramInt1, paramInt2, paramBoolean1, paramBoolean2, this.c[0]);
        return localView;
    }

    private View a(int paramInt, boolean[] paramArrayOfBoolean) {
        paramArrayOfBoolean[0] = false;
        View localView1 = this.E.d(paramInt);
        if (localView1 != null) {
            View localView2 = this.a.getView(paramInt, localView1, this);
            if (localView2 != localView1) {
                this.E.a(localView1, paramInt);
                return localView2;
            }
            paramArrayOfBoolean[0] = true;
            return localView2;
        }
        return this.a.getView(paramInt, null, this);
    }

    static View a(ArrayList<View> paramArrayList, int paramInt) {
        int i2 = paramArrayList.size();
        if (i2 > 0) {
            int i1 = 0;
            while (i1 < i2) {
                View localView = (View) paramArrayList.get(i1);
                if (((h) localView.getLayoutParams()).b == paramInt) {
                    paramArrayList.remove(i1);
                    return localView;
                }
                i1 += 1;
            }
            return (View) paramArrayList.remove(i2 - 1);
        }
        return null;
    }

    private void a() {
        this.M = true;
        b();
    }

    private void a(float paramFloat) {
        if (this.H == null) {
            this.H = new g(this);
        }
        this.H.a((int) -paramFloat);
    }

    private void a(int paramInt) {
        int i2 = paramInt - this.s;
        int i3 = i2 - this.u;
        int i1;
        if (this.w != Integer.MIN_VALUE) {
            i1 = paramInt - this.w;
            if ((this.l == 1) && (paramInt != this.w)) {
                if (Math.abs(i2) > this.o) {
                    ViewParent localViewParent = getParent();
                    if (localViewParent != null) {
                        localViewParent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (this.v < 0) {
                    break label137;
                }
                i2 = this.v - this.b;
                label94:
                if (i1 == 0) {
                    break label147;
                }
            }
        }
        label137:
        label147:
        for (boolean bool = c(i3, i1); ; bool = false) {
            if (getChildAt(i2) != null) {
                if (bool) {
                }
                this.s = paramInt;
            }
            this.w = paramInt;
            return;
            i1 = i3;
            break;
            i2 = getChildCount() / 2;
            break label94;
        }
    }

    private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        int i2;
        int i1;
        label39:
        int i3;
        label51:
        label71:
        int i4;
        h localh;
        if (paramView.isSelected()) {
            i2 = 1;
            i1 = this.l;
            if ((i1 <= 3) || (i1 >= 1) || (this.v != paramInt1)) {
                break label239;
            }
            paramBoolean2 = true;
            if (paramBoolean2 == paramView.isPressed()) {
                break label245;
            }
            i3 = 1;
            if ((paramBoolean3) && (i2 == 0) && (!paramView.isLayoutRequested())) {
                break label251;
            }
            i1 = 1;
            i4 = this.a.getItemViewType(paramInt1);
            if (i4 != -2) {
                break label257;
            }
            localh = d(paramView);
            label97:
            localh.d = i4;
            localh.b = paramInt1;
            if ((!paramBoolean3) && ((!localh.a) || (localh.d != -2))) {
                break label273;
            }
            if (!paramBoolean1) {
                break label267;
            }
            i4 = -1;
            label141:
            attachViewToParent(paramView, i4, localh);
            if (i2 != 0) {
                paramView.setSelected(false);
            }
            if (i3 != 0) {
                paramView.setPressed(paramBoolean2);
            }
            if (i1 == 0) {
                break label317;
            }
            a(paramView, localh);
            label183:
            i2 = paramView.getMeasuredWidth();
            i3 = paramView.getMeasuredHeight();
            if (!paramBoolean1) {
                break label325;
            }
        }
        for (; ; ) {
            i4 = d(paramInt1);
            if (i1 == 0) {
                break label333;
            }
            a(paramView, paramInt1, paramBoolean1, i4, paramInt2, i4 + i2, paramInt2 + i3);
            return;
            i2 = 0;
            break;
            label239:
            paramBoolean2 = false;
            break label39;
            label245:
            i3 = 0;
            break label51;
            label251:
            i1 = 0;
            break label71;
            label257:
            localh = c(paramView);
            break label97;
            label267:
            i4 = 0;
            break label141;
            label273:
            if (localh.d == -2) {
                localh.a = true;
            }
            if (paramBoolean1) {
            }
            for (i4 = -1; ; i4 = 0) {
                addViewInLayout(paramView, i4, localh, true);
                break;
            }
            label317:
            cleanupLayoutState(paramView);
            break label183;
            label325:
            paramInt2 -= i3;
        }
        label333:
        a(paramView, paramInt1, paramBoolean1, i4, paramInt2);
    }

    private void a(View paramView, ArrayList<f> paramArrayList) {
        int i2 = paramArrayList.size();
        int i1 = 0;
        for (; ; ) {
            if (i1 < i2) {
                if (((f) paramArrayList.get(i1)).a == paramView) {
                    paramArrayList.remove(i1);
                }
            } else {
                return;
            }
            i1 += 1;
        }
    }

    private void a(Runnable paramRunnable) {
        bd.a(this, paramRunnable);
    }

    private void a(ArrayList<f> paramArrayList) {
        if (paramArrayList == null) {
        }
        for (; ; ) {
            return;
            paramArrayList = paramArrayList.iterator();
            while (paramArrayList.hasNext()) {
                ViewGroup.LayoutParams localLayoutParams = ((f) paramArrayList.next()).a.getLayoutParams();
                if ((localLayoutParams instanceof h)) {
                    ((h) localLayoutParams).a = false;
                }
            }
        }
    }

    private boolean a(MotionEvent paramMotionEvent) {
        int i3 = (int) paramMotionEvent.getX();
        int i4 = (int) paramMotionEvent.getY();
        int i2 = pointToPosition(i3, i4);
        this.n.clear();
        this.x = as.b(paramMotionEvent, 0);
        int i1;
        if ((this.l != 2) && (!this.B) && (i2 >= 0) && (getAdapter().isEnabled(i2))) {
            this.l = 3;
            if (this.N == null) {
                this.N = new e(this);
            }
            postDelayed(this.N, ViewConfiguration.getTapTimeout() / 2);
            i1 = i2;
            if (paramMotionEvent.getEdgeFlags() != 0) {
                i1 = i2;
                if (i2 < 0) {
                    return false;
                }
            }
        } else {
            i1 = i2;
            if (this.l == 2) {
                this.l = 1;
                this.u = 0;
                i1 = k(i4);
            }
        }
        this.M = false;
        this.t = i3;
        this.s = i4;
        this.v = i1;
        this.w = Integer.MIN_VALUE;
        return true;
    }

    private void b() {
        Object localObject = getHandler();
        if (localObject != null) {
            ((Handler) localObject).removeCallbacks(this.J);
            ((Handler) localObject).removeCallbacks(this.N);
        }
        setPressed(false);
        removeCallbacks(this.N);
        removeCallbacks(this.J);
        localObject = getChildAt(this.v - this.b);
        if (localObject != null) {
            ((View) localObject).setPressed(false);
        }
    }

    private boolean b(int paramInt1, int paramInt2) {
        int i1 = paramInt2 - this.s;
        int i2 = Math.abs(i1);
        paramInt1 = Math.abs(paramInt1 - this.t);
        if (i2 > this.o) {
            this.l = 1;
            l();
            if (i1 > 0) {
            }
            for (paramInt1 = this.o; ; paramInt1 = -this.o) {
                this.u = paramInt1;
                b();
                ViewParent localViewParent = getParent();
                if (localViewParent != null) {
                    localViewParent.requestDisallowInterceptTouchEvent(true);
                }
                a(paramInt2);
                return true;
            }
        }
        if (paramInt1 > this.o) {
            removeCallbacks(this.N);
            a();
        }
        return false;
    }

    private boolean b(MotionEvent paramMotionEvent) {
        int i2 = as.a(paramMotionEvent, this.x);
        if (i2 < 0) {
            Log.e("ExtendableListView", "onTouchMove could not find pointer with id " + this.x + " - did ExtendableListView receive an inconsistent " + "event stream?");
            return false;
        }
        int i1 = (int) as.d(paramMotionEvent, i2);
        i2 = (int) as.c(paramMotionEvent, i2);
        if (this.B) {
            layoutChildren();
        }
        switch (this.l) {
        }
        for (; ; ) {
            return true;
            if (b(i2, i1)) {
                continue;
                a(i1);
            }
        }
    }

    private boolean b(View paramView, int paramInt, long paramLong) {
        AdapterView.OnItemLongClickListener localOnItemLongClickListener = getOnItemLongClickListener();
        if (localOnItemLongClickListener != null) {
        }
        for (boolean bool1 = localOnItemLongClickListener.onItemLongClick(this, paramView, paramInt, paramLong); ; bool1 = false) {
            boolean bool2 = bool1;
            if (!bool1) {
                this.e = a(paramView, paramInt, paramLong);
                if ((getParent() == null) || (!getParent().showContextMenuForChild(this))) {
                    break label81;
                }
            }
            label81:
            for (bool2 = true; ; bool2 = false) {
                if (bool2) {
                    performHapticFeedback(0);
                }
                return bool2;
            }
        }
    }

    private boolean c(int paramInt1, int paramInt2) {
        if (!j()) {
            return true;
        }
        paramInt1 = getHighestChildTop();
        int i1 = getLowestChildBottom();
        int i3 = 0;
        int i2 = 0;
        if (this.d) {
            i3 = getListPaddingTop();
            i2 = getListPaddingBottom();
        }
        int i6 = getHeight();
        int i7 = getFirstChildTop();
        int i8 = getLastChildBottom();
        int i4 = i6 - getListPaddingBottom() - getListPaddingTop();
        int i9;
        int i5;
        int i10;
        if (paramInt2 < 0) {
            i4 = Math.max(-(i4 - 1), paramInt2);
            i9 = this.b;
            i5 = getListPaddingTop();
            paramInt2 = getListPaddingBottom();
            i10 = getChildCount();
            if ((i9 != 0) || (paramInt1 < i5) || (i4 < 0)) {
                break label183;
            }
            paramInt1 = 1;
            label132:
            if ((i9 + i10 != this.C) || (i1 > i6 - paramInt2) || (i4 > 0)) {
                break label188;
            }
            paramInt2 = 1;
        }
        for (; ; ) {
            if (paramInt1 != 0) {
                if (i4 != 0) {
                    return true;
                    i4 = Math.min(i4 - 1, paramInt2);
                    break;
                    label183:
                    paramInt1 = 0;
                    break label132;
                    label188:
                    paramInt2 = 0;
                    continue;
                }
                return false;
            }
        }
        if (paramInt2 != 0) {
            return i4 != 0;
        }
        boolean bool;
        int i11;
        int i12;
        label264:
        View localView;
        if (i4 < 0) {
            bool = true;
            i11 = getHeaderViewsCount();
            i12 = this.C - getFooterViewsCount();
            paramInt1 = 0;
            if (!bool) {
                break label440;
            }
            paramInt1 = -i4;
            paramInt2 = paramInt1;
            if (this.d) {
                paramInt2 = paramInt1 + getListPaddingTop();
            }
            paramInt1 = 0;
            i1 = 0;
            if (i1 < i10) {
                localView = getChildAt(i1);
                if (localView.getBottom() < paramInt2) {
                    break label398;
                }
            }
            paramInt2 = 0;
        }
        for (; ; ) {
            this.A = true;
            if (paramInt1 > 0) {
                detachViewsFromParent(paramInt2, paramInt1);
                this.E.d();
                a(paramInt2, paramInt1);
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            i(i4);
            if (bool) {
                this.b = (paramInt1 + this.b);
            }
            paramInt1 = Math.abs(i4);
            if ((i3 - i7 < paramInt1) || (i8 - (i6 - i2) < paramInt1)) {
                a(bool);
            }
            this.A = false;
            m();
            return false;
            bool = false;
            break;
            label398:
            i5 = i9 + i1;
            if ((i5 >= i11) && (i5 < i12)) {
                this.E.a(localView, i5);
            }
            i1 += 1;
            paramInt1 += 1;
            break label264;
            label440:
            paramInt2 = i6 - i4;
            i5 = paramInt2;
            if (this.d) {
                i5 = paramInt2 - getListPaddingBottom();
            }
            paramInt2 = 0;
            i1 = i10 - 1;
            for (; ; ) {
                if (i1 < 0) {
                    break label541;
                }
                localView = getChildAt(i1);
                if (localView.getTop() <= i5) {
                    i1 = paramInt1;
                    paramInt1 = paramInt2;
                    paramInt2 = i1;
                    break;
                }
                paramInt1 = i9 + i1;
                if ((paramInt1 >= i11) && (paramInt1 < i12)) {
                    this.E.a(localView, paramInt1);
                }
                paramInt2 += 1;
                paramInt1 = i1;
                i1 -= 1;
            }
            label541:
            i1 = paramInt1;
            paramInt1 = paramInt2;
            paramInt2 = i1;
        }
    }

    private boolean c(MotionEvent paramMotionEvent) {
        a();
        this.l = 0;
        invalidate();
        r();
        this.x = -1;
        return true;
    }

    private View d(int paramInt1, int paramInt2) {
        int i4 = getHeight();
        int i1 = i4;
        int i2 = paramInt1;
        int i3 = paramInt2;
        if (this.d) {
            i1 = i4 - getListPaddingBottom();
            i3 = paramInt2;
            i2 = paramInt1;
        }
        while (((i3 < i1) || (g())) && (i2 < this.C)) {
            a(i2, i3, true, false);
            i2 += 1;
            i3 = g(i2);
        }
        return null;
    }

    private void d() {
        if (getChildCount() > 0) {
            int i2 = getHighestChildTop() - getListPaddingTop();
            int i1 = i2;
            if (i2 < 0) {
                i1 = 0;
            }
            if (i1 != 0) {
                i(-i1);
            }
        }
    }

    private boolean d(MotionEvent paramMotionEvent) {
        switch (this.l) {
            case 2:
            default:
                invalidate();
                r();
                b();
                this.x = -1;
                return true;
            case 3:
            case 4:
            case 5:
                b();
                return f(paramMotionEvent);
        }
        return e(paramMotionEvent);
    }

    private View e(int paramInt1, int paramInt2) {
        int i1;
        if (this.d) {
            i1 = getListPaddingTop();
        }
        while (((paramInt2 > i1) || (h())) && (paramInt1 >= 0)) {
            a(paramInt1, paramInt2, false, false);
            paramInt1 -= 1;
            paramInt2 = h(paramInt1);
            continue;
            i1 = 0;
        }
        this.b = (paramInt1 + 1);
        return null;
    }

    private boolean e(MotionEvent paramMotionEvent) {
        if (j()) {
            int i1 = getFirstChildTop();
            int i2 = getLastChildBottom();
            if (((this.b == 0) && (i1 >= getListPaddingTop())) || ((this.b + getChildCount() < this.C) && (i2 <= getHeight() - getListPaddingBottom()))) {
            }
            for (i1 = 1; i1 == 0; i1 = 0) {
                this.n.computeCurrentVelocity(1000, this.p);
                float f1 = this.n.getYVelocity(this.x);
                if (Math.abs(f1) <= this.q) {
                    break;
                }
                fling((int) f1);
                return true;
            }
        }
        this.x = -1;
        k();
        r();
        this.l = 0;
        return true;
    }

    private View f(int paramInt1, int paramInt2) {
        a(paramInt1, paramInt2, true, false);
        this.b = paramInt1;
        paramInt2 = h(paramInt1 - 1);
        int i1 = g(paramInt1 + 1);
        View localView1 = e(paramInt1 - 1, paramInt2);
        d();
        View localView2 = d(paramInt1 + 1, i1);
        paramInt1 = getChildCount();
        if (paramInt1 > 0) {
            m(paramInt1);
        }
        if (localView1 != null) {
            return localView1;
        }
        return localView2;
    }

    private boolean f(MotionEvent paramMotionEvent) {
        if (this.M) {
            this.l = 0;
            invalidate();
            this.M = false;
            return true;
        }
        int i1 = this.v;
        if (i1 >= 0) {
            View localView = getChildAt(i1 - this.b);
            if ((localView != null) && (!localView.hasFocusable())) {
                if (this.l != 3) {
                    localView.setPressed(false);
                }
                if (this.I == null) {
                    invalidate();
                    this.I = new j(this, null);
                }
                j localj = this.I;
                localj.a = i1;
                localj.a();
                if ((this.l == 3) || (this.l == 4)) {
                    Handler localHandler = getHandler();
                    if (localHandler != null) {
                        if (this.l != 3) {
                            break label232;
                        }
                    }
                    label232:
                    for (paramMotionEvent = this.N; ; paramMotionEvent = this.J) {
                        localHandler.removeCallbacks(paramMotionEvent);
                        this.k = 0;
                        if ((this.B) || (i1 < 0) || (!this.a.isEnabled(i1))) {
                            break;
                        }
                        this.l = 4;
                        layoutChildren();
                        localView.setPressed(true);
                        setPressed(true);
                        this.O = new b(this, localView, localj);
                        postDelayed(this.O, ViewConfiguration.getPressedStateDuration());
                        return true;
                    }
                    this.l = 0;
                    return true;
                }
                if ((!this.B) && (i1 >= 0) && (this.a.isEnabled(i1))) {
                    post(localj);
                }
            }
        }
        this.l = 0;
        return true;
    }

    private boolean g(MotionEvent paramMotionEvent) {
        h(paramMotionEvent);
        int i2 = this.t;
        int i1 = this.s;
        i2 = pointToPosition(i2, i1);
        if (i2 >= 0) {
            this.v = i2;
        }
        this.w = i1;
        return true;
    }

    private Rect getListPaddingRect() {
        this.P.set(getListPaddingLeft(), getListPaddingTop(), getListPaddingRight(), getListPaddingBottom());
        return this.P;
    }

    private void h(MotionEvent paramMotionEvent) {
        int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        if (paramMotionEvent.getPointerId(i1) == this.x) {
            if (i1 != 0) {
                break label64;
            }
        }
        label64:
        for (i1 = 1; ; i1 = 0) {
            this.t = ((int) paramMotionEvent.getX(i1));
            this.s = ((int) paramMotionEvent.getY(i1));
            this.x = paramMotionEvent.getPointerId(i1);
            r();
            return;
        }
    }

    private int k(int paramInt) {
        int i2 = getChildCount();
        if (i2 > 0) {
            int i1 = 0;
            while (i1 < i2) {
                if (paramInt <= getChildAt(i1).getBottom()) {
                    return i1 + this.b;
                }
                i1 += 1;
            }
        }
        return -1;
    }

    private View l(int paramInt) {
        this.b = Math.min(this.b, this.C - 1);
        if (this.b < 0) {
            this.b = 0;
        }
        return d(this.b, paramInt);
    }

    private void m(int paramInt) {
        if ((this.b + paramInt - 1 == this.C - 1) && (paramInt > 0)) {
            paramInt = getLowestChildBottom();
            int i1 = getBottom() - getTop() - getListPaddingBottom() - paramInt;
            int i2 = getHighestChildTop();
            if ((i1 > 0) && ((this.b > 0) || (i2 < getListPaddingTop()))) {
                paramInt = i1;
                if (this.b == 0) {
                    paramInt = Math.min(i1, getListPaddingTop() - i2);
                }
                i(paramInt);
                if (this.b > 0) {
                    paramInt = this.b - 1;
                    e(paramInt, h(paramInt));
                    d();
                }
            }
        }
    }

    private void n(int paramInt) {
        int i4;
        if ((this.b == 0) && (paramInt > 0)) {
            int i1 = getHighestChildTop();
            int i3 = getListPaddingTop();
            int i2 = getTop() - getBottom() - getListPaddingBottom();
            i1 -= i3;
            i3 = getLowestChildBottom();
            i4 = this.b + paramInt - 1;
            if (i1 > 0) {
                if ((i4 >= this.C - 1) && (i3 <= i2)) {
                    break label139;
                }
                paramInt = i1;
                if (i4 == this.C - 1) {
                    paramInt = Math.min(i1, i3 - i2);
                }
                i(-paramInt);
                if (i4 < this.C - 1) {
                    paramInt = i4 + 1;
                    d(paramInt, g(paramInt));
                    d();
                }
            }
        }
        label139:
        while (i4 != this.C - 1) {
            return;
        }
        d();
    }

    private void p() {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
            return;
        }
        this.n.clear();
    }

    private void q() {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
    }

    private void r() {
        if (this.n != null) {
            this.n.recycle();
            this.n = null;
        }
    }

    @SuppressLint({"WrongCall"})
    private void s() {
        int i1;
        View localView;
        if ((getAdapter() == null) || (getAdapter().isEmpty())) {
            i1 = 1;
            if (isInFilterMode()) {
                i1 = 0;
            }
            localView = getEmptyView();
            if (i1 == 0) {
                break label96;
            }
            if (localView == null) {
                break label88;
            }
            localView.setVisibility(0);
            setVisibility(8);
        }
        for (; ; ) {
            if (this.B) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
            }
            return;
            i1 = 0;
            break;
            label88:
            setVisibility(0);
        }
        label96:
        if (localView != null) {
            localView.setVisibility(8);
        }
        setVisibility(0);
    }

    private void t() {
        a(this.K);
        a(this.L);
        removeAllViewsInLayout();
        this.b = 0;
        this.B = false;
        this.E.b();
        this.j = false;
        this.f = 0;
        this.g = 0;
        this.h = 0L;
        this.R = null;
        this.k = 0;
        invalidate();
    }

    protected ContextMenu.ContextMenuInfo a(View paramView, int paramInt, long paramLong) {
        return new AdapterView.AdapterContextMenuInfo(paramView, paramInt, paramLong);
    }

    protected void a(int paramInt1, int paramInt2) {
    }

    protected void a(int paramInt, boolean paramBoolean) {
    }

    public void a(View paramView) {
        a(paramView, null, true);
    }

    protected void a(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
        paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt3 - paramView.getTop());
    }

    protected void a(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        paramView.layout(paramInt2, paramInt3, paramInt4, paramInt5);
    }

    protected void a(View paramView, h paramh) {
        int i2 = ViewGroup.getChildMeasureSpec(this.G, getListPaddingLeft() + getListPaddingRight(), paramh.width);
        int i1 = paramh.height;
        if (i1 > 0) {
        }
        for (i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824); ; i1 = View.MeasureSpec.makeMeasureSpec(0, 0)) {
            paramView.measure(i2, i1);
            return;
        }
    }

    public void a(View paramView, Object paramObject, boolean paramBoolean) {
        f localf = new f(this);
        localf.a = paramView;
        localf.b = paramObject;
        localf.c = paramBoolean;
        this.L.add(localf);
        if ((this.a != null) && (this.F != null)) {
            this.F.onChanged();
        }
    }

    protected void a(boolean paramBoolean) {
        int i1 = getChildCount();
        if (paramBoolean) {
            i1 += this.b;
            d(i1, e(i1));
        }
        for (; ; ) {
            b(paramBoolean);
            return;
            i1 = this.b - 1;
            e(i1, f(i1));
        }
    }

    public View b(int paramInt) {
        paramInt = getHeaderViewsCount() + paramInt;
        int i1 = getFirstVisiblePosition();
        if ((paramInt < i1) || (paramInt > getLastVisiblePosition())) {
            return null;
        }
        return getChildAt(paramInt - i1);
    }

    public void b(VelocityTracker paramVelocityTracker, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, int paramInt) {
        if ((paramMotionEvent2.getActionMasked() == 1) || (paramMotionEvent2.getActionMasked() == 3)) {
            paramVelocityTracker.computeCurrentVelocity(1000, this.p);
            float f1 = paramVelocityTracker.getYVelocity(this.x);
            paramVelocityTracker.recycle();
            if (Math.abs(f1) > this.q) {
                c((int) f1);
            }
            return;
        }
        this.w = Integer.MIN_VALUE;
        this.x = paramInt;
        paramInt = paramMotionEvent1.findPointerIndex(this.x);
        label183:
        int i1;
        if (paramInt >= 0) {
            this.t = ((int) paramMotionEvent1.getX(paramInt));
            this.s = ((int) paramMotionEvent1.getY(paramInt));
            this.v = pointToPosition(this.t, this.s);
            this.u = 0;
            if (paramMotionEvent2.getActionMasked() == 6) {
                g(paramMotionEvent2);
            }
            if (paramMotionEvent2.findPointerIndex(this.x) == -1) {
                this.x = paramMotionEvent2.getPointerId(0);
            }
            if (paramVelocityTracker == null) {
                break label257;
            }
            r();
            this.n = paramVelocityTracker;
            i1 = (int) as.d(paramMotionEvent2, as.a(paramMotionEvent2, this.x));
            paramInt = this.s;
            this.l = 1;
            if (i1 - paramInt <= 0) {
                break label264;
            }
        }
        label257:
        label264:
        for (paramInt = this.o; ; paramInt = -this.o) {
            this.u = paramInt;
            a(i1);
            return;
            this.t = ((int) paramMotionEvent1.getX());
            this.s = ((int) paramMotionEvent1.getY());
            break;
            p();
            break label183;
        }
    }

    protected void b(boolean paramBoolean) {
        if (paramBoolean) {
            m(getChildCount());
            return;
        }
        n(getChildCount());
    }

    public boolean b(View paramView) {
        if (this.L.size() > 0) {
            if ((this.a == null) || (!((m) this.a).a(paramView))) {
                break label60;
            }
            if (this.F != null) {
                this.F.onChanged();
            }
        }
        label60:
        for (boolean bool = true; ; bool = false) {
            a(paramView, this.L);
            return bool;
            return false;
        }
    }

    public VelocityTracker c() {
        VelocityTracker localVelocityTracker = this.n;
        this.n = null;
        return localVelocityTracker;
    }

    protected h c(View paramView) {
        return d(paramView);
    }

    public void c(int paramInt) {
        r();
        b();
        this.x = -1;
        fling(paramInt);
    }

    public boolean canScrollList(int paramInt) {
        int i2 = getChildCount();
        if (i2 == 0) {
        }
        int i1;
        Rect localRect;
        do {
            do {
                return false;
                i1 = this.b;
                localRect = getListPaddingRect();
                if (paramInt <= 0) {
                    break;
                }
                paramInt = getChildAt(i2 - 1).getBottom();
            } while ((i2 + i1 >= this.C) && (paramInt <= getHeight() - localRect.bottom));
            return true;
            paramInt = getChildAt(0).getTop();
        } while ((i1 <= 0) && (paramInt >= localRect.top));
        return true;
    }

    public boolean canScrollVertically(int paramInt) {
        return canScrollList(paramInt);
    }

    protected int computeVerticalScrollExtent() {
        int i3 = getChildCount();
        if (i3 > 0) {
            if (isSmoothScrollbarEnabled()) {
                int i2 = i3 * 100;
                View localView = getChildAt(0);
                int i4 = localView.getTop();
                int i5 = localView.getHeight();
                int i1 = i2;
                if (i5 > 0) {
                    i1 = i2 + i4 * 100 / i5;
                }
                localView = getChildAt(i3 - 1);
                i3 = localView.getBottom();
                i4 = localView.getHeight();
                i2 = i1;
                if (i4 > 0) {
                    i2 = i1 - (i3 - getHeight()) * 100 / i4;
                }
                return i2;
            }
            return 1;
        }
        return 0;
    }

    protected int computeVerticalScrollOffset() {
        int i4 = 0;
        int i3 = 0;
        int i5 = this.b;
        int i6 = getChildCount();
        int i1 = i3;
        int i2;
        float f1;
        if (i5 >= 0) {
            i1 = i3;
            if (i6 > 0) {
                i2 = getCount();
                if (!isSmoothScrollbarEnabled()) {
                    break label122;
                }
                View localView = getChildAt(0);
                i4 = localView.getTop();
                i6 = localView.getHeight();
                i1 = i3;
                if (i6 > 0) {
                    i1 = i4 * 100 / i6;
                    f1 = getScrollY() / getHeight();
                    i1 = Math.max((int) (i2 * f1 * 100.0F) + (i5 * 100 - i1), 0);
                }
            }
        }
        return i1;
        label122:
        if (i5 == 0) {
            i1 = i4;
        }
        for (; ; ) {
            f1 = i5;
            float f2 = i6;
            return (int) (i1 / i2 * f2 + f1);
            if (i5 + i6 == i2) {
                i1 = i2;
            } else {
                i1 = i6 / 2 + i5;
            }
        }
    }

    protected int computeVerticalScrollRange() {
        if (isSmoothScrollbarEnabled()) {
            int i2 = Math.max(this.C * 100, 0);
            int i3 = getScrollY();
            int i1 = i2;
            if (i3 != 0) {
                i1 = i2 + Math.abs((int) (i3 / getHeight() * this.C * 100.0F));
            }
            return i1;
        }
        return this.C;
    }

    protected int d(int paramInt) {
        return getListPaddingLeft();
    }

    protected h d(View paramView) {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
            if ((paramView instanceof h)) {
                paramView = (h) paramView;
            }
        }
        for (; ; ) {
            Object localObject = paramView;
            if (paramView == null) {
                localObject = i();
            }
            return (h) localObject;
            paramView = new h(paramView);
            continue;
            paramView = null;
        }
    }

    protected int e(int paramInt) {
        int i1 = getChildCount();
        paramInt = 0;
        if (this.d) {
            paramInt = getListPaddingTop();
        }
        if (i1 > 0) {
            paramInt = getChildAt(i1 - 1).getBottom();
        }
        return paramInt;
    }

    public void e() {
    }

    protected int f(int paramInt) {
        int i1 = getChildCount();
        if (this.d) {
        }
        for (paramInt = getListPaddingBottom(); ; paramInt = 0) {
            if (i1 > 0) {
                return getChildAt(0).getTop();
            }
            return getHeight() - paramInt;
        }
    }

    public void f() {
        r();
        this.x = -1;
        this.l = 0;
    }

    public void fling(int paramInt) {
        k();
        a(paramInt);
        this.l = 2;
        this.s = 0;
        this.t = 0;
        invalidate();
    }

    protected int g(int paramInt) {
        paramInt = getChildCount();
        if (paramInt > 0) {
            return getChildAt(paramInt - 1).getBottom();
        }
        return 0;
    }

    protected boolean g() {
        return false;
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return new h(paramLayoutParams);
    }

    public AbsListView.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new h(getContext(), paramAttributeSet);
    }

    public int getActivePointerId() {
        return this.x;
    }

    public ListAdapter getAdapter() {
        return this.a;
    }

    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.e;
    }

    public int getCount() {
        return this.C;
    }

    public float getCurrentVelocity() {
        if (this.H != null) {
            return g.b(this.H).getCurrVelocity();
        }
        return 0.0F;
    }

    protected int getFirstChildTop() {
        int i1 = 0;
        if (j()) {
            i1 = getChildAt(0).getTop();
        }
        return i1;
    }

    public int getFirstVisiblePosition() {
        return this.b;
    }

    public int getFooterViewsCount() {
        return this.L.size();
    }

    public int getHeaderViewsCount() {
        return this.K.size();
    }

    protected int getHighestChildTop() {
        int i1 = 0;
        if (j()) {
            i1 = getChildAt(0).getTop();
        }
        return i1;
    }

    protected int getLastChildBottom() {
        if (j()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    public int getLastVisiblePosition() {
        return this.b + getChildCount() - 1;
    }

    protected int getLowestChildBottom() {
        if (j()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    public int getPositionForView(View paramView) {
        try {
            for (; ; ) {
                View localView = (View) paramView.getParent();
                boolean bool = localView.equals(this);
                if (bool) {
                    break;
                }
                paramView = localView;
            }
            i2 = getChildCount();
        } catch (ClassCastException paramView) {
            return -1;
        }
        int i2;
        int i1 = 0;
        while (i1 < i2) {
            if (getChildAt(i1).equals(paramView)) {
                return i1 + this.b;
            }
            i1 += 1;
        }
        return -1;
    }

    public int getScrollState() {
        return this.m;
    }

    public View getSelectedView() {
        return null;
    }

    protected int h(int paramInt) {
        paramInt = getChildCount();
        if (paramInt == 0) {
        }
        while (paramInt <= 0) {
            return 0;
        }
        return getChildAt(0).getTop();
    }

    protected boolean h() {
        return false;
    }

    protected void handleDataChanged() {
        super.handleDataChanged();
        int i1 = this.C;
        if ((i1 > 0) && (this.j)) {
            this.j = false;
            this.R = null;
            this.k = 2;
            this.f = Math.min(Math.max(0, this.f), i1 - 1);
            return;
        }
        this.k = 1;
        this.j = false;
        this.R = null;
    }

    protected h i() {
        return new h(-1, -2, 0);
    }

    protected void i(int paramInt) {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            getChildAt(i1).offsetTopAndBottom(paramInt);
            i1 += 1;
        }
    }

    protected void j(int paramInt) {
        if (paramInt != this.m) {
            this.m = paramInt;
            if (this.Q != null) {
                this.Q.onScrollStateChanged(this, paramInt);
            }
        }
    }

    protected boolean j() {
        return getChildCount() > 0;
    }

    protected void k() {
        if (this.H != null) {
            g.a(this.H);
            this.H = null;
        }
    }

    public void l() {
        switch (this.l) {
            default:
                return;
            case 1:
                j(1);
                return;
            case 2:
                j(2);
                return;
        }
        j(0);
    }

    protected void layoutChildren() {
        if (this.A) {
            return;
        }
        this.A = true;
        int i2;
        int i3;
        boolean bool;
        try {
            super.layoutChildren();
            invalidate();
            if (this.a == null) {
                t();
                m();
                return;
            }
            i2 = getListPaddingTop();
            i3 = getChildCount();
            if (this.k != 0) {
                break label425;
            }
            View localView = getChildAt(0);
            bool = this.B;
            if (bool) {
                handleDataChanged();
            }
            if (this.C == 0) {
                t();
                m();
                return;
            }
            if (this.C != this.a.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ExtendableListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ExtendableListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.a.getClass() + ")]");
            }
        } finally {
            this.A = false;
        }
        int i4 = this.b;
        k localk = this.E;
        int i1;
        if (bool) {
            i1 = 0;
            while (i1 < i3) {
                localk.a(getChildAt(i1), i4 + i1);
                i1 += 1;
            }
        }
        localk.a(i3, i4);
        detachAllViewsFromParent();
        localk.d();
        switch (this.k) {
        }
        for (; ; ) {
            if (i3 == 0) {
                f(this.b, getListPaddingTop());
            }
            for (; ; ) {
                localk.e();
                this.B = false;
                this.j = false;
                this.k = 0;
                m();
                this.A = false;
                return;
                this.b = 0;
                e();
                d();
                l(i2);
                d();
                continue;
                f(this.f, this.g);
                continue;
                if (this.b < this.C) {
                    i3 = this.b;
                    if (localObject1 == null) {
                    }
                    for (i1 = i2; ; i1 = ((View) localObject1).getTop()) {
                        f(i3, i1);
                        break;
                    }
                }
                f(0, i2);
            }
            label425:
            Object localObject2 = null;
            break;
        }
    }

    protected void m() {
        if (this.Q != null) {
            this.Q.onScroll(this, this.b, getChildCount(), this.C);
        }
    }

    public void n() {
        k();
        r();
    }

    void o() {
        View localView;
        ListAdapter localListAdapter;
        if (getChildCount() > 0) {
            this.j = true;
            this.i = getHeight();
            localView = getChildAt(0);
            localListAdapter = getAdapter();
            if ((this.b < 0) || (this.b >= localListAdapter.getCount())) {
                break label87;
            }
        }
        label87:
        for (this.h = localListAdapter.getItemId(this.b); ; this.h = -1L) {
            if (localView != null) {
                this.g = localView.getTop();
            }
            this.f = this.b;
            return;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.B = true;
            this.D = this.C;
            this.C = this.a.getCount();
        }
        this.y = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r();
        this.E.b();
        if (this.H != null) {
            removeCallbacks(this.H);
        }
        if (this.N != null) {
            removeCallbacks(this.N);
        }
        if (this.J != null) {
            removeCallbacks(this.J);
        }
        if (this.O != null) {
            removeCallbacks(this.O);
        }
        if (this.I != null) {
            removeCallbacks(this.I);
        }
        Handler localHandler = getHandler();
        if (localHandler != null) {
            localHandler.removeCallbacks(this.H);
            localHandler.removeCallbacks(this.N);
            localHandler.removeCallbacks(this.J);
            localHandler.removeCallbacks(this.O);
            localHandler.removeCallbacks(this.I);
        }
        this.y = false;
    }

    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        int i1 = paramMotionEvent.getAction();
        if (!this.y) {
        }
        int i2;
        do {
            do {
                return false;
                switch (i1 & 0xFF) {
                    case 4:
                    case 5:
                    default:
                        return false;
                    case 0:
                        i1 = this.l;
                        i2 = (int) paramMotionEvent.getX();
                        int i3 = (int) paramMotionEvent.getY();
                        this.x = paramMotionEvent.getPointerId(0);
                        int i4 = k(i3);
                        if ((i1 != 2) && (i4 >= 0)) {
                            this.t = i2;
                            this.s = i3;
                            this.v = i4;
                            this.l = 3;
                        }
                        this.w = Integer.MIN_VALUE;
                        p();
                        this.n.addMovement(paramMotionEvent);
                }
            } while (i1 != 2);
            return true;
            switch (this.l) {
                default:
                    return false;
            }
            i2 = paramMotionEvent.findPointerIndex(this.x);
            i1 = i2;
            if (i2 == -1) {
                this.x = paramMotionEvent.getPointerId(0);
                i1 = 0;
            }
            i2 = (int) paramMotionEvent.getY(i1);
            i1 = (int) paramMotionEvent.getX(i1);
            q();
            this.n.addMovement(paramMotionEvent);
        } while (!b(i1, i2));
        return true;
        this.l = 0;
        this.x = -1;
        r();
        j(0);
        return false;
        h(paramMotionEvent);
        return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.a == null) {
            t();
            return;
        }
        if (paramBoolean) {
            paramInt2 = getChildCount();
            paramInt1 = 0;
            while (paramInt1 < paramInt2) {
                getChildAt(paramInt1).forceLayout();
                paramInt1 += 1;
            }
            this.E.a();
        }
        this.r = true;
        layoutChildren();
        this.r = false;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
        this.G = paramInt1;
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (ExtendableListView.ListSavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.a());
        this.B = true;
        this.i = paramParcelable.f;
        if (paramParcelable.c >= 0L) {
            this.j = true;
            this.R = paramParcelable;
            this.h = paramParcelable.c;
            this.f = paramParcelable.e;
            this.g = paramParcelable.d;
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        n();
        ExtendableListView.ListSavedState localListSavedState = new ExtendableListView.ListSavedState(super.onSaveInstanceState());
        if (this.R != null) {
            localListSavedState.b = this.R.b;
            localListSavedState.c = this.R.c;
            localListSavedState.d = this.R.d;
            localListSavedState.e = this.R.e;
            localListSavedState.f = this.R.f;
            return localListSavedState;
        }
        int i1;
        if ((getChildCount() > 0) && (this.C > 0)) {
            i1 = 1;
            localListSavedState.b = getSelectedItemId();
            localListSavedState.f = getHeight();
            if ((i1 == 0) || (this.b <= 0)) {
                break label183;
            }
            localListSavedState.d = getChildAt(0).getTop();
            int i2 = this.b;
            i1 = i2;
            if (i2 >= this.C) {
                i1 = this.C - 1;
            }
            localListSavedState.e = i1;
            localListSavedState.c = this.a.getItemId(i1);
        }
        for (; ; ) {
            return localListSavedState;
            i1 = 0;
            break;
            label183:
            localListSavedState.d = 0;
            localListSavedState.c = -1L;
            localListSavedState.e = 0;
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (getChildCount() > 0) {
            k();
            this.E.b();
            this.B = true;
            o();
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = false;
        boolean bool1 = false;
        if (!isEnabled()) {
            if ((isClickable()) || (isLongClickable())) {
                bool1 = true;
            }
        }
        do {
            return bool1;
            q();
            this.n.addMovement(paramMotionEvent);
        } while (!j());
        bool1 = bool2;
        switch (paramMotionEvent.getAction() & 0xFF) {
            default:
                bool1 = bool2;
        }
        for (; ; ) {
            l();
            return bool1;
            bool1 = a(paramMotionEvent);
            continue;
            bool1 = b(paramMotionEvent);
            continue;
            bool1 = c(paramMotionEvent);
            continue;
            bool1 = g(paramMotionEvent);
            continue;
            bool1 = d(paramMotionEvent);
        }
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
    }

    public int pointToPosition(int paramInt1, int paramInt2) {
        Object localObject2 = this.z;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            this.z = new Rect();
            localObject1 = this.z;
        }
        int i1 = getChildCount() - 1;
        while (i1 >= 0) {
            localObject2 = getChildAt(i1);
            if (((View) localObject2).getVisibility() == 0) {
                ((View) localObject2).getHitRect((Rect) localObject1);
                if (((Rect) localObject1).contains(paramInt1, paramInt2)) {
                    return this.b + i1;
                }
            }
            i1 -= 1;
        }
        return -1;
    }

    public void reclaimViews(List<View> paramList) {
        int i2 = getChildCount();
        AbsListView.RecyclerListener localRecyclerListener = k.a(this.E);
        int i1 = 0;
        while (i1 < i2) {
            View localView = getChildAt(i1);
            h localh = (h) localView.getLayoutParams();
            if ((localh != null) && (this.E.b(localh.d))) {
                paramList.add(localView);
                if (localRecyclerListener != null) {
                    localRecyclerListener.onMovedToScrapHeap(localView);
                }
            }
            i1 += 1;
        }
        this.E.a(paramList);
        removeAllViewsInLayout();
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
        if (paramBoolean) {
            r();
        }
        super.requestDisallowInterceptTouchEvent(paramBoolean);
    }

    public void requestLayout() {
        if ((!this.A) && (!this.r)) {
            super.requestLayout();
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (this.a != null) {
            this.a.unregisterDataSetObserver(this.F);
        }
        if ((paramListAdapter != null) || (this.K.size() > 0) || (this.L.size() > 0)) {
            this.a = new m(this.K, this.L, paramListAdapter);
            this.B = true;
            if (this.a == null) {
                break label140;
            }
        }
        label140:
        for (int i1 = this.a.getCount(); ; i1 = 0) {
            this.C = i1;
            if (this.a != null) {
                this.a.registerDataSetObserver(this.F);
                this.E.a(this.a.getViewTypeCount());
            }
            requestLayout();
            return;
            this.a = null;
            break;
        }
    }

    public void setClipToPadding(boolean paramBoolean) {
        super.setClipToPadding(paramBoolean);
        this.d = paramBoolean;
    }

    protected void setFirstPosition(int paramInt) {
        if (paramInt >= 0) {
            this.k = 2;
            this.g = getListPaddingTop();
            this.j = true;
            this.f = paramInt;
            this.h = this.a.getItemId(paramInt);
            requestLayout();
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
        super.setOnScrollListener(paramOnScrollListener);
        this.Q = paramOnScrollListener;
    }

    public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener) {
        k.a(this.E, paramRecyclerListener);
    }

    public void setSelection(int paramInt) {
        if (paramInt >= 0) {
            this.k = 2;
            this.g = getListPaddingTop();
            this.b = 0;
            if (this.j) {
                this.f = paramInt;
                this.h = this.a.getItemId(paramInt);
            }
            requestLayout();
        }
    }

    public boolean showContextMenuForChild(View paramView) {
        int i1 = getPositionForView(paramView);
        long l1;
        if (i1 >= 0) {
            l1 = this.a.getItemId(i1);
            if (getOnItemLongClickListener() == null) {
                break label102;
            }
        }
        label102:
        for (boolean bool1 = getOnItemLongClickListener().onItemLongClick(this, paramView, i1, l1); ; bool1 = false) {
            boolean bool2 = bool1;
            if (!bool1) {
                this.e = a(getChildAt(i1 - this.b), i1, l1);
                if ((getParent() != null) && (getParent().showContextMenuForChild(paramView))) {
                    bool2 = true;
                }
            } else {
                return bool2;
            }
            return false;
            return false;
        }
    }

    public void smoothScrollBy(int paramInt1, int paramInt2) {
        if (this.H == null) {
            this.H = new g(this);
        }
        int i1 = this.b;
        int i2 = getChildCount();
        int i3 = getPaddingTop();
        int i4 = getHeight();
        int i5 = getPaddingBottom();
        if ((paramInt1 == 0) || (this.C == 0) || (i2 == 0) || ((i1 == 0) && (getChildAt(0).getTop() == i3) && (paramInt1 < 0)) || ((i1 + i2 == this.C) && (getChildAt(i2 - 1).getBottom() == i4 - i5) && (paramInt1 > 0))) {
            g.a(this.H);
            return;
        }
        j(2);
        this.H.a(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/etsy/android/grid/ExtendableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */