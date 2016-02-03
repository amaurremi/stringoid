package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActionBarDrawerToggle.Delegate;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.bool;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.style;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.menu.ListMenuPresenter;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.support.v7.internal.widget.ActionBarContainer;
import android.support.v7.internal.widget.ActionBarContextView;
import android.support.v7.internal.widget.ActionBarView;
import android.support.v7.internal.widget.ProgressBarICS;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;

class ActionBarActivityDelegateBase
  extends ActionBarActivityDelegate
  implements MenuPresenter.Callback, MenuBuilder.Callback
{
  private static final int[] ACTION_BAR_DRAWABLE_TOGGLE_ATTRS = { R.attr.homeAsUpIndicator };
  private static final String TAG = "ActionBarActivityDelegateBase";
  private ActionBarView mActionBarView;
  private ActionMode mActionMode;
  private boolean mFeatureIndeterminateProgress;
  private boolean mFeatureProgress;
  private boolean mInvalidateMenuPosted;
  private final Runnable mInvalidateMenuRunnable = new Runnable()
  {
    public void run()
    {
      MenuBuilder localMenuBuilder = ActionBarActivityDelegateBase.this.createMenu();
      if ((ActionBarActivityDelegateBase.this.mActivity.superOnCreatePanelMenu(0, localMenuBuilder)) && (ActionBarActivityDelegateBase.this.mActivity.superOnPreparePanel(0, null, localMenuBuilder))) {
        ActionBarActivityDelegateBase.this.setMenu(localMenuBuilder);
      }
      for (;;)
      {
        ActionBarActivityDelegateBase.access$202(ActionBarActivityDelegateBase.this, false);
        return;
        ActionBarActivityDelegateBase.this.setMenu(null);
      }
    }
  };
  private ListMenuPresenter mListMenuPresenter;
  private MenuBuilder mMenu;
  private boolean mSubDecorInstalled;
  private CharSequence mTitleToSet;
  
  ActionBarActivityDelegateBase(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  private MenuBuilder createMenu()
  {
    MenuBuilder localMenuBuilder = new MenuBuilder(getActionBarThemedContext());
    localMenuBuilder.setCallback(this);
    return localMenuBuilder;
  }
  
  private ProgressBarICS getCircularProgressBar()
  {
    ProgressBarICS localProgressBarICS = (ProgressBarICS)this.mActionBarView.findViewById(R.id.progress_circular);
    if (localProgressBarICS != null) {
      localProgressBarICS.setVisibility(4);
    }
    return localProgressBarICS;
  }
  
  private ProgressBarICS getHorizontalProgressBar()
  {
    ProgressBarICS localProgressBarICS = (ProgressBarICS)this.mActionBarView.findViewById(R.id.progress_horizontal);
    if (localProgressBarICS != null) {
      localProgressBarICS.setVisibility(4);
    }
    return localProgressBarICS;
  }
  
  private MenuView getListMenuView(Context paramContext, MenuPresenter.Callback paramCallback)
  {
    if (this.mMenu == null) {
      return null;
    }
    if (this.mListMenuPresenter == null)
    {
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(R.styleable.Theme);
      int i = localTypedArray.getResourceId(4, R.style.Theme_AppCompat_CompactMenu);
      localTypedArray.recycle();
      this.mListMenuPresenter = new ListMenuPresenter(R.layout.abc_list_menu_item_layout, i);
      this.mListMenuPresenter.setCallback(paramCallback);
      this.mMenu.addMenuPresenter(this.mListMenuPresenter);
    }
    for (;;)
    {
      return this.mListMenuPresenter.getMenuView(new FrameLayout(paramContext));
      this.mListMenuPresenter.updateMenuView(false);
    }
  }
  
  private void hideProgressBars(ProgressBarICS paramProgressBarICS1, ProgressBarICS paramProgressBarICS2)
  {
    if ((this.mFeatureIndeterminateProgress) && (paramProgressBarICS2.getVisibility() == 0)) {
      paramProgressBarICS2.setVisibility(4);
    }
    if ((this.mFeatureProgress) && (paramProgressBarICS1.getVisibility() == 0)) {
      paramProgressBarICS1.setVisibility(4);
    }
  }
  
  private void reopenMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if ((this.mActionBarView != null) && (this.mActionBarView.isOverflowReserved()))
    {
      if ((!this.mActionBarView.isOverflowMenuShowing()) || (!paramBoolean))
      {
        if (this.mActionBarView.getVisibility() == 0) {
          this.mActionBarView.showOverflowMenu();
        }
        return;
      }
      this.mActionBarView.hideOverflowMenu();
      return;
    }
    paramMenuBuilder.close();
  }
  
  private void setMenu(MenuBuilder paramMenuBuilder)
  {
    if (paramMenuBuilder == this.mMenu) {}
    do
    {
      return;
      if (this.mMenu != null) {
        this.mMenu.removeMenuPresenter(this.mListMenuPresenter);
      }
      this.mMenu = paramMenuBuilder;
      if ((paramMenuBuilder != null) && (this.mListMenuPresenter != null)) {
        paramMenuBuilder.addMenuPresenter(this.mListMenuPresenter);
      }
    } while (this.mActionBarView == null);
    this.mActionBarView.setMenu(paramMenuBuilder, this);
  }
  
  private void showProgressBars(ProgressBarICS paramProgressBarICS1, ProgressBarICS paramProgressBarICS2)
  {
    if ((this.mFeatureIndeterminateProgress) && (paramProgressBarICS2.getVisibility() == 4)) {
      paramProgressBarICS2.setVisibility(0);
    }
    if ((this.mFeatureProgress) && (paramProgressBarICS1.getProgress() < 10000)) {
      paramProgressBarICS1.setVisibility(0);
    }
  }
  
  private void updateProgressBars(int paramInt)
  {
    ProgressBarICS localProgressBarICS1 = getCircularProgressBar();
    ProgressBarICS localProgressBarICS2 = getHorizontalProgressBar();
    if (paramInt == -1) {
      if (this.mFeatureProgress)
      {
        paramInt = localProgressBarICS2.getProgress();
        if ((localProgressBarICS2.isIndeterminate()) || (paramInt < 10000))
        {
          paramInt = 0;
          localProgressBarICS2.setVisibility(paramInt);
        }
      }
      else if (this.mFeatureIndeterminateProgress)
      {
        localProgressBarICS1.setVisibility(0);
      }
    }
    label99:
    do
    {
      do
      {
        return;
        paramInt = 4;
        break;
        if (paramInt != -2) {
          break label99;
        }
        if (this.mFeatureProgress) {
          localProgressBarICS2.setVisibility(8);
        }
      } while (!this.mFeatureIndeterminateProgress);
      localProgressBarICS1.setVisibility(8);
      return;
      if (paramInt == -3)
      {
        localProgressBarICS2.setIndeterminate(true);
        return;
      }
      if (paramInt == -4)
      {
        localProgressBarICS2.setIndeterminate(false);
        return;
      }
    } while ((paramInt < 0) || (paramInt > 10000));
    localProgressBarICS2.setProgress(paramInt + 0);
    if (paramInt < 10000)
    {
      showProgressBars(localProgressBarICS2, localProgressBarICS1);
      return;
    }
    hideProgressBars(localProgressBarICS2, localProgressBarICS1);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    if (this.mHasActionBar) {
      ((ViewGroup)this.mActivity.findViewById(16908290)).addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      this.mActivity.onSupportContentChanged();
      return;
      this.mActivity.superSetContentView(paramView, paramLayoutParams);
    }
  }
  
  public ActionBar createSupportActionBar()
  {
    ensureSubDecor();
    return new ActionBarImplBase(this.mActivity, this.mActivity);
  }
  
  final void ensureSubDecor()
  {
    boolean bool2;
    boolean bool1;
    if ((this.mHasActionBar) && (!this.mSubDecorInstalled))
    {
      if (!this.mOverlayActionBar) {
        break label252;
      }
      this.mActivity.superSetContentView(R.layout.abc_action_bar_decor_overlay);
      this.mActionBarView = ((ActionBarView)this.mActivity.findViewById(R.id.action_bar));
      this.mActionBarView.setWindowCallback(this.mActivity);
      if (this.mFeatureProgress) {
        this.mActionBarView.initProgress();
      }
      if (this.mFeatureIndeterminateProgress) {
        this.mActionBarView.initIndeterminateProgress();
      }
      bool2 = "splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata());
      if (!bool2) {
        break label265;
      }
      bool1 = this.mActivity.getResources().getBoolean(R.bool.abc_split_action_bar_is_narrow);
    }
    for (;;)
    {
      Object localObject = (ActionBarContainer)this.mActivity.findViewById(R.id.split_action_bar);
      if (localObject != null)
      {
        this.mActionBarView.setSplitView((ActionBarContainer)localObject);
        this.mActionBarView.setSplitActionBar(bool1);
        this.mActionBarView.setSplitWhenNarrow(bool2);
        ActionBarContextView localActionBarContextView = (ActionBarContextView)this.mActivity.findViewById(R.id.action_context_bar);
        localActionBarContextView.setSplitView((ActionBarContainer)localObject);
        localActionBarContextView.setSplitActionBar(bool1);
        localActionBarContextView.setSplitWhenNarrow(bool2);
      }
      this.mActivity.findViewById(16908290).setId(-1);
      this.mActivity.findViewById(R.id.action_bar_activity_content).setId(16908290);
      if (this.mTitleToSet != null)
      {
        this.mActionBarView.setWindowTitle(this.mTitleToSet);
        this.mTitleToSet = null;
      }
      this.mSubDecorInstalled = true;
      supportInvalidateOptionsMenu();
      return;
      label252:
      this.mActivity.superSetContentView(R.layout.abc_action_bar_decor);
      break;
      label265:
      localObject = this.mActivity.obtainStyledAttributes(R.styleable.ActionBarWindow);
      bool1 = ((TypedArray)localObject).getBoolean(2, false);
      ((TypedArray)localObject).recycle();
    }
  }
  
  ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return new ActionBarDrawableToggleImpl(null);
  }
  
  public boolean onBackPressed()
  {
    if (this.mActionMode != null)
    {
      this.mActionMode.finish();
      return true;
    }
    if ((this.mActionBarView != null) && (this.mActionBarView.hasExpandedActionView()))
    {
      this.mActionBarView.collapseActionView();
      return true;
    }
    return false;
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    this.mActivity.closeOptionsMenu();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if ((this.mHasActionBar) && (this.mSubDecorInstalled)) {
      ((ActionBarImplBase)getSupportActionBar()).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentChanged() {}
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt != 0) {
      return this.mActivity.superOnCreatePanelMenu(paramInt, paramMenu);
    }
    return false;
  }
  
  public View onCreatePanelView(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 0)
    {
      boolean bool1 = true;
      boolean bool2 = true;
      MenuBuilder localMenuBuilder = this.mMenu;
      Object localObject2 = localMenuBuilder;
      if (this.mActionMode == null)
      {
        localObject1 = localMenuBuilder;
        if (localMenuBuilder == null)
        {
          localObject1 = createMenu();
          setMenu((MenuBuilder)localObject1);
          ((MenuBuilder)localObject1).stopDispatchingItemsChanged();
          bool2 = this.mActivity.superOnCreatePanelMenu(0, (Menu)localObject1);
        }
        localObject2 = localObject1;
        bool1 = bool2;
        if (bool2)
        {
          ((MenuBuilder)localObject1).stopDispatchingItemsChanged();
          bool1 = this.mActivity.superOnPreparePanel(0, null, (Menu)localObject1);
          localObject2 = localObject1;
        }
      }
      if (bool1)
      {
        localObject1 = (View)getListMenuView(this.mActivity, this);
        ((MenuBuilder)localObject2).startDispatchingItemsChanged();
      }
    }
    else
    {
      return (View)localObject1;
    }
    setMenu(null);
    return null;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    MenuItem localMenuItem = paramMenuItem;
    if (paramInt == 0) {
      localMenuItem = MenuWrapperFactory.createMenuItemWrapper(paramMenuItem);
    }
    return this.mActivity.superOnMenuItemSelected(paramInt, localMenuItem);
  }
  
  public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
  {
    return this.mActivity.onMenuItemSelected(0, paramMenuItem);
  }
  
  public void onMenuModeChange(MenuBuilder paramMenuBuilder)
  {
    reopenMenu(paramMenuBuilder, true);
  }
  
  public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
  {
    return false;
  }
  
  public void onPostResume()
  {
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      localActionBarImplBase.setShowHideAnimationEnabled(true);
    }
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if (paramInt != 0) {
      return this.mActivity.superOnPreparePanel(paramInt, paramView, paramMenu);
    }
    return false;
  }
  
  public void onStop()
  {
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      localActionBarImplBase.setShowHideAnimationEnabled(false);
    }
  }
  
  public void onTitleChanged(CharSequence paramCharSequence)
  {
    if (this.mActionBarView != null)
    {
      this.mActionBarView.setWindowTitle(paramCharSequence);
      return;
    }
    this.mTitleToSet = paramCharSequence;
  }
  
  public void setContentView(int paramInt)
  {
    ensureSubDecor();
    if (this.mHasActionBar)
    {
      ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
      localViewGroup.removeAllViews();
      this.mActivity.getLayoutInflater().inflate(paramInt, localViewGroup);
    }
    for (;;)
    {
      this.mActivity.onSupportContentChanged();
      return;
      this.mActivity.superSetContentView(paramInt);
    }
  }
  
  public void setContentView(View paramView)
  {
    ensureSubDecor();
    if (this.mHasActionBar)
    {
      ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
      localViewGroup.removeAllViews();
      localViewGroup.addView(paramView);
    }
    for (;;)
    {
      this.mActivity.onSupportContentChanged();
      return;
      this.mActivity.superSetContentView(paramView);
    }
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    ensureSubDecor();
    if (this.mHasActionBar)
    {
      ViewGroup localViewGroup = (ViewGroup)this.mActivity.findViewById(16908290);
      localViewGroup.removeAllViews();
      localViewGroup.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      this.mActivity.onSupportContentChanged();
      return;
      this.mActivity.superSetContentView(paramView, paramLayoutParams);
    }
  }
  
  void setSupportProgress(int paramInt)
  {
    updateProgressBars(paramInt + 0);
  }
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -3;; i = -4)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = -2)
    {
      updateProgressBars(i);
      return;
    }
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    paramCallback = new ActionModeCallbackWrapper(paramCallback);
    ActionBarImplBase localActionBarImplBase = (ActionBarImplBase)getSupportActionBar();
    if (localActionBarImplBase != null) {
      this.mActionMode = localActionBarImplBase.startActionMode(paramCallback);
    }
    if (this.mActionMode != null) {
      this.mActivity.onSupportActionModeStarted(this.mActionMode);
    }
    return this.mActionMode;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if (!this.mInvalidateMenuPosted)
    {
      this.mInvalidateMenuPosted = true;
      this.mActivity.getWindow().getDecorView().post(this.mInvalidateMenuRunnable);
    }
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    case 7: 
    default: 
      return this.mActivity.requestWindowFeature(paramInt);
    case 8: 
      this.mHasActionBar = true;
      return true;
    case 9: 
      this.mOverlayActionBar = true;
      return true;
    case 2: 
      this.mFeatureProgress = true;
      return true;
    }
    this.mFeatureIndeterminateProgress = true;
    return true;
  }
  
  private class ActionBarDrawableToggleImpl
    implements ActionBarDrawerToggle.Delegate
  {
    private ActionBarDrawableToggleImpl() {}
    
    public Drawable getThemeUpIndicator()
    {
      TypedArray localTypedArray = ActionBarActivityDelegateBase.this.mActivity.obtainStyledAttributes(ActionBarActivityDelegateBase.ACTION_BAR_DRAWABLE_TOGGLE_ATTRS);
      Drawable localDrawable = localTypedArray.getDrawable(0);
      localTypedArray.recycle();
      return localDrawable;
    }
    
    public void setActionBarDescription(int paramInt) {}
    
    public void setActionBarUpIndicator(Drawable paramDrawable, int paramInt)
    {
      if (ActionBarActivityDelegateBase.this.mActionBarView != null) {
        ActionBarActivityDelegateBase.this.mActionBarView.setHomeAsUpIndicator(paramDrawable);
      }
    }
  }
  
  private class ActionModeCallbackWrapper
    implements ActionMode.Callback
  {
    private ActionMode.Callback mWrapped;
    
    public ActionModeCallbackWrapper(ActionMode.Callback paramCallback)
    {
      this.mWrapped = paramCallback;
    }
    
    public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
    }
    
    public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
    }
    
    public void onDestroyActionMode(ActionMode paramActionMode)
    {
      this.mWrapped.onDestroyActionMode(paramActionMode);
      ActionBarActivityDelegateBase.this.mActivity.onSupportActionModeFinished(paramActionMode);
      ActionBarActivityDelegateBase.access$402(ActionBarActivityDelegateBase.this, null);
    }
    
    public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/android/support/v7/app/ActionBarActivityDelegateBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */