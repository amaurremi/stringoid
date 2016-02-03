package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.appcompat.R.anim;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.internal.view.ActionBarPolicy;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarOverlayLayout;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SpinnerAdapter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplBase
        extends ActionBar {
    private static final int CONTEXT_DISPLAY_NORMAL = 0;
    private static final int CONTEXT_DISPLAY_SPLIT = 1;
    private static final int INVALID_POSITION = -1;
    ActionModeImpl mActionMode;
    private ActionBarView mActionView;
    private ActionBarActivity mActivity;
    private ActionBar.Callback mCallback;
    private ActionBarContainer mContainerView;
    private View mContentView;
    private Context mContext;
    private int mContextDisplayMode;
    private ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    ActionMode mDeferredDestroyActionMode;
    ActionMode.Callback mDeferredModeDestroyCallback;
    private Dialog mDialog;
    private boolean mDisplayHomeAsUpSet;
    final Handler mHandler = new Handler();
    private boolean mHasEmbeddedTabs;
    private boolean mHiddenByApp;
    private boolean mHiddenBySystem;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.OnMenuVisibilityListener> mMenuVisibilityListeners = new ArrayList();
    private boolean mNowShowing = true;
    private ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition = -1;
    private TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    private boolean mShowingForMode;
    private ActionBarContainer mSplitView;
    private ScrollingTabContainerView mTabScrollView;
    Runnable mTabSelector;
    private ArrayList<TabImpl> mTabs = new ArrayList();
    private Context mThemedContext;
    private ViewGroup mTopVisibilityView;

    public ActionBarImplBase(ActionBarActivity paramActionBarActivity, ActionBar.Callback paramCallback) {
        this.mActivity = paramActionBarActivity;
        this.mContext = paramActionBarActivity;
        this.mCallback = paramCallback;
        init(this.mActivity);
    }

    private static boolean checkShowingFlags(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
        if (paramBoolean3) {
        }
        while ((!paramBoolean1) && (!paramBoolean2)) {
            return true;
        }
        return false;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab(null);
        }
        this.mTabs.clear();
        if (this.mTabScrollView != null) {
            this.mTabScrollView.removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab paramTab, int paramInt) {
        paramTab = (TabImpl) paramTab;
        if (paramTab.getCallback() == null) {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
        paramTab.setPosition(paramInt);
        this.mTabs.add(paramInt, paramTab);
        int i = this.mTabs.size();
        paramInt += 1;
        while (paramInt < i) {
            ((TabImpl) this.mTabs.get(paramInt)).setPosition(paramInt);
            paramInt += 1;
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView != null) {
            return;
        }
        ScrollingTabContainerView localScrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
        if (this.mHasEmbeddedTabs) {
            localScrollingTabContainerView.setVisibility(0);
            this.mActionView.setEmbeddedTabView(localScrollingTabContainerView);
            this.mTabScrollView = localScrollingTabContainerView;
            return;
        }
        if (getNavigationMode() == 2) {
            localScrollingTabContainerView.setVisibility(0);
        }
        for (; ; ) {
            this.mContainerView.setTabContainer(localScrollingTabContainerView);
            break;
            localScrollingTabContainerView.setVisibility(8);
        }
    }

    private void init(ActionBarActivity paramActionBarActivity) {
        boolean bool = false;
        this.mOverlayLayout = ((ActionBarOverlayLayout) paramActionBarActivity.findViewById(R.id.action_bar_overlay_layout));
        if (this.mOverlayLayout != null) {
            this.mOverlayLayout.setActionBar(this);
        }
        this.mActionView = ((ActionBarView) paramActionBarActivity.findViewById(R.id.action_bar));
        this.mContextView = ((ActionBarContextView) paramActionBarActivity.findViewById(R.id.action_context_bar));
        this.mContainerView = ((ActionBarContainer) paramActionBarActivity.findViewById(R.id.action_bar_container));
        this.mTopVisibilityView = ((ViewGroup) paramActionBarActivity.findViewById(R.id.top_action_bar));
        if (this.mTopVisibilityView == null) {
            this.mTopVisibilityView = this.mContainerView;
        }
        this.mSplitView = ((ActionBarContainer) paramActionBarActivity.findViewById(R.id.split_action_bar));
        if ((this.mActionView == null) || (this.mContextView == null) || (this.mContainerView == null)) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.mActionView.setContextView(this.mContextView);
        if (this.mActionView.isSplitActionBar()) {
            i = 1;
            this.mContextDisplayMode = i;
            if ((this.mActionView.getDisplayOptions() & 0x4) == 0) {
                break label279;
            }
        }
        label279:
        for (int i = 1; ; i = 0) {
            if (i != 0) {
                this.mDisplayHomeAsUpSet = true;
            }
            paramActionBarActivity = ActionBarPolicy.get(this.mContext);
            if ((paramActionBarActivity.enableHomeButtonByDefault()) || (i != 0)) {
                bool = true;
            }
            setHomeButtonEnabled(bool);
            setHasEmbeddedTabs(paramActionBarActivity.hasEmbeddedTabs());
            setTitle(this.mActivity.getTitle());
            return;
            i = 0;
            break;
        }
    }

    private void setHasEmbeddedTabs(boolean paramBoolean) {
        boolean bool = true;
        this.mHasEmbeddedTabs = paramBoolean;
        int i;
        label43:
        label62:
        ActionBarView localActionBarView;
        if (!this.mHasEmbeddedTabs) {
            this.mActionView.setEmbeddedTabView(null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
            if (getNavigationMode() != 2) {
                break label110;
            }
            i = 1;
            if (this.mTabScrollView != null) {
                if (i == 0) {
                    break label115;
                }
                this.mTabScrollView.setVisibility(0);
            }
            localActionBarView = this.mActionView;
            if ((this.mHasEmbeddedTabs) || (i == 0)) {
                break label127;
            }
        }
        label110:
        label115:
        label127:
        for (paramBoolean = bool; ; paramBoolean = false) {
            localActionBarView.setCollapsable(paramBoolean);
            return;
            this.mContainerView.setTabContainer(null);
            this.mActionView.setEmbeddedTabView(this.mTabScrollView);
            break;
            i = 0;
            break label43;
            this.mTabScrollView.setVisibility(8);
            break label62;
        }
    }

    private void updateVisibility(boolean paramBoolean) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(paramBoolean);
            }
        }
        while (!this.mNowShowing) {
            return;
        }
        this.mNowShowing = false;
        doHide(paramBoolean);
    }

    public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(paramOnMenuVisibilityListener);
    }

    public void addTab(ActionBar.Tab paramTab) {
        addTab(paramTab, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab paramTab, int paramInt) {
        addTab(paramTab, paramInt, this.mTabs.isEmpty());
    }

    public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean) {
        ensureTabsExist();
        this.mTabScrollView.addTab(paramTab, paramInt, paramBoolean);
        configureTab(paramTab, paramInt);
        if (paramBoolean) {
            selectTab(paramTab);
        }
    }

    public void addTab(ActionBar.Tab paramTab, boolean paramBoolean) {
        ensureTabsExist();
        this.mTabScrollView.addTab(paramTab, paramBoolean);
        configureTab(paramTab, this.mTabs.size());
        if (paramBoolean) {
            selectTab(paramTab);
        }
    }

    void animateToMode(boolean paramBoolean) {
        int j = 8;
        Object localObject;
        if (paramBoolean) {
            showForActionMode();
            localObject = this.mActionView;
            if (!paramBoolean) {
                break label100;
            }
            i = 4;
            label23:
            ((ActionBarView) localObject).animateToVisibility(i);
            localObject = this.mContextView;
            if (!paramBoolean) {
                break label105;
            }
            i = 0;
            label41:
            ((ActionBarContextView) localObject).animateToVisibility(i);
            if ((this.mTabScrollView != null) && (!this.mActionView.hasEmbeddedTabs()) && (this.mActionView.isCollapsed())) {
                localObject = this.mTabScrollView;
                if (!paramBoolean) {
                    break label111;
                }
            }
        }
        label100:
        label105:
        label111:
        for (int i = j; ; i = 0) {
            ((ScrollingTabContainerView) localObject).setVisibility(i);
            return;
            hideForActionMode();
            break;
            i = 0;
            break label23;
            i = 8;
            break label41;
        }
    }

    public void doHide(boolean paramBoolean) {
        this.mTopVisibilityView.clearAnimation();
        if (this.mTopVisibilityView.getVisibility() == 8) {
            return;
        }
        if ((isShowHideAnimationEnabled()) || (paramBoolean)) {
        }
        for (int i = 1; ; i = 0) {
            Animation localAnimation;
            if (i != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.abc_slide_out_top);
                this.mTopVisibilityView.startAnimation(localAnimation);
            }
            this.mTopVisibilityView.setVisibility(8);
            if ((this.mSplitView == null) || (this.mSplitView.getVisibility() == 8)) {
                break;
            }
            if (i != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.abc_slide_out_bottom);
                this.mSplitView.startAnimation(localAnimation);
            }
            this.mSplitView.setVisibility(8);
            return;
        }
    }

    public void doShow(boolean paramBoolean) {
        this.mTopVisibilityView.clearAnimation();
        if (this.mTopVisibilityView.getVisibility() == 0) {
            return;
        }
        if ((isShowHideAnimationEnabled()) || (paramBoolean)) {
        }
        for (int i = 1; ; i = 0) {
            Animation localAnimation;
            if (i != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.abc_slide_in_top);
                this.mTopVisibilityView.startAnimation(localAnimation);
            }
            this.mTopVisibilityView.setVisibility(0);
            if ((this.mSplitView == null) || (this.mSplitView.getVisibility() == 0)) {
                break;
            }
            if (i != 0) {
                localAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.abc_slide_in_bottom);
                this.mSplitView.startAnimation(localAnimation);
            }
            this.mSplitView.setVisibility(0);
            return;
        }
    }

    public View getCustomView() {
        return this.mActionView.getCustomNavigationView();
    }

    public int getDisplayOptions() {
        return this.mActionView.getDisplayOptions();
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getNavigationItemCount() {
        switch (this.mActionView.getNavigationMode()) {
        }
        SpinnerAdapter localSpinnerAdapter;
        do {
            return 0;
            return this.mTabs.size();
            localSpinnerAdapter = this.mActionView.getDropdownAdapter();
        } while (localSpinnerAdapter == null);
        return localSpinnerAdapter.getCount();
    }

    public int getNavigationMode() {
        return this.mActionView.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        switch (this.mActionView.getNavigationMode()) {
            default:
            case 2:
                do {
                    return -1;
                } while (this.mSelectedTab == null);
                return this.mSelectedTab.getPosition();
        }
        return this.mActionView.getDropdownSelectedPosition();
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mActionView.getSubtitle();
    }

    public ActionBar.Tab getTabAt(int paramInt) {
        return (ActionBar.Tab) this.mTabs.get(paramInt);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        int i;
        if (this.mThemedContext == null) {
            TypedValue localTypedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, localTypedValue, true);
            i = localTypedValue.resourceId;
            if (i == 0) {
                break label61;
            }
        }
        label61:
        for (this.mThemedContext = new ContextThemeWrapper(this.mContext, i); ; this.mThemedContext = this.mContext) {
            return this.mThemedContext;
        }
    }

    public CharSequence getTitle() {
        return this.mActionView.getTitle();
    }

    public boolean hasNonEmbeddedTabs() {
        return (!this.mHasEmbeddedTabs) && (getNavigationMode() == 2);
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            updateVisibility(false);
        }
    }

    boolean isShowHideAnimationEnabled() {
        return this.mShowHideAnimationEnabled;
    }

    public boolean isShowing() {
        return this.mNowShowing;
    }

    public ActionBar.Tab newTab() {
        return new TabImpl();
    }

    public void onConfigurationChanged(Configuration paramConfiguration) {
        setHasEmbeddedTabs(ActionBarPolicy.get(this.mContext).hasEmbeddedTabs());
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(paramOnMenuVisibilityListener);
    }

    public void removeTab(ActionBar.Tab paramTab) {
        removeTabAt(paramTab.getPosition());
    }

    public void removeTabAt(int paramInt) {
        if (this.mTabScrollView == null) {
        }
        int i;
        do {
            return;
            if (this.mSelectedTab != null) {
            }
            for (i = this.mSelectedTab.getPosition(); ; i = this.mSavedTabPosition) {
                this.mTabScrollView.removeTabAt(paramInt);
                localTabImpl = (TabImpl) this.mTabs.remove(paramInt);
                if (localTabImpl != null) {
                    localTabImpl.setPosition(-1);
                }
                int k = this.mTabs.size();
                int j = paramInt;
                while (j < k) {
                    ((TabImpl) this.mTabs.get(j)).setPosition(j);
                    j += 1;
                }
            }
        } while (i != paramInt);
        if (this.mTabs.isEmpty()) {
        }
        for (TabImpl localTabImpl = null; ; localTabImpl = (TabImpl) this.mTabs.get(Math.max(0, paramInt - 1))) {
            selectTab(localTabImpl);
            return;
        }
    }

    public void selectTab(ActionBar.Tab paramTab) {
        int i = -1;
        if (getNavigationMode() != 2) {
            if (paramTab != null) {
                i = paramTab.getPosition();
            }
            this.mSavedTabPosition = i;
        }
        for (; ; ) {
            return;
            FragmentTransaction localFragmentTransaction = this.mActivity.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
            if (this.mSelectedTab == paramTab) {
                if (this.mSelectedTab != null) {
                    this.mSelectedTab.getCallback().onTabReselected(this.mSelectedTab, localFragmentTransaction);
                    this.mTabScrollView.animateToTab(paramTab.getPosition());
                }
            }
            while (!localFragmentTransaction.isEmpty()) {
                localFragmentTransaction.commit();
                return;
                ScrollingTabContainerView localScrollingTabContainerView = this.mTabScrollView;
                if (paramTab != null) {
                    i = paramTab.getPosition();
                }
                localScrollingTabContainerView.setTabSelected(i);
                if (this.mSelectedTab != null) {
                    this.mSelectedTab.getCallback().onTabUnselected(this.mSelectedTab, localFragmentTransaction);
                }
                this.mSelectedTab = ((TabImpl) paramTab);
                if (this.mSelectedTab != null) {
                    this.mSelectedTab.getCallback().onTabSelected(this.mSelectedTab, localFragmentTransaction);
                }
            }
        }
    }

    public void setBackgroundDrawable(Drawable paramDrawable) {
        this.mContainerView.setPrimaryBackground(paramDrawable);
    }

    public void setCustomView(int paramInt) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.mActionView, false));
    }

    public void setCustomView(View paramView) {
        this.mActionView.setCustomNavigationView(paramView);
    }

    public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams) {
        paramView.setLayoutParams(paramLayoutParams);
        this.mActionView.setCustomNavigationView(paramView);
    }

    public void setDisplayHomeAsUpEnabled(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 4; ; i = 0) {
            setDisplayOptions(i, 4);
            return;
        }
    }

    public void setDisplayOptions(int paramInt) {
        if ((paramInt & 0x4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mActionView.setDisplayOptions(paramInt);
    }

    public void setDisplayOptions(int paramInt1, int paramInt2) {
        int i = this.mActionView.getDisplayOptions();
        if ((paramInt2 & 0x4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mActionView.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }

    public void setDisplayShowCustomEnabled(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 16; ; i = 0) {
            setDisplayOptions(i, 16);
            return;
        }
    }

    public void setDisplayShowHomeEnabled(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 2; ; i = 0) {
            setDisplayOptions(i, 2);
            return;
        }
    }

    public void setDisplayShowTitleEnabled(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 8; ; i = 0) {
            setDisplayOptions(i, 8);
            return;
        }
    }

    public void setDisplayUseLogoEnabled(boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            setDisplayOptions(i, 1);
            return;
        }
    }

    public void setHomeAsUpIndicator(int paramInt) {
        this.mActionView.setHomeAsUpIndicator(paramInt);
    }

    public void setHomeAsUpIndicator(Drawable paramDrawable) {
        this.mActionView.setHomeAsUpIndicator(paramDrawable);
    }

    public void setHomeButtonEnabled(boolean paramBoolean) {
        this.mActionView.setHomeButtonEnabled(paramBoolean);
    }

    public void setIcon(int paramInt) {
        this.mActionView.setIcon(paramInt);
    }

    public void setIcon(Drawable paramDrawable) {
        this.mActionView.setIcon(paramDrawable);
    }

    public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener) {
        this.mActionView.setDropdownAdapter(paramSpinnerAdapter);
        this.mActionView.setCallback(paramOnNavigationListener);
    }

    public void setLogo(int paramInt) {
        this.mActionView.setLogo(paramInt);
    }

    public void setLogo(Drawable paramDrawable) {
        this.mActionView.setLogo(paramDrawable);
    }

    public void setNavigationMode(int paramInt) {
        boolean bool2 = false;
        switch (this.mActionView.getNavigationMode()) {
            default:
                this.mActionView.setNavigationMode(paramInt);
                switch (paramInt) {
                }
                break;
        }
        for (; ; ) {
            ActionBarView localActionBarView = this.mActionView;
            boolean bool1 = bool2;
            if (paramInt == 2) {
                bool1 = bool2;
                if (!this.mHasEmbeddedTabs) {
                    bool1 = true;
                }
            }
            localActionBarView.setCollapsable(bool1);
            return;
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab(null);
            this.mTabScrollView.setVisibility(8);
            break;
            ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            if (this.mSavedTabPosition != -1) {
                setSelectedNavigationItem(this.mSavedTabPosition);
                this.mSavedTabPosition = -1;
            }
        }
    }

    public void setSelectedNavigationItem(int paramInt) {
        switch (this.mActionView.getNavigationMode()) {
            default:
                throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
            case 2:
                selectTab((ActionBar.Tab) this.mTabs.get(paramInt));
                return;
        }
        this.mActionView.setDropdownSelectedPosition(paramInt);
    }

    public void setShowHideAnimationEnabled(boolean paramBoolean) {
        this.mShowHideAnimationEnabled = paramBoolean;
        if (!paramBoolean) {
            this.mTopVisibilityView.clearAnimation();
            if (this.mSplitView != null) {
                this.mSplitView.clearAnimation();
            }
        }
    }

    public void setSplitBackgroundDrawable(Drawable paramDrawable) {
        this.mContainerView.setSplitBackground(paramDrawable);
    }

    public void setStackedBackgroundDrawable(Drawable paramDrawable) {
        this.mContainerView.setStackedBackground(paramDrawable);
    }

    public void setSubtitle(int paramInt) {
        setSubtitle(this.mContext.getString(paramInt));
    }

    public void setSubtitle(CharSequence paramCharSequence) {
        this.mActionView.setSubtitle(paramCharSequence);
    }

    public void setTitle(int paramInt) {
        setTitle(this.mContext.getString(paramInt));
    }

    public void setTitle(CharSequence paramCharSequence) {
        this.mActionView.setTitle(paramCharSequence);
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            updateVisibility(false);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback paramCallback) {
        if (this.mActionMode != null) {
            this.mActionMode.finish();
        }
        this.mContextView.killMode();
        paramCallback = new ActionModeImpl(paramCallback);
        if (paramCallback.dispatchOnCreate()) {
            paramCallback.invalidate();
            this.mContextView.initForMode(paramCallback);
            animateToMode(true);
            if ((this.mSplitView != null) && (this.mContextDisplayMode == 1) && (this.mSplitView.getVisibility() != 0)) {
                this.mSplitView.setVisibility(0);
            }
            this.mContextView.sendAccessibilityEvent(32);
            this.mActionMode = paramCallback;
            return paramCallback;
        }
        return null;
    }

    class ActionModeImpl
            extends ActionMode
            implements MenuBuilder.Callback {
        private ActionMode.Callback mCallback;
        private WeakReference<View> mCustomView;
        private MenuBuilder mMenu;

        public ActionModeImpl(ActionMode.Callback paramCallback) {
            this.mCallback = paramCallback;
            this.mMenu = new MenuBuilder(ActionBarImplBase.this.getThemedContext()).setDefaultShowAsAction(1);
            this.mMenu.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                boolean bool = this.mCallback.onCreateActionMode(this, this.mMenu);
                return bool;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public void finish() {
            if (ActionBarImplBase.this.mActionMode != this) {
                return;
            }
            if (!ActionBarImplBase.checkShowingFlags(ActionBarImplBase.this.mHiddenByApp, ActionBarImplBase.this.mHiddenBySystem, false)) {
                ActionBarImplBase.this.mDeferredDestroyActionMode = this;
                ActionBarImplBase.this.mDeferredModeDestroyCallback = this.mCallback;
            }
            for (; ; ) {
                this.mCallback = null;
                ActionBarImplBase.this.animateToMode(false);
                ActionBarImplBase.this.mContextView.closeMode();
                ActionBarImplBase.this.mActionView.sendAccessibilityEvent(32);
                ActionBarImplBase.this.mActionMode = null;
                return;
                this.mCallback.onDestroyActionMode(this);
            }
        }

        public View getCustomView() {
            if (this.mCustomView != null) {
                return (View) this.mCustomView.get();
            }
            return null;
        }

        public Menu getMenu() {
            return this.mMenu;
        }

        public MenuInflater getMenuInflater() {
            return new SupportMenuInflater(ActionBarImplBase.this.getThemedContext());
        }

        public CharSequence getSubtitle() {
            return ActionBarImplBase.this.mContextView.getSubtitle();
        }

        public CharSequence getTitle() {
            return ActionBarImplBase.this.mContextView.getTitle();
        }

        public void invalidate() {
            this.mMenu.stopDispatchingItemsChanged();
            try {
                this.mCallback.onPrepareActionMode(this, this.mMenu);
                return;
            } finally {
                this.mMenu.startDispatchingItemsChanged();
            }
        }

        public boolean isTitleOptional() {
            return ActionBarImplBase.this.mContextView.isTitleOptional();
        }

        public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {
        }

        public void onCloseSubMenu(SubMenuBuilder paramSubMenuBuilder) {
        }

        public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem) {
            if (this.mCallback != null) {
                return this.mCallback.onActionItemClicked(this, paramMenuItem);
            }
            return false;
        }

        public void onMenuModeChange(MenuBuilder paramMenuBuilder) {
            if (this.mCallback == null) {
                return;
            }
            invalidate();
            ActionBarImplBase.this.mContextView.showOverflowMenu();
        }

        public void onMenuModeChange(Menu paramMenu) {
            if (this.mCallback == null) {
                return;
            }
            invalidate();
            ActionBarImplBase.this.mContextView.showOverflowMenu();
        }

        public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder) {
            boolean bool = true;
            if (this.mCallback == null) {
                bool = false;
            }
            while (paramSubMenuBuilder.hasVisibleItems()) {
                return bool;
            }
            return true;
        }

        public void setCustomView(View paramView) {
            ActionBarImplBase.this.mContextView.setCustomView(paramView);
            this.mCustomView = new WeakReference(paramView);
        }

        public void setSubtitle(int paramInt) {
            setSubtitle(ActionBarImplBase.this.mContext.getResources().getString(paramInt));
        }

        public void setSubtitle(CharSequence paramCharSequence) {
            ActionBarImplBase.this.mContextView.setSubtitle(paramCharSequence);
        }

        public void setTitle(int paramInt) {
            setTitle(ActionBarImplBase.this.mContext.getResources().getString(paramInt));
        }

        public void setTitle(CharSequence paramCharSequence) {
            ActionBarImplBase.this.mContextView.setTitle(paramCharSequence);
        }

        public void setTitleOptionalHint(boolean paramBoolean) {
            super.setTitleOptionalHint(paramBoolean);
            ActionBarImplBase.this.mContextView.setTitleOptional(paramBoolean);
        }
    }

    public class TabImpl
            extends ActionBar.Tab {
        private ActionBar.TabListener mCallback;
        private CharSequence mContentDesc;
        private View mCustomView;
        private Drawable mIcon;
        private int mPosition = -1;
        private Object mTag;
        private CharSequence mText;

        public TabImpl() {
        }

        public ActionBar.TabListener getCallback() {
            return this.mCallback;
        }

        public CharSequence getContentDescription() {
            return this.mContentDesc;
        }

        public View getCustomView() {
            return this.mCustomView;
        }

        public Drawable getIcon() {
            return this.mIcon;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public Object getTag() {
            return this.mTag;
        }

        public CharSequence getText() {
            return this.mText;
        }

        public void select() {
            ActionBarImplBase.this.selectTab(this);
        }

        public ActionBar.Tab setContentDescription(int paramInt) {
            return setContentDescription(ActionBarImplBase.this.mContext.getResources().getText(paramInt));
        }

        public ActionBar.Tab setContentDescription(CharSequence paramCharSequence) {
            this.mContentDesc = paramCharSequence;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setCustomView(int paramInt) {
            return setCustomView(LayoutInflater.from(ActionBarImplBase.this.getThemedContext()).inflate(paramInt, null));
        }

        public ActionBar.Tab setCustomView(View paramView) {
            this.mCustomView = paramView;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public ActionBar.Tab setIcon(int paramInt) {
            return setIcon(ActionBarImplBase.this.mContext.getResources().getDrawable(paramInt));
        }

        public ActionBar.Tab setIcon(Drawable paramDrawable) {
            this.mIcon = paramDrawable;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }

        public void setPosition(int paramInt) {
            this.mPosition = paramInt;
        }

        public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener) {
            this.mCallback = paramTabListener;
            return this;
        }

        public ActionBar.Tab setTag(Object paramObject) {
            this.mTag = paramObject;
            return this;
        }

        public ActionBar.Tab setText(int paramInt) {
            return setText(ActionBarImplBase.this.mContext.getResources().getText(paramInt));
        }

        public ActionBar.Tab setText(CharSequence paramCharSequence) {
            this.mText = paramCharSequence;
            if (this.mPosition >= 0) {
                ActionBarImplBase.this.mTabScrollView.updateTab(this.mPosition);
            }
            return this;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/android/support/v7/app/ActionBarImplBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */