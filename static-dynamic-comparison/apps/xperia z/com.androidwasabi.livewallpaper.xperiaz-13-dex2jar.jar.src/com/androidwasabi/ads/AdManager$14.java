package com.androidwasabi.ads;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

class AdManager$14
  extends ImageLoader.OnImageLoaderListener
{
  AdManager$14(AlertDialog paramAlertDialog) {}
  
  public void onImageLoaded(Bitmap paramBitmap, Object paramObject)
  {
    if (this.val$adDialog != null) {}
    try
    {
      int i = ((Integer)paramObject).intValue();
      paramObject = (ListView)this.val$adDialog.findViewById(R.id.ad_list);
      paramObject = (ImageView)((ListView)paramObject).getChildAt(i - ((ListView)paramObject).getFirstVisiblePosition()).findViewById(R.id.ad_image);
      if (paramObject != null) {
        ((ImageView)paramObject).setImageBitmap(paramBitmap);
      }
      return;
    }
    catch (Exception paramBitmap) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */