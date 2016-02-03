package com.venticake.retrica.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;

public class SystemUiHiderBase
  extends SystemUiHider
{
  private boolean mVisible = true;
  
  protected SystemUiHiderBase(Activity paramActivity, View paramView, int paramInt)
  {
    super(paramActivity, paramView, paramInt);
  }
  
  public void hide()
  {
    if ((this.mFlags & 0x2) != 0) {
      this.mActivity.getWindow().setFlags(1024, 1024);
    }
    this.mOnVisibilityChangeListener.onVisibilityChange(false);
    this.mVisible = false;
  }
  
  public boolean isVisible()
  {
    return this.mVisible;
  }
  
  public void setup()
  {
    if ((this.mFlags & 0x1) == 0) {
      this.mActivity.getWindow().setFlags(768, 768);
    }
  }
  
  public void show()
  {
    if ((this.mFlags & 0x2) != 0) {
      this.mActivity.getWindow().setFlags(0, 1024);
    }
    this.mOnVisibilityChangeListener.onVisibilityChange(true);
    this.mVisible = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/SystemUiHiderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */