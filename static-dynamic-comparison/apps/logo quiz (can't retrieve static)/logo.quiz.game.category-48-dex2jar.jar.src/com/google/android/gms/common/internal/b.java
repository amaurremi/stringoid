package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class b
  implements DialogInterface.OnClickListener
{
  private final Fragment Ll;
  private final int Lm;
  private final Intent mIntent;
  private final Activity nr;
  
  public b(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    this.nr = paramActivity;
    this.Ll = null;
    this.mIntent = paramIntent;
    this.Lm = paramInt;
  }
  
  public b(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    this.nr = null;
    this.Ll = paramFragment;
    this.mIntent = paramIntent;
    this.Lm = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((this.mIntent != null) && (this.Ll != null)) {
        this.Ll.startActivityForResult(this.mIntent, this.Lm);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (this.mIntent != null) {
          this.nr.startActivityForResult(this.mIntent, this.Lm);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/common/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */