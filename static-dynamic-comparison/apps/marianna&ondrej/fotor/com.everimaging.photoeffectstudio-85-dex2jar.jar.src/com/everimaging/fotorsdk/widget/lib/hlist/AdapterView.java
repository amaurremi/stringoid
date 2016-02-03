package com.everimaging.fotorsdk.widget.lib.hlist;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;

public abstract class AdapterView<T extends Adapter>
        extends ViewGroup {
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int V = 0;
    protected int W;
    protected int Z;
    private int a;
    protected long aa = Long.MIN_VALUE;
    protected long ab;
    protected boolean ac = false;
    int ad;
    protected boolean ae = false;
    e af;
    c ag;
    d ah;
    public boolean ai;
    @ViewDebug.ExportedProperty(category = "list")
    protected int aj = -1;
    protected long ak = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")
    protected int al = -1;
    protected long am = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")
    protected int an;
    protected int ao;
    AccessibilityManager ap;
    protected int aq = -1;
    protected long ar = Long.MIN_VALUE;
    protected boolean as = false;
    private View b;
    private boolean c;
    private boolean d;
    private AdapterView<T>.f e;

    public AdapterView(Context paramContext) {
        super(paramContext);
    }

    public AdapterView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    public AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        if ((Build.VERSION.SDK_INT >= 16) && (getImportantForAccessibility() == 0)) {
            setImportantForAccessibility(1);
        }
        this.ap = ((AccessibilityManager) getContext().getSystemService("accessibility"));
    }

    private void a() {
        if (this.af == null) {
            return;
        }
        int i = getSelectedItemPosition();
        if (i >= 0) {
            View localView = getSelectedView();
            this.af.a(this, localView, i, getAdapter().getItemId(i));
            return;
        }
        this.af.a(this);
    }

    @SuppressLint({"WrongCall"})
    private void a(boolean paramBoolean) {
        if (s()) {
            paramBoolean = false;
        }
        if (paramBoolean) {
            if (this.b != null) {
                this.b.setVisibility(0);
                setVisibility(8);
            }
            for (; ; ) {
                if (this.ai) {
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

    private void b() {
        if (!this.ap.isEnabled()) {
        }
        while (getSelectedItemPosition() < 0) {
            return;
        }
        sendAccessibilityEvent(4);
    }

    private boolean c() {
        boolean bool2 = false;
        Adapter localAdapter = getAdapter();
        boolean bool1 = bool2;
        if (localAdapter != null) {
            int i = localAdapter.getCount();
            bool1 = bool2;
            if (i > 0) {
                if (getFirstVisiblePosition() <= 0) {
                    bool1 = bool2;
                    if (getLastVisiblePosition() >= i - 1) {
                    }
                } else {
                    bool1 = true;
                }
            }
        }
        return bool1;
    }

    public int a(View paramView) {
        try {
            for (; ; ) {
                View localView = (View) paramView.getParent();
                boolean bool = localView.equals(this);
                if (bool) {
                    break;
                }
                paramView = localView;
            }
            j = getChildCount();
        } catch (ClassCastException paramView) {
            return -1;
        }
        int j;
        int i = 0;
        while (i < j) {
            if (getChildAt(i).equals(paramView)) {
                return i + this.V;
            }
            i += 1;
        }
        return -1;
    }

    public boolean a(View paramView, int paramInt, long paramLong) {
        boolean bool = false;
        if (this.ag != null) {
            playSoundEffect(0);
            if (paramView != null) {
                paramView.sendAccessibilityEvent(1);
            }
            this.ag.a(this, paramView, paramInt, paramLong);
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

    protected int b(int paramInt, boolean paramBoolean) {
        return paramInt;
    }

    protected boolean canAnimate() {
        return (super.canAnimate()) && (this.an > 0);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        View localView = getSelectedView();
        return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
        dispatchThawSelfOnly(paramSparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
        dispatchFreezeSelfOnly(paramSparseArray);
    }

    public long g(int paramInt) {
        Adapter localAdapter = getAdapter();
        if ((localAdapter == null) || (paramInt < 0)) {
            return Long.MIN_VALUE;
        }
        return localAdapter.getItemId(paramInt);
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.an;
    }

    public View getEmptyView() {
        return this.b;
    }

    public int getFirstVisiblePosition() {
        return this.V;
    }

    public int getLastVisiblePosition() {
        return this.V + getChildCount() - 1;
    }

    public final c getOnItemClickListener() {
        return this.ag;
    }

    public final d getOnItemLongClickListener() {
        return this.ah;
    }

    public final e getOnItemSelectedListener() {
        return this.af;
    }

    public Object getSelectedItem() {
        Adapter localAdapter = getAdapter();
        int i = getSelectedItemPosition();
        if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
            return localAdapter.getItem(i);
        }
        return null;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.ak;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.aj;
    }

    public abstract View getSelectedView();

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
        paramAccessibilityEvent.setClassName(AdapterView.class.getName());
        paramAccessibilityEvent.setScrollable(c());
        View localView = getSelectedView();
        if (localView != null) {
            paramAccessibilityEvent.setEnabled(localView.isEnabled());
        }
        paramAccessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        paramAccessibilityEvent.setFromIndex(getFirstVisiblePosition());
        paramAccessibilityEvent.setToIndex(getLastVisiblePosition());
        paramAccessibilityEvent.setItemCount(getCount());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setClassName(AdapterView.class.getName());
        paramAccessibilityNodeInfo.setScrollable(c());
        View localView = getSelectedView();
        if (localView != null) {
            paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.a = getWidth();
    }

    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
        if (super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent)) {
            AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
            onInitializeAccessibilityEvent(localAccessibilityEvent);
            paramView.dispatchPopulateAccessibilityEvent(localAccessibilityEvent);
            paramAccessibilityEvent.appendRecord(localAccessibilityEvent);
            return true;
        }
        return false;
    }

    void r() {
        int m = this.an;
        int i;
        if (m > 0) {
            if (this.ac) {
                this.ac = false;
                i = w();
                if ((i >= 0) && (b(i, true) == i)) {
                    setNextSelectedPositionInt(i);
                    i = 1;
                    if (i == 0) {
                        int k = getSelectedItemPosition();
                        int j = k;
                        if (k >= m) {
                            j = m - 1;
                        }
                        k = j;
                        if (j < 0) {
                            k = 0;
                        }
                        j = b(k, true);
                        if (j >= 0) {
                            break label153;
                        }
                        j = b(k, false);
                        label97:
                        if (j >= 0) {
                            setNextSelectedPositionInt(j);
                            v();
                            i = 1;
                        }
                    }
                }
            }
        }
        for (; ; ) {
            if (i == 0) {
                this.al = -1;
                this.am = Long.MIN_VALUE;
                this.aj = -1;
                this.ak = Long.MIN_VALUE;
                this.ac = false;
                v();
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

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View paramView) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int paramInt) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    boolean s() {
        return false;
    }

    public abstract void setAdapter(T paramT);

    public void setEmptyView(View paramView) {
        boolean bool2 = true;
        this.b = paramView;
        if ((Build.VERSION.SDK_INT >= 16) && (paramView != null) && (paramView.getImportantForAccessibility() == 0)) {
            paramView.setImportantForAccessibility(1);
        }
        paramView = getAdapter();
        boolean bool1 = bool2;
        if (paramView != null) {
            if (!paramView.isEmpty()) {
                break label59;
            }
        }
        label59:
        for (bool1 = bool2; ; bool1 = false) {
            a(bool1);
            return;
        }
    }

    public void setFocusable(boolean paramBoolean) {
        boolean bool = true;
        Adapter localAdapter = getAdapter();
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
                if (!s()) {
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
        Adapter localAdapter = getAdapter();
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
                if (!s()) {
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

    protected void setNextSelectedPositionInt(int paramInt) {
        this.aj = paramInt;
        this.ak = g(paramInt);
        if ((this.ac) && (this.ad == 0) && (paramInt >= 0)) {
            this.Z = paramInt;
            this.aa = this.ak;
        }
    }

    public void setOnClickListener(View.OnClickListener paramOnClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(c paramc) {
        this.ag = paramc;
    }

    public void setOnItemLongClickListener(d paramd) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.ah = paramd;
    }

    public void setOnItemSelectedListener(e parame) {
        this.af = parame;
    }

    protected void setSelectedPositionInt(int paramInt) {
        this.al = paramInt;
        this.am = g(paramInt);
    }

    public abstract void setSelection(int paramInt);

    protected void t() {
        boolean bool2 = false;
        Adapter localAdapter = getAdapter();
        int i;
        if ((localAdapter == null) || (localAdapter.getCount() == 0)) {
            i = 1;
            if ((i != 0) && (!s())) {
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

    void u() {
        if ((this.af != null) || (this.ap.isEnabled())) {
            if ((this.ae) || (this.as)) {
                if (this.e == null) {
                    this.e = new f(null);
                }
                post(this.e);
            }
        } else {
            return;
        }
        a();
        b();
    }

    protected void v() {
        if ((this.al != this.aq) || (this.am != this.ar)) {
            u();
            this.aq = this.al;
            this.ar = this.am;
        }
    }

    int w() {
        int i2 = this.an;
        int n;
        if (i2 == 0) {
            n = -1;
            return n;
        }
        long l1 = this.aa;
        int i = this.Z;
        if (l1 == Long.MIN_VALUE) {
            return -1;
        }
        i = Math.min(i2 - 1, Math.max(0, i));
        long l2 = SystemClock.uptimeMillis();
        Adapter localAdapter = getAdapter();
        label70:
        int i1;
        int j;
        int k;
        if (localAdapter == null) {
            return -1;
            if ((i1 != 0) || ((j != 0) && (n == 0))) {
                i = k + 1;
                k = i;
                j = 0;
            }
        }
        for (; ; ) {
            int m;
            if (SystemClock.uptimeMillis() <= l2 + 100L) {
                n = i;
                if (localAdapter.getItemId(i) == l1) {
                    break;
                }
                if (k != i2 - 1) {
                    break label153;
                }
                n = 1;
                if (m != 0) {
                    break label159;
                }
            }
            label153:
            label159:
            for (i1 = 1; ; i1 = 0) {
                if ((n == 0) || (i1 == 0)) {
                    break label163;
                }
                return -1;
                n = 0;
                break;
            }
            label163:
            break label70;
            if ((n != 0) || ((j == 0) && (i1 == 0))) {
                i = m - 1;
                m = i;
                j = 1;
                continue;
                k = i;
                m = i;
                j = 0;
            }
        }
    }

    public void x() {
        if (getChildCount() > 0) {
            this.ac = true;
            this.ab = this.a;
            if (this.al >= 0) {
                localView = getChildAt(this.al - this.V);
                this.aa = this.ak;
                this.Z = this.aj;
                if (localView != null) {
                    this.W = localView.getLeft();
                }
                this.ad = 0;
            }
        } else {
            return;
        }
        View localView = getChildAt(0);
        Adapter localAdapter = getAdapter();
        if ((this.V >= 0) && (this.V < localAdapter.getCount())) {
        }
        for (this.aa = localAdapter.getItemId(this.V); ; this.aa = -1L) {
            this.Z = this.V;
            if (localView != null) {
                this.W = localView.getLeft();
            }
            this.ad = 1;
            return;
        }
    }

    public static class a
            implements ContextMenu.ContextMenuInfo {
        public View a;
        public int b;
        public long c;

        public a(View paramView, int paramInt, long paramLong) {
            this.a = paramView;
            this.b = paramInt;
            this.c = paramLong;
        }
    }

    class b
            extends DataSetObserver {
        private Parcelable a = null;

        b() {
        }

        public void onChanged() {
            Log.i("View", "onChanged");
            AdapterView.this.ai = true;
            AdapterView.this.ao = AdapterView.this.an;
            AdapterView.this.an = AdapterView.this.getAdapter().getCount();
            if ((AdapterView.this.getAdapter().hasStableIds()) && (this.a != null) && (AdapterView.this.ao == 0) && (AdapterView.this.an > 0)) {
                Log.d("View", "calling onRestoreInstanceState");
                AdapterView.a(AdapterView.this, this.a);
                this.a = null;
            }
            for (; ; ) {
                AdapterView.this.t();
                AdapterView.this.requestLayout();
                return;
                Log.d("View", "else calling rememberSyncState");
                AdapterView.this.x();
            }
        }

        public void onInvalidated() {
            Log.i("View", "onInvalidated");
            AdapterView.this.ai = true;
            if (AdapterView.this.getAdapter().hasStableIds()) {
                this.a = AdapterView.a(AdapterView.this);
            }
            AdapterView.this.ao = AdapterView.this.an;
            AdapterView.this.an = 0;
            AdapterView.this.al = -1;
            AdapterView.this.am = Long.MIN_VALUE;
            AdapterView.this.aj = -1;
            AdapterView.this.ak = Long.MIN_VALUE;
            AdapterView.this.ac = false;
            AdapterView.this.t();
            AdapterView.this.requestLayout();
        }
    }

    public static abstract interface c {
        public abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
    }

    public static abstract interface d {
        public abstract boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
    }

    public static abstract interface e {
        public abstract void a(AdapterView<?> paramAdapterView);

        public abstract void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong);
    }

    private class f
            implements Runnable {
        private f() {
        }

        public void run() {
            if (AdapterView.this.ai) {
                if (AdapterView.this.getAdapter() != null) {
                    AdapterView.this.post(this);
                }
                return;
            }
            AdapterView.b(AdapterView.this);
            AdapterView.c(AdapterView.this);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/AdapterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */