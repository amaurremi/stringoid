package com.zgy.view.listview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class StickyListHeadersListView
        extends ListView {
    private AdapterWrapper mAdapter;
    private AdapterWrapper.OnHeaderClickListener mAdapterHeaderClickListener = new AdapterWrapper.OnHeaderClickListener() {
        public void onHeaderClick(View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
            if (StickyListHeadersListView.this.mOnHeaderClickListener != null) {
                StickyListHeadersListView.this.mOnHeaderClickListener.onHeaderClick(StickyListHeadersListView.this, paramAnonymousView, paramAnonymousInt, paramAnonymousLong, false);
            }
        }
    };
    private boolean mAreHeadersSticky = true;
    private final Rect mClippingRect = new Rect();
    private Boolean mClippingToPadding;
    private Long mCurrentHeaderId = null;
    private DataSetObserver mDataSetChangedObserver = new DataSetObserver() {
        public void onChanged() {
            StickyListHeadersListView.this.reset();
        }

        public void onInvalidated() {
            StickyListHeadersListView.this.reset();
        }
    };
    private Drawable mDivider;
    private int mDividerHeight;
    private boolean mDrawingListUnderStickyHeader = false;
    private ArrayList<View> mFooterViews;
    private View mHeader;
    private boolean mHeaderBeingPressed = false;
    private int mHeaderBottomPosition;
    private float mHeaderDownY = -1.0F;
    private Integer mHeaderPosition;
    private OnHeaderClickListener mOnHeaderClickListener;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {
            if (StickyListHeadersListView.this.mOnScrollListenerDelegate != null) {
                StickyListHeadersListView.this.mOnScrollListenerDelegate.onScroll(paramAnonymousAbsListView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
            }
            if (Build.VERSION.SDK_INT >= 8) {
                StickyListHeadersListView.this.scrollChanged(paramAnonymousInt1);
            }
        }

        public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {
            if (StickyListHeadersListView.this.mOnScrollListenerDelegate != null) {
                StickyListHeadersListView.this.mOnScrollListenerDelegate.onScrollStateChanged(paramAnonymousAbsListView, paramAnonymousInt);
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListenerDelegate;
    private Field mSelectorPositionField;
    private Rect mSelectorRect = new Rect();
    private ViewConfiguration mViewConfig;

    public StickyListHeadersListView(Context paramContext) {
        this(paramContext, null);
    }

    public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet) {
        this(paramContext, paramAttributeSet, 16842868);
    }

    public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        super.setOnScrollListener(this.mOnScrollListener);
        super.setDivider(null);
        super.setDividerHeight(0);
        this.mViewConfig = ViewConfiguration.get(paramContext);
        if (this.mClippingToPadding == null) {
            this.mClippingToPadding = Boolean.valueOf(true);
        }
        try {
            paramContext = AbsListView.class.getDeclaredField("mSelectorRect");
            paramContext.setAccessible(true);
            this.mSelectorRect = ((Rect) paramContext.get(this));
            this.mSelectorPositionField = AbsListView.class.getDeclaredField("mSelectorPosition");
            this.mSelectorPositionField.setAccessible(true);
            return;
        } catch (NoSuchFieldException paramContext) {
            paramContext.printStackTrace();
            return;
        } catch (IllegalArgumentException paramContext) {
            paramContext.printStackTrace();
            return;
        } catch (IllegalAccessException paramContext) {
            paramContext.printStackTrace();
        }
    }

    private void drawStickyHeader(Canvas paramCanvas) {
        int i = getHeaderHeight();
        int j = this.mHeaderBottomPosition - i;
        this.mClippingRect.left = getPaddingLeft();
        this.mClippingRect.right = (getWidth() - getPaddingRight());
        this.mClippingRect.bottom = (j + i);
        Rect localRect = this.mClippingRect;
        if (this.mClippingToPadding.booleanValue()) {
        }
        for (i = getPaddingTop(); ; i = 0) {
            localRect.top = i;
            paramCanvas.save();
            paramCanvas.clipRect(this.mClippingRect);
            paramCanvas.translate(getPaddingLeft(), j);
            this.mHeader.draw(paramCanvas);
            paramCanvas.restore();
            return;
        }
    }

    private int fixedFirstVisibleItem(int paramInt) {
        if (Build.VERSION.SDK_INT >= 11) {
            return paramInt;
        }
        int i = 0;
        for (; ; ) {
            if (i >= getChildCount()) {
            }
            for (; ; ) {
                i = paramInt;
                if (!this.mClippingToPadding.booleanValue()) {
                    i = paramInt;
                    if (getPaddingTop() > 0) {
                        i = paramInt;
                        if (super.getChildAt(0).getTop() > 0) {
                            i = paramInt;
                            if (paramInt > 0) {
                                i = paramInt - 1;
                            }
                        }
                    }
                }
                return i;
                if (getChildAt(i).getBottom() < 0) {
                    break;
                }
                paramInt += i;
            }
            i += 1;
        }
    }

    private int getHeaderHeight() {
        if (this.mHeader == null) {
            return 0;
        }
        return this.mHeader.getMeasuredHeight();
    }

    private int getSelectorPosition() {
        int i;
        if (this.mSelectorPositionField == null) {
            i = 0;
            if (i < getChildCount()) {
            }
        }
        for (; ; ) {
            return -1;
            if (getChildAt(i).getBottom() == this.mSelectorRect.bottom) {
                return fixedFirstVisibleItem(getFirstVisiblePosition()) + i;
            }
            i += 1;
            break;
            try {
                i = this.mSelectorPositionField.getInt(this);
                return i;
            } catch (IllegalArgumentException localIllegalArgumentException) {
                localIllegalArgumentException.printStackTrace();
            } catch (IllegalAccessException localIllegalAccessException) {
                localIllegalAccessException.printStackTrace();
            }
        }
    }

    private boolean hasStickyHeaderAtPosition(int paramInt) {
        paramInt -= getHeaderViewsCount();
        return (this.mAreHeadersSticky) && (paramInt > 0) && (paramInt < this.mAdapter.getCount()) && (this.mAdapter.getHeaderId(paramInt) == this.mAdapter.getHeaderId(paramInt - 1));
    }

    private boolean isScrollBarOverlay() {
        int i = getScrollBarStyle();
        return (i == 0) || (i == 33554432);
    }

    private void measureHeader() {
        int j = getWidth();
        int k = getPaddingLeft();
        int m = getPaddingRight();
        ViewGroup.LayoutParams localLayoutParams;
        if (isScrollBarOverlay()) {
            i = 0;
            j = View.MeasureSpec.makeMeasureSpec(j - k - m - i, 1073741824);
            localLayoutParams = this.mHeader.getLayoutParams();
            if (localLayoutParams == null) {
                this.mHeader.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
            }
            if ((localLayoutParams == null) || (localLayoutParams.height <= 0)) {
                break label142;
            }
        }
        label142:
        for (int i = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824); ; i = View.MeasureSpec.makeMeasureSpec(0, 0)) {
            this.mHeader.measure(j, i);
            this.mHeader.layout(getPaddingLeft(), 0, getWidth() - getPaddingRight(), this.mHeader.getMeasuredHeight());
            return;
            i = getVerticalScrollbarWidth();
            break;
        }
    }

    private void positionSelectorRect() {
        if (!this.mSelectorRect.isEmpty()) {
            int i = getSelectorPosition();
            if (i >= 0) {
                Object localObject = getChildAt(i - fixedFirstVisibleItem(getFirstVisiblePosition()));
                if ((localObject instanceof WrapperView)) {
                    localObject = (WrapperView) localObject;
                    this.mSelectorRect.top = (((WrapperView) localObject).getTop() + ((WrapperView) localObject).mItemTop);
                }
            }
        }
    }

    private void reset() {
        this.mHeader = null;
        this.mCurrentHeaderId = null;
        this.mHeaderPosition = null;
        this.mHeaderBottomPosition = -1;
    }

    private void scrollChanged(int paramInt) {
        if (this.mAdapter == null) {
        }
        for (int i = 0; (i == 0) || (!this.mAreHeadersSticky); i = this.mAdapter.getCount()) {
            return;
        }
        int i2 = getHeaderViewsCount();
        int i3 = fixedFirstVisibleItem(paramInt) - i2;
        if ((i3 < 0) || (i3 > i - 1)) {
            reset();
            updateHeaderVisibilities();
            invalidate();
            return;
        }
        if ((this.mHeaderPosition == null) || (this.mHeaderPosition.intValue() != i3)) {
            this.mHeaderPosition = Integer.valueOf(i3);
            this.mCurrentHeaderId = Long.valueOf(this.mAdapter.getHeaderId(i3));
            this.mHeader = this.mAdapter.getHeaderView(this.mHeaderPosition.intValue(), this.mHeader, this);
            measureHeader();
        }
        int i4 = getChildCount();
        Object localObject1;
        int k;
        int j;
        if (i4 != 0) {
            localObject1 = null;
            k = Integer.MAX_VALUE;
            j = 0;
            i = 0;
            if (i >= i4) {
                i = getHeaderHeight();
                if ((localObject1 == null) || ((j == 0) && (!((WrapperView) localObject1).hasHeader()))) {
                    break label485;
                }
                if ((i3 != i2) || (super.getChildAt(0).getTop() <= 0) || (this.mClippingToPadding.booleanValue())) {
                    break label422;
                }
                this.mHeaderBottomPosition = 0;
            }
        } else {
            updateHeaderVisibilities();
            invalidate();
            return;
        }
        View localView = super.getChildAt(i);
        label269:
        int n;
        int m;
        label292:
        int i1;
        Object localObject2;
        if ((this.mFooterViews != null) && (this.mFooterViews.contains(localView))) {
            paramInt = 1;
            n = localView.getTop();
            if (!this.mClippingToPadding.booleanValue()) {
                break label338;
            }
            m = getPaddingTop();
            i1 = n - m;
            if (i1 >= 0) {
                break label344;
            }
            n = k;
            m = j;
            localObject2 = localObject1;
        }
        for (; ; ) {
            i += 1;
            localObject1 = localObject2;
            j = m;
            k = n;
            break;
            paramInt = 0;
            break label269;
            label338:
            m = 0;
            break label292;
            label344:
            if ((localObject1 != null) && ((j != 0) || (((WrapperView) localObject1).hasHeader()))) {
                if (paramInt == 0) {
                    localObject2 = localObject1;
                    m = j;
                    n = k;
                    if (!((WrapperView) localView).hasHeader()) {
                    }
                } else {
                    localObject2 = localObject1;
                    m = j;
                    n = k;
                    if (i1 >= k) {
                    }
                }
            } else {
                localObject2 = localView;
                n = i1;
                m = paramInt;
            }
        }
        label422:
        if (this.mClippingToPadding.booleanValue()) {
            paramInt = getPaddingTop();
            label437:
            this.mHeaderBottomPosition = Math.min(((View) localObject1).getTop(), i + paramInt);
            if (this.mHeaderBottomPosition >= paramInt) {
                break label477;
            }
        }
        label477:
        for (paramInt = i + paramInt; ; paramInt = this.mHeaderBottomPosition) {
            this.mHeaderBottomPosition = paramInt;
            break;
            paramInt = 0;
            break label437;
        }
        label485:
        if (this.mClippingToPadding.booleanValue()) {
        }
        for (paramInt = getPaddingTop(); ; paramInt = 0) {
            this.mHeaderBottomPosition = (paramInt + i);
            break;
        }
    }

    private void updateHeaderVisibilities() {
        if (this.mClippingToPadding.booleanValue()) {
        }
        int j;
        for (int i = getPaddingTop(); ; i = 0) {
            int k = getChildCount();
            j = 0;
            if (j < k) {
                break;
            }
            return;
        }
        Object localObject = super.getChildAt(j);
        View localView;
        if ((localObject instanceof WrapperView)) {
            localObject = (WrapperView) localObject;
            if (((WrapperView) localObject).hasHeader()) {
                localView = ((WrapperView) localObject).mHeader;
                if (((WrapperView) localObject).getTop() >= i) {
                    break label92;
                }
                localView.setVisibility(4);
            }
        }
        for (; ; ) {
            j += 1;
            break;
            label92:
            localView.setVisibility(0);
        }
    }

    private AdapterWrapper wrapAdapter(ListAdapter paramListAdapter) {
        paramListAdapter = new AdapterWrapper(getContext(), (StickyListHeadersAdapter) paramListAdapter);
        paramListAdapter.setDivider(this.mDivider);
        paramListAdapter.setDividerHeight(this.mDividerHeight);
        paramListAdapter.registerDataSetObserver(this.mDataSetChangedObserver);
        paramListAdapter.setOnHeaderClickListener(this.mAdapterHeaderClickListener);
        return paramListAdapter;
    }

    public void addFooterView(View paramView) {
        super.addFooterView(paramView);
        if (this.mFooterViews == null) {
            this.mFooterViews = new ArrayList();
        }
        this.mFooterViews.add(paramView);
    }

    protected void dispatchDraw(Canvas paramCanvas) {
        if (Build.VERSION.SDK_INT < 8) {
            scrollChanged(getFirstVisiblePosition());
        }
        positionSelectorRect();
        if ((!this.mAreHeadersSticky) || (this.mHeader == null)) {
            super.dispatchDraw(paramCanvas);
            return;
        }
        if (!this.mDrawingListUnderStickyHeader) {
            this.mClippingRect.set(0, this.mHeaderBottomPosition, getWidth(), getHeight());
            paramCanvas.save();
            paramCanvas.clipRect(this.mClippingRect);
        }
        super.dispatchDraw(paramCanvas);
        if (!this.mDrawingListUnderStickyHeader) {
            paramCanvas.restore();
        }
        drawStickyHeader(paramCanvas);
    }

    public boolean getAreHeadersSticky() {
        return this.mAreHeadersSticky;
    }

    public StickyListHeadersAdapter getWrappedAdapter() {
        if (this.mAdapter == null) {
            return null;
        }
        return this.mAdapter.mDelegate;
    }

    public View getWrappedView(int paramInt) {
        View localView2 = getChildAt(paramInt);
        View localView1 = localView2;
        if ((localView2 instanceof WrapperView)) {
            localView1 = ((WrapperView) localView2).mItem;
        }
        return localView1;
    }

    public boolean isDrawingListUnderStickyHeader() {
        return this.mDrawingListUnderStickyHeader;
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
        if (paramBoolean) {
            reset();
            scrollChanged(getFirstVisiblePosition());
        }
    }

    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        int i = paramMotionEvent.getAction();
        if ((i == 0) && (paramMotionEvent.getY() <= this.mHeaderBottomPosition)) {
            this.mHeaderDownY = paramMotionEvent.getY();
            this.mHeaderBeingPressed = true;
            this.mHeader.setPressed(true);
            this.mHeader.invalidate();
            invalidate(0, 0, getWidth(), this.mHeaderBottomPosition);
        }
        do {
            do {
                return true;
                if (!this.mHeaderBeingPressed) {
                    break label225;
                }
                if (Math.abs(paramMotionEvent.getY() - this.mHeaderDownY) >= this.mViewConfig.getScaledTouchSlop()) {
                    break;
                }
            } while ((i != 1) && (i != 3));
            this.mHeaderDownY = -1.0F;
            this.mHeaderBeingPressed = false;
            this.mHeader.setPressed(false);
            this.mHeader.invalidate();
            invalidate(0, 0, getWidth(), this.mHeaderBottomPosition);
        } while (this.mOnHeaderClickListener == null);
        this.mOnHeaderClickListener.onHeaderClick(this, this.mHeader, this.mHeaderPosition.intValue(), this.mCurrentHeaderId.longValue(), true);
        return true;
        this.mHeaderDownY = -1.0F;
        this.mHeaderBeingPressed = false;
        this.mHeader.setPressed(false);
        this.mHeader.invalidate();
        invalidate(0, 0, getWidth(), this.mHeaderBottomPosition);
        label225:
        return super.onTouchEvent(paramMotionEvent);
    }

    public boolean performItemClick(View paramView, int paramInt, long paramLong) {
        View localView = paramView;
        if ((paramView instanceof WrapperView)) {
            localView = ((WrapperView) paramView).mItem;
        }
        return super.performItemClick(localView, paramInt, paramLong);
    }

    public boolean removeFooterView(View paramView) {
        if (super.removeFooterView(paramView)) {
            this.mFooterViews.remove(paramView);
            return true;
        }
        return false;
    }

    public void setAdapter(ListAdapter paramListAdapter) {
        if (isInEditMode()) {
            super.setAdapter(paramListAdapter);
            return;
        }
        if (paramListAdapter == null) {
            this.mAdapter = null;
            reset();
            super.setAdapter(null);
            return;
        }
        if (!(paramListAdapter instanceof StickyListHeadersAdapter)) {
            throw new IllegalArgumentException("Adapter must implement StickyListHeadersAdapter");
        }
        this.mAdapter = wrapAdapter(paramListAdapter);
        reset();
        super.setAdapter(this.mAdapter);
    }

    public void setAreHeadersSticky(boolean paramBoolean) {
        if (this.mAreHeadersSticky != paramBoolean) {
            this.mAreHeadersSticky = paramBoolean;
            requestLayout();
        }
    }

    public void setClipToPadding(boolean paramBoolean) {
        super.setClipToPadding(paramBoolean);
        this.mClippingToPadding = Boolean.valueOf(paramBoolean);
    }

    public void setDivider(Drawable paramDrawable) {
        this.mDivider = paramDrawable;
        if (paramDrawable != null) {
            int i = paramDrawable.getIntrinsicHeight();
            if (i >= 0) {
                setDividerHeight(i);
            }
        }
        if (this.mAdapter != null) {
            this.mAdapter.setDivider(paramDrawable);
            requestLayout();
            invalidate();
        }
    }

    public void setDividerHeight(int paramInt) {
        this.mDividerHeight = paramInt;
        if (this.mAdapter != null) {
            this.mAdapter.setDividerHeight(paramInt);
            requestLayout();
            invalidate();
        }
    }

    public void setDrawingListUnderStickyHeader(boolean paramBoolean) {
        this.mDrawingListUnderStickyHeader = paramBoolean;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener paramOnHeaderClickListener) {
        this.mOnHeaderClickListener = paramOnHeaderClickListener;
    }

    public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener) {
        this.mOnScrollListenerDelegate = paramOnScrollListener;
    }

    public void setSelectionFromTop(int paramInt1, int paramInt2) {
        int i = paramInt2;
        if (hasStickyHeaderAtPosition(paramInt1)) {
            i = paramInt2 + getHeaderHeight();
        }
        super.setSelectionFromTop(paramInt1, i);
    }

    @SuppressLint({"NewApi"})
    public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2) {
        int i = paramInt2;
        if (hasStickyHeaderAtPosition(paramInt1)) {
            i = paramInt2 + getHeaderHeight();
        }
        super.smoothScrollToPositionFromTop(paramInt1, i);
    }

    @SuppressLint({"NewApi"})
    public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3) {
        int i = paramInt2;
        if (hasStickyHeaderAtPosition(paramInt1)) {
            i = paramInt2 + getHeaderHeight();
        }
        super.smoothScrollToPositionFromTop(paramInt1, i, paramInt3);
    }

    public static abstract interface OnHeaderClickListener {
        public abstract void onHeaderClick(StickyListHeadersListView paramStickyListHeadersListView, View paramView, int paramInt, long paramLong, boolean paramBoolean);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/zgy/view/listview/StickyListHeadersListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */