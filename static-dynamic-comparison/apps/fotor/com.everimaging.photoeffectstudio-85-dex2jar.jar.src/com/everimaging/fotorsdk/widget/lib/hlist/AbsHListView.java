package com.everimaging.fotorsdk.widget.lib.hlist;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewConfiguration;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.everimaging.fotorsdk.widget.lib.hlist.util.a.a;
import com.everimaging.fotorsdk.widget.lib.hlist.util.v11.b;

import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class AbsHListView
        extends AdapterView<ListAdapter>
        implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator T = new LinearInterpolator();
    public static final int[] U = {0};
    protected int A;
    int B;
    int C;
    int D;
    int E;
    protected int F = -1;
    int G;
    int H;
    protected j I;
    protected int J = 0;
    protected boolean K;
    boolean L;
    protected int M = -1;
    protected int N;
    protected Runnable O;
    protected final boolean[] P = new boolean[1];
    int Q;
    int R;
    protected boolean S;
    a.a a;
    private c aA;
    private Runnable aB;
    private b aC;
    private i aD;
    private Runnable aE;
    private int aF;
    private int aG;
    private boolean aH;
    private int aI = 0;
    private int aJ;
    private Runnable aK;
    private int aL;
    private int aM;
    private float aN = 1.0F;
    private int aO = -1;
    private a aP;
    private a aQ;
    private int aR;
    private int aS;
    private int aT = 0;
    private boolean aU;
    private int aV;
    private int aW;
    private g aX;
    private int aY;
    private int aZ;
    private VelocityTracker at;
    private e au;
    private h av;
    private boolean aw = true;
    private Rect ax;
    private ContextMenu.ContextMenuInfo ay = null;
    private int az = -1;
    protected int b = 0;
    private int ba;
    private SavedState bb;
    private float bc;
    public Object c;
    Object d;
    int e;
    protected SparseBooleanArray f;
    LongSparseArray<Integer> g;
    protected int h = 0;
    protected a i;
    protected ListAdapter j;
    boolean k;
    boolean l = false;
    Drawable m;
    int n = -1;
    protected Rect o = new Rect();
    protected final k p = new k();
    int q = 0;
    int r = 0;
    int s = 0;
    int t = 0;
    protected Rect u = new Rect();
    protected int v = 0;
    View w;
    View x;
    protected boolean y;
    protected boolean z;

    public AbsHListView(Context paramContext) {
        super(paramContext);
        a();
    }

    public AbsHListView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, paramContext.getResources().getIdentifier("fotorSephiroth_absHListViewStyle", "attr", paramContext.getPackageName()));
    }

    public AbsHListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        a();
        int[] arrayOfInt = (int[]) a(paramContext, "fotorAbsHListView");
        if (arrayOfInt != null) {
        }
        for (paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0); ; paramContext = null) {
            boolean bool4;
            boolean bool3;
            boolean bool2;
            int i2;
            boolean bool1;
            int i1;
            if (paramContext != null) {
                paramAttributeSet = paramContext.getDrawable(0);
                bool4 = paramContext.getBoolean(1, false);
                bool3 = paramContext.getBoolean(6, false);
                bool2 = paramContext.getBoolean(2, true);
                i2 = paramContext.getInt(7, 0);
                paramInt = paramContext.getColor(3, 0);
                bool1 = paramContext.getBoolean(5, true);
                int i3 = paramContext.getInt(4, 0);
                paramContext.recycle();
                paramContext = paramAttributeSet;
                i1 = paramInt;
                paramInt = i3;
            }
            for (; ; ) {
                if (paramContext != null) {
                    setSelector(paramContext);
                }
                this.l = bool4;
                setStackFromRight(bool3);
                setScrollingCacheEnabled(bool2);
                setTranscriptMode(i2);
                setCacheColorHint(i1);
                setSmoothScrollbarEnabled(bool1);
                setChoiceMode(paramInt);
                return;
                paramInt = 0;
                bool2 = true;
                bool3 = false;
                bool4 = false;
                paramContext = null;
                i2 = 0;
                bool1 = true;
                i1 = 0;
            }
        }
    }

    private void A() {
        setSelector(getResources().getDrawable(17301602));
    }

    private void B() {
        if (this.at == null) {
            this.at = VelocityTracker.obtain();
            return;
        }
        this.at.clear();
    }

    private void C() {
        if (this.at == null) {
            this.at = VelocityTracker.obtain();
        }
    }

    private void D() {
        if (this.at != null) {
            this.at.recycle();
            this.at = null;
        }
    }

    private void E() {
        if ((this.L) && (!this.y) && (!this.a.a())) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.z = true;
            this.y = true;
        }
    }

    private void F() {
        if (!this.a.a()) {
            if (this.aK == null) {
                this.aK = new Runnable() {
                    public void run() {
                        if (AbsHListView.this.y) {
                            AbsHListView localAbsHListView = AbsHListView.this;
                            AbsHListView.this.z = false;
                            localAbsHListView.y = false;
                            AbsHListView.a(AbsHListView.this, false);
                            if ((AbsHListView.this.getPersistentDrawingCache() & 0x2) == 0) {
                                AbsHListView.b(AbsHListView.this, false);
                            }
                            if (!AbsHListView.this.isAlwaysDrawnWithCacheEnabled()) {
                                AbsHListView.this.invalidate();
                            }
                        }
                    }
                };
            }
            post(this.aK);
        }
    }

    private void G() {
        if (this.aP != null) {
            this.aP.b();
            this.aQ.b();
        }
    }

    public static int a(Rect paramRect1, Rect paramRect2, int paramInt) {
        int i3;
        int i2;
        int i1;
        switch (paramInt) {
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
            case 66:
                i3 = paramRect1.right;
                i2 = paramRect1.top + paramRect1.height() / 2;
                i1 = paramRect2.left;
                paramInt = paramRect2.top + paramRect2.height() / 2;
        }
        for (; ; ) {
            i1 -= i3;
            paramInt -= i2;
            return paramInt * paramInt + i1 * i1;
            i3 = paramRect1.left + paramRect1.width() / 2;
            i2 = paramRect1.bottom;
            paramInt = paramRect2.left;
            i1 = paramRect2.width() / 2 + paramInt;
            paramInt = paramRect2.top;
            continue;
            i3 = paramRect1.left;
            i2 = paramRect1.top + paramRect1.height() / 2;
            i1 = paramRect2.right;
            paramInt = paramRect2.top + paramRect2.height() / 2;
            continue;
            i3 = paramRect1.left + paramRect1.width() / 2;
            i2 = paramRect1.top;
            paramInt = paramRect2.left;
            i1 = paramRect2.width() / 2 + paramInt;
            paramInt = paramRect2.bottom;
            continue;
            i3 = paramRect1.right + paramRect1.width() / 2;
            i2 = paramRect1.top + paramRect1.height() / 2;
            paramInt = paramRect2.left;
            i1 = paramRect2.width() / 2 + paramInt;
            paramInt = paramRect2.top + paramRect2.height() / 2;
        }
    }

    static View a(ArrayList<View> paramArrayList, int paramInt) {
        int i2 = paramArrayList.size();
        if (i2 > 0) {
            int i1 = 0;
            while (i1 < i2) {
                View localView = (View) paramArrayList.get(i1);
                if (((f) localView.getLayoutParams()).d == paramInt) {
                    paramArrayList.remove(i1);
                    return localView;
                }
                i1 += 1;
            }
            return (View) paramArrayList.remove(i2 - 1);
        }
        return null;
    }

    public static final <T> T a(Context paramContext, String paramString) {
        Object localObject = null;
        try {
            paramString = Class.forName(paramContext.getPackageName() + ".R$styleable").getField(paramString);
            paramContext = (Context) localObject;
            if (paramString != null) {
                paramContext = paramString.get(null);
            }
            return paramContext;
        } catch (Throwable paramContext) {
            paramContext.printStackTrace();
        }
        return null;
    }

    private void a() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
        this.aJ = localViewConfiguration.getScaledTouchSlop();
        this.aL = localViewConfiguration.getScaledMinimumFlingVelocity();
        this.aM = localViewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = localViewConfiguration.getScaledOverscrollDistance();
        this.R = localViewConfiguration.getScaledOverflingDistance();
        this.a = com.everimaging.fotorsdk.widget.lib.hlist.util.a.a(this);
    }

    private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.o.set(paramInt1 - this.q, paramInt2 - this.r, this.s + paramInt3, this.t + paramInt4);
    }

    private void a(Canvas paramCanvas) {
        if (!this.o.isEmpty()) {
            Drawable localDrawable = this.m;
            localDrawable.setBounds(this.o);
            localDrawable.draw(paramCanvas);
        }
    }

    private void b(MotionEvent paramMotionEvent) {
        int i1 = (paramMotionEvent.getAction() & 0xFF00) >> 8;
        if (paramMotionEvent.getPointerId(i1) == this.aO) {
            if (i1 != 0) {
                break label65;
            }
        }
        label65:
        for (i1 = 1; ; i1 = 0) {
            this.D = ((int) paramMotionEvent.getX(i1));
            this.E = ((int) paramMotionEvent.getY(i1));
            this.H = 0;
            this.aO = paramMotionEvent.getPointerId(i1);
            return;
        }
    }

    private boolean h(int paramInt) {
        int i2 = paramInt - this.D;
        int i3 = Math.abs(i2);
        int i1;
        if (getScrollX() != 0) {
            i1 = 1;
        }
        while ((i1 != 0) || (i3 > this.aJ)) {
            E();
            if (i1 != 0) {
                this.F = 5;
                this.H = 0;
                Object localObject = getHandler();
                if (localObject != null) {
                    ((Handler) localObject).removeCallbacks(this.aA);
                }
                setPressed(false);
                localObject = getChildAt(this.A - this.V);
                if (localObject != null) {
                    ((View) localObject).setPressed(false);
                }
                b(1);
                localObject = getParent();
                if (localObject != null) {
                    ((ViewParent) localObject).requestDisallowInterceptTouchEvent(true);
                }
                i(paramInt);
                return true;
                i1 = 0;
            } else {
                this.F = 3;
                if (i2 > 0) {
                }
                for (i1 = this.aJ; ; i1 = -this.aJ) {
                    this.H = i1;
                    break;
                }
            }
        }
        return false;
    }

    private void i(int paramInt) {
        int i4 = 0;
        int i6 = paramInt - this.D;
        int i5 = i6 - this.H;
        int i1;
        Object localObject;
        int i2;
        if (this.G != Integer.MIN_VALUE) {
            i1 = paramInt - this.G;
            if (this.F != 3) {
                break label374;
            }
            if (paramInt != this.G) {
                if (Math.abs(i6) > this.aJ) {
                    localObject = getParent();
                    if (localObject != null) {
                        ((ViewParent) localObject).requestDisallowInterceptTouchEvent(true);
                    }
                }
                if (this.A < 0) {
                    break label312;
                }
                i2 = this.A - this.V;
                label101:
                localObject = getChildAt(i2);
                if (localObject == null) {
                    break label739;
                }
            }
        }
        label295:
        label312:
        label322:
        label374:
        label462:
        label668:
        label681:
        label739:
        for (int i3 = ((View) localObject).getLeft(); ; i3 = 0) {
            if (i1 != 0) {
            }
            for (boolean bool = c(i5, i1); ; bool = false) {
                localObject = getChildAt(i2);
                if (localObject != null) {
                    i2 = ((View) localObject).getLeft();
                    if (bool) {
                        i1 = -i1 - (i2 - i3);
                        overScrollBy(i1, 0, getScrollX(), 0, 0, 0, this.Q, 0, true);
                        if ((Math.abs(this.Q) == Math.abs(getScrollX())) && (this.at != null)) {
                            this.at.clear();
                        }
                        i2 = getOverScrollMode();
                        if ((i2 == 0) || ((i2 == 1) && (!z()))) {
                            this.aT = 0;
                            this.F = 5;
                            if (i6 <= 0) {
                                break label322;
                            }
                            this.aP.a(i1 / getWidth());
                            if (!this.aQ.a()) {
                                this.aQ.c();
                            }
                            invalidate(this.aP.a(false));
                        }
                    }
                    this.D = paramInt;
                } else {
                    this.G = paramInt;
                }
                do {
                    return;
                    i1 = i5;
                    break;
                    i2 = getChildCount() / 2;
                    break label101;
                    if (i6 >= 0) {
                        break label295;
                    }
                    this.aQ.a(i1 / getWidth());
                    if (!this.aP.a()) {
                        this.aP.c();
                    }
                    invalidate(this.aQ.a(true));
                    break label295;
                } while ((this.F != 5) || (paramInt == this.G));
                i5 = getScrollX();
                int i7 = i5 - i1;
                if (paramInt > this.G) {
                    i2 = 1;
                    if (this.aT == 0) {
                        this.aT = i2;
                    }
                    i3 = -i1;
                    if (((i7 >= 0) || (i5 < 0)) && ((i7 <= 0) || (i5 > 0))) {
                        break label668;
                    }
                    i5 = -i5;
                    i3 = i1 + i5;
                    i1 = i5;
                    if (i1 != 0) {
                        overScrollBy(i1, 0, getScrollX(), 0, 0, 0, this.Q, 0, true);
                        i5 = getOverScrollMode();
                        if ((i5 == 0) || ((i5 == 1) && (!z()))) {
                            if (i6 <= 0) {
                                break label681;
                            }
                            this.aP.a(i1 / getWidth());
                            if (!this.aQ.a()) {
                                this.aQ.c();
                            }
                            invalidate(this.aP.a(false));
                        }
                    }
                }
                for (; ; ) {
                    if (i3 != 0) {
                        if (getScrollX() != 0) {
                            this.a.a(0);
                            l();
                        }
                        c(i3, i3);
                        this.F = 3;
                        i3 = f(paramInt);
                        this.H = 0;
                        localObject = getChildAt(i3 - this.V);
                        i1 = i4;
                        if (localObject != null) {
                            i1 = ((View) localObject).getLeft();
                        }
                        this.B = i1;
                        this.D = paramInt;
                        this.A = i3;
                    }
                    this.G = paramInt;
                    this.aT = i2;
                    return;
                    i2 = -1;
                    break;
                    i5 = 0;
                    i1 = i3;
                    i3 = i5;
                    break label462;
                    if (i6 < 0) {
                        this.aQ.a(i1 / getWidth());
                        if (!this.aP.a()) {
                            this.aP.c();
                        }
                        invalidate(this.aQ.a(true));
                    }
                }
            }
        }
    }

    @TargetApi(11)
    private void y() {
        int i2 = 0;
        int i3 = this.V;
        int i4 = getChildCount();
        int i1;
        View localView;
        int i5;
        if (Build.VERSION.SDK_INT >= 11) {
            i1 = 1;
            if (i2 >= i4) {
                return;
            }
            localView = getChildAt(i2);
            i5 = i3 + i2;
            if (!(localView instanceof Checkable)) {
                break label80;
            }
            ((Checkable) localView).setChecked(this.f.get(i5));
        }
        for (; ; ) {
            i2 += 1;
            break;
            i1 = 0;
            break;
            label80:
            if (i1 != 0) {
                localView.setActivated(this.f.get(i5));
            }
        }
    }

    private boolean z() {
        int i1 = getChildCount();
        if (i1 == 0) {
        }
        do {
            return true;
            if (i1 != this.an) {
                return false;
            }
        }
        while ((getChildAt(0).getLeft() >= this.u.left) && (getChildAt(i1 - 1).getRight() <= getWidth() - this.u.right));
        return false;
    }

    public int a(int paramInt1, int paramInt2) {
        Object localObject2 = this.ax;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            this.ax = new Rect();
            localObject1 = this.ax;
        }
        int i1 = getChildCount() - 1;
        while (i1 >= 0) {
            localObject2 = getChildAt(i1);
            if (((View) localObject2).getVisibility() == 0) {
                ((View) localObject2).getHitRect((Rect) localObject1);
                if (((Rect) localObject1).contains(paramInt1, paramInt2)) {
                    return this.V + i1;
                }
            }
            i1 -= 1;
        }
        return -1;
    }

    @SuppressLint({"NewApi"})
    protected View a(int paramInt, boolean[] paramArrayOfBoolean) {
        paramArrayOfBoolean[0] = false;
        Object localObject = this.p.d(paramInt);
        if (localObject != null) {
            return (View) localObject;
        }
        View localView = this.p.e(paramInt);
        if (localView != null) {
            localObject = this.j.getView(paramInt, localView, this);
            if ((Build.VERSION.SDK_INT >= 16) && (((View) localObject).getImportantForAccessibility() == 0)) {
                ((View) localObject).setImportantForAccessibility(1);
            }
            if (localObject != localView) {
                this.p.a(localView, paramInt);
                paramArrayOfBoolean = (boolean[]) localObject;
                if (this.aG == 0) {
                    break label246;
                }
                ((View) localObject).setDrawingCacheBackgroundColor(this.aG);
                paramArrayOfBoolean = (boolean[]) localObject;
                label103:
                if (this.k) {
                    localObject = paramArrayOfBoolean.getLayoutParams();
                    if (localObject != null) {
                        break label249;
                    }
                    localObject = (f) generateDefaultLayoutParams();
                }
            }
        }
        for (; ; ) {
            ((f) localObject).e = this.j.getItemId(paramInt);
            paramArrayOfBoolean.setLayoutParams((ViewGroup.LayoutParams) localObject);
            localObject = paramArrayOfBoolean;
            if (!this.ap.isEnabled()) {
                break;
            }
            localObject = paramArrayOfBoolean;
            if (this.aX != null) {
                break;
            }
            this.aX = new g();
            return paramArrayOfBoolean;
            paramArrayOfBoolean[0] = true;
            ((View) localObject).onFinishTemporaryDetach();
            paramArrayOfBoolean = (boolean[]) localObject;
            break label103;
            localObject = this.j.getView(paramInt, null, this);
            if ((Build.VERSION.SDK_INT >= 16) && (((View) localObject).getImportantForAccessibility() == 0)) {
                ((View) localObject).setImportantForAccessibility(1);
            }
            paramArrayOfBoolean = (boolean[]) localObject;
            if (this.aG != 0) {
                ((View) localObject).setDrawingCacheBackgroundColor(this.aG);
                paramArrayOfBoolean = (boolean[]) localObject;
            }
            label246:
            break label103;
            label249:
            if (!checkLayoutParams((ViewGroup.LayoutParams) localObject)) {
                localObject = (f) generateLayoutParams((ViewGroup.LayoutParams) localObject);
            } else {
                localObject = (f) localObject;
            }
        }
    }

    public f a(AttributeSet paramAttributeSet) {
        return new f(getContext(), paramAttributeSet);
    }

    public void a(int paramInt1, int paramInt2, boolean paramBoolean) {
        if (this.au == null) {
            this.au = new e();
        }
        int i1 = this.V;
        int i2 = getChildCount();
        int i3 = getPaddingLeft();
        int i4 = getWidth();
        int i5 = getPaddingRight();
        if ((paramInt1 == 0) || (this.an == 0) || (i2 == 0) || ((i1 == 0) && (getChildAt(0).getLeft() == i3) && (paramInt1 < 0)) || ((i1 + i2 == this.an) && (getChildAt(i2 - 1).getRight() == i4 - i5) && (paramInt1 > 0))) {
            this.au.b();
            if (this.I != null) {
                this.I.a();
            }
            return;
        }
        b(2);
        this.au.a(paramInt1, paramInt2, paramBoolean);
    }

    protected void a(int paramInt, View paramView) {
        if (paramInt != -1) {
            this.n = paramInt;
        }
        Rect localRect = this.o;
        localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
        if ((paramView instanceof m)) {
            ((m) paramView).a(localRect);
        }
        a(localRect.left, localRect.top, localRect.right, localRect.bottom);
        boolean bool = this.aH;
        if (paramView.isEnabled() != bool) {
            if (bool) {
                break label116;
            }
        }
        label116:
        for (bool = true; ; bool = false) {
            this.aH = bool;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
            return;
        }
    }

    @TargetApi(11)
    public void a(int paramInt, boolean paramBoolean) {
        if (this.b == 0) {
        }
        label188:
        label276:
        label391:
        label418:
        for (; ; ) {
            return;
            if ((Build.VERSION.SDK_INT >= 11) && (paramBoolean) && (this.b == 3) && (this.c == null)) {
                if ((this.d == null) || (!((b) this.d).a())) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.c = startActionMode((b) this.d);
            }
            if ((this.b == 2) || ((Build.VERSION.SDK_INT >= 11) && (this.b == 3))) {
                boolean bool = this.f.get(paramInt);
                this.f.put(paramInt, paramBoolean);
                if ((this.g != null) && (this.j.hasStableIds())) {
                    if (paramBoolean) {
                        this.g.put(this.j.getItemId(paramInt), Integer.valueOf(paramInt));
                    }
                } else {
                    if (bool != paramBoolean) {
                        if (!paramBoolean) {
                            break label276;
                        }
                        this.e += 1;
                    }
                    if (this.c != null) {
                        long l1 = this.j.getItemId(paramInt);
                        ((b) this.d).a((ActionMode) this.c, paramInt, l1, paramBoolean);
                    }
                }
            }
            for (; ; ) {
                if ((this.ae) || (this.as)) {
                    break label418;
                }
                this.ai = true;
                x();
                requestLayout();
                return;
                this.g.delete(this.j.getItemId(paramInt));
                break;
                this.e -= 1;
                break label188;
                if ((this.g != null) && (this.j.hasStableIds())) {
                }
                for (int i1 = 1; ; i1 = 0) {
                    if ((paramBoolean) || (a(paramInt))) {
                        this.f.clear();
                        if (i1 != 0) {
                            this.g.clear();
                        }
                    }
                    if (!paramBoolean) {
                        break label391;
                    }
                    this.f.put(paramInt, true);
                    if (i1 != 0) {
                        this.g.put(this.j.getItemId(paramInt), Integer.valueOf(paramInt));
                    }
                    this.e = 1;
                    break;
                }
                if ((this.f.size() == 0) || (!this.f.valueAt(0))) {
                    this.e = 0;
                }
            }
        }
    }

    protected abstract void a(boolean paramBoolean);

    public boolean a(float paramFloat1, float paramFloat2, int paramInt) {
        int i1 = a((int) paramFloat1, (int) paramFloat2);
        if (i1 != -1) {
            long l1 = this.j.getItemId(i1);
            View localView = getChildAt(i1 - this.V);
            if (localView != null) {
                this.ay = b(localView, i1, l1);
                return super.showContextMenuForChild(this);
            }
        }
        return a(paramFloat1, paramFloat2, paramInt);
    }

    public boolean a(int paramInt) {
        if ((this.b != 0) && (this.f != null)) {
            return this.f.get(paramInt);
        }
        return false;
    }

    @TargetApi(14)
    protected boolean a(MotionEvent paramMotionEvent) {
        return (Build.VERSION.SDK_INT >= 14) && ((paramMotionEvent.getButtonState() & 0x2) != 0) && (a(paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState()));
    }

    public boolean a(View paramView, int paramInt, long paramLong) {
        int i1 = 1;
        int i2 = 0;
        int i3 = 0;
        if (this.b != 0) {
            if ((this.b == 2) || ((Build.VERSION.SDK_INT >= 11) && (this.b == 3) && (this.c != null))) {
                if (!this.f.get(paramInt, false)) {
                    bool1 = true;
                    this.f.put(paramInt, bool1);
                    if ((this.g != null) && (this.j.hasStableIds())) {
                        if (!bool1) {
                            break label209;
                        }
                        this.g.put(this.j.getItemId(paramInt), Integer.valueOf(paramInt));
                    }
                    label117:
                    if (!bool1) {
                        break label229;
                    }
                    this.e += 1;
                    label132:
                    if (this.c == null) {
                        break label388;
                    }
                    ((b) this.d).a((ActionMode) this.c, paramInt, paramLong, bool1);
                    i1 = i3;
                    label164:
                    i2 = 1;
                    label167:
                    if (i2 != 0) {
                        y();
                    }
                }
            }
        }
        for (boolean bool1 = true; ; bool1 = false) {
            boolean bool2 = bool1;
            if (i1 != 0) {
                bool2 = bool1 | super.a(paramView, paramInt, paramLong);
            }
            return bool2;
            bool1 = false;
            break;
            label209:
            this.g.delete(this.j.getItemId(paramInt));
            break label117;
            label229:
            this.e -= 1;
            break label132;
            if (this.b == 1) {
                if (!this.f.get(paramInt, false)) {
                    i1 = 1;
                    label265:
                    if (i1 == 0) {
                        break label353;
                    }
                    this.f.clear();
                    this.f.put(paramInt, true);
                    if ((this.g != null) && (this.j.hasStableIds())) {
                        this.g.clear();
                        this.g.put(this.j.getItemId(paramInt), Integer.valueOf(paramInt));
                    }
                }
                for (this.e = 1; ; this.e = 0) {
                    label353:
                    do {
                        i2 = 1;
                        i1 = 1;
                        break;
                        i1 = 0;
                        break label265;
                    } while ((this.f.size() != 0) && (this.f.valueAt(0)));
                }
            }
            i1 = 1;
            break label167;
            label388:
            i1 = 1;
            break label164;
        }
    }

    public void addTouchables(ArrayList<View> paramArrayList) {
        int i2 = getChildCount();
        int i3 = this.V;
        ListAdapter localListAdapter = this.j;
        if (localListAdapter == null) {
        }
        for (; ; ) {
            return;
            int i1 = 0;
            while (i1 < i2) {
                View localView = getChildAt(i1);
                if (localListAdapter.isEnabled(i3 + i1)) {
                    paramArrayList.add(localView);
                }
                localView.addTouchables(paramArrayList);
                i1 += 1;
            }
        }
    }

    ContextMenu.ContextMenuInfo b(View paramView, int paramInt, long paramLong) {
        return new AdapterView.a(paramView, paramInt, paramLong);
    }

    public void b() {
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            this.g.clear();
        }
        this.e = 0;
    }

    void b(int paramInt) {
        if ((paramInt != this.aI) && (this.av != null)) {
            this.aI = paramInt;
            this.av.a(this, paramInt);
        }
    }

    public void b(int paramInt1, int paramInt2) {
        a(paramInt1, paramInt2, false);
    }

    protected void c() {
        if (this.av != null) {
            this.av.a(this, this.V, getChildCount(), this.an);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public void c(int paramInt) {
        if (this.I == null) {
            this.I = new j();
        }
        this.I.a(paramInt);
    }

    boolean c(int paramInt1, int paramInt2) {
        int i10 = getChildCount();
        if (i10 == 0) {
            return true;
        }
        int i6 = getChildAt(0).getLeft();
        int i7 = getChildAt(i10 - 1).getRight();
        Object localObject = this.u;
        int i8 = getWidth();
        int i1 = getWidth() - getPaddingRight() - getPaddingLeft();
        int i2;
        int i3;
        label91:
        int i9;
        if (paramInt1 < 0) {
            i2 = Math.max(-(i1 - 1), paramInt1);
            if (paramInt2 >= 0) {
                break label221;
            }
            i3 = Math.max(-(i1 - 1), paramInt2);
            i9 = this.V;
            if (i9 != 0) {
                break label233;
            }
            this.aR = (i6 - ((Rect) localObject).left);
            label114:
            if (i9 + i10 != this.an) {
                break label247;
            }
            this.aS = (((Rect) localObject).right + i7);
            label138:
            if ((i9 != 0) || (i6 < ((Rect) localObject).left) || (i3 < 0)) {
                break label261;
            }
            paramInt1 = 1;
            label160:
            if ((i9 + i10 != this.an) || (i7 > getWidth() - ((Rect) localObject).right) || (i3 > 0)) {
                break label266;
            }
            paramInt2 = 1;
        }
        for (; ; ) {
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
                if (i3 != 0) {
                    return true;
                    i2 = Math.min(i1 - 1, paramInt1);
                    break;
                    label221:
                    i3 = Math.min(i1 - 1, paramInt2);
                    break label91;
                    label233:
                    this.aR += i3;
                    break label114;
                    label247:
                    this.aS += i3;
                    break label138;
                    label261:
                    paramInt1 = 0;
                    break label160;
                    label266:
                    paramInt2 = 0;
                    continue;
                }
                return false;
            }
        }
        boolean bool1;
        int i11;
        int i12;
        int i4;
        int i13;
        label332:
        int i5;
        if (i3 < 0) {
            bool1 = true;
            boolean bool2 = isInTouchMode();
            if (bool2) {
                m();
            }
            i11 = getHeaderViewsCount();
            i12 = this.an - getFooterViewsCount();
            i4 = 0;
            i1 = 0;
            if (!bool1) {
                break label574;
            }
            i13 = -i3;
            paramInt1 = 0;
            paramInt2 = 0;
            i4 = paramInt1;
            i5 = i1;
            if (paramInt2 < i10) {
                localObject = getChildAt(paramInt2);
                if (((View) localObject).getRight() < i13) {
                    break label532;
                }
                i5 = i1;
                i4 = paramInt1;
            }
            this.C = (this.B + i2);
            this.as = true;
            if (i4 > 0) {
                detachViewsFromParent(i5, i4);
                this.p.d();
            }
            if (!awakenScrollBars()) {
                invalidate();
            }
            d(i3);
            if (bool1) {
                this.V = (i4 + this.V);
            }
            paramInt1 = Math.abs(i3);
            if ((0 - i6 < paramInt1) || (i7 - (i8 - 0) < paramInt1)) {
                a(bool1);
            }
            if ((bool2) || (this.al == -1)) {
                break label666;
            }
            paramInt1 = this.al - this.V;
            if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
                a(this.al, getChildAt(paramInt1));
            }
        }
        for (; ; ) {
            this.as = false;
            c();
            return false;
            bool1 = false;
            break;
            label532:
            i4 = i9 + paramInt2;
            if ((i4 >= i11) && (i4 < i12)) {
                this.p.a((View) localObject, i4);
            }
            paramInt2 += 1;
            paramInt1 += 1;
            break label332;
            label574:
            i13 = getWidth();
            paramInt2 = 0;
            paramInt1 = i10 - 1;
            i1 = i4;
            for (; ; ) {
                i4 = paramInt2;
                i5 = i1;
                if (paramInt1 < 0) {
                    break;
                }
                localObject = getChildAt(paramInt1);
                i4 = paramInt2;
                i5 = i1;
                if (((View) localObject).getLeft() <= i13 - i3) {
                    break;
                }
                i1 = i9 + paramInt1;
                if ((i1 >= i11) && (i1 < i12)) {
                    this.p.a((View) localObject, i1);
                }
                paramInt2 += 1;
                i1 = paramInt1;
                paramInt1 -= 1;
            }
            label666:
            if (this.n != -1) {
                paramInt1 = this.n - this.V;
                if ((paramInt1 >= 0) && (paramInt1 < getChildCount())) {
                    a(-1, getChildAt(paramInt1));
                }
            } else {
                this.o.setEmpty();
            }
        }
    }

    @TargetApi(11)
    boolean c(View paramView, int paramInt, long paramLong) {
        if ((Build.VERSION.SDK_INT >= 11) && (this.b == 3)) {
            if (this.c == null) {
                paramView = startActionMode((b) this.d);
                this.c = paramView;
                if (paramView != null) {
                    a(paramInt, true);
                    performHapticFeedback(0);
                }
            }
            bool2 = true;
            return bool2;
        }
        if (this.ah != null) {
        }
        for (boolean bool2 = this.ah.a(this, paramView, paramInt, paramLong); ; bool2 = false) {
            boolean bool1 = bool2;
            if (!bool2) {
                this.ay = b(paramView, paramInt, paramLong);
                bool1 = super.showContextMenuForChild(this);
            }
            bool2 = bool1;
            if (!bool1) {
                break;
            }
            performHapticFeedback(0);
            return bool1;
        }
    }

    public boolean checkInputConnectionProxy(View paramView) {
        return false;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return paramLayoutParams instanceof f;
    }

    protected int computeHorizontalScrollExtent() {
        int i3 = getChildCount();
        if (i3 > 0) {
            if (this.aw) {
                int i2 = i3 * 100;
                View localView = getChildAt(0);
                int i4 = localView.getLeft();
                int i5 = localView.getWidth();
                int i1 = i2;
                if (i5 > 0) {
                    i1 = i2 + i4 * 100 / i5;
                }
                localView = getChildAt(i3 - 1);
                i3 = localView.getRight();
                i4 = localView.getWidth();
                i2 = i1;
                if (i4 > 0) {
                    i2 = i1 - (i3 - getWidth()) * 100 / i4;
                }
                return i2;
            }
            return 1;
        }
        return 0;
    }

    protected int computeHorizontalScrollOffset() {
        int i3 = 0;
        int i2 = 0;
        int i4 = this.V;
        int i5 = getChildCount();
        int i1 = i2;
        if (i4 >= 0) {
            i1 = i2;
            if (i5 > 0) {
                if (!this.aw) {
                    break label114;
                }
                View localView = getChildAt(0);
                i3 = localView.getLeft();
                i5 = localView.getWidth();
                i1 = i2;
                if (i5 > 0) {
                    i1 = Math.max(i4 * 100 - i3 * 100 / i5 + (int) (getScrollX() / getWidth() * this.an * 100.0F), 0);
                }
            }
        }
        return i1;
        label114:
        i2 = this.an;
        if (i4 == 0) {
            i1 = i3;
        }
        for (; ; ) {
            float f1 = i4;
            float f2 = i5;
            return (int) (i1 / i2 * f2 + f1);
            if (i4 + i5 == i2) {
                i1 = i2;
            } else {
                i1 = i5 / 2 + i4;
            }
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.aw) {
            int i2 = Math.max(this.an * 100, 0);
            int i1 = i2;
            if (getScrollX() != 0) {
                i1 = i2 + Math.abs((int) (getScrollX() / getWidth() * this.an * 100.0F));
            }
            return i1;
        }
        return this.an;
    }

    void d() {
        if (getChildCount() > 0) {
            e();
            requestLayout();
            invalidate();
        }
    }

    public void d(int paramInt) {
        int i2 = getChildCount();
        int i1 = 0;
        while (i1 < i2) {
            getChildAt(i1).offsetLeftAndRight(paramInt);
            i1 += 1;
        }
    }

    protected void d(int paramInt1, int paramInt2) {
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        boolean bool = this.l;
        if (!bool) {
            a(paramCanvas);
        }
        super.dispatchDraw(paramCanvas);
        if (bool) {
            a(paramCanvas);
        }
    }

    protected void dispatchSetPressed(boolean paramBoolean) {
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        if (this.aP != null) {
            int i1 = getScrollX();
            int i2;
            int i3;
            int i4;
            int i5;
            if (!this.aP.a()) {
                i2 = paramCanvas.save();
                i3 = this.u.top + this.aV;
                i4 = this.u.bottom;
                i5 = this.aW;
                i4 = getHeight() - i3 - (i4 + i5);
                getWidth();
                i5 = Math.min(0, this.aR + i1);
                paramCanvas.rotate(-90.0F);
                paramCanvas.translate(-getHeight() + i3, i5);
                this.aP.a(i4, i4);
                if (this.aP.a(paramCanvas)) {
                    this.aP.b(i5, i3);
                    invalidate();
                }
                paramCanvas.restoreToCount(i2);
            }
            if (!this.aQ.a()) {
                i2 = paramCanvas.save();
                i3 = this.u.left + this.aV;
                i4 = this.u.right;
                i5 = this.aW;
                i4 = getHeight() - i3 - (i4 + i5);
                i1 = Math.max(getWidth(), i1 + this.aS);
                paramCanvas.rotate(90.0F);
                paramCanvas.translate(-i3, -i1);
                this.aQ.a(i4, i4);
                if (this.aQ.a(paramCanvas)) {
                    invalidate();
                }
                paramCanvas.restoreToCount(i2);
            }
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        k();
    }

    protected abstract int e(int paramInt);

    protected void e() {
        removeAllViewsInLayout();
        this.V = 0;
        this.ai = false;
        this.O = null;
        this.ac = false;
        this.bb = null;
        this.aq = -1;
        this.ar = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.J = 0;
        this.n = -1;
        this.o.setEmpty();
        invalidate();
    }

    protected int f(int paramInt) {
        int i2 = getChildCount();
        if (i2 == 0) {
            paramInt = -1;
        }
        int i1;
        do {
            return paramInt;
            i1 = e(paramInt);
            paramInt = i1;
        } while (i1 != -1);
        return this.V + i2 - 1;
    }

    protected void f() {
    }

    protected void g() {
        int i4 = 1;
        int i3 = 0;
        int i1;
        int i2;
        label56:
        View localView;
        if (this.w != null) {
            if (this.V > 0) {
                i1 = 1;
                i2 = i1;
                if (i1 == 0) {
                    i2 = i1;
                    if (getChildCount() > 0) {
                        if (getChildAt(0).getLeft() >= this.u.left) {
                            break label161;
                        }
                        i2 = 1;
                    }
                }
                localView = this.w;
                if (i2 == 0) {
                    break label166;
                }
                i1 = 0;
                label68:
                localView.setVisibility(i1);
            }
        } else if (this.x != null) {
            i2 = getChildCount();
            if (this.V + i2 >= this.an) {
                break label171;
            }
            i1 = 1;
            label101:
            if ((i1 != 0) || (i2 <= 0)) {
                break label186;
            }
            if (getChildAt(i2 - 1).getRight() <= getRight() - this.u.right) {
                break label176;
            }
            i1 = i4;
        }
        label137:
        label161:
        label166:
        label171:
        label176:
        label186:
        for (; ; ) {
            localView = this.x;
            if (i1 != 0) {
            }
            for (i1 = i3; ; i1 = 4) {
                localView.setVisibility(i1);
                return;
                i1 = 0;
                break;
                i2 = 0;
                break label56;
                i1 = 4;
                break label68;
                i1 = 0;
                break label101;
                i1 = 0;
                break label137;
            }
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -1, 0);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return new f(paramLayoutParams);
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.aG;
    }

    public int getCheckedItemCount() {
        return this.e;
    }

    public long[] getCheckedItemIds() {
        int i1 = 0;
        Object localObject;
        if ((this.b == 0) || (this.g == null) || (this.j == null)) {
            localObject = new long[0];
            return (long[]) localObject;
        }
        LongSparseArray localLongSparseArray = this.g;
        int i2 = localLongSparseArray.size();
        long[] arrayOfLong = new long[i2];
        for (; ; ) {
            localObject = arrayOfLong;
            if (i1 >= i2) {
                break;
            }
            arrayOfLong[i1] = localLongSparseArray.keyAt(i1);
            i1 += 1;
        }
    }

    public int getCheckedItemPosition() {
        if ((this.b == 1) && (this.f != null) && (this.f.size() == 1)) {
            return this.f.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.b != 0) {
            return this.f;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.b;
    }

    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.ay;
    }

    public void getFocusedRect(Rect paramRect) {
        View localView = getSelectedView();
        if ((localView != null) && (localView.getParent() == this)) {
            localView.getFocusedRect(paramRect);
            offsetDescendantRectToMyCoords(localView, paramRect);
            return;
        }
        super.getFocusedRect(paramRect);
    }

    protected int getFooterViewsCount() {
        return 0;
    }

    protected int getHeaderViewsCount() {
        return 0;
    }

    protected float getHorizontalScrollFactor() {
        if (this.bc == 0.0F) {
            int i1 = getResources().getIdentifier("fotorSephiroth_listPreferredItemWidth", "attr", getContext().getPackageName());
            if (i1 == 0) {
                break label91;
            }
            TypedValue localTypedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(i1, localTypedValue, true)) {
                this.bc = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
        } else {
            return this.bc;
        }
        throw new IllegalStateException("Expected theme to define fotorSephiroth_listPreferredItemWidth.");
        label91:
        throw new IllegalStateException("Expected theme to define fotorSephiroth_listPreferredItemWidth.");
    }

    protected int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    protected float getLeftFadingEdgeStrength() {
        int i1 = getChildCount();
        float f1 = super.getLeftFadingEdgeStrength();
        if (i1 == 0) {
        }
        float f2;
        do {
            return f1;
            if (this.V > 0) {
                return 1.0F;
            }
            i1 = getChildAt(0).getLeft();
            f2 = getHorizontalFadingEdgeLength();
        } while (i1 >= getPaddingLeft());
        return -(i1 - getPaddingLeft()) / f2;
    }

    public int getListPaddingBottom() {
        return this.u.bottom;
    }

    public int getListPaddingLeft() {
        return this.u.left;
    }

    public int getListPaddingRight() {
        return this.u.right;
    }

    public int getListPaddingTop() {
        return this.u.top;
    }

    protected float getRightFadingEdgeStrength() {
        int i1 = getChildCount();
        float f1 = super.getRightFadingEdgeStrength();
        if (i1 == 0) {
        }
        int i2;
        float f2;
        do {
            return f1;
            if (this.V + i1 - 1 < this.an - 1) {
                return 1.0F;
            }
            i1 = getChildAt(i1 - 1).getRight();
            i2 = getWidth();
            f2 = getHorizontalFadingEdgeLength();
        } while (i1 <= i2 - getPaddingRight());
        return (i1 - i2 + getPaddingRight()) / f2;
    }

    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if ((this.an > 0) && (this.al >= 0)) {
            return getChildAt(this.al - this.V);
        }
        return null;
    }

    public Drawable getSelector() {
        return this.m;
    }

    public int getSolidColor() {
        return this.aG;
    }

    public int getTranscriptMode() {
        return this.aF;
    }

    boolean h() {
        switch (this.F) {
            default:
                return false;
        }
        return true;
    }

    protected boolean i() {
        return ((hasFocus()) && (!isInTouchMode())) || (h());
    }

    protected void j() {
        if ((!isEnabled()) || (!isClickable())) {
        }
        for (; ; ) {
            return;
            Drawable localDrawable = this.m;
            Object localObject = this.o;
            if ((localDrawable != null) && ((isFocused()) || (h())) && (!((Rect) localObject).isEmpty())) {
                localObject = getChildAt(this.al - this.V);
                if (localObject != null) {
                    if (!((View) localObject).hasFocusable()) {
                        ((View) localObject).setPressed(true);
                    }
                } else {
                    setPressed(true);
                    boolean bool = isLongClickable();
                    localDrawable = localDrawable.getCurrent();
                    if ((localDrawable != null) && ((localDrawable instanceof TransitionDrawable))) {
                        if (!bool) {
                            break label172;
                        }
                        ((TransitionDrawable) localDrawable).startTransition(ViewConfiguration.getLongPressTimeout());
                    }
                    while ((bool) && (!this.ai)) {
                        if (this.aC == null) {
                            this.aC = new b(null);
                        }
                        this.aC.a();
                        postDelayed(this.aC, ViewConfiguration.getLongPressTimeout());
                        return;
                        label172:
                        ((TransitionDrawable) localDrawable).resetTransition();
                    }
                }
            }
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.m != null) {
            this.m.jumpToCurrentState();
        }
    }

    void k() {
        if (this.m != null) {
            if (i()) {
                this.m.setState(getDrawableState());
            }
        } else {
            return;
        }
        this.m.setState(U);
    }

    @TargetApi(11)
    protected void l() {
        if ((this.a.a()) && ((getParent() instanceof View))) {
            ((View) getParent()).invalidate();
        }
    }

    protected void m() {
        if (this.al != -1) {
            if (this.h != 4) {
                this.M = this.al;
            }
            if ((this.aj >= 0) && (this.aj != this.al)) {
                this.M = this.aj;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.J = 0;
        }
    }

    protected int n() {
        int i2 = this.al;
        int i1 = i2;
        if (i2 < 0) {
            i1 = this.M;
        }
        return Math.min(Math.max(0, i1), this.an - 1);
    }

    protected boolean o() {
        if ((this.al < 0) && (p())) {
            k();
            return true;
        }
        return false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if ((this.j != null) && (this.i == null)) {
            this.i = new a();
            this.j.registerDataSetObserver(this.i);
            this.ai = true;
            this.ao = this.an;
            this.an = this.j.getCount();
        }
        this.S = true;
    }

    protected int[] onCreateDrawableState(int paramInt) {
        Object localObject;
        if (this.aH) {
            localObject = super.onCreateDrawableState(paramInt);
            return (int[]) localObject;
        }
        int i1 = ENABLED_STATE_SET[0];
        int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
        paramInt = arrayOfInt.length - 1;
        label36:
        if (paramInt >= 0) {
            if (arrayOfInt[paramInt] != i1) {
            }
        }
        for (; ; ) {
            localObject = arrayOfInt;
            if (paramInt < 0) {
                break;
            }
            System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, arrayOfInt.length - paramInt - 1);
            return arrayOfInt;
            paramInt -= 1;
            break label36;
            paramInt = -1;
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
        return null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.p.b();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        if ((this.j != null) && (this.i != null)) {
            this.j.unregisterDataSetObserver(this.i);
            this.i = null;
        }
        if (this.au != null) {
            removeCallbacks(this.au);
        }
        if (this.I != null) {
            this.I.a();
        }
        if (this.aK != null) {
            removeCallbacks(this.aK);
        }
        if (this.aD != null) {
            removeCallbacks(this.aD);
        }
        if (this.aE != null) {
            removeCallbacks(this.aE);
            this.aE = null;
        }
        this.S = false;
    }

    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
        super.onFocusChanged(paramBoolean, paramInt, paramRect);
        if ((paramBoolean) && (this.al < 0) && (!isInTouchMode())) {
            if ((!this.S) && (this.j != null)) {
                this.ai = true;
                this.ao = this.an;
                this.an = this.j.getCount();
            }
            p();
        }
    }

    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
        if ((paramMotionEvent.getSource() & 0x2) != 0) {
            switch (paramMotionEvent.getAction()) {
            }
        }
        int i1;
        do {
            float f1;
            do {
                do {
                    return super.onGenericMotionEvent(paramMotionEvent);
                } while (this.F != -1);
                f1 = paramMotionEvent.getAxisValue(10);
            } while (f1 == 0.0F);
            i1 = (int) (f1 * getHorizontalScrollFactor());
        } while (c(i1, i1));
        return true;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
        super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
        paramAccessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
        paramAccessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                paramAccessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                paramAccessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        int i1 = paramMotionEvent.getAction();
        if (this.I != null) {
            this.I.a();
        }
        if (!this.S) {
        }
        do {
            do {
                return false;
                switch (i1 & 0xFF) {
                    case 4:
                    case 5:
                    default:
                        return false;
                    case 0:
                        i1 = this.F;
                        if ((i1 == 6) || (i1 == 5)) {
                            this.H = 0;
                            return true;
                        }
                        i2 = (int) paramMotionEvent.getX();
                        int i3 = (int) paramMotionEvent.getY();
                        this.aO = paramMotionEvent.getPointerId(0);
                        int i4 = e(i2);
                        if ((i1 != 4) && (i4 >= 0)) {
                            this.B = getChildAt(i4 - this.V).getLeft();
                            this.D = i2;
                            this.E = i3;
                            this.A = i4;
                            this.F = 0;
                            F();
                        }
                        this.G = Integer.MIN_VALUE;
                        B();
                        this.at.addMovement(paramMotionEvent);
                }
            } while (i1 != 4);
            return true;
            switch (this.F) {
                default:
                    return false;
            }
            int i2 = paramMotionEvent.findPointerIndex(this.aO);
            i1 = i2;
            if (i2 == -1) {
                this.aO = paramMotionEvent.getPointerId(0);
                i1 = 0;
            }
            i1 = (int) paramMotionEvent.getX(i1);
            C();
            this.at.addMovement(paramMotionEvent);
        } while (!h(i1));
        return true;
        this.F = -1;
        this.aO = -1;
        D();
        b(0);
        return false;
        b(paramMotionEvent);
        return false;
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        return false;
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        boolean bool = true;
        switch (paramInt) {
        }
        do {
            bool = super.onKeyUp(paramInt, paramKeyEvent);
            do {
                return bool;
            } while (!isEnabled());
        }
        while ((!isClickable()) || (!isPressed()) || (this.al < 0) || (this.j == null) || (this.al >= this.j.getCount()));
        paramKeyEvent = getChildAt(this.al - this.V);
        if (paramKeyEvent != null) {
            a(paramKeyEvent, this.al, this.am);
            paramKeyEvent.setPressed(false);
        }
        setPressed(false);
        return true;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        this.ae = true;
        if (paramBoolean) {
            paramInt4 = getChildCount();
            paramInt2 = 0;
            while (paramInt2 < paramInt4) {
                getChildAt(paramInt2).forceLayout();
                paramInt2 += 1;
            }
            this.p.a();
        }
        f();
        this.ae = false;
        this.N = ((paramInt3 - paramInt1) / 3);
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        if (this.m == null) {
            A();
        }
        Object localObject = this.u;
        ((Rect) localObject).left = (this.q + getPaddingLeft());
        ((Rect) localObject).top = (this.r + getPaddingTop());
        ((Rect) localObject).right = (this.s + getPaddingRight());
        ((Rect) localObject).bottom = (this.t + getPaddingBottom());
        if (this.aF == 1) {
            int i1 = getChildCount();
            paramInt2 = getWidth() - getPaddingRight();
            localObject = getChildAt(i1 - 1);
            if (localObject == null) {
                break label144;
            }
            paramInt1 = ((View) localObject).getRight();
            if ((i1 + this.V < this.ba) || (paramInt1 > paramInt2)) {
                break label149;
            }
        }
        label144:
        label149:
        for (boolean bool = true; ; bool = false) {
            this.aU = bool;
            return;
            paramInt1 = paramInt2;
            break;
        }
    }

    protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
        if (getScrollX() != paramInt1) {
            onScrollChanged(paramInt1, getScrollY(), getScrollX(), getScrollY());
            this.a.a(paramInt1);
            l();
            awakenScrollBars();
        }
    }

    @TargetApi(11)
    public void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        this.ai = true;
        this.ab = paramParcelable.e;
        if (paramParcelable.a >= 0L) {
            this.ac = true;
            this.bb = paramParcelable;
            this.aa = paramParcelable.a;
            this.Z = paramParcelable.d;
            this.W = paramParcelable.c;
            this.ad = 0;
        }
        for (; ; ) {
            if (paramParcelable.i != null) {
                this.f = paramParcelable.i;
            }
            if (paramParcelable.j != null) {
                this.g = paramParcelable.j;
            }
            this.e = paramParcelable.h;
            if ((Build.VERSION.SDK_INT >= 11) && (paramParcelable.g) && (this.b == 3) && (this.d != null)) {
                this.c = startActionMode((b) this.d);
            }
            requestLayout();
            return;
            if (paramParcelable.b >= 0L) {
                setSelectedPositionInt(-1);
                setNextSelectedPositionInt(-1);
                this.n = -1;
                this.ac = true;
                this.bb = paramParcelable;
                this.aa = paramParcelable.b;
                this.Z = paramParcelable.d;
                this.W = paramParcelable.c;
                this.ad = 1;
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        boolean bool = true;
        int i2 = 0;
        SavedState localSavedState = new SavedState(super.onSaveInstanceState());
        if (this.bb != null) {
            localSavedState.a = this.bb.a;
            localSavedState.b = this.bb.b;
            localSavedState.c = this.bb.c;
            localSavedState.d = this.bb.d;
            localSavedState.e = this.bb.e;
            localSavedState.f = this.bb.f;
            localSavedState.g = this.bb.g;
            localSavedState.h = this.bb.h;
            localSavedState.i = this.bb.i;
            localSavedState.j = this.bb.j;
            return localSavedState;
        }
        int i1;
        if ((getChildCount() > 0) && (this.an > 0)) {
            i1 = 1;
        }
        for (; ; ) {
            long l1 = getSelectedItemId();
            localSavedState.a = l1;
            localSavedState.e = getWidth();
            if (l1 >= 0L) {
                localSavedState.c = this.J;
                localSavedState.d = getSelectedItemPosition();
                localSavedState.b = -1L;
                label219:
                localSavedState.f = null;
                if ((Build.VERSION.SDK_INT < 11) || (this.b != 3) || (this.c == null)) {
                    break label431;
                }
                localSavedState.g = bool;
                if (this.f == null) {
                }
            }
            try {
                localSavedState.i = this.f.clone();
                if (this.g != null) {
                    LongSparseArray localLongSparseArray = new LongSparseArray();
                    int i3 = this.g.size();
                    i1 = i2;
                    for (; ; ) {
                        if (i1 < i3) {
                            localLongSparseArray.put(this.g.keyAt(i1), this.g.valueAt(i1));
                            i1 += 1;
                            continue;
                            i1 = 0;
                            break;
                            if ((i1 != 0) && (this.V > 0)) {
                                localSavedState.c = getChildAt(0).getLeft();
                                i3 = this.V;
                                i1 = i3;
                                if (i3 >= this.an) {
                                    i1 = this.an - 1;
                                }
                                localSavedState.d = i1;
                                localSavedState.b = this.j.getItemId(i1);
                                break label219;
                            }
                            localSavedState.c = 0;
                            localSavedState.b = -1L;
                            localSavedState.d = 0;
                            break label219;
                            label431:
                            bool = false;
                        }
                    }
                }
            } catch (NoSuchMethodError localNoSuchMethodError) {
                for (; ; ) {
                    localNoSuchMethodError.printStackTrace();
                    localSavedState.i = new SparseBooleanArray();
                }
                localSavedState.j = localNoSuchMethodError;
                localSavedState.h = this.e;
            }
        }
        return localSavedState;
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (getChildCount() > 0) {
            this.ai = true;
            x();
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = true;
        int i1 = 0;
        boolean bool1;
        if (!isEnabled()) {
            if ((isClickable()) || (isLongClickable())) {
            }
            for (bool1 = true; ; bool1 = false) {
                return bool1;
            }
        }
        if (this.I != null) {
            this.I.a();
        }
        if (!this.S) {
            return false;
        }
        int i2 = paramMotionEvent.getAction();
        C();
        this.at.addMovement(paramMotionEvent);
        int i3;
        switch (i2 & 0xFF) {
            case 4:
            default:
                return true;
            case 0:
                switch (this.F) {
                    default:
                        this.aO = paramMotionEvent.getPointerId(0);
                        i2 = (int) paramMotionEvent.getX();
                        i3 = (int) paramMotionEvent.getY();
                        i1 = a(i2, i3);
                        if (!this.ai) {
                            if ((this.F != 4) && (i1 >= 0) && (((ListAdapter) getAdapter()).isEnabled(i1))) {
                                this.F = 0;
                                if (this.aB == null) {
                                    this.aB = new d();
                                }
                                postDelayed(this.aB, ViewConfiguration.getTapTimeout());
                            }
                        }
                        break;
                }
                break;
        }
        for (; ; ) {
            if (i1 >= 0) {
                this.B = getChildAt(i1 - this.V).getLeft();
            }
            this.D = i2;
            this.E = i3;
            this.A = i1;
            this.G = Integer.MIN_VALUE;
            for (; ; ) {
                bool1 = bool2;
                if (!a(paramMotionEvent)) {
                    break;
                }
                bool1 = bool2;
                if (this.F != 0) {
                    break;
                }
                removeCallbacks(this.aB);
                return true;
                this.au.b();
                if (this.I != null) {
                    this.I.a();
                }
                this.F = 5;
                this.E = ((int) paramMotionEvent.getY());
                i1 = (int) paramMotionEvent.getX();
                this.G = i1;
                this.D = i1;
                this.H = 0;
                this.aO = paramMotionEvent.getPointerId(0);
                this.aT = 0;
            }
            if (this.F == 4) {
                E();
                this.F = 3;
                this.H = 0;
                i1 = e(i2);
                this.au.c();
                continue;
                i2 = paramMotionEvent.findPointerIndex(this.aO);
                if (i2 == -1) {
                    this.aO = paramMotionEvent.getPointerId(0);
                }
                for (; ; ) {
                    i1 = (int) paramMotionEvent.getX(i1);
                    if (this.ai) {
                        f();
                    }
                    switch (this.F) {
                        case 4:
                        default:
                            return true;
                        case 0:
                        case 1:
                        case 2:
                            h(i1);
                            return true;
                    }
                    i(i1);
                    return true;
                    switch (this.F) {
                    }
                    for (; ; ) {
                        setPressed(false);
                        if (this.aP != null) {
                            this.aP.c();
                            this.aQ.c();
                        }
                        invalidate();
                        paramMotionEvent = getHandler();
                        if (paramMotionEvent != null) {
                            paramMotionEvent.removeCallbacks(this.aA);
                        }
                        D();
                        this.aO = -1;
                        return true;
                        i2 = this.A;
                        final View localView = getChildAt(i2 - this.V);
                        float f1 = paramMotionEvent.getX();
                        final i locali;
                        Handler localHandler;
                        if ((f1 > this.u.left) && (f1 < getWidth() - this.u.right)) {
                            i1 = 1;
                            if ((localView == null) || (localView.hasFocusable()) || (i1 == 0)) {
                                break label1019;
                            }
                            if (this.F != 0) {
                                localView.setPressed(false);
                            }
                            if (this.aD == null) {
                                this.aD = new i(null);
                            }
                            locali = this.aD;
                            locali.a = i2;
                            locali.a();
                            this.M = i2;
                            if ((this.F != 0) && (this.F != 1)) {
                                break label993;
                            }
                            localHandler = getHandler();
                            if (localHandler != null) {
                                if (this.F != 0) {
                                    break label974;
                                }
                            }
                        }
                        label974:
                        for (paramMotionEvent = this.aB; ; paramMotionEvent = this.aA) {
                            localHandler.removeCallbacks(paramMotionEvent);
                            this.h = 0;
                            if ((this.ai) || (!this.j.isEnabled(i2))) {
                                break label982;
                            }
                            this.F = 1;
                            setSelectedPositionInt(this.A);
                            f();
                            localView.setPressed(true);
                            a(this.A, localView);
                            setPressed(true);
                            if (this.m != null) {
                                paramMotionEvent = this.m.getCurrent();
                                if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TransitionDrawable))) {
                                    ((TransitionDrawable) paramMotionEvent).resetTransition();
                                }
                            }
                            if (this.aE != null) {
                                removeCallbacks(this.aE);
                            }
                            this.aE = new Runnable() {
                                public void run() {
                                    AbsHListView.this.F = -1;
                                    localView.setPressed(false);
                                    AbsHListView.this.setPressed(false);
                                    if (!AbsHListView.this.ai) {
                                        locali.run();
                                    }
                                }
                            };
                            postDelayed(this.aE, ViewConfiguration.getPressedStateDuration());
                            return true;
                            i1 = 0;
                            break;
                        }
                        label982:
                        this.F = -1;
                        k();
                        return true;
                        label993:
                        if ((!this.ai) && (this.j.isEnabled(i2))) {
                            locali.run();
                        }
                        label1019:
                        this.F = -1;
                        k();
                        continue;
                        i1 = getChildCount();
                        if (i1 > 0) {
                            i2 = getChildAt(0).getLeft();
                            i3 = getChildAt(i1 - 1).getRight();
                            int i4 = this.u.left;
                            int i5 = getWidth() - this.u.right;
                            if ((this.V == 0) && (i2 >= i4) && (this.V + i1 < this.an) && (i3 <= getWidth() - i5)) {
                                this.F = -1;
                                b(0);
                            } else {
                                paramMotionEvent = this.at;
                                paramMotionEvent.computeCurrentVelocity(1000, this.aM);
                                int i6 = (int) (paramMotionEvent.getXVelocity(this.aO) * this.aN);
                                if ((Math.abs(i6) > this.aL) && ((this.V != 0) || (i2 != i4 - this.Q)) && ((i1 + this.V != this.an) || (i3 != this.Q + i5))) {
                                    if (this.au == null) {
                                        this.au = new e();
                                    }
                                    b(2);
                                    this.au.a(-i6);
                                } else {
                                    this.F = -1;
                                    b(0);
                                    if (this.au != null) {
                                        this.au.b();
                                    }
                                    if (this.I != null) {
                                        this.I.a();
                                    }
                                }
                            }
                        } else {
                            this.F = -1;
                            b(0);
                            continue;
                            if (this.au == null) {
                                this.au = new e();
                            }
                            paramMotionEvent = this.at;
                            paramMotionEvent.computeCurrentVelocity(1000, this.aM);
                            i1 = (int) paramMotionEvent.getXVelocity(this.aO);
                            b(2);
                            if (Math.abs(i1) > this.aL) {
                                this.au.b(-i1);
                            } else {
                                this.au.a();
                            }
                        }
                    }
                    switch (this.F) {
                        default:
                            this.F = -1;
                            setPressed(false);
                            paramMotionEvent = getChildAt(this.A - this.V);
                            if (paramMotionEvent != null) {
                                paramMotionEvent.setPressed(false);
                            }
                            F();
                            paramMotionEvent = getHandler();
                            if (paramMotionEvent != null) {
                                paramMotionEvent.removeCallbacks(this.aA);
                            }
                            D();
                    }
                    for (; ; ) {
                        if (this.aP != null) {
                            this.aP.c();
                            this.aQ.c();
                        }
                        this.aO = -1;
                        return true;
                        if (this.au == null) {
                            this.au = new e();
                        }
                        this.au.a();
                    }
                    b(paramMotionEvent);
                    i1 = this.D;
                    i2 = a(i1, this.E);
                    if (i2 >= 0) {
                        this.B = getChildAt(i2 - this.V).getLeft();
                        this.A = i2;
                    }
                    this.G = i1;
                    return true;
                    i3 = paramMotionEvent.getActionIndex();
                    i2 = paramMotionEvent.getPointerId(i3);
                    i1 = (int) paramMotionEvent.getX(i3);
                    i3 = (int) paramMotionEvent.getY(i3);
                    this.H = 0;
                    this.aO = i2;
                    this.D = i1;
                    this.E = i3;
                    i2 = a(i1, i3);
                    if (i2 >= 0) {
                        this.B = getChildAt(i2 - this.V).getLeft();
                        this.A = i2;
                    }
                    this.G = i1;
                    return true;
                    i1 = i2;
                }
            }
        }
    }

    public void onTouchModeChanged(boolean paramBoolean) {
        if (paramBoolean) {
            m();
            if ((getWidth() > 0) && (getChildCount() > 0)) {
                f();
            }
            k();
        }
        do {
            int i1;
            do {
                return;
                i1 = this.F;
            } while ((i1 != 5) && (i1 != 6));
            if (this.au != null) {
                this.au.b();
            }
            if (this.I != null) {
                this.I.a();
            }
        } while (getScrollX() == 0);
        this.a.a(0);
        G();
        invalidate();
    }

    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        int i1;
        if (isInTouchMode()) {
            i1 = 0;
            if (paramBoolean) {
                break label107;
            }
            setChildrenDrawingCacheEnabled(false);
            if (this.au != null) {
                removeCallbacks(this.au);
                this.au.b();
                if (this.I != null) {
                    this.I.a();
                }
                if (getScrollX() != 0) {
                    this.a.a(0);
                    G();
                    invalidate();
                }
            }
            if (i1 == 1) {
                this.M = this.al;
            }
        }
        for (; ; ) {
            this.az = i1;
            return;
            i1 = 1;
            break;
            label107:
            if ((i1 != this.az) && (this.az != -1)) {
                if (i1 == 1) {
                    p();
                } else {
                    m();
                    this.h = 0;
                    f();
                }
            }
        }
    }

    boolean p() {
        boolean bool2 = true;
        int i7 = getChildCount();
        if (i7 <= 0) {
            return false;
        }
        int i1 = this.u.left;
        int i2 = getRight() - getLeft() - this.u.right;
        int i6 = this.V;
        int i3 = this.M;
        View localView;
        int i4;
        int i5;
        boolean bool1;
        if ((i3 >= i6) && (i3 < i6 + i7)) {
            localView = getChildAt(i3 - this.V);
            i4 = localView.getLeft();
            i5 = localView.getRight();
            if (i4 < i1) {
                i1 = getHorizontalFadingEdgeLength() + i1;
            }
            for (; ; ) {
                bool1 = true;
                i2 = i3;
                this.M = -1;
                removeCallbacks(this.au);
                if (this.I != null) {
                    this.I.a();
                }
                this.F = -1;
                F();
                this.W = i1;
                i1 = b(i2, bool1);
                if ((i1 < i6) || (i1 > getLastVisiblePosition())) {
                    break;
                }
                this.h = 4;
                k();
                setSelectionInt(i1);
                c();
                label194:
                b(0);
                if (i1 < 0) {
                    break label431;
                }
                bool1 = bool2;
                label207:
                return bool1;
                i1 = i4;
                if (i5 > i2) {
                    i1 = i2 - localView.getMeasuredWidth() - getHorizontalFadingEdgeLength();
                }
            }
        }
        if (i3 < i6) {
            i4 = 0;
            i2 = 0;
            label246:
            if (i4 >= i7) {
                break label477;
            }
            i3 = getChildAt(i4).getLeft();
            if (i4 != 0) {
                break label474;
            }
            if ((i6 <= 0) && (i3 >= i1)) {
                break label469;
            }
            i1 = getHorizontalFadingEdgeLength() + i1;
            i2 = i3;
            label287:
            if (i3 >= i1) {
                i1 = i6 + i4;
            }
        }
        for (; ; ) {
            bool1 = true;
            i2 = i1;
            i1 = i3;
            break;
            i4 += 1;
            break label246;
            int i8 = this.an;
            i4 = i7 - 1;
            i1 = 0;
            label331:
            if (i4 >= 0) {
                localView = getChildAt(i4);
                i3 = localView.getLeft();
                int i9 = localView.getRight();
                if (i4 == i7 - 1) {
                    if ((i6 + i7 < i8) || (i9 > i2)) {
                        i1 = i2 - getHorizontalFadingEdgeLength();
                        i2 = i3;
                    }
                }
                for (; ; ) {
                    if (i9 <= i1) {
                        i1 = i3;
                        i2 = i6 + i4;
                        bool1 = false;
                        break;
                    }
                    i4 -= 1;
                    i3 = i1;
                    i1 = i2;
                    i2 = i3;
                    break label331;
                    i1 = -1;
                    break label194;
                    label431:
                    bool1 = false;
                    break label207;
                    i1 = i2;
                    i2 = i3;
                    continue;
                    i5 = i1;
                    i1 = i2;
                    i2 = i5;
                }
            }
            i2 = i6 + i7 - 1;
            bool1 = false;
            break;
            label469:
            i2 = i3;
            break label287;
            label474:
            break label287;
            label477:
            i1 = i6;
            i3 = i2;
        }
    }

    @TargetApi(14)
    public boolean performAccessibilityAction(int paramInt, Bundle paramBundle) {
        if (super.performAccessibilityAction(paramInt, paramBundle)) {
            return true;
        }
        switch (paramInt) {
            default:
                return false;
            case 4096:
                if ((isEnabled()) && (getLastVisiblePosition() < getCount() - 1)) {
                    b(getWidth() - this.u.left - this.u.right, 200);
                    return true;
                }
                return false;
        }
        if ((isEnabled()) && (this.V > 0)) {
            b(-(getWidth() - this.u.left - this.u.right), 200);
            return true;
        }
        return false;
    }

    @TargetApi(16)
    void q() {
        this.f.clear();
        int i1 = 0;
        int i2 = 0;
        long l1;
        int i5;
        int i3;
        if (i1 < this.g.size()) {
            l1 = this.g.keyAt(i1);
            i5 = ((Integer) this.g.valueAt(i1)).intValue();
            if (l1 != this.j.getItemId(i5)) {
                i3 = Math.max(0, i5 - 20);
                i4 = Math.min(i5 + 20, this.an);
                label89:
                if (i3 >= i4) {
                    break label268;
                }
                if (l1 == this.j.getItemId(i3)) {
                    this.f.put(i3, true);
                    this.g.setValueAt(i1, Integer.valueOf(i3));
                }
            }
        }
        label268:
        for (int i4 = 1; ; i4 = 0) {
            i3 = i1;
            if (i4 == 0) {
                this.g.delete(l1);
                this.e -= 1;
                if ((Build.VERSION.SDK_INT > 11) && (this.c != null) && (this.d != null)) {
                    ((b) this.d).a((ActionMode) this.c, i5, l1, false);
                }
                i3 = i1 - 1;
                i2 = 1;
            }
            for (i1 = i2; ; i1 = i2) {
                i2 = i1;
                i1 = i3 + 1;
                break;
                i3 += 1;
                break label89;
                this.f.put(i5, true);
                i3 = i1;
            }
            if ((i2 != 0) && (this.c != null)) {
                ((ActionMode) this.c).invalidate();
            }
            return;
        }
    }

    protected void r() {
        int i3 = this.an;
        int i4 = this.ba;
        this.ba = this.an;
        if ((Build.VERSION.SDK_INT >= 16) && (this.b != 0) && (this.j != null) && (this.j.hasStableIds())) {
            q();
        }
        this.p.c();
        if (i3 > 0) {
            if (this.ac) {
                this.ac = false;
                this.bb = null;
                if (this.aF == 2) {
                    this.h = 3;
                }
            }
            do {
                return;
                int i2;
                if (this.aF == 1) {
                    if (this.aU) {
                        this.aU = false;
                        this.h = 3;
                        return;
                    }
                    int i5 = getChildCount();
                    i2 = getWidth() - getPaddingRight();
                    View localView = getChildAt(i5 - 1);
                    if (localView != null) {
                    }
                    for (i1 = localView.getBottom(); (i5 + this.V >= i4) && (i1 <= i2); i1 = i2) {
                        this.h = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                switch (this.ad) {
                }
                while (!isInTouchMode()) {
                    i2 = getSelectedItemPosition();
                    i1 = i2;
                    if (i2 >= i3) {
                        i1 = i3 - 1;
                    }
                    i2 = i1;
                    if (i1 < 0) {
                        i2 = 0;
                    }
                    i1 = b(i2, true);
                    if (i1 >= 0) {
                        setNextSelectedPositionInt(i1);
                        return;
                        if (isInTouchMode()) {
                            this.h = 5;
                            this.Z = Math.min(Math.max(0, this.Z), i3 - 1);
                            return;
                        }
                        i1 = w();
                        if ((i1 >= 0) && (b(i1, true) == i1)) {
                            this.Z = i1;
                            if (this.ab == getWidth()) {
                            }
                            for (this.h = 5; ; this.h = 2) {
                                setNextSelectedPositionInt(i1);
                                return;
                            }
                            this.h = 5;
                            this.Z = Math.min(Math.max(0, this.Z), i3 - 1);
                        }
                    } else {
                        i1 = b(i2, false);
                        if (i1 < 0) {
                            break label403;
                        }
                        setNextSelectedPositionInt(i1);
                        return;
                    }
                }
            } while (this.M >= 0);
        }
        label403:
        if (this.K) {
        }
        for (int i1 = 3; ; i1 = 1) {
            this.h = i1;
            this.al = -1;
            this.am = Long.MIN_VALUE;
            this.aj = -1;
            this.ak = Long.MIN_VALUE;
            this.ac = false;
            this.bb = null;
            this.n = -1;
            v();
            return;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
        if (paramBoolean) {
            D();
        }
        super.requestDisallowInterceptTouchEvent(paramBoolean);
    }

    public void requestLayout() {
        if ((!this.as) && (!this.ae)) {
            super.requestLayout();
        }
    }

    public void sendAccessibilityEvent(int paramInt) {
        if (paramInt == 4096) {
            int i1 = getFirstVisiblePosition();
            int i2 = getLastVisiblePosition();
            if ((this.aY == i1) && (this.aZ == i2)) {
                return;
            }
            this.aY = i1;
            this.aZ = i2;
        }
        super.sendAccessibilityEvent(paramInt);
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (paramListAdapter != null) {
            this.k = this.j.hasStableIds();
            if ((this.b != 0) && (this.k) && (this.g == null)) {
                this.g = new LongSparseArray();
            }
        }
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            this.g.clear();
        }
    }

    public void setCacheColorHint(int paramInt) {
        if (paramInt != this.aG) {
            this.aG = paramInt;
            int i2 = getChildCount();
            int i1 = 0;
            while (i1 < i2) {
                getChildAt(i1).setDrawingCacheBackgroundColor(paramInt);
                i1 += 1;
            }
            this.p.f(paramInt);
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int paramInt) {
        this.b = paramInt;
        if ((Build.VERSION.SDK_INT >= 11) && (this.c != null)) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.c).finish();
            }
            this.c = null;
        }
        if (this.b != 0) {
            if (this.f == null) {
                this.f = new SparseBooleanArray();
            }
            if ((this.g == null) && (this.j != null) && (this.j.hasStableIds())) {
                this.g = new LongSparseArray();
            }
            if ((Build.VERSION.SDK_INT >= 11) && (this.b == 3)) {
                b();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean paramBoolean) {
        this.l = paramBoolean;
    }

    public void setFriction(float paramFloat) {
        if (this.au == null) {
            this.au = new e();
        }
        e.a(this.au).b(paramFloat);
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(com.everimaging.fotorsdk.widget.lib.hlist.util.v11.a parama) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.d == null) {
                this.d = new b(this);
            }
            ((b) this.d).a(parama);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    public void setOnScrollListener(h paramh) {
        this.av = paramh;
        c();
    }

    public void setOverScrollMode(int paramInt) {
        Context localContext;
        if (paramInt != 2) {
            if (this.aP == null) {
                localContext = getContext();
                this.aP = new a(localContext, 1);
            }
        }
        for (this.aQ = new a(localContext, 1); ; this.aQ = null) {
            super.setOverScrollMode(paramInt);
            return;
            this.aP = null;
        }
    }

    public void setRecyclerListener(l paraml) {
        k.a(this.p, paraml);
    }

    public void setScrollingCacheEnabled(boolean paramBoolean) {
        if ((this.L) && (!paramBoolean)) {
            F();
        }
        this.L = paramBoolean;
    }

    public abstract void setSelectionInt(int paramInt);

    public void setSelector(int paramInt) {
        setSelector(getResources().getDrawable(paramInt));
    }

    public void setSelector(Drawable paramDrawable) {
        if (this.m != null) {
            this.m.setCallback(null);
            unscheduleDrawable(this.m);
        }
        this.m = paramDrawable;
        Rect localRect = new Rect();
        paramDrawable.getPadding(localRect);
        this.q = localRect.left;
        this.r = localRect.top;
        this.s = localRect.right;
        this.t = localRect.bottom;
        paramDrawable.setCallback(this);
        k();
    }

    public void setSmoothScrollbarEnabled(boolean paramBoolean) {
        this.aw = paramBoolean;
    }

    public void setStackFromRight(boolean paramBoolean) {
        if (this.K != paramBoolean) {
            this.K = paramBoolean;
            d();
        }
    }

    public void setTranscriptMode(int paramInt) {
        this.aF = paramInt;
    }

    public void setVelocityScale(float paramFloat) {
        this.aN = paramFloat;
    }

    public boolean showContextMenuForChild(View paramView) {
        boolean bool1 = false;
        boolean bool2 = false;
        int i1 = a(paramView);
        if (i1 >= 0) {
            long l1 = this.j.getItemId(i1);
            if (this.ah != null) {
                bool2 = this.ah.a(this, paramView, i1, l1);
            }
            bool1 = bool2;
            if (!bool2) {
                this.ay = b(getChildAt(i1 - this.V), i1, l1);
                bool1 = super.showContextMenuForChild(paramView);
            }
        }
        return bool1;
    }

    public boolean verifyDrawable(Drawable paramDrawable) {
        return (this.m == paramDrawable) || (super.verifyDrawable(paramDrawable));
    }

    static class SavedState
            extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {
            public AbsHListView.SavedState a(Parcel paramAnonymousParcel) {
                return new AbsHListView.SavedState(paramAnonymousParcel, null);
            }

            public AbsHListView.SavedState[] a(int paramAnonymousInt) {
                return new AbsHListView.SavedState[paramAnonymousInt];
            }
        };
        long a;
        long b;
        int c;
        int d;
        int e;
        String f;
        boolean g;
        int h;
        SparseBooleanArray i;
        LongSparseArray<Integer> j;

        private SavedState(Parcel paramParcel) {
            super();
            this.a = paramParcel.readLong();
            this.b = paramParcel.readLong();
            this.c = paramParcel.readInt();
            this.d = paramParcel.readInt();
            this.e = paramParcel.readInt();
            this.f = paramParcel.readString();
            if (paramParcel.readByte() != 0) {
            }
            for (boolean bool = true; ; bool = false) {
                this.g = bool;
                this.h = paramParcel.readInt();
                this.i = paramParcel.readSparseBooleanArray();
                int m = paramParcel.readInt();
                if (m <= 0) {
                    break;
                }
                this.j = new LongSparseArray();
                while (k < m) {
                    long l = paramParcel.readLong();
                    int n = paramParcel.readInt();
                    this.j.put(l, Integer.valueOf(n));
                    k += 1;
                }
            }
        }

        SavedState(Parcelable paramParcelable) {
            super();
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.a + " firstId=" + this.b + " viewLeft=" + this.c + " position=" + this.d + " width=" + this.e + " filter=" + this.f + " checkState=" + this.i + "}";
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            int k = 0;
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeLong(this.a);
            paramParcel.writeLong(this.b);
            paramParcel.writeInt(this.c);
            paramParcel.writeInt(this.d);
            paramParcel.writeInt(this.e);
            paramParcel.writeString(this.f);
            if (this.g) {
                paramInt = 1;
                paramParcel.writeByte((byte) paramInt);
                paramParcel.writeInt(this.h);
                paramParcel.writeSparseBooleanArray(this.i);
                if (this.j == null) {
                    break label154;
                }
            }
            label154:
            for (paramInt = this.j.size(); ; paramInt = 0) {
                paramParcel.writeInt(paramInt);
                while (k < paramInt) {
                    paramParcel.writeLong(this.j.keyAt(k));
                    paramParcel.writeInt(((Integer) this.j.valueAt(k)).intValue());
                    k += 1;
                }
                paramInt = 0;
                break;
            }
        }
    }

    public class a
            extends AdapterView.b {
        public a() {
            super();
        }

        public void onChanged() {
            Log.i("AbsListView", "onChanged");
            super.onChanged();
        }

        public void onInvalidated() {
            Log.i("AbsListView", "onInvalidated");
            super.onInvalidated();
        }
    }

    private class b
            extends AbsHListView.n
            implements Runnable {
        private b() {
            super(null);
        }

        public void run() {
            View localView;
            if ((AbsHListView.this.isPressed()) && (AbsHListView.this.al >= 0)) {
                int i = AbsHListView.this.al;
                int j = AbsHListView.this.V;
                localView = AbsHListView.this.getChildAt(i - j);
                if (AbsHListView.this.ai) {
                    break label108;
                }
                if (!b()) {
                    break label128;
                }
            }
            label108:
            label128:
            for (boolean bool = AbsHListView.this.c(localView, AbsHListView.this.al, AbsHListView.this.am); ; bool = false) {
                if (bool) {
                    AbsHListView.this.setPressed(false);
                    localView.setPressed(false);
                }
                do {
                    return;
                    AbsHListView.this.setPressed(false);
                } while (localView == null);
                localView.setPressed(false);
                return;
            }
        }
    }

    private class c
            extends AbsHListView.n
            implements Runnable {
        private c() {
            super(null);
        }

        public void run() {
            int i = AbsHListView.this.A;
            View localView = AbsHListView.this.getChildAt(i - AbsHListView.this.V);
            long l;
            if (localView != null) {
                i = AbsHListView.this.A;
                l = AbsHListView.this.j.getItemId(AbsHListView.this.A);
                if ((!b()) || (AbsHListView.this.ai)) {
                    break label126;
                }
            }
            label126:
            for (boolean bool = AbsHListView.this.c(localView, i, l); ; bool = false) {
                if (bool) {
                    AbsHListView.this.F = -1;
                    AbsHListView.this.setPressed(false);
                    localView.setPressed(false);
                    return;
                }
                AbsHListView.this.F = 2;
                return;
            }
        }
    }

    final class d
            implements Runnable {
        d() {
        }

        public void run() {
            Object localObject;
            int i;
            boolean bool;
            if (AbsHListView.this.F == 0) {
                AbsHListView.this.F = 1;
                localObject = AbsHListView.this.getChildAt(AbsHListView.this.A - AbsHListView.this.V);
                if ((localObject != null) && (!((View) localObject).hasFocusable())) {
                    AbsHListView.this.h = 0;
                    if (AbsHListView.this.ai) {
                        break label249;
                    }
                    ((View) localObject).setPressed(true);
                    AbsHListView.this.setPressed(true);
                    AbsHListView.this.f();
                    AbsHListView.this.a(AbsHListView.this.A, (View) localObject);
                    AbsHListView.this.refreshDrawableState();
                    i = ViewConfiguration.getLongPressTimeout();
                    bool = AbsHListView.this.isLongClickable();
                    if (AbsHListView.this.m != null) {
                        localObject = AbsHListView.this.m.getCurrent();
                        if ((localObject != null) && ((localObject instanceof TransitionDrawable))) {
                            if (!bool) {
                                break label230;
                            }
                            ((TransitionDrawable) localObject).startTransition(i);
                        }
                    }
                }
            }
            while (bool) {
                if (AbsHListView.c(AbsHListView.this) == null) {
                    AbsHListView.a(AbsHListView.this, new AbsHListView.c(AbsHListView.this, null));
                }
                AbsHListView.c(AbsHListView.this).a();
                AbsHListView.this.postDelayed(AbsHListView.c(AbsHListView.this), i);
                return;
                label230:
                ((TransitionDrawable) localObject).resetTransition();
            }
            AbsHListView.this.F = 2;
            return;
            label249:
            AbsHListView.this.F = 2;
        }
    }

    private class e
            implements Runnable {
        private final c b = new c(AbsHListView.this.getContext());
        private int c;
        private final Runnable d = new Runnable() {
            public void run() {
                int i = AbsHListView.d(AbsHListView.this);
                VelocityTracker localVelocityTracker = AbsHListView.e(AbsHListView.this);
                c localc = AbsHListView.e.a(AbsHListView.e.this);
                if ((localVelocityTracker == null) || (i == -1)) {
                    return;
                }
                localVelocityTracker.computeCurrentVelocity(1000, AbsHListView.f(AbsHListView.this));
                float f = -localVelocityTracker.getXVelocity(i);
                if ((Math.abs(f) >= AbsHListView.g(AbsHListView.this)) && (localc.a(f, 0.0F))) {
                    AbsHListView.this.postDelayed(this, 40L);
                    return;
                }
                AbsHListView.e.this.b();
                AbsHListView.this.F = 3;
                AbsHListView.this.b(1);
            }
        };

        e() {
        }

        void a() {
            if (this.b.a(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.F = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.a.a(this);
                return;
            }
            AbsHListView.this.F = -1;
            AbsHListView.this.b(0);
        }

        void a(int paramInt) {
            if (paramInt < 0) {
            }
            for (int i = Integer.MAX_VALUE; ; i = 0) {
                this.c = i;
                this.b.a(null);
                this.b.a(i, 0, paramInt, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                AbsHListView.this.F = 4;
                AbsHListView.this.a.a(this);
                return;
            }
        }

        void a(int paramInt1, int paramInt2, boolean paramBoolean) {
            int i;
            c localc;
            if (paramInt1 < 0) {
                i = Integer.MAX_VALUE;
                this.c = i;
                localc = this.b;
                if (!paramBoolean) {
                    break label75;
                }
            }
            label75:
            for (Interpolator localInterpolator = AbsHListView.T; ; localInterpolator = null) {
                localc.a(localInterpolator);
                this.b.a(i, 0, paramInt1, 0, paramInt2);
                AbsHListView.this.F = 4;
                AbsHListView.this.a.a(this);
                return;
                i = 0;
                break;
            }
        }

        void b() {
            AbsHListView.this.F = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.d);
            AbsHListView.this.b(0);
            AbsHListView.k(AbsHListView.this);
            this.b.e();
            AbsHListView.a(AbsHListView.this, 0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void b(int paramInt) {
            this.b.a(null);
            this.b.a(AbsHListView.this.getScrollX(), 0, paramInt, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.F = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.a.a(this);
        }

        void c() {
            AbsHListView.this.postDelayed(this.d, 40L);
        }

        void c(int paramInt) {
            this.b.a(AbsHListView.this.getScrollX(), 0, AbsHListView.this.R);
            int i = AbsHListView.this.getOverScrollMode();
            if ((i == 0) || ((i == 1) && (!AbsHListView.h(AbsHListView.this)))) {
                AbsHListView.this.F = 6;
                i = (int) this.b.c();
                if (paramInt > 0) {
                    AbsHListView.i(AbsHListView.this).a(i);
                }
            }
            for (; ; ) {
                AbsHListView.this.invalidate();
                AbsHListView.this.a.a(this);
                return;
                AbsHListView.j(AbsHListView.this).a(i);
                continue;
                AbsHListView.this.F = -1;
                if (AbsHListView.this.I != null) {
                    AbsHListView.this.I.a();
                }
            }
        }

        public void run() {
            int k = 1;
            int m = 0;
            Object localObject;
            boolean bool1;
            int i;
            switch (AbsHListView.this.F) {
                case 5:
                default:
                    b();
                case 3:
                    do {
                        return;
                    } while (this.b.a());
                case 4:
                    if (AbsHListView.this.ai) {
                        AbsHListView.this.f();
                    }
                    if ((AbsHListView.this.an == 0) || (AbsHListView.this.getChildCount() == 0)) {
                        b();
                        return;
                    }
                    localObject = this.b;
                    bool1 = ((c) localObject).d();
                    m = ((c) localObject).b();
                    i = this.c - m;
                    if (i > 0) {
                        AbsHListView.this.A = AbsHListView.this.V;
                        localObject = AbsHListView.this.getChildAt(0);
                        AbsHListView.this.B = ((View) localObject).getLeft();
                        i = Math.min(AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight() - AbsHListView.this.getPaddingLeft() - 1, i);
                        label199:
                        localObject = AbsHListView.this.getChildAt(AbsHListView.this.A - AbsHListView.this.V);
                        if (localObject == null) {
                            break label599;
                        }
                    }
                    break;
            }
            label401:
            label599:
            for (int j = ((View) localObject).getLeft(); ; j = 0) {
                boolean bool2 = AbsHListView.this.c(i, i);
                if ((bool2) && (i != 0)) {
                }
                for (; ; ) {
                    if (k == 0) {
                        break label401;
                    }
                    if (localObject != null) {
                        j = -(i - (((View) localObject).getLeft() - j));
                        AbsHListView.b(AbsHListView.this, j, 0, AbsHListView.this.getScrollX(), 0, 0, 0, AbsHListView.this.R, 0, false);
                    }
                    if (!bool1) {
                        break;
                    }
                    c(i);
                    return;
                    j = AbsHListView.this.getChildCount() - 1;
                    AbsHListView.this.A = (AbsHListView.this.V + j);
                    localObject = AbsHListView.this.getChildAt(j);
                    AbsHListView.this.B = ((View) localObject).getLeft();
                    i = Math.max(-(AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight() - AbsHListView.this.getPaddingLeft() - 1), i);
                    break label199;
                    k = 0;
                }
                if ((bool1) && (k == 0)) {
                    if (bool2) {
                        AbsHListView.this.invalidate();
                    }
                    this.c = m;
                    AbsHListView.this.a.a(this);
                    return;
                }
                b();
                return;
                localObject = this.b;
                if (((c) localObject).d()) {
                    k = AbsHListView.this.getScrollX();
                    int n = ((c) localObject).b();
                    if (AbsHListView.c(AbsHListView.this, n - k, 0, k, 0, 0, 0, AbsHListView.this.R, 0, false)) {
                        if ((k <= 0) && (n > 0)) {
                        }
                        for (j = 1; ; j = 0) {
                            i = m;
                            if (k >= 0) {
                                i = m;
                                if (n < 0) {
                                    i = 1;
                                }
                            }
                            if ((j == 0) && (i == 0)) {
                                break;
                            }
                            k = (int) ((c) localObject).c();
                            j = k;
                            if (i != 0) {
                                j = -k;
                            }
                            ((c) localObject).e();
                            a(j);
                            return;
                        }
                        a();
                        return;
                    }
                    AbsHListView.this.invalidate();
                    AbsHListView.this.a.a(this);
                    return;
                }
                b();
                return;
            }
        }
    }

    public static class f
            extends ViewGroup.LayoutParams {
        public int a;
        public boolean b;
        public boolean c;
        public int d;
        public long e = -1L;

        public f(int paramInt1, int paramInt2) {
            super(paramInt2);
        }

        public f(int paramInt1, int paramInt2, int paramInt3) {
            super(paramInt2);
            this.a = paramInt3;
        }

        public f(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
        }

        public f(ViewGroup.LayoutParams paramLayoutParams) {
            super();
        }
    }

    @TargetApi(14)
    class g
            extends AccessibilityDelegateCompat {
        g() {
        }

        public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
            int i = AbsHListView.this.a(paramView);
            paramView = (ListAdapter) AbsHListView.this.getAdapter();
            if ((i == -1) || (paramView == null)) {
                break label35;
            }
            label35:
            while ((!AbsHListView.this.isEnabled()) || (!paramView.isEnabled(i))) {
                return;
            }
            if (i == AbsHListView.this.getSelectedItemPosition()) {
                paramAccessibilityNodeInfoCompat.setSelected(true);
                paramAccessibilityNodeInfoCompat.addAction(8);
            }
            for (; ; ) {
                if (AbsHListView.this.isClickable()) {
                    paramAccessibilityNodeInfoCompat.addAction(16);
                    paramAccessibilityNodeInfoCompat.setClickable(true);
                }
                if (!AbsHListView.this.isLongClickable()) {
                    break;
                }
                paramAccessibilityNodeInfoCompat.addAction(32);
                paramAccessibilityNodeInfoCompat.setLongClickable(true);
                return;
                paramAccessibilityNodeInfoCompat.addAction(4);
            }
        }

        public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle) {
            if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
                return true;
            }
            int i = AbsHListView.this.a(paramView);
            paramBundle = (ListAdapter) AbsHListView.this.getAdapter();
            if ((i == -1) || (paramBundle == null)) {
                return false;
            }
            if ((!AbsHListView.this.isEnabled()) || (!paramBundle.isEnabled(i))) {
                return false;
            }
            long l = AbsHListView.this.g(i);
            switch (paramInt) {
                default:
                    return false;
                case 8:
                    if (AbsHListView.this.getSelectedItemPosition() == i) {
                        AbsHListView.this.setSelection(-1);
                        return true;
                    }
                    return false;
                case 4:
                    if (AbsHListView.this.getSelectedItemPosition() != i) {
                        AbsHListView.this.setSelection(i);
                        return true;
                    }
                    return false;
                case 16:
                    if (AbsHListView.this.isClickable()) {
                        return AbsHListView.this.a(paramView, i, l);
                    }
                    return false;
            }
            if (AbsHListView.this.isLongClickable()) {
                return AbsHListView.this.c(paramView, i, l);
            }
            return false;
        }
    }

    public static abstract interface h {
        public abstract void a(AbsHListView paramAbsHListView, int paramInt);

        public abstract void a(AbsHListView paramAbsHListView, int paramInt1, int paramInt2, int paramInt3);
    }

    private class i
            extends AbsHListView.n
            implements Runnable {
        int a;

        private i() {
            super(null);
        }

        public void run() {
            if (AbsHListView.this.ai) {
            }
            ListAdapter localListAdapter;
            int i;
            View localView;
            do {
                do {
                    return;
                    localListAdapter = AbsHListView.this.j;
                    i = this.a;
                }
                while ((localListAdapter == null) || (AbsHListView.this.an <= 0) || (i == -1) || (i >= localListAdapter.getCount()) || (!b()));
                localView = AbsHListView.this.getChildAt(i - AbsHListView.this.V);
            } while (localView == null);
            AbsHListView.this.a(localView, i, localListAdapter.getItemId(i));
        }
    }

    public class j
            implements Runnable {
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private final int g = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        private int h;

        j() {
        }

        public void a() {
            AbsHListView.this.removeCallbacks(this);
        }

        void a(final int paramInt) {
            a();
            if (AbsHListView.this.ai) {
                AbsHListView.this.O = new Runnable() {
                    public void run() {
                        AbsHListView.j.this.a(paramInt);
                    }
                };
            }
            do {
                return;
                i = AbsHListView.this.getChildCount();
            } while (i == 0);
            int j = AbsHListView.this.V;
            int k = i + j - 1;
            int i = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, paramInt));
            if (i < j) {
                paramInt = j - i + 1;
                this.b = 2;
                if (paramInt <= 0) {
                    break label163;
                }
            }
            label163:
            for (this.f = (200 / paramInt); ; this.f = 200) {
                this.c = i;
                this.d = -1;
                this.e = -1;
                AbsHListView.this.a.a(this);
                return;
                if (i > k) {
                    paramInt = i - k + 1;
                    this.b = 1;
                    break;
                }
                a(i, -1, 200);
                return;
            }
        }

        void a(int paramInt1, int paramInt2, int paramInt3) {
            int m = AbsHListView.this.V;
            int n = AbsHListView.this.getChildCount() + m - 1;
            int j = AbsHListView.this.u.left;
            int k = AbsHListView.this.getWidth() - AbsHListView.this.u.right;
            if ((paramInt1 < m) || (paramInt1 > n)) {
                Log.w("AbsListView", "scrollToVisible called with targetPos " + paramInt1 + " not visible [" + m + ", " + n + "]");
            }
            int i;
            if (paramInt2 >= m) {
                i = paramInt2;
                if (paramInt2 <= n) {
                }
            } else {
                i = -1;
            }
            View localView = AbsHListView.this.getChildAt(paramInt1 - m);
            paramInt2 = localView.getLeft();
            paramInt1 = localView.getRight();
            if (paramInt1 > k) {
                paramInt1 -= k;
            }
            for (; ; ) {
                if (paramInt2 < j) {
                    paramInt1 = paramInt2 - j;
                }
                if (paramInt1 == 0) {
                    return;
                }
                paramInt2 = paramInt1;
                if (i >= 0) {
                    localView = AbsHListView.this.getChildAt(i - m);
                    i = localView.getLeft();
                    paramInt2 = localView.getRight();
                    m = Math.abs(paramInt1);
                    if ((paramInt1 >= 0) || (paramInt2 + m <= k)) {
                        break label259;
                    }
                    paramInt2 = Math.max(0, paramInt2 - k);
                }
                for (; ; ) {
                    AbsHListView.this.b(paramInt2, paramInt3);
                    return;
                    label259:
                    paramInt2 = paramInt1;
                    if (paramInt1 > 0) {
                        paramInt2 = paramInt1;
                        if (i - m < j) {
                            paramInt2 = Math.min(0, i - j);
                        }
                    }
                }
                paramInt1 = 0;
            }
        }

        public void run() {
            int i = 0;
            int k = AbsHListView.this.getWidth();
            int j = AbsHListView.this.V;
            switch (this.b) {
                default:
                case 1:
                case 3:
                case 2:
                case 4:
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        do {
                                            return;
                                            i = AbsHListView.this.getChildCount() - 1;
                                            j += i;
                                        } while (i < 0);
                                        if (j == this.e) {
                                            AbsHListView.this.a.a(this);
                                            return;
                                        }
                                        localView = AbsHListView.this.getChildAt(i);
                                        m = localView.getWidth();
                                        n = localView.getLeft();
                                        if (j < AbsHListView.this.an - 1) {
                                        }
                                        for (i = Math.max(AbsHListView.this.u.right, this.g); ; i = AbsHListView.this.u.right) {
                                            AbsHListView.this.a(i + (m - (k - n)), this.f, true);
                                            this.e = j;
                                            if (j >= this.c) {
                                                break;
                                            }
                                            AbsHListView.this.a.a(this);
                                            return;
                                        }
                                        i = AbsHListView.this.getChildCount();
                                    } while ((j == this.d) || (i <= 1) || (i + j >= AbsHListView.this.an));
                                    i = j + 1;
                                    if (i == this.e) {
                                        AbsHListView.this.a.a(this);
                                        return;
                                    }
                                    localView = AbsHListView.this.getChildAt(1);
                                    j = localView.getWidth();
                                    k = localView.getLeft();
                                    m = Math.max(AbsHListView.this.u.right, this.g);
                                    if (i < this.d) {
                                        AbsHListView.this.a(Math.max(0, k + j - m), this.f, true);
                                        this.e = i;
                                        AbsHListView.this.a.a(this);
                                        return;
                                    }
                                } while (k <= m);
                                AbsHListView.this.a(k - m, this.f, true);
                                return;
                                if (j == this.e) {
                                    AbsHListView.this.a.a(this);
                                    return;
                                }
                                localView = AbsHListView.this.getChildAt(0);
                            } while (localView == null);
                            k = localView.getLeft();
                            if (j > 0) {
                            }
                            for (i = Math.max(this.g, AbsHListView.this.u.left); ; i = AbsHListView.this.u.left) {
                                AbsHListView.this.a(k - i, this.f, true);
                                this.e = j;
                                if (j <= this.c) {
                                    break;
                                }
                                AbsHListView.this.a.a(this);
                                return;
                            }
                            m = AbsHListView.this.getChildCount() - 2;
                        } while (m < 0);
                        i = j + m;
                        if (i == this.e) {
                            AbsHListView.this.a.a(this);
                            return;
                        }
                        View localView = AbsHListView.this.getChildAt(m);
                        j = localView.getWidth();
                        m = localView.getLeft();
                        n = Math.max(AbsHListView.this.u.left, this.g);
                        this.e = i;
                        if (i > this.d) {
                            AbsHListView.this.a(-(k - m - n), this.f, true);
                            AbsHListView.this.a.a(this);
                            return;
                        }
                        i = k - n;
                        j = m + j;
                    } while (i <= j);
                    AbsHListView.this.a(-(i - j), this.f, true);
                    return;
            }
            if (this.e == j) {
                AbsHListView.this.a.a(this);
                return;
            }
            this.e = j;
            k = AbsHListView.this.getChildCount();
            int m = this.c;
            int n = j + k - 1;
            if (m < j) {
                i = j - m + 1;
            }
            float f1;
            for (; ; ) {
                f1 = Math.min(Math.abs(i / k), 1.0F);
                if (m >= j) {
                    break;
                }
                i = (int) (-AbsHListView.this.getWidth() * f1);
                j = (int) (f1 * this.f);
                AbsHListView.this.a(i, j, true);
                AbsHListView.this.a.a(this);
                return;
                if (m > n) {
                    i = m - n;
                }
            }
            if (m > n) {
                i = (int) (AbsHListView.this.getWidth() * f1);
                j = (int) (f1 * this.f);
                AbsHListView.this.a(i, j, true);
                AbsHListView.this.a.a(this);
                return;
            }
            i = AbsHListView.this.getChildAt(m - j).getLeft() - this.h;
            j = (int) (this.f * (Math.abs(i) / AbsHListView.this.getWidth()));
            AbsHListView.this.a(i, j, true);
        }
    }

    public class k {
        private AbsHListView.l b;
        private int c;
        private View[] d = new View[0];
        private ArrayList<View>[] e;
        private int f;
        private ArrayList<View> g;
        private ArrayList<View> h;
        private SparseArrayCompat<View> i;

        public k() {
        }

        @SuppressLint({"NewApi"})
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
                    AbsHListView.e(AbsHListView.this, (View) localArrayList.remove(k), false);
                    m += 1;
                    k -= 1;
                }
                j += 1;
            }
            if (this.i != null) {
                for (j = n; j < this.i.size(); j = k + 1) {
                    k = j;
                    if (!((View) this.i.valueAt(j)).hasTransientState()) {
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

        public void a(int paramInt1, int paramInt2) {
            if (this.d.length < paramInt1) {
                this.d = new View[paramInt1];
            }
            this.c = paramInt2;
            View[] arrayOfView = this.d;
            paramInt2 = 0;
            while (paramInt2 < paramInt1) {
                View localView = AbsHListView.this.getChildAt(paramInt2);
                AbsHListView.f localf = (AbsHListView.f) localView.getLayoutParams();
                if ((localf != null) && (localf.a != -2)) {
                    arrayOfView[paramInt2] = localView;
                }
                paramInt2 += 1;
            }
        }

        @SuppressLint({"NewApi"})
        public void a(View paramView, int paramInt) {
            AbsHListView.f localf = (AbsHListView.f) paramView.getLayoutParams();
            if (localf == null) {
                return;
            }
            localf.d = paramInt;
            int j = localf.a;
            if (Build.VERSION.SDK_INT >= 16) {
            }
            for (boolean bool = paramView.hasTransientState(); ; bool = false) {
                if ((b(j)) && (!bool)) {
                    break label135;
                }
                if ((j != -2) || (bool)) {
                    if (this.h == null) {
                        this.h = new ArrayList();
                    }
                    this.h.add(paramView);
                }
                if (!bool) {
                    break;
                }
                if (this.i == null) {
                    this.i = new SparseArrayCompat();
                }
                paramView.onStartTemporaryDetach();
                this.i.put(paramInt, paramView);
                return;
            }
            label135:
            paramView.onStartTemporaryDetach();
            if (this.f == 1) {
                this.g.add(paramView);
            }
            for (; ; ) {
                if (Build.VERSION.SDK_INT >= 14) {
                    paramView.setAccessibilityDelegate(null);
                }
                if (this.b == null) {
                    break;
                }
                this.b.a(paramView);
                return;
                this.e[j].add(paramView);
            }
        }

        public void b() {
            ArrayList localArrayList;
            int k;
            if (this.f == 1) {
                localArrayList = this.g;
                k = localArrayList.size();
                j = 0;
                while (j < k) {
                    AbsHListView.a(AbsHListView.this, (View) localArrayList.remove(k - 1 - j), false);
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
                    AbsHListView.b(AbsHListView.this, (View) localArrayList.remove(n - 1 - k), false);
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

        public View c(int paramInt) {
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
            if (this.i == null) {
            }
            do {
                return null;
                paramInt = this.i.indexOfKey(paramInt);
            } while (paramInt < 0);
            View localView = (View) this.i.valueAt(paramInt);
            this.i.removeAt(paramInt);
            return localView;
        }

        public void d() {
            if (this.h == null) {
                return;
            }
            int k = this.h.size();
            int j = 0;
            while (j < k) {
                AbsHListView.c(AbsHListView.this, (View) this.h.get(j), false);
                j += 1;
            }
            this.h.clear();
        }

        View e(int paramInt) {
            if (this.f == 1) {
                return AbsHListView.a(this.g, paramInt);
            }
            int j = AbsHListView.this.j.getItemViewType(paramInt);
            if ((j >= 0) && (j < this.e.length)) {
                return AbsHListView.a(this.e[j], paramInt);
            }
            return null;
        }

        @SuppressLint({"NewApi"})
        public void e() {
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
            if (this.b != null) {
                j = 1;
                if (this.f <= 1) {
                    break label191;
                }
                k = 1;
                localObject1 = this.g;
                m = arrayOfView.length - 1;
                if (m < 0) {
                    break label275;
                }
                localView = arrayOfView[m];
                localObject2 = localObject1;
                if (localView != null) {
                    localObject2 = (AbsHListView.f) localView.getLayoutParams();
                    n = ((AbsHListView.f) localObject2).a;
                    arrayOfView[m] = null;
                    if (Build.VERSION.SDK_INT < 16) {
                        break label196;
                    }
                }
            }
            label191:
            label196:
            for (boolean bool = localView.hasTransientState(); ; bool = false) {
                if ((b(n)) && (!bool)) {
                    break label202;
                }
                if ((n != -2) || (bool)) {
                    AbsHListView.d(AbsHListView.this, localView, false);
                }
                localObject2 = localObject1;
                if (bool) {
                    if (this.i == null) {
                        this.i = new SparseArrayCompat();
                    }
                    this.i.put(this.c + m, localView);
                    localObject2 = localObject1;
                }
                m -= 1;
                localObject1 = localObject2;
                break label37;
                j = 0;
                break;
                k = 0;
                break label25;
            }
            label202:
            if (k != 0) {
                localObject1 = this.e[n];
            }
            for (; ; ) {
                localView.onStartTemporaryDetach();
                ((AbsHListView.f) localObject2).d = (this.c + m);
                ((ArrayList) localObject1).add(localView);
                if (Build.VERSION.SDK_INT >= 14) {
                    localView.setAccessibilityDelegate(null);
                }
                if (j != 0) {
                    this.b.a(localView);
                }
                localObject2 = localObject1;
                break;
                label275:
                f();
                return;
            }
        }

        void f(int paramInt) {
            if (this.f == 1) {
                localObject1 = this.g;
                k = ((ArrayList) localObject1).size();
                j = 0;
                while (j < k) {
                    ((View) ((ArrayList) localObject1).get(j)).setDrawingCacheBackgroundColor(paramInt);
                    j += 1;
                }
            }
            int m = this.f;
            int j = 0;
            while (j < m) {
                localObject1 = this.e[j];
                int n = ((ArrayList) localObject1).size();
                k = 0;
                while (k < n) {
                    ((View) ((ArrayList) localObject1).get(k)).setDrawingCacheBackgroundColor(paramInt);
                    k += 1;
                }
                j += 1;
            }
            Object localObject1 = this.d;
            int k = localObject1.length;
            j = 0;
            while (j < k) {
                Object localObject2 = localObject1[j];
                if (localObject2 != null) {
                    ((View) localObject2).setDrawingCacheBackgroundColor(paramInt);
                }
                j += 1;
            }
        }
    }

    public static abstract interface l {
        public abstract void a(View paramView);
    }

    public static abstract interface m {
        public abstract void a(Rect paramRect);
    }

    private class n {
        private int a;

        private n() {
        }

        public void a() {
            this.a = AbsHListView.a(AbsHListView.this);
        }

        public boolean b() {
            return (AbsHListView.this.hasWindowFocus()) && (AbsHListView.b(AbsHListView.this) == this.a);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/widget/lib/hlist/AbsHListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */