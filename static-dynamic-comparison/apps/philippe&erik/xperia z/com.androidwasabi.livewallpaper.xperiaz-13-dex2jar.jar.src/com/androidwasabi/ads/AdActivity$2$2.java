package com.androidwasabi.ads;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

class AdActivity$2$2
  extends ImageLoader.OnImageLoaderListener
{
  AdActivity$2$2(AdActivity.2 param2) {}
  
  public void onImageLoaded(Bitmap paramBitmap, Object paramObject)
  {
    try
    {
      int i = ((Integer)paramObject).intValue();
      paramObject = (ListView)AdActivity.2.access$0(this.this$1).findViewById(R.id.ad_list);
      paramObject = (ImageView)((ListView)paramObject).getChildAt(i - ((ListView)paramObject).getFirstVisiblePosition()).findViewById(R.id.ad_image);
      if (paramObject != null) {
        ((ImageView)paramObject).setImageBitmap(paramBitmap);
      }
      return;
    }
    catch (Exception paramBitmap) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdActivity$2$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */