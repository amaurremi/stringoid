package com.everimaging.fotorsdk.widget.lib.hlist;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews.RemoteView;

import java.util.ArrayList;

@RemoteViews.RemoteView
public class HListView
        extends AbsHListView {
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE = true;
    private boolean aF = false;
    private final Rect aG = new Rect();
    private Paint aH;
    private final a aI = new a(null);
    private c aJ;
    Drawable at;
    int au;
    int av;
    Drawable aw;
    Drawable ax;
    private ArrayList<b> ay = new ArrayList();
    private ArrayList<b> az = new ArrayList();

    public HListView(Context paramContext) {
        this(paramContext, null);
    }

    public HListView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, paramContext.getResources().getIdentifier("fotorSephiroth_listViewStyle", "attr", paramContext.getPackageName()));
    }

    public HListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        Object localObject2 = (int[]) a(paramContext, "fotorHListView");
        if (localObject2 != null) {
        }
        for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, (int[]) localObject2, paramInt, 0); ; paramAttributeSet = null) {
            CharSequence[] arrayOfCharSequence;
            Drawable localDrawable;
            boolean bool1;
            if (paramAttributeSet != null) {
                arrayOfCharSequence = paramAttributeSet.getTextArray(0);
                localObject2 = paramAttributeSet.getDrawable(1);
                localObject1 = paramAttributeSet.getDrawable(5);
                localDrawable = paramAttributeSet.getDrawable(6);
                i = paramAttributeSet.getDimensionPixelSize(2, 0);
                bool2 = paramAttributeSet.getBoolean(3, true);
                bool1 = paramAttributeSet.getBoolean(4, true);
                paramInt = paramAttributeSet.getInteger(7, -1);
                paramAttributeSet.recycle();
                paramAttributeSet = localDrawable;
            }
            for (; ; ) {
                if (arrayOfCharSequence != null) {
                    setAdapter(new ArrayAdapter(paramContext, 17367043, arrayOfCharSequence));
                }
                if (localObject2 != null) {
                    setDivider((Drawable) localObject2);
                }
                if (localObject1 != null) {
                    setOverscrollHeader((Drawable) localObject1);
                }
                if (paramAttributeSet != null) {
                    setOverscrollFooter(paramAttributeSet);
                }
                if (i != 0) {
                    setDividerWidth(i);
                }
                this.aC = bool2;
                this.aD = bool1;
                this.av = paramInt;
                return;
                paramInt = -1;
                localDrawable = null;
                localObject2 = null;
                arrayOfCharSequence = null;
                bool1 = true;
                paramAttributeSet = (AttributeSet) localObject1;
                localObject1 = localDrawable;
            }
        }
    }

    private boolean A() {
        int i = getChildCount();
        int j = getChildAt(i - 1).getRight();
        int k = this.V;
        int m = getScrollX();
        int n = getWidth();
        int i1 = this.u.right;
        return (i + k - 1 < this.an - 1) || (j < m + n - i1);
    }

    private int a(int paramInt1, View paramView, int paramInt2) {
        int i = 0;
        paramView.getDrawingRect(this.aG);
        offsetDescendantRectToMyCoords(paramView, this.aG);
        if (paramInt1 == 33) {
            paramInt1 = i;
            if (this.aG.left < this.u.left) {
                i = this.u.left - this.aG.left;
                paramInt1 = i;
                if (paramInt2 > 0) {
                    paramInt1 = i + getArrowScrollPreviewLength();
                }
            }
        }
        do {
            int j;
            do {
                return paramInt1;
                j = getWidth() - this.u.right;
                paramInt1 = i;
            } while (this.aG.bottom <= j);
            i = this.aG.right - j;
            paramInt1 = i;
        } while (paramInt2 >= this.an - 1);
        return i + getArrowScrollPreviewLength();
    }

    private View a(int paramInt1, int paramInt2, int paramInt3) {
        int j = getHorizontalFadingEdgeLength();
        int i = this.al;
        paramInt2 = c(paramInt2, j, i);
        paramInt3 = b(paramInt3, j, i);
        View localView = a(i, paramInt1, true, this.u.top, true);
        if (localView.getRight() > paramInt3) {
            localView.offsetLeftAndRight(-Math.min(localView.getLeft() - paramInt2, localView.getRight() - paramInt3));
        }
        for (; ; ) {
            a(localView, i);
            if (this.K) {
                break;
            }
            l(getChildCount());
            return localView;
            if (localView.getLeft() < paramInt2) {
                localView.offsetLeftAndRight(Math.min(paramInt2 - localView.getLeft(), paramInt3 - localView.getRight()));
            }
        }
        m(getChildCount());
        return localView;
    }

    private View a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2) {
        if (!this.ai) {
            localView = this.p.c(paramInt1);
            if (localView != null) {
                a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, true);
                return localView;
            }
        }
        View localView = a(paramInt1, this.P);
        a(localView, paramInt1, paramInt2, paramBoolean1, paramInt3, paramBoolean2, this.P[0]);
        return localView;
    }

    private View a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3) {
        int j = getHorizontalFadingEdgeLength();
        int k = this.al;
        int i = c(paramInt2, j, k);
        j = b(paramInt2, j, k);
        int m;
        if (paramInt1 > 0) {
            paramView1 = a(k - 1, paramView1.getLeft(), true, this.u.top, false);
            paramInt1 = this.au;
            paramView2 = a(k, paramView1.getRight() + paramInt1, true, this.u.top, true);
            if (paramView2.getRight() > j) {
                k = paramView2.getLeft();
                m = paramView2.getRight();
                paramInt2 = (paramInt3 - paramInt2) / 2;
                paramInt2 = Math.min(Math.min(k - i, m - j), paramInt2);
                paramView1.offsetLeftAndRight(-paramInt2);
                paramView2.offsetLeftAndRight(-paramInt2);
            }
            if (!this.K) {
                g(this.al - 2, paramView2.getLeft() - paramInt1);
                a();
                f(this.al + 1, paramView2.getRight() + paramInt1);
                return paramView2;
            }
            f(this.al + 1, paramView2.getRight() + paramInt1);
            a();
            g(this.al - 2, paramView2.getLeft() - paramInt1);
            return paramView2;
        }
        if (paramInt1 < 0) {
            if (paramView2 != null) {
            }
            for (paramView1 = a(k, paramView2.getLeft(), true, this.u.top, true); ; paramView1 = a(k, paramView1.getLeft(), false, this.u.top, true)) {
                if (paramView1.getLeft() < i) {
                    paramInt1 = paramView1.getLeft();
                    m = paramView1.getRight();
                    paramInt2 = (paramInt3 - paramInt2) / 2;
                    paramView1.offsetLeftAndRight(Math.min(Math.min(i - paramInt1, j - m), paramInt2));
                }
                a(paramView1, k);
                return paramView1;
            }
        }
        paramInt1 = paramView1.getLeft();
        paramView1 = a(k, paramInt1, true, this.u.top, true);
        if ((paramInt1 < paramInt2) && (paramView1.getRight() < paramInt2 + 20)) {
            paramView1.offsetLeftAndRight(paramInt2 - paramView1.getLeft());
        }
        a(paramView1, k);
        return paramView1;
    }

    private void a() {
        int k = 0;
        int m = getChildCount();
        int j;
        int i;
        if (m > 0) {
            if (this.K) {
                break label72;
            }
            j = getChildAt(0).getLeft() - this.u.left;
            i = j;
            if (this.V != 0) {
                i = j - this.au;
            }
            j = i;
            if (i >= 0) {
                break label128;
            }
            j = k;
        }
        label72:
        label128:
        for (; ; ) {
            if (j != 0) {
                d(-j);
            }
            return;
            j = getChildAt(m - 1).getRight() - (getWidth() - this.u.right);
            i = j;
            if (m + this.V < this.an) {
                i = j + this.au;
            }
            j = k;
            if (i <= 0) {
                j = i;
            }
        }
    }

    private void a(View paramView, int paramInt) {
        int i = this.au;
        if (!this.K) {
            g(paramInt - 1, paramView.getLeft() - i);
            a();
            f(paramInt + 1, i + paramView.getRight());
            return;
        }
        f(paramInt + 1, paramView.getRight() + i);
        a();
        g(paramInt - 1, paramView.getLeft() - i);
    }

    private void a(View paramView, int paramInt1, int paramInt2) {
        AbsHListView.f localf2 = (AbsHListView.f) paramView.getLayoutParams();
        AbsHListView.f localf1 = localf2;
        if (localf2 == null) {
            localf1 = (AbsHListView.f) generateDefaultLayoutParams();
            paramView.setLayoutParams(localf1);
        }
        localf1.a = this.j.getItemViewType(paramInt1);
        localf1.c = true;
        paramInt2 = ViewGroup.getChildMeasureSpec(paramInt2, this.u.top + this.u.bottom, localf1.height);
        paramInt1 = localf1.width;
        if (paramInt1 > 0) {
        }
        for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824); ; paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0)) {
            paramView.measure(paramInt1, paramInt2);
            return;
        }
    }

    private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
        boolean bool2 = true;
        if (paramInt2 == -1) {
            throw new IllegalArgumentException("newSelectedPosition needs to be valid");
        }
        int i = this.al - this.V;
        paramInt2 -= this.V;
        int j;
        View localView1;
        boolean bool1;
        if (paramInt1 == 33) {
            View localView2 = getChildAt(paramInt2);
            paramInt1 = i;
            j = 1;
            localView1 = paramView;
            paramView = localView2;
            i = paramInt2;
            paramInt2 = paramInt1;
            paramInt1 = j;
            j = getChildCount();
            if (paramView != null) {
                if ((paramBoolean) || (paramInt1 == 0)) {
                    break label154;
                }
                bool1 = true;
                label92:
                paramView.setSelected(bool1);
                b(paramView, i, j);
            }
            if (localView1 != null) {
                if ((paramBoolean) || (paramInt1 != 0)) {
                    break label160;
                }
            }
        }
        label154:
        label160:
        for (paramBoolean = bool2; ; paramBoolean = false) {
            localView1.setSelected(paramBoolean);
            b(localView1, paramInt2, j);
            return;
            localView1 = getChildAt(paramInt2);
            paramInt1 = 0;
            break;
            bool1 = false;
            break label92;
        }
    }

    @TargetApi(11)
    private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, boolean paramBoolean3) {
        int j;
        label27:
        int i;
        boolean bool;
        label55:
        int k;
        label67:
        label87:
        AbsHListView.f localf;
        if ((paramBoolean2) && (i())) {
            paramBoolean2 = true;
            if (paramBoolean2 == paramView.isSelected()) {
                break label392;
            }
            j = 1;
            i = this.F;
            if ((i <= 0) || (i >= 3) || (this.A != paramInt1)) {
                break label398;
            }
            bool = true;
            if (bool == paramView.isPressed()) {
                break label404;
            }
            k = 1;
            if ((paramBoolean3) && (j == 0) && (!paramView.isLayoutRequested())) {
                break label410;
            }
            i = 1;
            localf = (AbsHListView.f) paramView.getLayoutParams();
            if (localf != null) {
                break label545;
            }
            localf = (AbsHListView.f) generateDefaultLayoutParams();
        }
        label164:
        label233:
        label289:
        label297:
        label314:
        label392:
        label398:
        label404:
        label410:
        label472:
        label495:
        label505:
        label513:
        label521:
        label545:
        for (; ; ) {
            localf.a = this.j.getItemViewType(paramInt1);
            int m;
            if (((paramBoolean3) && (!localf.c)) || ((localf.b) && (localf.a == -2))) {
                if (paramBoolean1) {
                    m = -1;
                    attachViewToParent(paramView, m, localf);
                    if (j != 0) {
                        paramView.setSelected(paramBoolean2);
                    }
                    if (k != 0) {
                        paramView.setPressed(bool);
                    }
                    if ((this.b != 0) && (this.f != null)) {
                        if (!(paramView instanceof Checkable)) {
                            break label472;
                        }
                        ((Checkable) paramView).setChecked(this.f.get(paramInt1));
                    }
                    if (i == 0) {
                        break label505;
                    }
                    k = ViewGroup.getChildMeasureSpec(this.v, this.u.top + this.u.bottom, localf.height);
                    j = localf.width;
                    if (j <= 0) {
                        break label495;
                    }
                    j = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                    paramView.measure(j, k);
                    j = paramView.getMeasuredWidth();
                    k = paramView.getMeasuredHeight();
                    if (!paramBoolean1) {
                        break label513;
                    }
                    if (i == 0) {
                        break label521;
                    }
                    paramView.layout(paramInt2, paramInt3, j + paramInt2, k + paramInt3);
                }
            }
            for (; ; ) {
                if ((this.y) && (!paramView.isDrawingCacheEnabled())) {
                    paramView.setDrawingCacheEnabled(true);
                }
                if ((Build.VERSION.SDK_INT >= 11) && (paramBoolean3) && (((AbsHListView.f) paramView.getLayoutParams()).d != paramInt1)) {
                    paramView.jumpDrawablesToCurrentState();
                }
                return;
                paramBoolean2 = false;
                break;
                j = 0;
                break label27;
                bool = false;
                break label55;
                k = 0;
                break label67;
                i = 0;
                break label87;
                m = 0;
                break label164;
                localf.c = false;
                if (localf.a == -2) {
                    localf.b = true;
                }
                if (paramBoolean1) {
                }
                for (m = -1; ; m = 0) {
                    addViewInLayout(paramView, m, localf, true);
                    break;
                }
                if (Build.VERSION.SDK_INT < 11) {
                    break label233;
                }
                paramView.setActivated(this.f.get(paramInt1));
                break label233;
                j = View.MeasureSpec.makeMeasureSpec(0, 0);
                break label289;
                cleanupLayoutState(paramView);
                break label297;
                paramInt2 -= j;
                break label314;
                paramView.offsetLeftAndRight(paramInt2 - paramView.getLeft());
                paramView.offsetTopAndBottom(paramInt3 - paramView.getTop());
            }
        }
    }

    private void a(ArrayList<b> paramArrayList) {
        if (paramArrayList != null) {
            int j = paramArrayList.size();
            int i = 0;
            while (i < j) {
                AbsHListView.f localf = (AbsHListView.f) ((b) paramArrayList.get(i)).a.getLayoutParams();
                if (localf != null) {
                    localf.b = false;
                }
                i += 1;
            }
        }
    }

    @TargetApi(11)
    private boolean a(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
        if ((this.j == null) || (!this.S)) {
        }
        do {
            return false;
            if (this.ai) {
                f();
            }
        } while (Build.VERSION.SDK_INT < 11);
        int k = paramKeyEvent.getAction();
        if (k != 1) {
        }
        boolean bool1;
        int i;
        switch (paramInt1) {
            default:
                bool1 = false;
                i = paramInt2;
        }
        for (; ; ) {
            if (!bool1) {
                break label802;
            }
            return true;
            boolean bool2;
            int j;
            if (paramKeyEvent.hasNoModifiers()) {
                bool2 = o();
                bool1 = bool2;
                i = paramInt2;
                if (!bool2) {
                    for (; ; ) {
                        j = paramInt2 - 1;
                        bool1 = bool2;
                        i = j;
                        if (paramInt2 <= 0) {
                            break;
                        }
                        bool1 = bool2;
                        i = j;
                        if (!j(33)) {
                            break;
                        }
                        bool2 = true;
                        paramInt2 = j;
                    }
                }
            } else {
                if (!paramKeyEvent.hasModifiers(2)) {
                    break;
                }
                if ((o()) || (i(33))) {
                    bool1 = true;
                    i = paramInt2;
                } else {
                    bool1 = false;
                    i = paramInt2;
                    continue;
                    if (paramKeyEvent.hasNoModifiers()) {
                        bool2 = o();
                        bool1 = bool2;
                        i = paramInt2;
                        if (!bool2) {
                            for (; ; ) {
                                j = paramInt2 - 1;
                                bool1 = bool2;
                                i = j;
                                if (paramInt2 <= 0) {
                                    break;
                                }
                                bool1 = bool2;
                                i = j;
                                if (!j(130)) {
                                    break;
                                }
                                bool2 = true;
                                paramInt2 = j;
                            }
                        }
                    } else {
                        if (!paramKeyEvent.hasModifiers(2)) {
                            break;
                        }
                        if ((o()) || (i(130))) {
                            bool1 = true;
                            i = paramInt2;
                        } else {
                            bool1 = false;
                            i = paramInt2;
                            continue;
                            if (!paramKeyEvent.hasNoModifiers()) {
                                break;
                            }
                            bool1 = n(17);
                            i = paramInt2;
                            continue;
                            if (!paramKeyEvent.hasNoModifiers()) {
                                break;
                            }
                            bool1 = n(66);
                            i = paramInt2;
                            continue;
                            if (!paramKeyEvent.hasNoModifiers()) {
                                break;
                            }
                            bool2 = o();
                            bool1 = bool2;
                            i = paramInt2;
                            if (!bool2) {
                                bool1 = bool2;
                                i = paramInt2;
                                if (paramKeyEvent.getRepeatCount() == 0) {
                                    bool1 = bool2;
                                    i = paramInt2;
                                    if (getChildCount() > 0) {
                                        j();
                                        bool1 = true;
                                        i = paramInt2;
                                        continue;
                                        if (paramKeyEvent.hasNoModifiers()) {
                                            if ((o()) || (!h(130))) {
                                            }
                                        }
                                        for (; ; ) {
                                            bool1 = true;
                                            i = paramInt2;
                                            break;
                                            if ((!paramKeyEvent.hasModifiers(1)) || (o()) || (!h(33))) {
                                            }
                                        }
                                        if (paramKeyEvent.hasNoModifiers()) {
                                            if ((o()) || (h(33))) {
                                                bool1 = true;
                                                i = paramInt2;
                                            } else {
                                                bool1 = false;
                                                i = paramInt2;
                                            }
                                        } else {
                                            if (!paramKeyEvent.hasModifiers(2)) {
                                                break;
                                            }
                                            if ((o()) || (i(33))) {
                                                bool1 = true;
                                                i = paramInt2;
                                            } else {
                                                bool1 = false;
                                                i = paramInt2;
                                                continue;
                                                if (paramKeyEvent.hasNoModifiers()) {
                                                    if ((o()) || (h(130))) {
                                                        bool1 = true;
                                                        i = paramInt2;
                                                    } else {
                                                        bool1 = false;
                                                        i = paramInt2;
                                                    }
                                                } else {
                                                    if (!paramKeyEvent.hasModifiers(2)) {
                                                        break;
                                                    }
                                                    if ((o()) || (i(130))) {
                                                        bool1 = true;
                                                        i = paramInt2;
                                                    } else {
                                                        bool1 = false;
                                                        i = paramInt2;
                                                        continue;
                                                        if (!paramKeyEvent.hasNoModifiers()) {
                                                            break;
                                                        }
                                                        if ((o()) || (i(33))) {
                                                            bool1 = true;
                                                            i = paramInt2;
                                                        } else {
                                                            bool1 = false;
                                                            i = paramInt2;
                                                            continue;
                                                            if (!paramKeyEvent.hasNoModifiers()) {
                                                                break;
                                                            }
                                                            if ((o()) || (i(130))) {
                                                                bool1 = true;
                                                                i = paramInt2;
                                                            } else {
                                                                bool1 = false;
                                                                i = paramInt2;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        switch (k) {
            default:
                return false;
            case 0:
                return super.onKeyDown(paramInt1, paramKeyEvent);
            case 1:
                label802:
                return super.onKeyUp(paramInt1, paramKeyEvent);
        }
        return super.onKeyMultiple(paramInt1, i, paramKeyEvent);
    }

    private boolean a(View paramView1, View paramView2) {
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

    private int b(int paramInt1, int paramInt2, int paramInt3) {
        int i = paramInt1;
        if (paramInt3 != this.an - 1) {
            i = paramInt1 - paramInt2;
        }
        return i;
    }

    private View b(View paramView, int paramInt) {
        paramInt -= 1;
        View localView = a(paramInt, this.P);
        a(localView, paramInt, paramView.getLeft() - this.au, false, this.u.top, false, this.P[0]);
        return localView;
    }

    private void b(View paramView, int paramInt1, int paramInt2) {
        int i = paramView.getWidth();
        d(paramView);
        if (paramView.getMeasuredWidth() != i) {
            e(paramView);
            int j = paramView.getMeasuredWidth();
            paramInt1 += 1;
            while (paramInt1 < paramInt2) {
                getChildAt(paramInt1).offsetLeftAndRight(j - i);
                paramInt1 += 1;
            }
        }
    }

    private int c(int paramInt1, int paramInt2, int paramInt3) {
        int i = paramInt1;
        if (paramInt3 > 0) {
            i = paramInt1 + paramInt2;
        }
        return i;
    }

    private View c(View paramView, int paramInt) {
        paramInt += 1;
        View localView = a(paramInt, this.P);
        int i = paramView.getRight();
        a(localView, paramInt, this.au + i, true, this.u.top, false, this.P[0]);
        return localView;
    }

    private boolean c(View paramView) {
        ArrayList localArrayList = this.ay;
        int j = localArrayList.size();
        int i = 0;
        while (i < j) {
            if (paramView == ((b) localArrayList.get(i)).a) {
                return true;
            }
            i += 1;
        }
        localArrayList = this.az;
        j = localArrayList.size();
        i = 0;
        while (i < j) {
            if (paramView == ((b) localArrayList.get(i)).a) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    private void d(View paramView) {
        ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
        ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
            localLayoutParams1 = new ViewGroup.LayoutParams(-2, -1);
        }
        int j = ViewGroup.getChildMeasureSpec(this.v, this.u.top + this.u.bottom, localLayoutParams1.height);
        int i = localLayoutParams1.width;
        if (i > 0) {
        }
        for (i = View.MeasureSpec.makeMeasureSpec(i, 1073741824); ; i = View.MeasureSpec.makeMeasureSpec(0, 0)) {
            paramView.measure(i, j);
            return;
        }
    }

    private void e(View paramView) {
        int i = paramView.getMeasuredWidth();
        int j = paramView.getMeasuredHeight();
        int k = this.u.top;
        int m = paramView.getLeft();
        paramView.layout(m, k, i + m, j + k);
    }

    private int f(View paramView) {
        int j = getChildCount();
        int i = 0;
        while (i < j) {
            if (a(paramView, getChildAt(i))) {
                return i + this.V;
            }
            i += 1;
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private View f(int paramInt1, int paramInt2) {
        Object localObject = null;
        int i = getRight();
        int j = getLeft();
        boolean bool;
        if ((paramInt2 < i - j) && (paramInt1 < this.an)) {
            if (paramInt1 == this.al) {
                bool = true;
                label41:
                View localView = a(paramInt1, paramInt2, true, this.u.top, bool);
                paramInt2 = localView.getRight() + this.au;
                if (!bool) {
                    break label114;
                }
                localObject = localView;
            }
        }
        label114:
        for (; ; ) {
            paramInt1 += 1;
            break;
            bool = false;
            break label41;
            d(this.V, this.V + getChildCount() - 1);
            return (View) localObject;
        }
    }

    private int g(View paramView) {
        int i = 0;
        paramView.getDrawingRect(this.aG);
        offsetDescendantRectToMyCoords(paramView, this.aG);
        int j = getRight() - getLeft() - this.u.right;
        if (this.aG.right < this.u.left) {
            i = this.u.left - this.aG.right;
        }
        while (this.aG.left <= j) {
            return i;
        }
        return this.aG.left - j;
    }

    private View g(int paramInt1, int paramInt2) {
        Object localObject = null;
        boolean bool;
        if ((paramInt2 > 0) && (paramInt1 >= 0)) {
            if (paramInt1 == this.al) {
                bool = true;
                label21:
                View localView = a(paramInt1, paramInt2, false, this.u.top, bool);
                paramInt2 = localView.getLeft() - this.au;
                if (!bool) {
                    break label98;
                }
                localObject = localView;
            }
        }
        label98:
        for (; ; ) {
            paramInt1 -= 1;
            break;
            bool = false;
            break label21;
            this.V = (paramInt1 + 1);
            d(this.V, this.V + getChildCount() - 1);
            return (View) localObject;
        }
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private View h(int paramInt1, int paramInt2) {
        paramInt2 -= paramInt1;
        int i = n();
        View localView = a(i, paramInt1, true, this.u.top, true);
        this.V = i;
        paramInt1 = localView.getMeasuredWidth();
        if (paramInt1 <= paramInt2) {
            localView.offsetLeftAndRight((paramInt2 - paramInt1) / 2);
        }
        a(localView, i);
        if (!this.K) {
            l(getChildCount());
            return localView;
        }
        m(getChildCount());
        return localView;
    }

    private View i(int paramInt1, int paramInt2) {
        boolean bool;
        View localView5;
        View localView3;
        View localView4;
        View localView1;
        View localView2;
        if (paramInt1 == this.al) {
            bool = true;
            localView5 = a(paramInt1, paramInt2, true, this.u.top, bool);
            this.V = paramInt1;
            paramInt2 = this.au;
            if (this.K) {
                break label122;
            }
            localView3 = g(paramInt1 - 1, localView5.getLeft() - paramInt2);
            a();
            localView4 = f(paramInt1 + 1, paramInt2 + localView5.getRight());
            paramInt1 = getChildCount();
            localView1 = localView3;
            localView2 = localView4;
            if (paramInt1 > 0) {
                l(paramInt1);
                localView2 = localView4;
                localView1 = localView3;
            }
        }
        for (; ; ) {
            if (!bool) {
                break label191;
            }
            return localView5;
            bool = false;
            break;
            label122:
            localView3 = f(paramInt1 + 1, localView5.getRight() + paramInt2);
            a();
            localView4 = g(paramInt1 - 1, localView5.getLeft() - paramInt2);
            paramInt1 = getChildCount();
            localView1 = localView4;
            localView2 = localView3;
            if (paramInt1 > 0) {
                m(paramInt1);
                localView1 = localView4;
                localView2 = localView3;
            }
        }
        label191:
        if (localView1 != null) {
            return localView1;
        }
        return localView2;
    }

    private int j(int paramInt1, int paramInt2) {
        int i = getWidth() - this.u.right;
        int j = this.u.left;
        int k = getChildCount();
        View localView;
        if (paramInt1 == 130) {
            paramInt1 = k - 1;
            if (paramInt2 != -1) {
                paramInt1 = paramInt2 - this.V;
            }
            j = this.V;
            localView = getChildAt(paramInt1);
            if (j + paramInt1 >= this.an - 1) {
                break label285;
            }
        }
        label285:
        for (paramInt1 = i - getArrowScrollPreviewLength(); ; paramInt1 = i) {
            if (localView.getRight() <= paramInt1) {
            }
            while ((paramInt2 != -1) && (paramInt1 - localView.getLeft() >= getMaxScrollAmount())) {
                return 0;
            }
            paramInt2 = localView.getRight() - paramInt1;
            paramInt1 = paramInt2;
            if (this.V + k == this.an) {
                paramInt1 = Math.min(paramInt2, getChildAt(k - 1).getRight() - i);
            }
            return Math.min(paramInt1, getMaxScrollAmount());
            if (paramInt2 != -1) {
            }
            for (paramInt1 = paramInt2 - this.V; ; paramInt1 = 0) {
                i = this.V;
                localView = getChildAt(paramInt1);
                if (i + paramInt1 > 0) {
                }
                for (paramInt1 = getArrowScrollPreviewLength() + j; (localView.getLeft() < paramInt1) && ((paramInt2 == -1) || (localView.getRight() - paramInt1 < getMaxScrollAmount())); paramInt1 = j) {
                    paramInt2 = paramInt1 - localView.getLeft();
                    paramInt1 = paramInt2;
                    if (this.V == 0) {
                        paramInt1 = Math.min(paramInt2, j - getChildAt(0).getLeft());
                    }
                    return Math.min(paramInt1, getMaxScrollAmount());
                }
                break;
            }
        }
    }

    private View k(int paramInt) {
        this.V = Math.min(this.V, this.al);
        this.V = Math.min(this.V, this.an - 1);
        if (this.V < 0) {
            this.V = 0;
        }
        return f(this.V, paramInt);
    }

    private void l(int paramInt) {
        if ((this.V + paramInt - 1 == this.an - 1) && (paramInt > 0)) {
            paramInt = getChildAt(paramInt - 1).getRight();
            int i = getRight() - getLeft() - this.u.right - paramInt;
            View localView = getChildAt(0);
            int j = localView.getLeft();
            if ((i > 0) && ((this.V > 0) || (j < this.u.top))) {
                paramInt = i;
                if (this.V == 0) {
                    paramInt = Math.min(i, this.u.top - j);
                }
                d(paramInt);
                if (this.V > 0) {
                    g(this.V - 1, localView.getLeft() - this.au);
                    a();
                }
            }
        }
    }

    private void m(int paramInt) {
        int m;
        if ((this.V == 0) && (paramInt > 0)) {
            int i = getChildAt(0).getLeft();
            int k = this.u.left;
            int j = getRight() - getLeft() - this.u.right;
            i -= k;
            View localView = getChildAt(paramInt - 1);
            k = localView.getRight();
            m = this.V + paramInt - 1;
            if (i > 0) {
                if ((m >= this.an - 1) && (k <= j)) {
                    break label162;
                }
                paramInt = i;
                if (m == this.an - 1) {
                    paramInt = Math.min(i, k - j);
                }
                d(-paramInt);
                if (m < this.an - 1) {
                    f(m + 1, localView.getRight() + this.au);
                    a();
                }
            }
        }
        label162:
        while (m != this.an - 1) {
            return;
        }
        a();
    }

    private boolean n(int paramInt) {
        if ((paramInt != 17) && (paramInt != 66)) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
        }
        int i = getChildCount();
        if ((this.aF) && (i > 0) && (this.al != -1)) {
            View localView2 = getSelectedView();
            if ((localView2 != null) && (localView2.hasFocus()) && ((localView2 instanceof ViewGroup))) {
                View localView1 = localView2.findFocus();
                localView2 = FocusFinder.getInstance().findNextFocus((ViewGroup) localView2, localView1, paramInt);
                if (localView2 != null) {
                    localView1.getFocusedRect(this.aG);
                    offsetDescendantRectToMyCoords(localView1, this.aG);
                    offsetRectIntoDescendantCoords(localView2, this.aG);
                    if (localView2.requestFocus(paramInt, this.aG)) {
                        return true;
                    }
                }
                localView1 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), localView1, paramInt);
                if (localView1 != null) {
                    return a(localView1, this);
                }
            }
        }
        return false;
    }

    private boolean o(int paramInt) {
        if (getChildCount() <= 0) {
            return false;
        }
        View localView1 = getSelectedView();
        int m = this.al;
        int i = p(paramInt);
        int j = j(paramInt, i);
        Object localObject;
        int k;
        label73:
        boolean bool;
        if (this.aF) {
            localObject = q(paramInt);
            if (localObject != null) {
                i = ((a) localObject).a();
                j = ((a) localObject).b();
            }
            if (localObject == null) {
                break label306;
            }
            k = 1;
            if (i == -1) {
                break label327;
            }
            if (localObject == null) {
                break label312;
            }
            bool = true;
            label86:
            a(localView1, paramInt, i, bool);
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            localView1 = getSelectedView();
            if ((this.aF) && (localObject == null)) {
                View localView2 = getFocusedChild();
                if (localView2 != null) {
                    localView2.clearFocus();
                }
            }
            v();
            k = 1;
            m = i;
        }
        label160:
        label306:
        label312:
        label324:
        label325:
        label327:
        for (; ; ) {
            if (j > 0) {
                if (paramInt == 33) {
                    r(j);
                    k = 1;
                }
            } else {
                if ((this.aF) && (localObject == null) && (localView1 != null) && (localView1.hasFocus())) {
                    localObject = localView1.findFocus();
                    if ((!a((View) localObject, this)) || (g((View) localObject) > 0)) {
                        ((View) localObject).clearFocus();
                    }
                }
                if ((i != -1) || (localView1 == null) || (a(localView1, this))) {
                    break label324;
                }
                m();
                this.M = -1;
                localView1 = null;
            }
            for (; ; ) {
                if (k == 0) {
                    break label325;
                }
                if (localView1 != null) {
                    a(m, localView1);
                    this.J = localView1.getLeft();
                }
                if (!awakenScrollBars()) {
                    invalidate();
                }
                c();
                return true;
                localObject = null;
                break;
                k = 0;
                break label73;
                bool = false;
                break label86;
                j = -j;
                break label160;
            }
            break;
        }
    }

    private int p(int paramInt) {
        int j = this.V;
        ListAdapter localListAdapter;
        if (paramInt == 130) {
            if (this.al != -1) {
            }
            for (i = this.al + 1; i >= this.j.getCount(); i = j) {
                paramInt = -1;
                return paramInt;
            }
            paramInt = i;
            if (i < j) {
                paramInt = j;
            }
            int k = getLastVisiblePosition();
            localListAdapter = getAdapter();
            i = paramInt;
            for (; ; ) {
                if (i > k) {
                    break label215;
                }
                if (localListAdapter.isEnabled(i)) {
                    paramInt = i;
                    if (getChildAt(i - j).getVisibility() == 0) {
                        break;
                    }
                }
                i += 1;
            }
        }
        int i = getChildCount() + j - 1;
        if (this.al != -1) {
        }
        for (paramInt = this.al - 1; (paramInt < 0) || (paramInt >= this.j.getCount()); paramInt = getChildCount() + j - 1) {
            return -1;
        }
        if (paramInt > i) {
        }
        for (; ; ) {
            localListAdapter = getAdapter();
            for (; ; ) {
                if (i < j) {
                    break label215;
                }
                if (localListAdapter.isEnabled(i)) {
                    paramInt = i;
                    if (getChildAt(i - j).getVisibility() == 0) {
                        break;
                    }
                }
                i -= 1;
            }
            label215:
            return -1;
            i = paramInt;
        }
    }

    private a q(int paramInt) {
        int j = 1;
        int i = 1;
        View localView = getSelectedView();
        if ((localView != null) && (localView.hasFocus())) {
            localView = localView.findFocus();
            localView = FocusFinder.getInstance().findNextFocus(this, localView, paramInt);
            if (localView == null) {
                break label376;
            }
            i = f(localView);
            if ((this.al != -1) && (i != this.al)) {
                j = p(paramInt);
                if ((j != -1) && (((paramInt == 130) && (j < i)) || ((paramInt == 33) && (j > i)))) {
                    return null;
                }
            }
        } else {
            if (paramInt == 130) {
                if (this.V > 0) {
                    label120:
                    j = this.u.left;
                    if (i == 0) {
                        break label198;
                    }
                }
                label198:
                for (i = getArrowScrollPreviewLength(); ; i = 0) {
                    j = i + j;
                    i = j;
                    if (localView != null) {
                        i = j;
                        if (localView.getLeft() > j) {
                            i = localView.getLeft();
                        }
                    }
                    this.aG.set(i, 0, i, 0);
                    localView = FocusFinder.getInstance().findNextFocusFromRect(this, this.aG, paramInt);
                    break;
                    i = 0;
                    break label120;
                }
            }
            if (this.V + getChildCount() - 1 < this.an) {
                i = j;
                label223:
                j = getWidth();
                k = this.u.right;
                if (i == 0) {
                    break label296;
                }
            }
            label296:
            for (i = getArrowScrollPreviewLength(); ; i = 0) {
                j = j - k - i;
                i = j;
                if (localView != null) {
                    i = j;
                    if (localView.getRight() < j) {
                        i = localView.getRight();
                    }
                }
                this.aG.set(i, 0, i, 0);
                break;
                i = 0;
                break label223;
            }
        }
        j = a(paramInt, localView, i);
        int k = getMaxScrollAmount();
        if (j < k) {
            localView.requestFocus(paramInt);
            this.aI.a(i, j);
            return this.aI;
        }
        if (g(localView) < k) {
            localView.requestFocus(paramInt);
            this.aI.a(i, k);
            return this.aI;
        }
        label376:
        return null;
    }

    private void r(int paramInt) {
        d(paramInt);
        int i = getWidth() - this.u.right;
        int j = this.u.left;
        AbsHListView.k localk = this.p;
        View localView;
        if (paramInt < 0) {
            paramInt = getChildCount();
            localView = getChildAt(paramInt - 1);
            while (localView.getRight() < i) {
                int k = this.V + paramInt - 1;
                if (k >= this.an - 1) {
                    break;
                }
                localView = c(localView, k);
                paramInt += 1;
            }
            if (localView.getBottom() < i) {
                d(i - localView.getRight());
            }
            localView = getChildAt(0);
            if (localView.getRight() < j) {
                if (localk.b(((AbsHListView.f) localView.getLayoutParams()).a)) {
                    detachViewFromParent(localView);
                    localk.a(localView, this.V);
                }
                for (; ; ) {
                    localView = getChildAt(0);
                    this.V += 1;
                    break;
                    removeViewInLayout(localView);
                }
            }
        } else {
            localView = getChildAt(0);
            while ((localView.getLeft() > j) && (this.V > 0)) {
                localView = b(localView, this.V);
                this.V -= 1;
            }
            if (localView.getLeft() > j) {
                d(j - localView.getLeft());
            }
            paramInt = getChildCount() - 1;
            localView = getChildAt(paramInt);
            if (localView.getLeft() > i) {
                if (localk.b(((AbsHListView.f) localView.getLayoutParams()).a)) {
                    detachViewFromParent(localView);
                    localk.a(localView, this.V + paramInt);
                }
                for (; ; ) {
                    paramInt -= 1;
                    localView = getChildAt(paramInt);
                    break;
                    removeViewInLayout(localView);
                }
            }
        }
    }

    private boolean z() {
        boolean bool = false;
        int i = getScrollX();
        int j = this.u.left;
        if ((this.V > 0) || (getChildAt(0).getLeft() > i + j)) {
            bool = true;
        }
        return bool;
    }

    final int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        int k = 0;
        Log.i("HListView", "measureWidthOfChildren, from " + paramInt2 + " to " + paramInt3);
        Object localObject = this.j;
        if (localObject == null) {
            paramInt1 = this.u.left + this.u.right;
            return paramInt1;
        }
        int m = this.u.left + this.u.right;
        int i;
        label106:
        boolean bool;
        label148:
        View localView;
        if ((this.au > 0) && (this.at != null)) {
            i = this.au;
            int j = paramInt3;
            if (paramInt3 == -1) {
                j = ((ListAdapter) localObject).getCount() - 1;
            }
            localObject = this.p;
            bool = y();
            boolean[] arrayOfBoolean = this.P;
            paramInt3 = paramInt2;
            paramInt2 = m;
            if (paramInt3 > j) {
                break label302;
            }
            localView = a(paramInt3, arrayOfBoolean);
            a(localView, paramInt3, paramInt1);
            if (paramInt3 <= 0) {
                break label304;
            }
            paramInt2 += i;
        }
        label302:
        label304:
        for (; ; ) {
            if ((bool) && (((AbsHListView.k) localObject).b(((AbsHListView.f) localView.getLayoutParams()).a))) {
                ((AbsHListView.k) localObject).a(localView, -1);
            }
            paramInt2 = localView.getMeasuredWidth() + paramInt2;
            if (paramInt2 >= paramInt4) {
                paramInt1 = paramInt4;
                if (paramInt5 < 0) {
                    break;
                }
                paramInt1 = paramInt4;
                if (paramInt3 <= paramInt5) {
                    break;
                }
                paramInt1 = paramInt4;
                if (k <= 0) {
                    break;
                }
                paramInt1 = paramInt4;
                if (paramInt2 == paramInt4) {
                    break;
                }
                return k;
                i = 0;
                break label106;
            }
            m = k;
            if (paramInt5 >= 0) {
                m = k;
                if (paramInt3 >= paramInt5) {
                    m = paramInt2;
                }
            }
            paramInt3 += 1;
            k = m;
            break label148;
            return paramInt2;
        }
    }

    void a(Canvas paramCanvas, Rect paramRect, int paramInt) {
        Drawable localDrawable = this.at;
        localDrawable.setBounds(paramRect);
        localDrawable.draw(paramCanvas);
    }

    void a(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect) {
        int i = paramDrawable.getMinimumWidth();
        paramCanvas.save();
        paramCanvas.clipRect(paramRect);
        if (paramRect.right - paramRect.left < i) {
            paramRect.left = (paramRect.right - i);
        }
        paramDrawable.setBounds(paramRect);
        paramDrawable.draw(paramCanvas);
        paramCanvas.restore();
    }

    public void a(View paramView, Object paramObject, boolean paramBoolean) {
        if ((this.j != null) && (!(this.j instanceof b))) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        b localb = new b();
        localb.a = paramView;
        localb.b = paramObject;
        localb.c = paramBoolean;
        this.ay.add(localb);
        if ((this.j != null) && (this.i != null)) {
            this.i.onChanged();
        }
    }

    protected void a(boolean paramBoolean) {
        int i = 0;
        int j = getChildCount();
        if (paramBoolean) {
            if (j > 0) {
                i = getChildAt(j - 1).getRight() + this.au;
            }
            f(j + this.V, i);
            l(getChildCount());
            return;
        }
        if (j > 0) {
        }
        for (i = getChildAt(0).getLeft() - this.au; ; i = getWidth() - 0) {
            g(this.V - 1, i);
            m(getChildCount());
            return;
        }
    }

    final int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        Log.i("HListView", "measureWithLargeChildren, from " + paramInt2 + " to " + paramInt3);
        Object localObject = this.j;
        if (localObject == null) {
            return new int[]{this.u.left + this.u.right, this.u.top + this.u.bottom};
        }
        int k = this.u.left;
        int m = this.u.right;
        int n = this.u.top;
        int i1 = this.u.bottom;
        if ((this.au > 0) && (this.at != null)) {
        }
        int j;
        for (paramInt6 = this.au; ; paramInt6 = 0) {
            int i = paramInt3;
            if (paramInt3 == -1) {
                i = ((ListAdapter) localObject).getCount() - 1;
            }
            localObject = this.p;
            boolean bool = y();
            boolean[] arrayOfBoolean = this.P;
            j = 0;
            paramInt3 = 0;
            while (paramInt2 <= i) {
                View localView = a(paramInt2, arrayOfBoolean);
                a(localView, paramInt2, paramInt1);
                if ((bool) && (((AbsHListView.k) localObject).b(((AbsHListView.f) localView.getLayoutParams()).a))) {
                    ((AbsHListView.k) localObject).a(localView, -1);
                }
                j = Math.max(j, localView.getMeasuredWidth() + paramInt6);
                paramInt3 = Math.max(paramInt3, localView.getMeasuredHeight());
                paramInt2 += 1;
            }
        }
        return new int[]{Math.min(j + (k + m), paramInt4), Math.min(paramInt3 + (n + i1), paramInt5)};
    }

    protected int b(int paramInt, boolean paramBoolean) {
        ListAdapter localListAdapter = this.j;
        int i;
        if ((localListAdapter == null) || (isInTouchMode())) {
            i = -1;
        }
        int j;
        label125:
        do {
            do {
                return i;
                j = localListAdapter.getCount();
                if (this.aE) {
                    break label125;
                }
                if (paramBoolean) {
                    i = Math.max(0, paramInt);
                    for (; ; ) {
                        paramInt = i;
                        if (i >= j) {
                            break;
                        }
                        paramInt = i;
                        if (localListAdapter.isEnabled(i)) {
                            break;
                        }
                        i += 1;
                    }
                }
                i = Math.min(paramInt, j - 1);
                for (; ; ) {
                    paramInt = i;
                    if (i < 0) {
                        break;
                    }
                    paramInt = i;
                    if (localListAdapter.isEnabled(i)) {
                        break;
                    }
                    i -= 1;
                }
                if (paramInt < 0) {
                    break;
                }
                i = paramInt;
            } while (paramInt < j);
            return -1;
            if (paramInt < 0) {
                break;
            }
            i = paramInt;
        } while (paramInt < j);
        return -1;
    }

    void b(Canvas paramCanvas, Drawable paramDrawable, Rect paramRect) {
        int i = paramDrawable.getMinimumWidth();
        paramCanvas.save();
        paramCanvas.clipRect(paramRect);
        if (paramRect.right - paramRect.left < i) {
            paramRect.right = (i + paramRect.left);
        }
        paramDrawable.setBounds(paramRect);
        paramDrawable.draw(paramCanvas);
        paramCanvas.restore();
    }

    public void b(View paramView) {
        a(paramView, null, true);
    }

    public void c(int paramInt) {
        super.c(paramInt);
    }

    protected boolean canAnimate() {
        return (super.canAnimate()) && (this.an > 0);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        if (this.y) {
            this.z = true;
        }
        int i2 = this.au;
        Drawable localDrawable1 = this.aw;
        Drawable localDrawable2 = this.ax;
        int i;
        int j;
        label44:
        label59:
        Rect localRect;
        int i3;
        int i5;
        int i8;
        int i6;
        boolean bool1;
        boolean bool2;
        int i4;
        boolean bool3;
        ListAdapter localListAdapter;
        int m;
        label188:
        Paint localPaint;
        int n;
        int i1;
        int i7;
        if (localDrawable1 != null) {
            i = 1;
            if (localDrawable2 == null) {
                break label491;
            }
            j = 1;
            if ((i2 <= 0) || (this.at == null)) {
                break label496;
            }
            k = 1;
            if ((k == 0) && (i == 0) && (j == 0)) {
                break label628;
            }
            localRect = this.aG;
            localRect.top = getPaddingTop();
            localRect.bottom = (getBottom() - getTop() - getPaddingBottom());
            i3 = getChildCount();
            i5 = this.ay.size();
            i8 = this.an;
            i6 = i8 - this.az.size() - 1;
            bool1 = this.aC;
            bool2 = this.aD;
            i4 = this.V;
            bool3 = this.aE;
            localListAdapter = this.j;
            if ((!isOpaque()) || (super.isOpaque())) {
                break label502;
            }
            m = 1;
            if ((m != 0) && (this.aH == null) && (this.aA)) {
                this.aH = new Paint();
                this.aH.setColor(getCacheColorHint());
            }
            localPaint = this.aH;
            n = getRight();
            i1 = getLeft();
            i7 = getScrollX() + (n - i1 - 0);
            if (this.K) {
                break label634;
            }
            n = getScrollX();
            if ((i3 > 0) && (n < 0)) {
                if (i == 0) {
                    break label508;
                }
                localRect.right = 0;
                localRect.left = n;
                a(paramCanvas, localDrawable1, localRect);
            }
            label310:
            i = 0;
            n = 0;
            label315:
            if (n >= i3) {
                break label575;
            }
            if (!bool1) {
                i1 = i;
                if (i4 + n < i5) {
                }
            } else if (!bool2) {
                i1 = i;
                if (i4 + n >= i6) {
                }
            } else {
                i = getChildAt(n).getRight();
                i1 = i;
                if (k != 0) {
                    i1 = i;
                    if (i < i7) {
                        if (j != 0) {
                            i1 = i;
                            if (n == i3 - 1) {
                            }
                        } else {
                            if ((!bool3) && ((!localListAdapter.isEnabled(i4 + n)) || ((n != i3 - 1) && (!localListAdapter.isEnabled(i4 + n + 1))))) {
                                break label538;
                            }
                            localRect.left = i;
                            localRect.right = (i + i2);
                            a(paramCanvas, localRect, n);
                            i1 = i;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            n += 1;
            i = i1;
            break label315;
            i = 0;
            break;
            label491:
            j = 0;
            break label44;
            label496:
            k = 0;
            break label59;
            label502:
            m = 0;
            break label188;
            label508:
            if (k == 0) {
                break label310;
            }
            localRect.right = 0;
            localRect.left = (-i2);
            a(paramCanvas, localRect, -1);
            break label310;
            label538:
            i1 = i;
            if (m != 0) {
                localRect.left = i;
                localRect.right = (i + i2);
                paramCanvas.drawRect(localRect, localPaint);
                i1 = i;
            }
        }
        label575:
        int k = getRight() + getScrollX();
        if ((j != 0) && (i4 + i3 == i8) && (k > i)) {
            localRect.left = i;
            localRect.right = k;
            b(paramCanvas, localDrawable2, localRect);
        }
        for (; ; ) {
            label628:
            super.dispatchDraw(paramCanvas);
            return;
            label634:
            n = getScrollX();
            if ((i3 > 0) && (i != 0)) {
                localRect.left = n;
                localRect.right = getChildAt(0).getLeft();
                a(paramCanvas, localDrawable1, localRect);
            }
            if (i != 0) {
                i = 1;
                if (i >= i3) {
                    break label848;
                }
                if (((bool1) || (i4 + i >= i5)) && ((bool2) || (i4 + i < i6))) {
                    i1 = getChildAt(i).getLeft();
                    if (i1 > 0) {
                        if ((!bool3) && ((!localListAdapter.isEnabled(i4 + i)) || ((i != i3 - 1) && (!localListAdapter.isEnabled(i4 + i + 1))))) {
                            break label815;
                        }
                        localRect.left = (i1 - i2);
                        localRect.right = i1;
                        a(paramCanvas, localRect, i - 1);
                    }
                }
            }
            for (; ; ) {
                i += 1;
                break;
                i = 0;
                break;
                label815:
                if (m != 0) {
                    localRect.left = (i1 - i2);
                    localRect.right = i1;
                    paramCanvas.drawRect(localRect, localPaint);
                }
            }
            label848:
            if ((i3 > 0) && (n > 0)) {
                if (j != 0) {
                    i = getRight();
                    localRect.left = i;
                    localRect.right = (i + n);
                    b(paramCanvas, localDrawable2, localRect);
                } else if (k != 0) {
                    localRect.left = i7;
                    localRect.right = (i7 + i2);
                    a(paramCanvas, localRect, -1);
                }
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
        boolean bool2 = super.dispatchKeyEvent(paramKeyEvent);
        boolean bool1 = bool2;
        if (!bool2) {
            bool1 = bool2;
            if (getFocusedChild() != null) {
                bool1 = bool2;
                if (paramKeyEvent.getAction() == 0) {
                    bool1 = onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent);
                }
            }
        }
        return bool1;
    }

    protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
        boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
        if (this.z) {
            this.z = false;
        }
        return bool;
    }

    protected int e(int paramInt) {
        int j = getChildCount();
        if (j > 0) {
            if (!this.K) {
                i = 0;
                while (i < j) {
                    if (paramInt <= getChildAt(i).getRight()) {
                        return i + this.V;
                    }
                    i += 1;
                }
            }
            int i = j - 1;
            while (i >= 0) {
                if (paramInt >= getChildAt(i).getLeft()) {
                    return i + this.V;
                }
                i -= 1;
            }
        }
        return -1;
    }

    protected void e() {
        a(this.ay);
        a(this.az);
        super.e();
        this.h = 0;
    }

    public void e(int paramInt1, int paramInt2) {
        if (this.j == null) {
        }
        for (; ; ) {
            return;
            if (!isInTouchMode()) {
                int i = b(paramInt1, true);
                paramInt1 = i;
                if (i >= 0) {
                    setNextSelectedPositionInt(i);
                    paramInt1 = i;
                }
            }
            while (paramInt1 >= 0) {
                this.h = 4;
                this.W = (this.u.left + paramInt2);
                if (this.ac) {
                    this.Z = paramInt1;
                    this.aa = this.j.getItemId(paramInt1);
                }
                if (this.I != null) {
                    this.I.a();
                }
                requestLayout();
                return;
                this.M = paramInt1;
            }
        }
    }

    protected void f() {
        boolean bool1 = this.as;
        if (!bool1) {
            this.as = true;
        }
        int j;
        int m;
        int n;
        int k;
        int i;
        Object localObject4;
        View localView3;
        Object localObject3;
        label136:
        label208:
        boolean bool2;
        try {
            super.f();
            invalidate();
            if (this.j == null) {
                e();
                c();
                return;
            }
            j = this.u.left;
            m = getRight() - getLeft() - this.u.right;
            n = getChildCount();
            k = 0;
            i = 0;
            localObject4 = null;
            View localView1 = null;
            localView3 = null;
            localObject3 = null;
            switch (this.h) {
                case 2:
                    k = this.al - this.V;
                    localObject2 = localView1;
                    if (k >= 0) {
                        localObject2 = localView1;
                        if (k < n) {
                            localObject2 = getChildAt(k);
                        }
                    }
                    localView1 = getChildAt(0);
                    if (this.aj >= 0) {
                        i = this.aj - this.al;
                    }
                    localView3 = getChildAt(k + i);
                    localObject4 = localObject2;
                    for (; ; ) {
                        bool2 = this.ai;
                        if (bool2) {
                            r();
                        }
                        if (this.an != 0) {
                            break;
                        }
                        e();
                        c();
                        return;
                        i = this.aj - this.V;
                        if ((i < 0) || (i >= n)) {
                            break label1153;
                        }
                        localView3 = getChildAt(i);
                        localView1 = null;
                        i = k;
                    }
                    if (this.an != this.j.getCount()) {
                        throw new IllegalStateException("The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView(" + getId() + ", " + getClass() + ") with Adapter(" + this.j.getClass() + ")]");
                    }
                    break;
            }
        } finally {
            if (!bool1) {
                this.as = false;
            }
        }
        setSelectedPositionInt(this.aj);
        int i1 = this.V;
        AbsHListView.k localk = this.p;
        Object localObject2 = null;
        if (bool2) {
            k = 0;
            while (k < n) {
                localk.a(getChildAt(k), i1 + k);
                k += 1;
            }
        }
        localk.a(n, i1);
        Object localObject5 = getFocusedChild();
        label491:
        label508:
        label560:
        View localView2;
        if (localObject5 != null) {
            if ((!bool2) || (c((View) localObject5))) {
                localObject3 = findFocus();
                if (localObject3 == null) {
                    break label1172;
                }
                ((View) localObject3).onStartTemporaryDetach();
                break label1172;
            }
            requestFocus();
            localObject5 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject5;
            detachAllViewsFromParent();
            localk.d();
            switch (this.h) {
                case 2:
                    if (n == 0) {
                        if (!this.K) {
                            setSelectedPositionInt(b(0, true));
                            localView2 = k(j);
                            label589:
                            localk.e();
                            if (localView2 == null) {
                                break label1063;
                            }
                            if ((!this.aF) || (!hasFocus()) || (localView2.hasFocus())) {
                                break label1053;
                            }
                            if ((localView2 == localObject3) && (localObject2 != null) && (((View) localObject2).requestFocus())) {
                                break label1182;
                            }
                            if (!localView2.requestFocus()) {
                                break label1187;
                            }
                        }
                    }
                    break;
            }
        }
        for (; ; ) {
            if (i == 0) {
                localView3 = getFocusedChild();
                if (localView3 != null) {
                    localView3.clearFocus();
                }
                a(-1, localView2);
                label679:
                this.J = localView2.getLeft();
            }
            label1053:
            label1063:
            label1142:
            for (; ; ) {
                if ((localObject2 != null) && (((View) localObject2).getWindowToken() != null)) {
                    ((View) localObject2).onFinishTemporaryDetach();
                }
                this.h = 0;
                this.ai = false;
                if (this.O != null) {
                    post(this.O);
                    this.O = null;
                }
                this.ac = false;
                setNextSelectedPositionInt(this.al);
                g();
                if (this.an > 0) {
                    v();
                }
                c();
                if (bool1) {
                    break;
                }
                this.as = false;
                return;
                if (localView3 != null) {
                    localView2 = a(localView3.getLeft(), j, m);
                    break label589;
                }
                localView2 = h(j, m);
                break label589;
                localView2 = i(this.Z, this.W);
                break label589;
                localView2 = g(this.an - 1, m);
                a();
                break label589;
                this.V = 0;
                localView2 = k(j);
                a();
                break label589;
                localView2 = i(n(), this.W);
                break label589;
                localView2 = a((View) localObject4, localView3, i, j, m);
                break label589;
                setSelectedPositionInt(b(this.an - 1, false));
                localView2 = g(this.an - 1, m);
                break label589;
                if ((this.al >= 0) && (this.al < this.an)) {
                    i = this.al;
                    if (localObject4 == null) {
                    }
                    for (; ; ) {
                        localView2 = i(i, j);
                        break;
                        j = ((View) localObject4).getLeft();
                    }
                }
                if (this.V < this.an) {
                    i = this.V;
                    if (localView2 == null) {
                    }
                    for (; ; ) {
                        localView2 = i(i, j);
                        break;
                        j = localView2.getLeft();
                    }
                }
                localView2 = i(0, j);
                break label589;
                localView2.setSelected(false);
                this.o.setEmpty();
                break label679;
                a(-1, localView2);
                break label679;
                if ((this.F > 0) && (this.F < 3)) {
                    localView2 = getChildAt(this.A - this.V);
                    if (localView2 != null) {
                        a(this.A, localView2);
                    }
                }
                for (; ; ) {
                    if ((!hasFocus()) || (localObject2 == null)) {
                        break label1142;
                    }
                    ((View) localObject2).requestFocus();
                    break;
                    this.J = 0;
                    this.o.setEmpty();
                }
            }
            localObject2 = null;
            localObject3 = null;
            break label508;
            label1153:
            localView2 = null;
            i = k;
            break label208;
            break label136;
            localView2 = null;
            i = k;
            break label208;
            label1172:
            localObject2 = localObject5;
            break label491;
            break label560;
            label1182:
            i = 1;
            continue;
            label1187:
            i = 0;
        }
    }

    public ListAdapter getAdapter() {
        return this.j;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        if ((this.j != null) && (this.j.hasStableIds())) {
            return getCheckedItemIds();
        }
        Object localObject;
        int m;
        long[] arrayOfLong;
        int j;
        int i;
        if ((this.b != 0) && (this.f != null) && (this.j != null)) {
            localObject = this.f;
            m = ((SparseBooleanArray) localObject).size();
            arrayOfLong = new long[m];
            ListAdapter localListAdapter = this.j;
            j = 0;
            i = 0;
            if (j < m) {
                if (!((SparseBooleanArray) localObject).valueAt(j)) {
                    break label150;
                }
                int k = i + 1;
                arrayOfLong[i] = localListAdapter.getItemId(((SparseBooleanArray) localObject).keyAt(j));
                i = k;
            }
        }
        label150:
        for (; ; ) {
            j += 1;
            break;
            if (i == m) {
                return arrayOfLong;
            }
            localObject = new long[i];
            System.arraycopy(arrayOfLong, 0, localObject, 0, i);
            return (long[]) localObject;
            return new long[0];
        }
    }

    public Drawable getDivider() {
        return this.at;
    }

    public int getDividerWidth() {
        return this.au;
    }

    public int getFooterViewsCount() {
        return this.az.size();
    }

    public int getHeaderViewsCount() {
        return this.ay.size();
    }

    public boolean getItemsCanFocus() {
        return this.aF;
    }

    public int getMaxScrollAmount() {
        return (int) (0.33F * (getRight() - getLeft()));
    }

    public Drawable getOverscrollFooter() {
        return this.ax;
    }

    public Drawable getOverscrollHeader() {
        return this.aw;
    }

    boolean h(int paramInt) {
        boolean bool;
        if (paramInt == 33) {
            paramInt = Math.max(0, this.al - getChildCount() - 1);
            bool = false;
        }
        for (; ; ) {
            if (paramInt >= 0) {
                paramInt = b(paramInt, bool);
                if (paramInt >= 0) {
                    this.h = 4;
                    this.W = (getPaddingLeft() + getHorizontalFadingEdgeLength());
                    if ((bool) && (paramInt > this.an - getChildCount())) {
                        this.h = 3;
                    }
                    if ((!bool) && (paramInt < getChildCount())) {
                        this.h = 1;
                    }
                    setSelectionInt(paramInt);
                    c();
                    if (!awakenScrollBars()) {
                        invalidate();
                    }
                    return true;
                    if (paramInt != 130) {
                        break label153;
                    }
                    paramInt = Math.min(this.an - 1, this.al + getChildCount() - 1);
                    bool = true;
                    continue;
                }
            }
            return false;
            label153:
            paramInt = -1;
            bool = false;
        }
    }

    boolean i(int paramInt) {
        boolean bool2 = true;
        boolean bool1;
        if (paramInt == 33) {
            if (this.al == 0) {
                break label123;
            }
            paramInt = b(0, true);
            bool1 = bool2;
            if (paramInt >= 0) {
                this.h = 1;
                setSelectionInt(paramInt);
                c();
                bool1 = bool2;
            }
        }
        for (; ; ) {
            if ((bool1) && (!awakenScrollBars())) {
                awakenScrollBars();
                invalidate();
            }
            return bool1;
            if ((paramInt == 130) && (this.al < this.an - 1)) {
                paramInt = b(this.an - 1, true);
                bool1 = bool2;
                if (paramInt >= 0) {
                    this.h = 3;
                    setSelectionInt(paramInt);
                    c();
                    bool1 = bool2;
                }
            } else {
                label123:
                bool1 = false;
            }
        }
    }

    public boolean isOpaque() {
        boolean bool;
        if (((this.z) && (this.aA) && (this.aB)) || (super.isOpaque())) {
            bool = true;
            if (!bool) {
                return bool;
            }
            if (this.u == null) {
                break label77;
            }
        }
        View localView;
        label77:
        for (int i = this.u.left; ; i = getPaddingLeft()) {
            localView = getChildAt(0);
            if ((localView != null) && (localView.getLeft() <= i)) {
                break label85;
            }
            return false;
            bool = false;
            break;
        }
        label85:
        int j = getWidth();
        if (this.u != null) {
        }
        for (i = this.u.right; ; i = getPaddingRight()) {
            localView = getChildAt(getChildCount() - 1);
            if ((localView != null) && (localView.getRight() >= j - i)) {
                break;
            }
            return false;
        }
        return bool;
    }

    boolean j(int paramInt) {
        try {
            this.ae = true;
            boolean bool = o(paramInt);
            if (bool) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
            }
            return bool;
        } finally {
            this.ae = false;
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        int j = getChildCount();
        if (j > 0) {
            int i = 0;
            while (i < j) {
                b(getChildAt(i));
                i += 1;
            }
            removeAllViews();
        }
    }

    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
        int k = 0;
        int j = 0;
        super.onFocusChanged(paramBoolean, paramInt, paramRect);
        ListAdapter localListAdapter = this.j;
        int i = -1;
        int n = k;
        int i1 = i;
        Rect localRect;
        int m;
        if (localListAdapter != null) {
            n = k;
            i1 = i;
            if (paramBoolean) {
                n = k;
                i1 = i;
                if (paramRect != null) {
                    paramRect.offset(getScrollX(), getScrollY());
                    if (localListAdapter.getCount() < getChildCount() + this.V) {
                        this.h = 0;
                        f();
                    }
                    localRect = this.aG;
                    m = Integer.MAX_VALUE;
                    int i2 = getChildCount();
                    int i3 = this.V;
                    k = 0;
                    n = j;
                    i1 = i;
                    if (k < i2) {
                        if (!localListAdapter.isEnabled(i3 + k)) {
                            n = j;
                            j = i;
                            i = n;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            n = k + 1;
            k = j;
            j = i;
            i = k;
            k = n;
            break;
            View localView = getChildAt(k);
            localView.getDrawingRect(localRect);
            offsetDescendantRectToMyCoords(localView, localRect);
            n = a(paramRect, localRect, paramInt);
            if (n < m) {
                i = localView.getLeft();
                j = k;
                m = n;
                continue;
                if (i1 >= 0) {
                    e(this.V + i1, n);
                    return;
                }
                requestLayout();
            } else {
                n = i;
                i = j;
                j = n;
            }
        }
    }

    public void onGlobalLayout() {
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
        paramAccessibilityEvent.setClassName(HListView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setClassName(HListView.class.getName());
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        return a(paramInt, 1, paramKeyEvent);
    }

    public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent) {
        return a(paramInt1, paramInt2, paramKeyEvent);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        return a(paramInt, 1, paramKeyEvent);
    }

    @TargetApi(11)
    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        int i5 = View.MeasureSpec.getMode(paramInt1);
        int i6 = View.MeasureSpec.getMode(paramInt2);
        int m = View.MeasureSpec.getSize(paramInt1);
        int n = View.MeasureSpec.getSize(paramInt2);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i1 = 0;
        int i;
        int j;
        if (this.j == null) {
            paramInt1 = 0;
            this.an = paramInt1;
            i = i4;
            int k = i3;
            j = i2;
            if (this.an > 0) {
                if (i5 != 0) {
                    i = i4;
                    k = i3;
                    j = i2;
                    if (i6 != 0) {
                    }
                } else {
                    Log.d("HListView", "let's measure a scrap child");
                    View localView = a(0, this.P);
                    a(localView, 0, paramInt2);
                    i2 = localView.getMeasuredWidth();
                    i3 = localView.getMeasuredHeight();
                    paramInt1 = i1;
                    if (Build.VERSION.SDK_INT >= 11) {
                        paramInt1 = combineMeasuredStates(0, localView.getMeasuredState());
                    }
                    i = paramInt1;
                    k = i3;
                    j = i2;
                    if (y()) {
                        i = paramInt1;
                        k = i3;
                        j = i2;
                        if (this.p.b(((AbsHListView.f) localView.getLayoutParams()).a)) {
                            this.p.a(localView, -1);
                            j = i2;
                            k = i3;
                            i = paramInt1;
                        }
                    }
                }
            }
            if (i6 != 0) {
                break label338;
            }
            paramInt1 = k + (this.u.top + this.u.bottom) + getHorizontalScrollbarHeight();
        }
        for (; ; ) {
            i = m;
            if (i5 == 0) {
                i = this.u.left + this.u.right + j + getHorizontalFadingEdgeLength() * 2;
            }
            j = i;
            if (i5 == Integer.MIN_VALUE) {
                j = a(paramInt2, 0, -1, i, -1);
            }
            setMeasuredDimension(j, paramInt1);
            this.v = paramInt2;
            return;
            paramInt1 = this.j.getCount();
            break;
            label338:
            if ((i6 == Integer.MIN_VALUE) && (this.an > 0) && (this.av > -1)) {
                paramInt1 = a(paramInt2, this.av, this.av, m, n, -1)[1];
            } else if (Build.VERSION.SDK_INT >= 11) {
                paramInt1 = n | 0xFF000000 & i;
            } else {
                paramInt1 = n;
            }
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (getChildCount() > 0) {
            View localView = getFocusedChild();
            if (localView != null) {
                int i = this.V;
                int j = indexOfChild(localView);
                int k = Math.max(0, localView.getRight() - (paramInt1 - getPaddingLeft()));
                int m = localView.getLeft();
                if (this.aJ == null) {
                    this.aJ = new c(null);
                }
                post(this.aJ.a(i + j, m - k));
            }
        }
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
        int n = paramRect.left;
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramRect.offset(-paramView.getScrollX(), -paramView.getScrollY());
        int m = getWidth();
        int j = getScrollX();
        int k = j + m;
        int i1 = getHorizontalFadingEdgeLength();
        int i = j;
        if (z()) {
            if (this.al <= 0) {
                i = j;
                if (n <= i1) {
                }
            } else {
                i = j + i1;
            }
        }
        n = getChildAt(getChildCount() - 1).getRight();
        j = k;
        if (A()) {
            if (this.al >= this.an - 1) {
                j = k;
                if (paramRect.right >= n - i1) {
                }
            } else {
                j = k - i1;
            }
        }
        if ((paramRect.right > j) && (paramRect.left > i)) {
            if (paramRect.width() > m) {
                i = paramRect.left - i + 0;
                i = Math.min(i, n - j);
            }
        }
        for (; ; ) {
            if (i != 0) {
            }
            for (paramBoolean = true; ; paramBoolean = false) {
                if (paramBoolean) {
                    r(-i);
                    a(-1, paramView);
                    this.J = paramView.getTop();
                    invalidate();
                }
                return paramBoolean;
                i = paramRect.right - j + 0;
                break;
                if ((paramRect.left >= i) || (paramRect.right >= j)) {
                    break label335;
                }
                if (paramRect.width() > m) {
                }
                for (j = 0 - (j - paramRect.right); ; j = 0 - (i - paramRect.left)) {
                    i = Math.max(j, getChildAt(0).getLeft() - i);
                    break;
                }
            }
            label335:
            i = 0;
        }
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if ((this.j != null) && (this.i != null)) {
            this.j.unregisterDataSetObserver(this.i);
        }
        e();
        this.p.b();
        int i;
        if ((this.ay.size() > 0) || (this.az.size() > 0)) {
            this.j = new b(this.ay, this.az, paramListAdapter);
            this.aq = -1;
            this.ar = Long.MIN_VALUE;
            super.setAdapter(paramListAdapter);
            if (this.j == null) {
                break label244;
            }
            this.aE = this.j.areAllItemsEnabled();
            this.ao = this.an;
            this.an = this.j.getCount();
            t();
            this.i = new AbsHListView.a(this);
            this.j.registerDataSetObserver(this.i);
            this.p.a(this.j.getViewTypeCount());
            if (!this.K) {
                break label234;
            }
            i = b(this.an - 1, false);
            label200:
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.an == 0) {
                v();
            }
        }
        for (; ; ) {
            requestLayout();
            return;
            this.j = paramListAdapter;
            break;
            label234:
            i = b(0, true);
            break label200;
            label244:
            this.aE = true;
            t();
            v();
        }
    }

    public void setCacheColorHint(int paramInt) {
        if (paramInt >>> 24 == 255) {
        }
        for (boolean bool = true; ; bool = false) {
            this.aA = bool;
            if (bool) {
                if (this.aH == null) {
                    this.aH = new Paint();
                }
                this.aH.setColor(paramInt);
            }
            super.setCacheColorHint(paramInt);
            return;
        }
    }

    public void setDivider(Drawable paramDrawable) {
        boolean bool = false;
        Log.i("HListView", "setDivider: " + paramDrawable);
        if (paramDrawable != null) {
        }
        for (this.au = paramDrawable.getIntrinsicWidth(); ; this.au = 0) {
            this.at = paramDrawable;
            if ((paramDrawable == null) || (paramDrawable.getOpacity() == -1)) {
                bool = true;
            }
            this.aB = bool;
            requestLayout();
            invalidate();
            return;
        }
    }

    public void setDividerWidth(int paramInt) {
        Log.i("HListView", "setDividerWidth: " + paramInt);
        this.au = paramInt;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean paramBoolean) {
        this.aD = paramBoolean;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean paramBoolean) {
        this.aC = paramBoolean;
        invalidate();
    }

    public void setItemsCanFocus(boolean paramBoolean) {
        this.aF = paramBoolean;
        if (!paramBoolean) {
            setDescendantFocusability(393216);
        }
    }

    public void setOverscrollFooter(Drawable paramDrawable) {
        this.ax = paramDrawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable paramDrawable) {
        this.aw = paramDrawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public void setSelection(int paramInt) {
        e(paramInt, 0);
    }

    public void setSelectionInt(int paramInt) {
        int i = 1;
        setNextSelectedPositionInt(paramInt);
        int j = this.al;
        if (j >= 0) {
            if (paramInt != j - 1) {
            }
        }
        for (; ; ) {
            if (this.I != null) {
                this.I.a();
            }
            f();
            if (i != 0) {
                awakenScrollBars();
            }
            return;
            if (paramInt != j + 1) {
                i = 0;
            }
        }
    }

    @ViewDebug.ExportedProperty(category = "list")
    protected boolean y() {
        return true;
    }

    private static class a {
        private int a;
        private int b;

        public int a() {
            return this.a;
        }

        void a(int paramInt1, int paramInt2) {
            this.a = paramInt1;
            this.b = paramInt2;
        }

        public int b() {
            return this.b;
        }
    }

    public static class b {
        public View a;
        public Object b;
        public boolean c;
    }

    private class c
            implements Runnable {
        private int b;
        private int c;

        private c() {
        }

        public c a(int paramInt1, int paramInt2) {
            this.b = paramInt1;
            this.c = paramInt2;
            return this;
        }

        public void run() {
            HListView.this.e(this.b, this.c);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/HListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */