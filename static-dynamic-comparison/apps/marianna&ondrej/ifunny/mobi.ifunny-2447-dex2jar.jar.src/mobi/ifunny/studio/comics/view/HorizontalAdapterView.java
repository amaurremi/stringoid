package mobi.ifunny.studio.comics.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout.LayoutParams;
import mobi.ifunny.view.a.a;

public class HorizontalAdapterView
        extends AdapterView<Adapter> {
    protected a a;
    private DataSetObserver b;
    private Adapter c;
    private i d;
    private boolean e;
    private int[] f;
    private int[] g;
    private int h;
    private int i;
    private int j;
    private Rect k;
    private Rect[] l;
    private int m;
    private int n;
    private int[] o;
    private GestureDetector p;
    private boolean q;
    private j r;
    private View s;
    private Rect t;
    private h u;

    public HorizontalAdapterView(Context paramContext) {
        super(paramContext);
        a(paramContext, null);
    }

    public HorizontalAdapterView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        a(paramContext, paramAttributeSet);
    }

    public HorizontalAdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a(paramContext, paramAttributeSet);
    }

    private View a(View paramView, int paramInt) {
        if (this.c == null) {
            return null;
        }
        return this.c.getView(paramInt, paramView, this);
    }

    private void a(int paramInt) {
        this.j = paramInt;
        if (paramInt != 0) {
            this.f = new int[paramInt];
            this.g = new int[paramInt];
            this.o = new int[paramInt];
            this.l = new Rect[paramInt];
            int i1 = 0;
            while (i1 < paramInt) {
                this.f[i1] = b(i1);
                this.g[i1] = c(i1);
                this.o[i1] = getPaddingLeft();
                this.l[i1] = new Rect();
                i1 += 1;
            }
        }
        this.i = 0;
        setWasChanged(true);
    }

    private void a(int paramInt1, int paramInt2) {
        int i1 = this.g[paramInt2];
        int i2 = this.c.getCount();
        while ((paramInt1 < getRightWithPadding()) && (i1 < i2)) {
            View localView = i.a(this.d, i1);
            i1 += this.j;
            a(paramInt2, -1, localView);
            paramInt1 += localView.getMeasuredWidth();
        }
        this.g[paramInt2] = i1;
    }

    private void a(int paramInt1, int paramInt2, View paramView) {
        g localg2 = (g) paramView.getLayoutParams();
        g localg1 = localg2;
        if (localg2 == null) {
            localg1 = a();
        }
        addViewInLayout(paramView, paramInt2, localg1, true);
        this.r.a(paramInt1, paramInt2, paramView);
        paramView.forceLayout();
        a(paramView, paramInt1, paramInt2, this.i, false);
    }

    private void a(int paramInt, boolean paramBoolean) {
        int i1 = 0;
        while (i1 < this.j) {
            int i3 = this.r.c(i1);
            int i2 = 0;
            while (i2 < i3) {
                a(this.r.b(i1, i2), i1, i2, paramInt, paramBoolean);
                i2 += 1;
            }
            i1 += 1;
        }
    }

    private void a(Context paramContext, AttributeSet paramAttributeSet) {
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, mobi.ifunny.j.mobi_ifunny_editor_view_HorizontalAdapterView);
        int i2 = paramAttributeSet.getIndexCount();
        int i1 = 0;
        if (i1 < i2) {
            int i3 = paramAttributeSet.getIndex(i1);
            switch (i3) {
            }
            for (; ; ) {
                i1 += 1;
                break;
                i3 = paramAttributeSet.getResourceId(i3, 0);
                this.s = LayoutInflater.from(paramContext).inflate(i3, this, false);
                this.t = new Rect();
            }
        }
        paramAttributeSet.recycle();
        this.r = new j(this, null);
        this.h = getResources().getDimensionPixelSize(2131427414);
        this.k = new Rect();
        this.b = new f(this, null);
        this.d = new i(this, null);
        this.a = new a(paramContext, new AccelerateDecelerateInterpolator(), true);
        float f1 = ViewConfiguration.getScrollFriction() / 10.0F;
        this.a.a(f1);
        this.p = new GestureDetector(paramContext, new e(this, null));
        this.u = new h(this, null);
        a(0);
    }

    private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
        paramView.forceLayout();
        paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(paramInt3, Integer.MIN_VALUE));
        paramView.forceLayout();
        paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(paramInt3, Integer.MIN_VALUE));
    }

    private boolean a(MotionEvent paramMotionEvent, View paramView) {
        Rect localRect = new Rect();
        int[] arrayOfInt = new int[2];
        paramView.getLocationOnScreen(arrayOfInt);
        int i1 = arrayOfInt[0];
        int i2 = paramView.getWidth();
        int i3 = arrayOfInt[1];
        localRect.set(i1, i3, i2 + i1, paramView.getHeight() + i3);
        return localRect.contains((int) paramMotionEvent.getRawX(), (int) paramMotionEvent.getRawY());
    }

    private int b(int paramInt) {
        return -this.j + paramInt;
    }

    private void b() {
        int i1 = 0;
        while (i1 < this.j) {
            int i4 = this.r.c(i1);
            int i3 = this.f[i1];
            int i2 = 0;
            while (i2 < i4) {
                View localView = this.r.b(i1, i2);
                i3 += this.j;
                i.a(this.d, localView, i3);
                i2 += 1;
            }
            i1 += 1;
        }
    }

    private void b(int paramInt1, int paramInt2) {
        int i3 = this.o[paramInt2];
        int i1 = this.f[paramInt2];
        int i2 = paramInt1;
        paramInt1 = i3;
        while ((i2 > getPaddingLeft()) && (i1 >= paramInt2)) {
            View localView = i.a(this.d, i1);
            a(paramInt2, 0, localView);
            i3 = localView.getMeasuredWidth();
            i2 -= i3;
            i1 -= this.j;
            paramInt1 -= i3;
        }
        this.o[paramInt2] = paramInt1;
        this.f[paramInt2] = i1;
    }

    private int c(int paramInt) {
        return paramInt;
    }

    private void c() {
        int i1;
        int i2;
        Object localObject;
        if (this.j > 0) {
            for (; ; ) {
                e(this.m);
                e();
                e(this.m);
                this.q = d();
                if ((!this.q) || (getChildCount() <= 0)) {
                    break label232;
                }
                if (this.f[0] >= 0) {
                    break;
                }
                i1 = this.r.a(0).getLeft();
                if (i1 <= getPaddingLeft()) {
                    break;
                }
                this.m -= i1 - getPaddingLeft();
                this.a.a(true);
            }
            i2 = Integer.MAX_VALUE;
            i1 = 0;
            for (; ; ) {
                if (i1 < this.j) {
                    if (this.g[i1] + this.j >= this.c.getCount()) {
                        localObject = this.r.b(i1);
                        int i3 = i2;
                        if (localObject != null) {
                            i3 = ((View) localObject).getRight();
                            if (i3 >= getRightWithPadding()) {
                                break label200;
                            }
                            int i4 = getRightWithPadding() - i3;
                            i3 = i2;
                            if (i4 < i2) {
                                i3 = i4;
                            }
                        }
                        i1 += 1;
                        i2 = i3;
                        continue;
                        label200:
                        i1 = 0;
                    }
                }
            }
        }
        for (; ; ) {
            if (i1 != 0) {
                this.m += i2;
                this.a.a(true);
                break;
                i1 = 0;
                continue;
            }
            label232:
            f();
            i1 = 0;
            while (i1 < this.j) {
                localObject = this.o;
                localObject[i1] += this.m;
                i1 += 1;
            }
            this.m = 0;
            return;
            i1 = 1;
        }
    }

    private void d(int paramInt) {
        this.r.d(paramInt);
        a(paramInt);
        removeAllViewsInLayout();
        invalidate();
    }

    private boolean d() {
        int i1;
        if (this.c == null) {
            i1 = 0;
            if (i1 > 0) {
                break label28;
            }
        }
        label28:
        while (getChildCount() <= 0) {
            return false;
            i1 = this.c.getCount();
            break;
        }
        int i2 = 0;
        label37:
        int i3;
        int i4;
        View localView;
        if (i2 < this.j) {
            i3 = this.g[i2];
            if (i3 < i1) {
                return true;
            }
            i4 = this.f[i2];
            if (i4 >= 0) {
                return true;
            }
            localView = this.r.a(i2);
            if (localView != null) {
                break label96;
            }
        }
        label96:
        do {
            i2 += 1;
            break label37;
            break;
            if ((i4 < 0) && (localView.getLeft() < getPaddingLeft())) {
                return true;
            }
            localView = this.r.b(i2);
        } while ((localView == null) || (i3 < i1) || (localView.getRight() <= getRightWithPadding()));
        return true;
    }

    private void e() {
        int i1 = 0;
        int i2;
        View localView;
        if (i1 < this.j) {
            i2 = this.o[i1];
            localView = this.r.b(i1);
            if (localView == null) {
                break label79;
            }
        }
        label79:
        for (int i3 = localView.getRight(); ; i3 = i2) {
            a(i3, i1);
            localView = this.r.a(i1);
            if (localView != null) {
                i2 = localView.getLeft();
            }
            b(i2, i1);
            i1 += 1;
            break;
            return;
        }
    }

    private void e(int paramInt) {
        if (getChildCount() > 0) {
            int i1 = 0;
            while (i1 < this.j) {
                int i3 = this.o[i1];
                int i4 = this.r.c(i1);
                Rect localRect = this.l[i1];
                int i2 = 0;
                i3 += paramInt;
                while (i2 < i4) {
                    View localView = this.r.b(i1, i2);
                    int i5 = localView.getMeasuredWidth();
                    int i6 = localView.getMeasuredHeight();
                    g localg = (g) localView.getLayoutParams();
                    localRect.set(i3, localRect.top, i3 + i5, localRect.bottom);
                    i3 += i5;
                    Gravity.apply(localg.a, i5, i6, localRect, this.k);
                    localView.layout(this.k.left, this.k.top, this.k.right, this.k.bottom);
                    i2 += 1;
                }
                i1 += 1;
            }
        }
    }

    private void f() {
        int i1 = 0;
        while (i1 < this.j) {
            f(i1);
            i1 += 1;
        }
    }

    private void f(int paramInt) {
        int i2 = this.o[paramInt];
        int i1 = this.f[paramInt];
        int i3 = this.g[paramInt];
        for (View localView = this.r.a(paramInt); (localView != null) && (localView.getRight() <= getPaddingLeft()); localView = this.r.a(paramInt)) {
            i2 += localView.getWidth();
            i1 += this.j;
            i.a(this.d, localView, i1);
            removeViewInLayout(localView);
            this.r.a(paramInt, 0);
        }
        int i4 = getWidthWithoutPaddings();
        for (localView = this.r.b(paramInt); (localView != null) && (localView.getLeft() >= i4); localView = this.r.b(paramInt)) {
            i3 -= this.j;
            i.a(this.d, localView, i3);
            removeViewInLayout(localView);
            this.r.a(paramInt, -1);
        }
        this.o[paramInt] = i2;
        this.f[paramInt] = i1;
        this.g[paramInt] = i3;
    }

    private int getHeightWithoutPaddings() {
        return getHeight() - getPaddingTop() - getPaddingBottom();
    }

    private int getRightWithPadding() {
        return getWidth() - getPaddingRight();
    }

    private int getWidthWithoutPaddings() {
        return getWidth() - getPaddingLeft() - getPaddingRight();
    }

    private void setWasChanged(boolean paramBoolean) {
        this.e = paramBoolean;
        if ((this.q) && (!paramBoolean)) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            this.q = paramBoolean;
            return;
        }
    }

    protected g a() {
        return new g(-2, -2, 17, null);
    }

    public g a(AttributeSet paramAttributeSet) {
        return new g(getContext(), paramAttributeSet, null);
    }

    protected g a(ViewGroup.LayoutParams paramLayoutParams) {
        return new g(paramLayoutParams);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return paramLayoutParams instanceof LinearLayout.LayoutParams;
    }

    protected int computeHorizontalScrollExtent() {
        return 0;
    }

    protected int computeHorizontalScrollOffset() {
        return 0;
    }

    protected int computeHorizontalScrollRange() {
        int i1 = 0;
        if (this.c != null) {
            i1 = Math.max(this.c.getCount() * 1000, 0);
        }
        return i1;
    }

    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
        return super.dispatchTouchEvent(paramMotionEvent) | this.p.onTouchEvent(paramMotionEvent);
    }

    public Adapter getAdapter() {
        return this.c;
    }

    public View getSelectedView() {
        return null;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if ((this.c == null) || (this.c.getCount() == 0)) {
            this.q = false;
            this.a.a(true);
            if (this.s != null) {
                if (this.s.getParent() != this) {
                    b();
                    addViewInLayout(this.s, -1, this.s.getLayoutParams(), true);
                    this.s.measure(View.MeasureSpec.makeMeasureSpec(getWidthWithoutPaddings(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeightWithoutPaddings(), Integer.MIN_VALUE));
                }
                g localg = (g) this.s.getLayoutParams();
                this.t.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
                Gravity.apply(localg.a, this.s.getMeasuredWidth(), this.s.getMeasuredHeight(), this.t, this.k);
                this.s.layout(this.k.left, this.k.top, this.k.right, this.k.bottom);
                return;
            }
            b();
            return;
        }
        if ((this.s != null) && (this.s.getParent() == this)) {
            removeViewInLayout(this.s);
        }
        if (this.a.c()) {
            paramInt1 = this.a.b();
            this.m = (this.n - paramInt1);
            this.n = paramInt1;
        }
        if (this.m > 0) {
        }
        for (this.m = Math.min(getWidthWithoutPaddings() - 1, this.m); ; this.m = Math.max(-getWidthWithoutPaddings() + 1, this.m)) {
            c();
            if (this.a.a()) {
                break;
            }
            post(this.u);
            return;
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        boolean bool = false;
        super.onMeasure(paramInt1, paramInt2);
        if ((this.c == null) || (this.c.getCount() == 0)) {
            if ((this.s != null) && (this.s.getParent() == this)) {
                this.s.measure(View.MeasureSpec.makeMeasureSpec(getWidthWithoutPaddings(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeightWithoutPaddings(), Integer.MIN_VALUE));
            }
            return;
        }
        paramInt1 = this.j;
        paramInt2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
        int i1 = (int) Math.max(paramInt2 / this.h, 1.0F);
        if (paramInt1 != i1) {
            d(i1);
        }
        this.i = (paramInt2 / this.j);
        paramInt2 = getPaddingTop();
        paramInt1 = 0;
        while (paramInt1 < this.j) {
            i1 = this.i + paramInt2;
            this.l[paramInt1].set(0, paramInt2, 0, i1);
            paramInt1 += 1;
            paramInt2 = i1;
        }
        paramInt1 = this.i;
        if (!this.e) {
            bool = true;
        }
        a(paramInt1, bool);
    }

    public void setAdapter(Adapter paramAdapter) {
        if (paramAdapter != this.c) {
            if (this.c != null) {
                this.c.unregisterDataSetObserver(this.b);
            }
            this.c = paramAdapter;
            d(0);
        }
        if (paramAdapter != null) {
            paramAdapter.registerDataSetObserver(this.b);
        }
    }

    public void setSelection(int paramInt) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/studio/comics/view/HorizontalAdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */