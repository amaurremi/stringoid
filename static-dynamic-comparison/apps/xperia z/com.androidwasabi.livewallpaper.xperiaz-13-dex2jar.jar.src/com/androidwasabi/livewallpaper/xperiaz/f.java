package com.androidwasabi.livewallpaper.xperiaz;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.LinearLayout;
import com.androidwasabi.ads.AdManager;
import com.androidwasabi.ads.AdManager.AdItem;
import com.androidwasabi.ads.ImageLoader.OnImageCacheListener;
import java.util.ArrayList;

class f
  extends ImageLoader.OnImageCacheListener
{
  f(AppLauncher paramAppLauncher, ArrayList paramArrayList) {}
  
  public void onImageCacheLoaded()
  {
    ((LinearLayout)this.a.findViewById(2131296263)).setVisibility(0);
    int i = (int)TypedValue.applyDimension(1, 48.0F, this.a.getResources().getDisplayMetrics());
    if (this.b.size() == 1)
    {
      localAdItem = (AdManager.AdItem)this.b.get(0);
      localButton = (Button)this.a.findViewById(2131296264);
      localButton.setVisibility(0);
      localButton.setText(localAdItem.name);
      localBitmapDrawable = new BitmapDrawable(AdManager.getAdImageFromCache(localAdItem.image));
      localBitmapDrawable.setBounds(new Rect(0, 0, i, i));
      localButton.setCompoundDrawables(null, localBitmapDrawable, null, null);
      localButton.setOnClickListener(new g(this, localAdItem));
      ((Button)this.a.findViewById(2131296265)).setVisibility(8);
      return;
    }
    AdManager.AdItem localAdItem = (AdManager.AdItem)this.b.get(0);
    Button localButton = (Button)this.a.findViewById(2131296264);
    localButton.setVisibility(0);
    localButton.setText(localAdItem.name);
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(AdManager.getAdImageFromCache(localAdItem.image));
    localBitmapDrawable.setBounds(new Rect(0, 0, i, i));
    localButton.setCompoundDrawables(null, localBitmapDrawable, null, null);
    localButton.setOnClickListener(new h(this, localAdItem));
    localAdItem = (AdManager.AdItem)this.b.get(1);
    localButton = (Button)this.a.findViewById(2131296265);
    localButton.setVisibility(0);
    localButton.setText(localAdItem.name);
    localBitmapDrawable = new BitmapDrawable(AdManager.getAdImageFromCache(localAdItem.image));
    localBitmapDrawable.setBounds(new Rect(0, 0, i, i));
    localButton.setCompoundDrawables(null, localBitmapDrawable, null, null);
    localButton.setOnClickListener(new i(this, localAdItem));
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/livewallpaper/xperiaz/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */