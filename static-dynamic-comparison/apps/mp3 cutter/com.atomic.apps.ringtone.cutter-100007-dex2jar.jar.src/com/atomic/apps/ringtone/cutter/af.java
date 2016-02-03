package com.atomic.apps.ringtone.cutter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;

final class af
  implements DialogInterface.OnClickListener
{
  af(SplashActivity paramSplashActivity, SharedPreferences.Editor paramEditor, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.b.putBoolean("shownever", this.c.isChecked());
    this.b.commit();
    this.a.a();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/atomic/apps/ringtone/cutter/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */