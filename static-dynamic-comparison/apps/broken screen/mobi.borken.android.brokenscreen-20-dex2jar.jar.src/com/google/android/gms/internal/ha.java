package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class ha
  implements DialogInterface.OnClickListener
{
  private final Fragment FS;
  private final int FT;
  private final Intent mIntent;
  private final Activity oe;
  
  public ha(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.oe = paramActivity;
    this.FS = null;
    this.mIntent = paramIntent;
    this.FT = paramInt;
  }
  
  public ha(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.oe = null;
    this.FS = paramFragment;
    this.mIntent = paramIntent;
    this.FT = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.mIntent != null) && (this.FS != null)) {
        this.FS.startActivityForResult(this.mIntent, this.FT);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.mIntent != null) {
          this.oe.startActivityForResult(this.mIntent, this.FT);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */