package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

public class cr
  implements DialogInterface.OnClickListener
{
  private final Activity Cy;
  private final int GJ;
  private final Intent mIntent;
  
  public cr(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.Cy = paramActivity;
    this.mIntent = paramIntent;
    this.GJ = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if (this.mIntent != null) {
        this.Cy.startActivityForResult(this.mIntent, this.GJ);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */