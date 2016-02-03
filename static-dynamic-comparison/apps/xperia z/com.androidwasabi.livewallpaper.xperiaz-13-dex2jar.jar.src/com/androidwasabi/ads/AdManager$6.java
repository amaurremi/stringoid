package com.androidwasabi.ads;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.widget.ImageView;

class AdManager$6
  extends ImageLoader.OnImageLoaderListener
{
  AdManager$6(AlertDialog paramAlertDialog, String paramString) {}
  
  public void onImageLoaded(Bitmap paramBitmap, Object paramObject)
  {
    if (this.val$adDialog != null) {
      try
      {
        if (!this.val$image.equals(paramObject)) {
          return;
        }
        paramObject = (ImageView)this.val$adDialog.findViewById(R.id.ad_image);
        if (paramObject != null)
        {
          ((ImageView)paramObject).setImageBitmap(paramBitmap);
          return;
        }
      }
      catch (Exception paramBitmap) {}
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */