package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

public class du
  implements DialogInterface.OnClickListener
{
  private final Activity gs;
  private final Intent mIntent;
  private final int oZ;
  
  public du(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.gs = paramActivity;
    this.mIntent = paramIntent;
    this.oZ = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (this.mIntent != null) {
        this.gs.startActivityForResult(this.mIntent, this.oZ);
      }
      paramDialogInterface.dismiss();
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */