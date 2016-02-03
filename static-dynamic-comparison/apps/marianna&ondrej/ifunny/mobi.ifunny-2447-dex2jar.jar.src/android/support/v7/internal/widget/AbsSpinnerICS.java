package android.support.v7.internal.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.SpinnerAdapter;

abstract class AbsSpinnerICS
        extends l<SpinnerAdapter> {
    private DataSetObserver E;
    SpinnerAdapter a;
    int b;
    int c;
    boolean d;
    int e = 0;
    int f = 0;
    int g = 0;
    int h = 0;
    final Rect i = new Rect();
    final d j = new d(this);

    AbsSpinnerICS(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        o();
    }

    private void o() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    int a(View paramView) {
        return paramView.getMeasuredHeight();
    }

    void a() {
        this.u = false;
        this.p = false;
        removeAllViewsInLayout();
        this.B = -1;
        this.C = Long.MIN_VALUE;
        c(-1);
        d(-1);
        invalidate();
    }

    public void a(int paramInt) {
        d(paramInt);
        requestLayout();
        invalidate();
    }

    abstract void a(int paramInt, boolean paramBoolean);

    public void a(SpinnerAdapter paramSpinnerAdapter) {
        int k = -1;
        if (this.a != null) {
            this.a.unregisterDataSetObserver(this.E);
            a();
        }
        this.a = paramSpinnerAdapter;
        this.B = -1;
        this.C = Long.MIN_VALUE;
        if (this.a != null) {
            this.A = this.z;
            this.z = this.a.getCount();
            i();
            this.E = new n(this);
            this.a.registerDataSetObserver(this.E);
            if (this.z > 0) {
                k = 0;
            }
            c(k);
            d(k);
            if (this.z == 0) {
                l();
            }
        }
        for (; ; ) {
            requestLayout();
            return;
            i();
            a();
            l();
        }
    }

    int b(View paramView) {
        return paramView.getMeasuredWidth();
    }

    void b() {
        int m = getChildCount();
        d locald = this.j;
        int n = this.k;
        int k = 0;
        while (k < m) {
            locald.a(n + k, getChildAt(k));
            k += 1;
        }
    }

    public View c() {
        if ((this.z > 0) && (this.x >= 0)) {
            return getChildAt(this.x - this.k);
        }
        return null;
    }

    public SpinnerAdapter d() {
        return this.a;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i2 = View.MeasureSpec.getMode(paramInt1);
        int k = getPaddingLeft();
        int i1 = getPaddingTop();
        int n = getPaddingRight();
        int m = getPaddingBottom();
        Object localObject = this.i;
        if (k > this.e) {
            ((Rect) localObject).left = k;
            localObject = this.i;
            if (i1 <= this.f) {
                break label414;
            }
            k = i1;
            label67:
            ((Rect) localObject).top = k;
            localObject = this.i;
            if (n <= this.g) {
                break label422;
            }
            k = n;
            label91:
            ((Rect) localObject).right = k;
            localObject = this.i;
            if (m <= this.h) {
                break label430;
            }
            k = m;
            label115:
            ((Rect) localObject).bottom = k;
            if (this.u) {
                k();
            }
            k = f();
            if ((k < 0) || (this.a == null) || (k >= this.a.getCount())) {
                break label438;
            }
            View localView = this.j.a(k);
            localObject = localView;
            if (localView == null) {
                localObject = this.a.getView(k, null, this);
            }
            if (localObject != null) {
                this.j.a(k, (View) localObject);
            }
            if (localObject == null) {
                break label438;
            }
            if (((View) localObject).getLayoutParams() == null) {
                this.d = true;
                ((View) localObject).setLayoutParams(generateDefaultLayoutParams());
                this.d = false;
            }
            measureChild((View) localObject, paramInt1, paramInt2);
            m = a((View) localObject) + this.i.top + this.i.bottom;
            k = b((View) localObject) + this.i.left + this.i.right;
            n = 0;
        }
        for (; ; ) {
            i1 = k;
            if (n != 0) {
                n = this.i.top + this.i.bottom;
                i1 = k;
                m = n;
                if (i2 == 0) {
                    i1 = this.i.left + this.i.right;
                    m = n;
                }
            }
            k = Math.max(m, getSuggestedMinimumHeight());
            m = Math.max(i1, getSuggestedMinimumWidth());
            k = resolveSize(k, paramInt2);
            setMeasuredDimension(resolveSize(m, paramInt1), k);
            this.b = paramInt2;
            this.c = paramInt1;
            return;
            k = this.e;
            break;
            label414:
            k = this.f;
            break label67;
            label422:
            k = this.g;
            break label91;
            label430:
            k = this.h;
            break label115;
            label438:
            n = 1;
            k = 0;
            m = 0;
        }
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (AbsSpinnerICS.SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        if (paramParcelable.a >= 0L) {
            this.u = true;
            this.p = true;
            this.n = paramParcelable.a;
            this.m = paramParcelable.b;
            this.q = 0;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        AbsSpinnerICS.SavedState localSavedState = new AbsSpinnerICS.SavedState(super.onSaveInstanceState());
        localSavedState.a = g();
        if (localSavedState.a >= 0L) {
            localSavedState.b = f();
            return localSavedState;
        }
        localSavedState.b = -1;
        return localSavedState;
    }

    public void requestLayout() {
        if (!this.d) {
            super.requestLayout();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/AbsSpinnerICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */