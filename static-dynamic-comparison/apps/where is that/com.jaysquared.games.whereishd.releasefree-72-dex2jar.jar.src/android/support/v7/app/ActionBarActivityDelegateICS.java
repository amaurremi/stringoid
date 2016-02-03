package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.internal.view.ActionModeWrapper;
import android.support.v7.internal.view.ActionModeWrapper.CallbackWrapper;
import android.support.v7.internal.view.menu.MenuWrapperFactory;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

class ActionBarActivityDelegateICS
  extends ActionBarActivityDelegate
{
  Menu mMenu;
  
  ActionBarActivityDelegateICS(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mActivity.superAddContentView(paramView, paramLayoutParams);
  }
  
  ActionModeWrapper.CallbackWrapper createActionModeCallbackWrapper(Context paramContext, android.support.v7.view.ActionMode.Callback paramCallback)
  {
    return new ActionModeWrapper.CallbackWrapper(paramContext, paramCallback);
  }
  
  ActionModeWrapper createActionModeWrapper(Context paramContext, android.view.ActionMode paramActionMode)
  {
    return new ActionModeWrapper(paramContext, paramActionMode);
  }
  
  public ActionBar createSupportActionBar()
  {
    return new ActionBarImplICS(this.mActivity, this.mActivity);
  }
  
  Window.Callback createWindowCallbackWrapper(Window.Callback paramCallback)
  {
    return new WindowCallbackWrapper(paramCallback);
  }
  
  int getHomeAsUpIndicatorAttrId()
  {
    return 16843531;
  }
  
  public void onActionModeFinished(android.view.ActionMode paramActionMode)
  {
    this.mActivity.onSupportActionModeFinished(createActionModeWrapper(getActionBarThemedContext(), paramActionMode));
  }
  
  public void onActionModeStarted(android.view.ActionMode paramActionMode)
  {
    this.mActivity.onSupportActionModeStarted(createActionModeWrapper(getActionBarThemedContext(), paramActionMode));
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onContentChanged()
  {
    this.mActivity.onSupportContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if ("splitActionBarWhenNarrow".equals(getUiOptionsFromMetadata())) {
      this.mActivity.getWindow().setUiOptions(1, 1);
    }
    super.onCreate(paramBundle);
    if (this.mHasActionBar) {
      this.mActivity.requestWindowFeature(8);
    }
    if (this.mOverlayActionBar) {
      this.mActivity.requestWindowFeature(9);
    }
    paramBundle = this.mActivity.getWindow();
    paramBundle.setCallback(createWindowCallbackWrapper(paramBundle.getCallback()));
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8))
    {
      if (this.mMenu == null) {
        this.mMenu = MenuWrapperFactory.createMenuWrapper(paramMenu);
      }
      return this.mActivity.superOnCreatePanelMenu(paramInt, this.mMenu);
    }
    return this.mActivity.superOnCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
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
  
  public void onPostResume() {}
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) || (paramInt == 8)) {
      return this.mActivity.superOnPreparePanel(paramInt, paramView, this.mMenu);
    }
    return this.mActivity.superOnPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onStop() {}
  
  public void onTitleChanged(CharSequence paramCharSequence) {}
  
  public void setContentView(int paramInt)
  {
    this.mActivity.superSetContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    this.mActivity.superSetContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.mActivity.superSetContentView(paramView, paramLayoutParams);
  }
  
  void setSupportProgress(int paramInt)
  {
    this.mActivity.setProgress(paramInt);
  }
  
  void setSupportProgressBarIndeterminate(boolean paramBoolean)
  {
    this.mActivity.setProgressBarIndeterminate(paramBoolean);
  }
  
  void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean)
  {
    this.mActivity.setProgressBarIndeterminateVisibility(paramBoolean);
  }
  
  void setSupportProgressBarVisibility(boolean paramBoolean)
  {
    this.mActivity.setProgressBarVisibility(paramBoolean);
  }
  
  public android.support.v7.view.ActionMode startSupportActionMode(android.support.v7.view.ActionMode.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("ActionMode callback can not be null.");
    }
    Context localContext = getActionBarThemedContext();
    ActionModeWrapper.CallbackWrapper localCallbackWrapper = createActionModeCallbackWrapper(localContext, paramCallback);
    paramCallback = null;
    android.view.ActionMode localActionMode = this.mActivity.startActionMode(localCallbackWrapper);
    if (localActionMode != null)
    {
      paramCallback = createActionModeWrapper(localContext, localActionMode);
      localCallbackWrapper.setLastStartedActionMode(paramCallback);
    }
    return paramCallback;
  }
  
  public void supportInvalidateOptionsMenu()
  {
    this.mMenu = null;
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return this.mActivity.requestWindowFeature(paramInt);
  }
  
  class WindowCallbackWrapper
    implements Window.Callback
  {
    final Window.Callback mWrapped;
    
    public WindowCallbackWrapper(Window.Callback paramCallback)
    {
      this.mWrapped = paramCallback;
    }
    
    public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
    {
      return this.mWrapped.dispatchGenericMotionEvent(paramMotionEvent);
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return this.mWrapped.dispatchKeyEvent(paramKeyEvent);
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return this.mWrapped.dispatchKeyShortcutEvent(paramKeyEvent);
    }
    
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      return this.mWrapped.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      return this.mWrapped.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
    {
      return this.mWrapped.dispatchTrackballEvent(paramMotionEvent);
    }
    
    public void onActionModeFinished(android.view.ActionMode paramActionMode)
    {
      this.mWrapped.onActionModeFinished(paramActionMode);
      ActionBarActivityDelegateICS.this.onActionModeFinished(paramActionMode);
    }
    
    public void onActionModeStarted(android.view.ActionMode paramActionMode)
    {
      this.mWrapped.onActionModeStarted(paramActionMode);
      ActionBarActivityDelegateICS.this.onActionModeStarted(paramActionMode);
    }
    
    public void onAttachedToWindow()
    {
      this.mWrapped.onAttachedToWindow();
    }
    
    public void onContentChanged()
    {
      this.mWrapped.onContentChanged();
    }
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      return this.mWrapped.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public View onCreatePanelView(int paramInt)
    {
      return this.mWrapped.onCreatePanelView(paramInt);
    }
    
    public void onDetachedFromWindow()
    {
      this.mWrapped.onDetachedFromWindow();
    }
    
    public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
    {
      return this.mWrapped.onMenuItemSelected(paramInt, paramMenuItem);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      return this.mWrapped.onMenuOpened(paramInt, paramMenu);
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      this.mWrapped.onPanelClosed(paramInt, paramMenu);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      return this.mWrapped.onPreparePanel(paramInt, paramView, paramMenu);
    }
    
    public boolean onSearchRequested()
    {
      return this.mWrapped.onSearchRequested();
    }
    
    public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
    {
      this.mWrapped.onWindowAttributesChanged(paramLayoutParams);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      this.mWrapped.onWindowFocusChanged(paramBoolean);
    }
    
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback paramCallback)
    {
      return this.mWrapped.onWindowStartingActionMode(paramCallback);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/app/ActionBarActivityDelegateICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */