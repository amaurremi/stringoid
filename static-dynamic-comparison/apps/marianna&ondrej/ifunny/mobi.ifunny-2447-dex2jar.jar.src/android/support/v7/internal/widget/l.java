package android.support.v7.internal.widget;

import android.content.Context;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

abstract class l<T extends Adapter>
        extends ViewGroup {
    int A;
    int B = -1;
    long C = Long.MIN_VALUE;
    boolean D = false;
    private int a;
    private View b;
    private boolean c;
    private boolean d;
    private l<T>.r e;
    @ViewDebug.ExportedProperty(category = "scrolling")
    int k = 0;
    int l;
    int m;
    long n = Long.MIN_VALUE;
    long o;
    boolean p = false;
    int q;
    boolean r = false;
    q s;
    o t;
    boolean u;
    @ViewDebug.ExportedProperty(category = "list")
    int v = -1;
    long w = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")
    int x = -1;
    long y = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")
    int z;

    l(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    private void a() {
        if (this.s == null) {
            return;
        }
        int i = f();
        if (i >= 0) {
            View localView = c();
            this.s.a(this, localView, i, e().getItemId(i));
            return;
        }
        this.s.a(this);
    }

    private void a(boolean paramBoolean) {
        if (h()) {
            paramBoolean = false;
        }
        if (paramBoolean) {
            if (this.b != null) {
                this.b.setVisibility(0);
                setVisibility(8);
            }
            for (; ; ) {
                if (this.u) {
                    onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                }
                return;
                setVisibility(0);
            }
        }
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        setVisibility(0);
    }

    public void a(o paramo) {
        this.t = paramo;
    }

    public void a(q paramq) {
        this.s = paramq;
    }

    public boolean a(View paramView, int paramInt, long paramLong) {
        boolean bool = false;
        if (this.t != null) {
            playSoundEffect(0);
            if (paramView != null) {
                paramView.sendAccessibilityEvent(1);
            }
            this.t.a(this, paramView, paramInt, paramLong);
            bool = true;
        }
        return bool;
    }

    public void addView(View paramView) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View paramView, int paramInt) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    int b(int paramInt, boolean paramBoolean) {
        return paramInt;
    }

    public long b(int paramInt) {
        Adapter localAdapter = e();
        if ((localAdapter == null) || (paramInt < 0)) {
            return Long.MIN_VALUE;
        }
        return localAdapter.getItemId(paramInt);
    }

    public abstract View c();

    void c(int paramInt) {
        this.x = paramInt;
        this.y = b(paramInt);
    }

    protected boolean canAnimate() {
        return (super.canAnimate()) && (this.z > 0);
    }

    void d(int paramInt) {
        this.v = paramInt;
        this.w = b(paramInt);
        if ((this.p) && (this.q == 0) && (paramInt >= 0)) {
            this.m = paramInt;
            this.n = this.w;
        }
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        View localView = c();
        return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
        dispatchThawSelfOnly(paramSparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
        dispatchFreezeSelfOnly(paramSparseArray);
    }

    public abstract T e();

    @ViewDebug.CapturedViewProperty
    public int f() {
        return this.v;
    }

    @ViewDebug.CapturedViewProperty
    public long g() {
        return this.w;
    }

    boolean h() {
        return false;
    }

    void i() {
        boolean bool2 = false;
        Adapter localAdapter = e();
        int i;
        if ((localAdapter == null) || (localAdapter.getCount() == 0)) {
            i = 1;
            if ((i != 0) && (!h())) {
                break label111;
            }
            i = 1;
            label38:
            if ((i == 0) || (!this.d)) {
                break label116;
            }
            bool1 = true;
            label51:
            super.setFocusableInTouchMode(bool1);
            if ((i == 0) || (!this.c)) {
                break label121;
            }
        }
        label111:
        label116:
        label121:
        for (boolean bool1 = true; ; bool1 = false) {
            super.setFocusable(bool1);
            if (this.b != null) {
                if (localAdapter != null) {
                    bool1 = bool2;
                    if (!localAdapter.isEmpty()) {
                    }
                } else {
                    bool1 = true;
                }
                a(bool1);
            }
            return;
            i = 0;
            break;
            i = 0;
            break label38;
            bool1 = false;
            break label51;
        }
    }

    void j() {
        if (this.s != null) {
            if ((!this.r) && (!this.D)) {
                break label78;
            }
            if (this.e == null) {
                this.e = new r(this, null);
            }
            post(this.e);
        }
        for (; ; ) {
            if ((this.x != -1) && (isShown()) && (!isInTouchMode())) {
                sendAccessibilityEvent(4);
            }
            return;
            label78:
            a();
        }
    }

    void k() {
        int i2 = this.z;
        int i;
        if (i2 > 0) {
            if (this.p) {
                this.p = false;
                i = m();
                if ((i >= 0) && (b(i, true) == i)) {
                    d(i);
                    i = 1;
                    if (i == 0) {
                        int i1 = f();
                        int j = i1;
                        if (i1 >= i2) {
                            j = i2 - 1;
                        }
                        i1 = j;
                        if (j < 0) {
                            i1 = 0;
                        }
                        j = b(i1, true);
                        if (j >= 0) {
                            break label153;
                        }
                        j = b(i1, false);
                        label97:
                        if (j >= 0) {
                            d(j);
                            l();
                            i = 1;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            if (i == 0) {
                this.x = -1;
                this.y = Long.MIN_VALUE;
                this.v = -1;
                this.w = Long.MIN_VALUE;
                this.p = false;
                l();
            }
            return;
            continue;
            label153:
            break label97;
            i = 0;
            break;
            i = 0;
        }
    }

    void l() {
        if ((this.x != this.B) || (this.y != this.C)) {
            j();
            this.B = this.x;
            this.C = this.y;
        }
    }

    int m() {
        int i5 = this.z;
        int i3;
        if (i5 == 0) {
            i3 = -1;
            return i3;
        }
        long l1 = this.n;
        int i = this.m;
        if (l1 == Long.MIN_VALUE) {
            return -1;
        }
        i = Math.min(i5 - 1, Math.max(0, i));
        long l2 = SystemClock.uptimeMillis();
        int j = 0;
        Adapter localAdapter = e();
        label72:
        int i4;
        int i1;
        if (localAdapter == null) {
            return -1;
            if ((i4 != 0) || ((j != 0) && (i3 == 0))) {
                i1 += 1;
                j = 0;
                i = i1;
            }
        }
        for (; ; ) {
            int i2;
            if (SystemClock.uptimeMillis() <= l2 + 100L) {
                i3 = i;
                if (localAdapter.getItemId(i) == l1) {
                    break;
                }
                if (i1 != i5 - 1) {
                    break label155;
                }
                i3 = 1;
                if (i2 != 0) {
                    break label161;
                }
            }
            label155:
            label161:
            for (i4 = 1; ; i4 = 0) {
                if ((i3 == 0) || (i4 == 0)) {
                    break label165;
                }
                return -1;
                i3 = 0;
                break;
            }
            label165:
            break label72;
            if ((i3 != 0) || ((j == 0) && (i4 == 0))) {
                i2 -= 1;
                j = 1;
                i = i2;
                continue;
                i2 = i;
                i3 = i;
                i1 = i;
                i = i3;
            }
        }
    }

    void n() {
        if (getChildCount() > 0) {
            this.p = true;
            this.o = this.a;
            if (this.x >= 0) {
                localView = getChildAt(this.x - this.k);
                this.n = this.w;
                this.m = this.v;
                if (localView != null) {
                    this.l = localView.getTop();
                }
                this.q = 0;
            }
        } else {
            return;
        }
        View localView = getChildAt(0);
        Adapter localAdapter = e();
        if ((this.k >= 0) && (this.k < localAdapter.getCount())) {
        }
        for (this.n = localAdapter.getItemId(this.k); ; this.n = -1L) {
            this.m = this.k;
            if (localView != null) {
                this.l = localView.getTop();
            }
            this.q = 1;
            return;
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.a = getHeight();
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View paramView) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int paramInt) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    public void setFocusable(boolean paramBoolean) {
        boolean bool = true;
        Adapter localAdapter = e();
        int i;
        if ((localAdapter == null) || (localAdapter.getCount() == 0)) {
            i = 1;
            this.c = paramBoolean;
            if (!paramBoolean) {
                this.d = false;
            }
            if (!paramBoolean) {
                break label69;
            }
            paramBoolean = bool;
            if (i != 0) {
                if (!h()) {
                    break label69;
                }
            }
        }
        label69:
        for (paramBoolean = bool; ; paramBoolean = false) {
            super.setFocusable(paramBoolean);
            return;
            i = 0;
            break;
        }
    }

    public void setFocusableInTouchMode(boolean paramBoolean) {
        boolean bool = true;
        Adapter localAdapter = e();
        int i;
        if ((localAdapter == null) || (localAdapter.getCount() == 0)) {
            i = 1;
            this.d = paramBoolean;
            if (paramBoolean) {
                this.c = true;
            }
            if (!paramBoolean) {
                break label69;
            }
            paramBoolean = bool;
            if (i != 0) {
                if (!h()) {
                    break label69;
                }
            }
        }
        label69:
        for (paramBoolean = bool; ; paramBoolean = false) {
            super.setFocusableInTouchMode(paramBoolean);
            return;
            i = 0;
            break;
        }
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v7/internal/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */