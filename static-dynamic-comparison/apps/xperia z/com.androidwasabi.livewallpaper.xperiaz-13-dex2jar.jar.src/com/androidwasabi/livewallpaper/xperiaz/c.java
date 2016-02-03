package com.androidwasabi.livewallpaper.xperiaz;

import android.view.View;
import android.view.View.OnClickListener;
import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.NewAppManager.AppItem;

class c
  implements View.OnClickListener
{
  c(b paramb, NewAppManager.AppItem paramAppItem) {}
  
  public void onClick(View paramView)
  {
    AdManager.adHandler(b.a(this.a), this.b.url);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */