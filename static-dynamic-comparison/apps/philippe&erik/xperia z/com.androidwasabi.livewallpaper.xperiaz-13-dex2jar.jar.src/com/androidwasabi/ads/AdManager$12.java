package com.androidwasabi.ads;

import android.content.ActivityNotFoundException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AdManager$12
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    try
    {
      paramAdapterView = (String[])paramView.getTag();
      AdManager.adHandler(AdManager.access$6(), paramAdapterView[0], paramAdapterView[1]);
      return;
    }
    catch (ActivityNotFoundException paramAdapterView) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$12.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */