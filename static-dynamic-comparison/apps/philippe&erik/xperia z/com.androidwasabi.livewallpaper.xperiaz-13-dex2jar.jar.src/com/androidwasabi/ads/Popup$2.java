package com.androidwasabi.ads;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class Popup$2
  implements DialogInterface.OnClickListener
{
  Popup$2(Popup.OnAdPopupListener paramOnAdPopupListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$listener.onCancel();
    paramDialogInterface.cancel();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/xperia z/com.androidwasabi.livewallpaper.xperiaz-13-dex2jar.jar!/com/androidwasabi/ads/Popup$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */