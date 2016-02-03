package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.anim;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

abstract class AbsActionBarView
        extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    protected ActionMenuView mMenuView;
    protected boolean mSplitActionBar;
    protected ActionBarContainer mSplitView;
    protected boolean mSplitWhenNarrow;

    AbsActionBarView(Context paramContext) {
        super(paramContext);
    }

    AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }

    AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
    }

    public void animateToVisibility(int paramInt) {
        clearAnimation();
        Object localObject;
        if (paramInt != getVisibility()) {
            localObject = getContext();
            if (paramInt != 0) {
                break label72;
            }
        }
        label72:
        for (int i = R.anim.abc_fade_in; ; i = R.anim.abc_fade_out) {
            localObject = AnimationUtils.loadAnimation((Context) localObject, i);
            startAnimation((Animation) localObject);
            setVisibility(paramInt);
            if ((this.mSplitView != null) && (this.mMenuView != null)) {
                this.mMenuView.startAnimation((Animation) localObject);
                this.mMenuView.setVisibility(paramInt);
            }
            return;
        }
    }

    public void dismissPopupMenus() {
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.dismissPopupMenus();
        }
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        return (this.mActionMenuPresenter != null) && (this.mActionMenuPresenter.isOverflowReserved());
    }

    protected int measureChildView(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, Integer.MIN_VALUE), paramInt2);
        return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
    }

    protected void onConfigurationChanged(Configuration paramConfiguration) {
        if (Build.VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(paramConfiguration);
        }
        TypedArray localTypedArray = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(localTypedArray.getLayoutDimension(1, 0));
        localTypedArray.recycle();
        if (this.mSplitWhenNarrow) {
            setSplitActionBar(getContext().getResources().getBoolean(R.bool.abc_split_action_bar_is_narrow));
        }
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.onConfigurationChanged(paramConfiguration);
        }
    }

    protected int positionChild(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramView.getMeasuredWidth();
        int j = paramView.getMeasuredHeight();
        paramInt2 = (paramInt3 - j) / 2 + paramInt2;
        paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
        return i;
    }

    protected int positionChildInverse(View paramView, int paramInt1, int paramInt2, int paramInt3) {
        int i = paramView.getMeasuredWidth();
        int j = paramView.getMeasuredHeight();
        paramInt2 = (paramInt3 - j) / 2 + paramInt2;
        paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
        return i;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() {
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public void setContentHeight(int paramInt) {
        this.mContentHeight = paramInt;
        requestLayout();
    }

    public void setSplitActionBar(boolean paramBoolean) {
        this.mSplitActionBar = paramBoolean;
    }

    public void setSplitView(ActionBarContainer paramActionBarContainer) {
        this.mSplitView = paramActionBarContainer;
    }

    public void setSplitWhenNarrow(boolean paramBoolean) {
        this.mSplitWhenNarrow = paramBoolean;
    }

    public void setVisibility(int paramInt) {
        if (paramInt != getVisibility()) {
            super.setVisibility(paramInt);
        }
    }

    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/internal/widget/AbsActionBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */