package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.ActionBarSherlock.Implementation;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeFinishedListener;
import com.actionbarsherlock.ActionBarSherlock.OnActionModeStartedListener;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.internal.app.ActionBarWrapper;
import com.actionbarsherlock.internal.view.menu.MenuItemWrapper;
import com.actionbarsherlock.internal.view.menu.MenuWrapper;
import com.actionbarsherlock.view.MenuInflater;

@ActionBarSherlock.Implementation(api=14)
public class ActionBarSherlockNative
  extends ActionBarSherlock
{
  private ActionBarWrapper mActionBar;
  private ActionModeWrapper mActionMode;
  private MenuWrapper mMenu;
  
  public ActionBarSherlockNative(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
  }
  
  private void initActionBar()
  {
    if ((this.mActionBar != null) || (this.mActivity.getActionBar() == null)) {
      return;
    }
    this.mActionBar = new ActionBarWrapper(this.mActivity);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mActivity.getWindow().addContentView(paramView, paramLayoutParams);
    initActionBar();
  }
  
  public boolean dispatchCreateOptionsMenu(Menu paramMenu)
  {
    if ((this.mMenu == null) || (paramMenu != this.mMenu.unwrap())) {
      this.mMenu = new MenuWrapper(paramMenu);
    }
    return callbackCreateOptionsMenu(this.mMenu);
  }
  
  public void dispatchInvalidateOptionsMenu()
  {
    this.mActivity.getWindow().invalidatePanelMenu(0);
    if (this.mMenu != null) {
      this.mMenu.invalidate();
    }
  }
  
  public boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.mMenu == null) {
      if (paramMenuItem.getItemId() != 16908332) {
        throw new IllegalStateException("Non-home action item clicked before onCreateOptionsMenu with ID " + paramMenuItem.getItemId());
      }
    }
    for (paramMenuItem = new MenuItemWrapper(paramMenuItem);; paramMenuItem = this.mMenu.findItem(paramMenuItem)) {
      return callbackOptionsItemSelected(paramMenuItem);
    }
  }
  
  public boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    return callbackPrepareOptionsMenu(this.mMenu);
  }
  
  public ActionBar getActionBar()
  {
    initActionBar();
    return this.mActionBar;
  }
  
  protected Context getThemedContext()
  {
    Activity localActivity = this.mActivity;
    TypedValue localTypedValue = new TypedValue();
    this.mActivity.getTheme().resolveAttribute(16843671, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      return new ContextThemeWrapper(localActivity, localTypedValue.resourceId);
    }
    return localActivity;
  }
  
  public boolean hasFeature(int paramInt)
  {
    return this.mActivity.getWindow().hasFeature(paramInt);
  }
  
  public boolean requestFeature(int paramInt)
  {
    return this.mActivity.getWindow().requestFeature(paramInt);
  }
  
  public void setContentView(int paramInt)
  {
    this.mActivity.getWindow().setContentView(paramInt);
    initActionBar();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mActivity.getWindow().setContentView(paramView, paramLayoutParams);
    initActionBar();
  }
  
  public void setProgress(int paramInt)
  {
    this.mActivity.setProgress(paramInt);
  }
  
  public void setProgressBarIndeterminate(boolean paramBoolean)
  {
    this.mActivity.setProgressBarIndeterminate(paramBoolean);
  }
  
  public void setProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    this.mActivity.setProgressBarIndeterminateVisibility(paramBoolean);
  }
  
  public void setProgressBarVisibility(boolean paramBoolean)
  {
    this.mActivity.setProgressBarVisibility(paramBoolean);
  }
  
  public void setSecondaryProgress(int paramInt)
  {
    this.mActivity.setSecondaryProgress(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mActivity.getWindow().setTitle(paramCharSequence);
  }
  
  public void setUiOptions(int paramInt)
  {
    this.mActivity.getWindow().setUiOptions(paramInt);
  }
  
  public void setUiOptions(int paramInt1, int paramInt2)
  {
    this.mActivity.getWindow().setUiOptions(paramInt1, paramInt2);
  }
  
  public com.actionbarsherlock.view.ActionMode startActionMode(com.actionbarsherlock.view.ActionMode.Callback paramCallback)
  {
    if (this.mActionMode != null) {
      this.mActionMode.finish();
    }
    if (paramCallback != null) {}
    for (paramCallback = new ActionModeCallbackWrapper(paramCallback);; paramCallback = null)
    {
      if (this.mActivity.startActionMode(paramCallback) == null) {
        this.mActionMode = null;
      }
      if (((this.mActivity instanceof ActionBarSherlock.OnActionModeStartedListener)) && (this.mActionMode != null)) {
        ((ActionBarSherlock.OnActionModeStartedListener)this.mActivity).onActionModeStarted(this.mActionMode);
      }
      return this.mActionMode;
    }
  }
  
  private class ActionModeCallbackWrapper
    implements android.view.ActionMode.Callback
  {
    private final com.actionbarsherlock.view.ActionMode.Callback mCallback;
    
    public ActionModeCallbackWrapper(com.actionbarsherlock.view.ActionMode.Callback paramCallback)
    {
      this.mCallback = paramCallback;
    }
    
    public boolean onActionItemClicked(android.view.ActionMode paramActionMode, MenuItem paramMenuItem)
    {
      return this.mCallback.onActionItemClicked(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu().findItem(paramMenuItem));
    }
    
    public boolean onCreateActionMode(android.view.ActionMode paramActionMode, Menu paramMenu)
    {
      ActionBarSherlockNative.access$002(ActionBarSherlockNative.this, new ActionBarSherlockNative.ActionModeWrapper(ActionBarSherlockNative.this, paramActionMode));
      return this.mCallback.onCreateActionMode(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu());
    }
    
    public void onDestroyActionMode(android.view.ActionMode paramActionMode)
    {
      this.mCallback.onDestroyActionMode(ActionBarSherlockNative.this.mActionMode);
      if ((ActionBarSherlockNative.this.mActivity instanceof ActionBarSherlock.OnActionModeFinishedListener)) {
        ((ActionBarSherlock.OnActionModeFinishedListener)ActionBarSherlockNative.this.mActivity).onActionModeFinished(ActionBarSherlockNative.this.mActionMode);
      }
    }
    
    public boolean onPrepareActionMode(android.view.ActionMode paramActionMode, Menu paramMenu)
    {
      return this.mCallback.onPrepareActionMode(ActionBarSherlockNative.this.mActionMode, ActionBarSherlockNative.this.mActionMode.getMenu());
    }
  }
  
  private class ActionModeWrapper
    extends com.actionbarsherlock.view.ActionMode
  {
    private final android.view.ActionMode mActionMode;
    private MenuWrapper mMenu = null;
    
    ActionModeWrapper(android.view.ActionMode paramActionMode)
    {
      this.mActionMode = paramActionMode;
    }
    
    public void finish()
    {
      this.mActionMode.finish();
    }
    
    public View getCustomView()
    {
      return this.mActionMode.getCustomView();
    }
    
    public MenuWrapper getMenu()
    {
      if (this.mMenu == null) {
        this.mMenu = new MenuWrapper(this.mActionMode.getMenu());
      }
      return this.mMenu;
    }
    
    public MenuInflater getMenuInflater()
    {
      return ActionBarSherlockNative.this.getMenuInflater();
    }
    
    public CharSequence getSubtitle()
    {
      return this.mActionMode.getSubtitle();
    }
    
    public Object getTag()
    {
      return this.mActionMode.getTag();
    }
    
    public CharSequence getTitle()
    {
      return this.mActionMode.getTitle();
    }
    
    public void invalidate()
    {
      this.mActionMode.invalidate();
      if (this.mMenu != null) {
        this.mMenu.invalidate();
      }
    }
    
    public void setCustomView(View paramView)
    {
      this.mActionMode.setCustomView(paramView);
    }
    
    public void setSubtitle(int paramInt)
    {
      this.mActionMode.setSubtitle(paramInt);
    }
    
    public void setSubtitle(CharSequence paramCharSequence)
    {
      this.mActionMode.setSubtitle(paramCharSequence);
    }
    
    public void setTag(Object paramObject)
    {
      this.mActionMode.setTag(paramObject);
    }
    
    public void setTitle(int paramInt)
    {
      this.mActionMode.setTitle(paramInt);
    }
    
    public void setTitle(CharSequence paramCharSequence)
    {
      this.mActionMode.setTitle(paramCharSequence);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/actionbarsherlock/internal/ActionBarSherlockNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */