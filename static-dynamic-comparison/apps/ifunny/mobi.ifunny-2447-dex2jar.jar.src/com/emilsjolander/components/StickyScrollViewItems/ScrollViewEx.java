package com.emilsjolander.components.StickyScrollViewItems;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.bd;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;

import java.util.ArrayList;
import java.util.List;

public class ScrollViewEx
        extends FrameLayout {
    protected boolean a = false;
    protected VelocityTracker b;
    private long c;
    private final Rect d = new Rect();
    private OverScroller e;
    private EdgeEffect f;
    private EdgeEffect g;
    private int h;
    private boolean i = true;
    private View j = null;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean k;
    private boolean l = true;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r = -1;
    private ScrollViewEx.SavedState s;
    private boolean t;
    private float u;

    public ScrollViewEx(Context paramContext) {
        this(paramContext, null);
    }

    public ScrollViewEx(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 16842879);
    }

    public ScrollViewEx(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
        setFillViewport(true);
    }

    private View a(boolean paramBoolean, int paramInt1, int paramInt2) {
        ArrayList localArrayList = getFocusables(2);
        Object localObject2 = null;
        int i1 = 0;
        int i5 = localArrayList.size();
        int i3 = 0;
        Object localObject1;
        int i4;
        int i6;
        int i2;
        if (i3 < i5) {
            localObject1 = (View) localArrayList.get(i3);
            i4 = ((View) localObject1).getTop();
            i6 = ((View) localObject1).getBottom();
            if ((paramInt1 >= i6) || (i4 >= paramInt2)) {
                break label192;
            }
            if ((paramInt1 < i4) && (i6 < paramInt2)) {
                i2 = 1;
                label87:
                if (localObject2 != null) {
                    break label115;
                }
                i1 = i2;
            }
        }
        for (; ; ) {
            i3 += 1;
            localObject2 = localObject1;
            break;
            i2 = 0;
            break label87;
            label115:
            if (((paramBoolean) && (i4 < ((View) localObject2).getTop())) || ((!paramBoolean) && (i6 > ((View) localObject2).getBottom()))) {
            }
            for (i4 = 1; ; i4 = 0) {
                if (i1 == 0) {
                    break label170;
                }
                if ((i2 == 0) || (i4 == 0)) {
                    break label192;
                }
                break;
            }
            label170:
            if (i2 != 0) {
                i1 = 1;
            } else if (i4 != 0) {
                continue;
                return (View) localObject2;
            } else {
                label192:
                localObject1 = localObject2;
            }
        }
    }

    private void a() {
        this.e = new OverScroller(getContext(), null, 0.0F, 0.0F, true);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
        this.m = localViewConfiguration.getScaledTouchSlop();
        this.n = (localViewConfiguration.getScaledMinimumFlingVelocity() / 2);
        this.o = localViewConfiguration.getScaledMaximumFlingVelocity();
        this.p = localViewConfiguration.getScaledOverscrollDistance();
        this.q = localViewConfiguration.getScaledOverflingDistance();
    }

    private void a(int paramInt) {
        if (paramInt != 0) {
            if (this.l) {
                a(0, paramInt);
            }
        } else {
            return;
        }
        scrollBy(0, paramInt);
    }

    private void a(MotionEvent paramMotionEvent) {
        int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        if (paramMotionEvent.getPointerId(i1) == this.r) {
            if (i1 != 0) {
                break label63;
            }
        }
        label63:
        for (i1 = 1; ; i1 = 0) {
            this.h = ((int) paramMotionEvent.getY(i1));
            this.r = paramMotionEvent.getPointerId(i1);
            if (this.b != null) {
                this.b.clear();
            }
            return;
        }
    }

    private boolean a(int paramInt1, int paramInt2, int paramInt3) {
        boolean bool2 = false;
        int i2 = getHeight();
        int i1 = getScrollY();
        i2 = i1 + i2;
        if (paramInt1 == 33) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            View localView = a(bool1, paramInt2, paramInt3);
            Object localObject = localView;
            if (localView == null) {
                localObject = this;
            }
            if ((paramInt2 < i1) || (paramInt3 > i2)) {
                break;
            }
            bool1 = bool2;
            if (localObject != findFocus()) {
                ((View) localObject).requestFocus(paramInt1);
            }
            return bool1;
        }
        if (bool1) {
            paramInt2 -= i1;
        }
        for (; ; ) {
            a(paramInt2);
            bool1 = true;
            break;
            paramInt2 = paramInt3 - i2;
        }
    }

    private boolean a(Rect paramRect, boolean paramBoolean) {
        int i1 = a(paramRect);
        if (i1 != 0) {
        }
        for (boolean bool = true; ; bool = false) {
            if (bool) {
                if (!paramBoolean) {
                    break;
                }
                scrollBy(0, i1);
            }
            return bool;
        }
        a(0, i1);
        return bool;
    }

    private boolean a(View paramView) {
        boolean bool = false;
        if (!a(paramView, 0, getHeight())) {
            bool = true;
        }
        return bool;
    }

    private boolean a(View paramView, int paramInt1, int paramInt2) {
        paramView.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(paramView, this.d);
        return (this.d.bottom + paramInt1 >= getScrollY()) && (this.d.top - paramInt1 <= getScrollY() + paramInt2);
    }

    private static boolean a(View paramView1, View paramView2) {
        if (paramView1 == paramView2) {
            return true;
        }
        paramView1 = paramView1.getParent();
        if (((paramView1 instanceof ViewGroup)) && (a((View) paramView1, paramView2))) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    private static int b(int paramInt1, int paramInt2, int paramInt3) {
        int i1;
        if ((paramInt2 >= paramInt3) || (paramInt1 < 0)) {
            i1 = 0;
        }
        do {
            return i1;
            i1 = paramInt1;
        } while (paramInt2 + paramInt1 <= paramInt3);
        return paramInt3 - paramInt2;
    }

    private void b(View paramView) {
        paramView.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(paramView, this.d);
        int i1 = a(this.d);
        if (i1 != 0) {
            scrollBy(0, i1);
        }
    }

    private boolean b() {
        boolean bool2 = false;
        View localView = getChildAt(0);
        boolean bool1 = bool2;
        if (localView != null) {
            int i1 = localView.getHeight();
            bool1 = bool2;
            if (getHeight() < i1 + getPaddingTop() + getPaddingBottom()) {
                bool1 = true;
            }
        }
        return bool1;
    }

    private boolean c(int paramInt1, int paramInt2) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (getChildCount() > 0) {
            int i1 = getScrollY();
            View localView = getChildAt(0);
            bool1 = bool2;
            if (paramInt2 >= localView.getTop() - i1) {
                bool1 = bool2;
                if (paramInt2 < localView.getBottom() - i1) {
                    bool1 = bool2;
                    if (paramInt1 >= localView.getLeft()) {
                        bool1 = bool2;
                        if (paramInt1 < localView.getRight()) {
                            bool1 = true;
                        }
                    }
                }
            }
        }
        return bool1;
    }

    private void g() {
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
            return;
        }
        this.b.clear();
    }

    private void h() {
        if (this.b == null) {
            this.b = VelocityTracker.obtain();
        }
    }

    private void i() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
    }

    protected int a(Rect paramRect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int i4 = getHeight();
        int i1 = getScrollY();
        int i3 = i1 + i4;
        int i5 = getVerticalFadingEdgeLength();
        int i2 = i1;
        if (paramRect.top > 0) {
            i2 = i1 + i5;
        }
        i1 = i3;
        if (paramRect.bottom < getChildAt(0).getHeight()) {
            i1 = i3 - i5;
        }
        if ((paramRect.bottom > i1) && (paramRect.top > i2)) {
            if (paramRect.height() > i4) {
                i2 = paramRect.top - i2 + 0;
                i1 = Math.min(i2, getChildAt(0).getBottom() - i1);
            }
        }
        for (; ; ) {
            return i1;
            i2 = paramRect.bottom - i1 + 0;
            break;
            if ((paramRect.top < i2) && (paramRect.bottom < i1)) {
                if (paramRect.height() > i4) {
                }
                for (i1 = 0 - (i1 - paramRect.bottom); ; i1 = 0 - (i2 - paramRect.top)) {
                    i1 = Math.max(i1, -getScrollY());
                    break;
                }
            }
            i1 = 0;
        }
    }

    public final void a(int paramInt1, int paramInt2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.c > 250L) {
            int i1 = getHeight();
            int i2 = getPaddingBottom();
            int i3 = getPaddingTop();
            i2 = Math.max(0, getChildAt(0).getHeight() - (i1 - i2 - i3));
            i1 = getScrollY();
            paramInt1 = Math.max(0, Math.min(i1 + paramInt1, i2));
            this.e.startScroll(getScrollX(), i1, 0, paramInt1 - i1, paramInt2);
            bd.c(this);
        }
        for (; ; ) {
            this.c = AnimationUtils.currentAnimationTimeMillis();
            return;
            if (!this.e.isFinished()) {
                this.e.abortAnimation();
            }
            scrollBy(0, paramInt1);
        }
    }

    protected void a(boolean paramBoolean) {
    }

    public boolean a(KeyEvent paramKeyEvent) {
        int i1 = 33;
        boolean bool2 = false;
        this.d.setEmpty();
        boolean bool1;
        if (!b()) {
            bool1 = bool2;
            if (isFocused()) {
                bool1 = bool2;
                if (paramKeyEvent.getKeyCode() != 4) {
                    View localView = findFocus();
                    paramKeyEvent = localView;
                    if (localView == this) {
                        paramKeyEvent = null;
                    }
                    paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
                    if ((paramKeyEvent == null) || (paramKeyEvent == this) || (!paramKeyEvent.requestFocus(130))) {
                        break label93;
                    }
                    bool1 = true;
                }
            }
        }
        label93:
        do {
            for (; ; ) {
                return bool1;
                bool1 = false;
            }
            bool1 = bool2;
        } while (paramKeyEvent.getAction() != 0);
        switch (paramKeyEvent.getKeyCode()) {
            default:
                return false;
            case 19:
                if (!paramKeyEvent.isAltPressed()) {
                    return d(33);
                }
                return c(33);
            case 20:
                if (!paramKeyEvent.isAltPressed()) {
                    return d(130);
                }
                return c(130);
        }
        if (paramKeyEvent.isShiftPressed()) {
        }
        for (; ; ) {
            b(i1);
            return false;
            i1 = 130;
        }
    }

    public void addView(View paramView) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(paramView);
    }

    public void addView(View paramView, int paramInt) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(paramView, paramInt);
    }

    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(paramView, paramInt, paramLayoutParams);
    }

    public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(paramView, paramLayoutParams);
    }

    public final void b(int paramInt1, int paramInt2) {
        a(paramInt1 - getScrollX(), paramInt2 - getScrollY());
    }

    protected void b(VelocityTracker paramVelocityTracker, MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, int paramInt) {
        if (!this.e.isFinished()) {
            this.e.forceFinished(true);
        }
        if ((paramMotionEvent2.getActionMasked() == 1) || (paramMotionEvent2.getActionMasked() == 1) || (paramInt == -1)) {
            paramVelocityTracker.addMovement(paramMotionEvent2);
            paramVelocityTracker.computeCurrentVelocity(1000, this.o);
            paramInt = (int) paramVelocityTracker.getYVelocity(this.r);
            paramVelocityTracker.recycle();
            if ((getChildCount() > 0) && (Math.abs(paramInt) > this.n)) {
                f(-paramInt);
            }
        }
        label133:
        label172:
        label217:
        label259:
        label307:
        label425:
        label466:
        label473:
        label485:
        label489:
        label491:
        label532:
        for (; ; ) {
            return;
            f();
            this.r = paramInt;
            paramInt = paramMotionEvent1.findPointerIndex(paramInt);
            int i1;
            int i2;
            if (paramInt >= 0) {
                this.h = ((int) paramMotionEvent1.getY(paramInt));
                paramInt = paramMotionEvent2.getActionMasked();
                if (paramInt != 5) {
                    break label425;
                }
                paramInt = paramMotionEvent2.getActionIndex();
                this.h = ((int) paramMotionEvent2.getY(paramInt));
                this.r = paramMotionEvent2.getPointerId(paramInt);
                i1 = paramMotionEvent2.findPointerIndex(this.r);
                paramInt = i1;
                if (i1 == -1) {
                    this.r = paramMotionEvent2.getPointerId(0);
                    paramInt = 0;
                }
                if (paramVelocityTracker == null) {
                    break label466;
                }
                i();
                this.b = paramVelocityTracker;
                this.a = true;
                a(true);
                i1 = (int) paramMotionEvent2.getY(paramInt);
                paramInt = this.h - i1;
                if (paramInt <= 0) {
                    break label473;
                }
                paramInt -= this.m;
                this.h = i1;
                getScrollX();
                int i3 = getScrollY();
                i2 = getScrollRange();
                i1 = getOverScrollMode();
                if ((i1 != 0) && ((i1 != 1) || (i2 <= 0))) {
                    break label485;
                }
                i1 = 1;
                if ((overScrollBy(0, paramInt, 0, getScrollY(), 0, i2, 0, this.p, true)) && (i1 == 0)) {
                    break label489;
                }
                i1 = i3 + paramInt;
                if (i1 >= 0) {
                    break label491;
                }
                this.f.onPull(paramInt / getHeight());
                if (!this.g.isFinished()) {
                    this.g.onRelease();
                }
            }
            for (; ; ) {
                if ((this.f == null) || ((this.f.isFinished()) && (this.g.isFinished()))) {
                    break label532;
                }
                bd.c(this);
                return;
                this.h = ((int) paramMotionEvent1.getY());
                break label133;
                if (paramInt != 6) {
                    break label172;
                }
                a(paramMotionEvent2);
                paramInt = paramMotionEvent2.findPointerIndex(this.r);
                if (paramInt < 0) {
                    break label172;
                }
                this.h = ((int) paramMotionEvent2.getY(paramInt));
                break label172;
                g();
                break label217;
                paramInt = this.m + paramInt;
                break label259;
                i1 = 0;
                break label307;
                break;
                if (i1 > i2) {
                    this.g.onPull(paramInt / getHeight());
                    if (!this.f.isFinished()) {
                        this.f.onRelease();
                    }
                }
            }
        }
    }

    public boolean b(int paramInt) {
        int i1;
        int i2;
        if (paramInt == 130) {
            i1 = 1;
            i2 = getHeight();
            if (i1 == 0) {
                break label121;
            }
            this.d.top = (getScrollY() + i2);
            i1 = getChildCount();
            if (i1 > 0) {
                View localView = getChildAt(i1 - 1);
                if (this.d.top + i2 > localView.getBottom()) {
                    this.d.top = (localView.getBottom() - i2);
                }
            }
        }
        for (; ; ) {
            this.d.bottom = (this.d.top + i2);
            return a(paramInt, this.d.top, this.d.bottom);
            i1 = 0;
            break;
            label121:
            this.d.top = (getScrollY() - i2);
            if (this.d.top < 0) {
                this.d.top = 0;
            }
        }
    }

    public VelocityTracker c() {
        VelocityTracker localVelocityTracker = this.b;
        this.b = null;
        return localVelocityTracker;
    }

    public boolean c(int paramInt) {
        if (paramInt == 130) {
        }
        for (int i1 = 1; ; i1 = 0) {
            int i2 = getHeight();
            this.d.top = 0;
            this.d.bottom = i2;
            if (i1 != 0) {
                i1 = getChildCount();
                if (i1 > 0) {
                    View localView = getChildAt(i1 - 1);
                    this.d.bottom = (localView.getBottom() + getPaddingBottom());
                    this.d.top = (this.d.bottom - i2);
                }
            }
            return a(paramInt, this.d.top, this.d.bottom);
        }
    }

    public boolean canScrollVertically(int paramInt) {
        boolean bool = true;
        if (!b()) {
            bool = false;
        }
        do {
            do {
                return bool;
                if (paramInt <= 0) {
                    break;
                }
            } while (getScrollY() < getScrollRange());
            return false;
        } while (getScrollY() > 0);
        return false;
    }

    public void computeScroll() {
        int i3;
        int i5;
        int i6;
        int i1;
        if (this.e.computeScrollOffset()) {
            int i2 = getScrollX();
            i3 = getScrollY();
            int i4 = this.e.getCurrX();
            i5 = this.e.getCurrY();
            if ((i2 != i4) || (i3 != i5)) {
                i6 = getScrollRange();
                i1 = getOverScrollMode();
                if ((i1 != 0) && ((i1 != 1) || (i6 <= 0))) {
                    break label155;
                }
                i1 = 1;
                overScrollBy(i4 - i2, i5 - i3, i2, i3, 0, i6, 0, this.q, false);
                onScrollChanged(getScrollX(), getScrollY(), i2, i3);
                if (i1 != 0) {
                    if ((i5 >= 0) || (i3 < 0)) {
                        break label160;
                    }
                    this.f.onAbsorb((int) this.e.getCurrVelocity());
                }
            }
        }
        for (; ; ) {
            if (!awakenScrollBars()) {
                bd.c(this);
            }
            return;
            label155:
            i1 = 0;
            break;
            label160:
            if ((i5 > i6) && (i3 <= i6)) {
                this.g.onAbsorb((int) this.e.getCurrVelocity());
            }
        }
    }

    protected int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    protected int computeVerticalScrollRange() {
        int i2 = getChildCount();
        int i1 = getHeight() - getPaddingBottom() - getPaddingTop();
        if (i2 == 0) {
        }
        int i3;
        int i4;
        do {
            return i1;
            i2 = getChildAt(0).getBottom();
            i3 = getScrollY();
            i4 = Math.max(0, i2 - i1);
            if (i3 < 0) {
                return i2 - i3;
            }
            i1 = i2;
        } while (i3 <= i4);
        return i2 + (i3 - i4);
    }

    public void d() {
        if (!this.e.isFinished()) {
            this.e.forceFinished(true);
        }
    }

    public boolean d(int paramInt) {
        View localView2 = findFocus();
        View localView1 = localView2;
        if (localView2 == this) {
            localView1 = null;
        }
        localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
        int i2 = getMaxScrollAmount();
        if ((localView2 != null) && (a(localView2, i2, getHeight()))) {
            localView2.getDrawingRect(this.d);
            offsetDescendantRectToMyCoords(localView2, this.d);
            a(a(this.d));
            localView2.requestFocus(paramInt);
            if ((localView1 != null) && (localView1.isFocused()) && (a(localView1))) {
                paramInt = getDescendantFocusability();
                setDescendantFocusability(131072);
                requestFocus();
                setDescendantFocusability(paramInt);
            }
            return true;
        }
        int i1;
        if ((paramInt == 33) && (getScrollY() < i2)) {
            i1 = getScrollY();
        }
        while (i1 == 0) {
            return false;
            i1 = i2;
            if (paramInt == 130) {
                i1 = i2;
                if (getChildCount() > 0) {
                    int i3 = getChildAt(0).getBottom();
                    int i4 = getScrollY() + getHeight() - getPaddingBottom();
                    i1 = i2;
                    if (i3 - i4 < i2) {
                        i1 = i3 - i4;
                    }
                }
            }
        }
        if (paramInt == 130) {
        }
        for (; ; ) {
            a(i1);
            break;
            i1 = -i1;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        if (this.f != null) {
            int i1 = getScrollY();
            int i2;
            int i3;
            int i4;
            if (!this.f.isFinished()) {
                i2 = paramCanvas.save();
                i3 = getWidth();
                i4 = getPaddingLeft();
                int i5 = getPaddingRight();
                paramCanvas.translate(getPaddingLeft(), Math.min(0, i1));
                this.f.setSize(i3 - i4 - i5, getHeight());
                if (this.f.draw(paramCanvas)) {
                    bd.c(this);
                }
                paramCanvas.restoreToCount(i2);
            }
            if (!this.g.isFinished()) {
                i2 = paramCanvas.save();
                i3 = getWidth() - getPaddingLeft() - getPaddingRight();
                i4 = getHeight();
                paramCanvas.translate(-i3 + getPaddingLeft(), Math.max(getScrollRange(), i1) + i4);
                paramCanvas.rotate(180.0F, i3, 0.0F);
                this.g.setSize(i3, i4);
                if (this.g.draw(paramCanvas)) {
                    bd.c(this);
                }
                paramCanvas.restoreToCount(i2);
            }
        }
    }

    public void e(int paramInt) {
        if (getChildCount() > 0) {
            int i1 = getHeight() - getPaddingBottom() - getPaddingTop();
            int i2 = getChildAt(0).getHeight();
            a(false);
            this.e.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, 0, Math.max(0, i2 - i1), 0, i1 / 2);
            bd.c(this);
        }
    }

    public boolean e() {
        return this.a;
    }

    protected void f() {
        this.r = -1;
        this.a = false;
        i();
        if (this.f != null) {
            this.f.onRelease();
            this.g.onRelease();
        }
    }

    public void f(int paramInt) {
        f();
        e(paramInt);
    }

    public int getActivePointerId() {
        return this.r;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0F;
        }
        int i1 = getVerticalFadingEdgeLength();
        int i2 = getHeight();
        int i3 = getPaddingBottom();
        i2 = getChildAt(0).getBottom() - getScrollY() - (i2 - i3);
        if (i2 < i1) {
            return i2 / i1;
        }
        return 1.0F;
    }

    public float getCurrentFlingVelocity() {
        return this.e.getCurrVelocity();
    }

    public int getMaxScrollAmount() {
        return (int) (0.5F * (getBottom() - getTop()));
    }

    protected int getScrollRange() {
        int i1 = 0;
        if (getChildCount() > 0) {
            i1 = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
        }
        return i1;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0F;
        }
        int i1 = getVerticalFadingEdgeLength();
        if (getScrollY() < i1) {
            return getScrollY() / i1;
        }
        return 1.0F;
    }

    protected float getVerticalScrollFactor() {
        if (this.u == 0.0F) {
            TypedValue localTypedValue = new TypedValue();
            if (!getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.u = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
        }
        return this.u;
    }

    protected void measureChild(View paramView, int paramInt1, int paramInt2) {
        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
        paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams) paramView.getLayoutParams();
        paramInt1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
        paramInt2 = localMarginLayoutParams.topMargin;
        paramView.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.bottomMargin + paramInt2, 0));
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t = false;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
            switch (paramMotionEvent.getAction()) {
            }
        }
        for (; ; ) {
            return super.onGenericMotionEvent(paramMotionEvent);
            if (!this.a) {
                float f1 = paramMotionEvent.getAxisValue(9);
                if (f1 != 0.0F) {
                    int i1 = (int) (f1 * getVerticalScrollFactor());
                    int i2 = getScrollRange();
                    int i4 = getScrollY();
                    int i3 = i4 - i1;
                    if (i3 < 0) {
                        i1 = 0;
                    }
                    while (i1 != i4) {
                        super.scrollTo(getScrollX(), i1);
                        return true;
                        i1 = i2;
                        if (i3 <= i2) {
                            i1 = i3;
                        }
                    }
                }
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
        paramAccessibilityEvent.setClassName(ScrollViewEx.class.getName());
        if (getScrollRange() > 0) {
        }
        for (boolean bool = true; ; bool = false) {
            paramAccessibilityEvent.setScrollable(bool);
            paramAccessibilityEvent.setScrollX(getScrollX());
            paramAccessibilityEvent.setScrollY(getScrollY());
            paramAccessibilityEvent.setMaxScrollX(getScrollX());
            paramAccessibilityEvent.setMaxScrollY(getScrollRange());
            return;
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setClassName(ScrollViewEx.class.getName());
        if (isEnabled()) {
            int i1 = getScrollRange();
            if (i1 > 0) {
                paramAccessibilityNodeInfo.setScrollable(true);
                if (getScrollY() > 0) {
                    paramAccessibilityNodeInfo.addAction(8192);
                }
                if (getScrollY() < i1) {
                    paramAccessibilityNodeInfo.addAction(4096);
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool = true;
        int i1 = paramMotionEvent.getAction();
        if ((i1 == 2) && (this.a)) {
            return true;
        }
        if ((getScrollY() == 0) && (!canScrollVertically(1))) {
            return false;
        }
        switch (i1 & 0xFF) {
        }
        for (; ; ) {
            return this.a;
            i1 = this.r;
            if (i1 != -1) {
                int i2 = paramMotionEvent.findPointerIndex(i1);
                if (i2 == -1) {
                    Log.e("ScrollView", "Invalid pointerId=" + i1 + " in onInterceptTouchEvent");
                } else {
                    i1 = (int) paramMotionEvent.getY(i2);
                    if (Math.abs(i1 - this.h) > this.m) {
                        this.a = true;
                        this.h = i1;
                        h();
                        this.b.addMovement(paramMotionEvent);
                        paramMotionEvent = getParent();
                        if (paramMotionEvent != null) {
                            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
                            continue;
                            i1 = (int) paramMotionEvent.getY();
                            if (!c((int) paramMotionEvent.getX(), i1)) {
                                this.a = false;
                                i();
                            } else {
                                this.h = i1;
                                this.r = paramMotionEvent.getPointerId(0);
                                g();
                                this.b.addMovement(paramMotionEvent);
                                if (!this.e.isFinished()) {
                                }
                                for (; ; ) {
                                    this.a = bool;
                                    break;
                                    bool = false;
                                }
                                f();
                                continue;
                                a(paramMotionEvent);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        this.i = false;
        if ((this.j != null) && (a(this.j, this))) {
            b(this.j);
        }
        this.j = null;
        if (!this.t) {
            if (this.s != null) {
                setScrollY(this.s.a);
                this.s = null;
            }
            if (getChildCount() <= 0) {
                break label145;
            }
            paramInt1 = getChildAt(0).getMeasuredHeight();
            paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
            if (getScrollY() <= paramInt1) {
                break label150;
            }
            setScrollY(paramInt1);
        }
        for (; ; ) {
            scrollTo(getScrollX(), getScrollY());
            this.t = true;
            return;
            label145:
            paramInt1 = 0;
            break;
            label150:
            if (getScrollY() < 0) {
                setScrollY(0);
            }
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        if (!this.k) {
        }
        View localView;
        do {
            do {
                return;
            } while ((View.MeasureSpec.getMode(paramInt2) == 0) || (getChildCount() <= 0));
            localView = getChildAt(0);
            paramInt2 = getMeasuredHeight();
        } while (localView.getMeasuredHeight() >= paramInt2);
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams) localView.getLayoutParams();
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
    }

    protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        if (!this.e.isFinished()) {
            getScrollY();
            setScrollY(paramInt2);
        }
        for (; ; ) {
            awakenScrollBars();
            return;
            super.scrollTo(paramInt1, paramInt2);
        }
    }

    protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
        int i1;
        View localView;
        if (paramInt == 2) {
            i1 = 130;
            if (paramRect != null) {
                break label44;
            }
            localView = FocusFinder.getInstance().findNextFocus(this, null, i1);
            label24:
            if (localView != null) {
                break label58;
            }
        }
        label44:
        label58:
        while (a(localView)) {
            return false;
            i1 = paramInt;
            if (paramInt != 1) {
                break;
            }
            i1 = 33;
            break;
            localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i1);
            break label24;
        }
        return localView.requestFocus(i1, paramRect);
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (ScrollViewEx.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        this.s = paramParcelable;
    }

    protected Parcelable onSaveInstanceState() {
        ScrollViewEx.SavedState localSavedState = new ScrollViewEx.SavedState(super.onSaveInstanceState());
        localSavedState.a = getScrollY();
        return localSavedState;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        View localView = findFocus();
        if ((localView == null) || (this == localView)) {
        }
        while (!a(localView, 0, paramInt4)) {
            return;
        }
        localView.getDrawingRect(this.d);
        offsetDescendantRectToMyCoords(localView, this.d);
        a(a(this.d));
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool = false;
        h();
        this.b.addMovement(paramMotionEvent);
        switch (paramMotionEvent.getAction() & 0xFF) {
        }
        for (; ; ) {
            bool = true;
            do {
                return bool;
            } while (getChildCount() == 0);
            if (!this.e.isFinished()) {
            }
            for (bool = true; ; bool = false) {
                this.a = bool;
                if (bool) {
                    ViewParent localViewParent = getParent();
                    if (localViewParent != null) {
                        localViewParent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (!this.e.isFinished()) {
                    this.e.abortAnimation();
                }
                this.h = ((int) paramMotionEvent.getY());
                this.r = paramMotionEvent.getPointerId(0);
                break;
            }
            int i1 = paramMotionEvent.findPointerIndex(this.r);
            if (i1 == -1) {
                Log.e("ScrollView", "Invalid pointerId=" + this.r + " in onTouchEvent");
            } else {
                int i3 = (int) paramMotionEvent.getY(i1);
                int i2 = this.h - i3;
                i1 = i2;
                if (!this.a) {
                    i1 = i2;
                    if (Math.abs(i2) > this.m) {
                        paramMotionEvent = getParent();
                        if (paramMotionEvent != null) {
                            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.a = true;
                        a(true);
                        if (i2 <= 0) {
                            break label459;
                        }
                        i1 = i2 - this.m;
                    }
                }
                label292:
                if (this.a) {
                    this.h = i3;
                    getScrollX();
                    int i4 = getScrollY();
                    i3 = getScrollRange();
                    i2 = getOverScrollMode();
                    if ((i2 == 0) || ((i2 == 1) && (i3 > 0))) {
                        i2 = 1;
                        label343:
                        if ((overScrollBy(0, i1, 0, getScrollY(), 0, i3, 0, this.p, true)) && (this.b != null)) {
                            this.b.clear();
                        }
                        if (i2 == 0) {
                            continue;
                        }
                        i2 = i4 + i1;
                        if (i2 >= 0) {
                            break label474;
                        }
                        this.f.onPull(i1 / getHeight());
                        if (!this.g.isFinished()) {
                            this.g.onRelease();
                        }
                    }
                    while ((this.f != null) && ((!this.f.isFinished()) || (!this.g.isFinished()))) {
                        bd.c(this);
                        break;
                        label459:
                        i1 = i2 + this.m;
                        break label292;
                        i2 = 0;
                        break label343;
                        label474:
                        if (i2 > i3) {
                            this.g.onPull(i1 / getHeight());
                            if (!this.f.isFinished()) {
                                this.f.onRelease();
                            }
                        }
                    }
                    if (this.a) {
                        paramMotionEvent = this.b;
                        paramMotionEvent.computeCurrentVelocity(1000, this.o);
                        i1 = (int) paramMotionEvent.getYVelocity(this.r);
                        if ((getChildCount() > 0) && (Math.abs(i1) > this.n)) {
                            e(-i1);
                        }
                        f();
                        continue;
                        if ((this.a) && (getChildCount() > 0)) {
                            f();
                            continue;
                            i1 = paramMotionEvent.getActionIndex();
                            this.h = ((int) paramMotionEvent.getY(i1));
                            this.r = paramMotionEvent.getPointerId(i1);
                            continue;
                            a(paramMotionEvent);
                            this.h = ((int) paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.r)));
                        }
                    }
                }
            }
        }
    }

    public boolean performAccessibilityAction(int paramInt, Bundle paramBundle) {
        if (super.performAccessibilityAction(paramInt, paramBundle)) {
            return true;
        }
        if (!isEnabled()) {
            return false;
        }
        switch (paramInt) {
            default:
                return false;
            case 4096:
                paramInt = Math.min(getHeight() - getPaddingBottom() - getPaddingTop() + getScrollY(), getScrollRange());
                if (paramInt != getScrollY()) {
                    b(0, paramInt);
                    return true;
                }
                return false;
        }
        paramInt = getHeight();
        int i1 = getPaddingBottom();
        int i2 = getPaddingTop();
        paramInt = Math.max(getScrollY() - (paramInt - i1 - i2), 0);
        if (paramInt != getScrollY()) {
            b(0, paramInt);
            return true;
        }
        return false;
    }

    public void requestChildFocus(View paramView1, View paramView2) {
        if (!this.i) {
            b(paramView2);
        }
        for (; ; ) {
            super.requestChildFocus(paramView1, paramView2);
            return;
            this.j = paramView2;
        }
    }

    public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
        paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
        return a(paramRect, paramBoolean);
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
        if (paramBoolean) {
            i();
        }
        super.requestDisallowInterceptTouchEvent(paramBoolean);
    }

    public void requestLayout() {
        this.i = true;
        super.requestLayout();
    }

    public void scrollTo(int paramInt1, int paramInt2) {
        if (getChildCount() > 0) {
            View localView = getChildAt(0);
            paramInt1 = b(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
            paramInt2 = b(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
            if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
                super.scrollTo(paramInt1, paramInt2);
            }
        }
    }

    public void setFillViewport(boolean paramBoolean) {
        if (paramBoolean != this.k) {
            this.k = paramBoolean;
            requestLayout();
        }
    }

    public void setOverScrollMode(int paramInt) {
        Context localContext;
        if (paramInt != 2) {
            if (this.f == null) {
                localContext = getContext();
                this.f = new EdgeEffect(localContext);
            }
        }
        for (this.g = new EdgeEffect(localContext); ; this.g = null) {
            super.setOverScrollMode(paramInt);
            return;
            this.f = null;
        }
    }

    public void setSmoothScrollingEnabled(boolean paramBoolean) {
        this.l = paramBoolean;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/emilsjolander/components/StickyScrollViewItems/ScrollViewEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */