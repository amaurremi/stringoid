package com.androidwasabi.ads;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class AdActivity$2$1
  implements AdapterView.OnItemClickListener
{
  AdActivity$2$1(AdActivity.2 param2) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String[])paramView.getTag();
    AdManager.adHandler(AdActivity.2.access$0(this.this$1), paramAdapterView[0], paramAdapterView[1]);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdActivity$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */