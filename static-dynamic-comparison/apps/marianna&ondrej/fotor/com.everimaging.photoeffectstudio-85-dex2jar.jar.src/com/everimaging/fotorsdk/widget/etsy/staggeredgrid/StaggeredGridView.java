package com.everimaging.fotorsdk.widget.etsy.staggeredgrid;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import com.everimaging.fotorsdk.collage.R.styleable;

import java.util.Arrays;

public class StaggeredGridView
        extends ExtendableListView {
    private int k;
    private int l;
    private int m;
    private boolean n;
    private SparseArray<GridItemRecord> o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int[] t;
    private int[] u;
    private int[] v;
    private int w;

    public StaggeredGridView(Context paramContext) {
        this(paramContext, null);
    }

    public StaggeredGridView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public StaggeredGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if (paramAttributeSet != null) {
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fotorStaggeredGridView, paramInt, 0);
            this.k = paramContext.getInteger(0, 3);
            this.l = paramContext.getDimensionPixelSize(3, 0);
            this.p = paramContext.getDimensionPixelSize(4, 0);
            this.q = paramContext.getDimensionPixelSize(5, 0);
            this.r = paramContext.getDimensionPixelSize(6, 0);
            this.s = paramContext.getDimensionPixelSize(7, 0);
            paramContext.recycle();
        }
        if (this.k <= 0) {
        }
        for (paramInt = i; ; paramInt = this.k) {
            this.k = paramInt;
            this.t = new int[this.k];
            this.u = new int[this.k];
            this.v = new int[this.k];
            this.o = new SparseArray();
            return;
        }
    }

    private int b(int paramInt, boolean paramBoolean) {
        int i = p(paramInt);
        int j = this.k;
        if (i >= 0) {
            paramInt = i;
            if (i < j) {
            }
        } else {
            if (!paramBoolean) {
                break label35;
            }
            paramInt = getHighestPositionedBottomColumn();
        }
        return paramInt;
        label35:
        return getLowestPositionedTopColumnUp();
    }

    private void b(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
        int i1 = p(paramInt1);
        int i2 = i(paramInt1);
        int i3 = j(paramInt1);
        int j = i2 + i3;
        int i;
        if (paramBoolean) {
            i = this.u[i1];
            int i4 = c(paramView);
            paramInt1 = i;
            j = i4 + j + i;
            i = paramInt1;
            paramInt1 = j;
        }
        for (; ; ) {
            ((a) paramView.getLayoutParams()).e = i1;
            d(i1, paramInt1);
            c(i1, i);
            paramView.layout(paramInt2, i + i2, paramInt3, paramInt1 - i3);
            return;
            paramInt1 = this.t[i1];
            i = paramInt1 - (c(paramView) + j);
        }
    }

    private void b(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        if (paramBoolean) {
            paramInt3 = getLowestPositionedBottom();
            paramInt5 = paramInt3 + c(paramView);
        }
        for (; ; ) {
            int i = 0;
            while (i < this.k) {
                c(i, paramInt3);
                d(i, paramInt5);
                i += 1;
            }
            paramInt5 = getHighestPositionedTop();
            paramInt3 = paramInt5 - c(paramView);
        }
        super.a(paramView, paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramInt5);
    }

    private int c(View paramView) {
        return paramView.getMeasuredHeight();
    }

    private void c(int paramInt1, int paramInt2) {
        if (paramInt2 < this.t[paramInt1]) {
            this.t[paramInt1] = paramInt2;
        }
    }

    private void c(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
        int i;
        if (paramBoolean) {
            i = getLowestPositionedBottom();
            paramInt3 = c(paramView) + i;
        }
        for (; ; ) {
            int j = 0;
            while (j < this.k) {
                c(j, i);
                d(j, paramInt3);
                j += 1;
            }
            paramInt3 = getHighestPositionedTop();
            i = paramInt3 - c(paramView);
        }
        super.a(paramView, paramInt1, paramBoolean, paramInt2, i);
    }

    private void d(int paramInt1, int paramInt2) {
        if (paramInt2 > this.u[paramInt1]) {
            this.u[paramInt1] = paramInt2;
        }
    }

    private void d(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
        int i1 = p(paramInt1);
        int i2 = i(paramInt1);
        int j = i2 + j(paramInt1);
        int i;
        if (paramBoolean) {
            i = this.u[i1];
            int i3 = c(paramView);
            paramInt3 = i;
            j = i3 + j + i;
            i = paramInt3;
            paramInt3 = j;
        }
        for (; ; ) {
            ((a) paramView.getLayoutParams()).e = i1;
            d(i1, paramInt3);
            c(i1, i);
            super.a(paramView, paramInt1, paramBoolean, paramInt2, i + i2);
            return;
            paramInt3 = this.t[i1];
            i = paramInt3 - (c(paramView) + j);
        }
    }

    private void e(int paramInt1, int paramInt2) {
        if (paramInt1 != 0) {
            int[] arrayOfInt = this.t;
            arrayOfInt[paramInt2] += paramInt1;
            arrayOfInt = this.u;
            arrayOfInt[paramInt2] += paramInt1;
        }
    }

    private void f(int paramInt1, int paramInt2) {
        o(paramInt1).a = paramInt2;
    }

    private void g(int paramInt1, int paramInt2) {
        o(paramInt1).b = (paramInt2 / this.m);
    }

    private int[] getHighestNonHeaderTops() {
        int[] arrayOfInt = new int[this.k];
        int j = getChildCount();
        if (j > 0) {
            int i = 0;
            while (i < j) {
                View localView = getChildAt(i);
                if ((localView != null) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof a))) {
                    a locala = (a) localView.getLayoutParams();
                    if ((locala.d != -2) && (localView.getTop() < arrayOfInt[locala.e])) {
                        arrayOfInt[locala.e] = localView.getTop();
                    }
                }
                i += 1;
            }
        }
        return arrayOfInt;
    }

    private int getHighestPositionedBottom() {
        int i = getHighestPositionedBottomColumn();
        return this.u[i];
    }

    private int getHighestPositionedBottomColumn() {
        int i = 0;
        int j = Integer.MAX_VALUE;
        int i1 = 0;
        while (i < this.k) {
            int i3 = this.u[i];
            int i2 = j;
            if (i3 < j) {
                i2 = i3;
                i1 = i;
            }
            i += 1;
            j = i2;
        }
        return i1;
    }

    private int getHighestPositionedTop() {
        int i = getHighestPositionedTopColumn();
        return this.t[i];
    }

    private int getHighestPositionedTopColumn() {
        int i = 0;
        int j = Integer.MAX_VALUE;
        int i1 = 0;
        while (i < this.k) {
            int i3 = this.t[i];
            int i2 = j;
            if (i3 < j) {
                i2 = i3;
                i1 = i;
            }
            i += 1;
            j = i2;
        }
        return i1;
    }

    private int getLowestPositionedBottom() {
        int i = getLowestPositionedBottomColumn();
        return this.u[i];
    }

    private int getLowestPositionedBottomColumn() {
        int i = 0;
        int j = Integer.MIN_VALUE;
        int i1 = 0;
        while (i < this.k) {
            int i3 = this.u[i];
            int i2 = j;
            if (i3 > j) {
                i2 = i3;
                i1 = i;
            }
            i += 1;
            j = i2;
        }
        return i1;
    }

    private int getLowestPositionedTop() {
        int i = getLowestPositionedTopColumn();
        return this.t[i];
    }

    private int getLowestPositionedTopColumn() {
        int i = 0;
        int j = Integer.MIN_VALUE;
        int i1 = 0;
        while (i < this.k) {
            int i3 = this.t[i];
            int i2 = j;
            if (i3 > j) {
                i2 = i3;
                i1 = i;
            }
            i += 1;
            j = i2;
        }
        return i1;
    }

    private int getLowestPositionedTopColumnUp() {
        int j = 0;
        int i1 = Integer.MIN_VALUE;
        int i = this.k - 1;
        int i2;
        if (i >= 0) {
            i2 = this.t[i];
            if (i2 <= i1) {
                break label52;
            }
            i1 = i;
            j = i2;
        }
        for (; ; ) {
            i -= 1;
            i2 = i1;
            i1 = j;
            j = i2;
            break;
            return j;
            label52:
            i2 = j;
            j = i1;
            i1 = i2;
        }
    }

    private int getLowestPositionedTopUp() {
        int i = getLowestPositionedTopColumnUp();
        return this.t[i];
    }

    private int i(int paramInt) {
        int i = 0;
        if (paramInt < getHeaderViewsCount() + this.k) {
        }
        for (paramInt = 1; ; paramInt = 0) {
            if (paramInt != 0) {
                i = this.r;
            }
            return i;
        }
    }

    private int j(int paramInt) {
        int i = 1;
        if (getFooterViewsCount() > 0) {
            if (paramInt >= getCount() + getHeaderViewsCount()) {
            }
            for (paramInt = i; paramInt != 0; paramInt = 0) {
                return this.s;
            }
            return this.l;
        }
        int j = getCount() % this.k;
        i = j;
        if (j == 0) {
            i = this.k;
        }
        if (paramInt >= getHeaderViewsCount() + getCount() - i) {
        }
        for (paramInt = 1; paramInt != 0; paramInt = 0) {
            return this.s;
        }
        return this.l;
    }

    private void k() {
        if (!this.n) {
            Arrays.fill(this.u, 0);
        }
        for (; ; ) {
            System.arraycopy(this.t, 0, this.u, 0, this.k);
            return;
            this.n = false;
        }
    }

    private void k(int paramInt) {
        this.w += paramInt;
    }

    private void l() {
        int i4 = 0;
        int[] arrayOfInt;
        int i1;
        int j;
        int i;
        if (this.b == getHeaderViewsCount()) {
            arrayOfInt = getHighestNonHeaderTops();
            int i3 = 1;
            i1 = -1;
            j = Integer.MAX_VALUE;
            i = 0;
            while (i < arrayOfInt.length) {
                int i2 = i3;
                if (i3 != 0) {
                    i2 = i3;
                    if (i > 0) {
                        i2 = i3;
                        if (arrayOfInt[i] != j) {
                            i2 = 0;
                        }
                    }
                }
                i3 = j;
                if (arrayOfInt[i] < j) {
                    i3 = arrayOfInt[i];
                    i1 = i;
                }
                i += 1;
                j = i3;
                i3 = i2;
            }
            i = i4;
            if (i3 == 0) {
            }
        } else {
            return;
        }
        while (i < arrayOfInt.length) {
            if (i != i1) {
                b(j - arrayOfInt[i], i);
            }
            i += 1;
        }
        invalidate();
    }

    private void l(int paramInt) {
        if (paramInt != 0) {
            int i = 0;
            while (i < this.k) {
                e(paramInt, i);
                i += 1;
            }
        }
    }

    private int m(int paramInt) {
        return (paramInt - (getRowPaddingLeft() + getRowPaddingRight()) - this.l * (this.k - 1)) / this.k;
    }

    private void m() {
        int i1 = Math.min(this.f, getCount() - 1);
        SparseArray localSparseArray = new SparseArray(i1);
        int i = 0;
        Object localObject;
        if (i < i1) {
            localObject = (GridItemRecord) this.o.get(i);
            if (localObject != null) {
            }
        } else {
            this.o.clear();
            i = 0;
        }
        for (; ; ) {
            if (i < i1) {
                localObject = (Double) localSparseArray.get(i);
                if (localObject != null) {
                }
            } else {
                i = getHighestPositionedBottomColumn();
                f(i1, i);
                i = this.u[i];
                l(-i + this.g);
                this.w = (-i);
                System.arraycopy(this.u, 0, this.t, 0, this.k);
                return;
                Log.d("StaggeredGridView", "onColumnSync:" + i + " ratio:" + ((GridItemRecord) localObject).b);
                localSparseArray.append(i, Double.valueOf(((GridItemRecord) localObject).b));
                i += 1;
                break;
            }
            GridItemRecord localGridItemRecord = o(i);
            int i2 = (int) (this.m * ((Double) localObject).doubleValue());
            localGridItemRecord.b = ((Double) localObject).doubleValue();
            if (q(i)) {
                i3 = getLowestPositionedBottom();
                j = 0;
                while (j < this.k) {
                    this.t[j] = i3;
                    this.u[j] = (i2 + i3);
                    j += 1;
                }
            }
            int j = getHighestPositionedBottomColumn();
            int i3 = this.u[j];
            int i4 = i(i);
            int i5 = j(i);
            this.t[j] = i3;
            this.u[j] = (i2 + i3 + i4 + i5);
            localGridItemRecord.a = j;
            i += 1;
        }
    }

    private int n(int paramInt) {
        return getRowPaddingLeft() + (this.l + this.m) * paramInt;
    }

    private void n() {
        o();
        p();
    }

    private GridItemRecord o(int paramInt) {
        GridItemRecord localGridItemRecord2 = (GridItemRecord) this.o.get(paramInt, null);
        GridItemRecord localGridItemRecord1 = localGridItemRecord2;
        if (localGridItemRecord2 == null) {
            localGridItemRecord1 = new GridItemRecord();
            this.o.append(paramInt, localGridItemRecord1);
        }
        return localGridItemRecord1;
    }

    private void o() {
        Arrays.fill(this.t, getPaddingTop() + this.r);
    }

    private int p(int paramInt) {
        GridItemRecord localGridItemRecord = (GridItemRecord) this.o.get(paramInt, null);
        if (localGridItemRecord != null) {
            return localGridItemRecord.a;
        }
        return -1;
    }

    private void p() {
        Arrays.fill(this.u, getPaddingTop() + this.r);
    }

    private void q() {
        int i = 0;
        while (i < this.k) {
            this.v[i] = n(i);
            i += 1;
        }
    }

    private boolean q(int paramInt) {
        return this.a.getItemViewType(paramInt) == -2;
    }

    private void setPositionIsHeaderFooter(int paramInt) {
        o(paramInt).c = true;
    }

    protected ExtendableListView.f a(View paramView) {
        paramView = paramView.getLayoutParams();
        if (paramView != null) {
            if ((paramView instanceof a)) {
                paramView = (a) paramView;
            }
        }
        for (; ; ) {
            Object localObject = paramView;
            if (paramView == null) {
                localObject = new a(this.m, -2);
            }
            return (ExtendableListView.f) localObject;
            paramView = new a(paramView);
            continue;
            paramView = null;
        }
    }

    public void a() {
        if (this.k > 0) {
            if (this.t == null) {
                this.t = new int[this.k];
            }
            if (this.u == null) {
                this.u = new int[this.k];
            }
            n();
            this.o.clear();
            this.n = false;
            this.w = 0;
            setSelection(0);
        }
    }

    protected void a(int paramInt1, int paramInt2) {
        super.a(paramInt1, paramInt2);
        Arrays.fill(this.t, Integer.MAX_VALUE);
        Arrays.fill(this.u, 0);
        paramInt1 = 0;
        if (paramInt1 < getChildCount()) {
            View localView = getChildAt(paramInt1);
            int i;
            int j;
            if (localView != null) {
                Object localObject = (ExtendableListView.f) localView.getLayoutParams();
                if ((((ExtendableListView.f) localObject).d == -2) || (!(localObject instanceof a))) {
                    break label163;
                }
                localObject = (a) localObject;
                paramInt2 = ((a) localObject).e;
                i = ((a) localObject).b;
                j = localView.getTop();
                if (j < this.t[paramInt2]) {
                    this.t[paramInt2] = (j - i(i));
                }
                j = localView.getBottom();
                if (j > this.u[paramInt2]) {
                    this.u[paramInt2] = (j(i) + j);
                }
            }
            for (; ; ) {
                paramInt1 += 1;
                break;
                label163:
                i = localView.getTop();
                j = localView.getBottom();
                paramInt2 = 0;
                while (paramInt2 < this.k) {
                    if (i < this.t[paramInt2]) {
                        this.t[paramInt2] = i;
                    }
                    if (j > this.u[paramInt2]) {
                        this.u[paramInt2] = j;
                    }
                    paramInt2 += 1;
                }
            }
        }
    }

    protected void a(int paramInt, boolean paramBoolean) {
        super.a(paramInt, paramBoolean);
        if (!q(paramInt)) {
            f(paramInt, b(paramInt, paramBoolean));
            return;
        }
        setPositionIsHeaderFooter(paramInt);
    }

    protected void a(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3) {
        if (q(paramInt1)) {
            c(paramView, paramInt1, paramBoolean, paramInt2, paramInt3);
            return;
        }
        d(paramView, paramInt1, paramBoolean, paramInt2, paramInt3);
    }

    protected void a(View paramView, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        if (q(paramInt1)) {
            b(paramView, paramInt1, paramBoolean, paramInt2, paramInt3, paramInt4, paramInt5);
            return;
        }
        b(paramView, paramInt1, paramBoolean, paramInt2, paramInt4);
    }

    protected void a(View paramView, ExtendableListView.f paramf) {
        int i = paramf.d;
        int j = paramf.b;
        if ((i == -2) || (i == -1)) {
            super.a(paramView, paramf);
            g(j, c(paramView));
            return;
        }
        int i1 = View.MeasureSpec.makeMeasureSpec(this.m, 1073741824);
        if (paramf.height > 0) {
        }
        for (i = View.MeasureSpec.makeMeasureSpec(paramf.height, 1073741824); ; i = View.MeasureSpec.makeMeasureSpec(-2, 0)) {
            paramView.measure(i1, i);
            break;
        }
    }

    protected int b(int paramInt) {
        if (q(paramInt)) {
            return super.b(paramInt);
        }
        paramInt = p(paramInt);
        return this.v[paramInt];
    }

    protected void b(int paramInt1, int paramInt2) {
        int j = getChildCount();
        int i = 0;
        while (i < j) {
            View localView = getChildAt(i);
            if ((localView != null) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof a)) && (((a) localView.getLayoutParams()).e == paramInt2)) {
                localView.offsetTopAndBottom(paramInt1);
            }
            i += 1;
        }
        e(paramInt1, paramInt2);
    }

    protected void b(boolean paramBoolean) {
        super.b(paramBoolean);
        if (!paramBoolean) {
            l();
        }
    }

    protected int c(int paramInt) {
        if (q(paramInt)) {
            return super.c(paramInt);
        }
        paramInt = p(paramInt);
        if (paramInt == -1) {
            return getHighestPositionedBottom();
        }
        return this.u[paramInt];
    }

    protected boolean c() {
        boolean bool = false;
        if (this.d) {
        }
        for (int i = getRowPaddingTop(); ; i = 0) {
            if (getLowestPositionedTopUp() > i) {
                bool = true;
            }
            return bool;
        }
    }

    protected int d(int paramInt) {
        if (q(paramInt)) {
            return super.d(paramInt);
        }
        paramInt = p(paramInt);
        if (paramInt == -1) {
            return getLowestPositionedTop();
        }
        return this.t[paramInt];
    }

    protected int e(int paramInt) {
        if (q(paramInt)) {
            return super.e(paramInt);
        }
        return getHighestPositionedBottom();
    }

    protected int f(int paramInt) {
        if (q(paramInt)) {
            return super.f(paramInt);
        }
        return getLowestPositionedTopUp();
    }

    protected void g(int paramInt) {
        super.g(paramInt);
        l(paramInt);
        k(paramInt);
    }

    public int getColumnCount() {
        return this.k;
    }

    public int getColumnWidth() {
        return this.m;
    }

    public int getDistanceToTop() {
        return this.w;
    }

    protected int getFirstChildTop() {
        if (q(this.b)) {
            return super.getFirstChildTop();
        }
        return getLowestPositionedTop();
    }

    protected int getHighestChildTop() {
        if (q(this.b)) {
            return super.getHighestChildTop();
        }
        return getHighestPositionedTop();
    }

    public int getItemMargin() {
        return this.l;
    }

    protected int getLastChildBottom() {
        if (q(this.b + (getChildCount() - 1))) {
            return super.getLastChildBottom();
        }
        return getHighestPositionedBottom();
    }

    protected int getLowestChildBottom() {
        if (q(this.b + (getChildCount() - 1))) {
            return super.getLowestChildBottom();
        }
        return getLowestPositionedBottom();
    }

    public int getRowPaddingBottom() {
        return getListPaddingBottom() + this.s;
    }

    public int getRowPaddingLeft() {
        return getListPaddingLeft() + this.p;
    }

    public int getRowPaddingRight() {
        return getListPaddingRight() + this.q;
    }

    public int getRowPaddingTop() {
        return getListPaddingTop() + this.r;
    }

    protected void layoutChildren() {
        k();
        super.layoutChildren();
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        super.onMeasure(paramInt1, paramInt2);
        this.m = m(getMeasuredWidth());
        if ((this.t == null) || (this.t.length != this.k)) {
            this.t = new int[this.k];
            this.o.clear();
            o();
        }
        if ((this.u == null) || (this.u.length != this.k)) {
            this.u = new int[this.k];
            this.o.clear();
            p();
        }
        if ((this.v == null) || (this.v.length != this.k)) {
            this.v = new int[this.k];
            this.o.clear();
            q();
        }
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (GridListSavedState) paramParcelable;
        if (this.k == paramParcelable.g) {
            this.k = paramParcelable.g;
            this.t = paramParcelable.h;
            this.u = new int[this.k];
        }
        this.n = true;
        super.onRestoreInstanceState(paramParcelable);
    }

    public Parcelable onSaveInstanceState() {
        i();
        ExtendableListView.ListSavedState localListSavedState = (ExtendableListView.ListSavedState) super.onSaveInstanceState();
        GridListSavedState localGridListSavedState = new GridListSavedState(localListSavedState.a());
        localGridListSavedState.b = localListSavedState.b;
        localGridListSavedState.c = localListSavedState.c;
        localGridListSavedState.d = localListSavedState.d;
        localGridListSavedState.e = localListSavedState.e;
        localGridListSavedState.f = localListSavedState.f;
        if ((getChildCount() > 0) && (getCount() > 0)) {
        }
        for (int i = 1; (i != 0) && (this.b > 0); i = 0) {
            localGridListSavedState.g = this.k;
            localGridListSavedState.h = Arrays.copyOf(this.t, this.t.length);
            return localGridListSavedState;
        }
        if (this.k >= 0) {
        }
        for (i = this.k; ; i = 0) {
            localGridListSavedState.g = i;
            localGridListSavedState.h = new int[localGridListSavedState.g];
            return localGridListSavedState;
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if ((paramInt3 != paramInt1) || (paramInt4 != paramInt2) || (this.t == null) || (this.t.length != this.k) || (this.u == null) || (this.u.length != this.k) || (this.v == null) || (this.v.length != this.k)) {
            this.m = m(paramInt1);
            this.t = new int[this.k];
            this.u = new int[this.k];
            this.v = new int[this.k];
            this.w = 0;
            n();
            q();
            if ((getCount() > 0) && (this.o.size() > 0)) {
                m();
            }
            requestLayout();
        }
    }

    public void setColumnCount(int paramInt) {
        if ((paramInt > 0) && (paramInt != this.k)) {
            this.k = paramInt;
            forceLayout();
        }
    }

    public void setFirstVisiblePosition(int paramInt) {
        if (paramInt < getHeaderViewsCount()) {
            setFirstPosition(paramInt);
            return;
        }
        setFirstPosition(paramInt - paramInt % this.k + getHeaderViewsCount());
    }

    static class GridItemRecord
            implements Parcelable {
        public static final Parcelable.Creator<GridItemRecord> CREATOR = new Parcelable.Creator() {
            public StaggeredGridView.GridItemRecord a(Parcel paramAnonymousParcel) {
                return new StaggeredGridView.GridItemRecord(paramAnonymousParcel, null);
            }

            public StaggeredGridView.GridItemRecord[] a(int paramAnonymousInt) {
                return new StaggeredGridView.GridItemRecord[paramAnonymousInt];
            }
        };
        int a;
        double b;
        boolean c;

        GridItemRecord() {
        }

        private GridItemRecord(Parcel paramParcel) {
            this.a = paramParcel.readInt();
            this.b = paramParcel.readDouble();
            if (paramParcel.readByte() == 1) {
            }
            for (; ; ) {
                this.c = bool;
                return;
                bool = false;
            }
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "GridItemRecord.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " column:" + this.a + " heightRatio:" + this.b + " isHeaderFooter:" + this.c + "}";
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            paramParcel.writeInt(this.a);
            paramParcel.writeDouble(this.b);
            if (this.c) {
            }
            for (paramInt = 1; ; paramInt = 0) {
                paramParcel.writeByte((byte) paramInt);
                return;
            }
        }
    }

    public static class GridListSavedState
            extends ExtendableListView.ListSavedState {
        public static final Parcelable.Creator<GridListSavedState> CREATOR = new Parcelable.Creator() {
            public StaggeredGridView.GridListSavedState a(Parcel paramAnonymousParcel) {
                return new StaggeredGridView.GridListSavedState(paramAnonymousParcel);
            }

            public StaggeredGridView.GridListSavedState[] a(int paramAnonymousInt) {
                return new StaggeredGridView.GridListSavedState[paramAnonymousInt];
            }
        };
        int g;
        int[] h;

        public GridListSavedState(Parcel paramParcel) {
            super();
            this.g = paramParcel.readInt();
            if (this.g >= 0) {
            }
            for (int i = this.g; ; i = 0) {
                this.h = new int[i];
                paramParcel.readIntArray(this.h);
                return;
            }
        }

        public GridListSavedState(Parcelable paramParcelable) {
            super();
        }

        public String toString() {
            return "StaggeredGridView.GridListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + "}";
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeInt(this.g);
            paramParcel.writeIntArray(this.h);
        }
    }

    public static class a
            extends ExtendableListView.f {
        int e;

        public a(int paramInt1, int paramInt2) {
            super(paramInt2);
            a();
        }

        public a(ViewGroup.LayoutParams paramLayoutParams) {
            super();
            a();
        }

        private void a() {
            if (this.width != -1) {
                this.width = -1;
            }
            if (this.height == -1) {
                this.height = -2;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/etsy/staggeredgrid/StaggeredGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */