package com.androidwasabi.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import java.util.ArrayList;

class AdManager$13
  implements DialogInterface.OnShowListener
{
  AdManager$13(ArrayList paramArrayList) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    int i = 0;
    for (;;)
    {
      if (i >= this.val$adWallList.size()) {
        return;
      }
      AdManager.imageLoader.loadImage(((AdManager.AdItem)this.val$adWallList.get(i)).image, Integer.valueOf(i));
      i += 1;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */