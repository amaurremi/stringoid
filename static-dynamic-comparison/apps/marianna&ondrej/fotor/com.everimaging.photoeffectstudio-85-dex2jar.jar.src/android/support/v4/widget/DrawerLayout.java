package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

import java.util.List;

public class DrawerLayout
        extends ViewGroup {
    private static final boolean ALLOW_EDGE_LOCK = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int[] LAYOUT_ATTRS = {16842931};
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
    private boolean mChildrenCanceledTouch;
    private boolean mDisallowInterceptRequested;
    private int mDrawerState;
    private boolean mFirstLayout = true;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private final ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerListener mListener;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mMinDrawerMargin;
    private final ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor = -1728053248;
    private float mScrimOpacity;
    private Paint mScrimPaint = new Paint();
    private Drawable mShadowLeft;
    private Drawable mShadowRight;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    public DrawerLayout(Context paramContext) {
        this(paramContext, null);
    }

    public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        float f = getResources().getDisplayMetrics().density;
        this.mMinDrawerMargin = ((int) (64.0F * f + 0.5F));
        f *= 400.0F;
        this.mLeftCallback = new ViewDragCallback(3);
        this.mRightCallback = new ViewDragCallback(5);
        this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
        this.mLeftDragger.setEdgeTrackingEnabled(1);
        this.mLeftDragger.setMinVelocity(f);
        this.mLeftCallback.setDragger(this.mLeftDragger);
        this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
        this.mRightDragger.setEdgeTrackingEnabled(2);
        this.mRightDragger.setMinVelocity(f);
        this.mRightCallback.setDragger(this.mRightDragger);
        setFocusableInTouchMode(true);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
    }

    private View findVisibleDrawer() {
        int j = getChildCount();
        int i = 0;
        while (i < j) {
            View localView = getChildAt(i);
            if ((isDrawerView(localView)) && (isDrawerVisible(localView))) {
                return localView;
            }
            i += 1;
        }
        return null;
    }

    static String gravityToString(int paramInt) {
        if ((paramInt & 0x3) == 3) {
            return "LEFT";
        }
        if ((paramInt & 0x5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(paramInt);
    }

    private static boolean hasOpaqueBackground(View paramView) {
        boolean bool2 = false;
        paramView = paramView.getBackground();
        boolean bool1 = bool2;
        if (paramView != null) {
            bool1 = bool2;
            if (paramView.getOpacity() == -1) {
                bool1 = true;
            }
        }
        return bool1;
    }

    private boolean hasPeekingDrawer() {
        int j = getChildCount();
        int i = 0;
        while (i < j) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).isPeeking) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        return findVisibleDrawer() != null;
    }

    void cancelChildViewTouch() {
        int i = 0;
        if (!this.mChildrenCanceledTouch) {
            long l = SystemClock.uptimeMillis();
            MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            int j = getChildCount();
            while (i < j) {
                getChildAt(i).dispatchTouchEvent(localMotionEvent);
                i += 1;
            }
            localMotionEvent.recycle();
            this.mChildrenCanceledTouch = true;
        }
    }

    boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt) {
        return (getDrawerViewAbsoluteGravity(paramView) & paramInt) == paramInt;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
    }

    public void closeDrawer(int paramInt) {
        View localView = findDrawerWithGravity(paramInt);
        if (localView == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
        }
        closeDrawer(localView);
    }

    public void closeDrawer(View paramView) {
        if (!isDrawerView(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
        }
        if (this.mFirstLayout) {
            paramView = (LayoutParams) paramView.getLayoutParams();
            paramView.onScreen = 0.0F;
            paramView.knownOpen = false;
        }
        for (; ; ) {
            invalidate();
            return;
            if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
                this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
            } else {
                this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
            }
        }
    }

    public void closeDrawers() {
        closeDrawers(false);
    }

    void closeDrawers(boolean paramBoolean) {
        int n = getChildCount();
        int j = 0;
        int i = 0;
        while (j < n) {
            View localView = getChildAt(j);
            LayoutParams localLayoutParams = (LayoutParams) localView.getLayoutParams();
            int k = i;
            if (isDrawerView(localView)) {
                if ((paramBoolean) && (!localLayoutParams.isPeeking)) {
                    k = i;
                }
            } else {
                j += 1;
                i = k;
                continue;
            }
            int m = localView.getWidth();
            if (checkDrawerViewAbsoluteGravity(localView, 3)) {
                i |= this.mLeftDragger.smoothSlideViewTo(localView, -m, localView.getTop());
            }
            for (; ; ) {
                localLayoutParams.isPeeking = false;
                m = i;
                break;
                i |= this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
            }
        }
        this.mLeftCallback.removeCallbacks();
        this.mRightCallback.removeCallbacks();
        if (i != 0) {
            invalidate();
        }
    }

    public void computeScroll() {
        int j = getChildCount();
        float f = 0.0F;
        int i = 0;
        while (i < j) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).onScreen);
            i += 1;
        }
        this.mScrimOpacity = f;
        if ((this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true))) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void dispatchOnDrawerClosed(View paramView) {
        LayoutParams localLayoutParams = (LayoutParams) paramView.getLayoutParams();
        if (localLayoutParams.knownOpen) {
            localLayoutParams.knownOpen = false;
            if (this.mListener != null) {
                this.mListener.onDrawerClosed(paramView);
            }
            if (hasWindowFocus()) {
                paramView = getRootView();
                if (paramView != null) {
                    paramView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void dispatchOnDrawerOpened(View paramView) {
        LayoutParams localLayoutParams = (LayoutParams) paramView.getLayoutParams();
        if (!localLayoutParams.knownOpen) {
            localLayoutParams.knownOpen = true;
            if (this.mListener != null) {
                this.mListener.onDrawerOpened(paramView);
            }
            sendAccessibilityEvent(32);
        }
    }

    void dispatchOnDrawerSlide(View paramView, float paramFloat) {
        if (this.mListener != null) {
            this.mListener.onDrawerSlide(paramView, paramFloat);
        }
    }

    protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
        int i2 = getHeight();
        boolean bool1 = isContentView(paramView);
        int k = 0;
        int n = 0;
        int i = getWidth();
        int i3 = paramCanvas.save();
        int j = i;
        int m;
        View localView;
        if (bool1) {
            int i4 = getChildCount();
            m = 0;
            k = n;
            for (; ; ) {
                if (m < i4) {
                    localView = getChildAt(m);
                    if ((localView != paramView) && (localView.getVisibility() == 0) && (hasOpaqueBackground(localView)) && (isDrawerView(localView))) {
                        if (localView.getHeight() < i2) {
                            n = k;
                            j = i;
                            m += 1;
                            i = j;
                            k = n;
                            continue;
                        }
                        if (checkDrawerViewAbsoluteGravity(localView, 3)) {
                            j = localView.getRight();
                            if (j <= k) {
                                break label534;
                            }
                        }
                    }
                }
            }
        }
        for (; ; ) {
            n = j;
            j = i;
            break;
            int i1 = localView.getLeft();
            j = i1;
            n = k;
            if (i1 < i) {
                break;
            }
            j = i;
            n = k;
            break;
            paramCanvas.clipRect(k, 0, i, getHeight());
            j = i;
            boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restoreToCount(i3);
            if ((this.mScrimOpacity > 0.0F) && (bool1)) {
                i = (int) (((this.mScrimColor & 0xFF000000) >>> 24) * this.mScrimOpacity);
                m = this.mScrimColor;
                this.mScrimPaint.setColor(i << 24 | m & 0xFFFFFF);
                paramCanvas.drawRect(k, 0.0F, j, getHeight(), this.mScrimPaint);
            }
            do {
                return bool2;
                if ((this.mShadowLeft != null) && (checkDrawerViewAbsoluteGravity(paramView, 3))) {
                    i = this.mShadowLeft.getIntrinsicWidth();
                    j = paramView.getRight();
                    k = this.mLeftDragger.getEdgeSize();
                    f = Math.max(0.0F, Math.min(j / k, 1.0F));
                    this.mShadowLeft.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
                    this.mShadowLeft.setAlpha((int) (255.0F * f));
                    this.mShadowLeft.draw(paramCanvas);
                    return bool2;
                }
            } while ((this.mShadowRight == null) || (!checkDrawerViewAbsoluteGravity(paramView, 5)));
            i = this.mShadowRight.getIntrinsicWidth();
            j = paramView.getLeft();
            k = getWidth();
            m = this.mRightDragger.getEdgeSize();
            float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
            this.mShadowRight.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
            this.mShadowRight.setAlpha((int) (255.0F * f));
            this.mShadowRight.draw(paramCanvas);
            return bool2;
            label534:
            j = k;
        }
    }

    View findDrawerWithGravity(int paramInt) {
        int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
        int j = getChildCount();
        paramInt = 0;
        while (paramInt < j) {
            View localView = getChildAt(paramInt);
            if ((getDrawerViewAbsoluteGravity(localView) & 0x7) == (i & 0x7)) {
                return localView;
            }
            paramInt += 1;
        }
        return null;
    }

    View findOpenDrawer() {
        int j = getChildCount();
        int i = 0;
        while (i < j) {
            View localView = getChildAt(i);
            if (((LayoutParams) localView.getLayoutParams()).knownOpen) {
                return localView;
            }
            i += 1;
        }
        return null;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new LayoutParams(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        if ((paramLayoutParams instanceof LayoutParams)) {
            return new LayoutParams((LayoutParams) paramLayoutParams);
        }
        if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) paramLayoutParams);
        }
        return new LayoutParams(paramLayoutParams);
    }

    public int getDrawerLockMode(int paramInt) {
        paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
        if (paramInt == 3) {
            return this.mLockModeLeft;
        }
        if (paramInt == 5) {
            return this.mLockModeRight;
        }
        return 0;
    }

    public int getDrawerLockMode(View paramView) {
        int i = getDrawerViewAbsoluteGravity(paramView);
        if (i == 3) {
            return this.mLockModeLeft;
        }
        if (i == 5) {
            return this.mLockModeRight;
        }
        return 0;
    }

    public CharSequence getDrawerTitle(int paramInt) {
        paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
        if (paramInt == 3) {
            return this.mTitleLeft;
        }
        if (paramInt == 5) {
            return this.mTitleRight;
        }
        return null;
    }

    int getDrawerViewAbsoluteGravity(View paramView) {
        return GravityCompat.getAbsoluteGravity(((LayoutParams) paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
    }

    float getDrawerViewOffset(View paramView) {
        return ((LayoutParams) paramView.getLayoutParams()).onScreen;
    }

    boolean isContentView(View paramView) {
        return ((LayoutParams) paramView.getLayoutParams()).gravity == 0;
    }

    public boolean isDrawerOpen(int paramInt) {
        View localView = findDrawerWithGravity(paramInt);
        if (localView != null) {
            return isDrawerOpen(localView);
        }
        return false;
    }

    public boolean isDrawerOpen(View paramView) {
        if (!isDrawerView(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a drawer");
        }
        return ((LayoutParams) paramView.getLayoutParams()).knownOpen;
    }

    boolean isDrawerView(View paramView) {
        return (GravityCompat.getAbsoluteGravity(((LayoutParams) paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView)) & 0x7) != 0;
    }

    public boolean isDrawerVisible(int paramInt) {
        View localView = findDrawerWithGravity(paramInt);
        if (localView != null) {
            return isDrawerVisible(localView);
        }
        return false;
    }

    public boolean isDrawerVisible(View paramView) {
        if (!isDrawerView(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a drawer");
        }
        return ((LayoutParams) paramView.getLayoutParams()).onScreen > 0.0F;
    }

    void moveDrawerToOffset(View paramView, float paramFloat) {
        float f = getDrawerViewOffset(paramView);
        int i = paramView.getWidth();
        int j = (int) (f * i);
        i = (int) (i * paramFloat) - j;
        if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
        }
        for (; ; ) {
            paramView.offsetLeftAndRight(i);
            setDrawerViewOffset(paramView, paramFloat);
            return;
            i = -i;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool1 = false;
        int i = MotionEventCompat.getActionMasked(paramMotionEvent);
        boolean bool2 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent);
        boolean bool3 = this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
        switch (i) {
            default:
                i = 0;
                if (((bool2 | bool3)) || (i != 0) || (hasPeekingDrawer()) || (this.mChildrenCanceledTouch)) {
                    bool1 = true;
                }
                return bool1;
            case 0:
                label63:
                float f1 = paramMotionEvent.getX();
                float f2 = paramMotionEvent.getY();
                this.mInitialMotionX = f1;
                this.mInitialMotionY = f2;
                if ((this.mScrimOpacity <= 0.0F) || (!isContentView(this.mLeftDragger.findTopChildUnder((int) f1, (int) f2)))) {
                    break;
                }
        }
        for (i = 1; ; i = 0) {
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
            break label63;
            if (!this.mLeftDragger.checkTouchSlop(3)) {
                break;
            }
            this.mLeftCallback.removeCallbacks();
            this.mRightCallback.removeCallbacks();
            i = 0;
            break label63;
            closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
            break;
        }
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        if ((paramInt == 4) && (hasVisibleDrawer())) {
            KeyEventCompat.startTracking(paramKeyEvent);
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
        if (paramInt == 4) {
            paramKeyEvent = findVisibleDrawer();
            if ((paramKeyEvent != null) && (getDrawerLockMode(paramKeyEvent) == 0)) {
                closeDrawers();
            }
            return paramKeyEvent != null;
        }
        return super.onKeyUp(paramInt, paramKeyEvent);
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.mInLayout = true;
        int m = paramInt3 - paramInt1;
        int n = getChildCount();
        paramInt3 = 0;
        if (paramInt3 < n) {
            View localView = getChildAt(paramInt3);
            if (localView.getVisibility() == 8) {
            }
            LayoutParams localLayoutParams;
            for (; ; ) {
                paramInt3 += 1;
                break;
                localLayoutParams = (LayoutParams) localView.getLayoutParams();
                if (!isContentView(localView)) {
                    break label113;
                }
                localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
            }
            label113:
            int i1 = localView.getMeasuredWidth();
            int i2 = localView.getMeasuredHeight();
            int i;
            float f;
            label167:
            int j;
            if (checkDrawerViewAbsoluteGravity(localView, 3)) {
                paramInt1 = -i1;
                i = (int) (i1 * localLayoutParams.onScreen) + paramInt1;
                f = (i1 + i) / i1;
                if (f == localLayoutParams.onScreen) {
                    break label314;
                }
                j = 1;
                label181:
                switch (localLayoutParams.gravity & 0x70) {
                    default:
                        localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
                        label241:
                        if (j != 0) {
                            setDrawerViewOffset(localView, f);
                        }
                        if (localLayoutParams.onScreen <= 0.0F) {
                            break;
                        }
                }
            }
            for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4) {
                localView.setVisibility(paramInt1);
                break;
                i = m - (int) (i1 * localLayoutParams.onScreen);
                f = (m - i) / i1;
                break label167;
                label314:
                j = 0;
                break label181;
                paramInt1 = paramInt4 - paramInt2;
                localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
                break label241;
                int i3 = paramInt4 - paramInt2;
                int k = (i3 - i2) / 2;
                if (k < localLayoutParams.topMargin) {
                    paramInt1 = localLayoutParams.topMargin;
                }
                for (; ; ) {
                    localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
                    break;
                    paramInt1 = k;
                    if (k + i2 > i3 - localLayoutParams.bottomMargin) {
                        paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
                    }
                }
            }
        }
        this.mInLayout = false;
        this.mFirstLayout = false;
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int k = 300;
        int i1 = View.MeasureSpec.getMode(paramInt1);
        int n = View.MeasureSpec.getMode(paramInt2);
        int j = View.MeasureSpec.getSize(paramInt1);
        int m = View.MeasureSpec.getSize(paramInt2);
        int i;
        label81:
        label97:
        View localView;
        if (i1 == 1073741824) {
            i = j;
            if (n == 1073741824) {
            }
        } else {
            if (!isInEditMode()) {
                break label164;
            }
            if (i1 == Integer.MIN_VALUE) {
                i = j;
                if (n != Integer.MIN_VALUE) {
                    break label142;
                }
                j = m;
                k = i;
                setMeasuredDimension(k, j);
                m = getChildCount();
                i = 0;
                if (i >= m) {
                    return;
                }
                localView = getChildAt(i);
                if (localView.getVisibility() != 8) {
                    break label175;
                }
            }
        }
        for (; ; ) {
            i += 1;
            break label97;
            i = j;
            if (i1 != 0) {
                break;
            }
            i = 300;
            break;
            label142:
            j = k;
            k = i;
            if (n == 0) {
                break label81;
            }
            j = m;
            k = i;
            break label81;
            label164:
            throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            label175:
            LayoutParams localLayoutParams = (LayoutParams) localView.getLayoutParams();
            if (isContentView(localView)) {
                localView.measure(View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(j - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
            } else {
                if (!isDrawerView(localView)) {
                    break label377;
                }
                n = getDrawerViewAbsoluteGravity(localView) & 0x7;
                if ((0x0 & n) != 0) {
                    throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(n) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                }
                localView.measure(getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
            }
        }
        label377:
        throw new IllegalStateException("Child " + localView + " at index " + i + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        if (paramParcelable.openDrawerGravity != 0) {
            View localView = findDrawerWithGravity(paramParcelable.openDrawerGravity);
            if (localView != null) {
                openDrawer(localView);
            }
        }
        setDrawerLockMode(paramParcelable.lockModeLeft, 3);
        setDrawerLockMode(paramParcelable.lockModeRight, 5);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState localSavedState = new SavedState(super.onSaveInstanceState());
        int j = getChildCount();
        int i = 0;
        if (i < j) {
            Object localObject = getChildAt(i);
            if (!isDrawerView((View) localObject)) {
            }
            do {
                i += 1;
                break;
                localObject = (LayoutParams) ((View) localObject).getLayoutParams();
            } while (!((LayoutParams) localObject).knownOpen);
            localSavedState.openDrawerGravity = ((LayoutParams) localObject).gravity;
        }
        localSavedState.lockModeLeft = this.mLockModeLeft;
        localSavedState.lockModeRight = this.mLockModeRight;
        return localSavedState;
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        this.mLeftDragger.processTouchEvent(paramMotionEvent);
        this.mRightDragger.processTouchEvent(paramMotionEvent);
        float f1;
        float f2;
        boolean bool;
        switch (paramMotionEvent.getAction() & 0xFF) {
            case 2:
            default:
                return true;
            case 0:
                f1 = paramMotionEvent.getX();
                f2 = paramMotionEvent.getY();
                this.mInitialMotionX = f1;
                this.mInitialMotionY = f2;
                this.mDisallowInterceptRequested = false;
                this.mChildrenCanceledTouch = false;
                return true;
            case 1:
                f2 = paramMotionEvent.getX();
                f1 = paramMotionEvent.getY();
                paramMotionEvent = this.mLeftDragger.findTopChildUnder((int) f2, (int) f1);
                if ((paramMotionEvent != null) && (isContentView(paramMotionEvent))) {
                    f2 -= this.mInitialMotionX;
                    f1 -= this.mInitialMotionY;
                    int i = this.mLeftDragger.getTouchSlop();
                    if (f2 * f2 + f1 * f1 < i * i) {
                        paramMotionEvent = findOpenDrawer();
                        if (paramMotionEvent != null) {
                            if (getDrawerLockMode(paramMotionEvent) == 2) {
                                bool = true;
                            }
                        }
                    }
                }
                break;
        }
        for (; ; ) {
            closeDrawers(bool);
            this.mDisallowInterceptRequested = false;
            return true;
            bool = false;
            continue;
            closeDrawers(true);
            this.mDisallowInterceptRequested = false;
            this.mChildrenCanceledTouch = false;
            return true;
            bool = true;
        }
    }

    public void openDrawer(int paramInt) {
        View localView = findDrawerWithGravity(paramInt);
        if (localView == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
        }
        openDrawer(localView);
    }

    public void openDrawer(View paramView) {
        if (!isDrawerView(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
        }
        if (this.mFirstLayout) {
            paramView = (LayoutParams) paramView.getLayoutParams();
            paramView.onScreen = 1.0F;
            paramView.knownOpen = true;
        }
        for (; ; ) {
            invalidate();
            return;
            if (checkDrawerViewAbsoluteGravity(paramView, 3)) {
                this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
            } else {
                this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
            }
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
        super.requestDisallowInterceptTouchEvent(paramBoolean);
        this.mDisallowInterceptRequested = paramBoolean;
        if (paramBoolean) {
            closeDrawers(true);
        }
    }

    public void requestLayout() {
        if (!this.mInLayout) {
            super.requestLayout();
        }
    }

    public void setDrawerListener(DrawerListener paramDrawerListener) {
        this.mListener = paramDrawerListener;
    }

    public void setDrawerLockMode(int paramInt) {
        setDrawerLockMode(paramInt, 3);
        setDrawerLockMode(paramInt, 5);
    }

    public void setDrawerLockMode(int paramInt1, int paramInt2) {
        paramInt2 = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
        Object localObject;
        if (paramInt2 == 3) {
            this.mLockModeLeft = paramInt1;
            if (paramInt1 != 0) {
                if (paramInt2 != 3) {
                    break label74;
                }
                localObject = this.mLeftDragger;
                label33:
                ((ViewDragHelper) localObject).cancel();
            }
            switch (paramInt1) {
            }
        }
        label74:
        do {
            do {
                return;
                if (paramInt2 != 5) {
                    break;
                }
                this.mLockModeRight = paramInt1;
                break;
                localObject = this.mRightDragger;
                break label33;
                localObject = findDrawerWithGravity(paramInt2);
            } while (localObject == null);
            openDrawer((View) localObject);
            return;
            localObject = findDrawerWithGravity(paramInt2);
        } while (localObject == null);
        closeDrawer((View) localObject);
    }

    public void setDrawerLockMode(int paramInt, View paramView) {
        if (!isDrawerView(paramView)) {
            throw new IllegalArgumentException("View " + paramView + " is not a " + "drawer with appropriate layout_gravity");
        }
        setDrawerLockMode(paramInt, ((LayoutParams) paramView.getLayoutParams()).gravity);
    }

    public void setDrawerShadow(int paramInt1, int paramInt2) {
        setDrawerShadow(getResources().getDrawable(paramInt1), paramInt2);
    }

    public void setDrawerShadow(Drawable paramDrawable, int paramInt) {
        paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
        if ((paramInt & 0x3) == 3) {
            this.mShadowLeft = paramDrawable;
            invalidate();
        }
        if ((paramInt & 0x5) == 5) {
            this.mShadowRight = paramDrawable;
            invalidate();
        }
    }

    public void setDrawerTitle(int paramInt, CharSequence paramCharSequence) {
        paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
        if (paramInt == 3) {
            this.mTitleLeft = paramCharSequence;
        }
        while (paramInt != 5) {
            return;
        }
        this.mTitleRight = paramCharSequence;
    }

    void setDrawerViewOffset(View paramView, float paramFloat) {
        LayoutParams localLayoutParams = (LayoutParams) paramView.getLayoutParams();
        if (paramFloat == localLayoutParams.onScreen) {
            return;
        }
        localLayoutParams.onScreen = paramFloat;
        dispatchOnDrawerSlide(paramView, paramFloat);
    }

    public void setScrimColor(int paramInt) {
        this.mScrimColor = paramInt;
        invalidate();
    }

    void updateDrawerState(int paramInt1, int paramInt2, View paramView) {
        int i = 1;
        int j = this.mLeftDragger.getViewDragState();
        int k = this.mRightDragger.getViewDragState();
        paramInt1 = i;
        LayoutParams localLayoutParams;
        if (j != 1) {
            if (k == 1) {
                paramInt1 = i;
            }
        } else if ((paramView != null) && (paramInt2 == 0)) {
            localLayoutParams = (LayoutParams) paramView.getLayoutParams();
            if (localLayoutParams.onScreen != 0.0F) {
                break label124;
            }
            dispatchOnDrawerClosed(paramView);
        }
        for (; ; ) {
            if (paramInt1 != this.mDrawerState) {
                this.mDrawerState = paramInt1;
                if (this.mListener != null) {
                    this.mListener.onDrawerStateChanged(paramInt1);
                }
            }
            return;
            if ((j == 2) || (k == 2)) {
                paramInt1 = 2;
                break;
            }
            paramInt1 = 0;
            break;
            label124:
            if (localLayoutParams.onScreen == 1.0F) {
                dispatchOnDrawerOpened(paramView);
            }
        }
    }

    class AccessibilityDelegate
            extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
        }

        private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup) {
            int j = paramViewGroup.getChildCount();
            int i = 0;
            if (i < j) {
                View localView = paramViewGroup.getChildAt(i);
                if (filter(localView)) {
                }
                for (; ; ) {
                    i += 1;
                    break;
                    switch (ViewCompat.getImportantForAccessibility(localView)) {
                        case 4:
                        case 3:
                        default:
                            break;
                        case 0:
                            ViewCompat.setImportantForAccessibility(localView, 1);
                        case 1:
                            paramAccessibilityNodeInfoCompat.addChild(localView);
                            break;
                        case 2:
                            if ((localView instanceof ViewGroup)) {
                                addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup) localView);
                            }
                            break;
                    }
                }
            }
        }

        private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2) {
            Rect localRect = this.mTmpRect;
            paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
            paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
            paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
            paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
            paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
            paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
            paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
            paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
            paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
            paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
            paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
            paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
            paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
            paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
            paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
            paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
        }

        public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
            if (paramAccessibilityEvent.getEventType() == 32) {
                paramView = paramAccessibilityEvent.getText();
                paramAccessibilityEvent = DrawerLayout.this.findVisibleDrawer();
                if (paramAccessibilityEvent != null) {
                    int i = DrawerLayout.this.getDrawerViewAbsoluteGravity(paramAccessibilityEvent);
                    paramAccessibilityEvent = DrawerLayout.this.getDrawerTitle(i);
                    if (paramAccessibilityEvent != null) {
                        paramView.add(paramAccessibilityEvent);
                    }
                }
                return true;
            }
            return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
        }

        public boolean filter(View paramView) {
            View localView = DrawerLayout.this.findOpenDrawer();
            return (localView != null) && (localView != paramView);
        }

        public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
            super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
            paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
            paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
            paramAccessibilityNodeInfoCompat.setSource(paramView);
            ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
            if ((localViewParent instanceof View)) {
                paramAccessibilityNodeInfoCompat.setParent((View) localViewParent);
            }
            copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
            localAccessibilityNodeInfoCompat.recycle();
            addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup) paramView);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
            if (!filter(paramView)) {
                return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
            }
            return false;
        }
    }

    public static abstract interface DrawerListener {
        public abstract void onDrawerClosed(View paramView);

        public abstract void onDrawerOpened(View paramView);

        public abstract void onDrawerSlide(View paramView, float paramFloat);

        public abstract void onDrawerStateChanged(int paramInt);
    }

    public static class LayoutParams
            extends ViewGroup.MarginLayoutParams {
        public int gravity = 0;
        boolean isPeeking;
        boolean knownOpen;
        float onScreen;

        public LayoutParams(int paramInt1, int paramInt2) {
            super(paramInt2);
        }

        public LayoutParams(int paramInt1, int paramInt2, int paramInt3) {
            this(paramInt1, paramInt2);
        }

        public LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
            this.gravity = paramContext.getInt(0, 0);
            paramContext.recycle();
        }

        public LayoutParams(LayoutParams paramLayoutParams) {
            super();
            this.gravity = paramLayoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
            super();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
            super();
        }
    }

    protected static class SavedState
            extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {
            public DrawerLayout.SavedState createFromParcel(Parcel paramAnonymousParcel) {
                return new DrawerLayout.SavedState(paramAnonymousParcel);
            }

            public DrawerLayout.SavedState[] newArray(int paramAnonymousInt) {
                return new DrawerLayout.SavedState[paramAnonymousInt];
            }
        };
        int lockModeLeft = 0;
        int lockModeRight = 0;
        int openDrawerGravity = 0;

        public SavedState(Parcel paramParcel) {
            super();
            this.openDrawerGravity = paramParcel.readInt();
        }

        public SavedState(Parcelable paramParcelable) {
            super();
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeInt(this.openDrawerGravity);
        }
    }

    public static abstract class SimpleDrawerListener
            implements DrawerLayout.DrawerListener {
        public void onDrawerClosed(View paramView) {
        }

        public void onDrawerOpened(View paramView) {
        }

        public void onDrawerSlide(View paramView, float paramFloat) {
        }

        public void onDrawerStateChanged(int paramInt) {
        }
    }

    private class ViewDragCallback
            extends ViewDragHelper.Callback {
        private final int mAbsGravity;
        private ViewDragHelper mDragger;
        private final Runnable mPeekRunnable = new Runnable() {
            public void run() {
                DrawerLayout.ViewDragCallback.this.peekDrawer();
            }
        };

        public ViewDragCallback(int paramInt) {
            this.mAbsGravity = paramInt;
        }

        private void closeOtherDrawer() {
            int i = 3;
            if (this.mAbsGravity == 3) {
                i = 5;
            }
            View localView = DrawerLayout.this.findDrawerWithGravity(i);
            if (localView != null) {
                DrawerLayout.this.closeDrawer(localView);
            }
        }

        private void peekDrawer() {
            int j = 0;
            int k = this.mDragger.getEdgeSize();
            int i;
            View localView;
            if (this.mAbsGravity == 3) {
                i = 1;
                if (i == 0) {
                    break label149;
                }
                localView = DrawerLayout.this.findDrawerWithGravity(3);
                if (localView != null) {
                    j = -localView.getWidth();
                }
                j += k;
            }
            for (; ; ) {
                if ((localView != null) && (((i != 0) && (localView.getLeft() < j)) || ((i == 0) && (localView.getLeft() > j) && (DrawerLayout.this.getDrawerLockMode(localView) == 0)))) {
                    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams) localView.getLayoutParams();
                    this.mDragger.smoothSlideViewTo(localView, j, localView.getTop());
                    localLayoutParams.isPeeking = true;
                    DrawerLayout.this.invalidate();
                    closeOtherDrawer();
                    DrawerLayout.this.cancelChildViewTouch();
                }
                return;
                i = 0;
                break;
                label149:
                localView = DrawerLayout.this.findDrawerWithGravity(5);
                j = DrawerLayout.this.getWidth();
                j -= k;
            }
        }

        public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2) {
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
                return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
            }
            paramInt2 = DrawerLayout.this.getWidth();
            return Math.max(paramInt2 - paramView.getWidth(), Math.min(paramInt1, paramInt2));
        }

        public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2) {
            return paramView.getTop();
        }

        public int getViewHorizontalDragRange(View paramView) {
            return paramView.getWidth();
        }

        public void onEdgeDragStarted(int paramInt1, int paramInt2) {
            if ((paramInt1 & 0x1) == 1) {
            }
            for (View localView = DrawerLayout.this.findDrawerWithGravity(3); ; localView = DrawerLayout.this.findDrawerWithGravity(5)) {
                if ((localView != null) && (DrawerLayout.this.getDrawerLockMode(localView) == 0)) {
                    this.mDragger.captureChildView(localView, paramInt2);
                }
                return;
            }
        }

        public boolean onEdgeLock(int paramInt) {
            return false;
        }

        public void onEdgeTouched(int paramInt1, int paramInt2) {
            DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
        }

        public void onViewCaptured(View paramView, int paramInt) {
            ((DrawerLayout.LayoutParams) paramView.getLayoutParams()).isPeeking = false;
            closeOtherDrawer();
        }

        public void onViewDragStateChanged(int paramInt) {
            DrawerLayout.this.updateDrawerState(this.mAbsGravity, paramInt, this.mDragger.getCapturedView());
        }

        public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
            paramInt2 = paramView.getWidth();
            float f;
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
                f = (paramInt2 + paramInt1) / paramInt2;
                DrawerLayout.this.setDrawerViewOffset(paramView, f);
                if (f != 0.0F) {
                    break label76;
                }
            }
            label76:
            for (paramInt1 = 4; ; paramInt1 = 0) {
                paramView.setVisibility(paramInt1);
                DrawerLayout.this.invalidate();
                return;
                f = (DrawerLayout.this.getWidth() - paramInt1) / paramInt2;
                break;
            }
        }

        public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {
            paramFloat2 = DrawerLayout.this.getDrawerViewOffset(paramView);
            int k = paramView.getWidth();
            int i;
            if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3)) {
                if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (paramFloat2 > 0.5F))) {
                    i = 0;
                }
            }
            for (; ; ) {
                this.mDragger.settleCapturedViewAt(i, paramView.getTop());
                DrawerLayout.this.invalidate();
                return;
                i = -k;
                continue;
                int j = DrawerLayout.this.getWidth();
                if (paramFloat1 >= 0.0F) {
                    i = j;
                    if (paramFloat1 == 0.0F) {
                        i = j;
                        if (paramFloat2 <= 0.5F) {
                        }
                    }
                } else {
                    i = j - k;
                }
            }
        }

        public void removeCallbacks() {
            DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
        }

        public void setDragger(ViewDragHelper paramViewDragHelper) {
            this.mDragger = paramViewDragHelper;
        }

        public boolean tryCaptureView(View paramView, int paramInt) {
            return (DrawerLayout.this.isDrawerView(paramView)) && (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity)) && (DrawerLayout.this.getDrawerLockMode(paramView) == 0);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/widget/DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */