package com.venticake.retrica.util;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;

public abstract class SystemUiHider
{
  public static final int FLAG_FULLSCREEN = 2;
  public static final int FLAG_HIDE_NAVIGATION = 6;
  public static final int FLAG_LAYOUT_IN_SCREEN_OLDER_DEVICES = 1;
  private static SystemUiHider.OnVisibilityChangeListener sDummyListener = new SystemUiHider.OnVisibilityChangeListener()
  {
    public void onVisibilityChange(boolean paramAnonymousBoolean) {}
  };
  protected Activity mActivity;
  protected View mAnchorView;
  protected int mFlags;
  protected SystemUiHider.OnVisibilityChangeListener mOnVisibilityChangeListener = sDummyListener;
  
  protected SystemUiHider(Activity paramActivity, View paramView, int paramInt)
  {
    this.mActivity = paramActivity;
    this.mAnchorView = paramView;
    this.mFlags = paramInt;
  }
  
  public static SystemUiHider getInstance(Activity paramActivity, View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      return new SystemUiHiderHoneycomb(paramActivity, paramView, paramInt);
    }
    return new SystemUiHiderBase(paramActivity, paramView, paramInt);
  }
  
  public abstract void hide();
  
  public abstract boolean isVisible();
  
  public void setOnVisibilityChangeListener(SystemUiHider.OnVisibilityChangeListener paramOnVisibilityChangeListener)
  {
    SystemUiHider.OnVisibilityChangeListener localOnVisibilityChangeListener = paramOnVisibilityChangeListener;
    if (paramOnVisibilityChangeListener == null) {
      localOnVisibilityChangeListener = sDummyListener;
    }
    this.mOnVisibilityChangeListener = localOnVisibilityChangeListener;
  }
  
  public abstract void setup();
  
  public abstract void show();
  
  public void toggle()
  {
    if (isVisible())
    {
      hide();
      return;
    }
    show();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/SystemUiHider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */