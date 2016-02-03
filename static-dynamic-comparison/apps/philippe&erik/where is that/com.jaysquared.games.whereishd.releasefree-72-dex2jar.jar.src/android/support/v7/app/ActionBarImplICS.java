package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class ActionBarImplICS
  extends ActionBar
{
  final android.app.ActionBar mActionBar;
  android.support.v4.app.FragmentTransaction mActiveTransaction;
  final Activity mActivity;
  private ArrayList<WeakReference<OnMenuVisibilityListenerWrapper>> mAddedMenuVisWrappers = new ArrayList();
  final ActionBar.Callback mCallback;
  private ImageView mHomeActionView;
  
  public ActionBarImplICS(Activity paramActivity, ActionBar.Callback paramCallback)
  {
    this(paramActivity, paramCallback, true);
  }
  
  ActionBarImplICS(Activity paramActivity, ActionBar.Callback paramCallback, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.mCallback = paramCallback;
    this.mActionBar = paramActivity.getActionBar();
    if ((paramBoolean) && ((getDisplayOptions() & 0x4) != 0)) {
      setHomeButtonEnabled(true);
    }
  }
  
  private OnMenuVisibilityListenerWrapper findAndRemoveMenuVisWrapper(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    int i = 0;
    if (i < this.mAddedMenuVisWrappers.size())
    {
      OnMenuVisibilityListenerWrapper localOnMenuVisibilityListenerWrapper = (OnMenuVisibilityListenerWrapper)((WeakReference)this.mAddedMenuVisWrappers.get(i)).get();
      int j;
      if (localOnMenuVisibilityListenerWrapper == null)
      {
        this.mAddedMenuVisWrappers.remove(i);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (localOnMenuVisibilityListenerWrapper.mWrappedListener != paramOnMenuVisibilityListener);
      this.mAddedMenuVisWrappers.remove(i);
      return localOnMenuVisibilityListenerWrapper;
    }
    return null;
  }
  
  public void addOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    if (paramOnMenuVisibilityListener != null)
    {
      paramOnMenuVisibilityListener = new OnMenuVisibilityListenerWrapper(paramOnMenuVisibilityListener);
      this.mAddedMenuVisWrappers.add(new WeakReference(paramOnMenuVisibilityListener));
      this.mActionBar.addOnMenuVisibilityListener(paramOnMenuVisibilityListener);
    }
  }
  
  public void addTab(ActionBar.Tab paramTab)
  {
    this.mActionBar.addTab(((TabWrapper)paramTab).mWrappedTab);
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt)
  {
    this.mActionBar.addTab(((TabWrapper)paramTab).mWrappedTab, paramInt);
  }
  
  public void addTab(ActionBar.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    this.mActionBar.addTab(((TabWrapper)paramTab).mWrappedTab, paramInt, paramBoolean);
  }
  
  public void addTab(ActionBar.Tab paramTab, boolean paramBoolean)
  {
    this.mActionBar.addTab(((TabWrapper)paramTab).mWrappedTab, paramBoolean);
  }
  
  void commitActiveTransaction()
  {
    if ((this.mActiveTransaction != null) && (!this.mActiveTransaction.isEmpty())) {
      this.mActiveTransaction.commit();
    }
    this.mActiveTransaction = null;
  }
  
  android.support.v4.app.FragmentTransaction getActiveTransaction()
  {
    if (this.mActiveTransaction == null) {
      this.mActiveTransaction = this.mCallback.getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
    }
    return this.mActiveTransaction;
  }
  
  public View getCustomView()
  {
    return this.mActionBar.getCustomView();
  }
  
  public int getDisplayOptions()
  {
    return this.mActionBar.getDisplayOptions();
  }
  
  public int getHeight()
  {
    return this.mActionBar.getHeight();
  }
  
  ImageView getHomeActionView()
  {
    Object localObject1;
    if (this.mHomeActionView == null)
    {
      localObject1 = this.mActivity.findViewById(16908332);
      if (localObject1 == null) {}
      do
      {
        return null;
        localObject2 = (ViewGroup)((View)localObject1).getParent();
      } while (((ViewGroup)localObject2).getChildCount() != 2);
      localObject1 = ((ViewGroup)localObject2).getChildAt(0);
      Object localObject2 = ((ViewGroup)localObject2).getChildAt(1);
      if (((View)localObject1).getId() != 16908332) {
        break label82;
      }
      localObject1 = localObject2;
    }
    label82:
    for (;;)
    {
      if ((localObject1 instanceof ImageView)) {
        this.mHomeActionView = ((ImageView)localObject1);
      }
      return this.mHomeActionView;
    }
  }
  
  public int getNavigationItemCount()
  {
    return this.mActionBar.getNavigationItemCount();
  }
  
  public int getNavigationMode()
  {
    return this.mActionBar.getNavigationMode();
  }
  
  public int getSelectedNavigationIndex()
  {
    return this.mActionBar.getSelectedNavigationIndex();
  }
  
  public ActionBar.Tab getSelectedTab()
  {
    return (ActionBar.Tab)this.mActionBar.getSelectedTab().getTag();
  }
  
  public CharSequence getSubtitle()
  {
    return this.mActionBar.getSubtitle();
  }
  
  public ActionBar.Tab getTabAt(int paramInt)
  {
    return (ActionBar.Tab)this.mActionBar.getTabAt(paramInt).getTag();
  }
  
  public int getTabCount()
  {
    return this.mActionBar.getTabCount();
  }
  
  Drawable getThemeDefaultUpIndicator()
  {
    TypedArray localTypedArray = this.mActivity.obtainStyledAttributes(new int[] { 16843531 });
    Drawable localDrawable = localTypedArray.getDrawable(0);
    localTypedArray.recycle();
    return localDrawable;
  }
  
  public Context getThemedContext()
  {
    return this.mActionBar.getThemedContext();
  }
  
  public CharSequence getTitle()
  {
    return this.mActionBar.getTitle();
  }
  
  public void hide()
  {
    this.mActionBar.hide();
  }
  
  public boolean isShowing()
  {
    return this.mActionBar.isShowing();
  }
  
  public ActionBar.Tab newTab()
  {
    android.app.ActionBar.Tab localTab = this.mActionBar.newTab();
    TabWrapper localTabWrapper = new TabWrapper(localTab);
    localTab.setTag(localTabWrapper);
    return localTabWrapper;
  }
  
  public void removeAllTabs()
  {
    this.mActionBar.removeAllTabs();
  }
  
  public void removeOnMenuVisibilityListener(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
  {
    paramOnMenuVisibilityListener = findAndRemoveMenuVisWrapper(paramOnMenuVisibilityListener);
    this.mActionBar.removeOnMenuVisibilityListener(paramOnMenuVisibilityListener);
  }
  
  public void removeTab(ActionBar.Tab paramTab)
  {
    this.mActionBar.removeTab(((TabWrapper)paramTab).mWrappedTab);
  }
  
  public void removeTabAt(int paramInt)
  {
    this.mActionBar.removeTabAt(paramInt);
  }
  
  public void selectTab(ActionBar.Tab paramTab)
  {
    this.mActionBar.selectTab(((TabWrapper)paramTab).mWrappedTab);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mActionBar.setBackgroundDrawable(paramDrawable);
  }
  
  public void setCustomView(int paramInt)
  {
    this.mActionBar.setCustomView(paramInt);
  }
  
  public void setCustomView(View paramView)
  {
    this.mActionBar.setCustomView(paramView);
  }
  
  public void setCustomView(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    android.app.ActionBar.LayoutParams localLayoutParams = new android.app.ActionBar.LayoutParams(paramLayoutParams);
    localLayoutParams.gravity = paramLayoutParams.gravity;
    this.mActionBar.setCustomView(paramView, localLayoutParams);
  }
  
  public void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayHomeAsUpEnabled(paramBoolean);
  }
  
  public void setDisplayOptions(int paramInt)
  {
    this.mActionBar.setDisplayOptions(paramInt);
  }
  
  public void setDisplayOptions(int paramInt1, int paramInt2)
  {
    this.mActionBar.setDisplayOptions(paramInt1, paramInt2);
  }
  
  public void setDisplayShowCustomEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayShowCustomEnabled(paramBoolean);
  }
  
  public void setDisplayShowHomeEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayShowHomeEnabled(paramBoolean);
  }
  
  public void setDisplayShowTitleEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayShowTitleEnabled(paramBoolean);
  }
  
  public void setDisplayUseLogoEnabled(boolean paramBoolean)
  {
    this.mActionBar.setDisplayUseLogoEnabled(paramBoolean);
  }
  
  public void setHomeAsUpIndicator(int paramInt)
  {
    ImageView localImageView = getHomeActionView();
    if (localImageView != null)
    {
      if (paramInt != 0) {
        localImageView.setImageResource(paramInt);
      }
    }
    else {
      return;
    }
    localImageView.setImageDrawable(getThemeDefaultUpIndicator());
  }
  
  public void setHomeAsUpIndicator(Drawable paramDrawable)
  {
    ImageView localImageView = getHomeActionView();
    if (localImageView != null)
    {
      Drawable localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = getThemeDefaultUpIndicator();
      }
      localImageView.setImageDrawable(localDrawable);
    }
  }
  
  public void setHomeButtonEnabled(boolean paramBoolean)
  {
    this.mActionBar.setHomeButtonEnabled(paramBoolean);
  }
  
  public void setIcon(int paramInt)
  {
    this.mActionBar.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.mActionBar.setIcon(paramDrawable);
  }
  
  public void setListNavigationCallbacks(SpinnerAdapter paramSpinnerAdapter, ActionBar.OnNavigationListener paramOnNavigationListener)
  {
    android.app.ActionBar localActionBar = this.mActionBar;
    if (paramOnNavigationListener != null) {}
    for (paramOnNavigationListener = new OnNavigationListenerWrapper(paramOnNavigationListener);; paramOnNavigationListener = null)
    {
      localActionBar.setListNavigationCallbacks(paramSpinnerAdapter, paramOnNavigationListener);
      return;
    }
  }
  
  public void setLogo(int paramInt)
  {
    this.mActionBar.setLogo(paramInt);
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    this.mActionBar.setLogo(paramDrawable);
  }
  
  public void setNavigationMode(int paramInt)
  {
    this.mActionBar.setNavigationMode(paramInt);
  }
  
  public void setSelectedNavigationItem(int paramInt)
  {
    this.mActionBar.setSelectedNavigationItem(paramInt);
  }
  
  public void setSplitBackgroundDrawable(Drawable paramDrawable)
  {
    this.mActionBar.setSplitBackgroundDrawable(paramDrawable);
  }
  
  public void setStackedBackgroundDrawable(Drawable paramDrawable)
  {
    this.mActionBar.setStackedBackgroundDrawable(paramDrawable);
  }
  
  public void setSubtitle(int paramInt)
  {
    this.mActionBar.setSubtitle(paramInt);
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mActionBar.setSubtitle(paramCharSequence);
  }
  
  public void setTitle(int paramInt)
  {
    this.mActionBar.setTitle(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mActionBar.setTitle(paramCharSequence);
  }
  
  public void show()
  {
    this.mActionBar.show();
  }
  
  static class OnMenuVisibilityListenerWrapper
    implements android.app.ActionBar.OnMenuVisibilityListener
  {
    final ActionBar.OnMenuVisibilityListener mWrappedListener;
    
    public OnMenuVisibilityListenerWrapper(ActionBar.OnMenuVisibilityListener paramOnMenuVisibilityListener)
    {
      this.mWrappedListener = paramOnMenuVisibilityListener;
    }
    
    public void onMenuVisibilityChanged(boolean paramBoolean)
    {
      this.mWrappedListener.onMenuVisibilityChanged(paramBoolean);
    }
  }
  
  static class OnNavigationListenerWrapper
    implements android.app.ActionBar.OnNavigationListener
  {
    private final ActionBar.OnNavigationListener mWrappedListener;
    
    public OnNavigationListenerWrapper(ActionBar.OnNavigationListener paramOnNavigationListener)
    {
      this.mWrappedListener = paramOnNavigationListener;
    }
    
    public boolean onNavigationItemSelected(int paramInt, long paramLong)
    {
      return this.mWrappedListener.onNavigationItemSelected(paramInt, paramLong);
    }
  }
  
  class TabWrapper
    extends ActionBar.Tab
    implements android.app.ActionBar.TabListener
  {
    private CharSequence mContentDescription;
    private ActionBar.TabListener mTabListener;
    private Object mTag;
    final android.app.ActionBar.Tab mWrappedTab;
    
    public TabWrapper(android.app.ActionBar.Tab paramTab)
    {
      this.mWrappedTab = paramTab;
    }
    
    public CharSequence getContentDescription()
    {
      return this.mContentDescription;
    }
    
    public View getCustomView()
    {
      return this.mWrappedTab.getCustomView();
    }
    
    public Drawable getIcon()
    {
      return this.mWrappedTab.getIcon();
    }
    
    public int getPosition()
    {
      return this.mWrappedTab.getPosition();
    }
    
    public Object getTag()
    {
      return this.mTag;
    }
    
    public CharSequence getText()
    {
      return this.mWrappedTab.getText();
    }
    
    public void onTabReselected(android.app.ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction)
    {
      ActionBar.TabListener localTabListener = this.mTabListener;
      if (paramFragmentTransaction != null) {}
      for (paramTab = ActionBarImplICS.this.getActiveTransaction();; paramTab = null)
      {
        localTabListener.onTabReselected(this, paramTab);
        ActionBarImplICS.this.commitActiveTransaction();
        return;
      }
    }
    
    public void onTabSelected(android.app.ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction)
    {
      ActionBar.TabListener localTabListener = this.mTabListener;
      if (paramFragmentTransaction != null) {}
      for (paramTab = ActionBarImplICS.this.getActiveTransaction();; paramTab = null)
      {
        localTabListener.onTabSelected(this, paramTab);
        ActionBarImplICS.this.commitActiveTransaction();
        return;
      }
    }
    
    public void onTabUnselected(android.app.ActionBar.Tab paramTab, android.app.FragmentTransaction paramFragmentTransaction)
    {
      ActionBar.TabListener localTabListener = this.mTabListener;
      if (paramFragmentTransaction != null) {}
      for (paramTab = ActionBarImplICS.this.getActiveTransaction();; paramTab = null)
      {
        localTabListener.onTabUnselected(this, paramTab);
        return;
      }
    }
    
    public void select()
    {
      this.mWrappedTab.select();
    }
    
    public ActionBar.Tab setContentDescription(int paramInt)
    {
      this.mContentDescription = ActionBarImplICS.this.mActivity.getText(paramInt);
      return this;
    }
    
    public ActionBar.Tab setContentDescription(CharSequence paramCharSequence)
    {
      this.mContentDescription = paramCharSequence;
      return this;
    }
    
    public ActionBar.Tab setCustomView(int paramInt)
    {
      this.mWrappedTab.setCustomView(paramInt);
      return this;
    }
    
    public ActionBar.Tab setCustomView(View paramView)
    {
      this.mWrappedTab.setCustomView(paramView);
      return this;
    }
    
    public ActionBar.Tab setIcon(int paramInt)
    {
      this.mWrappedTab.setIcon(paramInt);
      return this;
    }
    
    public ActionBar.Tab setIcon(Drawable paramDrawable)
    {
      this.mWrappedTab.setIcon(paramDrawable);
      return this;
    }
    
    public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener)
    {
      this.mTabListener = paramTabListener;
      android.app.ActionBar.Tab localTab = this.mWrappedTab;
      if (paramTabListener != null) {}
      for (paramTabListener = this;; paramTabListener = null)
      {
        localTab.setTabListener(paramTabListener);
        return this;
      }
    }
    
    public ActionBar.Tab setTag(Object paramObject)
    {
      this.mTag = paramObject;
      return this;
    }
    
    public ActionBar.Tab setText(int paramInt)
    {
      this.mWrappedTab.setText(paramInt);
      return this;
    }
    
    public ActionBar.Tab setText(CharSequence paramCharSequence)
    {
      this.mWrappedTab.setText(paramCharSequence);
      return this;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/android/support/v7/app/ActionBarImplICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */