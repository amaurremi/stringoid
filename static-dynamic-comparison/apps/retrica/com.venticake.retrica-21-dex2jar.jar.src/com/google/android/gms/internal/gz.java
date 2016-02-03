package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class gz
  implements DialogInterface.OnClickListener
{
  private final Fragment FV;
  private final int FW;
  private final Intent mIntent;
  private final Activity og;
  
  public gz(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.og = paramActivity;
    this.FV = null;
    this.mIntent = paramIntent;
    this.FW = paramInt;
  }
  
  public gz(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.og = null;
    this.FV = paramFragment;
    this.mIntent = paramIntent;
    this.FW = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.mIntent != null) && (this.FV != null)) {
        this.FV.startActivityForResult(this.mIntent, this.FW);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.mIntent != null) {
          this.og.startActivityForResult(this.mIntent, this.FW);
        }
      }
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */