package com.everimaging.fotorsdk.widget.etsy.staggeredgrid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
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
    private boolean A;
    private int B;
    private int C;
    private h D;
    private a E;
    private int F;
    private e G;
    private g H;
    private b I;
    private boolean J = false;
    private ArrayList<d> K;
    private ArrayList<d> L;
    private boolean M;
    private Runnable N;
    private Runnable O;
    private Rect P = new Rect();
    private AbsListView.OnScrollListener Q;
    private ListSavedState R;
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
    private boolean z = false;

    public ExtendableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        setWillNotDraw(false);
        setClipToPadding(false);
        setFocusableInTouchMode(false);
        paramContext = ViewConfiguration.get(paramContext);
        this.o = paramContext.getScaledTouchSlop();
        this.p = paramContext.getScaledMaximumFlingVelocity();
        this.q = paramContext.getScaledMinimumFlingVelocity();
        this.D = new h();
        this.E = new a();
        this.K = new ArrayList();
        this.L = new ArrayList();
        this.k = 0;
    }

    private View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        a(paramInt1, paramBoolean1);
        if (!this.A) {
            localView = this.D.c(paramInt1);
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
        View localView1 = this.D.d(paramInt);
        if (localView1 != null) {
            View localView2 = this.a.getView(paramInt, localView1, this);
            if (localView2 != localView1) {
                this.D.a(localView1, paramInt);
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
                if (((f) localView.getLayoutParams()).b == paramInt) {
                    paramArrayList.remove(i1);
                    return localView;
                }
                i1 += 1;
            }
            return (View) paramArrayList.remove(i2 - 1);
        }
        return null;
    }

    private void a(float paramFloat) {
        if (this.G == null) {
            this.G = new e();
        }
        this.G.a((int) -paramFloat);
    }

    private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        int i2;
        int i1;
        label39:
        int i3;
        label51:
        label71:
        int i4;
        f localf;
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
            localf = b(paramView);
            label97:
            localf.d = i4;
            localf.b = paramInt1;
            if ((!paramBoolean3) && ((!localf.a) || (localf.d != -2))) {
                break label273;
            }
            if (!paramBoolean1) {
                break label267;
            }
            i4 = -1;
            label141:
            attachViewToParent(paramView, i4, localf);
            if (i2 != 0) {
                paramView.setSelected(false);
            }
            if (i3 != 0) {
                paramView.setPressed(paramBoolean2);
            }
            if (i1 == 0) {
                break label317;
            }
            a(paramView, localf);
            label183:
            i2 = paramView.getMeasuredWidth();
            i3 = paramView.getMeasuredHeight();
            if (!paramBoolean1) {
                break label325;
            }
        }
        for (; ; ) {
            i4 = b(paramInt1);
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
            localf = a(paramView);
            break label97;
            label267:
            i4 = 0;
            break label141;
            label273:
            if (localf.d == -2) {
                localf.a = true;
            }
            if (paramBoolean1) {
            }
            for (i4 = -1; ; i4 = 0) {
                addViewInLayout(paramView, i4, localf, true);
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

    private void a(Runnable paramRunnable) {
        ViewCompat.postOnAnimation(this, paramRunnable);
    }

    private void a(ArrayList<d> paramArrayList) {
        if (paramArrayList == null) {
        }
        for (; ; ) {
            return;
            paramArrayList = paramArrayList.iterator();
            while (paramArrayList.hasNext()) {
                ViewGroup.LayoutParams localLayoutParams = ((d) paramArrayList.next()).a.getLayoutParams();
                if ((localLayoutParams instanceof f)) {
                    ((f) localLayoutParams).a = false;
                }
            }
        }
    }

    private boolean a(MotionEvent paramMotionEvent) {
        int i3 = (int) paramMotionEvent.getX();
        int i4 = (int) paramMotionEvent.getY();
        int i2 = pointToPosition(i3, i4);
        this.n.clear();
        this.x = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        int i1;
        if ((this.l != 2) && (!this.A) && (i2 >= 0) && (getAdapter().isEnabled(i2))) {
            this.l = 3;
            if (this.N == null) {
                this.N = new c();
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
                i1 = j(i4);
            }
        }
        this.M = false;
        this.t = i3;
        this.s = i4;
        this.v = i1;
        this.w = Integer.MIN_VALUE;
        return true;
    }

    private boolean b(int paramInt1, int paramInt2) {
        int i1 = paramInt2 - this.s;
        int i2 = Math.abs(i1);
        paramInt1 = Math.abs(paramInt1 - this.t);
        if (i2 > this.o) {
            this.l = 1;
            g();
            if (i1 > 0) {
            }
            for (paramInt1 = this.o; ; paramInt1 = -this.o) {
                this.u = paramInt1;
                l();
                ViewParent localViewParent = getParent();
                if (localViewParent != null) {
                    localViewParent.requestDisallowInterceptTouchEvent(true);
                }
                i(paramInt2);
                return true;
            }
        }
        if (paramInt1 > this.o) {
            removeCallbacks(this.N);
            k();
        }
        return false;
    }

    private boolean b(MotionEvent paramMotionEvent) {
        int i2 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.x);
        if (i2 < 0) {
            Log.e("ExtendableListView", "onTouchMove could not find pointer with id " + this.x + " - did ExtendableListView receive an inconsistent " + "event stream?");
            return false;
        }
        int i1 = (int) MotionEventCompat.getY(paramMotionEvent, i2);
        i2 = (int) MotionEventCompat.getX(paramMotionEvent, i2);
        if (this.A) {
            layoutChildren();
        }
        switch (this.l) {
        }
        for (; ; ) {
            return true;
            if (b(i2, i1)) {
                continue;
                i(i1);
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
        if (!e()) {
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
            if ((i9 + i10 != this.B) || (i1 > i6 - paramInt2) || (i4 > 0)) {
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
            i12 = this.B - getFooterViewsCount();
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
            this.z = true;
            if (paramInt1 > 0) {
                detachViewsFromParent(paramInt2, paramInt1);
                this.D.d();
                a(paramInt2, paramInt1);
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            g(i4);
            if (bool) {
                this.b = (paramInt1 + this.b);
            }
            paramInt1 = Math.abs(i4);
            if ((i3 - i7 < paramInt1) || (i8 - (i6 - i2) < paramInt1)) {
                a(bool);
            }
            this.z = false;
            h();
            return false;
            bool = false;
            break;
            label398:
            i5 = i9 + i1;
            if ((i5 >= i11) && (i5 < i12)) {
                this.D.a(localView, i5);
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
                    this.D.a(localView, paramInt1);
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
        k();
        this.l = 0;
        invalidate();
        p();
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
        while (((i3 < i1) || (b())) && (i2 < this.B)) {
            a(i2, i3, true, false);
            i2 += 1;
            i3 = e(i2);
        }
        return null;
    }

    private boolean d(MotionEvent paramMotionEvent) {
        switch (this.l) {
            case 2:
            default:
                invalidate();
                p();
                l();
                this.x = -1;
                return true;
            case 3:
            case 4:
            case 5:
                l();
                return f(paramMotionEvent);
        }
        return e(paramMotionEvent);
    }

    private View e(int paramInt1, int paramInt2) {
        int i1;
        if (this.d) {
            i1 = getListPaddingTop();
        }
        while (((paramInt2 > i1) || (c())) && (paramInt1 >= 0)) {
            a(paramInt1, paramInt2, false, false);
            paramInt1 -= 1;
            paramInt2 = f(paramInt1);
            continue;
            i1 = 0;
        }
        this.b = (paramInt1 + 1);
        return null;
    }

    private boolean e(MotionEvent paramMotionEvent) {
        if (e()) {
            int i1 = getFirstChildTop();
            int i2 = getLastChildBottom();
            if (((this.b == 0) && (i1 >= getListPaddingTop())) || ((this.b + getChildCount() < this.B) && (i2 <= getHeight() - getListPaddingBottom()))) {
            }
            for (i1 = 1; i1 == 0; i1 = 0) {
                this.n.computeCurrentVelocity(1000, this.p);
                float f1 = this.n.getYVelocity(this.x);
                if (Math.abs(f1) <= this.q) {
                    break;
                }
                a((int) f1);
                return true;
            }
        }
        this.x = -1;
        f();
        p();
        this.l = 0;
        return true;
    }

    private View f(int paramInt1, int paramInt2) {
        a(paramInt1, paramInt2, true, false);
        this.b = paramInt1;
        paramInt2 = f(paramInt1 - 1);
        int i1 = e(paramInt1 + 1);
        View localView1 = e(paramInt1 - 1, paramInt2);
        m();
        View localView2 = d(paramInt1 + 1, i1);
        paramInt1 = getChildCount();
        if (paramInt1 > 0) {
            l(paramInt1);
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
            final View localView = getChildAt(i1);
            if ((localView != null) && (!localView.hasFocusable())) {
                if (this.l != 3) {
                    localView.setPressed(false);
                }
                if (this.H == null) {
                    invalidate();
                    this.H = new g(null);
                }
                final g localg = this.H;
                localg.a = i1;
                localg.a();
                if ((this.l == 3) || (this.l == 4)) {
                    Handler localHandler = getHandler();
                    if (localHandler != null) {
                        if (this.l != 3) {
                            break label227;
                        }
                    }
                    label227:
                    for (paramMotionEvent = this.N; ; paramMotionEvent = this.I) {
                        localHandler.removeCallbacks(paramMotionEvent);
                        this.k = 0;
                        if ((this.A) || (i1 < 0) || (!this.a.isEnabled(i1))) {
                            break;
                        }
                        this.l = 4;
                        layoutChildren();
                        localView.setPressed(true);
                        setPressed(true);
                        this.O = new Runnable() {
                            public void run() {
                                localView.setPressed(false);
                                ExtendableListView.this.setPressed(false);
                                if (!ExtendableListView.b(ExtendableListView.this)) {
                                    ExtendableListView.this.post(localg);
                                }
                                ExtendableListView.a(ExtendableListView.this, 0);
                            }
                        };
                        postDelayed(this.O, ViewConfiguration.getPressedStateDuration());
                        return true;
                    }
                    this.l = 0;
                    return true;
                }
                if ((!this.A) && (i1 >= 0) && (this.a.isEnabled(i1))) {
                    post(localg);
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
            p();
            return;
        }
    }

    private void i(int paramInt) {
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
                    break label138;
                }
                i2 = this.v - this.b;
                label95:
                if (i1 == 0) {
                    break label148;
                }
            }
        }
        label138:
        label148:
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
            break label95;
        }
    }

    private int j(int paramInt) {
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

    private View k(int paramInt) {
        this.b = Math.min(this.b, this.B - 1);
        if (this.b < 0) {
            this.b = 0;
        }
        return d(this.b, paramInt);
    }

    private void k() {
        this.M = true;
        l();
    }

    private void l() {
        Object localObject = getHandler();
        if (localObject != null) {
            ((Handler) localObject).removeCallbacks(this.I);
            ((Handler) localObject).removeCallbacks(this.N);
        }
        setPressed(false);
        removeCallbacks(this.N);
        removeCallbacks(this.I);
        localObject = getChildAt(this.v);
        if (localObject != null) {
            ((View) localObject).setPressed(false);
        }
    }

    private void l(int paramInt) {
        if ((this.b + paramInt - 1 == this.B - 1) && (paramInt > 0)) {
            paramInt = getLowestChildBottom();
            int i1 = getBottom() - getTop() - getListPaddingBottom() - paramInt;
            int i2 = getHighestChildTop();
            if ((i1 > 0) && ((this.b > 0) || (i2 < getListPaddingTop()))) {
                paramInt = i1;
                if (this.b == 0) {
                    paramInt = Math.min(i1, getListPaddingTop() - i2);
                }
                g(paramInt);
                if (this.b > 0) {
                    paramInt = this.b - 1;
                    e(paramInt, f(paramInt));
                    m();
                }
            }
        }
    }

    private void m() {
        if (getChildCount() > 0) {
            int i2 = getHighestChildTop() - getListPaddingTop();
            int i1 = i2;
            if (i2 < 0) {
                i1 = 0;
            }
            if (i1 != 0) {
                g(-i1);
            }
        }
    }

    private void m(int paramInt) {
        int i4;
        if ((this.b == 0) && (paramInt > 0)) {
            int i1 = getHighestChildTop();
            int i3 = getListPaddingTop();
            int i2 = getTop() - getBottom() - getListPaddingBottom();
            i1 -= i3;
            i3 = getLowestChildBottom();
            i4 = this.b + paramInt - 1;
            if (i1 > 0) {
                if ((i4 >= this.B - 1) && (i3 <= i2)) {
                    break label139;
                }
                paramInt = i1;
                if (i4 == this.B - 1) {
                    paramInt = Math.min(i1, i3 - i2);
                }
                g(-paramInt);
                if (i4 < this.B - 1) {
                    paramInt = i4 + 1;
                    d(paramInt, e(paramInt));
                    m();
                }
            }
        }
        label139:
        while (i4 != this.B - 1) {
            return;
        }
        m();
    }

    private void n() {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
            return;
        }
        this.n.clear();
    }

    private void o() {
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
    }

    private void p() {
        if (this.n != null) {
            this.n.recycle();
            this.n = null;
        }
    }

    @SuppressLint({"WrongCall"})
    private void q() {
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
            if (this.A) {
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

    private void r() {
        a(this.K);
        a(this.L);
        removeAllViewsInLayout();
        this.b = 0;
        this.A = false;
        this.D.b();
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

    protected f a(View paramView) {
        return b(paramView);
    }

    public void a() {
    }

    public void a(int paramInt) {
        f();
        a(paramInt);
        this.l = 2;
        this.s = 0;
        this.t = 0;
        invalidate();
    }

    protected void a(int paramInt1, int paramInt2) {
    }

    protected void a(int paramInt, boolean paramBoolean) {
    }

    protected void a(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
        paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
        paramView.offsetTopAndBottom(paramInt3 - paramView.getTop());
    }

    protected void a(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        paramView.layout(paramInt2, paramInt3, paramInt4, paramInt5);
    }

    protected void a(View paramView, f paramf) {
        int i2 = ViewGroup.getChildMeasureSpec(this.F, getListPaddingLeft() + getListPaddingRight(), paramf.width);
        int i1 = paramf.height;
        if (i1 > 0) {
        }
        for (i1 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824); ; i1 = View.MeasureSpec.makeMeasureSpec(0, 0)) {
            paramView.measure(i2, i1);
            return;
        }
    }

    protected void a(boolean paramBoolean) {
        int i1 = getChildCount();
        if (paramBoolean) {
            i1 += this.b;
            d(i1, c(i1));
        }
        for (; ; ) {
            b(paramBoolean);
            return;
            i1 = this.b - 1;
            e(i1, d(i1));
        }
    }

    protected int b(int paramInt) {
        return getListPaddingLeft();
    }

    protected f b(View paramView) {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
            if ((paramView instanceof f)) {
                paramView = (f) paramView;
            }
        }
        for (; ; ) {
            Object localObject = paramView;
            if (paramView == null) {
                localObject = d();
            }
            return (f) localObject;
            paramView = new f(paramView);
            continue;
            paramView = null;
        }
    }

    protected void b(boolean paramBoolean) {
        if (paramBoolean) {
            l(getChildCount());
            return;
        }
        m(getChildCount());
    }

    protected boolean b() {
        return false;
    }

    protected int c(int paramInt) {
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

    protected boolean c() {
        return false;
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
            } while ((i2 + i1 >= this.B) && (paramInt <= getHeight() - localRect.bottom));
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
            int i2 = Math.max(this.B * 100, 0);
            int i3 = getScrollY();
            int i1 = i2;
            if (i3 != 0) {
                i1 = i2 + Math.abs((int) (i3 / getHeight() * this.B * 100.0F));
            }
            return i1;
        }
        return this.B;
    }

    protected int d(int paramInt) {
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

    protected f d() {
        return new f(-1, -2, 0);
    }

    protected int e(int paramInt) {
        paramInt = getChildCount();
        if (paramInt > 0) {
            return getChildAt(paramInt - 1).getBottom();
        }
        return 0;
    }

    protected boolean e() {
        return getChildCount() > 0;
    }

    protected int f(int paramInt) {
        paramInt = getChildCount();
        if (paramInt == 0) {
        }
        while (paramInt <= 0) {
            return 0;
        }
        return getChildAt(0).getTop();
    }

    protected void f() {
        if (this.G != null) {
            e.a(this.G);
            this.G = null;
        }
    }

    public void g() {
        switch (this.l) {
            default:
                return;
            case 1:
                h(1);
                return;
            case 2:
                h(2);
                return;
        }
        h(0);
    }

    protected void g(int paramInt) {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            getChildAt(i1).offsetTopAndBottom(paramInt);
            i1 += 1;
        }
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return new f(paramLayoutParams);
    }

    public AbsListView.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new f(getContext(), paramAttributeSet);
    }

    public ListAdapter getAdapter() {
        return this.a;
    }

    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.e;
    }

    public int getCount() {
        return this.B;
    }

    @SuppressLint({"NewApi"})
    public float getCurrentVelocity() {
        if (this.G != null) {
            return e.b(this.G).getCurrVelocity();
        }
        return 0.0F;
    }

    protected int getFirstChildTop() {
        int i1 = 0;
        if (e()) {
            i1 = getChildAt(0).getTop();
        }
        return i1;
    }

    public int getFirstPosition() {
        return this.b;
    }

    public int getFirstVisiblePosition() {
        return Math.max(0, this.b - getHeaderViewsCount());
    }

    public int getFooterViewsCount() {
        return this.L.size();
    }

    public int getHeaderViewsCount() {
        return this.K.size();
    }

    protected int getHighestChildTop() {
        int i1 = 0;
        if (e()) {
            i1 = getChildAt(0).getTop();
        }
        return i1;
    }

    protected int getLastChildBottom() {
        if (e()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    public int getLastVisiblePosition() {
        int i2 = this.b;
        int i3 = getChildCount();
        if (this.a != null) {
        }
        for (int i1 = this.a.getCount() - 1; ; i1 = 0) {
            return Math.min(i2 + i3 - 1, i1);
        }
    }

    protected int getLowestChildBottom() {
        if (e()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    public int getScrollState() {
        return this.m;
    }

    public View getSelectedView() {
        return null;
    }

    protected void h() {
        if (this.Q != null) {
            this.Q.onScroll(this, this.b, getChildCount(), this.B);
        }
    }

    protected void h(int paramInt) {
        if (paramInt != this.m) {
            this.m = paramInt;
            if (this.Q != null) {
                this.Q.onScrollStateChanged(this, paramInt);
            }
        }
    }

    protected void handleDataChanged() {
        super.handleDataChanged();
        int i1 = this.B;
        if ((i1 > 0) && (this.j)) {
            this.j = false;
            this.R = null;
            this.k = 2;
            this.f = Math.min(Math.max(0, this.f), i1 - 1);
            return;
        }
        if (this.J) {
            this.J = false;
        }
        for (; ; ) {
            this.j = false;
            this.R = null;
            return;
            this.k = 1;
        }
    }

    public void i() {
        f();
        p();
    }

    void j() {
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

    protected void layoutChildren() {
        if (this.z) {
            return;
        }
        this.z = true;
        int i2;
        int i3;
        boolean bool;
        try {
            super.layoutChildren();
            invalidate();
            if (this.a == null) {
                r();
                h();
                return;
            }
            i2 = getListPaddingTop();
            i3 = getChildCount();
            if (this.k != 0) {
                break label425;
            }
            View localView = getChildAt(0);
            bool = this.A;
            if (bool) {
                handleDataChanged();
            }
            if (this.B == 0) {
                r();
                h();
                return;
            }
            if (this.B != this.a.getCount()) {
                throw new IllegalStateException("The content of the adapter has changed but ExtendableListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ExtendableListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.a.getClass() + ")]");
            }
        } finally {
            this.z = false;
        }
        int i4 = this.b;
        h localh = this.D;
        int i1;
        if (bool) {
            i1 = 0;
            while (i1 < i3) {
                localh.a(getChildAt(i1), i4 + i1);
                i1 += 1;
            }
        }
        localh.a(i3, i4);
        detachAllViewsFromParent();
        localh.d();
        switch (this.k) {
        }
        for (; ; ) {
            if (i3 == 0) {
                f(this.b, getListPaddingTop());
            }
            for (; ; ) {
                localh.e();
                this.A = false;
                this.j = false;
                this.k = 0;
                h();
                this.z = false;
                return;
                this.b = 0;
                a();
                m();
                k(i2);
                m();
                continue;
                f(this.f, this.g);
                continue;
                if (this.b < this.B) {
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

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.a != null) {
            this.A = true;
            this.C = this.B;
            this.B = this.a.getCount();
        }
        this.y = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
        this.D.b();
        if (this.G != null) {
            removeCallbacks(this.G);
        }
        if (this.N != null) {
            removeCallbacks(this.N);
        }
        if (this.I != null) {
            removeCallbacks(this.I);
        }
        if (this.O != null) {
            removeCallbacks(this.O);
        }
        if (this.H != null) {
            removeCallbacks(this.H);
        }
        Handler localHandler = getHandler();
        if (localHandler != null) {
            localHandler.removeCallbacks(this.G);
            localHandler.removeCallbacks(this.N);
            localHandler.removeCallbacks(this.I);
            localHandler.removeCallbacks(this.O);
            localHandler.removeCallbacks(this.H);
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
                        int i4 = j(i3);
                        if ((i1 != 2) && (i4 >= 0)) {
                            this.t = i2;
                            this.s = i3;
                            this.v = i4;
                            this.l = 3;
                        }
                        this.w = Integer.MIN_VALUE;
                        n();
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
            o();
            this.n.addMovement(paramMotionEvent);
        } while (!b(i1, i2));
        return true;
        this.l = 0;
        this.x = -1;
        p();
        h(0);
        return false;
        h(paramMotionEvent);
        return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.a == null) {
            r();
            return;
        }
        if (paramBoolean) {
            paramInt2 = getChildCount();
            paramInt1 = 0;
            while (paramInt1 < paramInt2) {
                getChildAt(paramInt1).forceLayout();
                paramInt1 += 1;
            }
            this.D.a();
        }
        this.r = true;
        layoutChildren();
        this.r = false;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
        this.F = paramInt1;
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (ListSavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.a());
        this.A = true;
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
        i();
        ListSavedState localListSavedState = new ListSavedState(super.onSaveInstanceState());
        if (this.R != null) {
            localListSavedState.b = this.R.b;
            localListSavedState.c = this.R.c;
            localListSavedState.d = this.R.d;
            localListSavedState.e = this.R.e;
            localListSavedState.f = this.R.f;
            return localListSavedState;
        }
        int i1;
        if ((getChildCount() > 0) && (this.B > 0)) {
            i1 = 1;
            localListSavedState.b = getSelectedItemId();
            localListSavedState.f = getHeight();
            if ((i1 == 0) || (this.b <= 0)) {
                break label183;
            }
            localListSavedState.d = getChildAt(0).getTop();
            int i2 = this.b;
            i1 = i2;
            if (i2 >= this.B) {
                i1 = this.B - 1;
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
            f();
            this.D.b();
            this.A = true;
            j();
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
            o();
            this.n.addMovement(paramMotionEvent);
        } while (!e());
        bool1 = bool2;
        switch (paramMotionEvent.getAction() & 0xFF) {
            default:
                bool1 = bool2;
        }
        for (; ; ) {
            g();
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

    public void reclaimViews(List<View> paramList) {
        int i2 = getChildCount();
        AbsListView.RecyclerListener localRecyclerListener = h.a(this.D);
        int i1 = 0;
        while (i1 < i2) {
            View localView = getChildAt(i1);
            f localf = (f) localView.getLayoutParams();
            if ((localf != null) && (this.D.b(localf.d))) {
                paramList.add(localView);
                if (localRecyclerListener != null) {
                    localRecyclerListener.onMovedToScrapHeap(localView);
                }
            }
            i1 += 1;
        }
        this.D.a(paramList);
        removeAllViewsInLayout();
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
        if (paramBoolean) {
            p();
        }
        super.requestDisallowInterceptTouchEvent(paramBoolean);
    }

    public void requestLayout() {
        if ((!this.z) && (!this.r)) {
            super.requestLayout();
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (this.a != null) {
            this.a.unregisterDataSetObserver(this.E);
        }
        if ((paramListAdapter != null) || (this.K.size() > 0) || (this.L.size() > 0)) {
            this.a = new a(this.K, this.L, paramListAdapter);
            this.A = true;
            if (this.a == null) {
                break label140;
            }
        }
        label140:
        for (int i1 = this.a.getCount(); ; i1 = 0) {
            this.B = i1;
            if (this.a != null) {
                this.a.registerDataSetObserver(this.E);
                this.D.a(this.a.getViewTypeCount());
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
            this.k = 0;
            this.g = getListPaddingTop();
            this.J = true;
            this.b = paramInt;
            if (this.j) {
                this.f = paramInt;
                this.h = this.a.getItemId(paramInt);
            }
            requestLayout();
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
        super.setOnScrollListener(paramOnScrollListener);
        this.Q = paramOnScrollListener;
    }

    public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener) {
        h.a(this.D, paramRecyclerListener);
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
        if (this.G == null) {
            this.G = new e();
        }
        int i1 = this.b;
        int i2 = getChildCount();
        int i3 = getPaddingTop();
        int i4 = getHeight();
        int i5 = getPaddingBottom();
        if ((paramInt1 == 0) || (this.B == 0) || (i2 == 0) || ((i1 == 0) && (getChildAt(0).getTop() == i3) && (paramInt1 < 0)) || ((i1 + i2 == this.B) && (getChildAt(i2 - 1).getBottom() == i4 - i5) && (paramInt1 > 0))) {
            e.a(this.G);
            return;
        }
        h(2);
        this.G.a(paramInt1, paramInt2);
    }

    public static class ListSavedState
            extends ClassLoaderSavedState {
        public static final Parcelable.Creator<ListSavedState> CREATOR = new Parcelable.Creator() {
            public ExtendableListView.ListSavedState a(Parcel paramAnonymousParcel) {
                return new ExtendableListView.ListSavedState(paramAnonymousParcel);
            }

            public ExtendableListView.ListSavedState[] a(int paramAnonymousInt) {
                return new ExtendableListView.ListSavedState[paramAnonymousInt];
            }
        };
        protected long b;
        protected long c;
        protected int d;
        protected int e;
        protected int f;

        public ListSavedState(Parcel paramParcel) {
            super();
            this.b = paramParcel.readLong();
            this.c = paramParcel.readLong();
            this.d = paramParcel.readInt();
            this.e = paramParcel.readInt();
            this.f = paramParcel.readInt();
        }

        public ListSavedState(Parcelable paramParcelable) {
            super(AbsListView.class.getClassLoader());
        }

        public String toString() {
            return "ExtendableListView.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.b + " firstId=" + this.c + " viewTop=" + this.d + " position=" + this.e + " height=" + this.f + "}";
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeLong(this.b);
            paramParcel.writeLong(this.c);
            paramParcel.writeInt(this.d);
            paramParcel.writeInt(this.e);
            paramParcel.writeInt(this.f);
        }
    }

    class a
            extends DataSetObserver {
        private Parcelable b = null;

        a() {
        }

        public void onChanged() {
            ExtendableListView.this.i();
            ExtendableListView.a(ExtendableListView.this, true);
            ExtendableListView.d(ExtendableListView.this, ExtendableListView.e(ExtendableListView.this));
            ExtendableListView.e(ExtendableListView.this, ExtendableListView.this.getAdapter().getCount());
            ExtendableListView.f(ExtendableListView.this).c();
            if ((ExtendableListView.this.getAdapter().hasStableIds()) && (this.b != null) && (ExtendableListView.g(ExtendableListView.this) == 0) && (ExtendableListView.e(ExtendableListView.this) > 0)) {
                ExtendableListView.this.onRestoreInstanceState(this.b);
                this.b = null;
            }
            for (; ; ) {
                ExtendableListView.h(ExtendableListView.this);
                ExtendableListView.this.requestLayout();
                return;
                ExtendableListView.this.j();
            }
        }

        public void onInvalidated() {
            ExtendableListView.a(ExtendableListView.this, true);
            if (ExtendableListView.this.getAdapter().hasStableIds()) {
                this.b = ExtendableListView.this.onSaveInstanceState();
            }
            ExtendableListView.d(ExtendableListView.this, ExtendableListView.e(ExtendableListView.this));
            ExtendableListView.e(ExtendableListView.this, 0);
            ExtendableListView.this.j = false;
            ExtendableListView.h(ExtendableListView.this);
            ExtendableListView.this.requestLayout();
        }
    }

    private class b
            extends ExtendableListView.i
            implements Runnable {
        private b() {
            super(null);
        }

        public void run() {
            int i = ExtendableListView.a(ExtendableListView.this);
            View localView = ExtendableListView.this.getChildAt(i);
            long l;
            if (localView != null) {
                i = ExtendableListView.a(ExtendableListView.this);
                l = ExtendableListView.this.a.getItemId(ExtendableListView.a(ExtendableListView.this) + ExtendableListView.this.b);
                if ((!b()) || (ExtendableListView.b(ExtendableListView.this))) {
                    break label136;
                }
            }
            label136:
            for (boolean bool = ExtendableListView.a(ExtendableListView.this, localView, i + ExtendableListView.this.b, l); ; bool = false) {
                if (bool) {
                    ExtendableListView.a(ExtendableListView.this, 0);
                    ExtendableListView.this.setPressed(false);
                    localView.setPressed(false);
                    return;
                }
                ExtendableListView.a(ExtendableListView.this, 5);
                return;
            }
        }
    }

    final class c
            implements Runnable {
        c() {
        }

        public void run() {
            if (ExtendableListView.c(ExtendableListView.this) == 3) {
                ExtendableListView.a(ExtendableListView.this, 4);
                View localView = ExtendableListView.this.getChildAt(ExtendableListView.a(ExtendableListView.this));
                if ((localView != null) && (!localView.hasFocusable())) {
                    ExtendableListView.b(ExtendableListView.this, 0);
                    if (ExtendableListView.b(ExtendableListView.this)) {
                        break label167;
                    }
                    ExtendableListView.this.layoutChildren();
                    localView.setPressed(true);
                    ExtendableListView.this.setPressed(true);
                    int i = ViewConfiguration.getLongPressTimeout();
                    if (!ExtendableListView.this.isLongClickable()) {
                        break label157;
                    }
                    if (ExtendableListView.d(ExtendableListView.this) == null) {
                        ExtendableListView.a(ExtendableListView.this, new ExtendableListView.b(ExtendableListView.this, null));
                    }
                    ExtendableListView.d(ExtendableListView.this).a();
                    ExtendableListView.this.postDelayed(ExtendableListView.d(ExtendableListView.this), i);
                }
            }
            return;
            label157:
            ExtendableListView.a(ExtendableListView.this, 5);
            return;
            label167:
            ExtendableListView.a(ExtendableListView.this, 5);
        }
    }

    public class d {
        public View a;
        public Object b;
        public boolean c;
    }

    private class e
            implements Runnable {
        private final OverScroller b = new OverScroller(ExtendableListView.this.getContext());
        private int c;

        e() {
        }

        private void a() {
            this.c = 0;
            ExtendableListView.a(ExtendableListView.this, 0);
            ExtendableListView.this.h(0);
            ExtendableListView.this.removeCallbacks(this);
            this.b.forceFinished(true);
        }

        void a(int paramInt) {
            if (paramInt < 0) {
            }
            for (int i = Integer.MAX_VALUE; ; i = 0) {
                this.c = i;
                this.b.forceFinished(true);
                this.b.fling(0, i, 0, paramInt, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                ExtendableListView.a(ExtendableListView.this, 2);
                ExtendableListView.a(ExtendableListView.this, this);
                return;
            }
        }

        void a(int paramInt1, int paramInt2) {
            if (paramInt1 < 0) {
            }
            for (int i = Integer.MAX_VALUE; ; i = 0) {
                this.c = i;
                this.b.startScroll(0, i, 0, paramInt1, paramInt2);
                ExtendableListView.a(ExtendableListView.this, 2);
                ExtendableListView.a(ExtendableListView.this, this);
                return;
            }
        }

        public void run() {
            switch (ExtendableListView.c(ExtendableListView.this)) {
                default:
                    return;
            }
            if ((ExtendableListView.e(ExtendableListView.this) == 0) || (ExtendableListView.this.getChildCount() == 0)) {
                a();
                return;
            }
            OverScroller localOverScroller = this.b;
            boolean bool1 = localOverScroller.computeScrollOffset();
            int j = localOverScroller.getCurrY();
            int i = this.c - j;
            if (i > 0) {
                ExtendableListView.c(ExtendableListView.this, ExtendableListView.this.b);
            }
            for (i = Math.min(ExtendableListView.this.getHeight() - ExtendableListView.this.getPaddingBottom() - ExtendableListView.this.getPaddingTop() - 1, i); ; i = Math.max(-(ExtendableListView.this.getHeight() - ExtendableListView.this.getPaddingBottom() - ExtendableListView.this.getPaddingTop() - 1), i)) {
                boolean bool2 = ExtendableListView.a(ExtendableListView.this, i, i);
                if ((!bool1) || (bool2)) {
                    break;
                }
                ExtendableListView.this.invalidate();
                this.c = j;
                ExtendableListView.a(ExtendableListView.this, this);
                return;
                int k = ExtendableListView.this.getChildCount();
                ExtendableListView.c(ExtendableListView.this, k - 1 + ExtendableListView.this.b);
            }
            a();
        }
    }

    public static class f
            extends AbsListView.LayoutParams {
        boolean a;
        int b;
        long c = -1L;
        int d;

        public f(int paramInt1, int paramInt2) {
            super(paramInt2);
        }

        public f(int paramInt1, int paramInt2, int paramInt3) {
            super(paramInt2);
            this.d = paramInt3;
        }

        public f(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
        }

        public f(ViewGroup.LayoutParams paramLayoutParams) {
            super();
        }
    }

    private class g
            extends ExtendableListView.i
            implements Runnable {
        int a;

        private g() {
            super(null);
        }

        public void run() {
            if (ExtendableListView.b(ExtendableListView.this)) {
            }
            ListAdapter localListAdapter;
            int i;
            View localView;
            int j;
            do {
                do {
                    do {
                        return;
                        localListAdapter = ExtendableListView.this.a;
                        i = this.a;
                    }
                    while ((localListAdapter == null) || (ExtendableListView.e(ExtendableListView.this) <= 0) || (i == -1) || (i >= localListAdapter.getCount()) || (!b()));
                    localView = ExtendableListView.this.getChildAt(i);
                } while (localView == null);
                i += ExtendableListView.this.b;
                j = ExtendableListView.this.getHeaderViewsCount();
            } while ((i < j) || (i >= localListAdapter.getCount() - ExtendableListView.this.getFooterViewsCount()));
            ExtendableListView.this.performItemClick(localView, i - j, localListAdapter.getItemId(i));
        }
    }

    class h {
        private AbsListView.RecyclerListener b;
        private int c;
        private View[] d = new View[0];
        private ArrayList<View>[] e;
        private int f;
        private ArrayList<View> g;
        private ArrayList<View> h;
        private SparseArrayCompat<View> i;

        h() {
        }

        private void f() {
            int n = 0;
            int i1 = this.d.length;
            int i2 = this.f;
            ArrayList[] arrayOfArrayList = this.e;
            int j = 0;
            int k;
            while (j < i2) {
                ArrayList localArrayList = arrayOfArrayList[j];
                int i3 = localArrayList.size();
                k = i3 - 1;
                int m = 0;
                while (m < i3 - i1) {
                    ExtendableListView.e(ExtendableListView.this, (View) localArrayList.remove(k), false);
                    m += 1;
                    k -= 1;
                }
                j += 1;
            }
            if (this.i != null) {
                for (j = n; j < this.i.size(); j = k + 1) {
                    k = j;
                    if (!ViewCompat.hasTransientState((View) this.i.valueAt(j))) {
                        this.i.removeAt(j);
                        k = j - 1;
                    }
                }
            }
        }

        public void a() {
            int m = 0;
            ArrayList localArrayList;
            int k;
            if (this.f == 1) {
                localArrayList = this.g;
                k = localArrayList.size();
                j = 0;
                while (j < k) {
                    ((View) localArrayList.get(j)).forceLayout();
                    j += 1;
                }
            }
            int n = this.f;
            int j = 0;
            while (j < n) {
                localArrayList = this.e[j];
                int i1 = localArrayList.size();
                k = 0;
                while (k < i1) {
                    ((View) localArrayList.get(k)).forceLayout();
                    k += 1;
                }
                j += 1;
            }
            if (this.i != null) {
                k = this.i.size();
                j = m;
                while (j < k) {
                    ((View) this.i.valueAt(j)).forceLayout();
                    j += 1;
                }
            }
        }

        public void a(int paramInt) {
            if (paramInt < 1) {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
            ArrayList[] arrayOfArrayList = new ArrayList[paramInt];
            int j = 0;
            while (j < paramInt) {
                arrayOfArrayList[j] = new ArrayList();
                j += 1;
            }
            this.f = paramInt;
            this.g = arrayOfArrayList[0];
            this.e = arrayOfArrayList;
        }

        void a(int paramInt1, int paramInt2) {
            if (this.d.length < paramInt1) {
                this.d = new View[paramInt1];
            }
            this.c = paramInt2;
            View[] arrayOfView = this.d;
            paramInt2 = 0;
            while (paramInt2 < paramInt1) {
                View localView = ExtendableListView.this.getChildAt(paramInt2);
                ExtendableListView.f localf = (ExtendableListView.f) localView.getLayoutParams();
                if ((localf != null) && (localf.d != -2)) {
                    arrayOfView[paramInt2] = localView;
                }
                paramInt2 += 1;
            }
        }

        void a(View paramView, int paramInt) {
            ExtendableListView.f localf = (ExtendableListView.f) paramView.getLayoutParams();
            if (localf == null) {
            }
            for (; ; ) {
                return;
                localf.b = paramInt;
                int j = localf.d;
                boolean bool = ViewCompat.hasTransientState(paramView);
                if ((!b(j)) || (bool)) {
                    if ((j != -2) || (bool)) {
                        if (this.h == null) {
                            this.h = new ArrayList();
                        }
                        this.h.add(paramView);
                    }
                    if (bool) {
                        if (this.i == null) {
                            this.i = new SparseArrayCompat();
                        }
                        this.i.put(paramInt, paramView);
                    }
                } else {
                    if (this.f == 1) {
                        this.g.add(paramView);
                    }
                    while (this.b != null) {
                        this.b.onMovedToScrapHeap(paramView);
                        return;
                        this.e[j].add(paramView);
                    }
                }
            }
        }

        void a(List<View> paramList) {
            if (this.f == 1) {
                paramList.addAll(this.g);
            }
            for (; ; ) {
                return;
                int k = this.f;
                ArrayList[] arrayOfArrayList = this.e;
                int j = 0;
                while (j < k) {
                    paramList.addAll(arrayOfArrayList[j]);
                    j += 1;
                }
            }
        }

        void b() {
            ArrayList localArrayList;
            int k;
            if (this.f == 1) {
                localArrayList = this.g;
                k = localArrayList.size();
                j = 0;
                while (j < k) {
                    ExtendableListView.a(ExtendableListView.this, (View) localArrayList.remove(k - 1 - j), false);
                    j += 1;
                }
            }
            int m = this.f;
            int j = 0;
            while (j < m) {
                localArrayList = this.e[j];
                int n = localArrayList.size();
                k = 0;
                while (k < n) {
                    ExtendableListView.b(ExtendableListView.this, (View) localArrayList.remove(n - 1 - k), false);
                    k += 1;
                }
                j += 1;
            }
            if (this.i != null) {
                this.i.clear();
            }
        }

        public boolean b(int paramInt) {
            return paramInt >= 0;
        }

        View c(int paramInt) {
            paramInt -= this.c;
            View[] arrayOfView = this.d;
            if ((paramInt >= 0) && (paramInt < arrayOfView.length)) {
                View localView = arrayOfView[paramInt];
                arrayOfView[paramInt] = null;
                return localView;
            }
            return null;
        }

        void c() {
            if (this.i != null) {
                this.i.clear();
            }
        }

        View d(int paramInt) {
            if (this.f == 1) {
                return ExtendableListView.a(this.g, paramInt);
            }
            int j = ExtendableListView.this.a.getItemViewType(paramInt);
            if ((j >= 0) && (j < this.e.length)) {
                return ExtendableListView.a(this.e[j], paramInt);
            }
            return null;
        }

        void d() {
            if (this.h == null) {
                return;
            }
            int k = this.h.size();
            int j = 0;
            while (j < k) {
                ExtendableListView.c(ExtendableListView.this, (View) this.h.get(j), false);
                j += 1;
            }
            this.h.clear();
        }

        void e() {
            View[] arrayOfView = this.d;
            int j;
            int k;
            label25:
            Object localObject1;
            int m;
            label37:
            View localView;
            Object localObject2;
            int n;
            if (this.f > 1) {
                j = 1;
                if (this.b == null) {
                    break label183;
                }
                k = 1;
                localObject1 = this.g;
                m = arrayOfView.length - 1;
                if (m < 0) {
                    break label246;
                }
                localView = arrayOfView[m];
                localObject2 = localObject1;
                if (localView != null) {
                    localObject2 = (ExtendableListView.f) localView.getLayoutParams();
                    arrayOfView[m] = null;
                    boolean bool = ViewCompat.hasTransientState(localView);
                    n = ((ExtendableListView.f) localObject2).d;
                    if ((b(n)) && (!bool)) {
                        break label188;
                    }
                    if ((n != -2) || (bool)) {
                        ExtendableListView.d(ExtendableListView.this, localView, false);
                    }
                    localObject2 = localObject1;
                    if (bool) {
                        if (this.i == null) {
                            this.i = new SparseArrayCompat();
                        }
                        this.i.put(this.c + m, localView);
                        localObject2 = localObject1;
                    }
                }
            }
            for (; ; ) {
                m -= 1;
                localObject1 = localObject2;
                break label37;
                j = 0;
                break;
                label183:
                k = 0;
                break label25;
                label188:
                if (j != 0) {
                    localObject1 = this.e[n];
                }
                ((ExtendableListView.f) localObject2).b = (this.c + m);
                ((ArrayList) localObject1).add(localView);
                localObject2 = localObject1;
                if (k != 0) {
                    this.b.onMovedToScrapHeap(localView);
                    localObject2 = localObject1;
                }
            }
            label246:
            f();
        }
    }

    private class i {
        private int a;

        private i() {
        }

        public void a() {
            this.a = ExtendableListView.i(ExtendableListView.this);
        }

        public boolean b() {
            return (ExtendableListView.this.hasWindowFocus()) && (ExtendableListView.j(ExtendableListView.this) == this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/etsy/staggeredgrid/ExtendableListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */