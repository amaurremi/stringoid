package mobi.ifunny.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import mobi.ifunny.j;

public class PriorityLinearLayout
        extends ViewGroup {
    public static int a = 0;
    private int b;
    private List<View> c;
    private Comparator<View> d = new s(this);
    private int e;
    private int f;
    private int g;
    private int h;

    public PriorityLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    private void a(int paramInt1, int paramInt2) {
        int i2 = getChildCount();
        int i3 = View.MeasureSpec.getMode(paramInt1);
        int i4 = View.MeasureSpec.getSize(paramInt1);
        int i5 = View.MeasureSpec.getMode(paramInt2);
        int i = View.MeasureSpec.getSize(paramInt2);
        int i6 = getPaddingLeft();
        int i7 = getPaddingRight();
        int k = i - getPaddingTop() - getPaddingBottom();
        int n = 0;
        int m = 0;
        int i1 = 0;
        while (i1 < i2) {
            View localView = (View) this.c.get(i1);
            int j;
            if (localView.getVisibility() == 8) {
                j = m;
                i = n;
                i1 += 1;
                m = j;
                n = i;
            } else {
                t localt = (t) localView.getLayoutParams();
                j = localt.leftMargin;
                int i8 = localt.rightMargin;
                i = View.MeasureSpec.makeMeasureSpec(0, 0);
                switch (i3) {
                    default:
                        label184:
                        j = View.MeasureSpec.makeMeasureSpec(0, 0);
                        i8 = k - localt.topMargin - localt.bottomMargin;
                        switch (i5) {
                        }
                        break;
                }
                for (; ; ) {
                    localView.measure(i, j);
                    i = localView.getMeasuredWidth();
                    i8 = localView.getMeasuredHeight();
                    j = localt.leftMargin;
                    int i9 = localt.rightMargin;
                    i8 = i8 + localt.topMargin + localt.bottomMargin;
                    i = Math.max(i + j + i9, n);
                    j = m + i8;
                    k -= i8;
                    break;
                    if (localt.width == -2) {
                        i = View.MeasureSpec.makeMeasureSpec(0, 0);
                        break label184;
                    }
                    if (localt.width == -1) {
                        i = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
                        break label184;
                    }
                    i = View.MeasureSpec.makeMeasureSpec(localt.width, 1073741824);
                    break label184;
                    if (localt.width == -2) {
                        i = View.MeasureSpec.makeMeasureSpec(i4 - i6 - i7 - j - i8, Integer.MIN_VALUE);
                        break label184;
                    }
                    if (localt.width == -1) {
                        i = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
                        break label184;
                    }
                    i = View.MeasureSpec.makeMeasureSpec(localt.width, 1073741824);
                    break label184;
                    if ((localt.height == -2) || (localt.height == -1)) {
                        j = View.MeasureSpec.makeMeasureSpec(0, 0);
                    } else {
                        j = View.MeasureSpec.makeMeasureSpec(localt.height, 1073741824);
                        continue;
                        if (localt.height == -2) {
                            j = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
                        } else if (localt.height == -1) {
                            j = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                        } else {
                            j = View.MeasureSpec.makeMeasureSpec(localt.height, 1073741824);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(resolveSize(getPaddingLeft() + n + getPaddingRight(), paramInt1), resolveSize(getPaddingTop() + m + getPaddingBottom(), paramInt2));
    }

    private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        paramInt2 = getMeasuredWidth();
        paramInt4 = getMeasuredHeight();
        int i = getChildCount();
        if ((paramInt2 == 0) || (paramInt4 == 0) || (i == 0)) {
            return;
        }
        Rect localRect1 = new Rect();
        Rect localRect2 = new Rect();
        paramInt2 = getPaddingTop();
        paramInt4 = 0;
        label58:
        View localView;
        if (paramInt4 < i) {
            localView = getChildAt(paramInt4);
            if (localView.getVisibility() != 8) {
                break label92;
            }
        }
        for (; ; ) {
            paramInt4 += 1;
            break label58;
            break;
            label92:
            int j = localView.getMeasuredWidth();
            int k = localView.getMeasuredHeight();
            t localt = (t) localView.getLayoutParams();
            paramInt2 += localt.topMargin;
            int m = paramInt2 + k;
            localRect1.set(getPaddingLeft() + localt.leftMargin, paramInt2, paramInt3 - paramInt1 - getPaddingRight() - localt.rightMargin, m);
            Gravity.apply(localt.gravity, j, k, localRect1, localRect2);
            localView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
            paramInt2 = localt.bottomMargin + m;
        }
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        this.c = new ArrayList();
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, j.mobi_ifunny_view_PriorityLinearLayout);
        this.b = paramContext.getInt(5, 0);
        this.e = paramContext.getDimensionPixelSize(1, 0);
        this.f = paramContext.getDimensionPixelSize(2, 0);
        this.g = paramContext.getDimensionPixelSize(3, 0);
        this.h = paramContext.getDimensionPixelSize(0, 0);
        paramContext.recycle();
    }

    private void a(View paramView) {
        this.c.add(paramView);
        Collections.sort(this.c, this.d);
    }

    private void b(int paramInt1, int paramInt2) {
        int i2 = getChildCount();
        int i3 = View.MeasureSpec.getMode(paramInt1);
        int i = View.MeasureSpec.getSize(paramInt1);
        int i4 = View.MeasureSpec.getMode(paramInt2);
        int i5 = View.MeasureSpec.getSize(paramInt2);
        int m = i - getPaddingLeft() - getPaddingRight();
        int i6 = getPaddingTop();
        int i7 = getPaddingBottom();
        int k = 0;
        int n = 0;
        int i1 = 0;
        while (i1 < i2) {
            View localView = (View) this.c.get(i1);
            int j;
            if (localView.getVisibility() == 8) {
                j = n;
                i = k;
                k = m;
                i1 += 1;
                m = k;
                n = j;
                k = i;
            } else {
                t localt = (t) localView.getLayoutParams();
                i = m - localt.leftMargin - localt.rightMargin;
                j = View.MeasureSpec.makeMeasureSpec(0, 0);
                label196:
                int i8;
                switch (i3) {
                    default:
                        i = View.MeasureSpec.makeMeasureSpec(0, 0);
                        i8 = i5 - i6 - i7 - localt.topMargin - localt.bottomMargin;
                        switch (i4) {
                        }
                        break;
                }
                for (; ; ) {
                    localView.measure(j, i);
                    j = localView.getMeasuredWidth();
                    i = localView.getMeasuredHeight();
                    i8 = localt.leftMargin;
                    i8 = localt.rightMargin + (j + i8);
                    j = Math.max(i + localt.topMargin + localt.bottomMargin, n);
                    i = k + i8;
                    k = m - i8;
                    break;
                    if ((localt.width == -2) || (localt.width == -1)) {
                        j = View.MeasureSpec.makeMeasureSpec(0, 0);
                        break label196;
                    }
                    j = View.MeasureSpec.makeMeasureSpec(localt.width, 1073741824);
                    break label196;
                    if (localt.width == -2) {
                        j = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
                        break label196;
                    }
                    if (localt.width == -1) {
                        j = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                        break label196;
                    }
                    j = View.MeasureSpec.makeMeasureSpec(localt.width, 1073741824);
                    break label196;
                    if (localt.height == -2) {
                        i = View.MeasureSpec.makeMeasureSpec(0, 0);
                    } else if (localt.height == -1) {
                        i = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
                    } else {
                        i = View.MeasureSpec.makeMeasureSpec(localt.height, 1073741824);
                        continue;
                        if (localt.height == -2) {
                            i = View.MeasureSpec.makeMeasureSpec(i8, Integer.MIN_VALUE);
                        } else if (localt.height == -1) {
                            i = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                        } else {
                            i = View.MeasureSpec.makeMeasureSpec(localt.height, 1073741824);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(resolveSize(getPaddingLeft() + k + getPaddingRight(), paramInt1), resolveSize(getPaddingTop() + n + getPaddingBottom(), paramInt2));
    }

    private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        paramInt1 = getMeasuredWidth();
        paramInt3 = getMeasuredHeight();
        int i = getChildCount();
        if ((paramInt1 == 0) || (paramInt3 == 0) || (i == 0)) {
            return;
        }
        Rect localRect1 = new Rect();
        Rect localRect2 = new Rect();
        paramInt1 = getPaddingLeft();
        paramInt3 = 0;
        label55:
        View localView;
        if (paramInt3 < i) {
            localView = getChildAt(paramInt3);
            if (localView.getVisibility() != 8) {
                break label85;
            }
        }
        for (; ; ) {
            paramInt3 += 1;
            break label55;
            break;
            label85:
            int j = localView.getMeasuredWidth();
            int k = localView.getMeasuredHeight();
            t localt = (t) localView.getLayoutParams();
            paramInt1 += localt.leftMargin;
            int m = paramInt1 + j;
            localRect1.set(paramInt1, getPaddingTop() + localt.topMargin, m, paramInt4 - paramInt2 - getPaddingBottom() - localt.bottomMargin);
            Gravity.apply(localt.gravity, j, k, localRect1, localRect2);
            localView.layout(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
            paramInt1 = localt.rightMargin + m;
        }
    }

    private void b(View paramView) {
        this.c.remove(paramView);
        Collections.sort(this.c, this.d);
    }

    protected t a() {
        return new t(-2, -2, a, null);
    }

    public t a(AttributeSet paramAttributeSet) {
        return new t(getContext(), paramAttributeSet, null);
    }

    protected t a(ViewGroup.LayoutParams paramLayoutParams) {
        return new t(paramLayoutParams);
    }

    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        super.addView(paramView, paramInt, paramLayoutParams);
        a(paramView);
    }

    protected boolean addViewInLayout(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean) {
        paramBoolean = super.addViewInLayout(paramView, paramInt, paramLayoutParams, paramBoolean);
        a(paramView);
        return paramBoolean;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return paramLayoutParams instanceof t;
    }

    public void getHitRect(Rect paramRect) {
        super.getHitRect(paramRect);
        paramRect.set(paramRect.left - this.e, paramRect.top - this.g, paramRect.right + this.f, paramRect.bottom + this.h);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (this.b == 0) {
            a(paramInt1, paramInt2, paramInt3, paramInt4);
            return;
        }
        b(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if (getChildCount() == 0) {
            super.onMeasure(paramInt1, paramInt2);
            return;
        }
        if (this.b == 0) {
            a(paramInt1, paramInt2);
            return;
        }
        b(paramInt1, paramInt2);
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.c.clear();
    }

    public void removeAllViewsInLayout() {
        super.removeAllViewsInLayout();
        this.c.clear();
    }

    public void removeView(View paramView) {
        super.removeView(paramView);
        b(paramView);
    }

    public void removeViewAt(int paramInt) {
        b(getChildAt(paramInt));
        super.removeViewAt(paramInt);
    }

    public void removeViewInLayout(View paramView) {
        super.removeViewInLayout(paramView);
        b(paramView);
    }

    public void removeViews(int paramInt1, int paramInt2) {
        int i = paramInt1;
        while (i < paramInt1 + paramInt2) {
            View localView = getChildAt(i);
            this.c.remove(localView);
            i += 1;
        }
        Collections.sort(this.c, this.d);
        super.removeViews(paramInt1, paramInt2);
    }

    public void removeViewsInLayout(int paramInt1, int paramInt2) {
        int i = paramInt1;
        while (i < paramInt1 + paramInt2) {
            View localView = getChildAt(i);
            this.c.remove(localView);
            i += 1;
        }
        Collections.sort(this.c, this.d);
        super.removeViewsInLayout(paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/view/PriorityLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */