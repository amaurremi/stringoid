package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
        extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    static final SlidingPanelLayoutImpl IMPL = new SlidingPanelLayoutImplBase();
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private final ViewDragHelper mDragHelper;
    private boolean mFirstLayout = true;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private PanelSlideListener mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    private final ArrayList<DisableLayerRunnable> mPostedRunnables = new ArrayList();
    private boolean mPreservedOpenState;
    private Drawable mShadowDrawable;
    private float mSlideOffset;
    private int mSlideRange;
    private View mSlideableView;
    private int mSliderFadeColor = -858993460;
    private final Rect mTmpRect = new Rect();

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            IMPL = new SlidingPanelLayoutImplJBMR1();
            return;
        }
        if (i >= 16) {
            IMPL = new SlidingPanelLayoutImplJB();
            return;
        }
    }

    public SlidingPaneLayout(Context paramContext) {
        this(paramContext, null);
    }

    public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 0);
    }

    public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        float f = paramContext.getResources().getDisplayMetrics().density;
        this.mOverhangSize = ((int) (32.0F * f + 0.5F));
        ViewConfiguration.get(paramContext);
        setWillNotDraw(false);
        ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
        ViewCompat.setImportantForAccessibility(this, 1);
        this.mDragHelper = ViewDragHelper.create(this, 0.5F, new DragHelperCallback(null));
        this.mDragHelper.setEdgeTrackingEnabled(1);
        this.mDragHelper.setMinVelocity(f * 400.0F);
    }

    private boolean closePane(View paramView, int paramInt) {
        boolean bool = false;
        if ((this.mFirstLayout) || (smoothSlideTo(0.0F, paramInt))) {
            this.mPreservedOpenState = false;
            bool = true;
        }
        return bool;
    }

    private void dimChildView(View paramView, float paramFloat, int paramInt) {
        LayoutParams localLayoutParams = (LayoutParams) paramView.getLayoutParams();
        if ((paramFloat > 0.0F) && (paramInt != 0)) {
            i = (int) (((0xFF000000 & paramInt) >>> 24) * paramFloat);
            if (localLayoutParams.dimPaint == null) {
                localLayoutParams.dimPaint = new Paint();
            }
            localLayoutParams.dimPaint.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
            if (ViewCompat.getLayerType(paramView) != 2) {
                ViewCompat.setLayerType(paramView, 2, localLayoutParams.dimPaint);
            }
            invalidateChildRegion(paramView);
        }
        while (ViewCompat.getLayerType(paramView) == 0) {
            int i;
            return;
        }
        if (localLayoutParams.dimPaint != null) {
            localLayoutParams.dimPaint.setColorFilter(null);
        }
        paramView = new DisableLayerRunnable(paramView);
        this.mPostedRunnables.add(paramView);
        ViewCompat.postOnAnimation(this, paramView);
    }

    private void invalidateChildRegion(View paramView) {
        IMPL.invalidateChildRegion(this, paramView);
    }

    private void onPanelDragged(int paramInt) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = 0.0F;
            return;
        }
        LayoutParams localLayoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        this.mSlideOffset = ((paramInt - (getPaddingLeft() + localLayoutParams.leftMargin)) / this.mSlideRange);
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (localLayoutParams.dimWhenOffset) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    private boolean openPane(View paramView, int paramInt) {
        if ((this.mFirstLayout) || (smoothSlideTo(1.0F, paramInt))) {
            this.mPreservedOpenState = true;
            return true;
        }
        return false;
    }

    private void parallaxOtherViews(float paramFloat) {
        int j = 0;
        Object localObject = (LayoutParams) this.mSlideableView.getLayoutParams();
        int i;
        if ((((LayoutParams) localObject).dimWhenOffset) && (((LayoutParams) localObject).leftMargin <= 0)) {
            i = 1;
            int k = getChildCount();
            label38:
            if (j >= k) {
                return;
            }
            localObject = getChildAt(j);
            if (localObject != this.mSlideableView) {
                break label72;
            }
        }
        for (; ; ) {
            j += 1;
            break label38;
            i = 0;
            break;
            label72:
            int m = (int) ((1.0F - this.mParallaxOffset) * this.mParallaxBy);
            this.mParallaxOffset = paramFloat;
            ((View) localObject).offsetLeftAndRight(m - (int) ((1.0F - paramFloat) * this.mParallaxBy));
            if (i != 0) {
                dimChildView((View) localObject, 1.0F - this.mParallaxOffset, this.mCoveredFadeColor);
            }
        }
    }

    private static boolean viewIsOpaque(View paramView) {
        if (ViewCompat.isOpaque(paramView)) {
        }
        do {
            return true;
            if (Build.VERSION.SDK_INT >= 18) {
                return false;
            }
            paramView = paramView.getBackground();
            if (paramView == null) {
                break;
            }
        } while (paramView.getOpacity() == -1);
        return false;
        return false;
    }

    protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
        int i;
        if ((paramView instanceof ViewGroup)) {
            ViewGroup localViewGroup = (ViewGroup) paramView;
            int j = paramView.getScrollX();
            int k = paramView.getScrollY();
            i = localViewGroup.getChildCount() - 1;
            if (i >= 0) {
                localView = localViewGroup.getChildAt(i);
                if ((paramInt2 + j < localView.getLeft()) || (paramInt2 + j >= localView.getRight()) || (paramInt3 + k < localView.getTop()) || (paramInt3 + k >= localView.getBottom()) || (!canScroll(localView, true, paramInt1, paramInt2 + j - localView.getLeft(), paramInt3 + k - localView.getTop()))) {
                }
            }
        }
        while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1))) {
            View localView;
            return true;
            i -= 1;
            break;
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public void computeScroll() {
        if (this.mDragHelper.continueSettling(true)) {
            if (!this.mCanSlide) {
                this.mDragHelper.abort();
            }
        } else {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void dispatchOnPanelClosed(View paramView) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelClosed(paramView);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(View paramView) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelOpened(paramView);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(View paramView) {
        if (this.mPanelSlideListener != null) {
            this.mPanelSlideListener.onPanelSlide(paramView, this.mSlideOffset);
        }
    }

    public void draw(Canvas paramCanvas) {
        super.draw(paramCanvas);
        if (getChildCount() > 1) {
        }
        for (View localView = getChildAt(1); (localView == null) || (this.mShadowDrawable == null); localView = null) {
            return;
        }
        int i = this.mShadowDrawable.getIntrinsicWidth();
        int j = localView.getLeft();
        int k = localView.getTop();
        int m = localView.getBottom();
        this.mShadowDrawable.setBounds(j - i, k, j, m);
        this.mShadowDrawable.draw(paramCanvas);
    }

    protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
        LayoutParams localLayoutParams = (LayoutParams) paramView.getLayoutParams();
        int i = paramCanvas.save(2);
        if ((this.mCanSlide) && (!localLayoutParams.slideable) && (this.mSlideableView != null)) {
            paramCanvas.getClipBounds(this.mTmpRect);
            this.mTmpRect.right = Math.min(this.mTmpRect.right, this.mSlideableView.getLeft());
            paramCanvas.clipRect(this.mTmpRect);
        }
        boolean bool;
        if (Build.VERSION.SDK_INT >= 11) {
            bool = super.drawChild(paramCanvas, paramView, paramLong);
        }
        for (; ; ) {
            paramCanvas.restoreToCount(i);
            return bool;
            if ((localLayoutParams.dimWhenOffset) && (this.mSlideOffset > 0.0F)) {
                if (!paramView.isDrawingCacheEnabled()) {
                    paramView.setDrawingCacheEnabled(true);
                }
                Bitmap localBitmap = paramView.getDrawingCache();
                if (localBitmap != null) {
                    paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localLayoutParams.dimPaint);
                    bool = false;
                } else {
                    Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
                    bool = super.drawChild(paramCanvas, paramView, paramLong);
                }
            } else {
                if (paramView.isDrawingCacheEnabled()) {
                    paramView.setDrawingCacheEnabled(false);
                }
                bool = super.drawChild(paramCanvas, paramView, paramLong);
            }
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new LayoutParams(getContext(), paramAttributeSet);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) paramLayoutParams);
        }
        return new LayoutParams(paramLayoutParams);
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    boolean isDimmed(View paramView) {
        if (paramView == null) {
            return false;
        }
        paramView = (LayoutParams) paramView.getLayoutParams();
        if ((this.mCanSlide) && (paramView.dimWhenOffset) && (this.mSlideOffset > 0.0F)) {
        }
        for (boolean bool = true; ; bool = false) {
            return bool;
        }
    }

    public boolean isOpen() {
        return (!this.mCanSlide) || (this.mSlideOffset == 1.0F);
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int j = this.mPostedRunnables.size();
        int i = 0;
        while (i < j) {
            ((DisableLayerRunnable) this.mPostedRunnables.get(i)).run();
            i += 1;
        }
        this.mPostedRunnables.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool2 = false;
        int i = MotionEventCompat.getActionMasked(paramMotionEvent);
        if ((!this.mCanSlide) && (i == 0) && (getChildCount() > 1)) {
            View localView = getChildAt(1);
            if (localView != null) {
                if (this.mDragHelper.isViewUnder(localView, (int) paramMotionEvent.getX(), (int) paramMotionEvent.getY())) {
                    break label108;
                }
            }
        }
        label108:
        for (boolean bool1 = true; ; bool1 = false) {
            this.mPreservedOpenState = bool1;
            if ((this.mCanSlide) && ((!this.mIsUnableToDrag) || (i == 0))) {
                break;
            }
            this.mDragHelper.cancel();
            bool1 = super.onInterceptTouchEvent(paramMotionEvent);
            return bool1;
        }
        if ((i == 3) || (i == 1)) {
            this.mDragHelper.cancel();
            return false;
        }
        switch (i) {
        }
        label164:
        float f1;
        float f2;
        do {
            for (i = 0; ; i = 1) {
                if (!this.mDragHelper.shouldInterceptTouchEvent(paramMotionEvent)) {
                    bool1 = bool2;
                    if (i == 0) {
                        break;
                    }
                }
                return true;
                this.mIsUnableToDrag = false;
                f1 = paramMotionEvent.getX();
                f2 = paramMotionEvent.getY();
                this.mInitialMotionX = f1;
                this.mInitialMotionY = f2;
                if ((!this.mDragHelper.isViewUnder(this.mSlideableView, (int) f1, (int) f2)) || (!isDimmed(this.mSlideableView))) {
                    break label164;
                }
            }
            f2 = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            f2 = Math.abs(f2 - this.mInitialMotionX);
            f1 = Math.abs(f1 - this.mInitialMotionY);
        } while ((f2 <= this.mDragHelper.getTouchSlop()) || (f1 <= f2));
        this.mDragHelper.cancel();
        this.mIsUnableToDrag = true;
        return false;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int j = paramInt3 - paramInt1;
        paramInt1 = getPaddingLeft();
        int k = getPaddingRight();
        int m = getPaddingTop();
        int i = getChildCount();
        if (this.mFirstLayout) {
            if ((!this.mCanSlide) || (!this.mPreservedOpenState)) {
                break label98;
            }
        }
        View localView;
        label98:
        for (float f = 1.0F; ; f = 0.0F) {
            this.mSlideOffset = f;
            paramInt4 = 0;
            paramInt2 = paramInt1;
            for (; ; ) {
                if (paramInt4 >= i) {
                    break label332;
                }
                localView = getChildAt(paramInt4);
                if (localView.getVisibility() != 8) {
                    break;
                }
                paramInt4 += 1;
            }
        }
        LayoutParams localLayoutParams = (LayoutParams) localView.getLayoutParams();
        int n = localView.getMeasuredWidth();
        if (localLayoutParams.slideable) {
            paramInt3 = localLayoutParams.leftMargin;
            int i1 = localLayoutParams.rightMargin;
            paramInt3 = Math.min(paramInt1, j - k - this.mOverhangSize) - paramInt2 - (paramInt3 + i1);
            this.mSlideRange = paramInt3;
            if (localLayoutParams.leftMargin + paramInt2 + paramInt3 + n / 2 > j - k) {
                paramBoolean = true;
                label198:
                localLayoutParams.dimWhenOffset = paramBoolean;
                paramInt3 = (int) (paramInt3 * this.mSlideOffset);
                i1 = localLayoutParams.leftMargin;
                this.mSlideOffset = (paramInt3 / this.mSlideRange);
                paramInt2 = i1 + paramInt3 + paramInt2;
                paramInt3 = 0;
            }
        }
        for (; ; ) {
            paramInt3 = paramInt2 - paramInt3;
            localView.layout(paramInt3, m, paramInt3 + n, localView.getMeasuredHeight() + m);
            paramInt1 += localView.getWidth();
            break;
            paramBoolean = false;
            break label198;
            if ((this.mCanSlide) && (this.mParallaxBy != 0)) {
                paramInt3 = (int) ((1.0F - this.mSlideOffset) * this.mParallaxBy);
                paramInt2 = paramInt1;
            } else {
                paramInt3 = 0;
                paramInt2 = paramInt1;
            }
        }
        label332:
        if (this.mFirstLayout) {
            if (!this.mCanSlide) {
                break label407;
            }
            if (this.mParallaxBy != 0) {
                parallaxOtherViews(this.mSlideOffset);
            }
            if (((LayoutParams) this.mSlideableView.getLayoutParams()).dimWhenOffset) {
                dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
            }
        }
        for (; ; ) {
            updateObscuredViewsVisibility(this.mSlideableView);
            this.mFirstLayout = false;
            return;
            label407:
            paramInt1 = 0;
            while (paramInt1 < i) {
                dimChildView(getChildAt(paramInt1), 0.0F, this.mSliderFadeColor);
                paramInt1 += 1;
            }
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int k = View.MeasureSpec.getMode(paramInt1);
        int i = View.MeasureSpec.getSize(paramInt1);
        int j = View.MeasureSpec.getMode(paramInt2);
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
        if (k != 1073741824) {
            if (isInEditMode()) {
                if (k == Integer.MIN_VALUE) {
                    paramInt2 = i;
                    i = j;
                }
            }
        }
        for (; ; ) {
            label85:
            boolean bool1;
            int i2;
            int i1;
            float f1;
            label132:
            View localView;
            LayoutParams localLayoutParams;
            switch (i) {
                default:
                    paramInt1 = 0;
                    k = -1;
                    bool1 = false;
                    j = paramInt2 - getPaddingLeft() - getPaddingRight();
                    i2 = getChildCount();
                    if (i2 > 2) {
                        Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
                    }
                    this.mSlideableView = null;
                    i1 = 0;
                    f1 = 0.0F;
                    if (i1 >= i2) {
                        break label611;
                    }
                    localView = getChildAt(i1);
                    localLayoutParams = (LayoutParams) localView.getLayoutParams();
                    if (localView.getVisibility() == 8) {
                        localLayoutParams.dimWhenOffset = false;
                        m = j;
                        j = paramInt1;
                        paramInt1 = m;
                    }
                    break;
            }
            float f2;
            for (; ; ) {
                i1 += 1;
                m = j;
                j = paramInt1;
                paramInt1 = m;
                break label132;
                if (k != 0) {
                    break label1087;
                }
                i = j;
                paramInt2 = 300;
                break;
                throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
                if (j != 0) {
                    break label1087;
                }
                if (isInEditMode()) {
                    if (j != 0) {
                        break label1087;
                    }
                    j = Integer.MIN_VALUE;
                    paramInt2 = i;
                    paramInt1 = 300;
                    i = j;
                    break;
                }
                throw new IllegalStateException("Height must not be UNSPECIFIED");
                paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
                k = paramInt1;
                break label85;
                k = getPaddingTop();
                m = getPaddingBottom();
                j = 0;
                k = paramInt1 - k - m;
                paramInt1 = j;
                break label85;
                f2 = f1;
                if (localLayoutParams.weight <= 0.0F) {
                    break label369;
                }
                f1 += localLayoutParams.weight;
                f2 = f1;
                if (localLayoutParams.width != 0) {
                    break label369;
                }
                m = paramInt1;
                paramInt1 = j;
                j = m;
            }
            label369:
            int m = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
            label404:
            int n;
            label424:
            int i3;
            if (localLayoutParams.width == -2) {
                m = View.MeasureSpec.makeMeasureSpec(paramInt2 - m, Integer.MIN_VALUE);
                if (localLayoutParams.height != -2) {
                    break label567;
                }
                n = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                localView.measure(m, n);
                n = localView.getMeasuredWidth();
                i3 = localView.getMeasuredHeight();
                m = paramInt1;
                if (i == Integer.MIN_VALUE) {
                    m = paramInt1;
                    if (i3 > paramInt1) {
                        m = Math.min(i3, k);
                    }
                }
                paramInt1 = j - n;
                if (paramInt1 >= 0) {
                    break label605;
                }
            }
            label567:
            label605:
            for (boolean bool2 = true; ; bool2 = false) {
                localLayoutParams.slideable = bool2;
                if (localLayoutParams.slideable) {
                    this.mSlideableView = localView;
                }
                j = m;
                bool1 = bool2 | bool1;
                f1 = f2;
                break;
                if (localLayoutParams.width == -1) {
                    m = View.MeasureSpec.makeMeasureSpec(paramInt2 - m, 1073741824);
                    break label404;
                }
                m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
                break label404;
                if (localLayoutParams.height == -1) {
                    n = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                    break label424;
                }
                n = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                break label424;
            }
            label611:
            if ((bool1) || (f1 > 0.0F)) {
                i1 = paramInt2 - this.mOverhangSize;
                m = 0;
                if (m < i2) {
                    localView = getChildAt(m);
                    if (localView.getVisibility() == 8) {
                    }
                    for (; ; ) {
                        m += 1;
                        break;
                        localLayoutParams = (LayoutParams) localView.getLayoutParams();
                        if (localView.getVisibility() != 8) {
                            if ((localLayoutParams.width == 0) && (localLayoutParams.weight > 0.0F)) {
                                i = 1;
                                label708:
                                if (i == 0) {
                                    break label804;
                                }
                                n = 0;
                                label716:
                                if ((!bool1) || (localView == this.mSlideableView)) {
                                    break label868;
                                }
                                if ((localLayoutParams.width >= 0) || ((n <= i1) && (localLayoutParams.weight <= 0.0F))) {
                                    continue;
                                }
                                if (i == 0) {
                                    break label852;
                                }
                                if (localLayoutParams.height != -2) {
                                    break label814;
                                }
                                i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                            }
                            for (; ; ) {
                                localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i);
                                break;
                                i = 0;
                                break label708;
                                label804:
                                n = localView.getMeasuredWidth();
                                break label716;
                                label814:
                                if (localLayoutParams.height == -1) {
                                    i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                                } else {
                                    i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                                    continue;
                                    label852:
                                    i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                                }
                            }
                            label868:
                            if (localLayoutParams.weight > 0.0F) {
                                if (localLayoutParams.width == 0) {
                                    if (localLayoutParams.height == -2) {
                                        i = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
                                    }
                                }
                                for (; ; ) {
                                    if (!bool1) {
                                        break label1013;
                                    }
                                    i3 = localLayoutParams.leftMargin;
                                    i3 = paramInt2 - (localLayoutParams.rightMargin + i3);
                                    int i4 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                                    if (n == i3) {
                                        break;
                                    }
                                    localView.measure(i4, i);
                                    break;
                                    if (localLayoutParams.height == -1) {
                                        i = View.MeasureSpec.makeMeasureSpec(k, 1073741824);
                                    } else {
                                        i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                                        continue;
                                        i = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                                    }
                                }
                                label1013:
                                i3 = Math.max(0, j);
                                localView.measure(View.MeasureSpec.makeMeasureSpec((int) (localLayoutParams.weight * i3 / f1) + n, 1073741824), i);
                            }
                        }
                    }
                }
            }
            setMeasuredDimension(paramInt2, paramInt1);
            this.mCanSlide = bool1;
            if ((this.mDragHelper.getViewDragState() != 0) && (!bool1)) {
                this.mDragHelper.abort();
            }
            return;
            label1087:
            paramInt2 = i;
            i = j;
        }
    }

    protected void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        if (paramParcelable.isOpen) {
            openPane();
        }
        for (; ; ) {
            this.mPreservedOpenState = paramParcelable.isOpen;
            return;
            closePane();
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState localSavedState = new SavedState(super.onSaveInstanceState());
        if (isSlideable()) {
        }
        for (boolean bool = isOpen(); ; bool = this.mPreservedOpenState) {
            localSavedState.isOpen = bool;
            return localSavedState;
        }
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramInt1 != paramInt3) {
            this.mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        boolean bool1;
        if (!this.mCanSlide) {
            bool1 = super.onTouchEvent(paramMotionEvent);
        }
        float f1;
        float f2;
        do {
            int i;
            boolean bool2;
            float f3;
            float f4;
            do {
                do {
                    return bool1;
                    this.mDragHelper.processTouchEvent(paramMotionEvent);
                    i = paramMotionEvent.getAction();
                    bool2 = true;
                    switch (i & 0xFF) {
                        default:
                            return true;
                        case 0:
                            f1 = paramMotionEvent.getX();
                            f2 = paramMotionEvent.getY();
                            this.mInitialMotionX = f1;
                            this.mInitialMotionY = f2;
                            return true;
                    }
                    bool1 = bool2;
                } while (!isDimmed(this.mSlideableView));
                f1 = paramMotionEvent.getX();
                f2 = paramMotionEvent.getY();
                f3 = f1 - this.mInitialMotionX;
                f4 = f2 - this.mInitialMotionY;
                i = this.mDragHelper.getTouchSlop();
                bool1 = bool2;
            } while (f3 * f3 + f4 * f4 >= i * i);
            bool1 = bool2;
        } while (!this.mDragHelper.isViewUnder(this.mSlideableView, (int) f1, (int) f2));
        closePane(this.mSlideableView, 0);
        return true;
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    public void requestChildFocus(View paramView1, View paramView2) {
        super.requestChildFocus(paramView1, paramView2);
        if ((!isInTouchMode()) && (!this.mCanSlide)) {
            if (paramView1 != this.mSlideableView) {
                break label36;
            }
        }
        label36:
        for (boolean bool = true; ; bool = false) {
            this.mPreservedOpenState = bool;
            return;
        }
    }

    void setAllChildrenVisible() {
        int j = getChildCount();
        int i = 0;
        while (i < j) {
            View localView = getChildAt(i);
            if (localView.getVisibility() == 4) {
                localView.setVisibility(0);
            }
            i += 1;
        }
    }

    public void setCoveredFadeColor(int paramInt) {
        this.mCoveredFadeColor = paramInt;
    }

    public void setPanelSlideListener(PanelSlideListener paramPanelSlideListener) {
        this.mPanelSlideListener = paramPanelSlideListener;
    }

    public void setParallaxDistance(int paramInt) {
        this.mParallaxBy = paramInt;
        requestLayout();
    }

    public void setShadowDrawable(Drawable paramDrawable) {
        this.mShadowDrawable = paramDrawable;
    }

    public void setShadowResource(int paramInt) {
        setShadowDrawable(getResources().getDrawable(paramInt));
    }

    public void setSliderFadeColor(int paramInt) {
        this.mSliderFadeColor = paramInt;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    boolean smoothSlideTo(float paramFloat, int paramInt) {
        if (!this.mCanSlide) {
            return false;
        }
        LayoutParams localLayoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        paramInt = getPaddingLeft();
        paramInt = (int) (localLayoutParams.leftMargin + paramInt + this.mSlideRange * paramFloat);
        if (this.mDragHelper.smoothSlideViewTo(this.mSlideableView, paramInt, this.mSlideableView.getTop())) {
            setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
        }
        return false;
    }

    void updateObscuredViewsVisibility(View paramView) {
        int i2 = getPaddingLeft();
        int i3 = getWidth();
        int i4 = getPaddingRight();
        int i5 = getPaddingTop();
        int i6 = getHeight();
        int i7 = getPaddingBottom();
        int m;
        int k;
        int j;
        int i;
        if ((paramView != null) && (viewIsOpaque(paramView))) {
            m = paramView.getLeft();
            k = paramView.getRight();
            j = paramView.getTop();
            i = paramView.getBottom();
        }
        int n;
        View localView;
        for (; ; ) {
            int i8 = getChildCount();
            n = 0;
            if (n < i8) {
                localView = getChildAt(n);
                if (localView != paramView) {
                    break;
                }
            }
            return;
            i = 0;
            j = 0;
            k = 0;
            m = 0;
        }
        int i1 = Math.max(i2, localView.getLeft());
        int i9 = Math.max(i5, localView.getTop());
        int i10 = Math.min(i3 - i4, localView.getRight());
        int i11 = Math.min(i6 - i7, localView.getBottom());
        if ((i1 >= m) && (i9 >= j) && (i10 <= k) && (i11 <= i)) {
        }
        for (i1 = 4; ; i1 = 0) {
            localView.setVisibility(i1);
            n += 1;
            break;
        }
    }

    class AccessibilityDelegate
            extends AccessibilityDelegateCompat {
        private final Rect mTmpRect = new Rect();

        AccessibilityDelegate() {
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
            paramAccessibilityNodeInfoCompat1.setMovementGranularities(paramAccessibilityNodeInfoCompat2.getMovementGranularities());
        }

        public boolean filter(View paramView) {
            return SlidingPaneLayout.this.isDimmed(paramView);
        }

        public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent) {
            super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
            paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
            super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
            copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
            localAccessibilityNodeInfoCompat.recycle();
            paramAccessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
            paramAccessibilityNodeInfoCompat.setSource(paramView);
            paramView = ViewCompat.getParentForAccessibility(paramView);
            if ((paramView instanceof View)) {
                paramAccessibilityNodeInfoCompat.setParent((View) paramView);
            }
            int j = SlidingPaneLayout.this.getChildCount();
            int i = 0;
            while (i < j) {
                paramView = SlidingPaneLayout.this.getChildAt(i);
                if ((!filter(paramView)) && (paramView.getVisibility() == 0)) {
                    ViewCompat.setImportantForAccessibility(paramView, 1);
                    paramAccessibilityNodeInfoCompat.addChild(paramView);
                }
                i += 1;
            }
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent) {
            if (!filter(paramView)) {
                return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
            }
            return false;
        }
    }

    private class DisableLayerRunnable
            implements Runnable {
        final View mChildView;

        DisableLayerRunnable(View paramView) {
            this.mChildView = paramView;
        }

        public void run() {
            if (this.mChildView.getParent() == SlidingPaneLayout.this) {
                ViewCompat.setLayerType(this.mChildView, 0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.mChildView);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    private class DragHelperCallback
            extends ViewDragHelper.Callback {
        private DragHelperCallback() {
        }

        public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2) {
            paramView = (SlidingPaneLayout.LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            paramInt2 = SlidingPaneLayout.this.getPaddingLeft();
            paramInt2 = paramView.leftMargin + paramInt2;
            int i = SlidingPaneLayout.this.mSlideRange;
            return Math.min(Math.max(paramInt1, paramInt2), i + paramInt2);
        }

        public int getViewHorizontalDragRange(View paramView) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        public void onEdgeDragStarted(int paramInt1, int paramInt2) {
            SlidingPaneLayout.this.mDragHelper.captureChildView(SlidingPaneLayout.this.mSlideableView, paramInt2);
        }

        public void onViewCaptured(View paramView, int paramInt) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        public void onViewDragStateChanged(int paramInt) {
            if (SlidingPaneLayout.this.mDragHelper.getViewDragState() == 0) {
                if (SlidingPaneLayout.this.mSlideOffset == 0.0F) {
                    SlidingPaneLayout.this.updateObscuredViewsVisibility(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.this.dispatchOnPanelClosed(SlidingPaneLayout.this.mSlideableView);
                    SlidingPaneLayout.access$502(SlidingPaneLayout.this, false);
                }
            } else {
                return;
            }
            SlidingPaneLayout.this.dispatchOnPanelOpened(SlidingPaneLayout.this.mSlideableView);
            SlidingPaneLayout.access$502(SlidingPaneLayout.this, true);
        }

        public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
            SlidingPaneLayout.this.onPanelDragged(paramInt1);
            SlidingPaneLayout.this.invalidate();
        }

        public void onViewReleased(View paramView, float paramFloat1, float paramFloat2) {
            SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams) paramView.getLayoutParams();
            int i = SlidingPaneLayout.this.getPaddingLeft();
            int j = localLayoutParams.leftMargin + i;
            if (paramFloat1 <= 0.0F) {
                i = j;
                if (paramFloat1 == 0.0F) {
                    i = j;
                    if (SlidingPaneLayout.this.mSlideOffset <= 0.5F) {
                    }
                }
            } else {
                i = j + SlidingPaneLayout.this.mSlideRange;
            }
            SlidingPaneLayout.this.mDragHelper.settleCapturedViewAt(i, paramView.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public boolean tryCaptureView(View paramView, int paramInt) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((SlidingPaneLayout.LayoutParams) paramView.getLayoutParams()).slideable;
        }
    }

    public static class LayoutParams
            extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;
        public float weight = 0.0F;

        public LayoutParams() {
            super(-1);
        }

        public LayoutParams(int paramInt1, int paramInt2) {
            super(paramInt2);
        }

        public LayoutParams(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
            paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
            this.weight = paramContext.getFloat(0, 0.0F);
            paramContext.recycle();
        }

        public LayoutParams(LayoutParams paramLayoutParams) {
            super();
            this.weight = paramLayoutParams.weight;
        }

        public LayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
            super();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams) {
            super();
        }
    }

    public static abstract interface PanelSlideListener {
        public abstract void onPanelClosed(View paramView);

        public abstract void onPanelOpened(View paramView);

        public abstract void onPanelSlide(View paramView, float paramFloat);
    }

    static class SavedState
            extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {
            public SlidingPaneLayout.SavedState createFromParcel(Parcel paramAnonymousParcel) {
                return new SlidingPaneLayout.SavedState(paramAnonymousParcel, null);
            }

            public SlidingPaneLayout.SavedState[] newArray(int paramAnonymousInt) {
                return new SlidingPaneLayout.SavedState[paramAnonymousInt];
            }
        };
        boolean isOpen;

        private SavedState(Parcel paramParcel) {
            super();
            if (paramParcel.readInt() != 0) {
            }
            for (boolean bool = true; ; bool = false) {
                this.isOpen = bool;
                return;
            }
        }

        SavedState(Parcelable paramParcelable) {
            super();
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            super.writeToParcel(paramParcel, paramInt);
            if (this.isOpen) {
            }
            for (paramInt = 1; ; paramInt = 0) {
                paramParcel.writeInt(paramInt);
                return;
            }
        }
    }

    public static class SimplePanelSlideListener
            implements SlidingPaneLayout.PanelSlideListener {
        public void onPanelClosed(View paramView) {
        }

        public void onPanelOpened(View paramView) {
        }

        public void onPanelSlide(View paramView, float paramFloat) {
        }
    }

    static abstract interface SlidingPanelLayoutImpl {
        public abstract void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
    }

    static class SlidingPanelLayoutImplBase
            implements SlidingPaneLayout.SlidingPanelLayoutImpl {
        public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView) {
            ViewCompat.postInvalidateOnAnimation(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
        }
    }

    static class SlidingPanelLayoutImplJB
            extends SlidingPaneLayout.SlidingPanelLayoutImplBase {
        private Method mGetDisplayList;
        private Field mRecreateDisplayList;

        SlidingPanelLayoutImplJB() {
            try {
                this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException localNoSuchMethodException) {
                for (; ; ) {
                    try {
                        this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                        this.mRecreateDisplayList.setAccessible(true);
                        return;
                    } catch (NoSuchFieldException localNoSuchFieldException) {
                        Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
                    }
                    localNoSuchMethodException = localNoSuchMethodException;
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
                }
            }
        }

        public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView) {
            if ((this.mGetDisplayList != null) && (this.mRecreateDisplayList != null)) {
                try {
                    this.mRecreateDisplayList.setBoolean(paramView, true);
                    this.mGetDisplayList.invoke(paramView, (Object[]) null);
                    super.invalidateChildRegion(paramSlidingPaneLayout, paramView);
                    return;
                } catch (Exception localException) {
                    for (; ; ) {
                        Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
                    }
                }
            }
            paramView.invalidate();
        }
    }

    static class SlidingPanelLayoutImplJBMR1
            extends SlidingPaneLayout.SlidingPanelLayoutImplBase {
        public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView) {
            ViewCompat.setLayerPaint(paramView, ((SlidingPaneLayout.LayoutParams) paramView.getLayoutParams()).dimPaint);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v4/widget/SlidingPaneLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */