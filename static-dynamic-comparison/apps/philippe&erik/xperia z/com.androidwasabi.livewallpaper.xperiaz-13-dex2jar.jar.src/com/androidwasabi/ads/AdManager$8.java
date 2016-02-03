package com.androidwasabi.ads;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

class AdManager$8
  implements View.OnClickListener
{
  AdManager$8(AlertDialog paramAlertDialog, ArrayList paramArrayList) {}
  
  public void onClick(View paramView)
  {
    if (this.val$adDialog != null)
    {
      AdManager.access$8(AdManager.access$7() - 1);
      if (AdManager.access$7() < 0) {
        AdManager.access$8(this.val$adList.size() - 1);
      }
      AdManager.access$9((AdManager.AdItem)this.val$adList.get(AdManager.access$7()), this.val$adDialog);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */