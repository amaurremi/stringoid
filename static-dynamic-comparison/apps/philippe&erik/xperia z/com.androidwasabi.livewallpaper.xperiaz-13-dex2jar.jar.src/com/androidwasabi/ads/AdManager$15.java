package com.androidwasabi.ads;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import java.util.ArrayList;

class AdManager$15
  implements View.OnClickListener
{
  AdManager$15(AlertDialog paramAlertDialog, ArrayList paramArrayList1, ArrayList paramArrayList2, ImageButton paramImageButton1, ImageButton paramImageButton2) {}
  
  public void onClick(View paramView)
  {
    if (this.val$adDialog != null)
    {
      AdManager.access$11(AdManager.access$10() + 4);
      if (AdManager.access$10() < this.val$adList.size()) {
        break label76;
      }
      AdManager.access$11(AdManager.access$10() - 4);
      this.val$nextBtn.setEnabled(true);
      this.val$prevBtn.setEnabled(true);
      if (AdManager.access$10() + 4 >= this.val$adList.size()) {
        this.val$nextBtn.setEnabled(false);
      }
    }
    return;
    label76:
    int i = AdManager.access$10() + 4;
    if (i > this.val$adList.size()) {
      i = this.val$adList.size();
    }
    for (;;)
    {
      ((ListView)this.val$adDialog.findViewById(R.id.ad_list)).setAdapter(null);
      if (this.val$adWallList != null) {
        this.val$adWallList.clear();
      }
      int j = AdManager.access$10();
      for (;;)
      {
        if (j >= i)
        {
          AdManager.access$12(this.val$adWallList, this.val$adDialog);
          break;
        }
        paramView = (AdManager.AdItem)this.val$adList.get(j);
        if (paramView != null) {
          this.val$adWallList.add(paramView);
        }
        j += 1;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/AdManager$15.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */