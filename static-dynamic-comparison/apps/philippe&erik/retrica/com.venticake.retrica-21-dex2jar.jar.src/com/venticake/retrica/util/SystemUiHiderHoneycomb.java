package com.venticake.retrica.util;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;

@TargetApi(11)
public class SystemUiHiderHoneycomb
  extends SystemUiHiderBase
{
  private int mHideFlags = 1;
  private int mShowFlags = 0;
  private View.OnSystemUiVisibilityChangeListener mSystemUiVisibilityChangeListener = new View.OnSystemUiVisibilityChangeListener()
  {
    public void onSystemUiVisibilityChange(int paramAnonymousInt)
    {
      if ((SystemUiHiderHoneycomb.this.mTestFlags & paramAnonymousInt) != 0)
      {
        if (Build.VERSION.SDK_INT < 16)
        {
          SystemUiHiderHoneycomb.this.mActivity.getActionBar().hide();
          SystemUiHiderHoneycomb.this.mActivity.getWindow().setFlags(1024, 1024);
        }
        SystemUiHiderHoneycomb.this.mOnVisibilityChangeListener.onVisibilityChange(false);
        SystemUiHiderHoneycomb.this.mVisible = false;
        return;
      }
      SystemUiHiderHoneycomb.this.mAnchorView.setSystemUiVisibility(SystemUiHiderHoneycomb.this.mShowFlags);
      if (Build.VERSION.SDK_INT < 16)
      {
        SystemUiHiderHoneycomb.this.mActivity.getActionBar().show();
        SystemUiHiderHoneycomb.this.mActivity.getWindow().setFlags(0, 1024);
      }
      SystemUiHiderHoneycomb.this.mOnVisibilityChangeListener.onVisibilityChange(true);
      SystemUiHiderHoneycomb.this.mVisible = true;
    }
  };
  private int mTestFlags = 1;
  private boolean mVisible = true;
  
  protected SystemUiHiderHoneycomb(Activity paramActivity, View paramView, int paramInt)
  {
    super(paramActivity, paramView, paramInt);
    if ((this.mFlags & 0x2) != 0)
    {
      this.mShowFlags |= 0x400;
      this.mHideFlags |= 0x404;
    }
    if ((this.mFlags & 0x6) != 0)
    {
      this.mShowFlags |= 0x200;
      this.mHideFlags |= 0x202;
      this.mTestFlags |= 0x2;
    }
  }
  
  public void hide()
  {
    this.mAnchorView.setSystemUiVisibility(this.mHideFlags);
  }
  
  public boolean isVisible()
  {
    return this.mVisible;
  }
  
  public void setup()
  {
    this.mAnchorView.setOnSystemUiVisibilityChangeListener(this.mSystemUiVisibilityChangeListener);
  }
  
  public void show()
  {
    this.mAnchorView.setSystemUiVisibility(this.mShowFlags);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/venticake/retrica/util/SystemUiHiderHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */