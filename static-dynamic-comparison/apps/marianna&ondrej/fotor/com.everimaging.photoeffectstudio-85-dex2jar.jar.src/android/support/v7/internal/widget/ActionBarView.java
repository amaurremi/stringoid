package android.support.v7.internal.widget;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.internal.view.menu.ActionMenuPresenter;
import android.support.v7.internal.view.menu.ActionMenuView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.view.CollapsibleActionView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.List;

public class ActionBarView
        extends AbsActionBarView {
    private static final int DEFAULT_CUSTOM_GRAVITY = 19;
    public static final int DISPLAY_DEFAULT = 0;
    private static final int DISPLAY_RELAYOUT_MASK = 31;
    private static final String TAG = "ActionBarView";
    private ActionBar.OnNavigationListener mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private View mCustomNavView;
    private int mDisplayOptions = -1;
    View mExpandedActionView;
    private final View.OnClickListener mExpandedActionViewUpListener = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            paramAnonymousView = ActionBarView.this.mExpandedMenuPresenter.mCurrentExpandedItem;
            if (paramAnonymousView != null) {
                paramAnonymousView.collapseActionView();
            }
        }
    };
    private HomeView mExpandedHomeLayout;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private HomeView mHomeLayout;
    private Drawable mIcon;
    private boolean mIncludeTabs;
    private int mIndeterminateProgressStyle;
    private ProgressBarICS mIndeterminateProgressView;
    private boolean mIsCollapsable;
    private boolean mIsCollapsed;
    private int mItemPadding;
    private LinearLayout mListNavLayout;
    private Drawable mLogo;
    private ActionMenuItem mLogoNavItem;
    private final AdapterViewICS.OnItemSelectedListener mNavItemSelectedListener = new AdapterViewICS.OnItemSelectedListener() {
        public void onItemSelected(AdapterViewICS<?> paramAnonymousAdapterViewICS, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {
            if (ActionBarView.this.mCallback != null) {
                ActionBarView.this.mCallback.onNavigationItemSelected(paramAnonymousInt, paramAnonymousLong);
            }
        }

        public void onNothingSelected(AdapterViewICS<?> paramAnonymousAdapterViewICS) {
        }
    };
    private int mNavigationMode;
    private MenuBuilder mOptionsMenu;
    private int mProgressBarPadding;
    private int mProgressStyle;
    private ProgressBarICS mProgressView;
    private SpinnerICS mSpinner;
    private SpinnerAdapter mSpinnerAdapter;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private ScrollingTabContainerView mTabScrollView;
    private Runnable mTabSelector;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private int mTitleStyleRes;
    private View mTitleUpView;
    private TextView mTitleView;
    private final View.OnClickListener mUpClickListener = new View.OnClickListener() {
        public void onClick(View paramAnonymousView) {
            ActionBarView.this.mWindowCallback.onMenuItemSelected(0, ActionBarView.this.mLogoNavItem);
        }
    };
    private boolean mUserTitle;
    Window.Callback mWindowCallback;

    public ActionBarView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        this.mContext = paramContext;
        setBackgroundResource(0);
        paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        Object localObject = paramContext.getApplicationInfo();
        PackageManager localPackageManager = paramContext.getPackageManager();
        this.mNavigationMode = paramAttributeSet.getInt(2, 0);
        this.mTitle = paramAttributeSet.getText(0);
        this.mSubtitle = paramAttributeSet.getText(4);
        this.mLogo = paramAttributeSet.getDrawable(8);
        if ((this.mLogo != null) || (Build.VERSION.SDK_INT < 9) || ((paramContext instanceof Activity))) {
        }
        try {
            this.mLogo = localPackageManager.getActivityLogo(((Activity) paramContext).getComponentName());
            if (this.mLogo == null) {
                this.mLogo = ((ApplicationInfo) localObject).loadLogo(localPackageManager);
            }
            this.mIcon = paramAttributeSet.getDrawable(7);
            if (this.mIcon == null) {
                if (!(paramContext instanceof Activity)) {
                }
            }
        } catch (PackageManager.NameNotFoundException localNameNotFoundException1) {
            try {
                this.mIcon = localPackageManager.getActivityIcon(((Activity) paramContext).getComponentName());
                if (this.mIcon == null) {
                    this.mIcon = ((ApplicationInfo) localObject).loadIcon(localPackageManager);
                }
                localObject = LayoutInflater.from(paramContext);
                int i = paramAttributeSet.getResourceId(14, R.layout.abc_action_bar_home);
                this.mHomeLayout = ((HomeView) ((LayoutInflater) localObject).inflate(i, this, false));
                this.mExpandedHomeLayout = ((HomeView) ((LayoutInflater) localObject).inflate(i, this, false));
                this.mExpandedHomeLayout.setUp(true);
                this.mExpandedHomeLayout.setOnClickListener(this.mExpandedActionViewUpListener);
                this.mExpandedHomeLayout.setContentDescription(getResources().getText(R.string.abc_action_bar_up_description));
                this.mTitleStyleRes = paramAttributeSet.getResourceId(5, 0);
                this.mSubtitleStyleRes = paramAttributeSet.getResourceId(6, 0);
                this.mProgressStyle = paramAttributeSet.getResourceId(15, 0);
                this.mIndeterminateProgressStyle = paramAttributeSet.getResourceId(16, 0);
                this.mProgressBarPadding = paramAttributeSet.getDimensionPixelOffset(17, 0);
                this.mItemPadding = paramAttributeSet.getDimensionPixelOffset(18, 0);
                setDisplayOptions(paramAttributeSet.getInt(3, 0));
                i = paramAttributeSet.getResourceId(13, 0);
                if (i != 0) {
                    this.mCustomNavView = ((LayoutInflater) localObject).inflate(i, this, false);
                    this.mNavigationMode = 0;
                    setDisplayOptions(this.mDisplayOptions | 0x10);
                }
                this.mContentHeight = paramAttributeSet.getLayoutDimension(1, 0);
                paramAttributeSet.recycle();
                this.mLogoNavItem = new ActionMenuItem(paramContext, 0, 16908332, 0, 0, this.mTitle);
                this.mHomeLayout.setOnClickListener(this.mUpClickListener);
                this.mHomeLayout.setClickable(true);
                this.mHomeLayout.setFocusable(true);
                return;
                localNameNotFoundException1 = localNameNotFoundException1;
                Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException1);
            } catch (PackageManager.NameNotFoundException localNameNotFoundException2) {
                for (; ; ) {
                    Log.e("ActionBarView", "Activity component name not found!", localNameNotFoundException2);
                }
            }
        }
    }

    private void configPresenters(MenuBuilder paramMenuBuilder) {
        if (paramMenuBuilder != null) {
            paramMenuBuilder.addMenuPresenter(this.mActionMenuPresenter);
            paramMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter);
        }
        for (; ; ) {
            this.mActionMenuPresenter.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
            return;
            this.mActionMenuPresenter.initForMenu(this.mContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mContext, null);
        }
    }

    private void initTitle() {
        boolean bool = true;
        int j;
        int k;
        label201:
        Object localObject;
        int i;
        if (this.mTitleLayout == null) {
            this.mTitleLayout = ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this, false));
            this.mTitleView = ((TextView) this.mTitleLayout.findViewById(R.id.action_bar_title));
            this.mSubtitleView = ((TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle));
            this.mTitleUpView = this.mTitleLayout.findViewById(R.id.up);
            this.mTitleLayout.setOnClickListener(this.mUpClickListener);
            if (this.mTitleStyleRes != 0) {
                this.mTitleView.setTextAppearance(this.mContext, this.mTitleStyleRes);
            }
            if (this.mTitle != null) {
                this.mTitleView.setText(this.mTitle);
            }
            if (this.mSubtitleStyleRes != 0) {
                this.mSubtitleView.setTextAppearance(this.mContext, this.mSubtitleStyleRes);
            }
            if (this.mSubtitle != null) {
                this.mSubtitleView.setText(this.mSubtitle);
                this.mSubtitleView.setVisibility(0);
            }
            if ((this.mDisplayOptions & 0x4) == 0) {
                break label289;
            }
            j = 1;
            if ((this.mDisplayOptions & 0x2) == 0) {
                break label294;
            }
            k = 1;
            localObject = this.mTitleUpView;
            if (k != 0) {
                break label304;
            }
            if (j == 0) {
                break label299;
            }
            i = 0;
            label217:
            ((View) localObject).setVisibility(i);
            localObject = this.mTitleLayout;
            if ((j == 0) || (k != 0)) {
                break label310;
            }
        }
        for (; ; ) {
            ((LinearLayout) localObject).setEnabled(bool);
            addView(this.mTitleLayout);
            if ((this.mExpandedActionView != null) || ((TextUtils.isEmpty(this.mTitle)) && (TextUtils.isEmpty(this.mSubtitle)))) {
                this.mTitleLayout.setVisibility(8);
            }
            return;
            label289:
            j = 0;
            break;
            label294:
            k = 0;
            break label201;
            label299:
            i = 4;
            break label217;
            label304:
            i = 8;
            break label217;
            label310:
            bool = false;
        }
    }

    private void setTitleImpl(CharSequence paramCharSequence) {
        int j = 0;
        this.mTitle = paramCharSequence;
        LinearLayout localLinearLayout;
        if (this.mTitleView != null) {
            this.mTitleView.setText(paramCharSequence);
            if ((this.mExpandedActionView != null) || ((this.mDisplayOptions & 0x8) == 0) || ((TextUtils.isEmpty(this.mTitle)) && (TextUtils.isEmpty(this.mSubtitle)))) {
                break label96;
            }
            i = 1;
            localLinearLayout = this.mTitleLayout;
            if (i == 0) {
                break label101;
            }
        }
        label96:
        label101:
        for (int i = j; ; i = 8) {
            localLinearLayout.setVisibility(i);
            if (this.mLogoNavItem != null) {
                this.mLogoNavItem.setTitle(paramCharSequence);
            }
            return;
            i = 0;
            break;
        }
    }

    public void collapseActionView() {
        if (this.mExpandedMenuPresenter == null) {
        }
        for (MenuItemImpl localMenuItemImpl = null; ; localMenuItemImpl = this.mExpandedMenuPresenter.mCurrentExpandedItem) {
            if (localMenuItemImpl != null) {
                localMenuItemImpl.collapseActionView();
            }
            return;
        }
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ActionBar.LayoutParams(19);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
        return new ActionBar.LayoutParams(getContext(), paramAttributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
        ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
        if (paramLayoutParams == null) {
            localLayoutParams = generateDefaultLayoutParams();
        }
        return localLayoutParams;
    }

    public View getCustomNavigationView() {
        return this.mCustomNavView;
    }

    public int getDisplayOptions() {
        return this.mDisplayOptions;
    }

    public SpinnerAdapter getDropdownAdapter() {
        return this.mSpinnerAdapter;
    }

    public int getDropdownSelectedPosition() {
        return this.mSpinner.getSelectedItemPosition();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hasEmbeddedTabs() {
        return this.mIncludeTabs;
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null);
    }

    public void initIndeterminateProgress() {
        this.mIndeterminateProgressView = new ProgressBarICS(this.mContext, null, 0, this.mIndeterminateProgressStyle);
        this.mIndeterminateProgressView.setId(R.id.progress_circular);
        this.mIndeterminateProgressView.setVisibility(8);
        addView(this.mIndeterminateProgressView);
    }

    public void initProgress() {
        this.mProgressView = new ProgressBarICS(this.mContext, null, 0, this.mProgressStyle);
        this.mProgressView.setId(R.id.progress_horizontal);
        this.mProgressView.setMax(10000);
        this.mProgressView.setVisibility(8);
        addView(this.mProgressView);
    }

    public boolean isCollapsed() {
        return this.mIsCollapsed;
    }

    public boolean isSplitActionBar() {
        return this.mSplitActionBar;
    }

    protected void onConfigurationChanged(Configuration paramConfiguration) {
        super.onConfigurationChanged(paramConfiguration);
        this.mTitleView = null;
        this.mSubtitleView = null;
        this.mTitleUpView = null;
        if ((this.mTitleLayout != null) && (this.mTitleLayout.getParent() == this)) {
            removeView(this.mTitleLayout);
        }
        this.mTitleLayout = null;
        if ((this.mDisplayOptions & 0x8) != 0) {
            initTitle();
        }
        if ((this.mTabScrollView != null) && (this.mIncludeTabs)) {
            paramConfiguration = this.mTabScrollView.getLayoutParams();
            if (paramConfiguration != null) {
                paramConfiguration.width = -2;
                paramConfiguration.height = -1;
            }
            this.mTabScrollView.setAllowCollapse(true);
        }
        if (this.mProgressView != null) {
            removeView(this.mProgressView);
            initProgress();
        }
        if (this.mIndeterminateProgressView != null) {
            removeView(this.mIndeterminateProgressView);
            initIndeterminateProgress();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mTabSelector);
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.hideSubMenus();
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        addView(this.mHomeLayout);
        if ((this.mCustomNavView != null) && ((this.mDisplayOptions & 0x10) != 0)) {
            ViewParent localViewParent = this.mCustomNavView.getParent();
            if (localViewParent != this) {
                if ((localViewParent instanceof ViewGroup)) {
                    ((ViewGroup) localViewParent).removeView(this.mCustomNavView);
                }
                addView(this.mCustomNavView);
            }
        }
    }

    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = getPaddingLeft();
        int k = getPaddingTop();
        int m = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
        if (m <= 0) {
            return;
        }
        Object localObject1;
        if (this.mExpandedActionView != null) {
            localObject1 = this.mExpandedHomeLayout;
            label47:
            if (((HomeView) localObject1).getVisibility() == 8) {
                break label898;
            }
            paramInt2 = ((HomeView) localObject1).getLeftOffset();
        }
        label127:
        label187:
        label190:
        label307:
        label334:
        label346:
        label427:
        label466:
        label608:
        label747:
        label753:
        label874:
        label877:
        label889:
        label898:
        for (paramInt4 = positionChild((View) localObject1, i + paramInt2, k, m) + paramInt2 + i; ; paramInt4 = i) {
            i = paramInt4;
            int j;
            if (this.mExpandedActionView == null) {
                if ((this.mTitleLayout == null) || (this.mTitleLayout.getVisibility() == 8) || ((this.mDisplayOptions & 0x8) == 0)) {
                    break label608;
                }
                j = 1;
                paramInt2 = paramInt4;
                if (j != 0) {
                    paramInt2 = paramInt4 + positionChild(this.mTitleLayout, paramInt4, k, m);
                }
            }
            switch (this.mNavigationMode) {
                default:
                    i = paramInt2;
                    paramInt2 = i;
                    paramInt3 = paramInt3 - paramInt1 - getPaddingRight();
                    paramInt1 = paramInt3;
                    if (this.mMenuView != null) {
                        paramInt1 = paramInt3;
                        if (this.mMenuView.getParent() == this) {
                            positionChildInverse(this.mMenuView, paramInt3, k, m);
                            paramInt1 = paramInt3 - this.mMenuView.getMeasuredWidth();
                        }
                    }
                    if ((this.mIndeterminateProgressView != null) && (this.mIndeterminateProgressView.getVisibility() != 8)) {
                        positionChildInverse(this.mIndeterminateProgressView, paramInt1, k, m);
                        paramInt1 -= this.mIndeterminateProgressView.getMeasuredWidth();
                    }
                    break;
            }
            for (; ; ) {
                if (this.mExpandedActionView != null) {
                    localObject1 = this.mExpandedActionView;
                }
                for (; ; ) {
                    Object localObject2;
                    if (localObject1 != null) {
                        localObject2 = ((View) localObject1).getLayoutParams();
                        if (!(localObject2 instanceof ActionBar.LayoutParams)) {
                            break label747;
                        }
                        localObject2 = (ActionBar.LayoutParams) localObject2;
                        if (localObject2 == null) {
                            break label753;
                        }
                        paramInt3 = ((ActionBar.LayoutParams) localObject2).gravity;
                        k = ((View) localObject1).getMeasuredWidth();
                        if (localObject2 == null) {
                            break label877;
                        }
                        m = ((ActionBar.LayoutParams) localObject2).leftMargin;
                        j = ((ActionBar.LayoutParams) localObject2).rightMargin;
                        i = ((ActionBar.LayoutParams) localObject2).topMargin;
                        paramInt4 = ((ActionBar.LayoutParams) localObject2).bottomMargin;
                        j = paramInt1 - j;
                        paramInt2 += m;
                    }
                    for (; ; ) {
                        paramInt1 = paramInt3 & 0x7;
                        if (paramInt1 == 1) {
                            m = (getWidth() - k) / 2;
                            if (m < paramInt2) {
                                paramInt1 = 3;
                            }
                        }
                        for (; ; ) {
                            switch (paramInt1) {
                                case 2:
                                case 4:
                                default:
                                    paramInt1 = 0;
                                    paramInt2 = paramInt3 & 0x70;
                                    if (paramInt3 == -1) {
                                        paramInt2 = 16;
                                    }
                                    paramInt3 = 0;
                                    switch (paramInt2) {
                                        default:
                                            paramInt2 = paramInt3;
                                    }
                                    break;
                            }
                            for (; ; ) {
                                paramInt3 = ((View) localObject1).getMeasuredWidth();
                                ((View) localObject1).layout(paramInt1, paramInt2, paramInt1 + paramInt3, ((View) localObject1).getMeasuredHeight() + paramInt2);
                                if (this.mProgressView == null) {
                                    break;
                                }
                                this.mProgressView.bringToFront();
                                paramInt1 = this.mProgressView.getMeasuredHeight() / 2;
                                this.mProgressView.layout(this.mProgressBarPadding, -paramInt1, this.mProgressBarPadding + this.mProgressView.getMeasuredWidth(), paramInt1);
                                return;
                                localObject1 = this.mHomeLayout;
                                break label47;
                                j = 0;
                                break label127;
                                break label190;
                                i = paramInt2;
                                if (this.mListNavLayout == null) {
                                    break label187;
                                }
                                paramInt4 = paramInt2;
                                if (j != 0) {
                                    paramInt4 = paramInt2 + this.mItemPadding;
                                }
                                paramInt2 = paramInt4 + (positionChild(this.mListNavLayout, paramInt4, k, m) + this.mItemPadding);
                                break label190;
                                i = paramInt2;
                                if (this.mTabScrollView == null) {
                                    break label187;
                                }
                                paramInt4 = paramInt2;
                                if (j != 0) {
                                    paramInt4 = paramInt2 + this.mItemPadding;
                                }
                                paramInt2 = paramInt4 + (positionChild(this.mTabScrollView, paramInt4, k, m) + this.mItemPadding);
                                break label190;
                                if (((this.mDisplayOptions & 0x10) == 0) || (this.mCustomNavView == null)) {
                                    break label889;
                                }
                                localObject1 = this.mCustomNavView;
                                break label307;
                                localObject2 = null;
                                break label334;
                                paramInt3 = 19;
                                break label346;
                                if (m + k <= j) {
                                    break label427;
                                }
                                paramInt1 = 5;
                                break label427;
                                if (paramInt3 != -1) {
                                    break label874;
                                }
                                paramInt1 = 3;
                                break label427;
                                paramInt1 = (getWidth() - k) / 2;
                                break label466;
                                paramInt1 = paramInt2;
                                break label466;
                                paramInt1 = j - k;
                                break label466;
                                paramInt2 = getPaddingTop();
                                paramInt2 = (getHeight() - getPaddingBottom() - paramInt2 - ((View) localObject1).getMeasuredHeight()) / 2;
                                continue;
                                paramInt2 = getPaddingTop() + i;
                                continue;
                                paramInt2 = getHeight() - getPaddingBottom() - ((View) localObject1).getMeasuredHeight() - paramInt4;
                            }
                        }
                        i = 0;
                        paramInt4 = 0;
                        j = paramInt1;
                    }
                    localObject1 = null;
                }
            }
        }
    }

    protected void onMeasure(int paramInt1, int paramInt2) {
        int i4 = getChildCount();
        int j;
        int i;
        Object localObject1;
        int k;
        if (this.mIsCollapsable) {
            j = 0;
            i = 0;
            while (i < i4) {
                localObject1 = getChildAt(i);
                k = j;
                if (((View) localObject1).getVisibility() != 8) {
                    if (localObject1 == this.mMenuView) {
                        k = j;
                        if (this.mMenuView.getChildCount() == 0) {
                        }
                    } else {
                        k = j + 1;
                    }
                }
                i += 1;
                j = k;
            }
            if (j == 0) {
                setMeasuredDimension(0, 0);
                this.mIsCollapsed = true;
                return;
            }
        }
        this.mIsCollapsed = false;
        if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"MATCH_PARENT\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(paramInt2) != Integer.MIN_VALUE) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        }
        int i5 = View.MeasureSpec.getSize(paramInt1);
        label226:
        int i6;
        int i3;
        int n;
        int m;
        label289:
        Object localObject2;
        if (this.mContentHeight > 0) {
            k = this.mContentHeight;
            i6 = getPaddingTop() + getPaddingBottom();
            paramInt1 = getPaddingLeft();
            paramInt2 = getPaddingRight();
            i3 = k - i6;
            n = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            paramInt2 = i5 - paramInt1 - paramInt2;
            m = paramInt2 / 2;
            if (this.mExpandedActionView == null) {
                break label902;
            }
            localObject1 = this.mExpandedHomeLayout;
            if (((HomeView) localObject1).getVisibility() == 8) {
                break label1303;
            }
            localObject2 = ((HomeView) localObject1).getLayoutParams();
            if (((ViewGroup.LayoutParams) localObject2).width >= 0) {
                break label911;
            }
            paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE);
            label322:
            ((HomeView) localObject1).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            paramInt1 = ((HomeView) localObject1).getMeasuredWidth();
            paramInt1 = ((HomeView) localObject1).getLeftOffset() + paramInt1;
            paramInt2 = Math.max(0, paramInt2 - paramInt1);
        }
        label517:
        label552:
        label571:
        label604:
        label654:
        label704:
        label723:
        label746:
        label861:
        label902:
        label911:
        label1148:
        label1154:
        label1178:
        label1186:
        label1192:
        label1287:
        label1290:
        label1297:
        label1303:
        for (paramInt1 = Math.max(0, paramInt2 - paramInt1); ; paramInt1 = m) {
            j = paramInt2;
            i = m;
            if (this.mMenuView != null) {
                j = paramInt2;
                i = m;
                if (this.mMenuView.getParent() == this) {
                    j = measureChildView(this.mMenuView, paramInt2, n, 0);
                    i = Math.max(0, m - this.mMenuView.getMeasuredWidth());
                }
            }
            paramInt2 = j;
            m = i;
            if (this.mIndeterminateProgressView != null) {
                paramInt2 = j;
                m = i;
                if (this.mIndeterminateProgressView.getVisibility() != 8) {
                    paramInt2 = measureChildView(this.mIndeterminateProgressView, j, n, 0);
                    m = Math.max(0, i - this.mIndeterminateProgressView.getMeasuredWidth());
                }
            }
            if ((this.mTitleLayout != null) && (this.mTitleLayout.getVisibility() != 8) && ((this.mDisplayOptions & 0x8) != 0)) {
                j = 1;
                if (this.mExpandedActionView == null) {
                }
                switch (this.mNavigationMode) {
                    default:
                        i = paramInt1;
                        paramInt1 = paramInt2;
                        paramInt2 = i;
                        if (this.mExpandedActionView != null) {
                            localObject1 = this.mExpandedActionView;
                        }
                        break;
                }
            }
            for (; ; ) {
                i = paramInt1;
                ViewGroup.LayoutParams localLayoutParams;
                int i1;
                int i2;
                int i7;
                if (localObject1 != null) {
                    localLayoutParams = generateLayoutParams(((View) localObject1).getLayoutParams());
                    if (!(localLayoutParams instanceof ActionBar.LayoutParams)) {
                        break label1148;
                    }
                    localObject2 = (ActionBar.LayoutParams) localLayoutParams;
                    n = 0;
                    i1 = 0;
                    if (localObject2 != null) {
                        i = ((ActionBar.LayoutParams) localObject2).leftMargin;
                        n = ((ActionBar.LayoutParams) localObject2).rightMargin + i;
                        i1 = ((ActionBar.LayoutParams) localObject2).topMargin + ((ActionBar.LayoutParams) localObject2).bottomMargin;
                    }
                    if (this.mContentHeight > 0) {
                        break label1154;
                    }
                    i = Integer.MIN_VALUE;
                    i2 = i3;
                    if (localLayoutParams.height >= 0) {
                        i2 = Math.min(localLayoutParams.height, i3);
                    }
                    i7 = Math.max(0, i2 - i1);
                    if (localLayoutParams.width == -2) {
                        break label1178;
                    }
                    i1 = 1073741824;
                    if (localLayoutParams.width < 0) {
                        break label1186;
                    }
                    i2 = Math.min(localLayoutParams.width, paramInt1);
                    i3 = Math.max(0, i2 - n);
                    if (localObject2 == null) {
                        break label1192;
                    }
                    i2 = ((ActionBar.LayoutParams) localObject2).gravity;
                    if (((i2 & 0x7) != 1) || (localLayoutParams.width != -1)) {
                        break label1290;
                    }
                }
                for (m = Math.min(paramInt2, m) * 2; ; m = i3) {
                    ((View) localObject1).measure(View.MeasureSpec.makeMeasureSpec(m, i1), View.MeasureSpec.makeMeasureSpec(i7, i));
                    i = paramInt1 - (((View) localObject1).getMeasuredWidth() + n);
                    if ((this.mExpandedActionView == null) && (j != 0)) {
                        measureChildView(this.mTitleLayout, i, View.MeasureSpec.makeMeasureSpec(this.mContentHeight, 1073741824), 0);
                        Math.max(0, paramInt2 - this.mTitleLayout.getMeasuredWidth());
                    }
                    if (this.mContentHeight <= 0) {
                        paramInt1 = 0;
                        paramInt2 = 0;
                        if (paramInt2 < i4) {
                            i = getChildAt(paramInt2).getMeasuredHeight() + i6;
                            if (i <= paramInt1) {
                                break label1287;
                            }
                            paramInt1 = i;
                        }
                    }
                    for (; ; ) {
                        paramInt2 += 1;
                        break label861;
                        k = View.MeasureSpec.getSize(paramInt2);
                        break label226;
                        localObject1 = this.mHomeLayout;
                        break label289;
                        paramInt1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams) localObject2).width, 1073741824);
                        break label322;
                        j = 0;
                        break label517;
                        if (this.mListNavLayout == null) {
                            break label552;
                        }
                        if (j != 0) {
                        }
                        for (i = this.mItemPadding * 2; ; i = this.mItemPadding) {
                            paramInt2 = Math.max(0, paramInt2 - i);
                            i = Math.max(0, paramInt1 - i);
                            this.mListNavLayout.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
                            n = this.mListNavLayout.getMeasuredWidth();
                            paramInt1 = Math.max(0, paramInt2 - n);
                            paramInt2 = Math.max(0, i - n);
                            break;
                        }
                        if (this.mTabScrollView == null) {
                            break label552;
                        }
                        if (j != 0) {
                        }
                        for (i = this.mItemPadding * 2; ; i = this.mItemPadding) {
                            paramInt2 = Math.max(0, paramInt2 - i);
                            i = Math.max(0, paramInt1 - i);
                            this.mTabScrollView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
                            n = this.mTabScrollView.getMeasuredWidth();
                            paramInt1 = Math.max(0, paramInt2 - n);
                            paramInt2 = Math.max(0, i - n);
                            break;
                        }
                        if (((this.mDisplayOptions & 0x10) == 0) || (this.mCustomNavView == null)) {
                            break label1297;
                        }
                        localObject1 = this.mCustomNavView;
                        break label571;
                        localObject2 = null;
                        break label604;
                        if (localLayoutParams.height != -2) {
                            i = 1073741824;
                            break label654;
                        }
                        i = Integer.MIN_VALUE;
                        break label654;
                        i1 = Integer.MIN_VALUE;
                        break label704;
                        i2 = paramInt1;
                        break label723;
                        i2 = 19;
                        break label746;
                        setMeasuredDimension(i5, paramInt1);
                        for (; ; ) {
                            if (this.mContextView != null) {
                                this.mContextView.setContentHeight(getMeasuredHeight());
                            }
                            if ((this.mProgressView == null) || (this.mProgressView.getVisibility() == 8)) {
                                break;
                            }
                            this.mProgressView.measure(View.MeasureSpec.makeMeasureSpec(i5 - this.mProgressBarPadding * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Integer.MIN_VALUE));
                            return;
                            setMeasuredDimension(i5, k);
                        }
                    }
                }
                localObject1 = null;
            }
        }
    }

    public void onRestoreInstanceState(Parcelable paramParcelable) {
        paramParcelable = (SavedState) paramParcelable;
        super.onRestoreInstanceState(paramParcelable.getSuperState());
        if ((paramParcelable.expandedMenuItemId != 0) && (this.mExpandedMenuPresenter != null) && (this.mOptionsMenu != null)) {
            SupportMenuItem localSupportMenuItem = (SupportMenuItem) this.mOptionsMenu.findItem(paramParcelable.expandedMenuItemId);
            if (localSupportMenuItem != null) {
                localSupportMenuItem.expandActionView();
            }
        }
        if (paramParcelable.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState localSavedState = new SavedState(super.onSaveInstanceState());
        if ((this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null)) {
            localSavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        localSavedState.isOverflowOpen = isOverflowMenuShowing();
        return localSavedState;
    }

    public void setCallback(ActionBar.OnNavigationListener paramOnNavigationListener) {
        this.mCallback = paramOnNavigationListener;
    }

    public void setCollapsable(boolean paramBoolean) {
        this.mIsCollapsable = paramBoolean;
    }

    public void setContextView(ActionBarContextView paramActionBarContextView) {
        this.mContextView = paramActionBarContextView;
    }

    public void setCustomNavigationView(View paramView) {
        if ((this.mDisplayOptions & 0x10) != 0) {
        }
        for (int i = 1; ; i = 0) {
            if ((this.mCustomNavView != null) && (i != 0)) {
                removeView(this.mCustomNavView);
            }
            this.mCustomNavView = paramView;
            if ((this.mCustomNavView != null) && (i != 0)) {
                addView(this.mCustomNavView);
            }
            return;
        }
    }

    public void setDisplayOptions(int paramInt) {
        int n = 8;
        int j = -1;
        boolean bool2 = true;
        int k;
        label38:
        int i;
        label52:
        boolean bool1;
        label75:
        label115:
        Object localObject;
        label131:
        label156:
        int m;
        if (this.mDisplayOptions == -1) {
            this.mDisplayOptions = paramInt;
            if ((j & 0x1F) == 0) {
                break label369;
            }
            if ((paramInt & 0x2) == 0) {
                break label298;
            }
            k = 1;
            if ((k == 0) || (this.mExpandedActionView != null)) {
                break label304;
            }
            i = 0;
            this.mHomeLayout.setVisibility(i);
            if ((j & 0x4) != 0) {
                if ((paramInt & 0x4) == 0) {
                    break label310;
                }
                bool1 = true;
                this.mHomeLayout.setUp(bool1);
                if (bool1) {
                    setHomeButtonEnabled(true);
                }
            }
            if ((j & 0x1) != 0) {
                if ((this.mLogo == null) || ((paramInt & 0x1) == 0)) {
                    break label316;
                }
                i = 1;
                HomeView localHomeView = this.mHomeLayout;
                if (i == 0) {
                    break label321;
                }
                localObject = this.mLogo;
                localHomeView.setIcon((Drawable) localObject);
            }
            if ((j & 0x8) != 0) {
                if ((paramInt & 0x8) == 0) {
                    break label330;
                }
                initTitle();
            }
            if ((this.mTitleLayout != null) && ((j & 0x6) != 0)) {
                if ((this.mDisplayOptions & 0x4) == 0) {
                    break label341;
                }
                m = 1;
                label182:
                localObject = this.mTitleUpView;
                i = n;
                if (k == 0) {
                    if (m == 0) {
                        break label347;
                    }
                    i = 0;
                }
                label203:
                ((View) localObject).setVisibility(i);
                localObject = this.mTitleLayout;
                if ((k != 0) || (m == 0)) {
                    break label352;
                }
                bool1 = bool2;
                label229:
                ((LinearLayout) localObject).setEnabled(bool1);
            }
            if (((j & 0x10) != 0) && (this.mCustomNavView != null)) {
                if ((paramInt & 0x10) == 0) {
                    break label358;
                }
                addView(this.mCustomNavView);
            }
            label265:
            requestLayout();
        }
        for (; ; ) {
            if (this.mHomeLayout.isEnabled()) {
                break label376;
            }
            this.mHomeLayout.setContentDescription(null);
            return;
            j = this.mDisplayOptions ^ paramInt;
            break;
            label298:
            k = 0;
            break label38;
            label304:
            i = 8;
            break label52;
            label310:
            bool1 = false;
            break label75;
            label316:
            i = 0;
            break label115;
            label321:
            localObject = this.mIcon;
            break label131;
            label330:
            removeView(this.mTitleLayout);
            break label156;
            label341:
            m = 0;
            break label182;
            label347:
            i = 4;
            break label203;
            label352:
            bool1 = false;
            break label229;
            label358:
            removeView(this.mCustomNavView);
            break label265;
            label369:
            invalidate();
        }
        label376:
        if ((paramInt & 0x4) != 0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abc_action_bar_up_description));
            return;
        }
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abc_action_bar_home_description));
    }

    public void setDropdownAdapter(SpinnerAdapter paramSpinnerAdapter) {
        this.mSpinnerAdapter = paramSpinnerAdapter;
        if (this.mSpinner != null) {
            this.mSpinner.setAdapter(paramSpinnerAdapter);
        }
    }

    public void setDropdownSelectedPosition(int paramInt) {
        this.mSpinner.setSelection(paramInt);
    }

    public void setEmbeddedTabView(ScrollingTabContainerView paramScrollingTabContainerView) {
        if (this.mTabScrollView != null) {
            removeView(this.mTabScrollView);
        }
        this.mTabScrollView = paramScrollingTabContainerView;
        if (paramScrollingTabContainerView != null) {
        }
        for (boolean bool = true; ; bool = false) {
            this.mIncludeTabs = bool;
            if ((this.mIncludeTabs) && (this.mNavigationMode == 2)) {
                addView(this.mTabScrollView);
                ViewGroup.LayoutParams localLayoutParams = this.mTabScrollView.getLayoutParams();
                localLayoutParams.width = -2;
                localLayoutParams.height = -1;
                paramScrollingTabContainerView.setAllowCollapse(true);
            }
            return;
        }
    }

    public void setHomeAsUpIndicator(int paramInt) {
        this.mHomeLayout.setUpIndicator(paramInt);
    }

    public void setHomeAsUpIndicator(Drawable paramDrawable) {
        this.mHomeLayout.setUpIndicator(paramDrawable);
    }

    public void setHomeButtonEnabled(boolean paramBoolean) {
        this.mHomeLayout.setEnabled(paramBoolean);
        this.mHomeLayout.setFocusable(paramBoolean);
        if (!paramBoolean) {
            this.mHomeLayout.setContentDescription(null);
            return;
        }
        if ((this.mDisplayOptions & 0x4) != 0) {
            this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abc_action_bar_up_description));
            return;
        }
        this.mHomeLayout.setContentDescription(this.mContext.getResources().getText(R.string.abc_action_bar_home_description));
    }

    public void setIcon(int paramInt) {
        setIcon(this.mContext.getResources().getDrawable(paramInt));
    }

    public void setIcon(Drawable paramDrawable) {
        this.mIcon = paramDrawable;
        if ((paramDrawable != null) && (((this.mDisplayOptions & 0x1) == 0) || (this.mLogo == null))) {
            this.mHomeLayout.setIcon(paramDrawable);
        }
        if (this.mExpandedActionView != null) {
            this.mExpandedHomeLayout.setIcon(this.mIcon.getConstantState().newDrawable(getResources()));
        }
    }

    public void setLogo(int paramInt) {
        setLogo(this.mContext.getResources().getDrawable(paramInt));
    }

    public void setLogo(Drawable paramDrawable) {
        this.mLogo = paramDrawable;
        if ((paramDrawable != null) && ((this.mDisplayOptions & 0x1) != 0)) {
            this.mHomeLayout.setIcon(paramDrawable);
        }
    }

    public void setMenu(SupportMenu paramSupportMenu, MenuPresenter.Callback paramCallback) {
        if (paramSupportMenu == this.mOptionsMenu) {
            return;
        }
        if (this.mOptionsMenu != null) {
            this.mOptionsMenu.removeMenuPresenter(this.mActionMenuPresenter);
            this.mOptionsMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        Object localObject = (MenuBuilder) paramSupportMenu;
        this.mOptionsMenu = ((MenuBuilder) localObject);
        if (this.mMenuView != null) {
            paramSupportMenu = (ViewGroup) this.mMenuView.getParent();
            if (paramSupportMenu != null) {
                paramSupportMenu.removeView(this.mMenuView);
            }
        }
        if (this.mActionMenuPresenter == null) {
            this.mActionMenuPresenter = new ActionMenuPresenter(this.mContext);
            this.mActionMenuPresenter.setCallback(paramCallback);
            this.mActionMenuPresenter.setId(R.id.action_menu_presenter);
            this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
        }
        paramCallback = new ViewGroup.LayoutParams(-2, -1);
        if (!this.mSplitActionBar) {
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(getResources().getBoolean(R.bool.abc_action_bar_expanded_action_views_exclusive));
            configPresenters((MenuBuilder) localObject);
            paramSupportMenu = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            paramSupportMenu.initialize((MenuBuilder) localObject);
            localObject = (ViewGroup) paramSupportMenu.getParent();
            if ((localObject != null) && (localObject != this)) {
                ((ViewGroup) localObject).removeView(paramSupportMenu);
            }
            addView(paramSupportMenu, paramCallback);
        }
        for (; ; ) {
            this.mMenuView = paramSupportMenu;
            return;
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
            paramCallback.width = -1;
            configPresenters((MenuBuilder) localObject);
            paramSupportMenu = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            if (this.mSplitView != null) {
                localObject = (ViewGroup) paramSupportMenu.getParent();
                if ((localObject != null) && (localObject != this.mSplitView)) {
                    ((ViewGroup) localObject).removeView(paramSupportMenu);
                }
                paramSupportMenu.setVisibility(getAnimatedVisibility());
                this.mSplitView.addView(paramSupportMenu, paramCallback);
            } else {
                paramSupportMenu.setLayoutParams(paramCallback);
            }
        }
    }

    public void setNavigationMode(int paramInt) {
        int i = this.mNavigationMode;
        if (paramInt != i) {
            switch (i) {
                default:
                    switch (paramInt) {
                    }
                    break;
            }
        }
        for (; ; ) {
            this.mNavigationMode = paramInt;
            requestLayout();
            return;
            if (this.mListNavLayout == null) {
                break;
            }
            removeView(this.mListNavLayout);
            break;
            if ((this.mTabScrollView == null) || (!this.mIncludeTabs)) {
                break;
            }
            removeView(this.mTabScrollView);
            break;
            if (this.mSpinner == null) {
                this.mSpinner = new SpinnerICS(this.mContext, null, R.attr.actionDropDownStyle);
                this.mListNavLayout = ((LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_action_bar_view_list_nav_layout, null));
                LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
                localLayoutParams.gravity = 17;
                this.mListNavLayout.addView(this.mSpinner, localLayoutParams);
            }
            if (this.mSpinner.getAdapter() != this.mSpinnerAdapter) {
                this.mSpinner.setAdapter(this.mSpinnerAdapter);
            }
            this.mSpinner.setOnItemSelectedListener(this.mNavItemSelectedListener);
            addView(this.mListNavLayout);
            continue;
            if ((this.mTabScrollView != null) && (this.mIncludeTabs)) {
                addView(this.mTabScrollView);
            }
        }
    }

    public void setSplitActionBar(boolean paramBoolean) {
        int i;
        if (this.mSplitActionBar != paramBoolean) {
            Object localObject;
            if (this.mMenuView != null) {
                localObject = (ViewGroup) this.mMenuView.getParent();
                if (localObject != null) {
                    ((ViewGroup) localObject).removeView(this.mMenuView);
                }
                if (!paramBoolean) {
                    break label135;
                }
                if (this.mSplitView != null) {
                    this.mSplitView.addView(this.mMenuView);
                }
                this.mMenuView.getLayoutParams().width = -1;
                this.mMenuView.requestLayout();
            }
            if (this.mSplitView != null) {
                localObject = this.mSplitView;
                if (!paramBoolean) {
                    break label158;
                }
                i = 0;
                label96:
                ((ActionBarContainer) localObject).setVisibility(i);
            }
            if (this.mActionMenuPresenter != null) {
                if (paramBoolean) {
                    break label164;
                }
                this.mActionMenuPresenter.setExpandedActionViewsExclusive(getResources().getBoolean(R.bool.abc_action_bar_expanded_action_views_exclusive));
            }
        }
        for (; ; ) {
            super.setSplitActionBar(paramBoolean);
            return;
            label135:
            addView(this.mMenuView);
            this.mMenuView.getLayoutParams().width = -2;
            break;
            label158:
            i = 8;
            break label96;
            label164:
            this.mActionMenuPresenter.setExpandedActionViewsExclusive(false);
            this.mActionMenuPresenter.setWidthLimit(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.mActionMenuPresenter.setItemLimit(Integer.MAX_VALUE);
        }
    }

    public void setSubtitle(CharSequence paramCharSequence) {
        int j = 0;
        this.mSubtitle = paramCharSequence;
        if (this.mSubtitleView != null) {
            this.mSubtitleView.setText(paramCharSequence);
            TextView localTextView = this.mSubtitleView;
            if (paramCharSequence == null) {
                break label96;
            }
            i = 0;
            localTextView.setVisibility(i);
            if ((this.mExpandedActionView != null) || ((this.mDisplayOptions & 0x8) == 0) || ((TextUtils.isEmpty(this.mTitle)) && (TextUtils.isEmpty(this.mSubtitle)))) {
                break label102;
            }
            i = 1;
            label79:
            paramCharSequence = this.mTitleLayout;
            if (i == 0) {
                break label107;
            }
        }
        label96:
        label102:
        label107:
        for (int i = j; ; i = 8) {
            paramCharSequence.setVisibility(i);
            return;
            i = 8;
            break;
            i = 0;
            break label79;
        }
    }

    public void setTitle(CharSequence paramCharSequence) {
        this.mUserTitle = true;
        setTitleImpl(paramCharSequence);
    }

    public void setWindowCallback(Window.Callback paramCallback) {
        this.mWindowCallback = paramCallback;
    }

    public void setWindowTitle(CharSequence paramCharSequence) {
        if (!this.mUserTitle) {
            setTitleImpl(paramCharSequence);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    private class ExpandedActionViewMenuPresenter
            implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
            if ((ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView)) {
                ((CollapsibleActionView) ActionBarView.this.mExpandedActionView).onActionViewCollapsed();
            }
            ActionBarView.this.removeView(ActionBarView.this.mExpandedActionView);
            ActionBarView.this.removeView(ActionBarView.this.mExpandedHomeLayout);
            ActionBarView.this.mExpandedActionView = null;
            if ((ActionBarView.this.mDisplayOptions & 0x2) != 0) {
                ActionBarView.this.mHomeLayout.setVisibility(0);
            }
            if ((ActionBarView.this.mDisplayOptions & 0x8) != 0) {
                if (ActionBarView.this.mTitleLayout != null) {
                    break label245;
                }
                ActionBarView.this.initTitle();
            }
            for (; ; ) {
                if ((ActionBarView.this.mTabScrollView != null) && (ActionBarView.this.mNavigationMode == 2)) {
                    ActionBarView.this.mTabScrollView.setVisibility(0);
                }
                if ((ActionBarView.this.mSpinner != null) && (ActionBarView.this.mNavigationMode == 1)) {
                    ActionBarView.this.mSpinner.setVisibility(0);
                }
                if ((ActionBarView.this.mCustomNavView != null) && ((ActionBarView.this.mDisplayOptions & 0x10) != 0)) {
                    ActionBarView.this.mCustomNavView.setVisibility(0);
                }
                ActionBarView.this.mExpandedHomeLayout.setIcon(null);
                this.mCurrentExpandedItem = null;
                ActionBarView.this.requestLayout();
                paramMenuItemImpl.setActionViewExpanded(false);
                return true;
                label245:
                ActionBarView.this.mTitleLayout.setVisibility(0);
            }
        }

        public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl) {
            ActionBarView.this.mExpandedActionView = paramMenuItemImpl.getActionView();
            ActionBarView.this.mExpandedHomeLayout.setIcon(ActionBarView.this.mIcon.getConstantState().newDrawable(ActionBarView.this.getResources()));
            this.mCurrentExpandedItem = paramMenuItemImpl;
            if (ActionBarView.this.mExpandedActionView.getParent() != ActionBarView.this) {
                ActionBarView.this.addView(ActionBarView.this.mExpandedActionView);
            }
            if (ActionBarView.this.mExpandedHomeLayout.getParent() != ActionBarView.this) {
                ActionBarView.this.addView(ActionBarView.this.mExpandedHomeLayout);
            }
            ActionBarView.this.mHomeLayout.setVisibility(8);
            if (ActionBarView.this.mTitleLayout != null) {
                ActionBarView.this.mTitleLayout.setVisibility(8);
            }
            if (ActionBarView.this.mTabScrollView != null) {
                ActionBarView.this.mTabScrollView.setVisibility(8);
            }
            if (ActionBarView.this.mSpinner != null) {
                ActionBarView.this.mSpinner.setVisibility(8);
            }
            if (ActionBarView.this.mCustomNavView != null) {
                ActionBarView.this.mCustomNavView.setVisibility(8);
            }
            ActionBarView.this.requestLayout();
            paramMenuItemImpl.setActionViewExpanded(true);
            if ((ActionBarView.this.mExpandedActionView instanceof CollapsibleActionView)) {
                ((CollapsibleActionView) ActionBarView.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean flagActionItems() {
            return false;
        }

        public int getId() {
            return 0;
        }

        public MenuView getMenuView(ViewGroup paramViewGroup) {
            return null;
        }

        public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder) {
            if ((this.mMenu != null) && (this.mCurrentExpandedItem != null)) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = paramMenuBuilder;
        }

        public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
        }

        public void onRestoreInstanceState(Parcelable paramParcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
            return false;
        }

        public void setCallback(MenuPresenter.Callback paramCallback) {
        }

        public void updateMenuView(boolean paramBoolean) {
            if (this.mCurrentExpandedItem != null) {
                if (this.mMenu == null) {
                    break label74;
                }
                int j = this.mMenu.size();
                i = 0;
                if (i >= j) {
                    break label74;
                }
                if ((SupportMenuItem) this.mMenu.getItem(i) != this.mCurrentExpandedItem) {
                    break label67;
                }
            }
            label67:
            label74:
            for (int i = 1; ; i = 0) {
                if (i == 0) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
                return;
                i += 1;
                break;
            }
        }
    }

    private static class HomeView
            extends FrameLayout {
        private Drawable mDefaultUpIndicator;
        private ImageView mIconView;
        private int mUpIndicatorRes;
        private ImageView mUpView;
        private int mUpWidth;

        public HomeView(Context paramContext) {
            this(paramContext, null);
        }

        public HomeView(Context paramContext, AttributeSet paramAttributeSet) {
            super(paramAttributeSet);
        }

        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
            CharSequence localCharSequence = getContentDescription();
            if (!TextUtils.isEmpty(localCharSequence)) {
                paramAccessibilityEvent.getText().add(localCharSequence);
            }
            return true;
        }

        public int getLeftOffset() {
            if (this.mUpView.getVisibility() == 8) {
                return this.mUpWidth;
            }
            return 0;
        }

        protected void onConfigurationChanged(Configuration paramConfiguration) {
            super.onConfigurationChanged(paramConfiguration);
            if (this.mUpIndicatorRes != 0) {
                setUpIndicator(this.mUpIndicatorRes);
            }
        }

        protected void onFinishInflate() {
            this.mUpView = ((ImageView) findViewById(R.id.up));
            this.mIconView = ((ImageView) findViewById(R.id.home));
            this.mDefaultUpIndicator = this.mUpView.getDrawable();
        }

        protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
            int i = 0;
            int j = (paramInt4 - paramInt2) / 2;
            paramInt2 = i;
            paramInt4 = paramInt1;
            if (this.mUpView.getVisibility() != 8) {
                localLayoutParams = (FrameLayout.LayoutParams) this.mUpView.getLayoutParams();
                paramInt4 = this.mUpView.getMeasuredHeight();
                paramInt2 = this.mUpView.getMeasuredWidth();
                i = j - paramInt4 / 2;
                this.mUpView.layout(0, i, paramInt2, paramInt4 + i);
                paramInt4 = localLayoutParams.leftMargin;
                paramInt2 = localLayoutParams.rightMargin + (paramInt4 + paramInt2);
                paramInt4 = paramInt1 + paramInt2;
            }
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams) this.mIconView.getLayoutParams();
            paramInt1 = this.mIconView.getMeasuredHeight();
            i = this.mIconView.getMeasuredWidth();
            paramInt3 = (paramInt3 - paramInt4) / 2;
            paramInt2 += Math.max(localLayoutParams.leftMargin, paramInt3 - i / 2);
            paramInt3 = Math.max(localLayoutParams.topMargin, j - paramInt1 / 2);
            this.mIconView.layout(paramInt2, paramInt3, i + paramInt2, paramInt1 + paramInt3);
        }

        protected void onMeasure(int paramInt1, int paramInt2) {
            measureChildWithMargins(this.mUpView, paramInt1, 0, paramInt2, 0);
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams) this.mUpView.getLayoutParams();
            this.mUpWidth = (localLayoutParams.leftMargin + this.mUpView.getMeasuredWidth() + localLayoutParams.rightMargin);
            int i;
            int j;
            int k;
            int m;
            if (this.mUpView.getVisibility() == 8) {
                i = 0;
                j = localLayoutParams.topMargin;
                k = this.mUpView.getMeasuredHeight();
                m = localLayoutParams.bottomMargin;
                measureChildWithMargins(this.mIconView, paramInt1, i, paramInt2, 0);
                localLayoutParams = (FrameLayout.LayoutParams) this.mIconView.getLayoutParams();
                i += localLayoutParams.leftMargin + this.mIconView.getMeasuredWidth() + localLayoutParams.rightMargin;
                int n = localLayoutParams.topMargin;
                int i1 = this.mIconView.getMeasuredHeight();
                j = Math.max(j + k + m, localLayoutParams.bottomMargin + (n + i1));
                i1 = View.MeasureSpec.getMode(paramInt1);
                n = View.MeasureSpec.getMode(paramInt2);
                m = View.MeasureSpec.getSize(paramInt1);
                k = View.MeasureSpec.getSize(paramInt2);
                paramInt1 = m;
                switch (i1) {
                    default:
                        paramInt1 = i;
                    case 1073741824:
                        label226:
                        paramInt2 = k;
                        switch (n) {
                        }
                        break;
                }
            }
            for (paramInt2 = j; ; paramInt2 = Math.min(j, k)) {
                setMeasuredDimension(paramInt1, paramInt2);
                return;
                i = this.mUpWidth;
                break;
                paramInt1 = Math.min(i, m);
                break label226;
            }
        }

        public void setIcon(Drawable paramDrawable) {
            this.mIconView.setImageDrawable(paramDrawable);
        }

        public void setUp(boolean paramBoolean) {
            ImageView localImageView = this.mUpView;
            if (paramBoolean) {
            }
            for (int i = 0; ; i = 8) {
                localImageView.setVisibility(i);
                return;
            }
        }

        public void setUpIndicator(int paramInt) {
            this.mUpIndicatorRes = paramInt;
            ImageView localImageView = this.mUpView;
            if (paramInt != 0) {
            }
            for (Drawable localDrawable = getResources().getDrawable(paramInt); ; localDrawable = this.mDefaultUpIndicator) {
                localImageView.setImageDrawable(localDrawable);
                return;
            }
        }

        public void setUpIndicator(Drawable paramDrawable) {
            ImageView localImageView = this.mUpView;
            if (paramDrawable != null) {
            }
            for (; ; ) {
                localImageView.setImageDrawable(paramDrawable);
                this.mUpIndicatorRes = 0;
                return;
                paramDrawable = this.mDefaultUpIndicator;
            }
        }
    }

    static class SavedState
            extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {
            public ActionBarView.SavedState createFromParcel(Parcel paramAnonymousParcel) {
                return new ActionBarView.SavedState(paramAnonymousParcel, null);
            }

            public ActionBarView.SavedState[] newArray(int paramAnonymousInt) {
                return new ActionBarView.SavedState[paramAnonymousInt];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        private SavedState(Parcel paramParcel) {
            super();
            this.expandedMenuItemId = paramParcel.readInt();
            if (paramParcel.readInt() != 0) {
            }
            for (boolean bool = true; ; bool = false) {
                this.isOverflowOpen = bool;
                return;
            }
        }

        SavedState(Parcelable paramParcelable) {
            super();
        }

        public void writeToParcel(Parcel paramParcel, int paramInt) {
            super.writeToParcel(paramParcel, paramInt);
            paramParcel.writeInt(this.expandedMenuItemId);
            if (this.isOverflowOpen) {
            }
            for (paramInt = 1; ; paramInt = 0) {
                paramParcel.writeInt(paramInt);
                return;
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/internal/widget/ActionBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */