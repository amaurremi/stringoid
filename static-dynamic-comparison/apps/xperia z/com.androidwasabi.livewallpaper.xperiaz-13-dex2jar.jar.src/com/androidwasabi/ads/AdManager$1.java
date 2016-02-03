package com.androidwasabi.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;

class AdManager$1
  extends Popup.OnAdPopupListener
{
  AdManager$1(Activity paramActivity) {}
  
  public void onCancel()
  {
    this.val$activity.finish();
  }
  
  public void onClick()
  {
    try
    {
      this.val$activity.startActivity(new Intent(this.val$activity, AdActivity.class));
      this.val$activity.finish();
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */